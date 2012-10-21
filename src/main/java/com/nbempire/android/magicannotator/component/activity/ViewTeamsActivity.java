/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * MakeTeamsActivity.java Created by: Nahuel Barrios: 29/02/2012, 10:34:20.
 */
package com.nbempire.android.magicannotator.component.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.AppParameter;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.game.Game;
import com.nbempire.android.magicannotator.exception.TeamShouldHasPlayersException;
import com.nbempire.android.magicannotator.service.AnnotatorService;
import com.nbempire.android.magicannotator.service.ServiceFactory;
import com.nbempire.android.magicannotator.service.impl.AnnotatorServiceImpl;
import com.nbempire.android.magicannotator.util.ExpandableList;
import com.nbempire.android.magicannotator.util.android.SimpleExpandableListActivity;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;

/**
 * Android activity to show the user the auto-generated teams.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ViewTeamsActivity extends SimpleExpandableListActivity {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "ViewTeamsActivity";

    /**
     * Service for the annotators.
     */
    private final AnnotatorService annotatorService = new AnnotatorServiceImpl();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(LOG_TAG));

        Game aGame = (Game) this.getIntent().getExtras().getSerializable(AppParameter.GAME);
        ExpandableList expandable = null;
        try {
            expandable = ServiceFactory.getInstance(aGame).getExpandableTeams(aGame.getTeams());
        } catch (TeamShouldHasPlayersException e) {
            //  TODO : Functionality : Return to last activity.
            Log.e(LOG_TAG, e.getMessage());
        }

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

                Intent nextIntentToShow = new Intent(view.getContext(), annotatorService.get(aGame));
                nextIntentToShow.putExtra(AppParameter.GAME, aGame);
                startActivity(nextIntentToShow);
            }
        });
    }

}
