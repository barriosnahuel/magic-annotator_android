/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 12:19hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import com.nbempire.android.magicannotator.GameKeys;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.AnnotatorService;

/**
 * TODO : Javadoc for new type.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class AnnotatorServiceImpl implements AnnotatorService {

    @Override
    public int getAnnotatorId(String userSelection) {
        if (userSelection == null) {
            throw new IllegalArgumentException("User selection musn't be null.");
        }

        int annotatorId;
        if (userSelection.equals(GameKeys.GAME_NAME_CHANCHO)) {
            annotatorId = R.string.gamename_chancho;

        } else if (userSelection.equals(GameKeys.GAME_NAME_MARKET)) {
            annotatorId = R.string.gamename_market;

        } else if (userSelection.equals(GameKeys.GAME_NAME_OTHER)) {
            annotatorId = R.string.gamename_otro;

        } else if (userSelection.equals(GameKeys.GAME_NAME_TRUCO)) {
            annotatorId = R.string.gamename_truco;

        } else if (userSelection.equals(GameKeys.GAME_NAME_TUTE)) {
            annotatorId = R.string.gamename_tute;

        } else {
            throw new IllegalArgumentException("There isn't any annotator with description: " + userSelection);
        }

        return annotatorId;
    }

    @Override
    public Game getAnnotatorGame(int annotatorId) {
        Game aGame = null;

        switch (annotatorId) {
            case R.string.gamename_chancho:
                aGame = new Chancho();
                break;
            case R.string.gamename_truco:
                aGame = new Truco();
                break;
            case R.string.gamename_tute:
                aGame = new Tute();
                break;
        }

        return aGame;
    }
}
