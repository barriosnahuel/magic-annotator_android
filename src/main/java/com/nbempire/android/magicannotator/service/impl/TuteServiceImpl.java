/**
 * TuteServiceImpl.java Created by: Nahuel Barrios: 24/03/2012, 02:24:01.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GUIKeys;
import com.nbempire.android.magicannotator.service.GameService;

/**
 * TODO : JavaDoc : for TuteServiceImpl.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 02:24:01.
 */
public class TuteServiceImpl extends GameServiceImpl implements GameService {

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers >= 3 && numberOfPlayers <= 12;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return GUIKeys.EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_TUTE;
    }

    @Override
    protected String getFirstTeamLabel() {
        return GUIKeys.GAME_TUTE_TEAM_LABEL_GROUP1;
    }

    @Override
    protected String getSecondTeamLabel() {
        return GUIKeys.GAME_TUTE_TEAM_LABEL_GROUP2;
    }

    @Override
    protected int getTeamPlayersLimit(int numberOfSelectedPlayers) {
        int limit = 6;
        if (numberOfSelectedPlayers == 7 || numberOfSelectedPlayers == 8) {
            limit = 4;
        } else if (numberOfSelectedPlayers == 9 || numberOfSelectedPlayers == 10) {
            limit = 5;
        }
        return limit;
    }

}
