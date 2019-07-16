package org.achugodonaldemeka.ShoppingBasket.model.impl;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public class Bread implements Item {

    private static double price = 0.80;

    public static final String ITEM_NAME = "Bread";

    @Override
    public double getPrice() {
        return Bread.price;
    }
}
