/**
 * ServiceFactoryTest.java Created by: Nahuel Barrios: 24/03/2012, 02:12:27.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl;
import com.nbempire.android.magicannotator.service.impl.TuteServiceImpl;
import junit.framework.Assert;
import org.junit.Test;

/**
 * This class is for test {@link ServiceFactoryTest} class using JUnit.
 *
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 02:12:27.
 */
public class ServiceFactoryTest {

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.ServiceFactory#getInstance(com.nbempire.android.magicannotator.domain.game.Game)}
     * .
     */
    @Test
    public final void testGetInstance_withExistentTrucoInput_returnValidServiceInstance() {
        Assert.assertEquals(TrucoServiceImpl.class, ServiceFactory.getInstance(new Truco()).getClass());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test
    public final void testGetInstance_withExistentTuteInput_returnValidGameInstance() {
        Assert.assertEquals(TuteServiceImpl.class, ServiceFactory.getInstance(new Tute()).getClass());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withInexistentInput_returnIllegalArgumentException() {
        ServiceFactory.getInstance(new InexistentGame());
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.service.GameFactory#getInstance(java.lang.String)} .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withNullInput_returnIllegalArgumentException() {
        ServiceFactory.getInstance(null);
    }

    /**
     * Es una clase de prueba que hereda de Game para poder utilizarla, pero no existe como un juego registrado en la app.
     *
     * @author Nahuel Barrios.
     * @version 1.0.
     * @since 24/03/2012, 09:13:02.
     */
    public class InexistentGame extends Game {

        /**
         * @author Nahuel Barrios.
         */
        private static final long serialVersionUID = 6199586921004785003L;

        public InexistentGame() {
            super(2, 3);
        }

    }

}
