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
 * @version 1.0.
 * @since 16/03/2012, 04:41:55.
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
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @param label
     */
    public Team(String label) {
        this.label = label;
    }

    /**
     * TODO : JavaDoc : for Team.addPlayer()
     * 
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @param aPlayer
     */
    public void addPlayer(Player aPlayer) {
        players.add(aPlayer);
    }

    /**
     * @author Nahuel Barrios.
     * @since 12/04/2012.
     * @param players
     *            List<Player> the players to set.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 12/04/2012.
     * @return String the label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 12/04/2012.
     * @return List<Player> the players.
     */
    public List<Player> getPlayers() {
        return players;
    }

}
