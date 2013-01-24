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
 * On: 02/10/12 at 16:29hs.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.MarketItem;

import java.util.List;

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
