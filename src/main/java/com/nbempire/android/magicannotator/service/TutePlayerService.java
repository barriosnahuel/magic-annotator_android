/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TutePlayerService.java Created by: Nahuel Barrios: 10/04/2012, 23:57:04.
 */
package com.nbempire.android.magicannotator.service;

import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;

/**
 * TODO : JavaDoc : for TutePlayerService.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 10/04/2012, 23:57:04.
 */
public interface TutePlayerService extends PlayerService {

    /**
     * TODO : JavaDoc : for PlayerService.addCapote()
     * 
     * @author Nahuel Barrios.
     * @since 10/04/2012.
     * @param aPlayer
     */
    public void addCapote(Player aPlayer);

    /**
     * TODO : JavaDoc : for TutePlayerService.addTute()
     * 
     * @author Nahuel Barrios.
     * @since 11/04/2012.
     * @param aPlayer
     */
    public void addTute(Player aPlayer);

    /**
     * TODO : JavaDoc : for TutePlayerService.addLostHand()
     * 
     * @author Nahuel Barrios.
     * @since 12/04/2012.
     * @param players
     * @param looserPlayers
     */
    public void addLostHand(List<Player> players, List<String> looserPlayers);

}
