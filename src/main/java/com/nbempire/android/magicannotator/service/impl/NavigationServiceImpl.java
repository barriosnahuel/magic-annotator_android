/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 09:43hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import android.app.Activity;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.ChoosePlayersActivity;
import com.nbempire.android.magicannotator.component.activity.MarketAnnotatorActivity;
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
    public Class<? extends Activity> getNextActivityType(Activities chooseAnnotator, int annotatorId) {
        Class<? extends Activity> nextActivity = ChoosePlayersActivity.class;

        switch (annotatorId) {
            case R.string.gamename_truco:
                throw new IllegalArgumentException("Caller activity must define navigation flow for Truco annotator.");
            case R.string.gamename_market:
                nextActivity = MarketAnnotatorActivity.class;
        }

        return nextActivity;
    }

}
