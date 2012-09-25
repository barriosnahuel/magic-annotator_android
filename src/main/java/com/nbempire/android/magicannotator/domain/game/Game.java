/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Game.java Created by: Nahuel Barrios: 16/03/2012, 04:42:50.
 */
package com.nbempire.android.magicannotator.domain.game;

import java.io.Serializable;
import java.util.List;

import com.nbempire.android.magicannotator.domain.Team;

/**
 * TODO : JavaDoc : for Game.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 16/03/2012, 04:42:50.
 */
public abstract class Game implements Serializable {

    /**
     * @author Nahuel Barrios.
     */
    private static final long serialVersionUID = 4849356274653494152L;

    protected List<Team> teams;

    protected Integer minimumTeams;

    protected Integer maximumTeams;

    /**
     * A constructor method for the {@link Game} type.
     * 
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param key
     * @param minimumTeams
     * @param maximumTeams
     */
    public Game(Integer minimumTeams, Integer maximumTeams) {
        super();
        this.minimumTeams = minimumTeams;
        this.maximumTeams = maximumTeams;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 23/03/2012.
     * @return the teams.
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * @author Nahuel Barrios.
     * @since 23/03/2012.
     * @param teams
     *            the teams to set.
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
