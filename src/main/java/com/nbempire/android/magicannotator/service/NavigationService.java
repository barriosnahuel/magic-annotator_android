/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 09:17hs.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.Activities;

/**
 * Service that controls the user's navigation flow.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public interface NavigationService {

    /**
     * Identifies which is the next activity that the application has to show to the user based on the specified {@code annotatorId}.
     *
     * @param chooseAnnotator
     *         The current activity.
     * @param annotatorId
     *         The Id of the annotator that the user has selected.
     *
     * @return The next Activity to show to the user.
     *
     * @since 15
     */
    Class getNextActivityType(Activities chooseAnnotator, int annotatorId);
}
