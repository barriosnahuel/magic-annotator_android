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
 * On: 02/10/12 at 16:30hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import android.database.sqlite.SQLiteDatabase;
import com.nbempire.android.magicannotator.dao.MarketItemDao;
import com.nbempire.android.magicannotator.dao.impl.MarketItemDaoImpl;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.service.MarketItemService;

import java.util.List;

/**
 * Implementation of MarketItemService for the MarketItem entity.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public class MarketItemServiceImpl implements MarketItemService {

    /**
     * DAO for the MarketItem entity.
     */
    private final MarketItemDao marketItemDao;

    /**
     * Constructor method for this MarketItemServiceImpl type.
     *
     * @param database
     *         The {@link SQLiteDatabase} to access.
     */
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

    @Override
    public void deleteAll() {
        marketItemDao.deleteAll();
    }
}
