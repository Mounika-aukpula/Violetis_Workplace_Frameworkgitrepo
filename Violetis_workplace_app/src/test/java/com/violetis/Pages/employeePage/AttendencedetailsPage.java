package com.violetis.Pages.employeePage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EmpAttendencePageLocators;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class AttendencedetailsPage extends BasePage {

	public AttendencedetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAttendencedetails() {
		 try {
             // Wait for main menu
             WebElement Attendence_Menu = WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.Attendencebtn, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Attendence  menu.");
             actions.moveToElement(Attendence_Menu).click().perform();
             
          // Wait for submenu
             WebElement Attendencedetails_Menu = WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.Attendencedetailsbtn, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(Attendencedetails_Menu);
             WaitUtils.waitForElementClickable(driver, EmpAttendencePageLocators.Attendencedetailsbtn, 50);
             try {
            	 Attendencedetails_Menu.click();
                 log.info("Clicked on Attendencedetails_Menu using standard click.");
             } catch (Exception clickEx) {
                 log.warn("Standard click failed on  Attendencedetails_Menu. Trying JS click...");
                 jsUtil.clickElementByJS(Attendencedetails_Menu);
                 log.info("Clicked on Attendence details menu  using JS click.");
             }
             
             log.info("Clicked on the Attendence details menu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Attendence menu.", e);
             throw new RuntimeException("Navigation to Attendence failed!", e);
         }
	}
	public int getLateAttendanceDays(WebElement element) {
	    String text = element.getText(); // e.g. "20 Days (20.09%)"
	    
	    Pattern pattern = Pattern.compile("\\d+"); // matches the first number
	    Matcher matcher = pattern.matcher(text);
	    
	    if (matcher.find()) {
	        return Integer.parseInt(matcher.group()); // returns 20
	    }
	    
	    return 0; // default if no number found
	}
	public void clickonyearpicker() {
		WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.yeardrpdownbtn, 50).click();
		log.info("clicked on yer picker");
	}
	public void enterYearOnYearPicker() throws InterruptedException {
	    int currentYear =LocalDate.now().getYear();
	    System.out.println("Current year = " + currentYear);

	    while (true) {
	        try {
	            // Re-find the visible year range every iteration to avoid stale element
	            WebElement rangeElem = WaitUtils.waitForElementClickable(driver, EmpAttendencePageLocators.yearpickeryearrangeele, 30);
	            String[] years = rangeElem.getText().split("-");
	            int startYear = Integer.parseInt(years[0].trim());
	            int endYear = Integer.parseInt(years[1].trim());

	            // Check if current year is within the visible range
	            if (currentYear >= startYear && currentYear <= endYear) {
	                // Re-find all year elements
	                List<WebElement> yearElements = WaitUtils.waitForElementsVisible(driver, EmpAttendencePageLocators.yearele, 10);

	                boolean yearClicked = false;
	                for (WebElement yearElem : yearElements) {
	                    int year = Integer.parseInt(yearElem.getText().trim());
	                    if (year == currentYear) {
	                        // JS click to avoid stale element issues
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearElem);
	                        yearClicked = true;
	                        break;
	                    }
	                }

	                if (yearClicked) {
	                    
	                    break; // exit while loop once year is clicked
	                }
	            } 
	            else if (currentYear > endYear) {
	                // Click Next
	                driver.findElement(EmpAttendencePageLocators.yearfrwdbtn).click();
	                Thread.sleep(500); // wait for DOM update
	            } 
	            else if (currentYear < startYear) {
	                // Click Previous
	                driver.findElement(EmpAttendencePageLocators.yearbackwardbtn).click();
	                Thread.sleep(500); // wait for DOM update
	            }
	        } catch (StaleElementReferenceException e) {
	            // Retry automatically
	        }
	    }
	    System.out.println("✅ Current year selected successfully: " + currentYear);
	}
	public int getTotalLateLogins() throws InterruptedException {
	    int totalLateDays = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January
	    JavaScriptUtility jsUtil = new JavaScriptUtility(driver);

	    // Open the month dropdown initially
	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        String monthName = Month.of(month).getDisplayName(TextStyle.FULL, Locale.ENGLISH); // "January", "February"

	        // Scrollable container for virtual list
	        WebElement container = driver.findElement(By.cssSelector(".rc-virtual-list-holder"));
	        boolean monthFound = false;
	        int maxScrolls = 10;
	        int scrolls = 0;

	        while (!monthFound && scrolls < maxScrolls) {
	            // Wait for visible month options
	            List<WebElement> months = WaitUtils.waitForElementsVisible(driver, EmpAttendencePageLocators.monthdrpdownbtnoptions, 50);

	            for (WebElement m : months) {
	                if (m.getText().equalsIgnoreCase(monthName)) {
	                    jsUtil.clickElementByJS(m); // Use JavaScriptUtility to click
	                    monthFound = true;
	                    break;
	                }
	            }

	            if (!monthFound) {
	                // Scroll up slightly if month not found
	                jsUtil.scrollUp(50); // Scroll up using JS utility
	                Thread.sleep(200); // wait for DOM to update
	                scrolls++;
	            }
	        }

	        if (!monthFound) {
	            throw new RuntimeException("Month '" + monthName + "' not found after scrolling");
	        }

	        // Wait for table/dashboard to refresh (replace Thread.sleep with explicit wait if possible)
	        Thread.sleep(500);

	        // Capture late login element
	        WebElement lateCountElem = driver.findElement(EmpAttendencePageLocators.lateloginele);

	        // Use your existing method to get days
	        int days = getLateAttendanceDays(lateCountElem);

	        System.out.println(monthName + " → Late login days = " + days);

	        // Add to total sum
	        totalLateDays += days;

	        // Re-open dropdown for next iteration if needed
	        if (month < currentMonth) {
	            driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();
	        }
	    }

	    System.out.println("✅ Total late login days from Jan → Current month = " + totalLateDays);
	    return totalLateDays;
	}

	public int getTotalAttendanceCount() throws InterruptedException {
	    int totalAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update

	        // Get all present icons
	        List<WebElement> presentList = driver.findElements(EmpAttendencePageLocators.presentcheckele);
	        // Get all leave icons
	        List<WebElement> leaveList = driver.findElements(EmpAttendencePageLocators.leavecarele);

	        // Add this month's attendance to total
	        totalAttendance += presentList.size() + leaveList.size();
	    }

	    return totalAttendance;
	}
	public int getpresentdayscount() throws InterruptedException {
		int totalpresentAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update

	        // Get all present icons
	        List<WebElement> presentList = driver.findElements(EmpAttendencePageLocators.presentcheckele);
	        totalpresentAttendance+=presentList.size();
	    }
	    return totalpresentAttendance;
}
	public int getabsentcount() throws InterruptedException {
		int totalabsentAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update
	     // Get all leave icons
	        List<WebElement> leaveList = driver.findElements(EmpAttendencePageLocators.leavecarele);

	        totalabsentAttendance+=leaveList.size();
	}
	    return totalabsentAttendance;
}
}

		

