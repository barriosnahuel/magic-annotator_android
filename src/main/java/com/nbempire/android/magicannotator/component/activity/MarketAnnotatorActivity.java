/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 10:55hs.
 */
package com.nbempire.android.magicannotator.component.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.service.MarketItemService;
import com.nbempire.android.magicannotator.service.impl.MarketItemServiceImpl;
import com.nbempire.android.magicannotator.storage.MagicAnnotatorDBHelper;
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
     * A service for the MarketItem entity.
     */
    private MarketItemService marketItemService;

    /**
     * Helper for the magicAnnotator database.
     */
    private MagicAnnotatorDBHelper magicAnnotatorDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketannotator);
    }

    @Override
    protected void onResume() {
        super.onResume();

        initializeDependencies(this);

        loadSavedItems();
        updateItemsOnGUI(items);
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

            marketItemService.saveOrUpdate(eachItem);
        }

        Log.i(LOG_TAG, "Closing MagicAnnotatorDBHelper...");
        //  Close the DBHelper in onPause because of the Activities lifecycle and the OS may find a memory leak if it's not closed.
        magicAnnotatorDBHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.marketannotator, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return items.size() > 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean showMenu = false;
        boolean updateGUI = true;

        switch (item.getItemId()) {
            case R.id.marketAnnotatorMenuItem_updateQuantitiesToZero:
                Log.i(LOG_TAG, "Updating all quantities to 0.");
                updateItems(items, 0);
                showMenu = true;
                break;
            case R.id.marketAnnotatorMenuItem_checkAllItems:
                Log.i(LOG_TAG, "Checking all items.");
                updateItems(items, true);
                showMenu = true;
                break;
            case R.id.marketAnnotatorMenuItem_uncheckAllItems:
                Log.i(LOG_TAG, "Unchecking all items.");
                updateItems(items, false);
                showMenu = true;
                break;
            case R.id.marketAnnotatorMenuItem_deleteAll:
                resetAnnotator();
                showMenu = true;
                updateGUI = false;
                break;
        }

        if (showMenu && updateGUI) {
            updateItemsOnGUI(items);
        }

        return showMenu;
    }

    /**
     * Instantiates the {@code magicAnnotatorDB} and all activity's dependencies.
     *
     * @param context
     *         The activity Context.
     *
     * @since 10
     */
    private void initializeDependencies(Context context) {
        magicAnnotatorDBHelper = new MagicAnnotatorDBHelper(context);
        marketItemService = new MarketItemServiceImpl(magicAnnotatorDBHelper.getWritableDatabase());
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
                            addItemToView(item);
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
            Log.i(LOG_TAG, "Adding item: " + eachItem.getDescription() + " to the GUI.");
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
    private void addItemToView(String item) {
        List<MarketItem> itemsList = new ArrayList<MarketItem>();
        itemsList.add(new MarketItem(item));
        addItemsToView(itemsList);
    }

    /**
     * Resets the annotator.
     * <p/>
     * This method is called from the layout definition.
     *
     * @since 9
     */
    public void resetAnnotator() {
        items.clear();
        marketItemService.deleteAll();
        onCreate(null);
    }

    /**
     * Load saved items and add them to the GUI.
     *
     * @since 10
     */
    private void loadSavedItems() {
        items = marketItemService.findAll();

        if (!items.isEmpty()) {
            addItemsToView(items);
            updateItemsOnGUI(items);
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
    private void updateItemsOnGUI(List<MarketItem> items) {
        for (MarketItem eachItem : items) {
            Log.i(LOG_TAG, "Updating item attributes for: " + eachItem.getDescription());

            TextView numberOfItems = (TextView) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
            numberOfItems.setText(eachItem.getQuantity());

            CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView
                                                                                                                     .CHECK_BOX_ID_SUFFIX));
            checkBox.setChecked(eachItem.isChecked());
        }
    }

    /**
     * Updates item's checked status.
     *
     * @param items
     *         The items to update.
     * @param checked
     *         The value for the update. It will be applied to all items.
     *
     * @since 11
     */
    private void updateItems(List<MarketItem> items, boolean checked) {
        for (MarketItem eachItem : items) {
            TextView itemCount = (TextView) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
            eachItem.setQuantity(itemCount.getText().toString());

            eachItem.setChecked(checked);
        }
    }

    /**
     * Updates item's quantities.
     *
     * @param items
     *         The items to update.
     * @param quantity
     *         The value for the update. It will be applied to all items.
     *
     * @since 11
     */
    private void updateItems(List<MarketItem> items, int quantity) {
        for (MarketItem eachItem : items) {
            eachItem.setQuantity(String.valueOf(quantity));

            CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView
                                                                                                                     .CHECK_BOX_ID_SUFFIX));
            eachItem.setChecked(checkBox.isChecked());
        }
    }

}
