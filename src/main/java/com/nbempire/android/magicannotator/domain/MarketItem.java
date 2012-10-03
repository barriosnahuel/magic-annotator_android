/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * Created by: Nahuel Barrios. On: 02/10/12 at 12:12hs.
 */
package com.nbempire.android.magicannotator.domain;

import com.nbempire.android.magicannotator.GameKeys;

/**
 * Entity type that represents an item on the market list annotator.
 *
 * @author Nahuel Barrios.
 * @since 10
 */
public class MarketItem {

    /**
     * The item description.
     */
    private final String description;

    /**
     * Quantity of items for this item.
     */
    private String quantity;

    /**
     * The entity ID.
     * <p/>
     * Default value is zero.
     */
    private int id;

    /**
     * Indicates with {@code true} when this item has the checkbox checked or {@code false} when not.
     */
    private boolean checked;

    /**
     * A constructor method for the MarketItem type.
     *
     * @param description
     *         The item description.
     *
     * @since 10
     */
    public MarketItem(String description) {
        super();
        this.description = description;
        this.quantity = GameKeys.MARKET_ITEM_INITIAL_QUANTITY;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the description.
     *
     * @since 10
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accessor for the attribute of the entity.
     *
     * @return the quantity.
     *
     * @since 10
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Setter for the attribute of the entity.
     *
     * @param quantity
     *         the quantity to set.
     *
     * @since 10
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    /**
     * Accessor for the attribute of the entity.
     *
     * @return the id.
     *
     * @since 10
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the attribute of the entity.
     *
     * @param id
     *         the id to set.
     *
     * @since 10
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Indicates with {@code true} when this item has the checkbox checked or {@code false} when not.
     *
     * @return {@code true} when this item is checked. Otherwise {@code false}.
     *
     * @since 10
     */
    public boolean isChecked() {
        return checked;
    }


    /**
     * Setter for the attribute of the entity.
     *
     * @param checked
     *         the checked to set.
     *
     * @since 10
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "MarketItem{" +
                       "description='" + description + '\'' +
                       ", quantity='" + quantity + '\'' +
                       ", id=" + id +
                       ", checked=" + checked +
                       '}';
    }
}
