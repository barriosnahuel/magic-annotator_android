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
 * TODO : JavaDoc : for PlayerService.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public interface PlayerService {

    /**
     * TODO : JavaDoc : for PlayerService.parsePlayers()
     *
     * @param playersToParse
     *
     * @return
     *
     * @since 1
     */
    public List<Player> parsePlayers(List<String> playersToParse);

    /**
     * TODO : JavaDoc : for PlayerService.getExpandablePlayers()
     *
     * @param players
     *
     * @return
     *
     * @since 1
     */
    public List<String> getExpandablePlayers(List<Player> players);

    /**
     * TODO : JavaDoc : for PlayerService.getPlayer()
     *
     * @param players
     * @param nickName
     *
     * @return {@link Player}.
     *
     * @since 1
     */
    public Player getPlayer(List<Player> players, String nickName);

}
