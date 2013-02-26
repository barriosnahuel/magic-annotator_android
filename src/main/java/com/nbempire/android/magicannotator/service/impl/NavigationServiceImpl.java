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
 * On: 19/10/2012 at 09:43hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import android.app.Activity;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.ChoosePlayersActivity;
import com.nbempire.android.magicannotator.component.activity.annotator.GenericAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.annotator.GolfAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.annotator.MarketAnnotatorActivity;
import com.nbempire.android.magicannotator.domain.Activities;
import com.nbempire.android.magicannotator.service.NavigationService;

/**
 * Implementation of the NavigationService interface. It controls the user's navigation flow.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class NavigationServiceImpl implements NavigationService {

    @Override
    public Class<? extends Activity> getNextActivityType(Activities fromActivity, int annotatorId) {
        Class<? extends Activity> nextActivity = ChoosePlayersActivity.class;

        switch (fromActivity) {
            case CHOOSE_ANNOTATOR:
                nextActivity = handleNavigationFromChooseAnnotatorActivity(annotatorId);
                break;
            case CHOOSE_PLAYERS:
                nextActivity = handleNavigationFromChoosePlayersActivity(annotatorId);
        }

        return nextActivity;
    }

    /**
     * Handle navigation flow for user selections into the {@link com.nbempire.android.magicannotator.component.activity.ChooseAnnotatorActivity}.
     *
     * @param annotatorId
     *         The ID of the annotator that the user has selected.
     *
     * @return The next {@link Activity} for the specified {@code annotatorId}.
     */
    private Class<? extends Activity> handleNavigationFromChooseAnnotatorActivity(int annotatorId) {
        Class<? extends Activity> nextActivity = ChoosePlayersActivity.class;

        switch (annotatorId) {
            case R.string.annotator_truco:
                throw new IllegalArgumentException("Caller activity must define navigation flow for Truco annotator.");
            case R.string.annotator_market:
                nextActivity = MarketAnnotatorActivity.class;
        }

        return nextActivity;
    }

    /**
     * Handle navigation flow for user selections into the {@link com.nbempire.android.magicannotator.component.activity.ChoosePlayersActivity}.
     *
     * @param annotatorId
     *         The ID of the annotator that the user has selected.
     *
     * @return The next {@link Activity} for the specified {@code annotatorId}.
     */
    private Class<? extends Activity> handleNavigationFromChoosePlayersActivity(int annotatorId) {
        Class<? extends Activity> nextActivity = ChoosePlayersActivity.class;

        switch (annotatorId) {
            case R.string.annotator_otro:
                nextActivity = GenericAnnotatorActivity.class;
                break;
            case R.string.annotator_golf:
                nextActivity = GolfAnnotatorActivity.class;
        }
        return nextActivity;
    }

}
