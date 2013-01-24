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
 * Game.java Created by: Nahuel Barrios: 16/03/2012, 04:42:50.
 */
package com.nbempire.android.magicannotator.domain.game;

import com.nbempire.android.magicannotator.domain.Team;

import java.io.Serializable;
import java.util.List;

/**
 * Abstract type to generalize a Game. All games should extend this type.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class Game implements Serializable {

    /**
     * The serialVersionUID of this type.
     */
    private static final long serialVersionUID = 4849356274653494152L;

    /**
     * The list of teams that has this Game.
     */
    private List<Team> teams;

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the teams.
     *
     * @since 1
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * @param teams
     *         the teams to set.
     *
     * @since 1
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
