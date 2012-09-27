/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator;

/**
 * Abstract class to put here all game keys.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GameKeys {

    public static final int CHANCHO_MAX_PLAYERS = 12;

    public static final String GAME_NAME_OTRO = "Otro";
    public static final String GAME_NAME_MARKET = "Supermercado";

    public static final int TRUCO_MAX_SCORE = 30;
    public static final int TRUCO_INCREMENT = 1;
    public static final int TRUCO_MAX_SCORE_WITHOUT_WIN = TRUCO_MAX_SCORE - TRUCO_INCREMENT;
}
