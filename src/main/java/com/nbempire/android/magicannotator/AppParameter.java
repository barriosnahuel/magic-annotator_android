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
 * AppParameter.java Created by: Nahuel Barrios: 23/03/2012, 07:05:38.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.game.Game;

/**
 * Abstract class to put app parameter keys.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class AppParameter {

    public static final String GA_KEY = "UA-3569";

    public static final int GA_DISPATCH_INTERVAL = 5;

    /**
     * The number of launches until display the for first time the dialog to let user rate the application.
     */
    public final static int LAUNCHES_UNTIL_FIRST_PROMPT_FOR_RATE_APP = 0;//2

    /**
     * Number of days until next prompt for rating the application.
     */
    public final static int DAYS_UNTIL_NEXT_PROMPT = 0;//10

    /**
     * The current {@link Game} that the user is creating.
     */
    public static final String GAME = "game";

    public static final String PLAYERS = "players";

    public static final String FIRST_RUN = "firstRun";
}
