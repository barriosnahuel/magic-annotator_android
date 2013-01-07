/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
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
 * DAO for the MarketItem entity.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public interface MarketItemDao {

    /**
     * Find all existing market items.
     *
     * @return All existing market items.
     *
     * @since 10
     */
    List<MarketItem> findAll();

    /**
     * Saves or updates the {@code item} based on its {@code id} attribute.
     *
     * @param item
     *         The MarketItem to save/update.
     *
     * @since 10
     */
    void saveOrUpdate(MarketItem item);

    /**
     * Delete all existing market items.
     *
     * @since 10
     */
    void deleteAll();
}
