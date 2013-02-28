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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

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

    private static final String HOLE_NUMBER_KEY_PREFFIX = "holeNumber";

    private int numberOfHoles;

    private int currentHole;

    private Bundle holes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  TODO : Functionality : Uncomment GoogleAnalyticsTracker from GolfAnnotatorActivity.
//        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));
        setContentView(R.layout.golfannotator);

        openNumberOfHolesChooser();
    }

    /**
     * TODO : Javadoc for openNumberOfHolesChooser
     */
    private void openNumberOfHolesChooser() {
        final CharSequence[] charSequences = {"6", "9", "18"};

        new AlertDialog.Builder(this).setTitle(getText(R.string.golfAnnotator_selectNumberOfHoles))
                                     .setSingleChoiceItems(charSequences, 0, new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {
                                             Log.i(TAG, "User is gonna play " + charSequences[which] + " holes.");
                                             //  TODO : Log to Analytics the number of holes that user is gonna play to determine which is the best default selection.

                                             dialog.dismiss();
                                             numberOfHoles = Integer.parseInt(charSequences[which].toString());

                                             initializeHoleSelector();
                                             preparePlayersAndScoresForFirstTime();

                                             renderPlayersAndScores(1);

                                             //  TODO : Functionality : Uncomment call to openDefaultHitsForHoleDialog to let user set default number of hits per hole.
//                                             openDefaultHitsForHoleDialog();
                                         }
                                     }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                //  TODO : Functionality : Do shomething when user cancels (press back button) this AlertDialog.
            }
        }).show();
    }

    /**
     * TODO : Javadoc for initializeHoleSelector
     */
    private void initializeHoleSelector() {
        String[] holes = new String[numberOfHoles];
        for (int index = 0; index < numberOfHoles; ) {
            holes[index] = String.valueOf(++index);
        }

        Spinner holeSelectorSpinner = (Spinner) findViewById(R.id.golfAnnotator_holeSelector);
        ArrayAdapter<String> holeSelectorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, holes);
        holeSelectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holeSelectorSpinner.setAdapter(holeSelectorAdapter);

        holeSelectorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "Showing hole " + position++);
                saveCurrentSores();
                renderPlayersAndScores(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i(TAG, "Nothing selected...");
            }
        });
    }

    /**
     * TODO : Javadoc for preparePlayersAndScoresForFirstTime
     */
    private void preparePlayersAndScoresForFirstTime() {
        holes = new Bundle(numberOfHoles);

        for (int index = 1; index <= numberOfHoles; index++) {
            Bundle eachHole = new Bundle();

            for (String player : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
                eachHole.putInt(player, 0);
            }
            holes.putBundle(HOLE_NUMBER_KEY_PREFFIX + index, eachHole);
        }
    }

    /**
     * TODO : Javadoc for saveCurrentSores
     */
    private void saveCurrentSores() {
        Log.i(TAG, "Saving scores from hole: " + currentHole);

        Bundle currentPlayersAndScores = holes.getBundle(HOLE_NUMBER_KEY_PREFFIX + currentHole);
        for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            String currentScore = ((EditText) findViewById(ViewsUtil.generateId(eachPlayer))).getText().toString();
            Log.d(TAG, "Player " + eachPlayer + " now has got: " + currentScore);
            currentPlayersAndScores.putInt(eachPlayer, Integer.parseInt(currentScore));
        }
    }

    /**
     * TODO : Javadoc for renderPlayersAndScores
     *
     * @param selectedHole
     *         The hole that will be displayed to the user.
     */
    private void renderPlayersAndScores(int selectedHole) {
        currentHole = selectedHole;
        LinearLayout playersLayout = (LinearLayout) findViewById(R.id.golfAnnotator_playersLinearLayout);
        playersLayout.removeAllViews();

        Bundle playersAndScores = holes.getBundle(HOLE_NUMBER_KEY_PREFFIX + currentHole);
        for (String eachPlayerName : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            int currentScore = playersAndScores.getInt(eachPlayerName);
            playersLayout.addView(new ScoreEditorView(playersLayout.getContext(), eachPlayerName, currentScore, 2));
        }
    }

//    /**
//     * TODO : Javadoc for openDefaultHitsForHoleDialog
//     */
//    private void openDefaultHitsForHoleDialog() {
//        EditText editText = new EditText(this, null);
//        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//        editText.setText(R.string.defaultInitialGameScore);
//
//        new AlertDialog.Builder(this).setTitle(R.string.golfAnnotator_defaultHitsPerHole)
//                                     .setView(editText)
//                                     .setPositiveButton(R.string.commonLabel_done, new DialogInterface.OnClickListener() {
//                                         @Override
//                                         public void onClick(DialogInterface dialog, int which) {
//                                             dialog.dismiss();
//                                         }
//                                     }).show();
//    }

}