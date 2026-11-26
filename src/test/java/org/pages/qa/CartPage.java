package org.pages.qa;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By cartRows = By.xpath("//tr[contains(@id,'product-')]");
	By productNames = By.xpath("//td[@class='cart_description']/h4/a");
	By productQuantities = By.xpath("//td[@class='cart_quantity']/button");
	By productPrices = By.xpath("//td[@class='cart_price']/p");
	By productTotals = By.xpath("//td[@class='cart_total']/p");
	
	// Constructor 
	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Get Product Count
	public int getProductCount() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartRows)).size();
	}
	
	//Get Product names
	public List<String> getProductNames() {
		List<String> names = new ArrayList<>();
		
		for (WebElement element : driver.findElements(productNames)) {
			names.add(element.getText());
		}
		return names;
	}
	
	//Get product quantities
	public List<String> getProductQuantities() {
		List<String> quantities = new ArrayList<>();
		
		for (WebElement element : driver.findElements(productQuantities)) {
			quantities.add(element.getText());
		}
		return quantities;
	}
	
	// Get product prices
    public List<String> getProductPrices() {
        List<String> prices = new ArrayList<>();

        for (WebElement element : driver.findElements(productPrices)) {
            prices.add(element.getText());
        }

        return prices;
    }

	//Get product line totals
    public List<String> getProductTotals() {
        List<String> totals = new ArrayList<>();

        for (WebElement element : driver.findElements(productTotals)) {
            totals.add(element.getText());
        }

        return totals;

}
    
}

