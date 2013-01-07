/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 17/10/12 at 09:00hs.
 */
package com.nbempire.android.magicannotator.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.nbempire.android.magicannotator.dao.PlayerDao;
import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.storage.schema.PlayerTable;

/**
 * Implementatino of PlayerDao for the Player entity.
 *
 * @author Nahuel Barrios.
 * @since 13
 */
public class PlayerDaoImpl implements PlayerDao {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "PlayerDaoImpl";

    /**
     * Application DB.
     */
    private final SQLiteDatabase magicAnnotatorDB;

    /**
     * Constructor method for this DAO.
     *
     * @param database
     *         The database where the table is.
     *
     * @since 13
     */
    public PlayerDaoImpl(SQLiteDatabase database) {
        this.magicAnnotatorDB = database;
    }

    @Override
    public List<Player> findAll() {
        List<Player> players = new ArrayList<Player>();

        Cursor cursor = magicAnnotatorDB.query(PlayerTable.TABLE_NAME, null, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            Player player = new Player(cursor.getString(cursor.getColumnIndex(PlayerTable.NICKNAME)));
            player.setId(cursor.getInt(cursor.getColumnIndex(PlayerTable.ID)));

            Log.i(LOG_TAG, "Getting " + player.getNickName() + "\twith ID: " + player.getId() + "\tfrom DB.");
            players.add(player);
        }

        //  TODO : Refactor : Should I close this Cursor object? Check startManagingCursor(cursor) method.

        return players;
    }

    @Override
    public void save(Player player) {
        ContentValues columnsAndValues = new ContentValues();

        columnsAndValues.put(PlayerTable.NICKNAME, player.getNickName());
        long createdId = magicAnnotatorDB.insert(PlayerTable.TABLE_NAME, "null", columnsAndValues);

        if (createdId == -1) {
            Log.e(LOG_TAG, "There was an error trying to save the Player: " + player.getNickName());
        } else {
            Log.i(LOG_TAG, "Created Player with ID: " + createdId);
        }

    }

    @Override
    public void deleteAll() {
        String tableName = PlayerTable.TABLE_NAME;
        int deletedRows = magicAnnotatorDB.delete(tableName, "1", null);
        Log.i(LOG_TAG, "Deleted " + deletedRows + " rows from table " + tableName + " in DB.");
    }
}
