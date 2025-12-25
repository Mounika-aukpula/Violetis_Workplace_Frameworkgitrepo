package com.violetis.Pages.ManagerPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EMPLeaveLocators;
import com.violetis.Locators.ManagerPageLocators.EmployeePageLocators;
import com.violetis.Locators.ManagerPageLocators.ManagerAttendencedetailsLocators;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class EmployeePage extends BasePage{

	public EmployeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoemployeepage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EmployeePageLocators.employeesmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,EmployeePageLocators.employeessubmenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Leave submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
/* for doing validations on emp work statusunder Manaer dashboard*/
	//get list of view elements
	public List<WebElement> getallviewbtns(){
		 List<WebElement> viewButtons= WaitUtils.waitForElementsVisible(driver, EmployeePageLocators.allrowsviewbtns, 15);
	    return viewButtons;
	}
	public int getEmployeesStillInProbationToday() throws InterruptedException {

	    int probationCount = 0;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate today = LocalDate.now();

	    // Get all view buttons once
	    List<WebElement> viewButtons = getallviewbtns();

	    for (WebElement viewBtn : viewButtons) {

	        viewBtn.click();   // clicking on view btn

	        WaitUtils.waitForElementClickable(driver, EmployeePageLocators.workinfotab, 20).click();

	        String startDateStr = WaitUtils.waitForElementVisible(driver, EmployeePageLocators.probation_startdate, 15).getText();
	        String endDateStr   = WaitUtils.waitForElementVisible(driver, EmployeePageLocators.probation_enddate, 15).getText();

	        // Skip employees without probation data
	        if (startDateStr.equals("-") || endDateStr.equals("-")) {
	        	Thread.sleep(2000);
	        	WaitUtils.waitForElementClickable(driver, EmployeePageLocators.closebtn, 20).click();
	            continue;// it just skip that emp who having - data
	        }

	        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
	        LocalDate endDate   = LocalDate.parse(endDateStr, formatter);

	        if ((today.isEqual(startDate) || today.isAfter(startDate)) &&
	            (today.isEqual(endDate)   || today.isBefore(endDate))) {
	            probationCount++;
	        }
            Thread.sleep(15000);
	        WaitUtils.waitForElementClickable(driver, EmployeePageLocators.closebtn, 20).click();
	    }

	    return probationCount;
	}
/*dashboard activeemps count validations method*/
	public void clickonactivetab() {
		 WaitUtils.waitForElementVisible(driver, EmployeePageLocators.activetab, 15).click();
	}
	public int getallrowscount() {
		List<WebElement> allrows=WaitUtils.waitForElementsVisible(driver, EmployeePageLocators.allrows, 15);
		int rows=allrows.size();
		return rows;
	}
	
}
