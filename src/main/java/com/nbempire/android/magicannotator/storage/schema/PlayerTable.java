/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 17/10/12 at 08:52hs.
 */
package com.nbempire.android.magicannotator.storage.schema;

/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * @author Nahuel Barrios.
 * @since 13
 */
public abstract class PlayerTable {

    /**
     * The name of the table.
     */
    public static final String TABLE_NAME = "players";

    //  Here goes the table columns...

    /**
     * Auto-incremental column that starts at 1 by default.
     */
    public static final String ID = "id";

    public static final String NICKNAME = "nickName";

    /**
     * Script for create the table.
     *
     * @return SQL Script to create the MarketItem table.
     *
     * @since 13
     */
    public static String getCreateScript() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                       + ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                       ", " + NICKNAME + " varchar" +
                       ");";
    }

    /**
     * Creates a SQL script to drop this table.
     *
     * @return SQL script to drop the MarketItem table.
     *
     * @since 13
     */
    public static String getDropScript() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }
}
