/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AboutActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:38:58.
 */
package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.analytics.AnalyticsUtil;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleAnalyticsTracker.getInstance().trackPageView(AnalyticsUtil.generatePageName(LOG_TAG));
        setContentView(R.layout.about);
    }

}
