/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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
