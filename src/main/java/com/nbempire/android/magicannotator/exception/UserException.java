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
