package com.violetis.Pages.employeePage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.violetis.Base.BasePage;

import com.violetis.Locators.EmpPageLocators.EMPAttendencesummaryLocators;

import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class AttendencesummaryPage extends BasePage{

	public AttendencesummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigaettoattendencesummarypage() {
		 try {
             // Wait for main menu
             WebElement Attendence_Menu = WaitUtils.waitForElementVisible(driver, EMPAttendencesummaryLocators.Attendencemenu, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Attendence  menu.");
             actions.moveToElement(Attendence_Menu).click().perform();
             
          // Wait for submenu
             WebElement Attendencesummary_Menu = WaitUtils.waitForElementVisible(driver, EMPAttendencesummaryLocators.Attendencesummarymenu, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(Attendencesummary_Menu);
             WaitUtils.waitForElementClickable(driver, EMPAttendencesummaryLocators.Attendencesummarymenu, 50);
             try {
            	 Attendencesummary_Menu.click();
                 log.info("Clicked on Attendencesummary_Menu using standard click.");
             } catch (Exception clickEx) {
                 log.warn("Standard click failed on  Attendencesummary_Menu. Trying JS click...");
                 jsUtil.clickElementByJS(Attendencesummary_Menu);
                 log.info("Clicked on Attendence summary menu  using JS click.");
             }
             
             log.info("Clicked on the Attendence summary menu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Attendence menu.", e);
             throw new RuntimeException("Navigation to Attendence failed!", e);
         }
	}
	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, EMPAttendencesummaryLocators.yeardropdown, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EMPAttendencesummaryLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( EMPAttendencesummaryLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EMPAttendencesummaryLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPAttendencesummaryLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPAttendencesummaryLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EMPAttendencesummaryLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPAttendencesummaryLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPAttendencesummaryLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EMPAttendencesummaryLocators.yearOption(targetyear));
        yearElement.click();
    }

	  public void selectMonth(String monthName) throws InterruptedException {
		    // 1️⃣ Click dropdown to open it
		    WebElement dropdown = WaitUtils.waitForElementClickable(driver,
		    		EMPAttendencesummaryLocators.monthdropdown, 10);
		    dropdown.click();

		    // 2️⃣ Locate visible dropdown panel
		    WebElement dropdownPanel = WaitUtils.waitForElementPresence(driver,EMPAttendencesummaryLocators.monthdrpoptions, 10);

		    // 🟢 ADD THIS LINE — find the actual scrollable list holder
		   // WebElement scrollableList = WaitUtils.waitForElementPresence(driver,EMPAttendencesummaryLocators.monthdrpscrollbar, 10);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    boolean found = false;

		    // Step 3️⃣: Scroll and search for the desired month
		    for (int i = 0; i < 15; i++) {
		        List<WebElement> options = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));

		        for (WebElement option : options) {
		            String text = option.getText().trim();
		            if (text.equalsIgnoreCase(monthName)) {
		                option.click(); // ✅ Select month
		                found = true;
		                break;
		            }
		        }

		        if (found) break;

		        // Scroll down to load more items
		       // js.executeScript("arguments[0].scrollTop += 300;", scrollableList);
		        Thread.sleep(400); // allow lazy load to render new items
		    }

		    if (!found) {
		        throw new RuntimeException("Month '" + monthName + "' not found even after scrolling!");
		    }

		    // Step 4️⃣: Verify month was selected
		    WebElement selectedMonthEle = WaitUtils.waitForElementVisible(driver,
		        By.xpath("//span[contains(@class,'ant-select-selection-item')]"), 10);

		    String selectedMonth = selectedMonthEle.getText().trim();
		    Assert.assertEquals(selectedMonth, monthName, "❌ Month selection verification failed!");

		    System.out.println("✅ Successfully selected and verified month: " + selectedMonth);
		}
	  // ================================
	    //  GET ALL DATES FROM HEADER
	    // ================================
	    public List<String> getAllDates() {

	        List<WebElement> dateHeaders =
	                driver.findElements(By.xpath("//table//thead//th[position() > 1]"));

	        List<String> dates = new ArrayList<>();

	        for (WebElement header : dateHeaders) {
	            dates.add(header.getText().trim());
	        }

	        return dates;
	    }

	    // ================================
	    //   GET STATUS FOR EACH DATE
	    // ================================
	    public Map<String, String> getDateStatusMap() {

	        // 1️⃣ Get all header dates
	        List<String> dates = getAllDates();

	        // 2️⃣ Read entire first row (employee attendance summary row)
	        WebElement firstRow = driver.findElement(By.xpath("//table//tbody//tr[1]"));

	        Map<String, String> dateStatusMap = new LinkedHashMap<>();

	        for (int i = 0; i < dates.size(); i++) {

	            int columnIndex = i + 2; // since date starts at TH[2]

	            String cellXpath = ".//td[" + columnIndex + "]/span";
	            WebElement span = firstRow.findElement(By.xpath(cellXpath));

	            String classValue = span.getAttribute("class");

	            String status = deriveStatusFromClass(classValue);

	            dateStatusMap.put(dates.get(i), status);
	        }

	        return dateStatusMap;
	    }

	    // ================================
	    //  STATUS DECODER LOGIC
	    // ================================
	    private String deriveStatusFromClass(String classValue) {

	        if (classValue.contains("anticon-close")) return "Absent";
	        if (classValue.contains("anticon-calendar")) return "Holiday";
	        if (classValue.contains("anticon-car")) return "On Leave";
	        if (classValue.contains("anticon-check")) return "Present";

	        return "Unknown";
	    }
	    //navigate back to dsahboard for validating summary with details
	    public void gobacktodashboard() {
	    	WaitUtils.waitForElementClickable(driver,
		    		EMPAttendencesummaryLocators.dashboardlink, 10).click();
	    }
	}

