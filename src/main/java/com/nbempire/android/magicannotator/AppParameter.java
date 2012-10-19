/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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

    public static final String GA_KEY = "UA-35699309-1";
    public static final int GA_DISPATCH_INTERVAL = 5;

    /**
     * The current {@link Game} that the user is creating.
     */
    public static final String GAME = "game";

    /**
     * TODO : Javadoc for PLAYERS
     */
    public static final String PLAYERS = "players";

}
