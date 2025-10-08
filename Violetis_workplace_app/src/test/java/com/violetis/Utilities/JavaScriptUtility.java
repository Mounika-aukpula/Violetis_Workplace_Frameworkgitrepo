package com.violetis.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	private WebDriver driver;
    private JavascriptExecutor js;

    // Constructor
    public JavaScriptUtility(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * Scrolls the page until the given element is in view.
     */
    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls down by a specified number of pixels.
     */
    public void scrollDown(int pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }

    /**
     * Scrolls up by a specified number of pixels.
     */
    public void scrollUp(int pixels) {
        js.executeScript("window.scrollBy(0,-" + pixels + ");");
    }

    /**
     * Clicks on an element using JavaScript.
     */
    public void clickElementByJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Sends text to an element using JavaScript.
     */
    public void sendKeysByJS(WebElement element, String value) {
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    /**
     * Retrieves the page title using JavaScript.
     */
    public String getTitleByJS() {
        return js.executeScript("return document.title;").toString();
    }

    /**
     * Refreshes the page using JavaScript.
     */
    public void refreshBrowserByJS() {
        js.executeScript("history.go(0)");
    }

    /**
     * Highlights an element (for debugging or reporting).
     */
    public void highlightElement(WebElement element) {
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    /**
     * Draws a border around an element.
     */
    public void drawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    /**
     * Generates a browser alert message.
     */
    public void generateAlert(String message) {
        js.executeScript("alert('" + message + "')");
    }

    /**
     * Returns the entire inner text of the page.
     */
    public String getPageInnerText() {
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    /**
     * Zooms the page view.
     * @param zoomPercentage e.g., 50, 100, 150
     */
    public void zoomPage(int zoomPercentage) {
        js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
    }

    /**
     * Scrolls to the bottom of the page.
     */
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls to the top of the page.
     */
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0)");
    }
}
