/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
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
import com.nbempire.android.magicannotator.exception.InvalidNumberOfSelectedPlayersException;
import com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException;
import com.nbempire.android.magicannotator.exception.UserException;
import com.nbempire.android.magicannotator.service.GameService;
import com.nbempire.android.magicannotator.service.PlayerService;
import com.nbempire.android.magicannotator.util.ExpandableArrayList;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;
import com.nbempire.android.magicannotator.util.RandomGenerator;

/**
 * Implementation of the GameService interface.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GameServiceImpl implements GameService {

    /**
     * Service for the Player entity.
     */
    private final PlayerService playerService = new PlayerServiceImpl();

    public List<Team> makeTeams(List<Player> players) throws UserException {
        if (!this.hasValidNumberOfSelectedPlayers(players.size())) {
            throw new InvalidNumberOfSelectedPlayersException(this.getInvalidNumberOfSelectedPlayersExceptionMessage());
        }

        return this.makeRandomTeams(players);
    }

    public ExpandableList getExpandableTeams(List<Team> teams) throws TeamShouldHasPlayersException {
        ExpandableList result = new ExpandableArrayList();

        validateTeams(teams);

        for (Team eachTeam : teams) {
            result.add(new ExpandableGroup(eachTeam.getLabel(), playerService.getExpandablePlayers(eachTeam.getPlayers())));
        }

        return result;
    }

    /**
     * Validate if each Team from the specified list of teams has at least one player.
     *
     * @param teams
     *         The list of teams to validate.
     *
     * @throws com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException
     *         When any of the specified teams hasn't got any players.
     * @since 15
     */
    private void validateTeams(List<Team> teams) throws TeamShouldHasPlayersException {
        for (Team eachTeam : teams) {
            if (eachTeam.getPlayers().isEmpty()) {
                throw new TeamShouldHasPlayersException();
            }
        }
    }

    /**
     * Make a list of teams by selecting randomly each player from the specified list of players.
     *
     * @param players
     *         The list of playes which the teams will be created.
     *
     * @return The generated list of teams.
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
     * Gets the label to show to the user for the first team.
     *
     * @return String with the label to show to the user.
     *
     * @since 1
     */
    protected abstract String getFirstTeamLabel();

    /**
     * Gets the label to show to the user for the second team.
     *
     * @return String with the label to show to the user.
     *
     * @since 1
     */
    protected abstract String getSecondTeamLabel();

    /**
     * Calculates the maximum number of players per team based on the specified number of {@code selectedPlayers}.
     *
     * @param selectedPlayers
     *         The number of players selected for the annotator.
     *
     * @return An integer with the maximum number of players per team.
     *
     * @since 1
     */
    protected abstract int getTeamPlayersLimit(int selectedPlayers);

    /**
     * Validates for each specific game when the number of selected players is valid/invalid.
     *
     * @param numberOfPlayers
     *         The current number of selected players.
     *
     * @return {@code true} when the number of players is valid. Otherwise {@code false}.
     *
     * @since 1
     */
    protected abstract boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers);

    /**
     * Gets the message to show to the user when the number of selected players is invalid.
     *
     * @return String with the message to the user.
     *
     * @since 1
     */
    protected abstract String getInvalidNumberOfSelectedPlayersExceptionMessage();
}
