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
import com.nbempire.android.magicannotator.listener.NoActionOnClickListener;
import com.nbempire.android.magicannotator.listener.TrucoScoreListener;

/**
 * {@link Activity} para anotar el puntaje de un partido de truco.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 01/03/2012, 05:55:58.
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
        this.setActions(R.id.trucoAnnotator_scoreTeam1, R.id.trucoAnnotator_toggleTeam1, R.string.trucoAnnotator_youWin,
                        R.id.trucoAnnotator_labelTeam1);

        // Setteo las acciones para los elementos del equipo "ellos"
        this.setActions(R.id.trucoAnnotator_scoreTeam2, R.id.trucoAnnotator_toggleTeam2, R.string.trucoAnnotator_theyWin,
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
     * Setteo las acciones para todo un equipo, ya sea nosotros o ellos, dependiendo de los ID de
     * los resources.
     * 
     * @author Nahuel Barrios.
     * @param teamScoreElementId
     *            El ID del {@link TextView} donde se anotar� el score.
     * @param teamToggleElementId
     *            El ID del {@link ToggleButton} que indicar� si est�n en las buenas/malas.
     * @param labelForWinnerTeamElementId
     *            ID del recurso string que se utilizar� cuando gane el equipo.
     * @param teamLabelElementId
     *            El ID del {@link TextView} con el label del equipo en el cu�l se debe hacer tap
     *            para sumar un punto.
     */
    private void setActions(int teamScoreElementId, int teamToggleElementId, int labelForWinnerTeamElementId,
                            int teamLabelElementId) {

        TextView teamScore = (TextView) findViewById(teamScoreElementId);
        teamScore.addTextChangedListener(new TrucoScoreListener((ToggleButton) findViewById(teamToggleElementId),
                                                                getText(labelForWinnerTeamElementId)));
        TrucoScoreListener listener = new TrucoScoreListener(teamScore);
        teamScore.setOnTouchListener(listener);

        TextView teamLabel = (TextView) findViewById(teamLabelElementId);
        teamLabel.setOnTouchListener(listener);

        ((ToggleButton) findViewById(teamToggleElementId)).setOnClickListener(new NoActionOnClickListener());
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetScores()
     * 
     * @author Nahuel Barrios.
     * @since 08/03/2012.
     */
    public void resetGame(View view) {
        this.resetScoreFor(R.id.trucoAnnotator_scoreTeam1);
        this.resetScoreFor(R.id.trucoAnnotator_scoreTeam2);

        this.resetGoodBadIndicator(R.id.trucoAnnotator_toggleTeam1);
        this.resetGoodBadIndicator(R.id.trucoAnnotator_toggleTeam2);
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetGoodBadIndicator()
     * 
     * @author Nahuel Barrios.
     * @since 08/03/2012.
     * @param goodBadIndicatorElementId
     */
    private void resetGoodBadIndicator(int goodBadIndicatorElementId) {
        ((ToggleButton) findViewById(goodBadIndicatorElementId)).setChecked(false);
    }

    /**
     * TODO : JavaDoc : for TrucoAnnotatorActivity.resetScoreFor()
     * 
     * @author Nahuel Barrios.
     * @since 08/03/2012.
     * @param teamScoreElementId
     */
    private void resetScoreFor(int teamScoreElementId) {
        ((TextView) findViewById(teamScoreElementId)).setText(this.getText(R.string.defaultInitialGameScore));
    }

}
