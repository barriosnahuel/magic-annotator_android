/**
 * PlayerServiceImplTest.java Created by: Nahuel Barrios: 23/03/2012, 05:43:54.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.nbempire.android.magicannotator.domain.Player;

/**
 * This class is for test {@link PlayerServiceImplTest} class using JUnit.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 23/03/2012, 05:43:54.
 */
public class PlayerServiceImplTest {

    private PlayerServiceImpl instance = new PlayerServiceImpl();

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl#parsePlayers(java.util.List)}
     * .
     */
    @Test
    public final void testParsePlayers_withValidPlayers_returnParsedPlayersList() {
        List<String> playersToParse = new ArrayList<String>();
        playersToParse.add("Juan");
        playersToParse.add("Pedro");
        playersToParse.add("Raul");

        List<Player> parsedPlayers = instance.parsePlayers(playersToParse);
        Assert.assertEquals(playersToParse.size(), parsedPlayers.size());
        Assert.assertEquals("Juan", parsedPlayers.get(0).getNickName());
        Assert.assertEquals("Pedro", parsedPlayers.get(1).getNickName());
        Assert.assertEquals("Raul", parsedPlayers.get(2).getNickName());
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl#parsePlayers(java.util.List)}
     * .
     */
    @Test
    public final void testGetExpandablePlayers_withValidPlayers_returnExpandablePlayersList() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));

        List<String> result = instance.getExpandablePlayers(players);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("Nahuel", result.get(0));
        Assert.assertEquals("Fer", result.get(1));
        Assert.assertEquals("Mati", result.get(2));
        Assert.assertEquals("Emi", result.get(3));
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl#parsePlayers(java.util.List)}
     * .
     */
    @Test
    public final void testGetPlayer_withValidPlayersNickName_returnPlayer() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));

        Player result = instance.getPlayer(players, "Nahuel");
        Assert.assertNotNull(result);
        Assert.assertEquals("Nahuel", result.getNickName());
    }

}
