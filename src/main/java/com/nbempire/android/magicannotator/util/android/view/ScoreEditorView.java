/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.util.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

/**
 * TODO : JavaDoc : for ScoreEditorView.
 * <p/>
 * Use example in XML layout file:
 * <p/>
 * &lt;com.nbempire.android.magicannotator.util.android.view.ScoreEditorView android:id="@+id/anId"/&gt;
 * <p/>
 * Other use example passing the increment:
 * <p/>
 * &lt;com.nbempire.android.magicannotator.util.android.view.ScoreEditorView android:id="@+id/anId" increment="2" /&gt;
 *
 * @author Nahuel Barrios.
 */
public class ScoreEditorView extends RelativeLayout {

    /**
     * {@link String} El nombre del jugador que se va a mostrar vinculado con el puntaje.
     */
    private String playerNickname;

    /**
     * A constructor method for the {@link ScoreEditorView} type.
     *
     * @param context
     * @param playerNickname
     */
    public ScoreEditorView(Context context, String playerNickname) {
        super(context);
        this.playerNickname = playerNickname;
        initializeView(context, null);
    }

    /**
     * A constructor method for the {@link ScoreEditorView} type.
     *
     * @param context
     * @param attributes
     */
    public ScoreEditorView(Context context, AttributeSet attributes) {
        super(context, attributes);

        initializeView(context, attributes);
    }

    /**
     * A constructor method for the {@link ScoreEditorView} type.
     *
     * @param context
     * @param attributes
     * @param defStyle
     */
    public ScoreEditorView(Context context, AttributeSet attributes, int defStyle) {
        super(context, attributes, defStyle);
        initializeView(context, attributes);
    }

    /**
     * TODO : JavaDoc : for ScoreEditorView.initializeView().
     *
     * @param context
     * @param attributes
     */
    private void initializeView(Context context, AttributeSet attributes) {
        int increment = 1;
        if (attributes != null) {
            attributes.getAttributeIntValue(null, "increment", increment);
        }

        initializeView(context, increment);
    }

    /**
     * TODO : JavaDoc : for ScoreEditorView.initializeView().
     *
     * @param context
     * @param increment
     */
    private void initializeView(Context context, int increment) {
        LayoutInflater.from(context).inflate(R.layout.scoreeditor_horizontal, this, true);

        TextView textView = (TextView) findViewById(R.id.playerNickname);
        textView.setEms(3);
        textView.setText(playerNickname);

        EditText editText = (EditText) findViewById(R.id.score);
        editText.setId(generateViewId(playerNickname));

        addOnTouchActions(increment);
    }

    /**
     * TODO : JavaDoc : for ScoreEditorView.addOnTouchActions().
     *
     * @param increment
     */
    public void addOnTouchActions(int increment) {
        Button plus = (Button) findViewById(R.id.plusButton);
        plus.setOnTouchListener(new ScoreEditorOnTouchListener(increment));

        Button substract = (Button) findViewById(R.id.substractButton);
        substract.setOnTouchListener(new ScoreEditorOnTouchListener(increment, true));
    }

    /**
     * TODO : JavaDoc : for ScoreEditorOnTouchListener. Pasar esta clase afuera y ver de refactorear la del truco pudiendole pasar a esta un
     * validador.
     *
     * @author Nahuel Barrios.
     */
    class ScoreEditorOnTouchListener implements OnTouchListener {

        private boolean forSubstract = true;

        private int increment = 1;

        /**
         * A constructor method for the {@link ScoreEditorOnTouchListener} type.
         */
        public ScoreEditorOnTouchListener() {
            super();
            this.forSubstract = false;
        }

        /**
         * A constructor method for the {@link ScoreEditorOnTouchListener} type.
         *
         * @param increment
         */
        public ScoreEditorOnTouchListener(int increment) {
            super();
            this.increment = increment;
            this.forSubstract = false;
        }

        /**
         * A constructor method for the {@link ScoreEditorOnTouchListener} type.
         *
         * @param increment
         * @param forSubstract
         */
        public ScoreEditorOnTouchListener(int increment, boolean forSubstract) {
            super();
            this.increment = increment;
            this.forSubstract = forSubstract;
        }

        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    int newValue = increment;
                    if (forSubstract) {
                        newValue = increment * -1;
                    }

                    updateScore((EditText) findViewById(generateViewId(playerNickname)), newValue);
                    break;
                default:
                    break;
            }
            return false;
        }

    }

    /**
     * Actualiza el valor original en base al incremento que le pasamos. TODO : JavaDoc : for ScoreEditorView.updateScore().
     *
     * @param editText
     * @param value
     */
    private void updateScore(EditText editText, int value) {
        String currentValue = editText.getText().toString();
        editText.setText(Integer.toString(Integer.parseInt(currentValue) + value));
    }

    /**
     * Returns the absolute value of the hashCode() method.
     *
     * @param anObject
     *         {@link Object} an object to get some unique property to use as an Id.
     *
     * @return Positive {@link Integer} to use as an Id for an Android {@link View}.
     */
    private int generateViewId(Object anObject) {
        return Math.abs(anObject.hashCode());
    }

}
