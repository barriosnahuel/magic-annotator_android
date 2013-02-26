package com.nbempire.android.magicannotator.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test type for the Service {@link GolfServiceImpl}.
 * <p/>
 * Created on 2/25/13, at 9:35 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 19.
 */
public class GolfServiceImplTest {

    private final GolfServiceImpl golfService = new GolfServiceImpl();

    /**
     * Test method for getTeamPlayersLimit().
     */
    @Test
    public void testgetTeamPlayersLimit_withValidNumberOfSelectedPlayers_returnSameValue() throws Exception {
        assertEquals(2, golfService.getTeamPlayersLimit(2));
    }

    /**
     * Test method for hasValidNumberOfSelectedPlayers().
     */
    @Test
    public void testhasValidNumberOfSelectedPlayers_withValidNumberOfSelectedPlayers_returnTrue() throws Exception {
        assertTrue("Must return true.", golfService.hasValidNumberOfSelectedPlayers(2));
    }

    /**
     * Test method for hasValidNumberOfSelectedPlayers().
     */
    @Test
    public void testhasValidNumberOfSelectedPlayers_withoutSelectedPlayers_returnFalse() throws Exception {
        assertFalse("Must return false.", golfService.hasValidNumberOfSelectedPlayers(0));
    }

    /**
     * Test method for hasValidNumberOfSelectedPlayers().
     */
    @Test
    public void testhasValidNumberOfSelectedPlayers_withInvalidNumberOfSelectedPlayers_returnFalse() throws Exception {
        assertFalse("Must return false.", golfService.hasValidNumberOfSelectedPlayers(-5));
    }

}
