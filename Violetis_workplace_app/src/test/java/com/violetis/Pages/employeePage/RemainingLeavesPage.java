package com.violetis.Pages.employeePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.RemainingLeaveLocators;
import com.violetis.Utilities.WaitUtils;

public class RemainingLeavesPage extends BasePage{

	public RemainingLeavesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public void navigatetoremaingleavepage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, RemainingLeaveLocators.Leavebtn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,RemainingLeaveLocators.remainingleave_btn, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the remaining leaves submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
public void selectyear(String targetyear) {
	WaitUtils.waitForElementPresence(driver, RemainingLeaveLocators.yeardrpdwnbtn, 30).click();
	 // Wait until year picker visible
    WaitUtils.waitForElementVisible(driver, RemainingLeaveLocators.yearrangeele, 10); 
    String rangeText = driver.findElement( RemainingLeaveLocators.yearrangeele).getText().trim();
    int startYear = Integer.parseInt(rangeText.split("-")[0]);
    int endYear = Integer.parseInt(rangeText.split("-")[1]);
    int Year = Integer.parseInt(targetyear);
    
    // Navigate decades if needed
    while (Year < startYear) {
        driver.findElement(RemainingLeaveLocators.yearprevbtn).click();
        WaitUtils.waitForElementVisible(driver, RemainingLeaveLocators.yearrangeele, 5);
        rangeText = driver.findElement(RemainingLeaveLocators.yearrangeele).getText().trim();
        startYear = Integer.parseInt(rangeText.split("-")[0]);
        endYear = Integer.parseInt(rangeText.split("-")[1]);
    }
    while (Year > endYear) {
        driver.findElement(RemainingLeaveLocators.yearfrnwdbtn).click();
        WaitUtils.waitForElementVisible(driver, RemainingLeaveLocators.yearrangeele, 5);
        rangeText = driver.findElement(RemainingLeaveLocators.yearrangeele).getText().trim();
        startYear = Integer.parseInt(rangeText.split("-")[0]);
        endYear = Integer.parseInt(rangeText.split("-")[1]);
    }

    // Click desired year
    WebElement yearElement = driver.findElement(RemainingLeaveLocators.yearOption(targetyear));
    yearElement.click();
}

public Map<String, Integer> getRemainingLeaves() {
    Map<String, Integer> leaves = new HashMap<>();

    List<WebElement> names =  WaitUtils.waitForElementsVisible(driver,RemainingLeaveLocators.remainingleavenames, 15);
    List<WebElement> counts = WaitUtils.waitForElementsVisible(driver,RemainingLeaveLocators.remainingleavecount, 15);

    int total = Math.min(names.size(), counts.size());
    for (int i = 0; i < total; i++) {
        String name = names.get(i).getText().trim();
        String countText = counts.get(i).getText().trim();

        // Validate numeric value
        int count = 0;
        try {
            count = Integer.parseInt(countText);
        } catch (NumberFormatException e) {
            System.err.println("⚠️ Invalid number for leave type: " + name + " -> " + countText);
        }

        leaves.put(name, count);
    }

    return leaves;
}
//get any of the leavetypes count is got decreased
public Map<String, Integer> getDecreasedLeaves(Map<String, Integer> expectedDefault) {
    Map<String, Integer> decreasedLeaves = new HashMap<>();

    Map<String, Integer> currentLeaves = getRemainingLeaves();

    for (String type : expectedDefault.keySet()) {
        int expected = expectedDefault.get(type);
        int current = currentLeaves.getOrDefault(type, expected);

        if (current < expected) {
            int diff = expected - current;
            decreasedLeaves.put(type, diff);
            System.out.println("🔻 " + type + " decreased by " + diff);
        } else {
            System.out.println("✅ " + type + " unchanged (" + current + ")");
        }
    }

    return decreasedLeaves;
}
public void clickondasboardanchor() {
	WaitUtils.waitForElementVisible(driver,RemainingLeaveLocators.dashboardanchortag, 15).click();
}
}


