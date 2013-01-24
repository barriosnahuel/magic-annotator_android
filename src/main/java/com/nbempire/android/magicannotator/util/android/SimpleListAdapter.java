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
 * SimpleListAdapter.java Created by: Nahuel Barrios: 05/04/2012, 09:31:29.
 */
package com.nbempire.android.magicannotator.util.android;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Helper type that extends BaseAdapter and implements ListAdapter to work easier with Android adapters.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class SimpleListAdapter extends BaseAdapter implements ListAdapter {

    /**
     * The activity where this adapter has to create its {@link View}s.
     */
    private final Activity activity;

    private final List<CharSequence> values;

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
    public SimpleListAdapter(Activity activity, List<CharSequence> values) {
        this.activity = activity;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO : Functionality : The method getItemId();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(activity);
        view.setText(this.getItem(position).toString());

        return view;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the activity.
     *
     * @since 1
     */
    public Activity getActivity() {
        return activity;
    }

}
