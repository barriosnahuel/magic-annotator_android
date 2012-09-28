/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 10:55hs.
 */
package com.nbempire.android.magicannotator.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.view.MarketItem;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

/**
 * {@link Activity} To annotate a market list with things to buy.
 *
 * @author Nahuel Barrios.
 * @since 8
 */
public class MarketAnnotatorActivity extends Activity {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "MarketAnnotatorActivity";

    private static final String BUNDLE_KEY_ITEMS = "items";
    private static final String BUNDLE_KEY_ITEMS_VALUES = "itemsValues";

    /**
     * The items that are in the GUI.
     */
    private ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.marketannotator);

        if (savedInstanceState != null) {
            Log.d(LOG_TAG, "Creating Activity from savedInstanceState.");
            items = savedInstanceState.getStringArrayList(BUNDLE_KEY_ITEMS);
            addItemsToView(items);
        } else {
            Log.d(LOG_TAG, "Creating Activity from first time.");
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //  Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //  Here goes my code.
        ArrayList<String> items = savedInstanceState.getStringArrayList(BUNDLE_KEY_ITEMS);
        ArrayList<String> itemsValues = savedInstanceState.getStringArrayList(BUNDLE_KEY_ITEMS_VALUES);

        for (int index = 0; index < items.size(); index++) {
            String item = items.get(index);
            Log.d(LOG_TAG, "Updating item: " + item);
            TextView numberOfItems = (TextView) findViewById(ViewsUtil.generateViewId(item + MarketItem.TEXT_VIEW_ID_SUFFIX));
            numberOfItems.setText(itemsValues.get(index));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //  Here goes my code.
        ArrayList<String> itemsValues = new ArrayList<String>();

        for (String eachItem : items) {
            TextView itemCount = (TextView) findViewById(ViewsUtil.generateViewId(eachItem + MarketItem.TEXT_VIEW_ID_SUFFIX));
            itemsValues.add(itemCount.getText().toString());
        }
        outState.putStringArrayList(BUNDLE_KEY_ITEMS, items);
        outState.putStringArrayList(BUNDLE_KEY_ITEMS_VALUES, itemsValues);

        //  Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    /**
     * Open the AlertDialog to let the user create a new item.
     * <p/>
     * Sets the functionality to add the item to the GUI with its checkbox.
     *
     * @param callerView
     *         The caller View.
     *
     * @since 8
     */
    public void openMarketItemCreator(View callerView) {

        final EditText input = new EditText(callerView.getContext());

        new AlertDialog.Builder(this).setTitle(R.string.marketAnnotator_whatDoYouNeed).setView(input)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        String item = input.getText().toString();
                        Log.d(LOG_TAG, "User input: " + item);
                        if (item.length() > 0) {
                            addItemsToView(item);
                            items.add(item);
                        }
                    }
                }).show();
    }

    /**
     * Add the specified {@code items} to the GUI into the corresponding {@code MarketItem}.
     *
     * @param items
     *         The items to add to the GUI.
     *
     * @since 8
     */
    private void addItemsToView(ArrayList<String> items) {
        TableLayout layout = (TableLayout) findViewById(R.id.marketAnnotator_itemsLayout);
        for (String eachItem : items) {
            Log.d(LOG_TAG, "Adding item: " + eachItem + ", to the GUI.");
            layout.addView(new MarketItem(layout.getContext(), eachItem));
        }
    }

    /**
     * Add the specified {@code item} to the GUI into the corresponding {@code MarketItem}.
     *
     * @param item
     *         The item to add to the GUI.
     *
     * @since 8
     */
    private void addItemsToView(String item) {
        ArrayList<String> itemsList = new ArrayList<String>();
        itemsList.add(item);
        addItemsToView(itemsList);
    }

    /**
     * Resets the annotator.
     * <p/>
     * This method is called from the layout definition.
     *
     * @param callerView
     *         The view that called this method.
     *
     * @since 9
     */
    public void resetAnnotator(View callerView) {
        items.clear();
        onCreate(null);
    }

}
