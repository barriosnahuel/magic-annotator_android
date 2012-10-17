/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * PlayerService.java Created by: Nahuel Barrios: 23/03/2012, 05:41:33.
 */
package com.nbempire.android.magicannotator.service;

import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;

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
    public List<Player> parsePlayers(List<String> playersToParse);

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
