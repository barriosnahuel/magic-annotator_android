/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 16:06hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.List;

import com.nbempire.android.magicannotator.DummyTeams;
import com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException;
import com.nbempire.android.magicannotator.service.GameService;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests the GameServiceImpl abstract type.
 * <p/>
 * It only test the non-abstract methods.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class GameServiceImplTest {

    /**
     * The service that we are testing.
     */
    private final GameService gameService = new GameServiceTestImpl();

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = TeamShouldHasPlayersException.class)
    public final void getExpandableTeams_with2TeamsWithoutPlayers_throwTeamShouldHasPlayersException() throws TeamShouldHasPlayersException {
        gameService.getExpandableTeams(DummyTeams.withoutPlayers());
    }

    @Test
    public final void getExpandableTeams_with2TeamsWith2PlayersPerTeam() throws TeamShouldHasPlayersException {
        ExpandableList expandableTeams = gameService.getExpandableTeams(DummyTeams.with2PlayersPerTeam(new String[]{"Nosotros", "Ellos"}));
        Assert.assertNotNull("The list of teams musn't be null.", expandableTeams);

        for (ExpandableGroup eachGroup : expandableTeams) {
            Assert.assertNotNull("Team label musn't be null.", eachGroup.getLabel());

            List<String> children = eachGroup.getChildren();
            Assert.assertFalse("Team must has players.", children.isEmpty());

            Assert.assertEquals(2, children.size());
        }
    }

    /**
     * Dummy type that extends the abstract type we want to test to be able to instantiate it.
     *
     * @author Nahuel Barrios.
     * @since 15
     */
    @SuppressWarnings("ALL")
    private class GameServiceTestImpl extends GameServiceImpl {
        @Override
        protected String getFirstTeamLabel() {
            return null;
        }

        @Override
        protected String getSecondTeamLabel() {
            return null;
        }

        @Override
        protected int getTeamPlayersLimit(int selectedPlayers) {
            return 0;
        }

        @Override
        protected boolean hasValidNumberOfSelectedPlayers(int numberOfPlayers) {
            return false;
        }

        @Override
        protected String getInvalidNumberOfSelectedPlayersExceptionMessage() {
            return null;
        }
    }

}
