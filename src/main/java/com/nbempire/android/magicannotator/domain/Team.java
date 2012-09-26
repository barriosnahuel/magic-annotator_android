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
 * TODO : JavaDoc : for Team.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class Team implements Serializable {

    /**
     * @author Nahuel Barrios.
     */
    private static final long serialVersionUID = -4595719220845823746L;

    private String label;

    private List<Player> players = new ArrayList<Player>();

    /**
     * A constructor method for the {@link Team} type.
     *
     * @param label
     *
     * @since 1
     */
    public Team(String label) {
        this.label = label;
    }

    /**
     * TODO : JavaDoc : for Team.addPlayer()
     *
     * @param aPlayer
     *
     * @since 1
     */
    public void addPlayer(Player aPlayer) {
        players.add(aPlayer);
    }

    /**
     * @param players
     *         List<Player> the players to set.
     *
     * @since 1
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
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
