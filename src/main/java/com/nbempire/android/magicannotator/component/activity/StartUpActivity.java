/*
 * Magic Annotator - The only thing you need to write down whatever you want.
 * Copyright (C) 2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nbempire.android.magicannotator.component.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.nbempire.android.magicannotator.R;

/**
 * Landing Activity to display to the user the name and logo of the application.
 * <p/>
 * Created on 2/22/13, at 8:10 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 * @since 18.
 */
public class StartUpActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_up);

        new Handler().postDelayed(new StartUpImageHandler(), 1250);
    }

    /**
     * Handler that implements {@link Runnable} to start main Activity after showing the start up information.
     */
    private class StartUpImageHandler implements Runnable {

        @Override
        public void run() {
            startActivity(new Intent(getApplication(), ChooseAnnotatorActivity.class));
            finish();
        }
    }
}