package org.achugodonaldemeka.ShoppingBasket.discountHandler.impl;

import org.achugodonaldemeka.ShoppingBasket.discountHandler.DiscountHandlerInterface;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;
import org.springframework.stereotype.Component;

@Component
public class ApplesDiscountHandler implements DiscountHandlerInterface {

    private String toPrint = "";
    private double totalDiscount = 0;

    @Override
    public void applyDisount(Item item) {
        if (item instanceof Apples) {
            toPrint += "Apples 10% off: -10p\n";
            totalDiscount += 0.10;
        }
    }

    @Override
    public double getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return toPrint;
    }
}
