/**
 * ExpandableGroup.java Created by: Nahuel Barrios: 24/03/2012, 11:34:31.
 */
package com.nbempire.android.magicannotator.util;

import java.util.List;

/**
 * TODO : JavaDoc : for ExpandableGroup.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 24/03/2012, 11:34:31.
 */
public class ExpandableGroup {

    private String label;

    private List<String> children;

    public ExpandableGroup(String label, List<String> children) {
        this.label = label;
        this.children = children;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 24/03/2012.
     * @return the label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 24/03/2012.
     * @return the children.
     */
    public List<String> getChildren() {
        return children;
    }

}
