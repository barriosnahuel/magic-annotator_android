/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 02/10/12 at 16:29hs.
 */
package com.nbempire.android.magicannotator.service;

import java.util.List;

import com.nbempire.android.magicannotator.domain.MarketItem;

/**
 * Service for the MarketItem entity.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public interface MarketItemService {

    /**
     * Find all existing market items.
     *
     * @return All existing market items.
     */
    List<MarketItem> findAll();

    /**
     * Saves or updates the {@code item} based on its {@code id} attribute.
     *
     * @param item
     *         The MarketItem to save/update.
     */
    void saveOrUpdate(MarketItem item);
}
