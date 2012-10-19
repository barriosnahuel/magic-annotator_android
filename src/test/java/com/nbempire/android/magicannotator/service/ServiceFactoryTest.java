/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

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
 * @since 1
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

    @Test
    public final void testGetInstance_withExistentTuteInput_returnValidGameInstance() {
        Assert.assertEquals(TuteServiceImpl.class, ServiceFactory.getInstance(new Tute()).getClass());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withInexistentInput_throwIllegalArgumentException() {
        ServiceFactory.getInstance(new InexistentGame());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withNullInput_throwIllegalArgumentException() {
        ServiceFactory.getInstance(null);
    }

    /**
     * Es una clase de prueba que hereda de Game para poder utilizarla, pero no existe como un juego registrado en la app.
     *
     * @author Nahuel Barrios.
     * @version 1.0.
     * @since 24/03/2012, 09:13:02.
     */
    private class InexistentGame extends Game {

        /**
         * The serialVersionUID of this type.
         */
        private static final long serialVersionUID = 6199586921004785003L;

        /**
         * Constructor method for this type.
         */
        public InexistentGame() {
            super(2, 3);
        }

    }

}
