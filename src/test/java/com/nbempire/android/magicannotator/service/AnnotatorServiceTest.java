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
import org.junit.Assert;
import org.junit.Test;

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
    public void getAnnotatorId_withChanchoInput_returnChanchoId() {
        Assert.assertEquals(R.string.annotator_chancho, annotatorService.getAnnotatorId("Chancho"));
    }

    @Test
    public void getAnnotatorId_withMarketInput_returnMarketId() {
        Assert.assertEquals(R.string.annotator_market, annotatorService.getAnnotatorId("Lista del supermercado"));
    }

    @Test
    public void getAnnotatorId_withOtherInput_returnOtherId() {
        Assert.assertEquals(R.string.annotator_otro, annotatorService.getAnnotatorId("Otro"));
    }

    @Test
    public void getAnnotatorId_withTrucoInput_returnTrucoId() {
        Assert.assertEquals(R.string.annotator_truco, annotatorService.getAnnotatorId("Truco"));
    }

    @Test
    public void getAnnotatorId_withTuteInput_returnTuteId() {
        Assert.assertEquals(R.string.annotator_tute, annotatorService.getAnnotatorId("Tute"));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void getAnnotatorId_withNullInput_throwIllegalArgumentException() {
        annotatorService.getAnnotatorId(null);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = IllegalArgumentException.class)
    public void getAnnotatorId_withInvalidInput_throwIllegalArgumentException() {
        annotatorService.getAnnotatorId("This annotator doesn't exist.");
    }

    @Test
    public void getAnnotatorGame_withChanchoInput_returnChanchoGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_chancho);
        Assert.assertNotNull("Returned Game musn't be null.");
        Assert.assertTrue(MUST_BE_INSTANCE_OF + Chancho.class.getSimpleName(), aGame instanceof Chancho);
    }

    @Test
    public void getAnnotatorGame_withTrucoInput_returnTrucoGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_truco);
        Assert.assertNotNull(RETURNED_GAME_MUST_NOT_BE_NULL);
        Assert.assertTrue(MUST_BE_INSTANCE_OF + Truco.class.getSimpleName(), aGame instanceof Truco);
    }

    @Test
    public void getAnnotatorGame_withTuteInput_returnTuteGame() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_tute);
        Assert.assertNotNull(RETURNED_GAME_MUST_NOT_BE_NULL);
        Assert.assertTrue(MUST_BE_INSTANCE_OF + Tute.class.getSimpleName(), aGame instanceof Tute);
    }

    @Test
    public void getAnnotatorGame_withMarketInput_returnNull() {
        Game aGame = annotatorService.getAnnotatorGame(R.string.annotator_market);
        Assert.assertNull("Returned Game must be null.", aGame);
    }

    @Test
    public void get_withOtroAnnotatorId_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(R.string.annotator_otro);
        Assert.assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        Assert.assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @Test
    public void get_withTrucoGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Truco());
        Assert.assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        Assert.assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @Test
    public void get_withChanchoGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Chancho());
        Assert.assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        Assert.assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
    }

    @Test
    public void get_withTuteGame_returnAnnotatorActivity() {
        Class<? extends Activity> activity = annotatorService.get(new Tute());
        Assert.assertNotNull(RETURNED_ANNOTATOR_ACTIVITY_MUST_NOT_BE_NULL, activity);
        Assert.assertTrue(TYPE_NAME_MUST_HAVE_SUFFIX, activity.getSimpleName().endsWith(ANNOTATOR_ACTIVITY_TYPE_SUFFIX));
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
