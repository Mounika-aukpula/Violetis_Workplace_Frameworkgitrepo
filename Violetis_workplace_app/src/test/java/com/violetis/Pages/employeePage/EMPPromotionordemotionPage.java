package com.violetis.Pages.employeePage;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EMPPrePaymentLocators;
import com.violetis.Locators.EmpPageLocators.PromotionordemotaionLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPPromotionordemotionPage extends BasePage {

	public EMPPromotionordemotionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoincordecmodule() {
		try {
            // Wait for main menu
            WebElement mainMenu = WaitUtils.waitForElementVisible(driver,PromotionordemotaionLocators.payrollbtn, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the main menu.");
            actions.moveToElement(mainMenu).click().perform();

            // Wait for submenu
            WebElement subMenu = WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.Submenu_incordec, 15);
            actions.moveToElement(subMenu).click().perform();
            
            log.info("Clicked on the increament or promotion submenu.");

        } catch (Exception e) {
            log.error("Failed to navigate to payroll.", e);
            throw new RuntimeException("Navigation to payroll failed!", e);
        }
	}
	//****** year picker action methods
	  public void selectyear(String targetyear) {
			WaitUtils.waitForElementPresence(driver, PromotionordemotaionLocators.yeardrpdwnbtn, 30).click();
			 // Wait until year picker visible
	        WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.yearrangeele, 10); 
	        String rangeText = driver.findElement( PromotionordemotaionLocators.yearrangeele).getText().trim();
	        int startYear = Integer.parseInt(rangeText.split("-")[0]);
	        int endYear = Integer.parseInt(rangeText.split("-")[1]);
	        int Year = Integer.parseInt(targetyear);
	        
	        // Navigate decades if needed
	        while (Year < startYear) {
	            driver.findElement(PromotionordemotaionLocators.yearprevbtn).click();
	            WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.yearrangeele, 5);
	            rangeText = driver.findElement(PromotionordemotaionLocators.yearrangeele).getText().trim();
	            startYear = Integer.parseInt(rangeText.split("-")[0]);
	            endYear = Integer.parseInt(rangeText.split("-")[1]);
	        }
	        while (Year > endYear) {
	            driver.findElement(PromotionordemotaionLocators.yearfrnwdbtn).click();
	            WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.yearrangeele, 5);
	            rangeText = driver.findElement(PromotionordemotaionLocators.yearrangeele).getText().trim();
	            startYear = Integer.parseInt(rangeText.split("-")[0]);
	            endYear = Integer.parseInt(rangeText.split("-")[1]);
	        }

	        // Click desired year
	        WebElement yearElement = driver.findElement(PromotionordemotaionLocators.yearOption(targetyear));
	        yearElement.click();
	    }
	  public int monthNameToNumber(String monthName) {
		    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
		    Month m = Month.from(fmt.parse(monthName));
		    return m.getValue(); // August → 8
		}
	  public List<WebElement> getDateColumnValues() {
		  List<WebElement> datecols=WaitUtils.waitForElementsVisible(driver,PromotionordemotaionLocators.datecolsinallrows,20);  // Assuming Date is in first column
		return datecols;
		}
	  //*****month dropdown page methods
	  public void selectmonthFilter(String month) {
			 WaitUtils.waitForElementClickable(driver,PromotionordemotaionLocators.monthdropdown , 30).click();
			// Wait for all options to appear
		        WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.monthoptions, 20);
		        
		        List<WebElement> options = driver.findElements(PromotionordemotaionLocators.monthoptions);
		        for (WebElement option : options) {
		            if (option.getText().equals(month)) {
		                option.click();
		                log.info("Selected user: " + month);
		                break;
		            }
		        }
		    }
	  public void clickonalltab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.alltabbtn, 20).click();
	  }
	  public void clickonincreamenttab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.increamenttab, 20).click();
	  }
	  public void clickonpromotiontab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.promotiontab, 20).click();
	  }
	  public void clickonincorpromotiontab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.incorpromotiontab, 20).click();
	  }
	  public void clickondecreamenttab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.decreamnettab, 20).click();
	  }
	  public void clickondecreamentordemotiontab() {
		  WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.decordemotiontab, 20).click();
	  }
	  //nodataele action method
	  public boolean isNoDataDisplayed() {
	        return WaitUtils.waitForElementVisible(driver, PromotionordemotaionLocators.nodataele, 10).isDisplayed();
	    }
	  public int getrowCount() {
	        List<WebElement> rows = driver.findElements(PromotionordemotaionLocators.allrows);
	        return rows.size();
	    }
	  // Get all row text from current tab
	  public List<String> getRowDataFromCurrentTab() {
	        List<WebElement> rows = WaitUtils.waitForElementsVisible(driver, PromotionordemotaionLocators.allrows, 10);
	        List<String> rowTextList = new ArrayList<>();

	        for (WebElement row : rows) {
	            rowTextList.add(row.getText().trim());
	        }
	        return rowTextList;
	    }
	  // Tab-specific fetchers
	  public List<String> getAllTabRows() throws InterruptedException {
		    
		  clickonalltab();
		  List<String> allTexts = new ArrayList<>();

		    while (true) {

		        // Always re-locate fresh rows — do NOT store earlier reference
		        List<WebElement> rows = driver.findElements(PromotionordemotaionLocators.allrows);

		        int beforeSize = allTexts.size();

		        for (WebElement row : rows) {
		            try {
		                allTexts.add(row.getText());
		            } catch (StaleElementReferenceException e) {
		                // re-fetch the element and retry
		                WebElement fresh = driver.findElement(PromotionordemotaionLocators.singleRow(row));
		                allTexts.add(fresh.getText());
		            }
		        }

		        // Scroll to last row to load more
		        WebElement lastRow = rows.get(rows.size() - 1);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastRow);

		        Thread.sleep(700);

		        // After scroll, check if new rows appeared
		        List<WebElement> newRows = driver.findElements(PromotionordemotaionLocators.allrows);

		        if (newRows.size() == rows.size()) {
		            break; // no more rows to load
		        }
		    }

		    return allTexts;
		    }

	    public List<String> getIncrementRows() {
	    	clickonincreamenttab();
	        return getRowDataFromCurrentTab();
	    }

	    public List<String> getPromotionRows() {
	    	clickonpromotiontab();
	        return getRowDataFromCurrentTab();
	    }

	    public List<String> getIncPromotionRows() {
	    	clickonincorpromotiontab();
	        return getRowDataFromCurrentTab();
	    }

	    public List<String> getDecrementRows() {
	    	clickondecreamenttab();
	        return getRowDataFromCurrentTab();
	    }

	    public List<String> getDecdemotionRows() {
	    	clickondecreamentordemotiontab();
	        return getRowDataFromCurrentTab();
	    }
	    
	    // Get all year values from date column
	    public List<String> getAllYearsFromDateColumn() {
	        List<WebElement> dateCells = driver.findElements(PromotionordemotaionLocators.datecolsinallrows);
	        List<String> years = new ArrayList<>();

	        for (WebElement cell : dateCells) {
	            String fullDate = cell.getText().trim();  // e.g. 01-12-2025

	            if (fullDate.length() >= 4) {
	                // Extract last 4 digits → Year
	                String year = fullDate.substring(6, 10); 
	                years.add(year);
	            }
	        }
	        return years;
	    }
	 // Verify all rows contain expected year
	    public boolean verifyAllRowsYear(String expectedYear) {
	        List<String> years = getAllYearsFromDateColumn();

	        for (String year : years) {
	            if (!year.equals(expectedYear)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public void loadAllRows() throws InterruptedException {
	        long lastHeight = (long) ((JavascriptExecutor) driver)
	                .executeScript("return document.body.scrollHeight");

	        while (true) {
	            scrollToBottom();  // <<< From BasePage
	            Thread.sleep(1200);

	            long newHeight = (long) ((JavascriptExecutor) driver)
	                    .executeScript("return document.body.scrollHeight");

	            if (newHeight == lastHeight) {
	                break;  // No more content loading
	            }
	            lastHeight = newHeight;
	        }
	    }
	   
}
