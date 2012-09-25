/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoAnnotatorActivity.java Created by: Nahuel Barrios: 01/03/2012, 05:55:58.
 */
package com.nbempire.android.magicannotator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.listener.TrucoScoreListener;

/**
 * {@link Activity} para anotar el puntaje de un partido de truco.
 *
 * @author Nahuel Barrios.
 * @since 0.1
 */
public class TrucoAnnotatorActivity extends Activity {

    /**
     * Key para el score del equipo "Nosotros", para controlar el giro del telefono.
     */
    private static final String SCORE_TEAM_1 = "scoreTeam1";

    /**
     * Key para el score del equipo "Ellos", para controlar el giro del telefono.
     */
    private static final String SCORE_TEAM_2 = "scoreTeam2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trucoannotator);

        // Setteo las acciones para los elementos del equipo "nosotros"
        setActions(R.id.trucoAnnotator_scoreTeam1, R.string.trucoAnnotator_youWin,
                          R.id.trucoAnnotator_labelTeam1);

        // Setteo las acciones para los elementos del equipo "ellos"
        setActions(R.id.trucoAnnotator_scoreTeam2, R.string.trucoAnnotator_theyWin,
                          R.id.trucoAnnotator_labelTeam2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(SCORE_TEAM_1, ((TextView) findViewById(R.id.trucoAnnotator_scoreTeam1)).getText());
        outState.putCharSequence(SCORE_TEAM_2, ((TextView) findViewById(R.id.trucoAnnotator_scoreTeam2)).getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ((TextView) findViewById(R.id.trucoAnnotator_scoreTeam1)).setText(savedInstanceState.getCharSequence(SCORE_TEAM_1));
        ((TextView) findViewById(R.id.trucoAnnotator_scoreTeam2)).setText(savedInstanceState.getCharSequence(SCORE_TEAM_2));
    }

    /**
     * Setteo las acciones para todo un equipo, ya sea nosotros o ellos, dependiendo de los ID de los resources.
     *
     * @param teamScoreId
     *         El ID del {@link TextView} donde se anotar� el score.
     * @param labelForWinnerTeamId
     *         ID del recurso string que se utilizar� cuando gane el equipo.
     * @param teamLabelId
     *         El ID del {@link TextView} con el label del equipo en el cu�l se debe hacer tap para sumar un punto.
     *
     * @since 0.1
     */
    private void setActions(int teamScoreId, int labelForWinnerTeamId,
                            int teamLabelId) {

        TextView teamScore = (TextView) findViewById(teamScoreId);
        TrucoScoreListener listener = new TrucoScoreListener(teamScore, getText(labelForWinnerTeamId));
        teamScore.setOnTouchListener(listener);

        TextView teamLabel = (TextView) findViewById(teamLabelId);
        teamLabel.setOnTouchListener(listener);
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetScores()
     *
     * @since 0.1
     */
    public void resetGame(View view) {
        this.resetScoreFor(R.id.trucoAnnotator_scoreTeam1);
        this.resetScoreFor(R.id.trucoAnnotator_scoreTeam2);
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetGoodBadIndicator()
     *
     * @param goodBadIndicatorId
     *
     * @since 0.1
     */
    private void resetGoodBadIndicator(int goodBadIndicatorId) {
        ((ToggleButton) findViewById(goodBadIndicatorId)).setChecked(false);
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetScoreFor()
     *
     * @param teamScoreElementId
     *
     * @since 0.1
     */
    private void resetScoreFor(int teamScoreElementId) {
        ((TextView) findViewById(teamScoreElementId)).setText(this.getText(R.string.defaultInitialGameScore));
    }

}
