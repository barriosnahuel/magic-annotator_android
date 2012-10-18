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
 * TODO : Javadoc for AnalyticsUtil
 *
 * @author Nahuel Barrios.
 * @since 14
 */
public abstract class AnalyticsUtil {

    /**
     * TODO : Javadoc for generatePageName
     *
     * @param activityName
     *
     * @return
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
