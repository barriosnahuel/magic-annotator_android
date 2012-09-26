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
 * TODO : JavaDoc : for GameService.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public interface GameService {

    /**
     * TODO : JavaDoc : for GameService.makeTeams()
     *
     * @param players
     *
     * @return
     *
     * @throws UserException
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
