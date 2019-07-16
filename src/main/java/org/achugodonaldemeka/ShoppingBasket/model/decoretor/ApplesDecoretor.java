package org.achugodonaldemeka.ShoppingBasket.model.decoretor;

import lombok.AllArgsConstructor;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;

@AllArgsConstructor
public class ApplesDecoretor implements Item {

    private Apples apples;

    @Override
    public double getPrice() {
        return apples.getPrice() * 0.9;
    }
}
