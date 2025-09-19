package com.violetis.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BasePage {
	protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.log = LogManager.getLogger(this.getClass());
    }

    // ===== Common Methods =====

    	    // Get element with wait
    	    protected WebElement getElement(By locator) {
    	        WebElement element = WaitUtils.waitForElementVisible(driver, locator, 10);
    	        log.debug("Located element: {}", locator);
    	        return element;
    	    }

    	    // Click element
    	    protected void click(By locator) {
    	        getElement(locator).click();
    	        log.info("Clicked on element: {}", locator);
    	    }

    	    // Type text
    	    protected void type(By locator, String text) {
    	        WebElement element = getElement(locator);
    	        element.clear();
    	        element.sendKeys(text);
    	        log.info("Typed '{}' into element: {}", text, locator);
    	    }

    	    // Get text
    	    protected String getText(By locator) {
    	        String text = getElement(locator).getText();
    	        log.info("Fetched text '{}' from element: {}", text, locator);
    	        return text;
    	    }

    	    // Get attribute
    	    protected String getAttribute(By locator, String attribute) {
    	        String value = getElement(locator).getAttribute(attribute);
    	        log.info("Fetched attribute '{}' value '{}' from element: {}", attribute, value, locator);
    	        return value;
    	    }

    	    // Get current URL
    	    public String getCurrentUrl() {
    	        String url = driver.getCurrentUrl();
    	        log.info("Current URL is: {}", url);
    	        return url;
    	    }

    	    // Get page title
    	    public String getTitle() {
    	        String title = driver.getTitle();
    	        log.info("Page title is: {}", title);
    	        return title;
    	    }
}
