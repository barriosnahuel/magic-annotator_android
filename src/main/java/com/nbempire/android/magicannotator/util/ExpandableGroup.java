/*
 * Copyright (c) 2012-2013 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * ExpandableGroup.java Created by: Nahuel Barrios: 24/03/2012, 11:34:31.
 */
package com.nbempire.android.magicannotator.util;

import java.util.List;

/**
 * Utility Android entity type that has a label and a list of strings as children.
 * <p/>
 * It's suposed to use to handle in an easier way the expandable lists.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class ExpandableGroup {

    /**
     * The label for this ExpandableGroup.
     */
    private final String label;

    /**
     * ExpandableGroup's children.
     */
    private final List<String> children;

    /**
     * Type's constructor.
     *
     * @param label
     *         The label for this ExpandableGroup.
     * @param children
     *         ExpandableGroup's children.
     *
     * @since 1
     */
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
