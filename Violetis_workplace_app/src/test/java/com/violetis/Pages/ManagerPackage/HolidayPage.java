package com.violetis.Pages.ManagerPackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.HolidaysLocators;
import com.violetis.Utilities.WaitUtils;

public class HolidayPage extends BasePage{

	public HolidayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonself() {
		 WaitUtils.waitForElementVisible(driver, HolidaysLocators.selfbtn, 20);
		
	}
public void navigatetoholidays() throws InterruptedException {
	
	 WaitUtils.waitForElementVisible(driver, HolidaysLocators.holidaysbtn, 20);
}
public void clickonholidaytab() {
	 WaitUtils.waitForElementVisible(driver, HolidaysLocators.holidaytab, 20);
}
public void selectyear(String targetyear) {
	WaitUtils.waitForElementPresence(driver, HolidaysLocators.yearpicker, 30).click();
	 // Wait until year picker visible
    WaitUtils.waitForElementVisible(driver, HolidaysLocators.yearrangeele, 10); 
    String rangeText = driver.findElement( HolidaysLocators.yearrangeele).getText().trim();
    int startYear = Integer.parseInt(rangeText.split("-")[0]);
    int endYear = Integer.parseInt(rangeText.split("-")[1]);
    int Year = Integer.parseInt(targetyear);
    // Navigate decades if needed
    while (Year < startYear) {
        driver.findElement(HolidaysLocators.yearprevbtn).click();
        WaitUtils.waitForElementVisible(driver, HolidaysLocators.yearrangeele, 5);
        rangeText = driver.findElement(HolidaysLocators.yearrangeele).getText().trim();
        startYear = Integer.parseInt(rangeText.split("-")[0]);
        endYear = Integer.parseInt(rangeText.split("-")[1]);
    }
    while (Year > endYear) {
        driver.findElement(HolidaysLocators.yearnextbtn).click();
        WaitUtils.waitForElementVisible(driver, HolidaysLocators.yearrangeele, 5);
        rangeText = driver.findElement(HolidaysLocators.yearrangeele).getText().trim();
        startYear = Integer.parseInt(rangeText.split("-")[0]);
        endYear = Integer.parseInt(rangeText.split("-")[1]);
    }

    // Click desired year
    WebElement yearElement = driver.findElement(HolidaysLocators.yearOption(targetyear));
    yearElement.click();
}

public List<WebElement> getholidaynames(){
	List<WebElement> names= WaitUtils.waitForElementsVisible(driver, HolidaysLocators.holidaynames, 20);
	return names;
	
}
public List<WebElement> getholidaydates(){
	List<WebElement> dates= WaitUtils.waitForElementsVisible(driver, HolidaysLocators.holidaydates, 20);
	return dates;
	
}
public Map<String, String> getHolidayNameDateMap() {

    List<WebElement> holidayNames =
            WaitUtils.waitForElementsVisible(driver, HolidaysLocators.holidaydates, 20);

    List<WebElement> holidayDates =
            WaitUtils.waitForElementsVisible(driver, HolidaysLocators.holidaydates, 20);

    Map<String, String> holidayMap = new LinkedHashMap<>();

    int size = Math.min(holidayNames.size(), holidayDates.size());

    for (int i = 0; i < size; i++) {
        String name = holidayNames.get(i).getText().trim();
        String date = holidayDates.get(i).getText().trim();
        holidayMap.put(name, date);
    }

    return holidayMap;
}
public void clickonpagination() {
	WaitUtils.waitForElementPresence(driver, HolidaysLocators.pageforwardbtn, 30).click();
}

}
