/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 14:23hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

import android.util.Log;

/**
 * Abstract utility class to help developer work with Views.
 *
 * @author Nahuel Barrios.
 * @since 8
 */
public abstract class ViewsUtil {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "ViewsUtil";

    /**
     * Returns the absolute value of the hashCode() method.
     *
     * @param anObject
     *         {@link Object} an object to get some unique property to use as an Id.
     *
     * @return Positive {@link Integer} to use as an Id for an Android {@link android.view.View}.
     *
     * @since 1
     */
    public static int generateViewId(Object anObject) {
        Log.d(LOG_TAG, "Generating viewId for: " + anObject.toString());
        return Math.abs(anObject.hashCode());
    }

}
