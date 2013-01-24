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
