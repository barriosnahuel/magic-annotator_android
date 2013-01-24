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
 * GameService.java Created by: Nahuel Barrios: 16/03/2012, 05:17:29.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException;
import com.nbempire.android.magicannotator.exception.UserException;
import com.nbempire.android.magicannotator.util.ExpandableList;

import java.util.List;

/**
 * Service for the Game entity.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public interface GameService {

    /**
     * Make teams randomly based on the specified list of players.
     *
     * @param players
     *         List of players to use for each team.
     *
     * @return List of teams generated randomly with the specified players.
     *
     * @throws UserException
     *         when the number of players is invalid for this Game.
     * @since 1
     */
    public abstract List<Team> makeTeams(List<Player> players) throws UserException;

    /**
     * Parse a list of teams and create an ExpandableList ready to show to the user.
     * <p/>
     * The ExpandableList will has one group per team, and each Player will be a subitem of a group.
     *
     * @param teams
     *         A list of teams. The source for the ExpandableList.
     *
     * @return An ExpandableList ready to show to the user
     *
     * @throws com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException
     *         When any of the specified teams hasn't got any players.
     * @since 1
     */
    public abstract ExpandableList getExpandableTeams(List<Team> teams) throws TeamShouldHasPlayersException;

}
