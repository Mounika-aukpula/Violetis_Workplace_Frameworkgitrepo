package com.violetis.Pages.ManagerPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.AttendenceDetailsLocators;
import com.violetis.Utilities.WaitUtils;

public class AttendenceDetailsPage extends BasePage{

	public AttendenceDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAttendencedetailsmenu() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, AttendenceDetailsLocators.Attendence_mainmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,AttendenceDetailsLocators.AttendenceDetails_subenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Attendance submenu");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Attendence details menu.", e);
	            throw new RuntimeException("Navigation to Attendance failed!", e);
	        }
	}
	public void selectuser(String username) {
		 // Click the input to open dropdown
        WaitUtils.waitForElementClickable(driver,AttendenceDetailsLocators.selectuserdrpdown , 10).click();

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, AttendenceDetailsLocators.selectuseroptions, 5);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(AttendenceDetailsLocators.selectuseroptions);
        for (WebElement option : options) {
            if (option.getText().equals(username)) {
                option.click();
                log.info("Selected user: " + username);
                break;
            }
        }
	}
	public Map<String, String> getFirstRowAttendanceData() {
		 Map<String, String> rowData = new HashMap<>();
		String dateele= WaitUtils.waitForElementVisible(driver, AttendenceDetailsLocators.firstrowdateele, 20).getText();
		String clockinele=WaitUtils.waitForElementVisible(driver,AttendenceDetailsLocators.firstrowclockinele,20).getText();
		String clockedtimeele=WaitUtils.waitForElementVisible(driver,AttendenceDetailsLocators.firstrowclockedtimeele,20).getText();
		String status=WaitUtils.waitForElementVisible(driver,AttendenceDetailsLocators.firstrowstatusele,20).getText();
		String clockedoutele=WaitUtils.waitForElementVisible(driver,AttendenceDetailsLocators.firstrowclockoutele,20).getText();
		  rowData.put("Date", dateele);
		  rowData.put("statjus", status);
		  rowData.put("clockintime", clockinele);
		  rowData.put("clockedtime", clockedtimeele);
		  rowData.put("clockin", clockedoutele);
		  return rowData;
}
}
