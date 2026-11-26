package org.tests.qa;

import java.util.Arrays;
import java.util.List;

import org.base.qa.BaseTest;
import org.pages.qa.CartPage;
import org.pages.qa.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
	
	@Test
	public void verifyMultipleProductsInCart() {
		
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		
		//Open Products page
		pp.openProductsPage();
		
		//Search and add Blue Top 
		pp.searchProduct("Blue Top");
		pp.addToCart();
		pp.continueShopping();
		
		//Search and add Men Shirt
		pp.searchProduct("Men Tshirt");
		pp.addToCart();
		pp.continueShopping();
		
		//Open Cart
		pp.openCart();
		
		//Verify product count
		Assert.assertEquals(cp.getProductCount(), 2);
		
		//Verify product name
		List<String> names = cp.getProductNames();
		
		Assert.assertTrue(names.contains("Blue Top"));
		Assert.assertTrue(names.contains("Men Tshirt"));
		
		// Verify quantities
        List<String> quantities = cp.getProductQuantities();

        Assert.assertEquals(quantities, Arrays.asList("1", "1"));

        // Verify line totals
        List<String> prices = cp.getProductPrices();
        List<String> totals = cp.getProductTotals();

        Assert.assertEquals(totals.size(), 2);

        for (int i = 0; i < prices.size(); i++) {

            String price = prices.get(i).replaceAll("[^0-9]", "");
            String total = totals.get(i).replaceAll("[^0-9]", "");

            Assert.assertEquals(total, price,
                "Line total does not match product price at row " + (i + 1));
	}

}
	
}

