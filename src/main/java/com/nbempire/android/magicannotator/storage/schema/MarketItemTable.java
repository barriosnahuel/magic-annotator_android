/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 11:10hs.
 */
package com.nbempire.android.magicannotator.storage.schema;

import com.nbempire.android.magicannotator.util.android.database.SQLiteUtil;

/**
 * @author Nahuel Barrios.
 * @since 10
 */
public abstract class MarketItemTable {

    /**
     * The name of the table.
     */
    public static final String TABLE_NAME = "marketItems";

    //  Here goes the table columns...

    /**
     * Auto-incremental column that starts at 1 by default.
     */
    public static final String ID = "id";

    public static final String DESCRIPTION = "description";
    public static final String QUANTITY = "quantity";
    public static final String CHECKED = "checked";

    /**
     * Script for create the table.
     *
     * @return SQL Script to create the MarketItem table.
     *
     * @since 10
     */
    public static String getCreateScript() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                       + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                       ", " + DESCRIPTION + " varchar" +
                       ", " + QUANTITY + " INT(3)" +
                       ", " + CHECKED + " INTEGER" +
                       ");";
    }

    /**
     * Creates a SQL script to drop this table.
     *
     * @return SQL script to drop the MarketItem table.
     *
     * @since 10
     */
    public static String getDropScript() {
        return SQLiteUtil.getDropTableScript(TABLE_NAME);
    }
}
