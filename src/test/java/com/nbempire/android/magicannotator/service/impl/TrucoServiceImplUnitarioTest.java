/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoServiceImplUnitarioTest.java Created by: Nahuel Barrios: 28/03/2012, 11:00:57.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.List;

import com.nbempire.android.magicannotator.DummyPlayers;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * TODO : JavaDoc : for TrucoServiceImplUnitarioTest.
 *
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 28/03/2012, 11:00:57.
 */
public class TrucoServiceImplUnitarioTest {

    private TrucoServiceImpl instance = new TrucoServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getFirstTeamLabel()} .
     */
    @Test
    public final void testGetFirstTeamLabel() {
        Assert.assertEquals("Nosotros", instance.getFirstTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getSecondTeamLabel()} .
     */
    @Test
    public final void testGetSecondTeamLabel() {
        Assert.assertEquals("Ellos", instance.getSecondTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with2Players_returnLimitOf1PlayersForEachGroup() {
        Assert.assertEquals(1, instance.getTeamPlayersLimit(2));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with4Players_returnLimitOf2PlayersForEachGroup() {
        Assert.assertEquals(2, instance.getTeamPlayersLimit(4));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with6Players_returnLimitOf3PlayersForEachGroup() {
        Assert.assertEquals(3, instance.getTeamPlayersLimit(6));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#hasValidNumberOfSelectedPlayers()} .
     */
    @Test
    public final void testHasValidNumberOfSelectedPlayers_withValidSelectedPlayers_returnTrue() {
        Assert.assertTrue("Con 2 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(2));
        Assert.assertTrue("Con 4 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(4));
        Assert.assertTrue("Con 6 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(6));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#hasValidNumberOfSelectedPlayers()} .
     */
    @Test
    public final void testHasValidNumberOfSelectedPlayers_withInvalidSelectedPlayers_returnFalse() {
        Assert.assertFalse("Con 1 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(1));
        Assert.assertFalse("Con 3 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(3));
        Assert.assertFalse("Con 5 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(5));
        Assert.assertFalse("Con 7 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(7));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getInvalidNumberOfSelectedPlayersExceptionMessage(com.nbempire.android.magicannotator.domain.game.Game)}
     * .
     */
    @Test
    public final void testGetInvalidNumberOfTeamsExceptionMessage() {
        Assert.assertEquals("La cantidad de jugadores debe ser 2, 4 o 6.",
                                   instance.getInvalidNumberOfSelectedPlayersExceptionMessage());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with4SelectedPlayers() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTruco4());
            Assert.assertEquals(2, teams.size());

            Team we = teams.get(0);
            Assert.assertEquals("Nosotros", we.getLabel());
            Assert.assertEquals(2, we.getPlayers().size());

            Team them = teams.get(1);
            Assert.assertEquals("Ellos", them.getLabel());
            Assert.assertEquals(2, them.getPlayers().size());
        } catch (UserException userException) {
            // TODO : Exception : Terminate this exception log.
            userException.printStackTrace();
        }

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with6SelectedPlayers() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTruco6());
            Assert.assertEquals(2, teams.size());

            Team we = teams.get(0);
            Assert.assertEquals("Nosotros", we.getLabel());
            Assert.assertEquals(3, we.getPlayers().size());

            Team them = teams.get(1);
            Assert.assertEquals("Ellos", them.getLabel());
            Assert.assertEquals(3, them.getPlayers().size());
        } catch (UserException userException) {
            // TODO : Exception : Terminate this exception log.
            userException.printStackTrace();
        }

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#getExpandableTeams(java.util.List)} .
     */
    @Test
    @Ignore
    public final void testGetExpandableTeams() {
        fail("Not yet implemented");
    }

}
