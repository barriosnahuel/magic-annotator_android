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
import android.widget.LinearLayout;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.view.ScoreEditorView;

import java.util.List;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  TODO : Functionality : Uncomment GoogleAnalyticsTracker from GolfAnnotatorActivity.
//        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));
        setContentView(R.layout.golfannotator);

        renderPlayers(getIntent().getExtras().getStringArrayList(AppParameter.PLAYERS));
//        openNumberOfHolesChooser();
    }

    private void renderPlayers(List<String> playersName) {
        LinearLayout playersLayout = (LinearLayout) findViewById(R.id.golfAnnotator_playersLinearLayout);

        for (String eachPlayerName : playersName) {
            playersLayout.addView(new ScoreEditorView(playersLayout.getContext(), eachPlayerName));
        }
    }

    /**
     * TODO : Javadoc for openNumberOfHolesChooser
     */
    private void openNumberOfHolesChooser() {
        final CharSequence[] charSequences = {"3", "6", "9"};

        new AlertDialog.Builder(this).setTitle(getText(R.string.golfAnnotator_selectNumberOfHoles))
                                     .setCancelable(false)
                                     .setSingleChoiceItems(charSequences, 0, new DialogInterface.OnClickListener() {
                                         @Override
                                         public void onClick(DialogInterface dialog, int which) {
                                             Log.i(TAG, "User is gonna to play " + charSequences[which] + " holes.");
                                             //  TODO : Log to Analytics the number of holes that user is gonna play to determine which is the best default selection.

                                             //  TODO : Functionality : Do something with selected number of holes.
                                             dialog.dismiss();
                                         }
                                     }).show();
    }

    /**
     * TODO : Javadoc for openHoleSelector
     *
     * @param callerView
     */
    private void openHoleSelector(View callerView) {
        //  TODO : Functionality : openHoleSelector method.
    }

}