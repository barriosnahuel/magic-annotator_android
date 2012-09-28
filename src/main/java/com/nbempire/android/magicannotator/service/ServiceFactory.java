/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * ServiceFactoryImpl.java Created by: Nahuel Barrios: 23/03/2012, 06:48:00.
 */
package com.nbempire.android.magicannotator.service;

import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.impl.ChanchoServiceImpl;
import com.nbempire.android.magicannotator.service.impl.TrucoServiceImpl;
import com.nbempire.android.magicannotator.service.impl.TuteServiceImpl;

/**
 * TODO : JavaDoc : for ServiceFactoryImpl.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public abstract class ServiceFactory {

    /**
     * TODO : JavaDoc : for ServiceFactory.getInstance()
     *
     * @param aGame
     *
     * @return {@link GameService}.
     *
     * @throws IllegalArgumentException
     *         when there isn't any Service for the input {@link Game}.
     * @since 1
     */
    public static GameService getInstance(Game aGame) throws IllegalArgumentException {
        if (aGame == null) {
            throw new IllegalArgumentException("El juego no puede ser null.");
        } else {
            Class<? extends Game> gameClass = aGame.getClass();
            if (gameClass.equals(Chancho.class)) {
                return new ChanchoServiceImpl();
            } else if (gameClass.equals(Truco.class)) {
                return new TrucoServiceImpl();
            } else if (gameClass.equals(Tute.class)) {
                return new TuteServiceImpl();
            } else {
                throw new IllegalArgumentException("El juego no existeo no esta configurado correctamente.");
            }

        }
    }

}
