/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoScoreListener.java Created by: Nahuel Barrios: 01/03/2012, 08:56:40.
 */
package com.nbempire.android.magicannotator.listener;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.nbempire.android.magicannotator.GameKeys;
import com.nbempire.android.magicannotator.R;

/**
 * Listener class to update scores of a Truco game.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TrucoScoreListener implements OnTouchListener {

    /**
     * The message to show when one team win.
     */
    private final String winMessageText;

    /**
     * The TextView to update.
     */
    private final TextView scoreToUpdate;

    /**
     * List of Views to disable when one team wins.
     */
    private final List<View> viewsToDisable;

    /**
     * A constructor method for the type.
     *
     * @param scoreToUpdate
     *         The TextView to update.
     * @param winMessageText
     *         The message to show when one team win.
     * @param viewsToDisable
     *         List of Views to disable when one team wins.
     *
     * @since 1
     */
    public TrucoScoreListener(TextView scoreToUpdate, CharSequence winMessageText, List<View> viewsToDisable) {
        this.scoreToUpdate = scoreToUpdate;
        this.winMessageText = winMessageText.toString();
        this.viewsToDisable = viewsToDisable;
    }

    public boolean onTouch(View view, MotionEvent event) {
        int currentValue = Integer.valueOf(scoreToUpdate.getText().toString());

        if (currentValue < GameKeys.TRUCO_MAX_SCORE) {
            int updatedValue = currentValue + GameKeys.TRUCO_INCREMENT;
            scoreToUpdate.setText(String.valueOf(updatedValue));

            if (updatedValue == GameKeys.TRUCO_MAX_SCORE) {
                showWinMessageAlert(view.getContext());
                disableLooserTeamControls();
            }
        }

        return false;
    }

    /**
     * Show the alert message when the team wins.
     *
     * @param context
     *         The view's context.
     */
    private void showWinMessageAlert(Context context) {
        AlertDialog winMessageAlertDialog = new AlertDialog.Builder(context).create();
        winMessageAlertDialog.setTitle(winMessageText);
        winMessageAlertDialog.setButton(context.getText(R.string.commonLabel_OK),
                                               new DialogInterface.OnClickListener() {

                                                   public void onClick(DialogInterface dialog, int which) {
                                                       //  Do nothing.
                                                   }
                                               });
        winMessageAlertDialog.show();
    }

    /**
     * Disable each View from {@code viewsToDisable} by setting the {@code enabled} property as {@code false}.
     *
     * @since 6
     */
    private void disableLooserTeamControls() {
        for (View eachView : viewsToDisable) {
            eachView.setEnabled(false);
        }
    }

}
