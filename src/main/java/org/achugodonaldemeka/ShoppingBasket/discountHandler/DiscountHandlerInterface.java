package org.achugodonaldemeka.ShoppingBasket.discountHandler;

import org.achugodonaldemeka.ShoppingBasket.model.Item;

public interface DiscountHandlerInterface {
    void applyDiscount(Item item);

    double getTotalDiscount();

    String toString();
}
