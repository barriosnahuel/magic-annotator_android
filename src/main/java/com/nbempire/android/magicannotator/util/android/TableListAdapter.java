/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * TableListAdapter.java Created by: Nahuel Barrios: 05/04/2012, 09:54:04.
 */
package com.nbempire.android.magicannotator.util.android;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

/**
 * TODO : JavaDoc : for TableListAdapter.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class TableListAdapter extends SimpleListAdapter implements ListAdapter {

    /**
     * Number of columns of the table.
     */
    private final int numberOfColumns;

    /**
     * A constructor method for the {@link TableListAdapter} type.
     *
     * @param activity
     * @param values
     *
     * @since 1
     */
    public TableListAdapter(Activity activity, List<CharSequence> values, int numberOfColumns) {
        super(activity, values);
        this.numberOfColumns = numberOfColumns;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = this.getActivity().getLayoutInflater().inflate(R.layout.gridview_table, null);

        TextView text;
        if (position < numberOfColumns) {
            text = (TextView) convertView.findViewById(R.id.gridView_cell_header);
        } else {
            text = (TextView) convertView.findViewById(R.id.gridView_cell_valuesMedium);
        }
        text.setText(this.getItem(position).toString());

        return convertView;
    }

}
