package org.achugodonaldemeka.ShoppingBasket.discountHandler;

import lombok.Getter;
import org.achugodonaldemeka.ShoppingBasket.discountHandler.impl.ApplesDiscountHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class DiscountHandler {

    private List<DiscountHandlerInterface> discountHandlers;

    @Autowired
    DiscountHandler(ApplesDiscountHandler applesDiscountHandler) {
        discountHandlers = new ArrayList<>();
        discountHandlers.add(applesDiscountHandler);
    }
}
