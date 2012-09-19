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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.nbempire.android.magicannotator.R;

/**
 * TODO : JavaDoc : for TrucoScoreListener.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 01/03/2012, 08:56:40.
 */
public class TrucoScoreListener implements TextWatcher, OnTouchListener {

    protected ToggleButton toggleButton;

    protected String winMessageText;

    protected TextView scoreToUpdate;

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     * 
     * @author Nahuel Barrios.
     * @param scoreToUpdate
     * @since 03/03/2012.
     */
    public TrucoScoreListener(EditText scoreToUpdate) {
        this.scoreToUpdate = scoreToUpdate;
    }

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     * 
     * @author Nahuel Barrios.
     * @since 08/03/2012.
     * @param scoreToUpdate
     */
    public TrucoScoreListener(TextView scoreToUpdate) {
        this.scoreToUpdate = scoreToUpdate;
    }

    /**
     * A constructor method for the {@link TrucoScoreListener} type.
     * 
     * @author Nahuel Barrios.
     * @since 01/03/2012.
     * @param toggleButton
     * @param winButton
     * @param winMessageText
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
                                                        return;
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
            updatedValue = new Integer(Integer.parseInt(currentValue) + 1).toString();
        }

        if (!updatedValue.toString().equals("31")) {
            scoreToUpdate.setText(updatedValue);
        }

        return false;
    }

}
