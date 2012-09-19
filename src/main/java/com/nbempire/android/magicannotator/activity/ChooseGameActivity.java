package com.nbempire.android.magicannotator.activity;

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
 * TODO : JavaDoc : for ChooseGameActivity.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 01:13:50.
 */
public class ChooseGameActivity extends Activity {

    private Intent nextIntentToShow;

    /** Called when the activity is first created. */
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
                    showNextActivity(theContext, ChoosePlayersActivity.class, GamesActivitiesFactory.getGameKey(selectedItemKey));
                }

            }
        });
    }

    /**
     * TODO : JavaDoc : for ChooseGameActivity.showNextActivity().
     * 
     * @author Nahuel Barrios.
     * @param theContext
     * @param nextIntent
     * @param gameKey
     */
    public <T extends Activity> void showNextActivity(Context theContext, Class<T> nextIntent, int gameKey) {
        nextIntentToShow = new Intent(theContext, nextIntent);
        nextIntentToShow.putExtra(AppParameter.GAME, gameKey);
        startActivity(nextIntentToShow);
    }

    /**
     * TODO : JavaDoc : for ChooseGameActivity.showNextActivity().
     * 
     * @author Nahuel Barrios.
     * @param theContext
     * @param nextIntent
     * @param aGame
     */
    public <T extends Activity> void showNextActivity(Context theContext, Class<T> nextIntent, Game aGame) {
        nextIntentToShow = new Intent(theContext, nextIntent);
        nextIntentToShow.putExtra(AppParameter.GAME, aGame);
        startActivityForResult(nextIntentToShow, 0);
    }

    /**
     * TODO : JavaDoc : for ChooseGameActivity.openAboutActivity()
     * 
     * @author Nahuel Barrios.
     * @since 14/04/2012.
     * @param view
     */
    public void openAboutActivity(View view) {
        startActivity(new Intent(view.getContext(), AboutActivity.class));
    }

    /**
     * TODO : JavaDoc : for ChooseGameActivity.openViewBugsActivity()
     * 
     * @author Nahuel Barrios.
     * @since 14/04/2012.
     * @param view
     */
    public void openViewBugsActivity(View view) {
        startActivity(new Intent(view.getContext(), ViewCurrentBugsActivity.class));
    }
}
