package org.tests.qa;

import org.base.qa.BaseTest;
import org.pages.qa.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {
	
	@Test
	public void verifyContactUsForm() {
		
		ContactUsPage cup= new ContactUsPage(driver);
		
		//Open Contact Us page
		cup.openContactUsPage();
		
		//Fill the form
		cup.fillContactForm("Test User", "testuser@gmail.com", "Automation Testing", "This is a sample file for Contact Us testing.");
		
		//Upload Sample File 
		cup.uploadSampleFile("C:\\Users\\sujal\\eclipse-workspace\\DR704_AutomationProject\\src\\test\\resources\\testfiles\\SampleUpload.txt");
		
		// Submit form
		cup.submitForm();
	
		//Accept Browser Alert
		driver.switchTo().alert().accept();
		
		//Verify success message
		String actualMessage = cup.getSucessMessage();
		
		Assert.assertEquals(actualMessage, "Success! Your details have been submitted successfully.");
	}

}

