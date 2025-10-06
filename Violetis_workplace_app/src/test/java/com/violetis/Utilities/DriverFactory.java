package com.violetis.Utilities;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(DriverFactory.class);

    // Initialize WebDriver with browser parameter
    public static void initDriver(String browser) {
        if (driver.get() == null) {
            if (browser == null || browser.isEmpty()) {
                browser = "chrome"; // default browser
            }
            log.info("Initializing WebDriver for browser: {}", browser);

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.credentials_enable_service", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(chromeOptions));
                    log.info("✅ ChromeDriver launched successfully.");
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    log.info("✅ FirefoxDriver launched successfully.");
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver.set(new EdgeDriver(edgeOptions));
                    log.info("✅ EdgeDriver launched successfully.");
                    break;

                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();
            log.info("Browser window maximized.");
        }
    }

    // Return WebDriver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver and remove from ThreadLocal
    public static void quitDriver() {
        if (driver.get() != null) {
            log.info("Closing browser...");
            driver.get().quit();
            driver.remove();
            log.info("Browser closed.");
        }
    }
}
