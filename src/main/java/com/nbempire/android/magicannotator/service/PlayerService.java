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
 * @version 1.0.
 * @since 23/03/2012, 05:41:33.
 */
public interface PlayerService {

    /**
     * TODO : JavaDoc : for PlayerService.parsePlayers()
     * 
     * @author Nahuel Barrios.
     * @since 23/03/2012.
     * @param playersToParse
     * @return
     */
    public List<Player> parsePlayers(List<String> playersToParse);

    /**
     * TODO : JavaDoc : for PlayerService.getExpandablePlayers()
     * 
     * @author Nahuel Barrios.
     * @since 24/03/2012.
     * @param players
     * @return
     */
    public List<String> getExpandablePlayers(List<Player> players);

    /**
     * TODO : JavaDoc : for PlayerService.getPlayer()
     * 
     * @author Nahuel Barrios.
     * @since 10/04/2012.
     * @param players
     * @param nickName
     * @return {@link Player}.
     */
    public Player getPlayer(List<Player> players, String nickName);

}
