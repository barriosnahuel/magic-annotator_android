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

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.nbempire.android.magicannotator.content.MarketItemTable;
import com.nbempire.android.magicannotator.dao.MarketItemDao;
import com.nbempire.android.magicannotator.domain.MarketItem;
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
    private SQLiteDatabase magicAnnotatorDB;

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

            //fetching from database and adding to arrayList
            MarketItem item = new MarketItem(cursor.getString(cursor.getColumnIndex(MarketItemTable.DESCRIPTION)));
            item.setQuantity(cursor.getString(cursor.getColumnIndex(MarketItemTable.QUANTITY)));
            item.setId(cursor.getInt(cursor.getColumnIndex(MarketItemTable.ID)));
            item.setChecked(SQLiteUtil.getBooleanValue(cursor.getInt(cursor.getColumnIndex(MarketItemTable.CHECKED))));

            Log.d(LOG_TAG, "Getting " + item.getDescription() + "\twith ID: " + item.getId() + "\tfrom DB.");
            items.add(item);
        }

        return items;
    }

    @Override
    public void saveOrUpdate(MarketItem item) {
        String scriptToExecute;
        if (item.getId() == 0) {
            scriptToExecute = MarketItemTable.getInsertScript(item.getDescription(), item.getQuantity(), item.isChecked());
        } else {
            scriptToExecute = MarketItemTable.getUpdateScript(item.getId(), item.getQuantity(), item.isChecked());
        }
        Log.d(LOG_TAG, "Executing SQL script: " + scriptToExecute);
        magicAnnotatorDB.execSQL(scriptToExecute);
    }
}
