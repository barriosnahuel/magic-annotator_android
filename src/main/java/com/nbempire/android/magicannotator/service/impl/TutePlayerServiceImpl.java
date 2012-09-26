/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TutePlayerServiceImpl.java Created by: Nahuel Barrios: 11/04/2012, 00:20:17.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.List;
import java.util.Map;

import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.service.TutePlayerService;

/**
 * TODO : JavaDoc : for TutePlayerServiceImpl.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TutePlayerServiceImpl extends PlayerServiceImpl implements TutePlayerService {

    public void addCapote(Player aPlayer) {
        this.addScoreFor(aPlayer, AppParameter.TUTE_PLAYER_SCORE_CAPOTE);
    }

    public void addTute(Player aPlayer) {
        this.addScoreFor(aPlayer, AppParameter.TUTE_PLAYER_SCORE_TUTE);
    }

    /**
     * TODO : JavaDoc : for TutePlayerServiceImpl.addScoreFor()
     *
     * @param aPlayer
     * @param scoreKey
     *
     * @since 1
     */
    private void addScoreFor(Player aPlayer, String scoreKey) {
        Map<String, Integer> scores = aPlayer.getScores();
        int updatedScore = 1;
        try {
            updatedScore = scores.get(scoreKey) + 1;
        } catch (NullPointerException nullPointerException) {
            System.out.println("Jugador \"" + aPlayer.getNickName() + "\" no tiene el score \"" + scoreKey
                                       + "\" asignado, por lo tanto el primer valor es 1.");
        }
        scores.put(scoreKey, updatedScore);
    }

    public void addLostHand(List<Player> players, List<String> looserPlayers) {
        for (Player eachPlayer : players) {
            if (looserPlayers.contains(eachPlayer.getNickName())) {
                this.addScoreFor(eachPlayer, AppParameter.TUTE_PLAYER_SCORE_LOST_HAND);
            }
        }
    }

}
