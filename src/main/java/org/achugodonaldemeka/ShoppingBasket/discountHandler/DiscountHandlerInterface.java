package org.achugodonaldemeka.ShoppingBasket.discountHandler;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public interface DiscountHandlerInterface {
    void applyDisount(Item item);

    double getTotalDiscount();

    String toString();
}
