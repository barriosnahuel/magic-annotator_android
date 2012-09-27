/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 14:23hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

/**
 * TODO : Javadoc for ViewsUtil
 *
 * @author Nahuel Barrios.
 * @since 0.1
 */
public class ViewsUtil {

    /**
     * Returns the absolute value of the hashCode() method.
     *
     * @param anObject
     *         {@link Object} an object to get some unique property to use as an Id.
     *
     * @return Positive {@link Integer} to use as an Id for an Android {@link android.view.View}.
     */
    public static int generateViewId(Object anObject) {
        return Math.abs(anObject.hashCode());
    }

}
