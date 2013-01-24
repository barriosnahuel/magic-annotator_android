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
 * On: 17/10/12 at 08:57hs.
 */
package com.nbempire.android.magicannotator.dao;

import com.nbempire.android.magicannotator.domain.Player;

import java.util.List;

/**
 * DAO for the Player entity.
 *
 * @author Nahuel Barrios.
 * @since 13
 */
public interface PlayerDao {

    /**
     * Find all existing players.
     *
     * @return All existing players.
     *
     * @since 13
     */
    List<Player> findAll();

    /**
     * Saves the {@code player}.
     *
     * @param player
     *         The Player to save.
     *
     * @since 13
     */
    void save(Player player);

    /**
     * Delete all existing players.
     *
     * @since 13
     */
    void deleteAll();
}
