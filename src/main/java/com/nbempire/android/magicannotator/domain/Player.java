/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
