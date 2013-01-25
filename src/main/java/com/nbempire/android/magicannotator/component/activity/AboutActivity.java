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

/**
 * AboutActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:38:58.
 */
package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;

/**
 * Activity to prepare the about section. It only loads the layout.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class AboutActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String TAG = "AboutActivity";

    /**
     * Google Analytics tracker used to track page views and events.
     */
    private GoogleAnalyticsTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tracker = GoogleAnalyticsTracker.getInstance();
        tracker.trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));

        setContentView(R.layout.about);

        addOnTouchActionsForProjectURL();
    }

    /**
     * Add onTouch actions for the TextView that shows the project URL. When user taps on the link, system will show the project site on the browser.
     *
     * @since 14
     */
    private void addOnTouchActionsForProjectURL() {
        findViewById(R.id.about_projectUrl).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String projectURL = getText(R.string.about_projectUrl_complete).toString();

                Log.i(TAG, "Opening browser to show the project URL: " + projectURL);
                tracker.trackPageView(projectURL);

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(projectURL)));
                return true;
            }
        });
    }

    /**
     * Display the license information to the user.
     *
     * @param callerView
     *         The view that called this method.
     */
    public void showLicense(View callerView) {
        Log.i(TAG, "Showing license information.");

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.about_license);

        ScrollView scrollView = new ScrollView(this);
        int padding = 10;
        int topPadding = 5;
        scrollView.setPadding(padding, topPadding, padding, padding);

        TextView aView = new TextView(scrollView.getContext());
        aView.setTextColor(Color.WHITE);
        aView.setText(R.string.app_license);
        scrollView.addView(aView);

        dialogBuilder.setView(scrollView);

        tracker.trackPageView("/License");
        dialogBuilder.show();
    }

}