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

package com.nbempire.android.magicannotator.util.android;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;
import com.nbempire.android.magicannotator.util.ExpandableGroup;
import com.nbempire.android.magicannotator.util.ExpandableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class to simplify the use of the Android's interface {@link SimpleExpandableListAdapter} . Activities should inherit from this abstract
 * class and call its constructor method to create the Adapter.
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
     * Called when the activity is starting. This is where most initialization should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact with widgets in the UI, calling {@link #managedQuery(android.net.Uri,
     * String[], String, String[], String)} to retrieve cursors for data being displayed, etc. <p> You can call {@link #finish} from within this
     * function, in which case onDestroy() will be immediately called without any of the rest of the activity lifecycle ({@link #onStart}, {@link
     * #onResume}, {@link #onPause}, etc) executing. <p> <em>Derived classes must call through to the super class's implementation of this method.  If
     * they do not, an exception will be thrown.</em> </p>
     *
     * @param savedInstanceState
     *         If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied
     *         in {@link #onSaveInstanceState} . <b><i>Note: Otherwise it is null.</i></b>
     * @param expandableList
     *         {@link ExpandableList} containing the groups with its children to show on this expandable list.
     *
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     * @since 1
     */
    protected void onCreate(Bundle savedInstanceState, ExpandableList expandableList) {
        super.onCreate(savedInstanceState);

        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

        for (ExpandableGroup eachGroup : expandableList) {
            Map<String, String> currentGroupMap = new HashMap<String, String>();
            currentGroupMap.put(ITEM_NAME, eachGroup.getLabel());
            groupData.add(currentGroupMap);

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();

            for (String each : eachGroup.getChildren()) {
                Map<String, String> currentChildMap = new HashMap<String, String>();
                children.add(currentChildMap);
                currentChildMap.put(ITEM_NAME, each);
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
