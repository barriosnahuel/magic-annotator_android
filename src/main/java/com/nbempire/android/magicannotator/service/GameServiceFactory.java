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
 * ServiceFactoryImpl.java Created by: Nahuel Barrios: 23/03/2012, 06:48:00.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl;
import com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl;
import com.nbempire.android.magicannotator.service.impl.TuteServiceImpl;

/**
 * Abstract type to provide a factory of implementations of the GameService interface.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GameServiceFactory {

    /**
     * Gets the corresponding instance of a GameService for the specified {@code aGame} parameter.
     *
     * @param aGame
     *         A Game associated with a particular instance of a GameService.
     *
     * @return An instantiated GameService.
     *
     * @throws IllegalArgumentException
     *         When there isn't any Service for the input {@link Game}.
     * @since 1
     */
    public static GameService getInstance(Game aGame) throws IllegalArgumentException {
        if (aGame == null) {
            throw new IllegalArgumentException("Game musn't be null.");
        }

        GameService annotatorActivity;
        if (aGame instanceof Truco) {
            annotatorActivity = new TrucoServiceImpl();

        } else if (aGame instanceof Chancho) {
            annotatorActivity = new ChanchoServiceImpl();

        } else if (aGame instanceof Tute) {
            annotatorActivity = new TuteServiceImpl();

        } else {
            throw new IllegalArgumentException("There's no Service for the specified game: " + aGame.getClass().getSimpleName());
        }

        return annotatorActivity;
    }

}
