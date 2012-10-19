/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AnnotatorFactory.java Created by: Nahuel Barrios: 05/04/2012, 08:11:12.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.component.activity.ChanchoAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.TrucoAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.TuteAnnotatorActivity;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;

/**
 * Factory to get games activities as {@link Class} variables.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class AnnotatorFactory {

    /**
     * Inspect which annotator activity has to return based on the specified {@code aGame} parameter.
     *
     * @param aGame
     *         An instance of any Game.
     *
     * @return The corresponding Activity to the specified {@code aGame}.
     *
     * @throws IllegalArgumentException
     *         when there isn't any Activity for the input {@link Game}.
     * @since 1
     */
    public static Class<? extends Activity> getFor(Game aGame) throws IllegalArgumentException {
        if (aGame == null) {
            throw new IllegalArgumentException("Game must not be null.");
        }

        Class<? extends Activity> annotatorActivity;

        Class<? extends Game> gameClass = aGame.getClass();
        if (gameClass.equals(Chancho.class)) {
            annotatorActivity = ChanchoAnnotatorActivity.class;

        } else if (gameClass.equals(Truco.class)) {
            annotatorActivity = TrucoAnnotatorActivity.class;

        } else if (gameClass.equals(Tute.class)) {
            annotatorActivity = TuteAnnotatorActivity.class;

        } else {
            throw new IllegalArgumentException("La actividad todavía no existe o no esta configurada correctamente.");
        }

        return annotatorActivity;
    }

}
