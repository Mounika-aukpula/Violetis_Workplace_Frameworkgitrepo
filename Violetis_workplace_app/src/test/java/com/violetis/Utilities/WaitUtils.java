package com.violetis.Utilities;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitUtils {
	// Wait for element to be visible
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element to be clickable
    public static WebElement waitForElementClickable(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for element presence in DOM
    public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
 

    // Wait for specific text to appear in element
    public static boolean waitForTextInElement(WebDriver driver, By locator, String text, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.textToBe(locator, text));
    }

    // Wait for page to fully load (JS ready + no active AJAX calls)
    public static void waitForPageLoad(WebDriver driver, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until((ExpectedCondition<Boolean>) wd ->
            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
    public static void waitForTextNotEmpty(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(d -> !d.findElement(locator).getText().trim().isEmpty() 
                       && !d.findElement(locator).getText().contains("N/A"));
    }
    public static Alert waitForAlert(WebDriver driver, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public static List<WebElement> waitForElementsVisible(WebDriver driver, By locator, int timeoutSeconds) {
        int attempts = 0;
        List<WebElement> elements = null;

        while (attempts < 3) { // Retry up to 3 times if stale
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
                elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
                break; // success
            } catch (StaleElementReferenceException e) {
                attempts++; // retry
            }
        }

        return elements;
    }
    public static void waitForDrawerToClose(WebDriver driver, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector(".ant-drawer-mask")
        ));
    }
    public static int waitForStableNumber(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        return wait.until(d -> {
            try {
                WebElement el = d.findElement(locator);
                String prev = "";
                long start = System.currentTimeMillis();

                while (System.currentTimeMillis() - start < timeoutSeconds * 1000) {
                    String text = el.getText().trim();

                    if (!text.isEmpty() && text.matches("\\d+")) {
                        if (text.equals(prev)) {
                            // text stable for 500ms
                            Thread.sleep(500);
                            String check = el.getText().trim();
                            if (check.equals(text)) {
                                return Integer.parseInt(text);
                            }
                        }
                        prev = text;
                    }
                    Thread.sleep(100); // poll interval
                }
            } catch (Exception e) {
                // ignore StaleElementReferenceException
            }
            return null;
        });
    }
    public static List<WebElement> waitForElementsPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

	public static WebElement waitForElementClickablewebelement(WebDriver driver, WebElement element, int timeoutSeconds) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	
    
}
