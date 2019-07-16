package org.achugodonaldemeka.ShoppingBasket.model.impl;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public class Bread implements Item {

    private static double price = 0.80;

    @Override
    public double getPrice() {
        return Bread.price;
    }
}
