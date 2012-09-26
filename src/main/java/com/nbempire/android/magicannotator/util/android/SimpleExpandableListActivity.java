/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

package com.nbempire.android.magicannotator.util.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;

/**
 * Abstract class to simplify the use of the Android's interface {@link SimpleExpandableListAdapter} . Activities should inherit from this
 * abstract class and call its constructor method to create the Adapter.
 *
 * @author Nahuel Barrios.
 */
public abstract class SimpleExpandableListActivity extends ExpandableListActivity {

    /**
     * {@link String} with the key for item's name.
     */
    private static final String ITEM_NAME = "name";

    /**
     * {@link String} with the key for item's description.
     */
    private static final String ITEM_DESCRIPTION = "description";

    /**
     * Called when the activity is starting. This is where most initialization should go: calling {@link #setContentView(int)} to inflate
     * the activity's UI, using {@link #findViewById} to programmatically interact with widgets in the UI, calling {@link
     * #managedQuery(android.net.Uri, String[], String, String[], String)} to retrieve cursors for data being displayed, etc. <p> You can
     * call {@link #finish} from within this function, in which case onDestroy() will be immediately called without any of the rest of the
     * activity lifecycle ({@link #onStart}, {@link #onResume}, {@link #onPause}, etc) executing. <p> <em>Derived classes must call through
     * to the super class's implementation of this method.  If they do not, an exception will be thrown.</em> </p>
     *
     * @param savedInstanceState
     *         If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently
     *         supplied in {@link #onSaveInstanceState} . <b><i>Note: Otherwise it is null.</i></b>
     * @param expandableList
     *         {@link ExpandableList} containing the groups with its children to show on this expandable list.
     *
     * @author Nahuel Barrios.
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    protected void onCreate(Bundle savedInstanceState, ExpandableList expandableList) {
        super.onCreate(savedInstanceState);

        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

        for (ExpandableGroup eachGroup : expandableList) {
            Map<String, String> currentGroupMap = new HashMap<String, String>();
            currentGroupMap.put(ITEM_NAME, eachGroup.getLabel());
            // currentChildMap.put(ITEM_DESCRIPTION, "la descripción...");
            groupData.add(currentGroupMap);

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();

            for (String each : eachGroup.getChildren()) {
                Map<String, String> currentChildMap = new HashMap<String, String>();
                children.add(currentChildMap);
                currentChildMap.put(ITEM_NAME, each);
                // currentChildMap.put(ITEM_DESCRIPTION, "la descripción...");
            }
            childData.add(children);
        }

        this.setListAdapter(new SimpleExpandableListAdapter(this, groupData, android.R.layout.simple_expandable_list_item_1,
                                                                   new String[]{ITEM_NAME, ITEM_DESCRIPTION},
                                                                   new int[]{android.R.id.text1, android.R.id.text2}, childData,
                                                                   android.R.layout.simple_expandable_list_item_2,
                                                                   new String[]{ITEM_NAME, ITEM_DESCRIPTION},
                                                                   new int[]{android.R.id.text1, android.R.id.text2}));
    }
}
