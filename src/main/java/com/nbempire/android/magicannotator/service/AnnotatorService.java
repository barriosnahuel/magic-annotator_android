/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 12:17hs.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.game.Game;

/**
 * Service for the annotators.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public interface AnnotatorService {

    /**
     * Inspect which game key has to return based on the specified {@code gameName} parameter. TODO : Javadoc for AnnotatorService
     *
     * @param userSelection
     *         The name of one game. It has to be unique for the app.
     *
     * @return {@link Integer} -1 if there is no game that matchs the current gameName
     *
     * @since 1
     */
    int getAnnotatorId(String userSelection);

    /**
     * Creates an instance of games based on a specific gameKey.
     *
     * @param annotatorId
     *         the annotator id
     *
     * @return An instance of Game based on the specified gameKey.
     *
     * @since 1
     */
    Game getAnnotatorGame(int annotatorId);
}
