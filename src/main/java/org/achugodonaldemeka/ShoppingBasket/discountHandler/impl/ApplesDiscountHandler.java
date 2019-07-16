package org.achugodonaldemeka.ShoppingBasket.discountHandler.impl;

import org.achugodonaldemeka.ShoppingBasket.discountHandler.DiscountHandlerInterface;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.decoretor.ApplesDecoretor;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;
import org.springframework.stereotype.Component;

@Component
public class ApplesDiscountHandler implements DiscountHandlerInterface {

    private String toPrint = "";

    @Override
    public Item applyDisount(Item item) {
        if (item instanceof Apples) {
            toPrint += "Apples 10% off: -10p\n";
            return new ApplesDecoretor((Apples) item);
        }
        return item;
    }

    @Override
    public String toString() {
        return toPrint;
    }
}
