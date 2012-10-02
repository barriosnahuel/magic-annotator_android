/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 16:31hs.
 */
package com.nbempire.android.magicannotator.dao;

import java.util.List;

import com.nbempire.android.magicannotator.domain.MarketItem;

/**
 * @author Nahuel Barrios.
 * @since 10
 */
public interface MarketItemDao {

    /**
     * TODO : Javadoc for findAll
     *
     * @return
     */
    List<MarketItem> findAll();

    /**
     * TODO : Javadoc for saveOrUpdate
     *
     * @param item
     */
    void saveOrUpdate(MarketItem item);
}
