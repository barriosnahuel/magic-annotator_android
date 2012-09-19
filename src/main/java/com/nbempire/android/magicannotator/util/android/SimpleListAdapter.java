/**
 * SimpleListAdapter.java Created by: Nahuel Barrios: 05/04/2012, 09:31:29.
 */
package com.nbempire.android.magicannotator.util.android;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * TODO : JavaDoc : for SimpleListAdapter.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 05/04/2012, 09:31:29.
 */
public class SimpleListAdapter extends BaseAdapter implements ListAdapter {

    /**
     * The activity where this adapter has to create its {@link View}s.
     */
    private Activity activity;

    private List<CharSequence> values;

    /**
     * A constructor method for the {@link SimpleListAdapter} type.
     * 
     * @author Nahuel Barrios.
     * @since 05/04/2012.
     * @param activity
     *            {@link Context} The activity where this adapter has to create its {@link View}s.
     * @param values
     *            {@link List} of {@link String}s to show in the grid.
     */
    public SimpleListAdapter(Activity context, List<CharSequence> values) {
        this.activity = context;
        this.values = values;
    }

    public int getCount() {
        return values.size();
    }

    public Object getItem(int position) {
        return values.get(position);
    }

    public long getItemId(int position) {
        // TODO : Functionality : The method getItemId();
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(activity);
        view.setText(this.getItem(position).toString());

        return view;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author Nahuel Barrios.
     * @since 05/04/2012.
     * @return the activity.
     */
    public Activity getActivity() {
        return activity;
    }

}
