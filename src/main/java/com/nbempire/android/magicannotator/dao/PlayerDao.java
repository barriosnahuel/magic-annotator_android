/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 17/10/12 at 08:57hs.
 */
package com.nbempire.android.magicannotator.dao;

import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;

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
