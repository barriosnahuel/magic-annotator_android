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
    public static final String CHECKED = "checked";


    /**
     * TODO : Javadoc for getCreateScript
     *
     * @return
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
     * TODO : Javadoc for getInsertScript
     *
     * @return
     */
    public static String getInsertScript(String description, String quantity, boolean checked) {
        int checkedValue = 0;
        if (checked) {
            checkedValue = 1;
        }
        return "INSERT INTO " + TABLE_NAME +
                       " (" + DESCRIPTION + ", " + QUANTITY + ", " + CHECKED + ")" +
                       " VALUES ('" + description + "', " +
                       "'" + quantity + "', " +
                       checkedValue + ")";
    }

    /**
     * TODO : Javadoc for getUpdateScript
     *
     * @param id
     * @param quantity
     * @param checked
     *
     * @return
     */
    public static String getUpdateScript(int id, String quantity, boolean checked) {
        int checkedValue = 0;
        if (checked) {
            checkedValue = 1;
        }
        return "UPDATE " + TABLE_NAME + " SET " + QUANTITY + "= " + quantity +
                       ", " + CHECKED + "= " + checkedValue + " WHERE " + ID + "= " + id;
    }

    public static String getDropScript() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
