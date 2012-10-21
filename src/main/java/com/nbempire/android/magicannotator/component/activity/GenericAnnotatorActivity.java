/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;

/**
 * Android activity to display to the user a generic annotator.
 *
 * @author Nahuel Barrios.
 */
public class GenericAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "GenericAnnotatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(LOG_TAG));
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
