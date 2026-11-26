package org.hooks.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	
	public static WebDriver driver; 
	public static WebDriverWait wait;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.automationexercise.com/");
		
		System.out.println("Cucumber Before Hook Executed");
	}
	
	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
			driver = null;
			wait = null;
		}
	}

}

