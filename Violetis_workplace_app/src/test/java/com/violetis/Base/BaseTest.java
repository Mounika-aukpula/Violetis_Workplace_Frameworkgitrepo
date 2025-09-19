package com.violetis.Base;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.violetis.Utilities.ConfigReader;
import com.violetis.Utilities.DriverFactory;
import com.violetis.Utilities.WaitUtils;

public class BaseTest {
	protected WebDriver driver;
    protected Logger log = LogManager.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        log.info("===== Test setup started =====");


        // ✅ Init driver (no return)
        DriverFactory.initDriver();

        // ✅ Get driver for current thread
        driver = DriverFactory.getDriver();
        log.info("Driver initialized for browser: {}", ConfigReader.getProperty("browser"));

        // Implicit wait (can be kept low because we use explicit waits in BasePage/WaitUtils)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        log.info("Browser window maximized and implicit wait applied.");

        // Navigate to application URL from config.properties
        String appUrl = ConfigReader.getProperty("url");
        driver.get(appUrl);
        log.info("Navigated to application URL: {}", appUrl);

        // Ensure page is fully loaded before test
        WaitUtils.waitForPageLoad(driver, 15);
        log.info("Page load completed for URL: {}", appUrl);

        log.info("===== Test setup completed =====");
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Test teardown started =====");
        DriverFactory.quitDriver();
        log.info("Driver quit successfully.");
        log.info("===== Test teardown completed =====");
    }
}
