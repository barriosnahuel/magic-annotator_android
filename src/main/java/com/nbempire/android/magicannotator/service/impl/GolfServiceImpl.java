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

import com.nbempire.android.magicannotator.MagicAnnotatorApp;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.service.GameService;

/**
 * Service for the {@link com.nbempire.android.magicannotator.component.activity.annotator.GolfAnnotatorActivity}.
 * <p/>
 * Created on 2/25/13, at 9:23 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 19.
 */
public class GolfServiceImpl extends GameServiceImpl implements GameService {

    @Override
    protected String getFirstTeamLabel() {
        return null;
    }

    @Override
    protected String getSecondTeamLabel() {
        return null;
    }

    @Override
    protected int getTeamPlayersLimit(int selectedPlayers) {
        return selectedPlayers;
    }

    @Override
    protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
        return numberOfPlayers > 0;
    }

    @Override
    protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
        return MagicAnnotatorApp.getContext().getText(R.string.mustSelectAtLeastOne).toString();
    }
}
