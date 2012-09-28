/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.activity;

import java.util.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.Player;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.util.ArrayUtil;
import com.nbempire.android.magicannotator.util.android.TableListAdapter;

/**
 * Android Activity for the Tute annotator.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TuteAnnotatorActivity extends Activity {

    private static final int NUMBER_OF_COLUMNS = 4;

    /**
     * El {@link Game} que contiene los usuarios.
     */
    private Game aGame;

    /**
     * {@link Bundle} con los puntajes de cada jugador.
     */
    private Bundle scores;

    /**
     * {@link String} key para trabajar con el {@link Bundle} para guardar la instancia de la {@link Activity}.
     */
    private static final String SCORES_BUNDLE_KEY = "scores";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutepartialresults);

        aGame = (Game) this.getIntent().getExtras().getSerializable(AppParameter.GAME);

        GridView grid = ((GridView) findViewById(R.id.tuteAnnotator_partialResults_gridView));

        boolean forUpdate = false;
        if (savedInstanceState != null) {
            scores = savedInstanceState.getBundle(SCORES_BUNDLE_KEY);
            forUpdate = true;
        } else {
            scores = new Bundle();
        }

        updateGrid(grid, forUpdate);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBundle(SCORES_BUNDLE_KEY, scores);
    }

    /**
     * Actualiza la {@link GridView} que le pasamos como parámetro (en la que se ven los jugadores y sus puntajes), en base a los jugadores
     * del atributo de clase {@link Game}. En base al parámetro forUpdate asignará el puntaje por default cuando se cree por primera vez la
     * grilla, o utilizará los scores guardados.
     *
     * @param gridView
     *         {@link GridView} que se va a actualizar.
     * @param forUpdate
     *         {@link Boolean} indicando en <code>true</code> que la grilla es la primera vez que se completa. <code>false</code> cuando sea
     *         una actualización.
     *
     * @since 1
     */
    private void updateGrid(GridView gridView, boolean forUpdate) {
        if (!forUpdate) {
            for (Player player : aGame.getTeams().get(0).getPlayers()) {
                Bundle eachPlayerBundle = new Bundle();
                eachPlayerBundle.putCharSequence(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND, "0");
                eachPlayerBundle.putCharSequence(AppParameter.TUTE_PLAYER_SCORE_CAPOTE, "0");
                eachPlayerBundle.putCharSequence(AppParameter.TUTE_PLAYER_SCORE_TUTE, "0");
                scores.putBundle(player.getNickName(), eachPlayerBundle);
            }
        }

        gridView.setAdapter(new TableListAdapter(this, this.getValuesForGrid(scores), NUMBER_OF_COLUMNS));
    }

    /**
     * Prepara la lista necesaria de nombre de jugadores-puntajes para utilizar un {@link TableListAdapter}.
     *
     * @param playersScores
     *         {@link Bundle} con pares nombre del jugador-puntaje de los cuáles se va a armar el {@link List} final.
     *
     * @return {@link List} de {@link CharSequence} con el resultado final.
     *
     * @since 1
     */
    private List<CharSequence> getValuesForGrid(Bundle playersScores) {
        List<CharSequence> result = new ArrayList<CharSequence>();
        result.add(this.getText(R.string.player).toString());
        result.add(this.getText(R.string.tutePartialResults_lostHands_short).toString());
        result.add(this.getText(R.string.tutePartialResults_capotes).toString());
        result.add(this.getText(R.string.tutePartialResults_tutes).toString());

        SortedSet<String> sortedSet = new TreeSet<String>();
        for (String eachPlayerNickname : playersScores.keySet()) {
            sortedSet.add(eachPlayerNickname);
        }

        for (String eachPlayer : sortedSet) {
            result.add(eachPlayer);
            result.add(playersScores.getBundle(eachPlayer).getCharSequence(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND));
            result.add(playersScores.getBundle(eachPlayer).getCharSequence(AppParameter.TUTE_PLAYER_SCORE_CAPOTE));
            result.add(playersScores.getBundle(eachPlayer).getCharSequence(AppParameter.TUTE_PLAYER_SCORE_TUTE));
        }

        return result;
    }

    /**
     * Método ejecutado desde el layout para abrir el selector de un jugador al que se le va a actualizar el puntaje.
     *
     * @param view
     *         {@link View} la vista que llamó al método.
     *
     * @since 1
     */
    public void openPlayersSelector(View view) {
        final Context theContext = view.getContext();

        final List<String> possibleLoosers = new ArrayList<String>();
        for (Player eachPlayer : aGame.getTeams().get(0).getPlayers()) {
            possibleLoosers.add(eachPlayer.getNickName());
        }
        Collections.sort(possibleLoosers);

        int temporalScoreToUpdate = AppParameter.ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_CAPOTE;
        if (R.id.tutePartialResults_addTuteButton == view.getId()) {
            temporalScoreToUpdate = AppParameter.ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_TUTE;
        }
        final int scoreToUpdate = temporalScoreToUpdate;

        AlertDialog.Builder selectPlayerDialog = new AlertDialog.Builder(theContext);
        selectPlayerDialog.setTitle(getText(R.string.tutePartialResults_whoDidThat));
        selectPlayerDialog.setSingleChoiceItems(ArrayUtil.toArray(possibleLoosers), -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int position) {
                addScoreFor(scoreToUpdate, possibleLoosers.get(position));
                updateGrid((GridView) findViewById(R.id.tuteAnnotator_partialResults_gridView), true);
                dialog.dismiss();
            }

        });
        selectPlayerDialog.show();
    }

    /**
     * TODO : JavaDoc : for TutePartialResultsActivity.addScoreFor()
     *
     * @param scoreToUpdate
     * @param selectedNickName
     *
     * @return
     *
     * @since 1
     */
    private int addScoreFor(int scoreToUpdate, String selectedNickName) {
        String scoreKey;
        switch (scoreToUpdate) {
            case AppParameter.ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_LOST_HAND:
                scoreKey = AppParameter.TUTE_PLAYER_SCORE_LOST_HAND;
                break;
            case AppParameter.ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_CAPOTE:
                scoreKey = AppParameter.TUTE_PLAYER_SCORE_CAPOTE;
                break;
            default:
                scoreKey = AppParameter.TUTE_PLAYER_SCORE_TUTE;
                break;
        }

        Integer updatedScore = Integer.parseInt(scores.getBundle(selectedNickName).getString(scoreKey)) + 1;
        scores.getBundle(selectedNickName).putCharSequence(scoreKey, updatedScore.toString());
        return updatedScore;
    }

    /**
     * Este método se ejecuta desde la defici�n del layout de esta actividad y es el encargado de cambiar la pestaña de anotar cada mano.
     *
     * @param view
     *
     * @since 1
     */
    public void playAnotherHand(View view) {
        AlertDialog.Builder selectPlayerDialog = new AlertDialog.Builder(view.getContext());

        final List<String> possibleLoosers = new ArrayList<String>();
        Iterator<String> iterator = scores.keySet().iterator();
        while (iterator.hasNext()) {
            String playerNickname = iterator.next();
            if (!scores.getBundle(playerNickname).getCharSequence(AppParameter.TUTE_PLAYER_SCORE_LOST_HAND).equals("4")) {
                possibleLoosers.add(playerNickname);
            }
        }
        Collections.sort(possibleLoosers);
        final List<String> selectedLoosers = new ArrayList<String>(possibleLoosers.size());
        selectPlayerDialog.setTitle(this.getText(R.string.chooseLoosers));
        selectPlayerDialog.setMultiChoiceItems(ArrayUtil.toArray(possibleLoosers), null, new OnMultiChoiceClickListener() {

            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                String value = possibleLoosers.get(position);
                if (isChecked) {
                    selectedLoosers.add(value);
                } else {
                    selectedLoosers.remove(value);
                }
            }
        }).setPositiveButton(this.getText(R.string.commonLabel_accept), new OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                updateScoreFor(selectedLoosers);
                updateGrid((GridView) findViewById(R.id.tuteAnnotator_partialResults_gridView), true);
                dialog.dismiss();
            }

        }).show();
    }

    /**
     * TODO : JavaDoc : for TuteAnnotatorActivity.updateScoreFor().
     *
     * @param selectedLoosers
     *
     * @return
     *
     * @since 1
     */
    private List<String> updateScoreFor(List<String> selectedLoosers) {
        List<String> lostUsers = new ArrayList<String>();
        for (String eachPlayerNickname : selectedLoosers) {
            int updatedScore = this.addScoreFor(AppParameter.ACTIVITY_RESULT_TUTE_CHOOSEN_PLAYER_FOR_ADD_LOST_HAND,
                                                       eachPlayerNickname);
            if (updatedScore == 4) {
                lostUsers.add(eachPlayerNickname);
            }
        }
        Collections.sort(lostUsers);
        return lostUsers;
    }

}
