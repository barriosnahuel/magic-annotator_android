/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * DummyGames.java Created by: Nahuel Barrios: 17/03/2012, 11:33:47.
 */
package com.nbempire.android.magicannotator;

import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;

/**
 * Abstract type to generate new instances of different games.
 * <p/>
 * <b>Important: It's only for test.</b>
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class DummyGames {

    public static Game truco() {
        return new Truco();
    }

}
