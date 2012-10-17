/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Player.java Created by: Nahuel Barrios: 09/03/2012, 03:33:15.
 */
package com.nbempire.android.magicannotator.domain;

import java.io.Serializable;

/**
 * Entity type to represent a player of any game.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class Player implements Serializable, Comparable<Player> {

    /**
     * The serialVersionUID of this type.
     */
    private static final long serialVersionUID = -7240272823346653241L;

    private int id;

    /**
     * The player's nick name.
     */
    private final String nickName;

    /**
     * A constructor method for the type.
     *
     * @param nickName
     *         The player's nick name.
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

    public int compareTo(Player another) {
        return nickName.compareTo(another.nickName);
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the id.
     *
     * @since 13
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the attribute of the entity.
     *
     * @param id
     *         the {@code id} to set.
     *
     * @since 13
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                       "id=" + id +
                       ", nickName='" + nickName + '\'' +
                       '}';
    }
}
