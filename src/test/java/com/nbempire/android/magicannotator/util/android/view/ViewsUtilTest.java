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
