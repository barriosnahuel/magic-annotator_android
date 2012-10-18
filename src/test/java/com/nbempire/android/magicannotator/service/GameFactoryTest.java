/**
 * GameFactoryTest.java Created by: Nahuel Barrios: 24/03/2012, 01:56:32.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import junit.framework.Assert;
import org.junit.Test;

/**
 * This class is for test {@link GameFactoryTest} class using JUnit.
 *
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 01:56:32.
 */
public class GameFactoryTest {

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test
    public final void testGetInstance_withExistentTrucoInput_returnValidGameInstance() {
        Assert.assertEquals(Truco.class, GameFactory.getInstance("Truco").getClass());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test
    public final void testGetInstance_withExistentTuteInput_returnValidGameInstance() {
        Assert.assertEquals(Tute.class, GameFactory.getInstance("Tute").getClass());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withInexistentInput_returnIllegalArgumentException() {
        GameFactory.getInstance("Un juego que no existe");
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withNullInput_returnIllegalArgumentException() {
        GameFactory.getInstance(null);
    }

}
