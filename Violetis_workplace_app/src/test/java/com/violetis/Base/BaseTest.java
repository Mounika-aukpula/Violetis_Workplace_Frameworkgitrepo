package com.violetis.Base;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.violetis.Utilities.ConfigReader;
import com.violetis.Utilities.DriverFactory;
import com.violetis.Utilities.WaitUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import org.testng.annotations.Listeners;
import com.violetis.Listners.TestListner;
@Listeners(TestListner.class) 
public class BaseTest {
	protected WebDriver driver;
    protected Logger log = LogManager.getLogger(this.getClass());
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUpClass(@Optional("chrome") String browser) {
        log.info("===== Browser setup started =====");
        log.info("Browser to run: {}", browser);

        // Initialize WebDriver
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        // Implicit wait and page load wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WaitUtils.waitForPageLoad(driver, 80);

        // Navigate to application URL
        String appUrl = ConfigReader.getProperty("loginurl");
        driver.get(appUrl);
        WaitUtils.waitForPageLoad(driver, 50);
        log.info("Navigated to application URL: {}", appUrl);

        log.info("===== Browser setup completed =====");
    }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        log.info("===== Browser teardown started =====");
        DriverFactory.quitDriver();
        log.info("===== Browser teardown completed =====");
    }

   /* @Parameters("browser") 
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        log.info("===== Test setup started =====");
        log.info("Browser to run: {}", browser);

        // Initialize WebDriver
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WaitUtils.waitForPageLoad(driver, 80);

        // Navigate to URL
        String appUrl = ConfigReader.getProperty("loginurl"); // read URL from config.properties
        driver.get(appUrl);
        log.info("Navigated to application URL: {}", appUrl);

        // Wait for page load
        WaitUtils.waitForPageLoad(driver, 50);
        log.info("===== Test setup completed =====");
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Test teardown started =====");
        DriverFactory.quitDriver();
        log.info("===== Test teardown completed =====");
    }*/
}
