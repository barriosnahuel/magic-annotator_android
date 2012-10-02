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
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.content.MagicAnnotatorDB;
import com.nbempire.android.magicannotator.content.MarketItemTable;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.util.android.db.SQLiteUtil;
import com.nbempire.android.magicannotator.util.android.view.MarketItemView;
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

    /**
     * The items that are in the GUI.
     */
    private List<MarketItem> items = new ArrayList<MarketItem>();

    /**
     * Application DB.
     */
    private SQLiteDatabase magicAnnotatorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketannotator);

        //  Creating database
        magicAnnotatorDB = openOrCreateDatabase(MagicAnnotatorDB.DB_NAME, MODE_PRIVATE, null);

        //  Creating table if not exists.

        String scriptToExecute = MarketItemTable.getCreateScript();
        Log.d(LOG_TAG, "Executing SQL script: " + scriptToExecute);
        magicAnnotatorDB.execSQL(scriptToExecute);

        loadSavedItems(magicAnnotatorDB);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (MarketItem eachItem : items) {
            TextView itemCount = (TextView) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
            eachItem.setQuantity(itemCount.getText().toString());

            CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView
                                                                                                                     .CHECK_BOX_ID_SUFFIX));
            eachItem.setChecked(checkBox.isChecked());

            String scriptToExecute;
            if (eachItem.getId() == 0) {
                scriptToExecute = MarketItemTable.getInsertScript(eachItem.getDescription(), eachItem.getQuantity(), eachItem.isChecked());
            } else {
                scriptToExecute = MarketItemTable.getUpdateScript(eachItem.getId(), eachItem.getQuantity(), eachItem.isChecked());
            }
            Log.d(LOG_TAG, "Executing SQL script: " + scriptToExecute);
            magicAnnotatorDB.execSQL(scriptToExecute);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateItemQuantities(items);
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
                            items.add(new MarketItem(item));
                        }
                    }
                }).show();
    }

    /**
     * Add the specified {@code items} to the GUI into the corresponding {@code MarketItemView}.
     *
     * @param items
     *         The items to add to the GUI.
     *
     * @since 8
     */
    private void addItemsToView(List<MarketItem> items) {
        TableLayout layout = (TableLayout) findViewById(R.id.marketAnnotator_itemsLayout);
        for (MarketItem eachItem : items) {
            Log.d(LOG_TAG, "Adding item: " + eachItem.getDescription() + " to the GUI.");
            layout.addView(new MarketItemView(layout.getContext(), eachItem.getDescription()));
        }
    }

    /**
     * Add the specified {@code item} to the GUI into the corresponding {@code MarketItemView}.
     *
     * @param item
     *         The item to add to the GUI.
     *
     * @since 8
     */
    private void addItemsToView(String item) {
        List<MarketItem> itemsList = new ArrayList<MarketItem>();
        itemsList.add(new MarketItem(item));
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
        Log.d(LOG_TAG, "--> resetAnnotator from view: " + callerView.getId());

        items.clear();
        magicAnnotatorDB.execSQL(MarketItemTable.getDropScript());
        onCreate(null);
    }

    /**
     * Load saved items from DB and add them to the GUI.
     *
     * @param magicAnnotatorDB
     *         The SQLiteDatabase to use.
     *
     * @since 10
     */
    private void loadSavedItems(SQLiteDatabase magicAnnotatorDB) {
        Cursor cursor = magicAnnotatorDB.query(MarketItemTable.TABLE_NAME, null, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            //fetching from database and adding to arrayList
            MarketItem item = new MarketItem(cursor.getString(cursor.getColumnIndex(MarketItemTable.DESCRIPTION)));
            item.setQuantity(cursor.getString(cursor.getColumnIndex(MarketItemTable.QUANTITY)));
            item.setId(cursor.getInt(cursor.getColumnIndex(MarketItemTable.ID)));
            item.setChecked(SQLiteUtil.getBooleanValue(cursor.getInt(cursor.getColumnIndex(MarketItemTable.CHECKED))));

            Log.d(LOG_TAG, "Loading item " + item.getDescription() + " with ID: " + item.getId() + " from DB.");
            items.add(item);
        }

        if (!items.isEmpty()) {
            addItemsToView(items);
            updateItemQuantities(items);
        }
    }

    /**
     * Updates item quantities on the GUI for the specified {@code items}.
     *
     * @param items
     *         The items to update.
     *
     * @since 10
     */
    private void updateItemQuantities(List<MarketItem> items) {
        for (MarketItem item : items) {
            Log.d(LOG_TAG, "Updating item quantity: " + item.getDescription());

            TextView numberOfItems = (TextView) findViewById(ViewsUtil.generateViewId(item.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
            numberOfItems.setText(item.getQuantity());

            if (item.isChecked()) {
                CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(item.getDescription() + MarketItemView
                                                                                                                     .CHECK_BOX_ID_SUFFIX));
                checkBox.setChecked(true);
            }
        }
    }

}
