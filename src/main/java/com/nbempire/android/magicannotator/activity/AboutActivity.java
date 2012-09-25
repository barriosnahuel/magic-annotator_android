/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AboutActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:38:58.
 */
package com.nbempire.android.magicannotator.activity;

import android.app.Activity;
import android.os.Bundle;
import com.nbempire.android.magicannotator.R;

/**
 * TODO : JavaDoc : for AboutActivity.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 14/04/2012, 09:38:58.
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

}
