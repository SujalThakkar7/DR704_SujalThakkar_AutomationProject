package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//locators 
	By productName = By.xpath("//div[@class='product-information']/h2");
	By productPrice = By.xpath("//div[@class='product-information']/span/span");
	By availability = By.xpath("//div[@class='product-information']//b[text()='Availability:']");
	
	//Constructor 
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Get product name 
	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
	}
	
	// Get product price
	public String getProductPrice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
}

	//Check availability
	public boolean isAvailabilityDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(availability)).isDisplayed();
		
	}

}