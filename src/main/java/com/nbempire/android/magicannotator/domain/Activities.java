/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
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
