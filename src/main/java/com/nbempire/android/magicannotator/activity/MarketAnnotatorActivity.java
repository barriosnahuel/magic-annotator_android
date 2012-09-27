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
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.util.android.view.MarketItem;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

/**
 * @author Nahuel Barrios.
 * @since 0.1
 */
public class MarketAnnotatorActivity extends Activity {

    private static final String BUNDLE_KEY_ITEMS = "items";
    private static final String BUNDLE_KEY_ITEMS_VALUES = "itemsValues";

    private ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.marketannotator);

        items.add("pescado");
        items.add("fideos");
        items.add("coca 2litros");
        items.add("picada");
        items.add("picad12451r");
        items.add("picadafsfa");
        items.add("picadaasfagasgadg");

        addItemsToView(items);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //  Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //  Here goes my code.
        ArrayList<String> items = savedInstanceState.getStringArrayList(BUNDLE_KEY_ITEMS);
        ArrayList<String> itemsValues = savedInstanceState.getStringArrayList(BUNDLE_KEY_ITEMS_VALUES);

        for (int index = 0; index < items.size(); index++) {
            TextView numberOfItems = (TextView) findViewById(ViewsUtil.generateViewId(items.get(index) + MarketItem.TEXT_VIEW_ID_SUFFIX));
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
     * @param callerView
     */
    public void openMarketItemCreator(View callerView) {

        final EditText input = new EditText(callerView.getContext());

        new AlertDialog.Builder(this).setTitle(R.string.whatDoYouNeed).setView(input)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        String item = input.getText().toString();
                        if (item.length() > 0) {
                            addItemsToView(item);
                        }
                    }
                }).show();
    }

    /**
     * Add the specified {@code items} to the GUI into the corresponding {@code MarketItem}.
     *
     * @param items
     *         The items to add to the GUI.
     */
    private void addItemsToView(ArrayList<String> items) {
        TableLayout layout = (TableLayout) findViewById(R.id.marketAnnotator_itemsLayout);
        for (String eachItem : items) {
            layout.addView(new MarketItem(layout.getContext(), eachItem));
        }
    }

    /**
     * Add the specified {@code item} to the GUI into the corresponding {@code MarketItem}.
     *
     * @param item
     *         The item to add to the GUI.
     */
    private void addItemsToView(String item) {
        ArrayList<String> itemsList = new ArrayList<String>();
        itemsList.add(item);
        addItemsToView(itemsList);
    }


}
