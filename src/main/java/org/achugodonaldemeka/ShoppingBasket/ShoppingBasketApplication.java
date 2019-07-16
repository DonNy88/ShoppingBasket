package org.achugodonaldemeka.ShoppingBasket;

import lombok.extern.log4j.Log4j2;
import org.achugodonaldemeka.ShoppingBasket.discountHandler.DiscountHandler;
import org.achugodonaldemeka.ShoppingBasket.discountHandler.DiscountHandlerInterface;
import org.achugodonaldemeka.ShoppingBasket.model.Item;
import org.achugodonaldemeka.ShoppingBasket.model.ItemFactory;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Apples;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Bread;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Milk;
import org.achugodonaldemeka.ShoppingBasket.model.impl.Soup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@SpringBootApplication
public class ShoppingBasketApplication implements CommandLineRunner {

    @Autowired
    private DiscountHandler discountHandler;

    public static String output;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingBasketApplication.class, args);
    }

    static final String[] products = new String[]{Soup.ITEM_NAME, Bread.ITEM_NAME, Milk.ITEM_NAME, Apples.ITEM_NAME};

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n\n");
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

        List<Item> cart = new ArrayList<>(args.length);

        double subTotal = 0;
        for (int i = 0; i < args.length; ++i) {
            Item item = ItemFactory.getItemObj(args[i]);
            cart.add(item);
            subTotal += item.getPrice();
        }

        double total = 0;
        for (int i = 0; i < cart.size(); ++i) {
            for (DiscountHandlerInterface disc : discountHandler.getDiscountHandlers()) {
                cart.set(i, disc.applyDisount(cart.get(i)));
            }
        }
        total = cart.stream().mapToDouble(elem -> elem.getPrice()).sum();

        output = "Subtotal: £" + subTotal + "\n";
        output += printOffers(cart);
        output += "Total price: £" + total;
        System.out.println(output);
    }

    private String printOffers(List<Item> cart) {
        String result = "";
        for (DiscountHandlerInterface elem : discountHandler.getDiscountHandlers()) {
            result += elem.toString();
        }
        if (result.trim().isEmpty()) {
            return "(No offers available)\n";
        }
        return result;
    }
}