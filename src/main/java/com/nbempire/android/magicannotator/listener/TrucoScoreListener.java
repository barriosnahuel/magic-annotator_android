/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TrucoScoreListener.java Created by: Nahuel Barrios: 01/03/2012, 08:56:40.
 */
package com.nbempire.android.magicannotator.listener;

import android.app.AlertDialog;
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
     * <p/>
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
        String currentValue = scoreToUpdate.getText().toString();
        String updatedValue;
        if (currentValue.length() == 0) {
            updatedValue = "1";
        } else {
            updatedValue = Integer.toString(Integer.parseInt(currentValue) + 1);
        }

        int value = Integer.valueOf(updatedValue);
        if (value <= 30) {
            scoreToUpdate.setText(updatedValue);
            if (value == 30) {
                AlertDialog winMessageAlertDialog = new AlertDialog.Builder(view.getContext()).create();
                winMessageAlertDialog.setTitle(winMessageText);
                winMessageAlertDialog.setButton(view.getContext().getText(R.string.commonLabel_OK),
                                                       new DialogInterface.OnClickListener() {

                                                           public void onClick(DialogInterface dialog, int which) {
                                                               //  Do nothing.
                                                           }
                                                       });
                winMessageAlertDialog.show();
            }
        }

        return false;
    }

}
