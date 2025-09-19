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

    public static void initDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("browser");
            log.info("Initializing WebDriver for browser: {}", browser);

            switch (browser.toLowerCase()) {
                case "chrome":
                    log.info("Setting up ChromeDriver...");
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.credentials_enable_service", false);
                    options.setExperimentalOption("prefs", prefs);
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                    log.info("✅ ChromeDriver launched successfully.");
                    break;

                case "firefox":
                    log.info("Setting up FirefoxDriver...");
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    log.info("✅ FirefoxDriver launched successfully.");
                    break;

                case "edge":
                    log.info("Setting up EdgeDriver...");
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver.set(new EdgeDriver(edgeOptions));
                    log.info("✅ EdgeDriver launched successfully.");
                    break;

                default:
                    log.error("❌ Unsupported browser: {}", browser);
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            getDriver().manage().window().maximize();
            log.info("Browser window maximized.");
        } else {
            log.warn("⚠️ Driver is already initialized. Returning existing instance.");
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            log.warn("⚠️ getDriver() called before initDriver(). Returning null.");
        } else {
            log.debug("Returning active WebDriver instance.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            log.info("Closing the browser and quitting WebDriver...");
            driver.get().quit();
            driver.remove(); // ✅ important: remove from ThreadLocal
            log.info("✅ Browser closed and WebDriver instance removed.");
        } else {
            log.warn("⚠️ quitDriver() called, but no WebDriver instance was active.");
        }
    }
}
