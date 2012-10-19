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
    protected List<Team> teams;

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
