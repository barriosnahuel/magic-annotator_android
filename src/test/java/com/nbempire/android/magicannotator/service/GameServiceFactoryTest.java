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
 * GameServiceFactoryTest.java Created by: Nahuel Barrios: 24/03/2012, 02:12:27.
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
 * This class is for test {@link GameServiceFactoryTest} class using JUnit.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class GameServiceFactoryTest {

    /**
     * Test method for {@link GameServiceFactory#getInstance(com.nbempire.android.magicannotator.domain.game.Game)} .
     */
    @Test
    public final void testGetInstance_withExistentTrucoInput_returnValidServiceInstance() {
        Assert.assertEquals(TrucoServiceImpl.class, GameServiceFactory.getInstance(new Truco()).getClass());
    }

    @Test
    public final void testGetInstance_withExistentTuteInput_returnValidGameInstance() {
        Assert.assertEquals(TuteServiceImpl.class, GameServiceFactory.getInstance(new Tute()).getClass());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withInexistentInput_throwIllegalArgumentException() {
        GameServiceFactory.getInstance(new InexistentGame());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public final void testGetInstance_withNullInput_throwIllegalArgumentException() {
        GameServiceFactory.getInstance(null);
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

    }

}
