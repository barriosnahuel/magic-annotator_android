/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * InvalidNumberOfTeamsException.java Created by: Nahuel Barrios: 17/03/2012, 10:00:25.
 */
package com.nbempire.android.magicannotator.exception;

/**
 * Exception that {@code extends} from {@link UserException} that indicates the user has selected an invalid number of players for a specific
 * game.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class InvalidNumberOfSelectedPlayersException extends UserException {

    /**
     * The serialVersionUID of this class.
     */
    private static final long serialVersionUID = -5977853697613041011L;

    /**
     * A constructor method for the type.
     *
     * @param guiMessage
     *         {@link String} with message for user.
     *
     * @since 1
     */
    public InvalidNumberOfSelectedPlayersException(String guiMessage) {
        super(guiMessage);
    }

}
