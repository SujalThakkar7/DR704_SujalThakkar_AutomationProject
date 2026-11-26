
package org.utilities.qa;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.base.qa.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.initReport();
        System.out.println("Extent Report Initialized");
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        if (result.getParameters().length > 0) {
            testName = testName + " " +
            Arrays.toString(result.getParameters());
        }

        ExtentManager.createTest(testName);
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentManager.getTest().pass("Test Passed");
        System.out.println("Test Passed Successfully: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentManager.getTest().fail(result.getThrowable());
        System.out.println("Test Failed: " + result.getName());

        // Capture screenshot when a TestNG test fails
        
        try {
            Object instance = result.getInstance();
            if (instance instanceof BaseTest) {

                BaseTest baseTest = (BaseTest) instance;
                WebDriver driver = baseTest.getDriver();

                if (driver != null) {
                    new File("test-output/screenshots").mkdirs();
                    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

                    String screenshotPath = "test-output/screenshots/" + result.getMethod().getMethodName()+ "_" + timeStamp + ".png";

                    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                    File destination = new File(screenshotPath);

                    Files.copy(source.toPath(),destination.toPath(),StandardCopyOption.REPLACE_EXISTING);

                    ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);
                }
            }

        } catch (Exception e) {

            ExtentManager.getTest().warning("Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentManager.getTest().skip("Test Skipped: " + result.getThrowable());
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
        System.out.println("Extent Report Generated");
    }

}
