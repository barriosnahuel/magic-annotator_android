/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GUIKeys;
import com.nbempire.android.magicannotator.GameKeys;
import com.nbempire.android.magicannotator.service.GameService;

/**
 * Implementation of GameServiceImpl service. It provides the functionality to handle Chancho game's events.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ChanchoServiceImpl extends GameServiceImpl implements GameService {

    @Override
    protected String getFirstTeamLabel() {
        return GUIKeys.COMMON_SELECTED_PLAYERS;
    }

    @Override
    protected String getSecondTeamLabel() {
        return "";
    }

    @Override
    protected int getTeamPlayersLimit(int selectedPlayers) {
        return GameKeys.CHANCHO_MAX_PLAYERS;
    }

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers > 2 && numberOfPlayers <= 12;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return GUIKeys.EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_CHANCHO;
    }

}
