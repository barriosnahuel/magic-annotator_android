/*
 * Magic Annotator - The only thing you need to write down whatever you want.
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
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 12:19hs.
 */
package com.nbempire.android.magicannotator.service.impl;

import android.app.Activity;
import com.nbempire.android.magicannotator.MagicAnnotatorApp;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.annotator.ChanchoAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.annotator.TrucoAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.annotator.TuteAnnotatorActivity;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.AnnotatorService;

/**
 * Implementation of the AnnotatorService.
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
        if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_chancho))) {
            annotatorId = R.string.annotator_chancho;

        } else if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_golf))) {
            annotatorId = R.string.annotator_golf;

        } else if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_market))) {
            annotatorId = R.string.annotator_market;

        } else if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_otro))) {
            annotatorId = R.string.annotator_otro;

        } else if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_truco))) {
            annotatorId = R.string.annotator_truco;

        } else if (userSelection.equals(MagicAnnotatorApp.getContext().getText(R.string.annotator_tute))) {
            annotatorId = R.string.annotator_tute;

        } else {
            throw new IllegalArgumentException("There isn't any annotator with description: " + userSelection);
        }

        return annotatorId;
    }

    @Override
    public Game getAnnotatorGame(int annotatorId) {
        Game aGame = null;

        switch (annotatorId) {
            case R.string.annotator_chancho:
                aGame = new Chancho();
                break;
            case R.string.annotator_truco:
                aGame = new Truco();
                break;
            case R.string.annotator_tute:
                aGame = new Tute();
                break;
        }

        return aGame;
    }

    @Override
    public Class<? extends Activity> get(Game game) throws IllegalArgumentException {
        Class<? extends Activity> annotatorActivity;

        if (game instanceof Truco) {
            annotatorActivity = TrucoAnnotatorActivity.class;

        } else if (game instanceof Chancho) {
            annotatorActivity = ChanchoAnnotatorActivity.class;

        } else if (game instanceof Tute) {
            annotatorActivity = TuteAnnotatorActivity.class;

        } else {
            throw new IllegalArgumentException("The specified Game is not a valid game.");
        }
        return annotatorActivity;
    }
}
