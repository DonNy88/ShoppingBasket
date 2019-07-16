package org.achugodonaldemeka.ShoppingBasket;

import lombok.extern.log4j.Log4j2;
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

    static final String[] products = new String[]{"Soup", "Bread", "Milk", "Apples"};

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            output = "No input provided";
        } else {
            for (int i = 0; i < args.length; ++i) {
                String elem = args[i];
                if (!Arrays.stream(products).anyMatch(str -> str.trim().equalsIgnoreCase(elem.trim()))) {
                    output = "The product " + elem + " is not available";
                    System.out.println(output);
                    return;
                }
            }
        }

        System.out.println(output);
    }


}