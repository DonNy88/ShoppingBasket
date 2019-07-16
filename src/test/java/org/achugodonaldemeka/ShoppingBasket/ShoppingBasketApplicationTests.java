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
		String expectedOutput = "Subtotal: £2.75\n" + "(No offers available)\n" + "Total price: £2.75";
		String[] argsArray = new String[]{"Soup", "Milk", "bread"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}

	@Test
	public void input3ItemsWith1AppleShouldPrintTotalWithDiscount() {
		String expectedOutput = "Subtotal: £2.95\n" + "Apples 10% off: -10p\n" + "Total price: £2.85";
		String[] argsArray = new String[]{"Soup", "Milk", "Apples"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}

	@Test
	public void input3ItemsWith2AppleShouldPrintTotalWithDoubleApplesDiscount() {
		String expectedOutput = "Subtotal: £2.65\n" + "Apples 10% off: -10p\n" + "Apples 10% off: -10p\n" + "Total price: £2.45";
		String[] argsArray = new String[]{"Soup", "Apples", "Apples"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}

	@Test
	public void input4ItemsWith2Soup1BreadShouldPrintTotalWithBreadAtHalfPriceDiscount() {
		String expectedOutput = "Subtotal: £3.40\n" + "Bread 50% off: -40p\n" + "Total price: £3.00";
		String[] argsArray = new String[]{"Bread", "Soup", "Soup", "Milk"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}

	@Test
	public void input43ItemsWith2Soup1BreadShouldPrintTotalWithBreadAtHalfPriceDiscount() {
		String expectedOutput =
				"Subtotal: £5.40\n" +
				"Apples 10% off: -10p\n" +
				"Apples 10% off: -10p\n" +
				"Bread 50% off: -40p\n" +
				"Total price: £4.80";
		String[] argsArray = new String[]{"Bread", "Soup", "Soup", "Milk", "Apples", "Apples"};

		ShoppingBasketApplication.main(argsArray);

		Assert.assertEquals(expectedOutput, ShoppingBasketApplication.output);
	}
}
