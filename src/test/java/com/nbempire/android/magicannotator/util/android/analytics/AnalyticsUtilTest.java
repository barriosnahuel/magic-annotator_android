/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 18/10/12 at 15:23hs.
 */
package com.nbempire.android.magicannotator.util.android.analytics;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Nahuel Barrios.
 * @since 14
 */
public class AnalyticsUtilTest {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "AnalyticsUtilTest";

    /**
     * Test method for generatePageName.
     *
     * @since 14
     */
    @Test
    public void generatePageName_withValidActivityName_returnValidPageName() throws Exception {
        String pageName = AnalyticsUtil.generatePageName(LOG_TAG);

        Assert.assertNotNull("Returned value shouldn't be null.", pageName);
        Assert.assertEquals("/" + LOG_TAG, pageName);
    }

    /**
     * Test method for generatePageName.
     *
     * @since 14
     */
    @Test(expected = IllegalArgumentException.class)
    public void generatePageName_withNullActivityName_throwIllegalArgumentException() throws Exception {
        AnalyticsUtil.generatePageName(null);
        Assert.fail("Should throw an exception.");
    }

}
