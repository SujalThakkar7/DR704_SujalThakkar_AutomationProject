package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
	
	WebDriver driver; 
	WebDriverWait wait;
	
	//locators 
	By productsLink = By.xpath("//a[@href='/products']");
	By searchBox = By.id("search_product");
	By searchButton = By.id("submit_search");
	By productName = By.xpath("//div[@class='productinfo text-center']/p");
	By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
	By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
	By cartLink = By.xpath("//a[@href='/view_cart']");
	By searchedProduct = By.xpath("//div[@class='productinfo text-center']/p");
	
	//Constructor 
	public ProductsPage(WebDriver driver) {
		this.driver = driver; 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Open Products page
	public void openProductsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
	}
	
	//Search Product
	public void searchProduct(String product) {
	    WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	    box.clear();
	    box.sendKeys(product);
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	//Get Product name 
	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
	}
	
	//Add product to cart
	public void addToCart() {
	    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	    
	}
	
	//Continue shopping
	public void continueShopping() {
	    wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
	}

	// Open cart
	public void openCart() {
	    WebElement product = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(searchedProduct));
	    
	    WebElement addButton = product.findElement(
	            By.xpath("./following-sibling::a[contains(@class,'add-to-cart')]"));

	    addButton.click();
	}

}
