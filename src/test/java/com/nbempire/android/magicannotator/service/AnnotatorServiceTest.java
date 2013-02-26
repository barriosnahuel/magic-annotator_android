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
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 12:18hs.
 */
package com.nbempire.android.magicannotator.service;

import android.app.Activity;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.domain.game.Tute;
import com.nbempire.android.magicannotator.service.impl.AnnotatorServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the AnnotatorService interface.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public class AnnotatorServiceTest {

    private static final String MUST_BE_INSTANCE_OF = "Must be an instance of ";

    private static final String RETURNED_GAME_MUST_NOT_BE_NULL = "Returned Game musn't be null.";

    private static final String RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL = "The returned annotator activity musn't be null.";

    private static final String ANNOTATOR_ACTIVITY_TYPE_SUFFIX = "AnnotatorActivity";

    private static final String TYPE_NAME_MUST_HAVE_SUFFIX = "The type's simple name must ends with the suffix: " +
                                                             ANNOTATOR_ACTIVITY_TYPE_SUFFIX;

    /**
     * The service to test.
     */
    private final AnnotatorService annotatorService = new AnnotatorServiceImpl();

    @Test
    public void getAnnotatorGame_withChanchoInput_returnChanchoGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_chancho);
        assertNotNull("Returned Game musn't be null.");
        assertTrue(MUST_BE_INSTANCE_OF + Chancho.class.getSimpleName(), aGame instanceof Chancho);
    }

    @Test
    public void getAnnotatorGame_withTrucoInput_returnTrucoGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_truco);
        assertNotNull(RETURNED_GAME_MUST_NOT_BE_NULL, aGame);
        assertTrue(MUST_BE_INSTANCE_OF + Truco.class.getSimpleName(), aGame instanceof Truco);
    }

    @Test
    public void getAnnotatorGame_withTuteInput_returnTuteGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_tute);
        assertNotNull(RETURNED_GAME_MUST_NOT_BE_NULL, aGame);
        assertTrue(MUST_BE_INSTANCE_OF + Tute.class.getSimpleName(), aGame instanceof Tute);
    }

    @Test
    public void getAnnotatorGame_withMarketInput_returnNull() {
        assertNull("Returned Game must be null.", annotatorService.getAnnotatorGame(R.string.annotator_market));
    }

    @Test
    public void get_withTrucoGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Truco());
        assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @Test
    public void get_withChanchoGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Chancho());
        assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @Test
    public void get_withTuteGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Tute());
        assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void get_withInvalidGame_throwIllegalArgumentException() {
        annotatorService.get(new Game() {
            private static final long serialVersionUID = 471756212507274824L;
        });
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void get_withNullGame_throwIllegalArgumentException() {
        annotatorService.get(null);
    }

}
