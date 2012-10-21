/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 18/10/12 at 15:21hs.
 */
package com.nbempire.android.magicannotator.util.android.analytics;

/**
 * Utility type containing statics methods to help developer when working with Google Analytics.
 *
 * @author Nahuel Barrios.
 * @since 14
 */
public abstract class GoogleAnalyticsUtil {

    /**
     * Generates the page name for the specified {@code activityName} by adding the preffix "/".
     *
     * @param activityName
     *         The name of the activity to track its page view.
     *
     * @return String with the activity name ready to track the page view.
     *
     * @since 14
     */
    public static String generatePageName(String activityName) {
        if (activityName == null) {
            throw new IllegalArgumentException("The activityName musn't be null.");
        }
        return "/" + activityName;
    }
}
