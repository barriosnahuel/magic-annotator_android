/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.util.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

/**
 * GUI entity type to use with the {@code scoreeditor_horizontal.xml} layout because it does its functionality. User can use it from layout
 * resources with or without setting the {@code increment} XML attribute. If you don't pass that attribute, its default value will be {@code 1}.
 * <p/>
 * Use example in XML layout file:
 * <p/>
 * &lt;com.nbempire.android.magicannotator.util.android.view.ScoreEditorView android:id="@+id/anId"/&gt;
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ScoreEditorView extends RelativeLayout {

    /**
     * {@link String} El nombre del jugador que se va a mostrar vinculado con el puntaje.
     */
    private final String playerNickname;

    /**
     * The default increment used to add/substract scores.
     */
    private static final int DEFAULT_INCREMENT = 1;

    /**
     * A constructor method for the type.
     *
     * @param context
     *         The view's context.
     * @param playerNickname
     *         The name of the player linked with this ScoreEditorView.
     */
    public ScoreEditorView(Context context, String playerNickname) {
        super(context);
        this.playerNickname = playerNickname;
        initializeView(context);
    }

    /**
     * A constructor method for the type.
     *
     * @param context
     *         The view's context.
     */
    private void initializeView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.scoreeditor_horizontal, this, true);

        TextView textView = (TextView) findViewById(R.id.playerNickname);
        textView.setEms(3);
        textView.setText(playerNickname);

        EditText editText = (EditText) findViewById(R.id.score);
        editText.setId(ViewsUtil.generateViewId(playerNickname));

        addOnTouchActions(DEFAULT_INCREMENT);
    }

    /**
     * Add corresponding functionality to add/substract buttons when users touch the screen.
     *
     * @param increment
     *         The increment used to add/substract scores.
     */
    public void addOnTouchActions(int increment) {
        Button plus = (Button) findViewById(R.id.plusButton);
        plus.setOnTouchListener(new ScoreEditorOnTouchListener(increment));

        Button substract = (Button) findViewById(R.id.substractButton);
        substract.setOnTouchListener(new ScoreEditorOnTouchListener(increment, true));
    }

    /**
     * Listener that implements {@link OnTouchListener} to do the functionality to add/substract score.
     * <p/>
     * TODO : Refactor : Move this type outside to re-use it.
     *
     * @author Nahuel Barrios.
     * @since 1
     */
    class ScoreEditorOnTouchListener implements OnTouchListener {

        private boolean forSubstract = false;

        private int increment = 1;

        /**
         * A constructor method for the type.
         *
         * @param increment
         *         The increment used to add scores.
         */
        public ScoreEditorOnTouchListener(int increment) {
            super();
            this.increment = increment;
        }

        /**
         * A constructor method for the type.
         *
         * @param increment
         *         The increment used to add/substract scores depending on the value of {@code forSubstract} parameter.
         * @param forSubstract
         *         Boolean value indicating with {@code true} when the listener has to substract, or {@code false} for add.
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

                    updateScore((EditText) findViewById(ViewsUtil.generateViewId(playerNickname)), newValue);
                    break;
                default:
                    break;
            }
            return false;
        }

    }

    /**
     * Add value of {@code increment} to the current value of the specified {@code editText}.
     * <p/>
     * Please note that this method always add the {@code increment} value to the current value, so if you want to substract you will transform
     * {@code increment} to the negative form.
     *
     * @param editText
     *         The editText to update.
     * @param increment
     *         The increment used to add scores.
     */
    private void updateScore(EditText editText, int increment) {
        String currentValue = editText.getText().toString();
        editText.setText(Integer.toString(Integer.parseInt(currentValue) + increment));
    }

}
