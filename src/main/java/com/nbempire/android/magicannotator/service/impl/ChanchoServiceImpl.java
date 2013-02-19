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

package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GameKeys;
import com.nbempire.android.magicannotator.MagicAnnotatorApp;
import com.nbempire.android.magicannotator.R;
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
        return MagicAnnotatorApp.getContext().getText(R.string.group_one).toString();
    }

    @Override
    protected String getSecondTeamLabel() {
        return MagicAnnotatorApp.getContext().getText(R.string.group_two).toString();
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
        return MagicAnnotatorApp.getContext().getText(R.string.message_must_select_between_3_and_12_players).toString();
    }

}
