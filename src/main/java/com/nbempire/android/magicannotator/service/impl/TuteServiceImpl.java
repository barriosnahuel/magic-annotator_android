/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

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
 * @since 1
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
    protected int getTeamPlayersLimit(int selectedPlayers) {
        int limit = 6;
        if (selectedPlayers == 7 || selectedPlayers == 8) {
            limit = 4;
        } else if (selectedPlayers == 9 || selectedPlayers == 10) {
            limit = 5;
        }
        return limit;
    }

}
