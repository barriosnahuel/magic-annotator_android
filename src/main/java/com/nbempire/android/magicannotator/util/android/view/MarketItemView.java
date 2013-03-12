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
 * On: 27/09/12 at 10:38hs.
 */
package com.nbempire.android.magicannotator.util.android.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
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
        checkBox.setId(ViewsUtil.generateId(itemName + CHECK_BOX_ID_SUFFIX));

        TextSwitcher itemCount = (TextSwitcher) findViewById(R.id.marketItem_itemCount);
        final int textViewId = ViewsUtil.generateId(itemName + TEXT_VIEW_ID_SUFFIX);
        itemCount.setId(textViewId);
        initializeTextSwitcher(itemCount);

        Button addButton = (Button) findViewById(R.id.marketItem_addButton);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Adding number of items, for item: " + itemName);
                TextSwitcher itemCount = (TextSwitcher) findViewById(textViewId);
                itemCount.setText(String.valueOf(Integer.parseInt(((TextView) itemCount.getCurrentView()).getText().toString()) + 1));
            }
        });

        Button substractButton = (Button) findViewById(R.id.marketItem_substractButton);
        substractButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Substracting number of items, for item: " + itemName);
                TextSwitcher itemCount = (TextSwitcher) findViewById(textViewId);
                int currentValue = Integer.parseInt(((TextView) itemCount.getCurrentView()).getText().toString());
                if (currentValue > 0) {
                    itemCount.setText(String.valueOf(currentValue - 1));
                }
            }
        });
    }

    /**
     * Initializes the score TextSwitcher for the specified {@code textSwitcher}.
     */
    private void initializeTextSwitcher(final TextSwitcher textSwitcher) {
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(textSwitcher.getContext());
                textView.setTextSize(26);
                return textView;
            }
        });

        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(textSwitcher.getContext(), android.R.anim.fade_in));
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(textSwitcher.getContext(), android.R.anim.fade_out));
        textSwitcher.setText(textSwitcher.getContext().getText(R.string.defaultInitialGameScore));
    }

}
