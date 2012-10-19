/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoServiceImplTest.java Created by: Nahuel Barrios: 28/03/2012, 11:00:57.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.List;

import com.nbempire.android.magicannotator.DummyPlayers;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests the TrucoServiceImpl type that implements the GameService interface.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TrucoServiceImplTest {

    /**
     * The service to test.
     */
    private TrucoServiceImpl trucoServiceImpl = new TrucoServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getFirstTeamLabel()} .
     */
    @Test
    public final void testGetFirstTeamLabel() {
        Assert.assertEquals("Nosotros", trucoServiceImpl.getFirstTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getSecondTeamLabel()} .
     */
    @Test
    public final void testGetSecondTeamLabel() {
        Assert.assertEquals("Ellos", trucoServiceImpl.getSecondTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with2Players_returnLimitOf1PlayersForEachGroup() {
        Assert.assertEquals(1, trucoServiceImpl.getTeamPlayersLimit(2));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with4Players_returnLimitOf2PlayersForEachGroup() {
        Assert.assertEquals(2, trucoServiceImpl.getTeamPlayersLimit(4));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with6Players_returnLimitOf3PlayersForEachGroup() {
        Assert.assertEquals(3, trucoServiceImpl.getTeamPlayersLimit(6));
    }

    @Test
    public final void testHasValidNumberOfSelectedPlayers_withValidSelectedPlayers_returnTrue() {
        Assert.assertTrue("Con 2 jugadores seleccionados, deber�a haber retornado <true>",
                                 trucoServiceImpl.hasValidNumberOfSelectedPlayers(2));
        Assert.assertTrue("Con 4 jugadores seleccionados, deber�a haber retornado <true>",
                                 trucoServiceImpl.hasValidNumberOfSelectedPlayers(4));
        Assert.assertTrue("Con 6 jugadores seleccionados, deber�a haber retornado <true>",
                                 trucoServiceImpl.hasValidNumberOfSelectedPlayers(6));
    }

    @Test
    public final void testHasValidNumberOfSelectedPlayers_withInvalidSelectedPlayers_returnFalse() {
        Assert.assertFalse("Con 1 jugadores seleccionados, deber�a haber retornado <false>",
                                  trucoServiceImpl.hasValidNumberOfSelectedPlayers(1));
        Assert.assertFalse("Con 3 jugadores seleccionados, deber�a haber retornado <false>",
                                  trucoServiceImpl.hasValidNumberOfSelectedPlayers(3));
        Assert.assertFalse("Con 5 jugadores seleccionados, deber�a haber retornado <false>",
                                  trucoServiceImpl.hasValidNumberOfSelectedPlayers(5));
        Assert.assertFalse("Con 7 jugadores seleccionados, deber�a haber retornado <false>",
                                  trucoServiceImpl.hasValidNumberOfSelectedPlayers(7));
    }

    @Test
    public final void testGetInvalidNumberOfTeamsExceptionMessage() {
        Assert.assertEquals("La cantidad de jugadores debe ser 2, 4 o 6.",
                                   trucoServiceImpl.getInvalidNumberOfSelectedPlayersExceptionMessage());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with4SelectedPlayers() throws UserException {
        List<Team> teams;
        teams = trucoServiceImpl.makeTeams(DummyPlayers.forTruco4());
        Assert.assertEquals(2, teams.size());

        Team we = teams.get(0);
        Assert.assertEquals("Nosotros", we.getLabel());
        Assert.assertEquals(2, we.getPlayers().size());

        Team them = teams.get(1);
        Assert.assertEquals("Ellos", them.getLabel());
        Assert.assertEquals(2, them.getPlayers().size());

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void makeTeams_with6SelectedPlayers() throws UserException {
        List<Team> teams;
        teams = trucoServiceImpl.makeTeams(DummyPlayers.forTruco6());
        Assert.assertEquals(2, teams.size());

        Team we = teams.get(0);
        Assert.assertEquals("Nosotros", we.getLabel());
        Assert.assertEquals(3, we.getPlayers().size());

        Team them = teams.get(1);
        Assert.assertEquals("Ellos", them.getLabel());
        Assert.assertEquals(3, them.getPlayers().size());

    }

}
