/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import org.junit.Test;

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
