package org.achugodonaldemeka.ShoppingBasket.discountHandler.impl;

import org.achugodonaldemeka.ShoppingBasket.discountHandler.DiscountHandlerInterface;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Bread;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Soup;
import org.springframework.stereotype.Component;

@Component
public class TwoSoupGetBreadAtHalfPriceHandler implements DiscountHandlerInterface {

    private String toPrint = "";
    private double totalDiscount = 0;

    int breadsCounter = 0;
    int soupCounter = 0;

    @Override
    public void applyDiscount(Item item) {
        if (item instanceof Soup) {
            ++soupCounter;
        } else if (item instanceof Bread) {
            ++breadsCounter;
        }

        while (soupCounter >= 2 && breadsCounter >= 1) {
            toPrint += "Bread 50% off: -40p\n";
            totalDiscount += 0.40;

            soupCounter -= 2;
            --breadsCounter;
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
