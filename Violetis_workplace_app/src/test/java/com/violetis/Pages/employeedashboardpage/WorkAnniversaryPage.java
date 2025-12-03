package com.violetis.Pages.employeedashboardpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Utilities.WaitUtils;
import com.violetis.Locators.Empdashboardlocators;

public class WorkAnniversaryPage extends BasePage {

	public WorkAnniversaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/** Verify if anniversaries are displayed */
    public boolean areAnniversariesDisplayed() {
        List<WebElement> elements = WaitUtils.waitForElementsVisible(driver,Empdashboardlocators.upcoming_ann_users, 10);
        return !elements.isEmpty();
    }
    /** Filter anniversaries by specific user name 
     *  */
    public String filterByUser(String userName) throws InterruptedException {
    	WebElement dropdown= WaitUtils.waitForElementClickable(driver, Empdashboardlocators.wokannseluserdrpdwn, 30);
        dropdown.click();
        dropdown.sendKeys(userName);
	    Thread.sleep(1000); // give UI time to auto-populate
	    dropdown.sendKeys(Keys.ENTER); // select top option
		return userName;
        
    }
    public void filterBydatepicker(String month,String year,String date) {
    	enterdateonbdaydatepicker(month,year,date);
    	
    }
    public void clickondatepicker() {
    	WaitUtils.waitForElementClickable(driver, Empdashboardlocators.workanniversarydatepicker, 30).click();
    }
    public void enterdateonbdaydatepicker(String month, String year, String date) {
	    // Convert month name (e.g. "Oct") to number (10)
    	clickondatepicker();
	    Map<String, Integer> monthMap = new HashMap<>();
	    monthMap.put("Jan", 1); monthMap.put("Feb", 2); monthMap.put("Mar", 3);
	    monthMap.put("Apr", 4); monthMap.put("May", 5); monthMap.put("Jun", 6);
	    monthMap.put("Jul", 7); monthMap.put("Aug", 8); monthMap.put("Sep", 9);
	    monthMap.put("Oct", 10); monthMap.put("Nov", 11); monthMap.put("Dec", 12);

	    int targetMonth = monthMap.get(month);
	    int targetYear = Integer.parseInt(year);

	    while (true) {
	        WebElement currentMonthEl = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.workannmonth_ele, 30);
	        String currentMonthText = currentMonthEl.getText().trim();

	        WebElement currentYearEl = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.workannyearele, 30);
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
	            WaitUtils.waitForElementVisible(driver, Empdashboardlocators.workannmonthfrwdbtn, 30).click();
	        } else {
	            // Need to go backward
	            WaitUtils.waitForElementVisible(driver, Empdashboardlocators.wokann_month_prev, 30).click();
	        }
	    }
    }
    /** Get all displayed anniversary dates after filtering */
    public List<WebElement> getDisplayedAnniversaryDates() {
    	List<WebElement> elements = WaitUtils.waitForElementsVisible(driver,Empdashboardlocators.upcoming_ann_dates, 20);
		return elements;
    }
    /** Get displayed user names after entering uname in slecetuserdropdown on anniversary cards */
    public List<WebElement> getDisplayedUserNames() {
    	List<WebElement> elements = WaitUtils.waitForElementsVisible(driver,Empdashboardlocators.upcoming_ann_username, 20);
		return elements;
    }
    /** Verify milestone badges */
    public boolean isMilestoneBadgeDisplayed() {
        List<WebElement> badges = WaitUtils.waitForElementsVisible(driver,Empdashboardlocators.badege_eles , 10);
        return !badges.isEmpty();
    }
}
