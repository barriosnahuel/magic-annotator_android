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
 * TuteServiceImpl.java Created by: Nahuel Barrios: 24/03/2012, 02:24:01.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GUIKeys;
import com.nbempire.android.magicannotator.service.GameService;

/**
 * Implementation of GameService for the Tute game.
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
        return GUIKeys.Exceptions.INVALID_NUMBER_SELECTED_PLAYERS_TUTE;
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
