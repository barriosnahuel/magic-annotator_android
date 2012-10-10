/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * GameService.java Created by: Nahuel Barrios: 16/03/2012, 05:17:29.
 */
package com.nbempire.android.magicannotator.service;

import java.util.List;

import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import com.nbempire.android.magicannotator.util.ExpandableList;

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
     * TODO : JavaDoc : for GameService.getExpandableTeams()
     *
     * @param teams
     *
     * @return
     *
     * @since 1
     */
    public abstract ExpandableList getExpandableTeams(List<Team> teams);

}
