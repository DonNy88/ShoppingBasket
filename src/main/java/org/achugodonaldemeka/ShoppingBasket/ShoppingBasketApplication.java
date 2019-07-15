package org.achugodonaldemeka.ShoppingBasket;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class ShoppingBasketApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingBasketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("main started");
        for (int i = 0; i < args.length; ++i) {
            log.info(i + " " + args[i]);
        }
    }
}