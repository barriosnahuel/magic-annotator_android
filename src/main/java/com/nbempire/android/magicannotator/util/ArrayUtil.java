/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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
