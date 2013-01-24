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

/**
 * Created by: Nahuel Barrios.
 * On: 19/10/2012 at 09:29hs.
 */
package com.nbempire.android.magicannotator.domain;

import com.nbempire.android.magicannotator.component.activity.ChooseAnnotatorActivity;
import com.nbempire.android.magicannotator.component.activity.ChoosePlayersActivity;

/**
 * Enum containing all activities that can has more than one next activity to show depending on user actions.
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public enum Activities {

    CHOOSE_ANNOTATOR(ChooseAnnotatorActivity.class.getSimpleName()), CHOOSE_PLAYERS(ChoosePlayersActivity.class.getSimpleName());

    /**
     * The associated activity type simple name. It's without the packages as preffix.
     */
    private final String activityTypeName;

    /**
     * Constructor for this enum.
     *
     * @param typeName
     *         The type's name.
     *
     * @since 15
     */
    private Activities(String typeName) {
        this.activityTypeName = typeName;
    }

    /**
     * Accesor for the activityTypeName for this enum constant.
     *
     * @return String with the activityTypeName.
     *
     * @since 15
     */
    public String getActivityTypeName() {
        return activityTypeName;
    }

}
