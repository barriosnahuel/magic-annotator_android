/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios.
 * On: 27/09/12 at 10:38hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nbempire.android.magicannotator.R;

/**
 * GUI entity class to use with the {@code marketitem.xml} layout because it does its functionality.
 *
 * @author Nahuel Barrios.
 * @since 8
 */
public class MarketItemView extends RelativeLayout {

    /**
     * Tag for class' log.
     */
    private static final String LOG_TAG = "MarketItemView";

    public static final String TEXT_VIEW_ID_SUFFIX = "-textView";
    public static final String CHECK_BOX_ID_SUFFIX = "-checkBox";

    /**
     * Creates a new MarketItemView on the specified {@code context}.
     *
     * @param context
     *         {@code Context} for example the context of a {@code TableLayout} view.
     * @param itemName
     *         String with the item name to put in the checkbox. It also be used to use as preffix for the generated view's ID.
     *
     * @since 8
     */
    public MarketItemView(Context context, String itemName) {
        super(context);
        initializeView(context, itemName);
    }

    /**
     * Initialize the market item layout.
     * <p/>
     * Sets the label for the checkbox with the {@code itemName}.
     * <p/>
     * Sets the corresponding ID to the checkbox based on {@code itemName} and a suffix with the value of the public constant {@code
     * CHECK_BOX_ID_SUFFIX}.
     *
     * @param context
     *         {@code Context} for example the context of a {@code TableLayout} view.
     * @param itemName
     *         String with the item name to put in the checkbox. It also be used to use as preffix for the generated view's ID.
     *
     * @since 8
     */
    private void initializeView(Context context, final String itemName) {
        LayoutInflater.from(context).inflate(R.layout.market_item, this, true);

        CheckBox checkBox = (CheckBox) findViewById(R.id.marketItem_itemName);
        checkBox.setText(itemName);
        //  Sets an ID to let the OS save itself the view's state. E.g. the label and the checked (or not checked) status.
        checkBox.setId(ViewsUtil.generateViewId(itemName + CHECK_BOX_ID_SUFFIX));

        TextView itemCount = (TextView) findViewById(R.id.marketItem_itemCount);
        final int textViewId = ViewsUtil.generateViewId(itemName + TEXT_VIEW_ID_SUFFIX);
        itemCount.setId(textViewId);

        Button addButton = (Button) findViewById(R.id.marketItem_addButton);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Adding number of items, for item: " + itemName);
                TextView itemCount = (TextView) findViewById(textViewId);
                itemCount.setText(String.valueOf(Integer.parseInt(itemCount.getText().toString()) + 1));
            }
        });

        Button substractButton = (Button) findViewById(R.id.marketItem_substractButton);
        substractButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Substracting number of items, for item: " + itemName);
                TextView itemCount = (TextView) findViewById(textViewId);
                itemCount.setText(String.valueOf(Integer.parseInt(itemCount.getText().toString()) - 1));
            }
        });
    }

}
