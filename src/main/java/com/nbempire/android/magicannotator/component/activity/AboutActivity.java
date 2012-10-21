/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AboutActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:38:58.
 */
package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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
    private static final String LOG_TAG = "AboutActivity";

    /**
     * Google Analytics tracker used to track page views and events.
     */
    private GoogleAnalyticsTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tracker = GoogleAnalyticsTracker.getInstance();
        tracker.trackPageView(GoogleAnalyticsUtil.generatePageName(LOG_TAG));

        setContentView(R.layout.about);

        addOnTouchActionsForProjectURL();
    }

    /**
     * Add onTouch actions for the TextView that shows the project URL. When user taps on the link, system will show the project site on the
     * browser.
     *
     * @since 14
     */
    private void addOnTouchActionsForProjectURL() {
        findViewById(R.id.about_projectUrl).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String projectURL = getText(R.string.about_projectUrl_complete).toString();

                Log.i(LOG_TAG, "Opening browser to show the project URL: " + projectURL);
                tracker.trackPageView(projectURL);

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(projectURL)));
                return true;
            }
        });
    }

}
