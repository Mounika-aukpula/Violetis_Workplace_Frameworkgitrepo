package com.violetis.Pages.ManagerDashboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class WeekendholidayPage extends BasePage{

	public WeekendholidayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, ManagerdashboardLocators.yearpicker, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( ManagerdashboardLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(ManagerdashboardLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.yearrangeele, 5);
            rangeText = driver.findElement(ManagerdashboardLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(ManagerdashboardLocators.yearnextbtn).click();
            WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.yearrangeele, 5);
            rangeText = driver.findElement(ManagerdashboardLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(ManagerdashboardLocators.yearOption(targetyear));
        yearElement.click();
    }
	public void clickonholidaybtn() {
		WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.holidaybtn, 20).click();
	}
	public void clickonweekendbtn() {
		WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.weekendbtn, 20).click();
	}
	public List<WebElement> getholidaynames(){
		return WaitUtils.waitForElementsPresent(
	            driver,
	            ManagerdashboardLocators.holidaysnames,
	            20
	    );
		
	}
	public List<WebElement> getholidaydates(){
		return WaitUtils.waitForElementsPresent(
	            driver,
	            ManagerdashboardLocators.holidaysnames,
	            20
	    );
	}
	public Map<String, String> getHolidayNameDateMap() {

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Map<String, String> holidayMap = new LinkedHashMap<>();

	    List<WebElement> holidayNames =
	            WaitUtils.waitForElementsPresent(
	                    driver,
	                    ManagerdashboardLocators.holidaysnames,
	                    20
	            );

	    List<WebElement> holidayDates =
	            WaitUtils.waitForElementsPresent(
	                    driver,
	                    ManagerdashboardLocators.holidaysdates,
	                    20
	            );

	    int size = Math.min(holidayNames.size(), holidayDates.size());

	    for (int i = 0; i < size; i++) {

	        // ✅ KEY LINE – triggers auto-scroll
	        js.executeScript(
	                "arguments[0].scrollIntoView({block:'center'});",
	                holidayNames.get(i)
	        );

	        // small wait for virtual row to render text
	        try { Thread.sleep(200); } catch (InterruptedException ignored) {}

	        String name = holidayNames.get(i).getText().trim();
	        String date = holidayDates.get(i).getText().trim();

	        if (!name.isEmpty() && !date.isEmpty()) {
	            holidayMap.put(name + "_" + date, date);
	        }
	    }

	    return holidayMap;
	}
	public Map<String, String> normalizeDateMap(
	        Map<String, String> inputMap,
	        String inputDateFormat,
	        String outputDateFormat) {

	    Map<String, String> normalizedMap = new LinkedHashMap<>();

	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputDateFormat);
	    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputDateFormat);

	    for (Map.Entry<String, String> entry : inputMap.entrySet()) {
	        try {
	            String rawDate = entry.getValue().trim();

	            // Parse input date
	            LocalDate parsedDate = LocalDate.parse(rawDate, inputFormatter);

	            // Format to required output
	            String normalizedDate = parsedDate.format(outputFormatter);

	            // Keep same key, normalize value
	            normalizedMap.put(entry.getKey(), normalizedDate);

	        } catch (DateTimeParseException e) {
	            System.err.println("Date parse failed for: " + entry.getValue());
	        }
	    }
	    return normalizedMap;
	}
	
}

