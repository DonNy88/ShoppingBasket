package org.achugodonaldemeka.ShoppingBasket;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingBasketApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertTrue("The application is started well!", true);
	}

	@Test
	public void noInputShouldPrint_No_input_provided() {
		String[] argsArray = new String[]{};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(ShoppingBasketApplication.output, "No input provided");
	}

	@Test
	public void inputNotValidShouldPrint_This_product_x_is_not_available() {
		String[] argsArray = new String[]{"Soup", "Milk", "pizza", "bread", "Fagioli"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals("The product pizza is not available", ShoppingBasketApplication.output);
	}

	@Test
	public void input3ItemsWithoutOffShouldPrintTotalWithoutAnyDiscount() {
		String expectedOutput = "Subtotal: £1.30\n" + "(No offers available)\n" + "Total price: £1.30";
		String[] argsArray = new String[]{"Soup", "Milk", "bread"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}

}
