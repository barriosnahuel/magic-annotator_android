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

package com.nbempire.android.magicannotator;

/**
 * Abstract class to put here all game keys.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GameKeys {

    public static final int CHANCHO_MIN_PLAYERS = 2;
    public static final int CHANCHO_MAX_PLAYERS = 12;

    public static final String GAME_NAME_CHANCHO = "Chancho";
    public static final String GAME_NAME_MARKET = "Lista del supermercado";
    public static final String GAME_NAME_OTHER = "Otro";
    public static final String GAME_NAME_TRUCO = "Truco";
    public static final String GAME_NAME_TUTE = "Tute";

    public static final int TRUCO_MAX_SCORE = 30;
    public static final int TRUCO_INCREMENT = 1;
    public static final int TRUCO_MAX_SCORE_WITHOUT_WIN = TRUCO_MAX_SCORE - TRUCO_INCREMENT;

    /**
     * Default quantity for new items on the market list annotator.
     */
    public static final String MARKET_ITEM_INITIAL_QUANTITY = String.valueOf(1);
}
