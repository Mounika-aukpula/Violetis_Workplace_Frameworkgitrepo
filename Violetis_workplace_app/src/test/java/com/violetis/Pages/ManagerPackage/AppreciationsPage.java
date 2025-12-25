package com.violetis.Pages.ManagerPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.AppreciationsPageLocators;
import com.violetis.Locators.ManagerPageLocators.EmployeePageLocators;
import com.violetis.Locators.ManagerPageLocators.ManagerAttendencedetailsLocators;
import com.violetis.Utilities.WaitUtils;

public class AppreciationsPage extends BasePage{

	public AppreciationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAppreciationpage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.Appreciationsmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.appreciations_submenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Appreciations submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
	public int getTotalRowCount() {

	    int totalRowCount = 0;

	    int lastpageno=Integer.parseInt(WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.lastpagenum, 15).getText());

	    // If pagination exists
	    if (lastpageno > 1) {

	       

	        for (int i = 1; i <= lastpageno; i++) {

	            // Count rows in current page
	            List<WebElement> rows =WaitUtils.waitForElementsVisible(driver,AppreciationsPageLocators.allrows,20);
	            totalRowCount += rows.size();

	            // Click next only if not last page
	            if (i < lastpageno) {
	                WebElement nextBtn = WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.pagenavigationnextbtn,20);

	                if (!nextBtn.getAttribute("class").contains("disabled")) {
	                    nextBtn.click();
	                    WaitUtils.waitForPageToLoad(driver); // custom wait
	                }
	            }
	        }

	    } else {
	        // Only one page
	        List<WebElement> rows =WaitUtils.waitForElementsVisible(driver,AppreciationsPageLocators.allrows,20);
	        totalRowCount = rows.size();
	    }

	    return totalRowCount;
	}
	 public void SelectByuser(String empname) {
		 // Click the input to open dropdown
	        WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.selectuserdrpdown , 10).click();

	        // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.selectuserdrpdownoptions, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(AppreciationsPageLocators.selectuserdrpdownoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(empname)) {
	                option.click();
	                log.info("Selected user: " + empname);
	                break;
	            }
	        }
	 }
	
}
