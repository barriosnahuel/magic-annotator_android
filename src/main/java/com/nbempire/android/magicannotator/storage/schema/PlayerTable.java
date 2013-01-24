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
 * On: 17/10/12 at 08:52hs.
 */
package com.nbempire.android.magicannotator.storage.schema;

import com.nbempire.android.magicannotator.util.android.database.SQLiteUtil;

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
    public static final String ID = "_id";

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
        return SQLiteUtil.getDropTableScript(TABLE_NAME);
    }
}
