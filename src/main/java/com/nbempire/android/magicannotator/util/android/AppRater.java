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
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * TODO : Javadoc for
 * <p/>
 * Created on 4/9/13, at 8:47 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 25.
 */
public class AppRater {

    private final static String APP_NAME = "Magic Annotator";

    private final static String APP_PACKAGE_NAME = "com.nbempire.android.magicannotator";

    private final static int DAYS_UNTIL_PROMPT = 3;

    private final static int LAUNCHES_UNTIL_PROMPT = 7;

    /**
     * @param mContext
     */
    public static void showRateDialogWhenCorrsponding(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("AppRater", 0);
        if (prefs.getBoolean("dontShowAgain", false)) {
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long appRunCounter = prefs.getLong("appRunCounter", 0) + 1;
        editor.putLong("appRunCounter", appRunCounter);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("firstRunDate", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("firstRunDate", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (appRunCounter >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch + (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }

        editor.commit();
    }

    /**
     * TODO : Javadoc for showRateDialog
     *
     * @param mContext
     * @param editor
     */
    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle("Rate " + APP_NAME);

        LinearLayout linearLayout = new LinearLayout(mContext);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(mContext);
        textView.setText("If you enjoy using " + APP_NAME + ", please take a moment to rate it. Thanks for your support!");
        textView.setWidth(240);
        textView.setPadding(4, 0, 4, 10);
        linearLayout.addView(textView);

        Button button1 = new Button(mContext);
        button1.setText("Rate " + APP_NAME);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent anIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PACKAGE_NAME));
                mContext.startActivity(anIntent);
                dialog.dismiss();
            }
        });
        linearLayout.addView(button1);

        Button button2 = new Button(mContext);
        button2.setText("Remind me later");
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        linearLayout.addView(button2);

        Button button3 = new Button(mContext);
        button3.setText("No, thanks");
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontShowAgain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        linearLayout.addView(button3);

        dialog.setContentView(linearLayout);
        dialog.show();
    }
}

