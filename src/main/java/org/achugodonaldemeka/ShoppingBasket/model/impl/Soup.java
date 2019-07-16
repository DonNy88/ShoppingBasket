package org.achugodonaldemeka.ShoppingBasket.model.impl;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public class Soup implements Item {

    private static double price = 0.65;

    public static final String ITEM_NAME = "Soup";

    @Override
    public double getPrice() {
        return Soup.price;
    }
}
