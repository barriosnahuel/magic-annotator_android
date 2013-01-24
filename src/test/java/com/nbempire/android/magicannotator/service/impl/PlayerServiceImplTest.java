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
 * PlayerServiceImplTest.java Created by: Nahuel Barrios: 23/03/2012, 05:43:54.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.domain.Player;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for test {@link PlayerServiceImplTest} class using JUnit.
 *
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 23/03/2012, 05:43:54.
 */
public class PlayerServiceImplTest {

    private final PlayerServiceImpl playerServiceImpl = new PlayerServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl#createPlayers(java.util.List)} .
     */
    @Test
    public final void testParsePlayers_withValidPlayers_returnParsedPlayersList() {
        List<String> playersToParse = new ArrayList<String>();
        playersToParse.add("Juan");
        playersToParse.add("Pedro");
        playersToParse.add("Raul");

        List<Player> parsedPlayers = playerServiceImpl.createPlayers(playersToParse);
        Assert.assertEquals(playersToParse.size(), parsedPlayers.size());
        Assert.assertEquals("Juan", parsedPlayers.get(0).getNickName());
        Assert.assertEquals("Pedro", parsedPlayers.get(1).getNickName());
        Assert.assertEquals("Raul", parsedPlayers.get(2).getNickName());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl#createPlayers(java.util.List)} .
     */
    @Test
    public final void testGetExpandablePlayers_withValidPlayers_returnExpandablePlayersList() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));

        List<String> result = playerServiceImpl.getExpandablePlayers(players);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("Nahuel", result.get(0));
        Assert.assertEquals("Fer", result.get(1));
        Assert.assertEquals("Mati", result.get(2));
        Assert.assertEquals("Emi", result.get(3));
    }

}
