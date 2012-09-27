/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * ChoosePlayersActivity.java Created by: Nahuel Barrios: 29/02/2012, 09:22:36.
 */
package com.nbempire.android.magicannotator.activity;

import java.util.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TableRow.LayoutParams;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.Team;
import com.nbempire.android.magicannotator.domain.exception.UserException;
import com.nbempire.android.magicannotator.domain.game.Chancho;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.service.AnnotatorFactory;
import com.nbempire.android.magicannotator.service.GamesActivitiesFactory;
import com.nbempire.android.magicannotator.service.PlayerService;
import com.nbempire.android.magicannotator.service.ServiceFactory;
import com.nbempire.android.magicannotator.service.impl.PlayerServiceImpl;

/**
 * TODO : JavaDoc : for ChoosePlayersActivity.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ChoosePlayersActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "ChoosePlayersActivity";

    private ArrayList<String> selectedPlayers = new ArrayList<String>();

    private PlayerService playerService = new PlayerServiceImpl();

    private static final String SELECTED_PLAYERS_KEY = "selectedPlayers";

    private static final String ALL_PLAYERS = "allPlayers";

    private Set<CharSequence> players = new TreeSet<CharSequence>();

    private Game aGame;

    int gameKey = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseplayers);

        Bundle extras = getIntent().getExtras();
        Object parameter = extras.get(AppParameter.GAME);

        if (parameter instanceof Game) {
            aGame = (Game) extras.getSerializable(AppParameter.GAME);
            if (aGame instanceof Chancho) {
                ((Button) this.findViewById(R.id.choosePlayers_button_makeTeams)).setText(R.string.play);
            }
        } else {
            gameKey = extras.getInt(AppParameter.GAME);
            switch (gameKey) {
                case R.string.gamename_otro:
                    ((Button) this.findViewById(R.id.choosePlayers_button_makeTeams)).setText(R.string.play);
                    break;
                default:
                    break;
            }
        }

        if (savedInstanceState != null) {
            players.addAll(savedInstanceState.getStringArrayList(ALL_PLAYERS));
        } else {
            // TODO : Delete : This line or context when begin using a DB.
            ArrayAdapter<CharSequence> playersAdapter = ArrayAdapter.createFromResource(this,
                                                                                               R.array.choosePlayers_playersValues, 0);
            for (int index = 0; index < playersAdapter.getCount(); index++) {
                players.add(playersAdapter.getItem(index));
            }
        }

        this.loadDefaultPlayers(savedInstanceState == null ? new ArrayList<String>()
                                        : savedInstanceState.getStringArrayList(SELECTED_PLAYERS_KEY));

        if (parameter instanceof Game) {
            this.addOnClickActionForMakeTeamsButton();
        } else {
            this.addOnClickActionForMakeTeamsButtonNuevo();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(SELECTED_PLAYERS_KEY, selectedPlayers);

        ArrayList<String> toAdd = new ArrayList<String>();
        Iterator<CharSequence> iterator = players.iterator();
        while (iterator.hasNext()) {
            toAdd.add(iterator.next().toString());
        }

        outState.putStringArrayList(ALL_PLAYERS, toAdd);
        super.onSaveInstanceState(outState);
    }

    /**
     * Cargo los jugadores dinámicamente.
     *
     * @param selectedPlayersList
     *         {@link List} de {@link String} con los jugadores ya seleccionados para ver cu�les tengo que tildar.
     */
    private void loadDefaultPlayers(List<String> selectedPlayersList) {
        TableLayout playersLayout = (TableLayout) findViewById(R.id.choosePlayers_playersLayout);

        Iterator<CharSequence> iterator = players.iterator();
        while (iterator.hasNext()) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

            String playerName = (iterator.next()).toString();
            tableRow.addView(this.preparePlayerSelector(playerName, selectedPlayersList.contains(playerName)));
            playersLayout.addView(tableRow);
        }
    }

    /**
     * TODO : JavaDoc : for ChoosePlayersActivity.preparePlayerSelector()
     *
     * @param playerName
     *
     * @return
     *
     * @since 1
     */
    private View preparePlayerSelector(String playerName, boolean checked) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(playerName);
        if (checked) {
            checkBox.setChecked(checked);
            selectedPlayers.add(playerName);
        }
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selectedPlayers.add(buttonView.getText().toString());
                } else {
                    selectedPlayers.remove(buttonView.getText().toString());
                }
                Toast.makeText(getApplicationContext(),
                                      getText(R.string.choosePlayers_selected).toString() + " " + selectedPlayers.size(),
                                      Toast.LENGTH_SHORT).show();
            }
        });
        return checkBox;
    }

    /**
     * Método llamado desde la definición del layout para permitir al usuario crear un jugador nuevo, y de crearlo, agregarlo al listado ya
     * tildado.
     *
     * @param view
     *         {@link View} desde la cuál se llamó a este método.
     *
     * @author Nahuel Barrios.
     */
    public void openPlayerCreator(View view) {
        final EditText input = new EditText(view.getContext());

        new AlertDialog.Builder(this).setTitle(R.string.newplayer_enterNickName).setView(input)
                .setPositiveButton(R.string.newplayer_createPlayer, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        String newPlayerNickname = input.getText().toString();
                        if (newPlayerNickname.length() > 0) {
                            if (!addCheckedDynamicPlayer(newPlayerNickname)) {
                                Toast.makeText(getApplicationContext(),
                                                      newPlayerNickname
                                                              + " "
                                                              + getText(R.string.choosePlayers_playerAlreadyExists).toString(),
                                                      Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }).show();
    }

    /**
     * Creates functionality for make teams button.
     *
     * @since 1
     */
    private void addOnClickActionForMakeTeamsButtonNuevo() {
        ((Button) findViewById(R.id.choosePlayers_button_makeTeams)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent nextIntentToShow = new Intent(view.getContext(), GamesActivitiesFactory.getAnnotator(gameKey));

                nextIntentToShow.putExtra(AppParameter.GAME, gameKey);
                nextIntentToShow.putExtra(AppParameter.PLAYERS, selectedPlayers);

                startActivity(nextIntentToShow);
            }
        });
    }

    /**
     * Creo la acción para el botón armar equipos. TODO : Refactor : Sacar este método y dejar el nuevo.
     *
     * @since 1
     */
    private void addOnClickActionForMakeTeamsButton() {
        ((Button) findViewById(R.id.choosePlayers_button_makeTeams)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {

                    List<Team> teams = ServiceFactory.getInstance(aGame).makeTeams(playerService.parsePlayers(selectedPlayers));
                    aGame.setTeams(teams);

                    Intent nextIntentToShow;
                    if (teams.size() > 1) {
                        nextIntentToShow = new Intent(view.getContext(), ViewTeamsActivity.class);
                    } else {
                        nextIntentToShow = new Intent(view.getContext(), AnnotatorFactory.getFor(aGame));
                    }

                    nextIntentToShow.putExtra(AppParameter.GAME, aGame);
                    startActivity(nextIntentToShow);
                } catch (UserException userException) {
                    Log.e(LOG_TAG, userException.getMessage());

                    AlertDialog winMessageAlertDialog = new AlertDialog.Builder(view.getContext()).create();
                    winMessageAlertDialog.setTitle(userException.getGuiMessage());
                    winMessageAlertDialog.setButton(getText(R.string.commonLabel_OK), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            //  Do nothing.
                        }
                    });
                    winMessageAlertDialog.show();
                }
            }
        });
    }

    /**
     * Adds a new row to the table layout. This new row will show a checked checkbox containing as label the playerNickName parameter.
     *
     * @param playerNickName
     *         {@link String} with the player's nickname.
     *
     * @return {@link boolean} <code>true</code> if the player was added. <code>false</code> otherwise.
     *
     * @since 1
     */
    private boolean addCheckedDynamicPlayer(String playerNickName) {
        boolean added = players.add(playerNickName);
        if (added) {
            TableLayout playersLayout = (TableLayout) findViewById(R.id.choosePlayers_playersLayout);
            TableRow tableRow = new TableRow(playersLayout.getContext());
            tableRow.addView(this.preparePlayerSelector(playerNickName, true));
            playersLayout.addView(tableRow);
        }
        return added;
    }

}
