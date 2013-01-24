/*
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
 * On: 19/10/2012 at 15:44hs.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract type to generate lists of teams for different tests.
 * <p/>
 * <b>Important: It's only for test.</b>
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public abstract class DummyTeams {

    public static List<Team> withoutPlayers() {
        List<Team> teams = new ArrayList<Team>();
        teams.add(new Team("Nosotros"));
        teams.add(new Team("Ellos"));
        return teams;
    }

    private static List<Team> withoutPlayers(String[] teamsLabel) {
        List<Team> teams = new ArrayList<Team>();

        for (String string : teamsLabel) {
            teams.add(new Team(string));
        }

        return teams;
    }

    public static List<Team> with2PlayersPerTeam(String[] teamsLabel) {
        List<Team> teams = DummyTeams.withoutPlayers(teamsLabel);
        for (int index = 0; index < teams.size(); index++) {
            Team eachTeam = teams.get(index);
            eachTeam.addPlayer(new Player("un nombre" + index + 1));
            eachTeam.addPlayer(new Player("otro nombre" + index + 1));
        }
        return teams;
    }
}
