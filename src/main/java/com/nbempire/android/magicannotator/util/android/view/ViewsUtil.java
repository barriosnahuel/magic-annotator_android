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
 * On: 27/09/12 at 14:23hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

/**
 * Abstract utility class to help developer work with Views.
 *
 * @author Nahuel Barrios.
 * @since 8
 */
public abstract class ViewsUtil {

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
    public static int generateId(Object anObject) {
        if (anObject == null) {
            throw new IllegalArgumentException("parameter musn't be null to generate an id.");
        }
        return Math.abs(anObject.hashCode());
    }

}
