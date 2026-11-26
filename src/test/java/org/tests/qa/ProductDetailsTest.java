package org.tests.qa;

import org.base.qa.BaseTest;
import org.openqa.selenium.By;
import org.pages.qa.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {
	
	@Test
	public void verifyBlueTopDetails() {
		
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'/product_details/1')]")).click();
		
		ProductDetailsPage detailspage = new ProductDetailsPage(driver);
		
		Assert.assertEquals(detailspage.getProductName(), "Blue Top");
		
		Assert.assertEquals(detailspage.getProductPrice(), "Rs. 500");
		
		Assert.assertTrue(detailspage.isAvailabilityDisplayed());
	}

}
