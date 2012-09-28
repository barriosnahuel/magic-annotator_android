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
 * @since 1
 */
public abstract class Game implements Serializable {

    /**
     * The serialVersionUID of this type.
     */
    private static final long serialVersionUID = 4849356274653494152L;

    protected List<Team> teams;

    protected Integer minimumTeams;

    protected Integer maximumTeams;

    /**
     * A constructor method for the {@link Game} type.
     *
     * @param minimumTeams
     * @param maximumTeams
     *
     * @since 1
     */
    public Game(Integer minimumTeams, Integer maximumTeams) {
        super();
        this.minimumTeams = minimumTeams;
        this.maximumTeams = maximumTeams;
    }

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
