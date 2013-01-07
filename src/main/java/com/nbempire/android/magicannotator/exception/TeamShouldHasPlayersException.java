/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 15:34hs.
 */
package com.nbempire.android.magicannotator.exception;

/**
 * Exception to throw when a team hasn't got any players.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class TeamShouldHasPlayersException extends Exception {

    /**
     * The serialVersionUID of this exception.
     */
    private static final long serialVersionUID = -8366867328553610150L;

    public TeamShouldHasPlayersException() {
        super("The team should has at least one player.");
    }
}
