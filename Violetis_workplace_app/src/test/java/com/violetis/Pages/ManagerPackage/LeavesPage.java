package com.violetis.Pages.ManagerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.EmployeePageLocators;
import com.violetis.Locators.ManagerPageLocators.LeavepageLocators;
import com.violetis.Utilities.WaitUtils;

public class LeavesPage extends BasePage{

	public LeavesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public void navigatetoleavespage() {
	
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, LeavepageLocators.Leaves_mainmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,LeavepageLocators.Leaves_submenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Leave submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
public void clickonpendingtab() {
	WaitUtils.waitForElementVisible(driver, LeavepageLocators.pendingtabs, 15).click();
}
// Get list of users
public List<WebElement> getLeaveUsers() {
    return WaitUtils.waitForElementsVisible(driver, LeavepageLocators.allrowsnames, 10);
}
//Get list of startdate leave dates
public List<WebElement> getstartdayLeaveDates() {
    return WaitUtils.waitForElementsVisible(driver, LeavepageLocators.startdateele, 10);
}
//Get list of enddate leave dates
public List<WebElement> getenddateleavedates() {
  return WaitUtils.waitForElementsVisible(driver, LeavepageLocators.enddateele, 10);
}

public Map<String, String> mapUserToLeaveDates() {

    List<WebElement> users = getLeaveUsers();
    List<WebElement> startDates = getstartdayLeaveDates();
    List<WebElement> endDates = getenddateleavedates();

    Map<String, String> userDateMap = new HashMap<>();

    for (int i = 0; i < users.size(); i++) {
        String user = users.get(i).getText().trim();
        String startDate = startDates.get(i).getText().trim();
        String endDate = endDates.get(i).getText().trim();

        userDateMap.put(user, startDate + " - " + endDate);
    }

    return userDateMap;
}
//Leaves page validations Action methods
public void clickTab(String tabName) throws InterruptedException {
    switch (tabName.toLowerCase()) {
        case "all": WaitUtils.waitForElementVisible(driver, LeavepageLocators.alltab, 15).click(); break;
        case "pending":WaitUtils.waitForElementVisible(driver, LeavepageLocators.pendingtabs, 15).click(); break;
        case "approved": WaitUtils.waitForElementVisible(driver, LeavepageLocators.approvedtab, 15).click(); break;
        case "rejected":WaitUtils.waitForElementVisible(driver, LeavepageLocators.rejectedtab, 15).click(); break;
    }
   Thread.sleep(3000);
}
public int getRowCount() {
    return WaitUtils.waitForElementsVisible(driver,LeavepageLocators.allrows, 15).size();
}
public List<String> getStatuses() {
    List<String> statuses = new ArrayList<>();
    List<WebElement> statusColumn=WaitUtils.waitForElementsVisible(driver,LeavepageLocators.statuseles, 15);
    for (WebElement status : statusColumn) {
        statuses.add(status.getText().trim());
    }
    return statuses;
}

// Get actual header names from UI
public List<String> getTableHeaderNames() {
    List<String> headers = new ArrayList<>();
    List<WebElement> tableHeaders=WaitUtils.waitForElementsVisible(driver,LeavepageLocators.tableheaders, 15);
    for (WebElement header : tableHeaders) {
        headers.add(header.getText().trim());
    }
    return headers;
}
}
