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
 * GUIKeys.java Created by: Nahuel Barrios: 17/03/2012, 11:48:41.
 */
package com.nbempire.android.magicannotator;

/**
 * Abstract class to put here all GUI keys that can't be resources.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GUIKeys {

    // Truco Labels
    public static final String GAME_TRUCO_TEAM_LABEL_WE = "Nosotros";

    public static final String GAME_TRUCO_TEAM_LABEL_THEM = "Ellos";

    // Tute Labels
    public static final String GAME_TUTE_TEAM_LABEL_GROUP1 = "Grupo 1";

    public static final String GAME_TUTE_TEAM_LABEL_GROUP2 = "Grupo 2";

    /**
     * @author Nahuel Barrios.
     * @since 9
     */
    public abstract static class Exceptions {

        public static final String INVALID_NUMBER_SELECTED_PLAYERS_TUTE = "Se deben seleccionar entre 3 y 12 jugadores.";

        public static final String INVALID_NUMBER_SELECTED_PLAYERS_CHANCHO = "Se deben seleccionar entre 3 y 12 jugadores.";

        public static final String INVALID_NUMBER_SELECTED_PLAYERS_TRUCO = "La cantidad de jugadores debe ser 2, 4 o 6.";
    }
}
