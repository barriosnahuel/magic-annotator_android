/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 16:31hs.
 */
package com.nbempire.android.magicannotator.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.nbempire.android.magicannotator.dao.MarketItemDao;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.storage.schema.MarketItemTable;
import com.nbempire.android.magicannotator.util.android.db.SQLiteUtil;

/**
 * @author Nahuel Barrios.
 * @since 10
 */
public class MarketItemDaoImpl implements MarketItemDao {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "MarketItemDaoImpl";

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
     * @since 10
     */
    public MarketItemDaoImpl(SQLiteDatabase database) {
        this.magicAnnotatorDB = database;
    }

    @Override
    public List<MarketItem> findAll() {
        List<MarketItem> items = new ArrayList<MarketItem>();

        Cursor cursor = magicAnnotatorDB.query(MarketItemTable.TABLE_NAME, null, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            MarketItem item = new MarketItem(cursor.getString(cursor.getColumnIndex(MarketItemTable.DESCRIPTION)));

            item.setQuantity(cursor.getString(cursor.getColumnIndex(MarketItemTable.QUANTITY)));
            item.setId(cursor.getInt(cursor.getColumnIndex(MarketItemTable.ID)));
            item.setChecked(SQLiteUtil.getBooleanValue(cursor.getInt(cursor.getColumnIndex(MarketItemTable.CHECKED))));

            Log.i(LOG_TAG, "Getting " + item.getDescription() + "\twith ID: " + item.getId() + "\tfrom DB.");
            items.add(item);
        }

        //  TODO : Refactor : Should I close this Cursor object? Check startManagingCursor(cursor) method.

        return items;
    }

    @Override
    public void saveOrUpdate(MarketItem item) {
        ContentValues columnsAndValues = new ContentValues();
        columnsAndValues.put(MarketItemTable.QUANTITY, item.getQuantity());
        columnsAndValues.put(MarketItemTable.CHECKED, item.isChecked());

        if (item.getId() == 0) {
            columnsAndValues.put(MarketItemTable.DESCRIPTION, item.getDescription());
            long createdId = magicAnnotatorDB.insert(MarketItemTable.TABLE_NAME, "null", columnsAndValues);

            if (createdId == -1) {
                Log.e(LOG_TAG, "There was an error trying to save the MarketItem: " + item.getDescription());
            } else {
                Log.i(LOG_TAG, "Created MarketItem with ID: " + createdId);
            }

        } else {
            int numberOfAffectedRows = magicAnnotatorDB.update(MarketItemTable.TABLE_NAME, columnsAndValues,
                                                                      MarketItemTable.ID + "=?", new String[]{String.valueOf(item.getId())});

            Log.i(LOG_TAG, "Updated " + numberOfAffectedRows + " MarketItem with ID: " + item.getId());
        }
    }

    @Override
    public void deleteAll() {
        int deletedRows = magicAnnotatorDB.delete(MarketItemTable.TABLE_NAME, "1", null);
        Log.i(LOG_TAG, "Deleted " + deletedRows + " rows.");
    }
}
