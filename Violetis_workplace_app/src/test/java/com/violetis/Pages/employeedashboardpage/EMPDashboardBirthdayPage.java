package com.violetis.Pages.employeedashboardpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPDashboardBirthdayPage extends BasePage {

	public EMPDashboardBirthdayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickondatepicker() {
		WaitUtils.waitForElementVisible(driver,Empdashboardlocators.bdaydatepicker , 30).click();
	}

	public void enterdateonbdaydatepicker(String month, String year, String date) {
	    // Convert month name (e.g. "Oct") to number (10)
	    Map<String, Integer> monthMap = new HashMap<>();
	    monthMap.put("Jan", 1); monthMap.put("Feb", 2); monthMap.put("Mar", 3);
	    monthMap.put("Apr", 4); monthMap.put("May", 5); monthMap.put("Jun", 6);
	    monthMap.put("Jul", 7); monthMap.put("Aug", 8); monthMap.put("Sep", 9);
	    monthMap.put("Oct", 10); monthMap.put("Nov", 11); monthMap.put("Dec", 12);

	    int targetMonth = monthMap.get(month);
	    int targetYear = Integer.parseInt(year);

	    while (true) {
	        WebElement currentMonthEl = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdmonthele, 30);
	        String currentMonthText = currentMonthEl.getText().trim();

	        WebElement currentYearEl = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdyearele, 30);
	        String currentYearText = currentYearEl.getText().trim();

	        int currentMonth = monthMap.get(currentMonthText);
	        int currentYear = Integer.parseInt(currentYearText);

	        // Print for debugging
	        System.out.println("Current Month-Year: " + currentMonthText + "-" + currentYear);
	        System.out.println("Target Month-Year: " + month + "-" + year);

	        // Stop if we reached desired month and year
	        if (currentMonth == targetMonth && currentYear == targetYear) {
	            break;
	        }

	        // Determine whether to go forward or backward
	        if ((currentYear < targetYear) || (currentYear == targetYear && currentMonth < targetMonth)) {
	            // Need to go forward
	            WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdaymonthforwardbtn, 30).click();
	        } else {
	            // Need to go backward
	            WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdaymonthprevbtn, 30).click();
	        }
	    }

	    // Select the date
	    List<WebElement> alldates = WaitUtils.waitForElementsVisible(driver, ManagerLocators.alldates, 30);
	    for (WebElement dt : alldates) {
	        if (dt.getText().equals(date)) {
	            dt.click();
	            break;
	        }
	    }
	}
	public String selectUser(String userName) throws InterruptedException {
	    WebElement dropdown = WaitUtils.waitForElementClickable(driver, Empdashboardlocators.selectuserdrpdwnbtn, 30);
	    dropdown.click();
	    dropdown.sendKeys(userName);
	    Thread.sleep(1000); // give UI time to auto-populate
	    dropdown.sendKeys(Keys.ENTER); // select top option
		return userName;
	}
	public void enterdateondatepicker(String month,String year,String date) {
		clickondatepicker();
		enterdateonbdaydatepicker(month,year,date);
		
	}
	 public boolean areBirthdaysDisplayed() throws InterruptedException {
		 	Thread.sleep(2000);
	        List<WebElement> birthdayCards = WaitUtils.waitForElementsPresence(driver, Empdashboardlocators.bdayrows, 40);

			if (birthdayCards.isEmpty()) {
			    log.info("No birthday cards found.");
			    return false;
			}

			log.info("Total birthdays found: {}", birthdayCards.size());
			scrollToElement(Empdashboardlocators.bdayrows);

			return true;
	    }
	 public String getselectedbdayusername() {
			WebElement TextElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdayusernameeles,10);
			String selectedusername=TextElement.getText();
			return selectedusername;
		   
		}
	 public void clearusernameafterentering() {
		 WaitUtils.waitForElementVisible(driver, Empdashboardlocators.selectuserdrpdwnbtn,30).clear();
	 }
	 public void cleardatetimedropdownclear() {
		 WaitUtils.waitForElementVisible(driver, Empdashboardlocators.bdaydatepicker,30).clear();
	 }
	  public boolean isNoBirthdayMessageDisplayed() {
	        return !driver.findElements(Empdashboardlocators.nobdaymsgele).isEmpty();
	    }
	  public void getentereddatefromdatapicker() {
		  List<WebElement> dates=WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.bdayuserdateles,30);
		  for(WebElement date:dates) {
			 String act_date=date.getText();
		  }
		
		
	  }
}
