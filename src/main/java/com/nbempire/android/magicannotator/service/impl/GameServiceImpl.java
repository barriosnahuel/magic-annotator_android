/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * GameServiceImpl.java Created by: Nahuel Barrios: 16/03/2012, 05:21:36.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.InvalidNumberOfSelectedPlayersException;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import com.nbempire.android.magicannotator.service.GameService;
import com.nbempire.android.magicannotator.service.PlayerService;
import com.nbempire.android.magicannotator.util.ExpandableArrayList;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;
import com.nbempire.android.magicannotator.util.RandomGenerator;

/**
 * TODO : JavaDoc : for GameServiceImpl.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GameServiceImpl implements GameService {

    private final PlayerService playerService = new PlayerServiceImpl();

    public List<Team> makeTeams(List<Player> players) throws UserException {
        if (!this.hasValidNumberOfSelectedPlayers(players.size())) {
            throw new InvalidNumberOfSelectedPlayersException(this.getInvalidNumberOfSelectedPlayersExceptionMessage());
        }

        return this.makeRandomTeams(players);
    }

    public ExpandableList getExpandableTeams(List<Team> teams) {
        ExpandableList result = new ExpandableArrayList();

        for (Team eachTeam : teams) {
            result.add(new ExpandableGroup(eachTeam.getLabel(), playerService.getExpandablePlayers(eachTeam.getPlayers())));
        }

        return result;
    }

    /**
     * TODO : JavaDoc : for GameServiceImpl.makeRandomTeams()
     *
     * @param players
     *
     * @return
     *
     * @since 1
     */
    private List<Team> makeRandomTeams(List<Player> players) {
        List<Team> teams = new ArrayList<Team>();

        RandomGenerator<Player> generator = new RandomGenerator<Player>(players);

        Team firstGroup = new Team(this.getFirstTeamLabel());
        Team secondGroup = new Team(this.getSecondTeamLabel());

        int limit = this.getTeamPlayersLimit(players.size());
        for (int counter = 1; generator.hasNext(); counter++) {
            Player player = generator.next();
            if (counter <= limit) {
                firstGroup.addPlayer(player);
            } else {
                secondGroup.addPlayer(player);
            }
        }

        if (!firstGroup.getPlayers().isEmpty()) {
            teams.add(firstGroup);
        }
        if (!secondGroup.getPlayers().isEmpty()) {
            teams.add(secondGroup);
        }

        return teams;
    }

    /**
     * TODO : JavaDoc : for GameServiceImpl.getFirstTeamLabel()
     *
     * @return
     *
     * @since 1
     */
    protected abstract String getFirstTeamLabel();

    /**
     * TODO : JavaDoc : for GameServiceImpl.getSecondTeamLabel()
     *
     * @return
     *
     * @since 1
     */
    protected abstract String getSecondTeamLabel();

    /**
     * TODO : JavaDoc : for GameServiceImpl.getTeamPlayersLimit()
     *
     * @param selectedPlayers
     *
     * @return
     *
     * @since 1
     */
    protected abstract int getTeamPlayersLimit(int selectedPlayers);

    /**
     * TODO : JavaDoc : for GameServiceImpl.hasValidNumberOfSelectedPlayers()
     *
     * @param numberOfPlayers
     *
     * @return
     *
     * @since 1
     */
    protected abstract boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers);

    /**
     * TODO : JavaDoc : for GameServiceImpl.getInvalidNumberOfSelectedPlayersExceptionMessage()
     *
     * @return
     *
     * @since 1
     */
    protected abstract String getInvalidNumberOfSelectedPlayersExceptionMessage();
}
