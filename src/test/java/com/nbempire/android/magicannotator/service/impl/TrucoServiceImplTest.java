/*
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
 * TrucoServiceImplTest.java Created by: Nahuel Barrios: 28/03/2012, 11:00:57.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.DummyPlayers;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.exception.UserException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
    private final TrucoServiceImpl trucoServiceImpl = new TrucoServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with2Players_returnLimitOf1PlayersForEachGroup() {
        assertEquals(1, trucoServiceImpl.getTeamPlayersLimit(2));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with4Players_returnLimitOf2PlayersForEachGroup() {
        assertEquals(2, trucoServiceImpl.getTeamPlayersLimit(4));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public final void testGetTeamPlayersLimit_with6Players_returnLimitOf3PlayersForEachGroup() {
        assertEquals(3, trucoServiceImpl.getTeamPlayersLimit(6));
    }

    @Test
    public final void testHasValidNumberOfSelectedPlayers_withValidSelectedPlayers_returnTrue() {
        assertTrue("With 2 selected players, must return <true>.",
                   trucoServiceImpl.hasValidNumberOfSelectedPlayers(2));

        assertTrue("With 4 selected players, must return <true>.",
                   trucoServiceImpl.hasValidNumberOfSelectedPlayers(4));

        assertTrue("With 6 selected players, must return <true>.",
                   trucoServiceImpl.hasValidNumberOfSelectedPlayers(6));
    }

    @Test
    public final void testHasValidNumberOfSelectedPlayers_withInvalidSelectedPlayers_returnFalse() {
        assertFalse("Con 1 jugadores seleccionados, deber�a haber retornado <false>",
                    trucoServiceImpl.hasValidNumberOfSelectedPlayers(1));
        assertFalse("Con 3 jugadores seleccionados, deber�a haber retornado <false>",
                    trucoServiceImpl.hasValidNumberOfSelectedPlayers(3));
        assertFalse("Con 5 jugadores seleccionados, deber�a haber retornado <false>",
                    trucoServiceImpl.hasValidNumberOfSelectedPlayers(5));
        assertFalse("Con 7 jugadores seleccionados, deber�a haber retornado <false>",
                    trucoServiceImpl.hasValidNumberOfSelectedPlayers(7));
    }

    @Test
    public final void testGetInvalidNumberOfTeamsExceptionMessage() {
        assertEquals("La cantidad de jugadores debe ser 2, 4 o 6.",
                     trucoServiceImpl.getInvalidNumberOfSelectedPlayersExceptionMessage());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void testMakeTeams_with4SelectedPlayers() throws UserException {
        List<Team> teams;
        teams = trucoServiceImpl.makeTeams(DummyPlayers.forTruco4());
        assertEquals(2, teams.size());

        Team we = teams.get(0);
        assertEquals("Nosotros", we.getLabel());
        assertEquals(2, we.getPlayers().size());

        Team them = teams.get(1);
        assertEquals("Ellos", them.getLabel());
        assertEquals(2, them.getPlayers().size());

    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.GameServiceImpl#makeTeams(java.util.List)} .
     */
    @Test
    public final void makeTeams_with6SelectedPlayers() throws UserException {
        List<Team> teams;
        teams = trucoServiceImpl.makeTeams(DummyPlayers.forTruco6());
        assertEquals(2, teams.size());

        Team we = teams.get(0);
        assertEquals("Nosotros", we.getLabel());
        assertEquals(3, we.getPlayers().size());

        Team them = teams.get(1);
        assertEquals("Ellos", them.getLabel());
        assertEquals(3, them.getPlayers().size());
    }

}
