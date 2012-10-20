/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * UserException.java Created by: Nahuel Barrios: 16/03/2012, 05:28:01.
 */
package com.nbempire.android.magicannotator.exception;

/**
 * Exception with a simple message to show to the user.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class UserException extends Exception {

    /**
     * The serialVersionUID for this class.
     */
    private static final long serialVersionUID = -7804434334427124016L;

    /**
     * {@link String} with message for user.
     */
    private final String guiMessage;

    /**
     * A constructor method for the type.
     *
     * @param guiMessage
     *         {@link String} with message for user.
     *
     * @since 1
     */
    public UserException(String guiMessage) {
        super(guiMessage);
        this.guiMessage = guiMessage;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the guiMessage.
     *
     * @since 1
     */
    public String getGuiMessage() {
        return guiMessage;
    }

}
