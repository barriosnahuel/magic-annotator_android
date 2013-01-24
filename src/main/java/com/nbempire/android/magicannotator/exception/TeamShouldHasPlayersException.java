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
