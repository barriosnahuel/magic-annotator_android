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

package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.component.activity.annotator.TrucoAnnotatorActivity;
import com.nbempire.android.magicannotator.domain.Activities;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.service.AnnotatorService;
import com.nbempire.android.magicannotator.service.NavigationService;
import com.nbempire.android.magicannotator.service.impl.AnnotatorServiceImpl;
import com.nbempire.android.magicannotator.service.impl.NavigationServiceImpl;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;

/**
 * Android Activity to let user choose the annotator to use.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ChooseAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String TAG = "ChooseAnnotatorActivity";

    /**
     * Service for the annotators.
     */
    private final AnnotatorService annotatorService = new AnnotatorServiceImpl();

    /**
     * Service that controls the user's navigation flow.
     */
    private final NavigationService navigationService = new NavigationServiceImpl();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpAnalytics();

        setContentView(R.layout.chooseannotator);

        ListView availableAnnotators = (ListView) findViewById(R.id.main_gamesListView);
        availableAnnotators.setAdapter(ArrayAdapter.createFromResource(this, R.array.chooseAnnotator_annotatorsValues,
                                                                       android.R.layout.simple_list_item_1));
        availableAnnotators.setTextFilterEnabled(true);

        addOnItemClickActionForAnnotatorsList(availableAnnotators);
    }

    /**
     * Adds the onItemClickListener to the specified ListView to create the functionality to take the user to the next Activity.
     *
     * @param annotators
     *         The ListView from the GUI with all available annotators.
     *
     * @since 15
     */
    private void addOnItemClickActionForAnnotatorsList(ListView annotators) {
        annotators.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemKey = ((TextView) parent.getChildAt(position)).getText().toString();

                if (getIntent().getExtras().getBoolean(AppParameter.FIRST_RUN)) {
                    GoogleAnalyticsTracker.getInstance().trackEvent(GoogleAnalyticsUtil.generatePageName(TAG), "Selected annotator on first run",
                                                                    selectedItemKey, 0);
                }

                int annotatorId = annotatorService.getAnnotatorId(selectedItemKey);
                Game aGame = annotatorService.getAnnotatorGame(annotatorId);

                Context theContext = view.getContext();
                if (aGame instanceof Truco) {
                    addCustomNavigationFlowForTrucoAnnotator(theContext, aGame);
                } else {
                    Class<? extends Activity> nextActivity = navigationService.getNextActivityType(Activities.CHOOSE_ANNOTATOR, annotatorId);
                    if (aGame == null) {
                        showNextActivity(theContext, nextActivity, annotatorId);
                    } else {
                        showNextActivity(theContext, nextActivity, aGame);
                    }
                }
            }
        });
    }

    /**
     * Let the user decide between throw kings to make the teams or go directly to the annotator and then show the next Activity.
     *
     * @param theContext
     *         The context where the next Intent will be showed.
     * @param aGame
     *         An instance of a Truco game to add as parameter to next Activity.
     *
     * @since 15
     */
    private void addCustomNavigationFlowForTrucoAnnotator(final Context theContext, final Game aGame) {
        AlertDialog.Builder builder = new AlertDialog.Builder(theContext);
        builder.setMessage(getText(R.string.trucoAnnotator_doYouWannaThrowKings))
               .setPositiveButton(getText(R.string.trucoAnnotator_throwKings),
                                  new DialogInterface.OnClickListener() {

                                      public void onClick(DialogInterface dialog, int id) {
                                          showNextActivity(theContext, ChoosePlayersActivity.class, aGame);
                                      }
                                  })
               .setNegativeButton(getText(R.string.trucoAnnotator_annotateNow),
                                  new DialogInterface.OnClickListener() {

                                      public void onClick(DialogInterface dialog, int id) {
                                          showNextActivity(theContext, TrucoAnnotatorActivity.class, aGame);
                                      }
                                  });
        builder.show();
    }

    /**
     * Setups the GoogleAnalyticsTracker and starts a new session. For this land-activity, it also tracks the page view.
     *
     * @since 15
     */
    private void setUpAnalytics() {
        GoogleAnalyticsTracker tracker = GoogleAnalyticsTracker.getInstance();

        // Start the tracker with a dispatch interval (in seconds).
        tracker.startNewSession(AppParameter.GA_KEY, AppParameter.GA_DISPATCH_INTERVAL, this);

        tracker.trackPageView(GoogleAnalyticsUtil.generatePageName(TAG));
    }

    /**
     * Show {@code nextActivity} to the user setting the {@code annotatoId} parameter as a parameter to the next activity.
     *
     * @param context
     *         The context where the next Intent will be showed.
     * @param nextActivity
     *         Next activity to show to the user.
     * @param annotatoId
     *         The Id of the annotator selected by the user.
     *
     * @since 1
     */
    private <T extends Activity> void showNextActivity(Context context, Class<T> nextActivity, int annotatoId) {
        showNextActivity(context, nextActivity, annotatoId, null);
    }

    /**
     * Show {@code nextActivity} to the user setting the {@code aGame} parameter as a parameter to the next activity.
     *
     * @param context
     *         The context where the next Intent will be showed.
     * @param nextActivity
     *         Next activity to show to the user.
     * @param aGame
     *         The Game to pass as parameter to the next activity.
     */
    private <T extends Activity> void showNextActivity(Context context, Class<T> nextActivity, Game aGame) {
        showNextActivity(context, nextActivity, -1, aGame);
    }

    /**
     * Show {@code nextActivity} to the user setting the {@code aGame} parameter or the {@code annotatorId} as a parameter to the next activity.
     *
     * @param theContext
     *         The context where the next Intent will be showed.
     * @param nextActivity
     *         Next activity to show to the user.
     * @param annotatorId
     *         The Id of the annotator selected by the user.
     * @param aGame
     *         The Game to pass as parameter to the next activity.
     *
     * @since 15
     */
    private <T extends Activity> void showNextActivity(Context theContext, Class<T> nextActivity, int annotatorId, Game aGame) {
        Intent nextIntentToShow = new Intent(theContext, nextActivity);

        if (aGame != null) {
            nextIntentToShow.putExtra(AppParameter.GAME, aGame);
        } else {
            nextIntentToShow.putExtra(AppParameter.GAME, annotatorId);
        }

        startActivity(nextIntentToShow);
    }

    /**
     * Open the AboutActivity. This method is called from the layout definition.
     *
     * @param callerView
     *         View that called this method.
     */
    public void openAboutActivity(View callerView) {
        startActivity(new Intent(callerView.getContext(), AboutActivity.class));
    }
}
