package com.violetis.Listners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.violetis.Utilities.ScreenshotUtils;
import com.violetis.Utilities.DriverFactory;
public class TestListner implements ITestListener{
	  @Override
	    public void onTestFailure(ITestResult result) {
	        // Get test name
	        String testName = result.getName();

	        // Take screenshot
	        String screenshotPath = ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), testName);
	        System.out.println("📸 Screenshot captured for failed test: " + screenshotPath);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("✅ Test Passed: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("⚠️ Test Skipped: " + result.getName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("🚀 Starting Test Suite: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("🏁 Finished Test Suite: " + context.getName());
	    }
}
