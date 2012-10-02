/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 11:05hs.
 */
package com.nbempire.android.magicannotator.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * TODO : Javadoc for MagicAnnotatorDB
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public class MagicAnnotatorDB extends SQLiteOpenHelper {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "MagicAnnotatorDB";

    /**
     * Current DB version.
     */
    private static final int DB_VERSION = 1;

    /**
     * Name of the database file, or null for an in-memory database
     */
    public static final String DB_NAME = "com.nbempire.android.magicannotator";

    /**
     * Constructor method for MagicAnnotatorDB type.
     *
     * @param context
     *         The context.
     */
    public MagicAnnotatorDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MarketItemTable.getCreateScript());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldDBVersion, int newDBVersion) {
        Log.w(LOG_TAG, "Upgrading database from version " + oldDBVersion + " to " + newDBVersion + ", which will destroy all old data.");

        sqLiteDatabase.execSQL(MarketItemTable.getDropScript());
        onCreate(sqLiteDatabase);
    }


}
