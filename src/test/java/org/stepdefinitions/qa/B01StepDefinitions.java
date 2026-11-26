package org.stepdefinitions.qa;

import org.hooks.qa.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B01StepDefinitions {

	
	
	@Given("I am on the Products page")
	public void i_am_on_the_products_page() {
		
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']"))).click();

	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		
		WebElement searchBox = CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
		searchBox.clear();
		searchBox.sendKeys(string);
		
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search"))).click();
	}

	@When("I open the Blue Top product details")
	public void i_open_the_blue_top_product_details() {
	    CucumberHooks.driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		  
		}

	@When("I set the product quantity to {int}")
	public void i_set_the_product_quantity_to(Integer int1) {
		
		WebElement quantityBox = CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity")));
		quantityBox.clear();
		quantityBox.sendKeys(int1.toString());

	}

	@When("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
		
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add to cart']"))).click();
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cartModal']//a[@href='/view_cart']"))).click();
	}

	@Then("I should see {string} in the cart")
	public void i_should_see_in_the_cart(String string) {
		
		By productName = By.xpath("//td[@class='cart_description']/h4/a");
		
		boolean status = false; 
		
		for (WebElement product : CucumberHooks.driver.findElements(productName)) {
			
			if (product.getText().equals(string)) {
				status = true; 
				break; 
			}
			
		}
		
		Assert.assertTrue(status, "Product not displayed in Cart");
	}

	@Then("the product quantity should be {int}")
	public void the_product_quantity_should_be(Integer int1) {
		
		String actualQuantity = CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_quantity button"))).getText();
		
		Assert.assertEquals(actualQuantity, int1.toString(), "Product quantity does not match");
	}


}

