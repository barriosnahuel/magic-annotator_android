/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AnnotatorFactory.java Created by: Nahuel Barrios: 05/04/2012, 08:11:12.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.activity.ChanchoAnnotatorActivity;
import com.nbempire.android.magicannotator.activity.TrucoAnnotatorActivity;
import com.nbempire.android.magicannotator.activity.TuteAnnotatorActivity;
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
public class AnnotatorFactory {

    /**
     * TODO : JavaDoc : for AnnotatorFactory.get()
     *
     * @param aGame
     *
     * @return {@link Class<? extends Activity>}
     *
     * @throws IllegalArgumentException
     * @throws {@link
     *         IllegalArgumentException} when there isn't any Activity for the input {@link Game}..
     * @since 1
     */
    public static Class<? extends Activity> getFor(Game aGame) throws IllegalArgumentException {
        if (aGame == null) {
            throw new IllegalArgumentException("El juego no puede ser null.");
        } else {
            Class<? extends Game> gameClass = aGame.getClass();
            if (gameClass.equals(Chancho.class)) {
                return ChanchoAnnotatorActivity.class;
            } else if (gameClass.equals(Truco.class)) {
                return TrucoAnnotatorActivity.class;
            } else if (gameClass.equals(Tute.class)) {
                return TuteAnnotatorActivity.class;
            } else {
                throw new IllegalArgumentException("La actividad todavía no existe o no esta configurada correctamente.");
            }

        }
    }

}
