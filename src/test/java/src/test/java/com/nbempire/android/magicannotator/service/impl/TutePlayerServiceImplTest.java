/**
 * TutePlayerServiceImplTest.java Created by: Nahuel Barrios: 11/04/2012, 00:27:52.
 */
package com.nbempire.android.magicannotator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.domain.Player;

/**
 * TODO : JavaDoc : for TutePlayerServiceImplTest.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 11/04/2012, 00:27:52.
 */
public class TutePlayerServiceImplTest {

    private TutePlayerServiceImpl instance = new TutePlayerServiceImpl();

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.TutePlayerServiceImpl#addCapote(com.nbempire.android.magicannotator.domain.Player)}
     * .
     */
    @Test
    public final void testAddCapote_withValidPlayerWithoutScores_setScoresTo1() {
        Player aPlayer = new Player("Juan");
        instance.addCapote(aPlayer);
        Assert.assertNotNull(aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE));
        Assert.assertEquals(1, aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE).intValue());
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.TutePlayerServiceImpl#addCapote(com.nbempire.android.magicannotator.domain.Player)}
     * .
     */
    @Test
    public final void testAddCapote_withValidPlayerWithScoreAt1_setScoresTo2() {
        Player aPlayer = new Player("Juan");
        instance.addCapote(aPlayer);
        Assert.assertNotNull(aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE));
        Assert.assertEquals(1, aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE).intValue());

        instance.addCapote(aPlayer);
        Assert.assertNotNull(aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE));
        Assert.assertEquals(2, aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_CAPOTE).intValue());
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.TutePlayerServiceImpl#addTute(com.nbempire.android.magicannotator.domain.Player)}
     * .
     */
    @Test
    public final void testAddTute_withValidPlayerWithoutScores_setScoresTo1() {
        Player aPlayer = new Player("Juan");
        instance.addTute(aPlayer);
        Assert.assertNotNull(aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_TUTE));
        Assert.assertEquals(1, aPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_TUTE).intValue());
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.TutePlayerServiceImpl#addTute(com.nbempire.android.magicannotator.domain.Player)}
     * .
     */
    @Test
    public final void testAddLostHand_withValidParametersWithoutScores_setScoresTo1() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Nahuel"));
        players.add(new Player("Fer"));
        players.add(new Player("Mati"));
        players.add(new Player("Emi"));
        players.add(new Player("Franco"));

        List<String> playersName = new ArrayList<String>();
        playersName.add("Nahuel");
        playersName.add("Fer");
        playersName.add("Mati");

        instance.addLostHand(players, playersName);

        for (Player eachPlayer : players) {
            if (playersName.contains(eachPlayer.getNickName())) {
                Assert.assertTrue("No se setteo el score en el jugador correcto.", eachPlayer.getNickName().equals("Nahuel")
                                                                                   || eachPlayer.getNickName().equals("Fer")
                                                                                   || eachPlayer.getNickName().equals("Mati"));
                Assert.assertNotNull(eachPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND));
                Assert.assertEquals(1, eachPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND).intValue());
            } else {
                Assert.assertFalse("No se setteo el score en el jugador correcto.", eachPlayer.getNickName().equals("Nahuel")
                                                                                    || eachPlayer.getNickName().equals("Fer")
                                                                                    || eachPlayer.getNickName().equals("Mati"));
                Assert.assertNull(eachPlayer.getScores().get(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND));
            }
        }
    }

}
