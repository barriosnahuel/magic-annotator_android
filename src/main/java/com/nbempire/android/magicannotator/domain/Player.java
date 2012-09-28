/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Player.java Created by: Nahuel Barrios: 09/03/2012, 03:33:15.
 */
package com.nbempire.android.magicannotator.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO : JavaDoc : for Player.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class Player implements Serializable, Comparable<Player> {

    /**
     * @author Nahuel Barrios.
     */
    private static final long serialVersionUID = 8589707208385445320L;

    private String nickName;

    private Map<String, Integer> scores = new HashMap<String, Integer>();

    /**
     * A constructor method for the {@link Player} type.
     *
     * @param nickName
     *
     * @since 1
     */
    public Player(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the nickName.
     *
     * @since 1
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the scores.
     *
     * @since 1
     */
    public Map<String, Integer> getScores() {
        return scores;
    }

    public int compareTo(Player another) {
        return nickName.compareTo(another.nickName);
    }

    @Override
    public String toString() {
        return "Player [nickName=" + nickName + "]";
    }

}
