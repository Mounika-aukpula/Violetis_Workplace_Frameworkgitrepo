package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EmpHolidayLocators;
import com.violetis.Utilities.WaitUtils;

public class EmpHolidayPage extends BasePage {

	public EmpHolidayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonholidaysmenu() {
		WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.holidaymenu, 30).click();
	}
	public void clickondownloadcalenderbtn() {
		WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.hldcalenderdownloadbtn, 30).click();
	}
	public void selectmonth(String month) {
		WebElement monthinput=WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.monthdrpdwnbtn, 30);
		 try {
		        // If input is editable
			 monthinput.clear();
			 monthinput.sendKeys(month);
			 monthinput.sendKeys(Keys.ENTER);
		    } catch (Exception e) {
		        // If input is read-only, select option from dropdown list
		        WebElement option = WaitUtils.waitForElementVisible(driver, 
		            By.xpath("//div[contains(@class,'ant-select-item-option') and @title='" + month + "']"), 10);
		        option.click();
		    }
	}

	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.yeardrpdwnbtn, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EmpHolidayLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( EmpHolidayLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EmpHolidayLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EmpHolidayLocators.yearrangeele, 5);
            rangeText = driver.findElement(EmpHolidayLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EmpHolidayLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EmpHolidayLocators.yearrangeele, 5);
            rangeText = driver.findElement(EmpHolidayLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EmpHolidayLocators.yearOption(targetyear));
        yearElement.click();
    }

    
	public void clickalltabs() {
		WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.all_tab_btn, 30).click();
		
	}
	public void clickHolidayTab() {
		WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.hldy_tab_btn, 30).click();
    }

    public void clickWeekendTab() {
    	WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.weekend_tab_btn, 30).click();
    }
    public List<WebElement> getHolidayNames() {
    	
        return driver.findElements(EmpHolidayLocators.hldynamecellss);
    }
    public List<WebElement> getHolidayDates() {
        return driver.findElements(EmpHolidayLocators.hldydatecells);
    }
    public boolean isHolidayListPresent() {
        return driver.findElements(EmpHolidayLocators.holidaysrows).size() > 0;
    }
    public boolean isNoDataDisplayed() {
        return driver.findElements(EmpHolidayLocators.nodatamsgele).size() > 0;
    }
    public void searchHoliday(String holidayname) {
    	WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.searchhldybtn, 30).sendKeys(holidayname);
    }
    
}
