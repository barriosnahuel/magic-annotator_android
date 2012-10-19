/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 11:21hs.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.MarketAnnotatorActivity;
import com.nbempire.android.magicannotator.domain.Activities;
import com.nbempire.android.magicannotator.service.impl.NavigationServiceImpl;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests the NavigationService interface.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class NavigationServiceTest {

    private final NavigationService navigationService = new NavigationServiceImpl();

    @Test
    public void getNextActivityType_fromChooseAnnotatorWithChanchoUserSelection_returnChoosePlayersActivity() {
        Class<? extends Activity> nextActivity = navigationService.getNextActivityType(Activities.CHOOSE_ANNOTATOR, R.string.annotator_chancho);

        Assert.assertNotNull("The nextActivity musn't be null.", nextActivity);
        Assert.assertEquals(Activities.CHOOSE_PLAYERS.getActivityTypeName(), nextActivity.getSimpleName());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void getNextActivityType_fromChooseAnnotatorWithTrucoUserSelection_throwIllegalArgumentException() {
        navigationService.getNextActivityType(Activities.CHOOSE_ANNOTATOR, R.string.annotator_truco);
    }

    @Test
    public void getNextActivityType_fromChooseAnnotatorWithSuperMarketUserSelection_throwIllegalArgumentException() {
        Class<? extends Activity> nextActivity = navigationService.getNextActivityType(Activities.CHOOSE_ANNOTATOR, R.string.annotator_market);
        Assert.assertNotNull("The nextActivity musn't be null.", nextActivity);
        Assert.assertEquals(MarketAnnotatorActivity.class.getSimpleName(), nextActivity.getSimpleName());
    }

}
