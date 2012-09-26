/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoAnnotatorActivity.java Created by: Nahuel Barrios: 01/03/2012, 05:55:58.
 */
package com.nbempire.android.magicannotator.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.listener.TrucoScoreListener;

/**
 * {@link Activity} para anotar el puntaje de un partido de truco.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TrucoAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "TrucoAnnotatorActivity";

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
        List<Integer> viewsToDisable = new ArrayList<Integer>();
        viewsToDisable.add(R.id.trucoAnnotator_labelTeam2);
        viewsToDisable.add(R.id.trucoAnnotator_scoreTeam2);
        setActions(R.id.trucoAnnotator_scoreTeam1, R.string.trucoAnnotator_youWin,
                          R.id.trucoAnnotator_labelTeam1, viewsToDisable);

        // Setteo las acciones para los elementos del equipo "ellos"
        viewsToDisable.clear();
        viewsToDisable.add(R.id.trucoAnnotator_labelTeam1);
        viewsToDisable.add(R.id.trucoAnnotator_scoreTeam1);
        setActions(R.id.trucoAnnotator_scoreTeam2, R.string.trucoAnnotator_theyWin,
                          R.id.trucoAnnotator_labelTeam2, viewsToDisable);
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
     * @param viewsIdToDisable
     *         List of Integer containing one element for each View to disable when one team wins.
     *
     * @since 1
     */
    private void setActions(int teamScoreId, int labelForWinnerTeamId, int teamLabelId, List<Integer> viewsIdToDisable) {

        List<View> viewsToDisable = new ArrayList<View>();
        for (int eachViewId : viewsIdToDisable) {
            viewsToDisable.add(findViewById(eachViewId));
        }

        TextView teamScore = (TextView) findViewById(teamScoreId);
        TrucoScoreListener listener = new TrucoScoreListener(teamScore, getText(labelForWinnerTeamId), viewsToDisable);
        teamScore.setOnTouchListener(listener);

        TextView teamLabel = (TextView) findViewById(teamLabelId);
        teamLabel.setOnTouchListener(listener);
    }

    /**
     * Reset the entire activity by setting scores to zero and enabling all controls.
     *
     * @since 1
     */
    public void resetGame(View view) {
        Log.d(LOG_TAG, "--> resetGame() from view: " + view.getId());
        resetScoreFor(R.id.trucoAnnotator_scoreTeam1);
        resetScoreFor(R.id.trucoAnnotator_scoreTeam2);

        List<Integer> viewsIdToEnable = new ArrayList<Integer>();
        viewsIdToEnable.add(R.id.trucoAnnotator_labelTeam1);
        viewsIdToEnable.add(R.id.trucoAnnotator_labelTeam2);
        viewsIdToEnable.add(R.id.trucoAnnotator_scoreTeam1);
        viewsIdToEnable.add(R.id.trucoAnnotator_scoreTeam2);
        enableControls(viewsIdToEnable);
    }

    /**
     * Set enabled=true to each control from {@code viewsIdToEnable} even if they are already enabled.
     *
     * @param viewsIdToEnable
     *         The view's ID to enable.
     *
     * @since 6
     */
    private void enableControls(List<Integer> viewsIdToEnable) {
        for (int eachViewId : viewsIdToEnable) {
            findViewById(eachViewId).setEnabled(true);
        }
    }

    /**
     * Reset the score for the specified {@code teamScoreId}.
     *
     * @param teamScoreId
     *         The id of the team score to reset.
     *
     * @since 1
     */
    private void resetScoreFor(int teamScoreId) {
        ((TextView) findViewById(teamScoreId)).setText(this.getText(R.string.defaultInitialGameScore));
    }

}
