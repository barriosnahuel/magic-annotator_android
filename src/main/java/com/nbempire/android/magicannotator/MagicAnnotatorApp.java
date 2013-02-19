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

package com.nbempire.android.magicannotator;

import android.app.Application;
import android.content.Context;

/**
 * Application global class to let non-Activity classes access Android resources by providing static access to application's context.
 * <p/>
 * Created on 19/02/13, at 17:27.
 *
 * @author Thales-PNT Equipo 6.
 */
public class MagicAnnotatorApp extends Application {

    /**
     * The application context. It can be used to access Android resources from non-Activity classes.
     */
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    /**
     * Retrieves the application context. It can be used to access Android resources from non-Activity classes.
     *
     * @return The application context.
     */
    public static Context getContext() {
        return appContext;
    }

}
