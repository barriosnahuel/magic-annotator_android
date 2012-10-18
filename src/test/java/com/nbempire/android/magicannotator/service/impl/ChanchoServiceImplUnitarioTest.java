package com.nbempire.android.magicannotator.service.impl;

import junit.framework.Assert;
import org.junit.Test;

/**
 * TODO : JavaDoc : for ChanchoServiceImplTest.
 *
 * @author Thales - PNT Equipo 6.
 */
public class ChanchoServiceImplUnitarioTest {

    private ChanchoServiceImpl chanchoServiceImpl = new ChanchoServiceImpl();

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getFirstTeamLabel()} .
     */
    @Test
    public void testGetFirstTeamLabel() {
        String value = chanchoServiceImpl.getFirstTeamLabel();
        Assert.assertNotNull(value);
        Assert.assertEquals("Jugadores seleccionados", value);
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getSecondTeamLabel()} .
     */
    @Test
    public void testGetSecondTeamLabel() {
        String value = chanchoServiceImpl.getSecondTeamLabel();
        Assert.assertEquals("", value);
    }

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

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl#getInvalidNumberOfSelectedPlayersExceptionMessage()}
     * .
     */
    @Test
    public void testGetInvalidNumberOfSelectedPlayersExceptionMessage() {
        String message = chanchoServiceImpl.getInvalidNumberOfSelectedPlayersExceptionMessage();
        Assert.assertNotNull(message);
        Assert.assertEquals("Se deben seleccionar entre 3 y 12 jugadores.", message);
    }

}
