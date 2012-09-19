/**
 * GUIKeys.java Created by: Nahuel Barrios: 17/03/2012, 11:48:41.
 */
package com.nbempire.android.magicannotator;

/**
 * TODO : JavaDoc : for GUIKeys.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 17/03/2012, 11:48:41.
 */
public abstract class GUIKeys {

    // Truco Labels
    public static final String GAME_TRUCO_TEAM_LABEL_WE = "Nosotros";

    public static final String GAME_TRUCO_TEAM_LABEL_THEM = "Ellos";

    // Tute Labels
    public static final String GAME_TUTE_TEAM_LABEL_GROUP1 = "Grupo 1";

    public static final String GAME_TUTE_TEAM_LABEL_GROUP2 = "Grupo 2";

    // Common labels
    public static final String COMMON_SELECTED_PLAYERS = "Jugadores seleccionados";

    // Sizes
    public static final int EXPANDABLE_GROUP_LABEL_PADDING_LEFT = 36;

    public static final float EXPANDABLE_GROUP_LABEL_SIZE = 20;

    public static final int VIEW_CURRENT_BUGS_TEXT_SIZE_FOR_BUGS_DETAIL = 20;

    // Exceptions
    public static final String EXCEPTION_GAME_INVALID_GAME_KEY = "No se encontró ningún juego con esa key.";

    public static final String EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_TUTE = "Se deben seleccionar entre 3 y 12 jugadores.";

    public static final String EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_CHANCHO = "Se deben seleccionar entre 3 y 12 jugadores.";

    public static String EXCEPTION_GAME_INVALID_NUMBER_SELECTED_PLAYERS_TRUCO = "La cantidad de jugadores debe ser 2, 4 o 6.";

}
