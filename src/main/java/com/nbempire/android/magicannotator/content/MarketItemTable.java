/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 11:10hs.
 */
package com.nbempire.android.magicannotator.content;

/**
 * @author Nahuel Barrios.
 * @since 10
 */
public abstract class MarketItemTable {

    public static final String DESCRIPTION = "description";
    public static final String QUANTITY = "quantity";

    /**
     * Auto-incremental column that starts at 1 by default.
     */
    public static final String ID = "id";

    public static final String TABLE_NAME = "marketItems";


    /**
     * TODO : Javadoc for getCreateScript
     *
     * @return
     */
    public static String getCreateScript() {
        return "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                       + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                       + DESCRIPTION + " varchar, "
                       + QUANTITY + " INT(3)" +
                       ");";
    }

    /**
     * TODO : Javadoc for getInsertScript
     *
     * @return
     */
    public static String getInsertScript(String description, String quantity) {
        return "INSERT INTO " + TABLE_NAME + " (" + DESCRIPTION + ", " + QUANTITY + ") VALUES ('" + description + "', '" + quantity + "')";
    }

    /**
     * TODO : Javadoc for getUpdateScript
     *
     * @param id
     * @param quantity
     *
     * @return
     */
    public static String getUpdateScript(int id, String quantity) {
        return "UPDATE " + TABLE_NAME + " SET " + QUANTITY + "= " + quantity + " WHERE " + ID + "= " + id;
    }

    public static String getDeleteScript() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
