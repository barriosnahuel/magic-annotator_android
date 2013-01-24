/*
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

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests ArrayUtil type.
 *
 * @author Nahuel Barrios.
 */
public class ArrayUtilTest {

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.ArrayUtil#toArray(java.util.List)}.
     */
    @Test
    public void testToArray_withCharSequenceList_returnValidArray() {
        List<CharSequence> aList = new ArrayList<CharSequence>();
        aList.add("Item 1");
        aList.add("Item 2");
        aList.add("Item 3");
        aList.add("Item 4");
        aList.add("Item 5");
        aList.add("Item 6");

        CharSequence[] anArray = ArrayUtil.toArray(aList);
        Assert.assertNotNull(anArray);
        Assert.assertFalse("El length NO debería ser cero", anArray.length == 0);
        Assert.assertEquals("Item 1", anArray[0]);
        Assert.assertEquals("Item 6", anArray[5]);
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.ArrayUtil#toArray(java.util.List)}.
     */
    @Test
    public void testToArray_withStringList_returnValidArray() {
        List<String> aList = new ArrayList<String>();
        aList.add("Item 1");
        aList.add("Item 2");
        aList.add("Item 3");
        aList.add("Item 4");
        aList.add("Item 5");
        aList.add("Item 6");

        String[] anArray = ArrayUtil.toArray(aList);
        Assert.assertNotNull(anArray);
        Assert.assertFalse("El length NO debería ser cero", anArray.length == 0);
        Assert.assertEquals("Item 1", anArray[0]);
        Assert.assertEquals("Item 6", anArray[5]);
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.ArrayUtil#toArray(java.util.List)}.
     */
    @Test
    public void testToArray_withIntegerList_returnValidArray() {
        List<Integer> aList = new ArrayList<Integer>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        aList.add(5);
        aList.add(6);

        Integer[] anArray = ArrayUtil.toArray(aList);
        Assert.assertNotNull(anArray);
        Assert.assertFalse("El length NO debería ser cero", anArray.length == 0);
        Assert.assertEquals(Integer.valueOf(1), anArray[0]);
        Assert.assertEquals(Integer.valueOf(6), anArray[5]);
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.ArrayUtil#toArray(java.util.List)}.
     */
    @Test
    public void testAlgo() {
        String st = "1";
        Assert.assertEquals('1', st.charAt(0));
    }

}
