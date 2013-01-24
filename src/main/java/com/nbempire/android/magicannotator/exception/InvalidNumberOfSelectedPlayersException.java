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
 * InvalidNumberOfTeamsException.java Created by: Nahuel Barrios: 17/03/2012, 10:00:25.
 */
package com.nbempire.android.magicannotator.exception;

/**
 * Exception that {@code extends} from {@link UserException} that indicates the user has selected an invalid number of players for a specific game.
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
