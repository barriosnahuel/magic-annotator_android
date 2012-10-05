/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Team.java Created by: Nahuel Barrios: 16/03/2012, 04:41:55.
 */
package com.nbempire.android.magicannotator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity type to represent a team.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class Team implements Serializable {

    /**
     * The serialVersionUID of this type.
     */
    private static final long serialVersionUID = 4246802248640324830L;

    /**
     * The team's label.
     */
    private final String label;

    /**
     * Team's players.
     */
    private final List<Player> players = new ArrayList<Player>();

    /**
     * A constructor method for the type.
     *
     * @param label
     *         The team's label.
     *
     * @since 1
     */
    public Team(String label) {
        this.label = label;
    }

    /**
     * Adds the specified Player to this team's players.
     *
     * @param aPlayer
     *         A player to add to this team.
     *
     * @since 1
     */
    public void addPlayer(Player aPlayer) {
        players.add(aPlayer);
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return String the label.
     *
     * @since 1
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return List<Player> the players.
     *
     * @since 1
     */
    public List<Player> getPlayers() {
        return players;
    }

}
