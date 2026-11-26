package org.stepdefinitions.qa;

import org.hooks.qa.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B04StepDefinitions {

	@When("I register a new practice account")
	public void i_register_a_new_practice_account() {
		
		// Register / Login
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkoutModal']/div/div/div[2]/p[2]/a/u"))).click();
		
		// Email
		String email = "testuser00100@example.com";
		
		// Signup
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys("Test User");
		CucumberHooks.driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
		CucumberHooks.driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		
		// Information
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		CucumberHooks.driver.findElement(By.id("id_gender1")).click();
		CucumberHooks.driver.findElement(By.id("password")).sendKeys("Test@12345");
		new Select(CucumberHooks.driver.findElement(By.id("days"))).selectByValue("1");
		new Select(CucumberHooks.driver.findElement(By.id("months"))).selectByValue("1");
		new Select(CucumberHooks.driver.findElement(By.id("years"))).selectByValue("2005");
		
		// Address 
		CucumberHooks.driver.findElement(By.id("first_name")).sendKeys("Test");
		CucumberHooks.driver.findElement(By.id("last_name")).sendKeys("User");
		CucumberHooks.driver.findElement(By.id("company")).sendKeys("Demo Company");
		CucumberHooks.driver.findElement(By.id("address1")).sendKeys("Address");
		new Select(CucumberHooks.driver.findElement(By.id("country"))).selectByVisibleText("India");
		CucumberHooks.driver.findElement(By.id("state")).sendKeys("Maharashtra");
		CucumberHooks.driver.findElement(By.id("city")).sendKeys("Mumbai");
		CucumberHooks.driver.findElement(By.id("zipcode")).sendKeys("400001");
		CucumberHooks.driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
		
		// Create Account 
		CucumberHooks.driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Created!']"))).click();
		
	}

	@When("I complete the checkout details")
	public void i_complete_the_checkout_details() {
		
		// Open Cart 
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/view_cart' and contains(.,'Cart')]"))).click();
		
		// Proceed
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();
		
		// Verify delivery address
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_delivery")));
		
		// Verify order view 
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_info")));
	}

	@When("I place the order with dummy payment details")
	public void i_place_the_order_with_dummy_payment_details() {
		
		// Click Place Order
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/payment']"))).click();
		
		// Enter dummy details (Payment) 
		CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card"))).sendKeys("Test User");
		CucumberHooks.driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
		CucumberHooks.driver.findElement(By.name("cvc")).sendKeys("123");
		CucumberHooks.driver.findElement(By.name("expiry_month")).sendKeys("12");
		CucumberHooks.driver.findElement(By.name("expiry_year")).sendKeys("2030");
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
	}

	@Then("I should see the order confirmation")
	public void i_should_see_the_order_confirmation() {
		
		boolean status = CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Order Placed!']"))).isDisplayed();
		Assert.assertTrue(status, "Order confirmation is not displayed");
		
	}

}
