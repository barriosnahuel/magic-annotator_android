/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 12:17hs.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.domain.game.Game;

/**
 * Service for the annotators.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public interface AnnotatorService {

    /**
     * Get the associated annotator Id for the specified {@code userSelection}.
     *
     * @param userSelection
     *         The name of one game. It has to be unique for the app.
     *
     * @return The Id of the annotator that matchs the specified {@code userSelection}.
     *
     * @throws IllegalArgumentException
     *         when the {@code userSelection} is {@code null} or if there isn't any annotator that matches the specified {@code userSelection}.
     * @since 1
     */
    int getAnnotatorId(String userSelection);

    /**
     * Creates an instance of games based on a specific {@code annotatorId}.
     *
     * @param annotatorId
     *         the annotator id
     *
     * @return An instance of Game based on the specified {@code annotatorId}. {@code null} when there isn't any Game for the specified {@code
     *         annotatorId}.
     *
     * @since 1
     */
    Game getAnnotatorGame(int annotatorId);

    /**
     * Inspect which annotator activity has to return based on the specified {@code annotatorId} parameter.
     *
     * @param annotatorId
     *         An annotator Id.
     *
     * @return The corresponding annotator activity for the specified {@code annotatorId}.
     *
     * @throws IllegalArgumentException
     *         When there isn't any Activity for the specified {@code annotatorId}.
     * @since 1
     */
    public Class<? extends Activity> get(int annotatorId) throws IllegalArgumentException;

    /**
     * Inspect which annotator activity has to return based on the specified {@code game} parameter.
     *
     * @param game
     *         A Game associated with some annotator Activity.
     *
     * @return The corresponding annotator activity for the specified {@code game}.
     *
     * @throws IllegalArgumentException
     *         When there isn't any Activity for the specified {@code game}.
     * @since 1
     */
    public Class<? extends Activity> get(Game game) throws IllegalArgumentException;
}
