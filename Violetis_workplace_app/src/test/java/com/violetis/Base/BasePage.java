package com.violetis.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Utilities.WaitUtils;
import com.violetis.Utilities.JavaScriptUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BasePage {
	protected WebDriver driver;
    protected Logger log;
    protected JavaScriptUtility jsUtil;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.log = LogManager.getLogger(this.getClass());
        this.jsUtil = new JavaScriptUtility(driver);
    }

    // ===== Element Handling =====

    protected WebElement getElement(By locator) {
        WebElement element = WaitUtils.waitForElementVisible(driver, locator, 10);
        log.debug("Located element: {}", locator);
        return element;
    }

    protected void click(By locator) {
        WebElement element = getElement(locator);
        highlightElement(element);
        try {
            element.click();
            log.info("Clicked on element: {}", locator);
        } catch (Exception e) {
            log.warn("Normal click failed on {} - trying JS click", locator);
            jsUtil.clickElementByJS(element);
        }
    }

    protected void type(By locator, String text) {
        WebElement element = getElement(locator);
        highlightElement(element);
        try {
            element.clear();
            element.sendKeys(text);
            log.info("Typed '{}' into element: {}", text, locator);
        } catch (Exception e) {
            log.warn("Normal sendKeys failed on {} - using JS sendKeys", locator);
            jsUtil.sendKeysByJS(element, text);
        }
    }

    protected String getText(By locator) {
        String text = getElement(locator).getText();
        log.info("Fetched text '{}' from element: {}", text, locator);
        return text;
    }

    protected String getAttribute(By locator, String attribute) {
        String value = getElement(locator).getAttribute(attribute);
        log.info("Fetched attribute '{}' value '{}' from element: {}", attribute, value, locator);
        return value;
    }

    // ===== Element State Checks =====

    protected boolean isDisplayed(By locator) {
        try {
            boolean displayed = getElement(locator).isDisplayed();
            log.info("Element {} is displayed: {}", locator, displayed);
            return displayed;
        } catch (Exception e) {
            log.warn("Element {} not displayed", locator);
            return false;
        }
    }

    protected boolean isEnabled(By locator) {
        try {
            boolean enabled = getElement(locator).isEnabled();
            log.info("Element {} is enabled: {}", locator, enabled);
            return enabled;
        } catch (Exception e) {
            log.warn("Element {} not enabled", locator);
            return false;
        }
    }

    protected boolean isSelected(By locator) {
        try {
            boolean selected = getElement(locator).isSelected();
            log.info("Element {} is selected: {}", locator, selected);
            return selected;
        } catch (Exception e) {
            log.warn("Element {} not selected", locator);
            return false;
        }
    }

    // ===== Scrolling and Highlight =====

    protected void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        jsUtil.scrollIntoView(element);
        log.info("Scrolled to element: {}", locator);
    }

    protected void scrollToTop() {
        jsUtil.scrollToTop();
        log.info("Scrolled to top of page");
    }

    protected void scrollToBottom() {
        jsUtil.scrollToBottom();
        log.info("Scrolled to bottom of page");
    }

    protected void highlightElement(WebElement element) {
        try {
            jsUtil.highlightElement(element);
        } catch (Exception e) {
            log.debug("Highlight failed: {}", e.getMessage());
        }
    }

    // ===== Page Info =====

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        log.info("Current URL is: {}", url);
        return url;
    }

    public String getTitle() {
        String title = driver.getTitle();
        log.info("Page title is: {}", title);
        return title;
    }
}
