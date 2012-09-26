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
 * @since 1
 */
public interface TutePlayerService extends PlayerService {

    /**
     * TODO : JavaDoc : for PlayerService.addCapote()
     *
     * @param aPlayer
     *
     * @since 1
     */
    public void addCapote(Player aPlayer);

    /**
     * TODO : JavaDoc : for TutePlayerService.addTute()
     *
     * @param aPlayer
     *
     * @since 1
     */
    public void addTute(Player aPlayer);

    /**
     * TODO : JavaDoc : for TutePlayerService.addLostHand()
     *
     * @param players
     * @param looserPlayers
     *
     * @since 1
     */
    public void addLostHand(List<Player> players, List<String> looserPlayers);

}
