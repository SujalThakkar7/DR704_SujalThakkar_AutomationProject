package org.stepdefinitions.qa;

import org.hooks.qa.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B03StepDefinitions {
	
	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		
		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();

	}

	@Then("I should see the Register Login prompt")
	public void i_should_see_the_register_login_prompt() {
		
		By registerLogin = By.xpath("//*[@id='checkoutModal']/div/div/div[2]/p[2]/a/u");

		boolean status = CucumberHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(registerLogin)).isDisplayed();
		Assert.assertTrue(status, "Register / Login prompt is not displayed");

		CucumberHooks.wait.until(ExpectedConditions.elementToBeClickable(registerLogin)).click();
		
		
	}

}
