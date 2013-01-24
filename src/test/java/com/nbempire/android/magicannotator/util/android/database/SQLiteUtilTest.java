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
 * On: 18/10/12 at 16:14hs.
 */
package com.nbempire.android.magicannotator.util.android.database;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests SQLiteUtil type.
 *
 * @author Nahuel Barrios.
 * @since 14
 */
public class SQLiteUtilTest {

    private static final String RETURNED_VALUE_SHOULD_BE = "Returned value should be ";

    /**
     * Test method for getBooleanValue.
     *
     * @since 14
     */
    @Test
    public void getBooleanValue_with1_returnTrue() throws Exception {
        Assert.assertTrue(RETURNED_VALUE_SHOULD_BE + "true.", SQLiteUtil.getBooleanValue(1));
    }

    /**
     * Test method for getBooleanValue.
     *
     * @since 14
     */
    @Test
    public void getBooleanValue_withNegative1_returnTrue() throws Exception {
        Assert.assertTrue(RETURNED_VALUE_SHOULD_BE + "true.", SQLiteUtil.getBooleanValue(-1));
    }

    /**
     * Test method for getBooleanValue.
     *
     * @since 14
     */
    @Test
    public void getBooleanValue_with0_returnFalse() throws Exception {
        Assert.assertFalse(RETURNED_VALUE_SHOULD_BE + "false.", SQLiteUtil.getBooleanValue(0));
    }

    @Test
    public void getDropScript_withValidTableName_returnDropScript() {
        String tableName = "aTableName";
        String dropTableScript = SQLiteUtil.getDropTableScript(tableName);
        Assert.assertNotNull("Drop script musn't be null.", dropTableScript);
        Assert.assertEquals("DROP TABLE IF EXISTS " + tableName + ";", dropTableScript);
    }

}
