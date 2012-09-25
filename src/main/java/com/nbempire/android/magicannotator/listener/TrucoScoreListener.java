/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoScoreListener.java Created by: Nahuel Barrios: 01/03/2012, 08:56:40.
 */
package com.nbempire.android.magicannotator.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

/**
 * Listener class to update scores of a Truco game.
 *
 * @author Nahuel Barrios.
 * @since 0.1
 */
public class TrucoScoreListener implements OnTouchListener {

    protected String winMessageText;

    protected TextView scoreToUpdate;

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     *
     * @param scoreToUpdate
     *         The TextView to update.
     * @param winMessageText
     *         The message to show when one team win.
     *
     * @since 0.1
     */
    public TrucoScoreListener(TextView scoreToUpdate, CharSequence winMessageText) {
        super();
        this.scoreToUpdate = scoreToUpdate;
        this.winMessageText = winMessageText.toString();
    }

    public boolean onTouch(View view, MotionEvent event) {
        int currentValue = Integer.valueOf(scoreToUpdate.getText().toString());

        if (currentValue < 30) {
            int updatedValue = currentValue + 1;
            scoreToUpdate.setText(String.valueOf(updatedValue));

            if (updatedValue == 30) {
                showWinMessageAlert(view.getContext());
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

}
