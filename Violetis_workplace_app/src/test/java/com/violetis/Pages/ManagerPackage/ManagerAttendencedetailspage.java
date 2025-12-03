package com.violetis.Pages.ManagerPackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerAttendencedetailsLocators;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class ManagerAttendencedetailspage extends BasePage{

	public ManagerAttendencedetailspage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void naviagettoattendencedetailspage() {
		 try {
             // Wait for main menu
             WebElement Attendence_Menu = WaitUtils.waitForElementVisible(driver, ManagerAttendencedetailsLocators.Attendencemainmoudle, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Attendence  menu.");
             actions.moveToElement(Attendence_Menu).click().perform();
             
          // Wait for submenu
             WebElement Attendencedetails_Menu = WaitUtils.waitForElementVisible(driver, ManagerAttendencedetailsLocators.Attendencedetails_submodule, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(Attendencedetails_Menu);
             WaitUtils.waitForElementClickable(driver, ManagerAttendencedetailsLocators.Attendencedetails_submodule, 50);
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
		 public void selectectemployee(String empname) {
			 // Click the input to open dropdown
		        WaitUtils.waitForElementVisible(driver,ManagerAttendencedetailsLocators.selectemployeedropdown , 10).click();

		        // Wait for all options to appear
		        WaitUtils.waitForElementVisible(driver, ManagerAttendencedetailsLocators.selectdrpdownoptions, 5);

		        // Get all options dynamically
		        List<WebElement> options = driver.findElements(ManagerAttendencedetailsLocators.selectdrpdownoptions);
		        for (WebElement option : options) {
		            if (option.getText().equals(empname)) {
		                option.click();
		                log.info("Selected user: " + empname);
		                break;
		            }
		        }
		 }
	
		 public List<Map<String, String>> fetchAttendanceTableData() {
		        List<Map<String, String>> attendanceData = new ArrayList<>();
		        List<WebElement> rows = driver.findElements(ManagerAttendencedetailsLocators.Attendence_details_rows);

		        for (int i = 0; i < rows.size(); i++) {
		            WebElement row = rows.get(i);
		            Map<String, String> rowData = new LinkedHashMap<>();

		            try {
		                String date = getTextSafe(row, ManagerAttendencedetailsLocators.DATE_COL);
		                String status = getTextSafe(row, ManagerAttendencedetailsLocators.STATUS_COL);
		                String clockIn = getTextSafe(row, ManagerAttendencedetailsLocators.CLOCKIN_COL);
		                String clockOut = getTextSafe(row, ManagerAttendencedetailsLocators.CLOCKOUT_COL);
		                String clockedTime = getTextSafe(row, ManagerAttendencedetailsLocators.CLOCKEDTIME_COL);
		               // String otherDetails = getTextSafe(row, ManagerAttendencedetailsLocators.OTHERDETAILS_COL);

		                rowData.put("Date", date);
		                rowData.put("Status", status);
		                rowData.put("ClockIn", clockIn);
		                rowData.put("ClockOut", clockOut);
		                rowData.put("ClockedTime", clockedTime);
		                //rowData.put("OtherDetails", otherDetails);

		                attendanceData.add(rowData);

		            } catch (Exception e) {
		                System.out.println("⚠️ Error reading manager row " + (i + 1) + ": " + e.getMessage());
		            }
		        }

		        System.out.println("✅ Fetched " + attendanceData.size() + " rows from Manager module.");
		        return attendanceData;
		    }

		    /**
		     * Safe text fetch with fallback "--" if not found or empty.
		     */
		    private String getTextSafe(WebElement parent, By locator) {
		        try {
		            WebElement element = parent.findElement(locator);
		            String text = element.getText().trim();
		            return text.isEmpty() ? "--" : text;
		        } catch (NoSuchElementException e) {
		            return "--";
		        }
		    }
}
