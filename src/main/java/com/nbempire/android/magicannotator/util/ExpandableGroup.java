/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * ExpandableGroup.java Created by: Nahuel Barrios: 24/03/2012, 11:34:31.
 */
package com.nbempire.android.magicannotator.util;

import java.util.List;

/**
 * TODO : JavaDoc : for ExpandableGroup.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ExpandableGroup {

    private final String label;

    private final List<String> children;

    public ExpandableGroup(String label, List<String> children) {
        this.label = label;
        this.children = children;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the label.
     *
     * @since 1
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the children.
     *
     * @since 1
     */
    public List<String> getChildren() {
        return children;
    }

}
