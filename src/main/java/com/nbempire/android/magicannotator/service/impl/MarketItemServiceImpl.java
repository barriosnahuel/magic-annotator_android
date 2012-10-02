/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 16:30hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import com.nbempire.android.magicannotator.dao.MarketItemDao;
import com.nbempire.android.magicannotator.dao.impl.MarketItemDaoImpl;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.service.MarketItemService;

/**
 * @author Nahuel Barrios.
 * @since 10
 */
public class MarketItemServiceImpl implements MarketItemService {

    private MarketItemDao marketItemDao;

    public MarketItemServiceImpl(SQLiteDatabase database) {
        this.marketItemDao = new MarketItemDaoImpl(database);
    }

    @Override
    public List<MarketItem> findAll() {
        return marketItemDao.findAll();
    }

    @Override
    public void saveOrUpdate(MarketItem item) {
        marketItemDao.saveOrUpdate(item);
    }
}
