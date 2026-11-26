package org.stepdefinitions.qa;

import java.util.List;

import org.hooks.qa.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B02StepDefinitions {
	
	@When("I add Blue Top to the cart")
	public void i_add_blue_top_to_the_cart() {
	    
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-product-id='1' and contains(@class,'add-to-cart')]"))).click();
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))).click();
	}

	@When("I open the cart")
	public void i_open_the_cart() {
		
		CucumberHooks.wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//a[@href='/view_cart' and contains(.,'Cart')]")
		        )
		    ).click();
		}

	@When("I remove Blue Top from the cart")
	public void i_remove_blue_top_from_the_cart() {
	   
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='product-1']//a[contains(@class,'cart_quantity_delete')]"))).click();
	}

	@Then("Blue Top should not be displayed in the cart")
	public void blue_top_should_not_be_displayed_in_the_cart() {
		
	    CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='product-1']//a[contains(@class,'cart_quantity_delete')]"))).click();
	    CucumberHooks.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("product-1")));
		
	}

	@Then("the cart should be empty")
	public void the_cart_should_be_empty() {
	 
		List<WebElement> products = CucumberHooks.driver.findElements(By.xpath("//tr[contains(@id,'product-')]"));
		
		Assert.assertEquals(products.size(), 0, "Cart is not empty");
	}

}
