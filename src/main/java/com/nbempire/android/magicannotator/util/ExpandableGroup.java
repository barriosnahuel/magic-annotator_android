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
