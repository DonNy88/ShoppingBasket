package org.achugodonaldemeka.ShoppingBasket.model;

import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Bread;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Milk;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Soup;

public class ItemFactory {

    public static Item getItemObj(String itemName) throws Exception {
        if (nameCheck(itemName, Soup.ITEM_NAME)) {
            return new Soup();
        } else if (nameCheck(itemName, Bread.ITEM_NAME)) {
            return new Bread();
        } else if (nameCheck(itemName, Apples.ITEM_NAME)) {
            return new Apples();
        } else if (nameCheck(itemName, Milk.ITEM_NAME)) {
            return new Milk();
        }

        throw new Exception("This item: " + itemName + " is not a valid item");
    }

    private static boolean nameCheck(final String str1, final String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.trim().equalsIgnoreCase(str2.trim());
    }

}
