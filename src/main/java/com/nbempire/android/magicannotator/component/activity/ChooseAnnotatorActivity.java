/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.service.GameFactory;
import com.nbempire.android.magicannotator.service.GamesActivitiesFactory;
import com.nbempire.android.magicannotator.util.android.analytics.AnalyticsUtil;

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
    private static final String LOG_TAG = "ChooseAnnotatorActivity";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpAnalytics();

        setContentView(R.layout.choosegame);

        ListView availableAnnotators = (ListView) findViewById(R.id.main_gamesListView);
        availableAnnotators.setAdapter(ArrayAdapter.createFromResource(this, R.array.chooseGame_gamesValues,
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

                final Game aGame = GameFactory.getInstance(selectedItemKey);
                final Context theContext = view.getContext();

                if (aGame != null) {
                    if (aGame.getClass().equals(Truco.class)) {
                        addCustomNavigationFlowForTrucoAnnotator(theContext, aGame);
                    } else {
                        showNextActivity(theContext, ChoosePlayersActivity.class, aGame);
                    }
                } else {
                    // el juego es null, entonces estoy en Otro y tengo que hacerlo de la forma
                    // correcta

                    if (selectedItemKey.equals(getText(R.string.gamename_market))) {
                        showNextActivity(theContext, MarketAnnotatorActivity.class);
                    } else {
                        showNextActivity(theContext, ChoosePlayersActivity.class, GamesActivitiesFactory.getGameKey(selectedItemKey));
                    }


                }

            }
        });
    }

    /**
     * TODO : Javadoc for addCustomNavigationFlowForTrucoAnnotator
     *
     * @param theContext
     * @param aGame
     *
     * @since 15
     */
    private void addCustomNavigationFlowForTrucoAnnotator(final Context theContext, final Game aGame) {
        AlertDialog.Builder builder = new AlertDialog.Builder(theContext);
        builder.setMessage(getText(R.string.trucoAnnotator_doYouWannaThrowKings))
                .setCancelable(false)
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

        tracker.trackPageView(AnalyticsUtil.generatePageName(LOG_TAG));
    }

    /**
     * Show {@code nextIntent} without setting any parameter to next activity.
     *
     * @param theContext
     *         The context.
     * @param nextIntent
     *         Next activity to show to the user.
     *
     * @since 8
     */
    public <T extends Activity> void showNextActivity(Context theContext, Class<T> nextIntent) {
        showNextActivity(theContext, nextIntent, -1);
    }

    /**
     * Show {@code nextIntent} to the user setting the {@code gameKey} parameter as a parameter to the next activity.
     *
     * @param theContext
     *         The context.
     * @param nextIntent
     *         Next activity to show to the user.
     * @param gameKey
     *         Game's key parameter to the next activity.
     *
     * @since 1
     */
    public <T extends Activity> void showNextActivity(Context theContext, Class<T> nextIntent, int gameKey) {
        Intent nextIntentToShow = new Intent(theContext, nextIntent);
        if (gameKey != -1) {
            nextIntentToShow.putExtra(AppParameter.GAME, gameKey);
        }
        startActivity(nextIntentToShow);
    }

    /**
     * Show {@code nextIntent} to the user setting the {@code aGame} parameter as a parameter to the next activity.
     *
     * @param theContext
     *         The context.
     * @param nextIntent
     *         Next activity to show to the user.
     * @param aGame
     *         The Game to pass as parameter to the next activity.
     */
    public <T extends Activity> void showNextActivity(Context theContext, Class<T> nextIntent, Game aGame) {
        Intent nextIntentToShow = new Intent(theContext, nextIntent);
        nextIntentToShow.putExtra(AppParameter.GAME, aGame);
        startActivity(nextIntentToShow);
    }

    /**
     * Open the AboutActivity. This method is called from the layout definition.
     *
     * @param callerView
     *         View that called this method.
     *
     * @since 1
     */
    public void openAboutActivity(View callerView) {
        startActivity(new Intent(callerView.getContext(), AboutActivity.class));
    }
}
