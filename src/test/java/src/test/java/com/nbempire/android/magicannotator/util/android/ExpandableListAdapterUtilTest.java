/**
 * ExpandableListAdapterUtilTest.java Created by: Nahuel Barrios: 28/03/2012, 09:20:25.
 */
package com.nbempire.android.magicannotator.util.android;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.nbempire.android.magicannotator.util.ExpandableArrayList;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;

/**
 * This class is for test {@link ExpandableListAdapterUtilTest} class using JUnit.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 28/03/2012, 09:20:25.
 */
public class ExpandableListAdapterUtilTest {

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.util.android.ExpandableListAdapterUtil#parseExpandableList(com.nbempire.android.magicannotator.util.ExpandableList)}
     * .
     */
    @Test
    public final void testParseExpandableList() {
        ExpandableList list = new ExpandableArrayList();

        List<String> values1 = new ArrayList<String>();
        values1.add("child1");
        values1.add("child2");
        ExpandableGroup group1 = new ExpandableGroup("group1", values1);
        list.add(group1);

        List<String> values2 = new ArrayList<String>();
        values2.add("child21");
        values2.add("child22");
        ExpandableGroup group2 = new ExpandableGroup("group2", values2);
        list.add(group2);

        Map<String, Object> result = ExpandableListAdapterUtil.parseExpandableList(list);
        String[] groups = (String[]) result.get(ExpandableListAdapterUtil.GROUPS);
        String[][] children = (String[][]) result.get(ExpandableListAdapterUtil.CHILDREN);

        assertNotNull(groups);
        assertEquals(2, groups.length);
        assertNotNull(children);
        assertEquals(2, children.length);

        assertEquals("group1", groups[0]);
        assertEquals("child1", children[0][0]);
        assertEquals("child2", children[0][1]);

        assertEquals("group2", groups[1]);
        assertEquals("child21", children[1][0]);
        assertEquals("child22", children[1][1]);
    }
}
