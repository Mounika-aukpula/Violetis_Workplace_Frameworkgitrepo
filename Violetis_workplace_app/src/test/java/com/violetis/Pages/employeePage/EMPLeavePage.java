package com.violetis.Pages.employeePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.EmpPageLocators.EMPLeaveLocators;
import com.violetis.Utilities.WaitUtils;
import com.violetis.Utilities.JavaScriptUtility;

public class EMPLeavePage extends BasePage{
	private JavaScriptUtility jsUtil;
	public EMPLeavePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoLeavebutton() {
		 try {
             // Wait for main menu
             WebElement Leave_mainMenu = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Leavebtn, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Leave main menu.");
             actions.moveToElement(Leave_mainMenu).click().perform();
             
          // Wait for submenu
             WebElement subMenu = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.sub_leave_btn, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(subMenu);
             WaitUtils.waitForElementClickable(driver, EMPLeaveLocators.sub_leave_btn, 50);
             try {
             	subMenu.click();
                 log.info("Clicked on leaves submenu using standard click.");
             } catch (Exception clickEx) {
                 log.warn("Standard click failed on leaves submenu. Trying JS click...");
                 jsUtil.clickElementByJS(subMenu);
                 log.info("Clicked on leaves submenu using JS click.");
             }
             
             log.info("Clicked on the leaves submenu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Leaves.", e);
             throw new RuntimeException("Navigation to Leaves failed!", e);
         }
	}
	  // Methods to count Pending, Approved, and Rejected
   public void clickonallbtn() {
	   WebElement all = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Allbtn, 15);
	   all.click();
	   
   }
   public void pendingbtn() {
	   WebElement pendingbtn = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Pendingbtn, 15);
	   pendingbtn.click();
   }
   public void approvedbtn() {
	   WebElement approvedbtn = WaitUtils.waitForElementPresence(driver, EMPLeaveLocators.Approvedbtn, 50);
	   approvedbtn.click();
   	}
   public void rejectedbtn() {
	   WebElement rejectedbtn = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Rejectedbtn, 15);
	   rejectedbtn.click();
   }
	public int getallleavecounts() {
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int totalDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					totalDays += days;  // or use a double variable if you want decimal sum
				
				}
		}

System.out.println("Total leave days: " + totalDays);
return totalDays;
	}
	public int getpendingleavecount() throws InterruptedException {
		pendingbtn();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int pendingDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					pendingDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("pending leave days: " + pendingDays);
return pendingDays;
		
	}
	public int getapprovedleavecount() throws InterruptedException {
		approvedbtn();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int approvedDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					approvedDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("approved leave days: " + approvedDays);
return approvedDays;
	}
	public int getrejectedleavecount() throws InterruptedException {
		Thread.sleep(2000);
		rejectedbtn();
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int rejectedDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					rejectedDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("rejected leave days: " + rejectedDays);
return rejectedDays;
	}
}
