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
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;

/**
 * TODO : Javadoc for AppRater
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

    private final static String APP_PACKAGE_NAME = "com.nbempire.android.magicannotator";

    private static final String DONT_SHOW_DIALOG_AGAIN = "dontShowDialogAgain";

    private static Dialog dialog;

    private static SharedPreferences.Editor preferencesEditor;

    /**
     * TODO : Javadoc for showRateDialogWhenCorresponding
     *
     * @param context
     */
    public static void showRateDialogWhenCorresponding(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AppRater", Context.MODE_PRIVATE);

        boolean showDialog = !sharedPreferences.getBoolean(DONT_SHOW_DIALOG_AGAIN, false);
        if (showDialog) {
            preferencesEditor = sharedPreferences.edit();

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
     * TODO : Javadoc for showRateDialog
     * <p/>
     * This method can be called from any Activity with {@code (this, null)} parameters to display dialog at any time.
     *
     * @param context
     * @param preferencesEditor
     */
    private static void showRateDialog(final Context context, final SharedPreferences.Editor preferencesEditor) {
        dialog = new Dialog(context);

        CharSequence rateApp = context.getText(R.string.rate);
        dialog.setTitle(rateApp);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView pleaseRateAppTextView = new TextView(context);
        pleaseRateAppTextView.setText(context.getText(R.string.pleaseRateApp));
        pleaseRateAppTextView.setWidth(240);
        pleaseRateAppTextView.setPadding(4, 0, 4, 10);
        linearLayout.addView(pleaseRateAppTextView);

        Button rateButton = new Button(context);
        rateButton.setText(rateApp);
        rateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PACKAGE_NAME));
                try {
                    context.startActivity(anIntent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Log.e(TAG, "Can't open Play Store because it's not present on running device.");
                }

                dialog.dismiss();
            }
        });
        linearLayout.addView(rateButton);

        Button remindMeLaterButton = new Button(context);
        remindMeLaterButton.setText(context.getText(R.string.remindMeLater));
        remindMeLaterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        linearLayout.addView(remindMeLaterButton);

        Button noThanksButton = new Button(context);
        noThanksButton.setText(context.getText(R.string.noThanks));
        noThanksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (preferencesEditor != null) {
                    preferencesEditor.putBoolean(DONT_SHOW_DIALOG_AGAIN, true);
                    preferencesEditor.commit();
                }
                dialog.dismiss();
            }
        });
        linearLayout.addView(noThanksButton);

        dialog.setContentView(linearLayout);
        dialog.show();
    }
}

