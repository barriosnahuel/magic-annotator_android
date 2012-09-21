/**
 * AppParameter.java Created by: Nahuel Barrios: 23/03/2012, 07:05:38.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.game.Game;

/**
 * Abstract class to put app parameter keys.
 * 
 * @author Nahuel Barrios.
 * @since 1.0
 */
public abstract class AppParameter {

    /**
     * The current {@link Game} that the user is creating.
     */
    public static final String GAME = "game";

    /**
     * The nickname for the new player that the user is creating.
     */
    public static final String NEW_PLAYER_NICKNAME = "newPlayerNickName";

    /**
     * The tab's key for the tute partial results tab.
     */
    public static final String TUTE_TAB_KEY_PARTIAL_RESULTS = "partialResults";

    /**
     * The tab's key for the tute hand tab.
     */
    public static final String TUTE_TAB_KEY_HAND = "hand";

    /**
     * The tab's key for the tute final results tab.
     */
    public static final String TUTE_TAB_KEY_FINAL_RESULTS = "finalResults";

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
     * // TODO : JavaDoc : for CHOOSEN_PLAYER_NICKNAME
     */
    public static final String CHOOSEN_PLAYER_NICKNAME = "choosenPlayerNickName";

    /**
     * // TODO : JavaDoc : for TUTE_ACTIVITY_RESULT_FOR_CHOOSE_GAMES_PLAYER
     */
    public static final String TUTE_ACTIVITY_RESULT_FOR_CHOOSE_GAMES_PLAYER = "tuteActivityResultForChooseGamesPlayer";

    /**
     * // TODO : JavaDoc : for LOOSER_PLAYERS
     */
    public static final String LOOSER_PLAYERS = "looserPlayers";

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
     * // TODO : JavaDoc : for ACTIVITY_RESULT_GET_LOOSER_PLAYERS
     */
    public static final int ACTIVITY_RESULT_GET_LOOSER_PLAYERS = 4;

    public static final CharSequence CHANCHO_PLAYER_SCORE_CHANCHO = "chanchoScore";

    public static final String PLAYERS = "players";

}
