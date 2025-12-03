package com.violetis.Pages.employeedashboardpage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Base.BasePage;
import com.violetis.Utilities.WaitUtils;

public class WeekendandholidayPage extends BasePage{

	public WeekendandholidayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/** Click Holiday tab */
    public void clickHolidayTab() {
        WaitUtils.waitForElementClickable(driver,Empdashboardlocators.hldbtn , 20).click();
    }
    /** Click Weekend tab */
    public void clickWeekendTab() {
        WaitUtils.waitForElementClickable(driver,Empdashboardlocators.weekendbtn, 20).click();
    }
    

    /** Get message text when no holidays */
    public String getNoHolidayMessage() {
        return WaitUtils.waitForElementVisible(driver, Empdashboardlocators.nohldmsgele, 10).getText().trim();
    }
    public void clickyearpicker() {
    	WaitUtils.waitForElementClickable(driver,Empdashboardlocators.hlddatepicker, 20).click();
    }
    public void selectYearFromPicker(int Targetyear) {
        int maxAttempts = 12; // Safety limit
        boolean clicked = false;

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            // Get current visible range (e.g., "2020-2029")
            WebElement rangeElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.yearrangeeleinpicker, 20);
            String rangeText = rangeElement.getText().trim();

            String[] parts = rangeText.split("-");
            int startYear = Integer.parseInt(parts[0].trim());
            int endYear = Integer.parseInt(parts[1].trim());

            System.out.println("📅 Visible range: " + startYear + "-" + endYear);

            if (Targetyear < startYear) {
                // Click previous decade
                WaitUtils.waitForElementClickable(driver, Empdashboardlocators.prevbtninpicker, 20).click();
                WaitUtils.waitForElementVisible(driver, Empdashboardlocators.allyearelesinpicker, 20);
            } 
            else if (Targetyear > endYear) {
                // Click next decade
                WaitUtils.waitForElementClickable(driver, Empdashboardlocators.nextbutninpicker, 20).click();
                WaitUtils.waitForElementVisible(driver, Empdashboardlocators.allyearelesinpicker, 20);
            } 
            else {
                // Target year is visible — click it
                List<WebElement> years = driver.findElements(Empdashboardlocators.allyearelesinpicker);
                for (WebElement year : years) {
                    String yearText = year.getText().trim();
                    if (yearText.equals(String.valueOf(Targetyear))) {
                        WaitUtils.waitForElementClickablewebelement(driver, year,20).click();
                        clicked = true;
                        break;
                    }
                }
                break; // break outer loop after attempting click
            }
        }

        if (!clicked) {
            throw new NoSuchElementException("Year " + Targetyear + " not found in visible grid!");
        }
    }
    public List<String> getAllHolidayNames() {
        // Wait until at least one holiday name is visible and non-empty
        WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.holidaynames, 30);

        // Fetch all matching elements
        List<WebElement> nameElements = driver.findElements(Empdashboardlocators.holidaynames);
        List<String> holidayNames = new ArrayList<>();

        // Extract and trim text from each element
        for (WebElement ele : nameElements) {
            String text = ele.getText().trim();
            if (!text.isEmpty()) {
                holidayNames.add(text);
            }
        }

        return holidayNames;
    }
    public List<String> getAllHolidayDates(){
    	// Wait until at least one holiday name is visible and non-empty
        WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.holidaydates, 30);

        // Fetch all matching elements
        List<WebElement> nameElements = driver.findElements(Empdashboardlocators.holidaydates);
        List<String> holidaydates = new ArrayList<>();

        // Extract and trim text from each element
        for (WebElement ele : nameElements) {
            String text = ele.getText().trim();
            if (!text.isEmpty()) {
            	holidaydates.add(text);
            }
        }

        return holidaydates;
    }
    public List<String> getAllweekendDates(){
    	WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.weekenddateseles, 30);
    	List<WebElement> nameElements = driver.findElements(Empdashboardlocators.weekenddateseles);
        List<String> weekenddates = new ArrayList<>();

        // Extract and trim text from each element
        for (WebElement ele : nameElements) {
            String text = ele.getText().trim();
            if (!text.isEmpty()) {
            	weekenddates.add(text);
            }
        }

        return weekenddates;
    }
    }

