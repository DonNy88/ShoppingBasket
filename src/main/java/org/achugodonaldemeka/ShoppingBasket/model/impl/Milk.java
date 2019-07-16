package org.achugodonaldemeka.ShoppingBasket.model.impl;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public class Milk implements Item {

    private static double price = 1.30;

    public static final String ITEM_NAME = "Milk";

    @Override
    public double getPrice() {
        return Milk.price;
    }

}
