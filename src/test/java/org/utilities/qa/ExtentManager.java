package org.utilities.qa;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent; 
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static ExtentReports initReport() {
		
		if (extent == null) {
			new File("test-output").mkdirs();
			extent = new ExtentReports();
			
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
			
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Test Report");
			spark.config().setReportName("DR704 Functional Testing");
			
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Project", "DR704 Automation Project");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Framework", "Selenium + TestNG + Cucumber");
			
		}
		
		return extent; 
	}
	
	public static void createTest(String testName) {
		
		ExtentTest test = extent.createTest(testName);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
		
	}
	
	public static void flushReport() {
		
		if(extent != null) {
			extent.flush();
		}
	}
}
