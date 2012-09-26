/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;

/**
 * TODO : JavaDoc : for GenericAnnotatorActivity.
 *
 * @author Nahuel Barrios.
 */
public class GenericAnnotatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.basescrollview);

        TableLayout layout = (TableLayout) this.findViewById(R.id.basescrollview_tableLayout);

        TextView headerText = (TextView) this.findViewById(R.id.basescrollview_headerText);
        headerText.setText(this.getText(R.string.genericannotator_scores));

        TableRow tableRow;
        for (String eachPlayer : this.getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS)) {
            tableRow = new TableRow(layout.getContext());
            ScoreEditorView scoreEditor = new ScoreEditorView(layout.getContext(), eachPlayer);
            tableRow.addView(scoreEditor);

            layout.addView(tableRow);
        }
    }

}
