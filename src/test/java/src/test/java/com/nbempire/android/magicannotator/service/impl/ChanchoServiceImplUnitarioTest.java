package com.nbempire.android.magicannotator.service.impl;

import junit.framework.Assert;

import org.junit.Test;

/**
 * TODO : JavaDoc : for ChanchoServiceImplTest.
 * 
 * @author Thales - PNT Equipo 6.
 */
public class ChanchoServiceImplUnitarioTest {

    private ChanchoServiceImpl instance = new ChanchoServiceImpl();

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getFirstTeamLabel()}
     * .
     */
    @Test
    public void testGetFirstTeamLabel() {
        String value = instance.getFirstTeamLabel();
        Assert.assertNotNull(value);
        Assert.assertEquals("Jugadores seleccionados", value);
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getSecondTeamLabel()}
     * .
     */
    @Test
    public void testGetSecondTeamLabel() {
        String value = instance.getSecondTeamLabel();
        Assert.assertNull(value);
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getTeamPlayersLimit(int)}
     * .
     */
    @Test
    public void testGetTeamPlayersLimit_with0SelectedPlayers_returnLimitOf12PlayersForEachGroup() {
        Assert.assertEquals(12, instance.getTeamPlayersLimit(0));
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#hasValidNumberOfSelectedPlayers(int)}
     * .
     */
    @Test
    public void testHasValidNumberOfSelectedPlayers_with0SelectedPlayers_returnFalse() {
        Assert.assertFalse("No se seleccionaron la cantidad de jugadores necesarios", instance.hasValidNumberOfSelectedPlayers(0));
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#hasValidNumberOfSelectedPlayers(int)}
     * .
     */
    @Test
    public void testHasValidNumberOfSelectedPlayers_with5SelectedPlayers_returnTrue() {
        Assert.assertTrue(instance.hasValidNumberOfSelectedPlayers(5));
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getInvalidNumberOfSelectedPlayersExceptionMessage()}
     * .
     */
    @Test
    public void testGetInvalidNumberOfSelectedPlayersExceptionMessage() {
        String message = instance.getInvalidNumberOfSelectedPlayersExceptionMessage();
        Assert.assertNotNull(message);
        Assert.assertEquals("Se deben seleccionar entre 3 y 12 jugadores.", message);
    }

}
