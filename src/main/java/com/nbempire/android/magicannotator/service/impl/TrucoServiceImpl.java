/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * TrucoServiceImpl.java Created by: Nahuel Barrios: 16/03/2012, 05:22:10.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GUIKeys;

/**
 * Implementation of GameServiceImpl for Truco game.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TrucoServiceImpl extends GameServiceImpl {

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers == 2 || numberOfPlayers == 4 || numberOfPlayers == 6;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return GUIKeys.Exceptions.INVALID_NUMBER_SELECTED_PLAYERS_TRUCO;
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
    protected int getTeamPlayersLimit(int selectedPlayers) {
        return selectedPlayers / 2;
    }

}
