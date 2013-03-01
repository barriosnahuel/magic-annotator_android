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
 * TableListAdapter.java Created by: Nahuel Barrios: 05/04/2012, 09:54:04.
 */
package com.nbempire.android.magicannotator.util.android;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

import java.util.List;

/**
 * Helper type that extends SimpleListAdapter to work easier with Android adapters but particulary to make tables.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TableListAdapter extends SimpleListAdapter {

    /**
     * Number of columns of the table.
     */
    private final int numberOfColumns;

    /**
     * The resource ID of any defined style in styles.xml.
     */
    private int textAppearanceResourceId;

    /**
     * A constructor method for the type.
     *
     * @param activity
     *         The activity where this adapter has to create its {@link View}s.
     * @param values
     *         {@link List} of {@link String}s to show in the grid.
     *
     * @since 1
     */
    public TableListAdapter(Activity activity, List<CharSequence> values, int numberOfColumns) {
        super(activity, values);
        this.numberOfColumns = numberOfColumns;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.getActivity().getLayoutInflater().inflate(R.layout.gridview_table, null);

        TextView text;
        if (position < numberOfColumns) {
            text = (TextView) convertView.findViewById(R.id.gridView_cell_header);
        } else {
            text = (TextView) convertView.findViewById(R.id.gridView_cell_valuesMedium);
        }

        text.setText(this.getItem(position).toString());
        text.setTextAppearance(text.getContext(), textAppearanceResourceId);

        return convertView;
    }

    /**
     * Setter for type attribute: {@link #textAppearanceResourceId}.
     *
     * @param resourceId
     *         The ID of some style resource for TextView text appearance.
     */
    public void setTextAppearanceResourceId(int resourceId) {
        this.textAppearanceResourceId = resourceId;
    }
}
