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
 * On: 02/10/12 at 11:05hs.
 */
package com.nbempire.android.magicannotator.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.nbempire.android.magicannotator.storage.schema.MarketItemTable;
import com.nbempire.android.magicannotator.storage.schema.PlayerTable;

/**
 * SQLiteOpenHelper for the MagicAnnotator database. It should be used to get a database to work with.
 * <p/>
 * It also performs the create statement for creating every table for the database and the upgrade proccess to take a previous database version to a
 * newer one.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public class MagicAnnotatorDBHelper extends SQLiteOpenHelper {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "MagicAnnotatorDB";

    /**
     * Current DB version.
     */
    private static final int DB_VERSION = 2;

    /**
     * Name of the database file, or null for an in-memory database
     */
    private static final String DB_NAME = "com.nbempire.android.magicannotator";

    /**
     * Constructor method for MagicAnnotatorDBHelper type.
     *
     * @param context
     *         The context.
     */
    public MagicAnnotatorDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(LOG_TAG, "Creating DB for first time...");

        String scriptToExecute = MarketItemTable.getCreateScript();
        Log.d(LOG_TAG, "Executing script: " + scriptToExecute);
        sqLiteDatabase.execSQL(scriptToExecute);

        scriptToExecute = PlayerTable.getCreateScript();
        Log.d(LOG_TAG, "Executing script: " + scriptToExecute);
        sqLiteDatabase.execSQL(scriptToExecute);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldDBVersion, int newDBVersion) {
        Log.w(LOG_TAG, "Upgrading database from version " + oldDBVersion + " to " + newDBVersion + ", which will destroy all old data.");

        sqLiteDatabase.execSQL(MarketItemTable.getDropScript());
        sqLiteDatabase.execSQL(PlayerTable.getDropScript());
        onCreate(sqLiteDatabase);
    }


}
