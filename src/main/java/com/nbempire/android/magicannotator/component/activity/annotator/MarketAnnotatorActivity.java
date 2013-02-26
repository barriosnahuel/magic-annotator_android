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
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 10:55hs.
 */
package com.nbempire.android.magicannotator.component.activity.annotator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.nbempire.android.magicannotator.R;
import com.nbempire.android.magicannotator.domain.MarketItem;
import com.nbempire.android.magicannotator.service.MarketItemService;
import com.nbempire.android.magicannotator.service.impl.MarketItemServiceImpl;
import com.nbempire.android.magicannotator.storage.MagicAnnotatorDBHelper;
import com.nbempire.android.magicannotator.util.android.analytics.GoogleAnalyticsUtil;
import com.nbempire.android.magicannotator.util.android.view.MarketItemView;
import com.nbempire.android.magicannotator.util.android.view.ViewsUtil;

import java.util.ArrayList;
import java.util.List;

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
        GoogleAnalyticsTracker.getInstance().trackPageView(GoogleAnalyticsUtil.generatePageName(LOG_TAG));
        setContentView(R.layout.marketannotator);
    }

    @Override
    protected void onResume() {
        super.onResume();

        initializeDependencies(this);

        loadSavedItems();
        updateGUI(items);
    }

    @Override
    protected void onPause() {
        super.onPause();

        for (MarketItem eachItem : items) {
            updateItem(eachItem, null, -1);

            marketItemService.saveOrUpdate(eachItem);
        }

        Log.i(LOG_TAG, "Closing MagicAnnotatorDBHelper...");
        //  Close the DBHelper in onPause because of the Activities lifecycle and the OS may find a memory leak if it's not closed.
        magicAnnotatorDBHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.marketannotator, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int numberOfItems = items.size();
        boolean showMenu = numberOfItems > 0;

        if (showMenu) {
            final int checkAllIndex = 0;
            final int uncheckAllIndex = 1;

            int checkedItems = 0;
            for (MarketItem eachItem : items) {
                CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView
                        .CHECK_BOX_ID_SUFFIX));

                if (checkBox.isChecked()) {
                    checkedItems++;
                } else {
                    checkedItems--;
                }
            }

            if (numberOfItems == checkedItems) {
                Log.i(LOG_TAG, "Hide check");
                menu.getItem(checkAllIndex).setVisible(false);
                menu.getItem(uncheckAllIndex).setVisible(true);
            } else if (numberOfItems == -checkedItems) {
                Log.i(LOG_TAG, "Hide uncheck");
                menu.getItem(checkAllIndex).setVisible(true);
                menu.getItem(uncheckAllIndex).setVisible(false);
            } else {
                Log.i(LOG_TAG, "Don't hide nothing");
                menu.getItem(checkAllIndex).setVisible(true);
                menu.getItem(uncheckAllIndex).setVisible(true);
            }
        }

        return showMenu;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(LOG_TAG, "User selected " + item.getTitle() + " option from the menu.");

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
            default:
                Log.e(LOG_TAG, "The menu item " + item.getTitle() + " has no action attached.");
                break;
        }

        if (showMenu && updateGUI) {
            updateGUI(items);
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
        input.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);

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
    private void addItemsToGUI(List<MarketItem> items) {
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
        addItemsToGUI(itemsList);
    }

    /**
     * Resets the annotator.
     * <p/>
     * This method is called from the layout definition.
     *
     * @since 9
     */
    private void resetAnnotator() {
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
            addItemsToGUI(items);
            updateGUI(items);
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
    private void updateGUI(List<MarketItem> items) {
        for (MarketItem eachItem : items) {
            Log.i(LOG_TAG, "Updating item attributes for: " + eachItem.getDescription());

            TextView numberOfItems =
                    (TextView) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
            numberOfItems.setText(eachItem.getQuantity());

            CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(eachItem.getDescription() + MarketItemView
                    .CHECK_BOX_ID_SUFFIX));
            checkBox.setChecked(eachItem.isChecked());
        }
    }

    /**
     * Update the specified MarketItems from GUI's values or from the specified {@code checked} and {@code quantity} parameters. Parameters have more
     * priority than GUI's values.
     *
     * @param items
     *         The items to update.
     * @param checked
     *         Value to update the {@code item}. If {@code null} then this parameter will not be used and GUI's values will be used instead.
     * @param quantity
     *         Value to update the {@code item}. If {@code -1} then this parameter will not be used and GUI's values will be used instead.
     *
     * @since 12
     */
    private void updateItems(List<MarketItem> items, Boolean checked, int quantity) {
        for (MarketItem eachItem : items) {
            updateItem(eachItem, checked, quantity);
        }
    }

    /**
     * Update a MarketItem from GUI's values or from the specified {@code checked} and {@code quantity} parameters. Parameters have more priority than
     * GUI's values.
     *
     * @param item
     *         The MarketItem to update.
     * @param checked
     *         Value to update the {@code item}. If {@code null} then this parameter will not be used and GUI's values will be used instead.
     * @param quantity
     *         Value to update the {@code item}. If {@code -1} then this parameter will not be used and GUI's values will be used instead.
     *
     * @since 12
     */
    private void updateItem(MarketItem item, Boolean checked, int quantity) {
        CheckBox checkBox = (CheckBox) findViewById(ViewsUtil.generateViewId(item.getDescription() + MarketItemView.CHECK_BOX_ID_SUFFIX));
        if (checked != null) {
            item.setChecked(checked);
        } else {
            item.setChecked(checkBox.isChecked());
        }

        TextView itemCount = (TextView) findViewById(ViewsUtil.generateViewId(item.getDescription() + MarketItemView.TEXT_VIEW_ID_SUFFIX));
        if (quantity != -1) {
            item.setQuantity(String.valueOf(quantity));
        } else {
            item.setQuantity(itemCount.getText().toString());
        }
    }

    /**
     * Updates item's checked status from GUI's values or from the specified {@code checked} parameter. Parameter has more priority than GUI's value.
     *
     * @param items
     *         The items to update.
     * @param checked
     *         Value to update the {@code item}. It will be applied to all items. If {@code null} then this parameter will not be used and GUI's
     *         values will be used instead.
     *
     * @since 12
     */
    private void updateItems(List<MarketItem> items, boolean checked) {
        updateItems(items, checked, -1);
    }

    /**
     * Updates item's quantities status from GUI's values or from the specified {@code quantity} parameter. Parameter has more priority than GUI's
     * value.
     *
     * @param items
     *         The items to update.
     * @param quantity
     *         Value to update the {@code item}. It will be applied to all items. If {@code -1} then this parameter will not be used and GUI's values
     *         will be used instead.
     *
     * @since 12
     */
    private void updateItems(List<MarketItem> items, int quantity) {
        updateItems(items, null, quantity);
    }

}
