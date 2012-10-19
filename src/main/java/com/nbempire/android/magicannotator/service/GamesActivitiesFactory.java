/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.GenericAnnotatorActivity;

/**
 * Factory to get games keys and activities as based
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class GamesActivitiesFactory {

    /**
     * Inspect which annotator activity has to return based on the specified {@code aGame} parameter.
     *
     * @param gameKey
     *         A game id.
     *
     * @return The corresponding games activities to the specified {@code gameKey}.
     *
     * @throws IllegalArgumentException
     *         when there isn't any Activity for the specified {@code gameKey}.
     * @since 1
     */
    public static Class<? extends Activity> getAnnotator(int gameKey) throws IllegalArgumentException {
        switch (gameKey) {
            case R.string.gamename_otro:
                return GenericAnnotatorActivity.class;
            default:
                throw new IllegalArgumentException("La actividad todavía no existe o no esta configurada correctamente.");
        }
    }

}
