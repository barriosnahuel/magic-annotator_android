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
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.domain.game.Truco;
import com.nbempire.android.magicannotator.service.GameFactory;
import com.nbempire.android.magicannotator.service.GamesActivitiesFactory;

/**
 * Android Activity to let user choose the annotator to use.
 * <p/>
 * TODO : Refactor :  Rename type ChooseGameActivity because there isn't only games.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ChooseGameActivity extends Activity {

    private Intent nextIntentToShow;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosegame);

        ListView games = (ListView) findViewById(R.id.main_gamesListView);
        games.setAdapter(ArrayAdapter.createFromResource(this, R.array.chooseGame_gamesValues,
                                                                android.R.layout.simple_list_item_1));
        games.setTextFilterEnabled(true);

        games.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemKey = ((TextView) parent.getChildAt(position)).getText().toString();
                final Game aGame = GameFactory.getInstance(selectedItemKey);
                final Context theContext = view.getContext();
                if (aGame != null) {

                    if (aGame.getClass().equals(Truco.class)) {
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
        nextIntentToShow = new Intent(theContext, nextIntent);
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
        nextIntentToShow = new Intent(theContext, nextIntent);
        nextIntentToShow.putExtra(AppParameter.GAME, aGame);
        startActivityForResult(nextIntentToShow, 0);
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
