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

package com.nbempire.android.magicannotator.util;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Abstract class tu use as an utility class containing helper methods to work with Arrays
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class ArrayUtil {

    /**
     * Returns an array of aList items in the same order than the {@link List}.
     *
     * @param aList
     *         {@link List} to transform.
     *
     * @return {@link T[]} array of aList items in the same order than the {@link List}.
     *
     * @since 1
     */
    public static <T> T[] toArray(List<T> aList) {
        T[] result = (T[]) Array.newInstance(aList.get(0).getClass(), 2);
        result = aList.toArray(result);
        return result;
    }

}
