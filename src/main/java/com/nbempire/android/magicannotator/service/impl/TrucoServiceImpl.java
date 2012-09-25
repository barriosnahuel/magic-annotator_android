/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoServiceImpl.java Created by: Nahuel Barrios: 16/03/2012, 05:22:10.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GUIKeys;

/**
 * TODO : JavaDoc : for TrucoServiceImpl.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 16/03/2012, 05:22:10.
 */
public class TrucoServiceImpl extends GameServiceImpl {

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers == 2 || numberOfPlayers == 4 || numberOfPlayers == 6;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return GUIKeys.EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_TRUCO;
    }

    @Override
    protected String getFirstTeamLabel() {
        return GUIKeys.GAME_TRUCO_TEAM_LABEL_WE;
    }

    @Override
    protected String getSecondTeamLabel() {
        return GUIKeys.GAME_TRUCO_TEAM_LABEL_THEM;
    }

    @Override
    protected int getTeamPlayersLimit(int numberOfSelectedPlayers) {
        return numberOfSelectedPlayers / 2;
    }

}
