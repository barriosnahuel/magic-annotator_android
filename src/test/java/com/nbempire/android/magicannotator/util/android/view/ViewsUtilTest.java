/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 18/10/12 at 16:19hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests ViewsUtil type.
 *
 * @author Nahuel Barrios.
 * @since 14
 */
public class ViewsUtilTest {

    /**
     * Test method for generateViewId.
     *
     * @since 14
     */
    @Test
    public void generateViewId_withValidString_returnViewId() throws Exception {
        String anObject = "A name!";

        Assert.assertEquals(Math.abs(anObject.hashCode()), ViewsUtil.generateViewId(anObject));
    }

    /**
     * Test method for generateViewId.
     *
     * @since 14
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void generateViewId_withNull_throwIllegalArgumentException() throws Exception {
        String anObject = null;

        ViewsUtil.generateViewId(anObject);
        Assert.fail("Must throw an IllegalArgumentException.");
    }
}
