/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nbempire.android.magicannotator.util.android;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;

/**
 * Utility type that displays a dialog to let user rate the application.
 * <p/>
 * It saves user preferences as {@link SharedPreferences} to handle when the dialog has to be opened or not.
 * <p/>
 * It also tracks events to Google Analytics about which is the user choice.
 * <p/>
 * Created on 4/9/13, at 8:47 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 25.
 */
public class AppRater {

    /**
     * Tag for class' log.
     */
    private static final String TAG = "AppRater";

    /**
     * Page name for Google Analytics for this type.
     */
    private static final String GOOGLE_ANALYTICS_PAGE_NAME = GoogleAnalyticsUtil.generatePageName(TAG);

    /**
     * Key flag to use with the SharedPreferences.
     */
    private static final String DONT_SHOW_DIALOG_AGAIN = "dontShowDialogAgain";

    private static Dialog s_dialog;

    /**
     * Key to use when tracking an event to Google Analytics. It must be used to track which button users selects when the dialog is displayed.
     */
    private static final String GOOGLE_ANALYTICS_EVENT_KEY = "Selected action on rateApp dialog";

    /**
     * Display an AlertDialog letting user choose between navigate to Android PlayStore to rate the app, remind him later, or disable prompt for
     * ever.
     *
     * @param context
     *         Activity's context.
     */
    public static void showRateDialogWhenCorresponding(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AppRater", Context.MODE_PRIVATE);

        boolean showDialog = !sharedPreferences.getBoolean(DONT_SHOW_DIALOG_AGAIN, false);
        if (showDialog) {
            SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();

            // Increment launch counter
            final String preferenceKeyAppRunCounter = "appRunCounter";
            long appRunCounter = sharedPreferences.getLong(preferenceKeyAppRunCounter, 0) + 1;
            preferencesEditor.putLong(preferenceKeyAppRunCounter, appRunCounter);

            // Get date of app first launch
            final String preferenceKeyFirstRunDate = "appRunCounter";
            long firstLaunchDate = sharedPreferences.getLong(preferenceKeyFirstRunDate, 0);
            long now = System.currentTimeMillis();
            if (firstLaunchDate == 0) {
                firstLaunchDate = now;
                preferencesEditor.putLong(preferenceKeyFirstRunDate, firstLaunchDate);
            }

            // Wait at least LAUNCHES_UNTIL_FIRST_PROMPT_FOR_RATE_APP days before showing dialog.
            if (appRunCounter >= AppParameter.LAUNCHES_UNTIL_FIRST_PROMPT_FOR_RATE_APP) {
                if (now >= firstLaunchDate + (AppParameter.DAYS_UNTIL_NEXT_PROMPT * 86400000)) {    //1000 * 60 * 60 * 24
                    showRateDialog(context, preferencesEditor);
                }
            }

            preferencesEditor.commit();
        }
    }

    /**
     * Create and display the dialog.
     * <p/>
     * This method can be called from any Activity with {@code (this, null)} parameters to display dialog at any time.
     *
     * @param context
     *         Activity's context.
     */
    private static void showRateDialog(final Context context, SharedPreferences.Editor preferencesEditor) {
        CharSequence rateAppDialogTitle = context.getText(R.string.rate);

        TextView pleaseRateAppTextView = new TextView(context);
        pleaseRateAppTextView.setText(context.getText(R.string.pleaseRateApp));
        pleaseRateAppTextView.setTextAppearance(context, R.style.alertDialogColor);
        int padding = 10;
        int topPadding = 5;
        pleaseRateAppTextView.setPadding(padding, topPadding, padding, padding);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(pleaseRateAppTextView);
        linearLayout.addView(createRateAppButton(context, rateAppDialogTitle, preferencesEditor));
        linearLayout.addView(createRemindMeLaterButton(context));
        linearLayout.addView(createNoThanksButton(context, preferencesEditor));

        s_dialog = new Dialog(context);
        s_dialog.setTitle(rateAppDialogTitle);
        s_dialog.setContentView(linearLayout);
        s_dialog.show();
    }

    /**
     * Create button which will open Android PlayStore to let user rate the application.
     *
     * @param context
     *         Activity's context.
     * @param rateApp
     *         Button's label.
     */
    private static Button createRateAppButton(final Context context, CharSequence rateApp, final SharedPreferences.Editor preferencesEditor) {
        Button rateAppButton = new Button(context);
        rateAppButton.setText(rateApp);
        rateAppButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View callerView) {
                Log.i(TAG, "Starting Play Store to rate app.");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getApplicationContext().getPackageName()));

                disableRateAppDialog(preferencesEditor);
                GoogleAnalyticsTracker.getInstance().trackEvent(GOOGLE_ANALYTICS_PAGE_NAME, GOOGLE_ANALYTICS_EVENT_KEY, "Rate app", 0);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Log.e(TAG, "Can't open Play Store because it's not present on running device.");
                }

                s_dialog.dismiss();
            }
        });

        return rateAppButton;
    }

    /**
     * Create a button that does nothing to remind the user later.
     *
     * @param context
     *         Activity's context.
     */
    private static Button createRemindMeLaterButton(Context context) {
        Button remindMeLaterButton = new Button(context);
        remindMeLaterButton.setText(context.getText(R.string.remindMeLater));
        remindMeLaterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View callerView) {
                Log.i(TAG, "User wants to let app remind him later about rating the application.");
                GoogleAnalyticsTracker.getInstance().trackEvent(GOOGLE_ANALYTICS_PAGE_NAME, GOOGLE_ANALYTICS_EVENT_KEY, "Remind later", 0);
                s_dialog.dismiss();
            }
        });

        return remindMeLaterButton;
    }

    /**
     * Create a button to disable this dialog for ever.
     *
     * @param context
     *         Activity's context.
     */
    private static Button createNoThanksButton(Context context, final SharedPreferences.Editor preferencesEditor) {
        Button noThanksButton = new Button(context);
        noThanksButton.setText(context.getText(R.string.noThanks));
        noThanksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View callerView) {
                Log.i(TAG, "User don't want to receive prompts to rate the application again.");
                disableRateAppDialog(preferencesEditor);
                GoogleAnalyticsTracker.getInstance().trackEvent(GOOGLE_ANALYTICS_PAGE_NAME, GOOGLE_ANALYTICS_EVENT_KEY, "Don't show again", 0);
                s_dialog.dismiss();
            }
        });

        return noThanksButton;
    }


    /**
     * Sets a flag to disable this dialog for ever.
     *
     * @param preferencesEditor
     *         The SharedPreferences Editor used to store user preferences.
     */
    private static void disableRateAppDialog(SharedPreferences.Editor preferencesEditor) {
        if (preferencesEditor != null) {
            preferencesEditor.putBoolean(DONT_SHOW_DIALOG_AGAIN, true);
            preferencesEditor.commit();
            Log.i(TAG, "AppRater dialog was disabled.");
        }
    }

}

