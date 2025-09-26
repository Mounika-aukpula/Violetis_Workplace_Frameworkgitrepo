package com.violetis.Listners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.violetis.Utilities.ScreenshotUtils;
import com.violetis.Utilities.DriverFactory;
public class TestListner implements ITestListener{
	private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testReport.get().log(Status.PASS, "✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String screenshotPath = ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), testName);

        testReport.get().log(Status.FAIL, "❌ Test Failed: " + testName);
        testReport.get().log(Status.FAIL, result.getThrowable());
        testReport.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testReport.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🚀 Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Test Suite Finished: " + context.getName());
        extent.flush(); // ✅ Write the report after execution
    }
}
