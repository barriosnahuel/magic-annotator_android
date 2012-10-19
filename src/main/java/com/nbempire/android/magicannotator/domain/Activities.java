/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
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
 * TODO : Javadoc for Activities
 *
 * @author Nahuel Barrios.
 * @since 15
 */
public enum Activities {

    CHOOSE_ANNOTATOR(ChooseAnnotatorActivity.class.getSimpleName()), CHOOSE_PLAYERS(ChoosePlayersActivity.class.getSimpleName());

    /**
     * The associated activity type simple name. It's without the packages as preffix.
     */
    private String activityTypeName;

    /**
     * Constructor for this enum.
     *
     * @param name
     *
     * @since 15
     */
    private Activities(String name) {
        this.activityTypeName = name;
    }

    /**
     * Accesor for the activityTypeName for this enum constant.
     *
     * @return
     *
     * @since 15
     */
    public String getActivityTypeName() {
        return activityTypeName;
    }

}
