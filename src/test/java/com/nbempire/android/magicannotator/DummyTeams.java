/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 15:44hs.
 */
package com.nbempire.android.magicannotator;

import java.util.ArrayList;
import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;

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
