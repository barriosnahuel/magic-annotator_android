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
 * Team.java Created by: Nahuel Barrios: 16/03/2012, 04:41:55.
 */
package com.nbempire.android.magicannotator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity type to represent a team.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class Team implements Serializable {

    /**
     * The serialVersionUID of this type.
     */
    private static final long serialVersionUID = 4246802248640324830L;

    /**
     * The team's label.
     */
    private final String label;

    /**
     * Team's players.
     */
    private final List<Player> players = new ArrayList<Player>();

    /**
     * A constructor method for the type.
     *
     * @param label
     *         The team's label.
     *
     * @since 1
     */
    public Team(String label) {
        this.label = label;
    }

    /**
     * Adds the specified Player to this team's players.
     *
     * @param aPlayer
     *         A player to add to this team.
     *
     * @since 1
     */
    public void addPlayer(Player aPlayer) {
        players.add(aPlayer);
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return String the label.
     *
     * @since 1
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return List<Player> the players.
     *
     * @since 1
     */
    public List<Player> getPlayers() {
        return players;
    }

}
