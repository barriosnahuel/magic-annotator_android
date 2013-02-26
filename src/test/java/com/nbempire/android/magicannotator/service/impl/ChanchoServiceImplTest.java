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

package com.nbempire.android.magicannotator.service.impl;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests the ChanchoServiceImpl type that implements the GameService interface.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ChanchoServiceImplTest {

    private final ChanchoServiceImpl chanchoServiceImpl = new ChanchoServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getTeamPlayersLimit(int)} .
     */
    @Test
    public void testGetTeamPlayersLimit_with0SelectedPlayers_returnLimitOf12PlayersForEachGroup() {
        Assert.assertEquals(12, chanchoServiceImpl.getTeamPlayersLimit(0));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#hasValidNumberOfSelectedPlayers(int)} .
     */
    @Test
    public void testHasValidNumberOfSelectedPlayers_with0SelectedPlayers_returnFalse() {
        Assert.assertFalse("No se seleccionaron la cantidad de jugadores necesarios", chanchoServiceImpl.hasValidNumberOfSelectedPlayers(0));
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#hasValidNumberOfSelectedPlayers(int)} .
     */
    @Test
    public void testHasValidNumberOfSelectedPlayers_with5SelectedPlayers_returnTrue() {
        Assert.assertTrue(chanchoServiceImpl.hasValidNumberOfSelectedPlayers(5));
    }

}
