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
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

/**
 * Android activity to display to the user a generic annotator.
 *
 * @author Nahuel Barrios.
 */
public class GenericAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String TAG = "GenericAnnotatorActivity";

    /**
     * Bundle where to save each player and his score.
     */
    private Bundle playersAndScores;

    //  TODO : Performance : Improve GenericAnnotatorActivity activity lifecycle.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));

        this.setContentView(R.layout.basescrollview);

        TextView headerText = (TextView) this.findViewById(R.id.basescrollview_headerText);
        headerText.setText(this.getText(R.string.genericannotator_scores));

        playersAndScores = new Bundle();

        TableLayout layout = (TableLayout) this.findViewById(R.id.basescrollview_tableLayout);
        TableRow tableRow;
        for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            tableRow = new TableRow(layout.getContext());
            ScoreEditorView scoreEditor = new ScoreEditorView(layout.getContext(), eachPlayer, 0, 3, true);
            tableRow.addView(scoreEditor);

            layout.addView(tableRow);
            playersAndScores.putString(eachPlayer, "0");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestore");
        playersAndScores = savedInstanceState.getBundle("playersAndScores");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            ((EditText) findViewById(ViewsUtil.generateId(eachPlayer))).setText(playersAndScores.getString(eachPlayer));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSave");

        for (String eachPlayer : getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            playersAndScores.putString(eachPlayer, ((EditText) findViewById(ViewsUtil.generateId(eachPlayer))).getText().toString());
        }
        outState.putBundle("playersAndScores", playersAndScores);
    }

}
