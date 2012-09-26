/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * MakeTeamsActivity.java Created by: Nahuel Barrios: 29/02/2012, 10:34:20.
 */
package com.nbempire.android.magicannotator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.service.AnnotatorFactory;
import com.nbempire.android.magicannotator.service.ServiceFactory;
import com.nbempire.android.magicannotator.util.ExpandableList;
import com.nbempire.android.magicannotator.util.android.SimpleExpandableListActivity;

/**
 * TODO : JavaDoc : for MakeTeamsActivity.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ViewTeamsActivity extends SimpleExpandableListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Game aGame = (Game) this.getIntent().getExtras().getSerializable(AppParameter.GAME);
        ExpandableList expandable = ServiceFactory.getInstance(aGame).getExpandableTeams(aGame.getTeams());

        super.onCreate(savedInstanceState, expandable);
        setContentView(R.layout.viewteams);

        this.registerForContextMenu(getExpandableListView());

        this.addOnClickActionForPlayButton();
    }

    /**
     * Adds onClick funcionality to the "play" button. It starts the next activity to show.
     *
     * @since 1
     */
    private void addOnClickActionForPlayButton() {
        Button play = (Button) findViewById(R.id.viewteams_button_play);
        play.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Game aGame = (Game) getIntent().getExtras().getSerializable(AppParameter.GAME);

                Intent nextIntentToShow = new Intent(view.getContext(), AnnotatorFactory.getFor(aGame));
                nextIntentToShow.putExtra(AppParameter.GAME, aGame);
                startActivityForResult(nextIntentToShow, 0);
            }
        });
    }

}
