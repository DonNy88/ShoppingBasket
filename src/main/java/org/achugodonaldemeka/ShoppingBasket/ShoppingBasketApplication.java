package org.achugodonaldemeka.ShoppingBasket;

import lombok.extern.log4j.Log4j2;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.ItemFactory;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Bread;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Milk;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Soup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@Log4j2
@SpringBootApplication
public class ShoppingBasketApplication implements CommandLineRunner {

    public static String output;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingBasketApplication.class, args);
    }

    static final String[] products = new String[]{Soup.ITEM_NAME, Bread.ITEM_NAME, Milk.ITEM_NAME, Apples.ITEM_NAME};

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            output = "No input provided";
            System.out.println(output);
            return;
        }

        for (int i = 0; i < args.length; ++i) {
            String elem = args[i];
            if (!Arrays.stream(products).anyMatch(str -> str.trim().equalsIgnoreCase(elem.trim()))) {
                output = "The product " + elem + " is not available";
                System.out.println(output);
                return;
            }
        }

        double total = 0;
        for (int i = 0; i < args.length; ++i) {
            Item item = ItemFactory.getItemObj(args[i]);
            total += item.getPrice();
        }

        output = "Subtotal: £" + total + "\n" + "(No offers available)\n" + "Total price: £" + total;
        System.out.println(output);
    }


}