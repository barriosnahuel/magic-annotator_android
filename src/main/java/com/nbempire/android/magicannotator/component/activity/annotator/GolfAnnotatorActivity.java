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

package com.nbempire.android.magicannotator.component.activity.annotator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.TableListAdapter;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Activity that represents the annotator for a golf match.
 * <p/>
 * Created on 2/25/13, at 9:15 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 19.
 */
public class GolfAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String TAG = "GolfAnnotatorActivity";

    /**
     * Bundle key to use as preffix for each hole.
     */
    private static final String KEY_HOLE_NUMBER_PREFFIX = "holeNumber";

    /**
     * Bundle key to get the holes Bundle.
     */
    private static final String KEY_HOLES = "holes";

    /**
     * Bundle key to get the current hole that user is playing.
     */
    private static final String KEY_CURRENT_HOLE = "currentHole";

    /**
     * Indicate how many holes user is playing.
     */
    private int numberOfHoles;

    /**
     * Indicate the current hole that the user is annotating.
     */
    private int currentHole;

    /**
     * Contains a pair holeNumber-scores where to save player's scores.
     */
    private Bundle holes;

    /**
     * Boolean indicating with {@code true} that is the first running so the application must NOT save scores to load starting hole.
     */
    private boolean isFirstRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));
        setContentView(R.layout.golfannotator);

        if (savedInstanceState == null) {
            isFirstRunning = true;
            openNumberOfHolesChooser();
        } else {
            holes = savedInstanceState.getBundle(KEY_HOLES);
            numberOfHoles = holes.keySet().size();
            currentHole = savedInstanceState.getInt(KEY_CURRENT_HOLE);

            initializeHoleSelector();
            renderPlayersAndScores(currentHole);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        saveCurrentSores();
        outState.putBundle(KEY_HOLES, holes);
        outState.putInt(KEY_CURRENT_HOLE, currentHole);
    }

    /**
     * Opens dialog to let user choose how many holes is gonna annotate. After user selection, call {@link #openInitialHoleSelector()}.
     */
    private void openNumberOfHolesChooser() {
        final CharSequence[] charSequences = {"6", "9", "18"};

        new AlertDialog.Builder(this).setTitle(getText(R.string.golfAnnotator_selectNumberOfHoles))
                                     .setCancelable(false)
                                     .setSingleChoiceItems(charSequences, 0, new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {
                                             String selectedNumberOfHoles = charSequences[which].toString();
                                             Log.i(TAG, "User is gonna play " + selectedNumberOfHoles + " holes.");

                                             numberOfHoles = Integer.parseInt(selectedNumberOfHoles);

                                             dialog.dismiss();

                                             openInitialHoleSelector();
                                         }
                                     }).show();
    }

    /**
     * Opens dialog to let user choose the starting hole. After user selection, it initializes the hole selector, prepare the holes Bundle for first
     * time and finally render players and scores for the selected hole.
     */
    private void openInitialHoleSelector() {
        String[] holesArray = new String[numberOfHoles];
        for (int index = 0; index < numberOfHoles; ) {
            holesArray[index] = String.valueOf(++index);
        }

        new AlertDialog.Builder(this).setTitle(getText(R.string.golfAnnotator_selectStartingHole))
                                     .setCancelable(false)
                                     .setItems(holesArray, new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {
                                             currentHole = which + 1;

                                             Log.i(TAG, "User is starting from hole number: " + currentHole);

                                             //  TODO : Performance : Try putting these 2 calls after if-else in onCreate. Check for race-condition.
                                             initializeHoleSelector();
                                             preparePlayersAndScoresForFirstTime();

                                             ((Spinner) findViewById(R.id.golfAnnotator_holeSelector)).setSelection(which);
                                         }
                                     }).show();
    }

    /**
     * Initialize the hole selector by setting the values that the user will be able to choose.
     * <p/>
     * It also sets the functionality for when the user selects some hole. First of all saves scores for the current hole and then render players and
     * scores for the selected hole number.
     */
    private void initializeHoleSelector() {
        String[] holesArray = new String[numberOfHoles];
        for (int index = 0; index < numberOfHoles; ) {
            holesArray[index] = String.valueOf(++index);
        }
        ArrayAdapter<String> holeSelectorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, holesArray);
        holeSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner holeSelectorSpinner = (Spinner) findViewById(R.id.golfAnnotator_holeSelector);
        holeSelectorSpinner.setAdapter(holeSelectorAdapter);

        holeSelectorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saveCurrentSores();
                renderPlayersAndScores(++position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.w(TAG, "Nothing was selected in golfAnnotator_holeSelector Spinner.");
            }
        });
    }

    /**
     * Prepare the {@link #holes} Bundle creating one {@link Bundle} for each hole. Each hole Bundle will contain an entry for each player with his
     * number of hits for that hole.
     */
    private void preparePlayersAndScoresForFirstTime() {
        holes = new Bundle(numberOfHoles);

        for (int index = 1; index <= numberOfHoles; index++) {
            Bundle eachHole = new Bundle();

            for (String player : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
                eachHole.putInt(player, 0);
            }
            holes.putBundle(KEY_HOLE_NUMBER_PREFFIX + index, eachHole);
        }
    }

    /**
     * Update layout by loading the {@code selectedHole} with its players and scores.
     *
     * @param selectedHole
     *         The hole that will be rendered.
     */
    private void renderPlayersAndScores(int selectedHole) {
        Log.i(TAG, "Loading hole " + selectedHole);

        currentHole = selectedHole;
        LinearLayout playersLayout = (LinearLayout) findViewById(R.id.golfAnnotator_playersLinearLayout);
        playersLayout.removeAllViews();

        Bundle playersAndScores = holes.getBundle(KEY_HOLE_NUMBER_PREFFIX + currentHole);
        for (String eachPlayerName : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            int currentScore = playersAndScores.getInt(eachPlayerName);
            playersLayout.addView(new ScoreEditorView(playersLayout.getContext(), eachPlayerName, currentScore, 2, false));
        }
    }

    /**
     * Saves scores from {@link #currentHole} into {@link #holes} Bundle.
     */
    private void saveCurrentSores() {
        if (!isFirstRunning) {
            Log.i(TAG, "Saving scores from hole: " + currentHole);

            Bundle currentPlayersAndScores = holes.getBundle(KEY_HOLE_NUMBER_PREFFIX + currentHole);
            for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
                String currentScore = ((TextView) findViewById(ViewsUtil.generateId(eachPlayer))).getText().toString();
                Log.d(TAG, "Player " + eachPlayer + " now has got: " + currentScore);
                currentPlayersAndScores.putInt(eachPlayer, Integer.parseInt(currentScore));
            }
        } else {
            isFirstRunning = false;
        }
    }

    /**
     * Display final scores for each user.
     *
     * @param callerView
     *         The view that has called this method.
     */
    public void displayFinalResult(View callerView) {
        saveCurrentSores();

        int numberOfColumns = 2;
        TableListAdapter tableListAdapter = new TableListAdapter(this, getValuesForGrid(), numberOfColumns);
        tableListAdapter.setTextAppearanceResourceId(R.style.alertDialogColor);

        GridView finalResultGridView = new GridView(callerView.getContext());
        finalResultGridView.setNumColumns(numberOfColumns);
        finalResultGridView.setAdapter(tableListAdapter);

        new AlertDialog.Builder(callerView.getContext()).setTitle(R.string.final_result).setView(finalResultGridView)
                                                        .setPositiveButton(R.string.commonLabel_done, new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                dialog.dismiss();
                                                            }
                                                        }).show();
    }

    /**
     * TODO : Refactor : Try to extract this duplicated method. First usage it's in {@link TuteAnnotatorActivity}.
     * <p/>
     * Prepara la lista necesaria de nombre de jugadores-puntajes para utilizar un {@link TableListAdapter}.
     *
     * @return {@link java.util.List} de {@link CharSequence} con el resultado final.
     */
    private List<CharSequence> getValuesForGrid() {
        List<CharSequence> result = new ArrayList<CharSequence>();
        result.add(getText(R.string.player).toString());
        result.add(getText(R.string.golfAnnotator_totalHits).toString());

        Bundle playersAndScores = getTotalScores();
        SortedSet<String> sortedSet = new TreeSet<String>();
        for (String eachPlayerNickname : playersAndScores.keySet()) {
            sortedSet.add(eachPlayerNickname);
        }

        for (String eachPlayer : sortedSet) {
            result.add(eachPlayer);
            result.add(String.valueOf(playersAndScores.getInt(eachPlayer)));
        }

        return result;
    }

    /**
     * Get total scores for each player from their partial scores from each hole.
     *
     * @return Bundle containing the pair player nickname-total score.
     */
    private Bundle getTotalScores() {
        Bundle playersAndScores = new Bundle();
        for (String holeNumber : holes.keySet()) {
            Bundle eachHole = holes.getBundle(holeNumber);

            for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
                int score = eachHole.getInt(eachPlayer);

                if (playersAndScores.containsKey(eachPlayer)) {
                    score += playersAndScores.getInt(eachPlayer);
                }

                playersAndScores.putInt(eachPlayer, score);
            }
        }

        return playersAndScores;
    }

    /**
     * Sets next hole as selected in the holeSelector so then it saves current scores and render next hole.
     */
    @SuppressWarnings("UnusedParameters")
    public void renderNextHole(View callerView) {
        int nextHole;
        if (currentHole < numberOfHoles) {
            nextHole = currentHole;
        } else {
            nextHole = 0;
        }
        ((Spinner) findViewById(R.id.golfAnnotator_holeSelector)).setSelection(nextHole);

    }

}