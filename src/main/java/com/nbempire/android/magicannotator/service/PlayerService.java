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
 * PlayerService.java Created by: Nahuel Barrios: 23/03/2012, 05:41:33.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.Player;

import java.util.List;

/**
 * Service type for the {@link Player} entity.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public interface PlayerService {

    /**
     * Creates a List of Players based on {@code playersToParse} parameter.
     *
     * @param playersToParse
     *         List containing the player's name.
     *
     * @return List of Players based on {@code playersToParse} parameter.
     *
     * @since 1
     */
    public List<Player> createPlayers(List<String> playersToParse);

    /**
     * Creates a List of Strings based on {@code players} parameter. It will use the player's nickname attribute.
     *
     * @param players
     *         List of players to transform.
     *
     * @return List of Strings based on {@code players} parameter.
     *
     * @since 1
     */
    public List<String> getExpandablePlayers(List<Player> players);

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
     *         The Player to save/update.
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
