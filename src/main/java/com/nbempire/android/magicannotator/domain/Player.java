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
 * @version 1.0.
 * @since 09/03/2012, 03:33:15.
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
     * @author Nahuel Barrios.
     * @since 16/03/2012.
     * @param nickName
     */
    public Player(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 17/03/2012.
     * @return the nickName.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 10/04/2012.
     * @return the scores.
     */
    public Map<String, Integer> getScores() {
        return scores;
    }

    public int compareTo(Player another) {
        return this.getNickName().compareTo(another.getNickName());
    }

    @Override
    public String toString() {
        return "Player [nickName=" + nickName + "]";
    }

}
