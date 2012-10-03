/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * AboutActivity.java Created by: Nahuel Barrios: 14/04/2012, 09:38:58.
 */
package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.os.Bundle;
import com.nbempire.android.magicannotator.R;

/**
 * Activity to prepare the about section. It only loads the layout.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

}
