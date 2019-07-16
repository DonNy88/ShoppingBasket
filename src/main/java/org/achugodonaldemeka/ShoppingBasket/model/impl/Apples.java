package org.achugodonaldemeka.ShoppingBasket.model.impl;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public class Apples implements Item {

    private static double price = 1.00;

    public static final String ITEM_NAME = "Apples";

    @Override
    public double getPrice() {
        return Apples.price;
    }
}
