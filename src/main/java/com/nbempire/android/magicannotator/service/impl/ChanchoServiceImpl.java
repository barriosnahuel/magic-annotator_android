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
        return GUIKeys.GAME_TUTE_TEAM_LABEL_GROUP1;
    }

    @Override
    protected String getSecondTeamLabel() {
        return GUIKeys.GAME_TUTE_TEAM_LABEL_GROUP2;
    }

    @Override
    protected int getTeamPlayersLimit(int selectedPlayers) {
        return GameKeys.CHANCHO_MAX_PLAYERS;
    }

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers > GameKeys.CHANCHO_MIN_PLAYERS && numberOfPlayers <= GameKeys.CHANCHO_MAX_PLAYERS;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return GUIKeys.Exceptions.INVALID_NUMBER_SELECTED_PLAYERS_CHANCHO;
    }

}
