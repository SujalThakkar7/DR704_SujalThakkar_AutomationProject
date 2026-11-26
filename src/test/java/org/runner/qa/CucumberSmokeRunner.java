package org.runner.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
    features = "src/test/resources/features/B01_Quantity.feature",
    glue = {"org.stepdefinitions.qa", "org.hooks.qa"},
    tags = "@smoke",
    plugin = {"pretty"},
    monochrome = true
    
)
public class CucumberSmokeRunner extends AbstractTestNGCucumberTests {
	
}