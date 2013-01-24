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
 * On: 02/10/12 at 14:41hs.
 */
package com.nbempire.android.magicannotator.util.android.database;

/**
 * Utility abstract type to help the developer work with the SQLite database that Android provides.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public abstract class SQLiteUtil {

    /**
     * SQLite does not have a separate Boolean storage class. Instead, Boolean values are stored as integers 0 (false) and 1 (true).
     *
     * @param value
     *         The value to evaluate.
     *
     * @return {@code false} when {@code value} is zero. Otherwise {@code true}.
     *
     * @since 10
     */
    public static boolean getBooleanValue(int value) {
        return value != 0;
    }

    /**
     * Creates a drop script for the specified {@code tableName}.
     *
     * @param tableName
     *         The name of the table to drop.
     *
     * @return SQLite script ready to execute.
     */
    public static String getDropTableScript(String tableName) {
        return "DROP TABLE IF EXISTS " + tableName + ";";
    }
}
