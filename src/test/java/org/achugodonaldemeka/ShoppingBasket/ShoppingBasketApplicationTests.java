package org.achugodonaldemeka.ShoppingBasket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingBasketApplicationTests {

	@Test
	public void contextLoads() {
		Assert.isTrue(true, "The application is started well!");
	}

	@Test
	public void noInput() {
		String[] argsArray = new String[]{};
		ShoppingBasketApplication.main(argsArray);
	}

}
