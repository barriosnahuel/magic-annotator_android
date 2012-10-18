/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TuteServiceImplUnitarioTest.java Created by: Nahuel Barrios: 28/03/2012, 10:55:15.
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
 * TODO : JavaDoc : for TuteServiceImplUnitarioTest.
 *
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 28/03/2012, 10:55:15.
 */
public class TuteServiceImplUnitarioTest {

    private TuteServiceImpl instance = new TuteServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getFirstTeamLabel()} .
     */
    @Test
    public final void testGetFirstTeamLabel() {
        Assert.assertEquals("Grupo 1", instance.getFirstTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getSecondTeamLabel()} .
     */
    @Test
    public final void testGetSecondTeamLabel() {
        Assert.assertEquals("Grupo 2", instance.getSecondTeamLabel());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with3Players_returnLimitOf6PlayersForEachGroup() {
        Assert.assertEquals(6, instance.getTeamPlayersLimit(3));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with6Players_returnLimitOf6PlayersForEachGroup() {
        Assert.assertEquals(6, instance.getTeamPlayersLimit(6));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with7Players_returnLimitOf4PlayersForEachGroup() {
        Assert.assertEquals(4, instance.getTeamPlayersLimit(7));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with8Players_returnLimitOf4PlayersForEachGroup() {
        Assert.assertEquals(4, instance.getTeamPlayersLimit(8));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with9Players_returnLimitOf5PlayersForEachGroup() {
        Assert.assertEquals(5, instance.getTeamPlayersLimit(9));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#hasValidNumberOfSelectedPlayers(int)} .
     */
    @Test
    public final void testHasValidNumberOfSelectedPlayers_withValidSelectedPlayers_returnTrue() {
        Assert.assertTrue("Con 3 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(3));
        Assert.assertTrue("Con 6 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(6));
        Assert.assertTrue("Con 7 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(7));
        Assert.assertTrue("Con 8 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(8));
        Assert.assertTrue("Con 12 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(12));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#hasValidNumberOfSelectedPlayers(int)} .
     */
    @Test
    public final void testHasValidNumberOfSelectedPlayers_withInvalidSelectedPlayers_returnFalse() {
        Assert.assertFalse("Con 1 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(1));
        Assert.assertFalse("Con 2 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(2));
        Assert.assertFalse("Con 13 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(13));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TuteServiceImpl#getInvalidNumberOfSelectedPlayersExceptionMessage()}
     * .
     */
    @Test
    public final void testGetInvalidNumberOfSelectedPlayersExceptionMessage() {
        Assert.assertFalse("Con 2 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(2));
        Assert.assertTrue("Con 3 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(3));
        Assert.assertTrue("Con 6 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(6));
        Assert.assertTrue("Con 7 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(7));
        Assert.assertTrue("Con 8 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(8));
        Assert.assertTrue("Con 12 jugadores seleccionados, deber�a haber retornado <true>",
                                 instance.hasValidNumberOfSelectedPlayers(12));
        Assert.assertFalse("Con 13 jugadores seleccionados, deber�a haber retornado <false>",
                                  instance.hasValidNumberOfSelectedPlayers(13));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with3SelectedPlayers_return1Group() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTute3());
            Assert.assertEquals(1, teams.size());

            Team we = teams.get(0);
            Assert.assertEquals("Grupo 1", we.getLabel());
            Assert.assertEquals(3, we.getPlayers().size());
        } catch (UserException e) {
            // TODO : Exception : Terminate this exception log.
            e.printStackTrace();
        }

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with6SelectedPlayers_return1Group() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTute6());
            Assert.assertEquals(1, teams.size());

            Team we = teams.get(0);
            Assert.assertEquals("Grupo 1", we.getLabel());
            Assert.assertEquals(6, we.getPlayers().size());
        } catch (UserException userException) {
            // TODO : Exception : Terminate this exception log.
            userException.printStackTrace();
        }

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with7SelectedPlayers_return2Groups() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTute7());
            Assert.assertEquals(2, teams.size());

            Team firstGroup = teams.get(0);
            Assert.assertEquals("Grupo 1", firstGroup.getLabel());
            Assert.assertEquals(4, firstGroup.getPlayers().size());

            Team secondGroup = teams.get(1);
            Assert.assertEquals("Grupo 2", secondGroup.getLabel());
            Assert.assertEquals(3, secondGroup.getPlayers().size());
        } catch (UserException userException) {
            // TODO : Exception : Terminate this exception log.
            userException.printStackTrace();
        }
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with8SelectedPlayers_return2Groups() {
        List<Team> teams;
        try {
            teams = instance.makeTeams(DummyPlayers.forTute8());
            Assert.assertEquals(2, teams.size());

            Team firstGroup = teams.get(0);
            Assert.assertEquals("Grupo 1", firstGroup.getLabel());
            Assert.assertEquals(4, firstGroup.getPlayers().size());

            Team secondGroup = teams.get(1);
            Assert.assertEquals("Grupo 2", secondGroup.getLabel());
            Assert.assertEquals(4, secondGroup.getPlayers().size());
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