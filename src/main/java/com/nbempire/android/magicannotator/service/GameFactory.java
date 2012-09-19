/**
 * GameFactory.java Created by: Nahuel Barrios: 24/03/2012, 01:53:59.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.GUIKeys;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;

/**
 * TODO : JavaDoc : for GameFactory.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 01:53:59.
 */
public abstract class GameFactory {

    /**
     * TODO : JavaDoc : for GameFactory.getInstance()
     * 
     * @author Nahuel Barrios.
     * @since 24/03/2012.
     * @param gameName
     * @return
     * @throws IllegalArgumentException
     */
    public static Game getInstance(String gameKey) throws IllegalArgumentException {
        try {
            if (gameKey.equals("Chancho")) {
                return new Chancho();
            } else if (gameKey.equals("Otro")) {
                return null;
            } else if (gameKey.equals("Truco")) {
                return new Truco();
            } else if (gameKey.equals("Tute")) {
                return new Tute();
            } else {
                throw new IllegalArgumentException(GUIKeys.EXCEPTION_GAME_INVALID_GAME_KEY);
            }
        } catch (NullPointerException nullPointerException) {
            // TODO : Exception : Terminate this exception log.
            throw new IllegalArgumentException(GUIKeys.EXCEPTION_GAME_INVALID_GAME_KEY);
        }

    }
}
