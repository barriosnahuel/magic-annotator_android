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
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 09:17hs.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
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
    Class<? extends Activity> getNextActivityType(Activities chooseAnnotator, int annotatorId);
}
