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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.nbempire.android.magicannotator.R;

/**
 * Listener class to update scores of a Truco game.
 *
 * @author Nahuel Barrios.
 * @since 0.1
 */
public class TrucoScoreListener implements TextWatcher, OnTouchListener {

    protected ToggleButton toggleButton;

    protected String winMessageText;

    protected TextView scoreToUpdate;

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     *
     * @param scoreToUpdate
     *         The TextView to update.
     *
     * @since 0.1
     */
    public TrucoScoreListener(TextView scoreToUpdate) {
        this.scoreToUpdate = scoreToUpdate;
    }

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     *
     * @param toggleButton
     *         The ToggleButton.
     * @param winMessageText
     *         The message to show when one team win.
     *
     * @since 0.1
     */
    public TrucoScoreListener(ToggleButton toggleButton, CharSequence winMessageText) {
        super();
        this.toggleButton = toggleButton;
        this.winMessageText = winMessageText.toString();
    }

    public void afterTextChanged(Editable input) {
        if (input.length() > 1) {
            int value = Integer.valueOf(input.toString());
            if (value < 15) {
                if (toggleButton.isChecked()) {
                    toggleButton.performClick();
                }
            } else if (!toggleButton.isChecked()) {
                toggleButton.performClick();
            }
            if (value >= 30) {
                AlertDialog winMessageAlertDialog = new AlertDialog.Builder(toggleButton.getContext()).create();
                winMessageAlertDialog.setTitle(winMessageText);
                winMessageAlertDialog.setButton(toggleButton.getContext().getText(R.string.commonLabel_OK),
                                                       new DialogInterface.OnClickListener() {

                                                           public void onClick(DialogInterface dialog, int which) {
                                                               //  Do nothing.
                                                           }
                                                       });
                winMessageAlertDialog.show();
            }
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        String currentValue = scoreToUpdate.getText().toString();
        String updatedValue;
        if (currentValue.length() == 0) {
            updatedValue = "1";
        } else {
            updatedValue = Integer.toString(Integer.parseInt(currentValue) + 1);
        }

        if (!updatedValue.equals("31")) {
            scoreToUpdate.setText(updatedValue);
        }

        return false;
    }

}
