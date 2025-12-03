package com.violetis.Locators.EmpPageLocators;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EMPLetterHeadsLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPLetterHeadsPage extends BasePage {

	public EMPLetterHeadsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, EMPLetterHeadsLocators.yeardrpdown, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EMPLetterHeadsLocators.yearrangeele, 20); 
        String rangeText = driver.findElement( EMPLetterHeadsLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EMPLetterHeadsLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPLetterHeadsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPLetterHeadsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EMPLetterHeadsLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPLetterHeadsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPLetterHeadsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EMPOFFboardingWarningsLocators.yearOption(targetyear));
        yearElement.click();
    }
	public int getRowCount() {
        return WaitUtils.waitForElementsVisible(driver, EMPLetterHeadsLocators.tablerows, 30).size();
    }
	public boolean isNoDataDisplayed() {
        return driver.findElements(EMPLetterHeadsLocators.nodataele).size() > 0;
    }
	public void downloadFirstLetterhead() {
        driver.findElement(EMPLetterHeadsLocators.firstrowdwnldbtn).click();
    }
	 public void changePagination(String size) {
	        new Select(driver.findElement(EMPLetterHeadsLocators.paginationdrpdownoptions)).selectByVisibleText(size);
	    }
	 public void clickNext() {
	        driver.findElement(EMPLetterHeadsLocators.paginationfrwdbtn).click();
	    }
	 public void clickPrev() {
	        driver.findElement(EMPLetterHeadsLocators.paginationprevbtn).click();
	    }
	 public void navigateletterheadpage() {
		 WaitUtils.waitForElementPresence(driver, EMPLetterHeadsLocators.letterhead_btn, 30).click();
	 }
	 //validations for year dropdown
	 public List<String> getAllCreatedYears() {
		    List<String> years = new ArrayList<>();
		    List<WebElement> dates = driver.findElements(EMPLetterHeadsLocators.createddatecols);

		    for (WebElement d : dates) {
		        String date = d.getText().trim();  // 24-11-2025
		        String[] parts = date.split("-"); // [24,11,2025]
		        years.add(parts[2]);
		    }
		    return years;
		}

}
