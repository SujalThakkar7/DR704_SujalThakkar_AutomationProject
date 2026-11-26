package org.pages.qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	
	WebDriver driver; 
	WebDriverWait wait; 
	
	// Locators 
	By contactUsLink = By.xpath("//a[@href='/contact_us']");
	By name = By.name("name");
	By email = By.name("email");
	By subject = By.name("subject");
	By message = By.name("message");
	By uploadFile = By.name("upload_file");
	By submitButton = By.name("submit");
	By successMessage = By.xpath("//div[contains(@class,'status') and contains(@class,'alert-success')]");
	
	//Constructor 
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Open Contact Us Page
	public void openContactUsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
	}
	
	// Fill Contact Us form
	public void fillContactForm(String userName, String userEmail, String userSubject, String userMessage) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(userName);
		driver.findElement(email).sendKeys(userEmail);
		driver.findElement(subject).sendKeys(userSubject);
		driver.findElement(message).sendKeys(userMessage);
	}
	
	//Upload File
	public void uploadSampleFile(String filepath) {
		driver.findElement(uploadFile).sendKeys(filepath);
	}
	
	//Submit Form
	public void submitForm() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	// Get Success Message
	public String getSucessMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	}

}
