/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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
