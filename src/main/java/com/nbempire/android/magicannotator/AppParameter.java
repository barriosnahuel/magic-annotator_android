/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AppParameter.java Created by: Nahuel Barrios: 23/03/2012, 07:05:38.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.game.Game;

/**
 * Abstract class to put app parameter keys.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class AppParameter {

    /**
     * The current {@link Game} that the user is creating.
     */
    public static final String GAME = "game";

    /**
     * // TODO : JavaDoc : for TUTE_PLAYER_SCORE_LOST_HAND
     */
    public static final String TUTE_PLAYER_SCORE_LOST_HAND = "tuteScoreLostHand";

    /**
     * // TODO : JavaDoc : for TUTE_PLAYER_SCORE_CAPOTE
     */
    public static final String TUTE_PLAYER_SCORE_CAPOTE = "tuteScoreCapote";

    /**
     * // TODO : JavaDoc : for TUTE_PLAYER_SCORE_TUTE
     */
    public static final String TUTE_PLAYER_SCORE_TUTE = "tuteScoreTute";

    /**
     * // TODO : JavaDoc : for ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_LOST_HAND
     */
    public static final int ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_LOST_HAND = 2;

    /**
     * // TODO : JavaDoc : for ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_CAPOTE
     */
    public static final int ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_CAPOTE = 3;

    /**
     * // TODO : JavaDoc : for ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_TUTE
     */
    public static final int ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_TUTE = 4;

    /**
     * TODO : Javadoc for PLAYERS
     */
    public static final String PLAYERS = "players";

}
