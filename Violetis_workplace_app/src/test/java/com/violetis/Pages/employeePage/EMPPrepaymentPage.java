package com.violetis.Pages.employeePage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EMPAppreciationsLocators;
import com.violetis.Locators.EmpPageLocators.EMPAssetsLocators;
import com.violetis.Locators.EmpPageLocators.EMPOFFboardingResignationsLocators;
import com.violetis.Locators.EmpPageLocators.EMPPrePaymentLocators;
import com.violetis.Locators.EmpPageLocators.EmpAttendencePageLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPPrepaymentPage extends BasePage{

	public EMPPrepaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoprepayementPage() {
        try {
            // Wait for main menu
            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.payrollbtn, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the main menu.");
            actions.moveToElement(mainMenu).click().perform();

            // Wait for submenu
            WebElement subMenu = WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.sub_menu_prepayementbtn, 15);
            actions.moveToElement(subMenu).click().perform();
            
            log.info("Clicked on the prepayement submenu.");

        } catch (Exception e) {
            log.error("Failed to navigate to payroll.", e);
            throw new RuntimeException("Navigation to payroll failed!", e);
        }
    }
	 public boolean isNoDataDisplayed() {
	        return WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.nodataele, 10).isDisplayed();
	    }
	 public int getrowCount() {
	        List<WebElement> rows = driver.findElements(EMPPrePaymentLocators.allrows);
	        return rows.size();
	    }
	  public void clickActionButton(int index) {
	        List<WebElement> buttons = driver.findElements(EMPPrePaymentLocators.viewactionbts);
	        buttons.get(index).click();
	    }
	  public void selectRow(int index) {
	        List<WebElement> checkboxes = driver.findElements(EMPPrePaymentLocators.ROW_CHECKBOXES);
	        checkboxes.get(index).click();
	        WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.pagebox,20).click();
	    }
	// Get specific row by index (0-based)
	    public WebElement getRow(int index) {
	        List<WebElement> rows = driver.findElements(EMPPrePaymentLocators.allrows);
	        return rows.get(index);
	    }
	  public boolean isRowHighlighted(int index) {
	        WebElement row = getRow(index);
	        WebElement firstCell = row.findElement(By.tagName("td"));
	        String bgColor = firstCell.getCssValue("background-color");

	        // Expected highlight = #b1b9bd → rgb(177,185,189)
	        return bgColor.equals("rgb(177, 185, 189)");
	    }
	  //****** year picker action methods
	  public void selectyear(String targetyear) {
			WaitUtils.waitForElementPresence(driver, EMPPrePaymentLocators.yeardrpdwnbtn, 30).click();
			 // Wait until year picker visible
	        WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.yearrangeele, 10); 
	        String rangeText = driver.findElement( EMPPrePaymentLocators.yearrangeele).getText().trim();
	        int startYear = Integer.parseInt(rangeText.split("-")[0]);
	        int endYear = Integer.parseInt(rangeText.split("-")[1]);
	        int Year = Integer.parseInt(targetyear);
	        
	        // Navigate decades if needed
	        while (Year < startYear) {
	            driver.findElement(EMPPrePaymentLocators.yearprevbtn).click();
	            WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.yearrangeele, 5);
	            rangeText = driver.findElement(EMPPrePaymentLocators.yearrangeele).getText().trim();
	            startYear = Integer.parseInt(rangeText.split("-")[0]);
	            endYear = Integer.parseInt(rangeText.split("-")[1]);
	        }
	        while (Year > endYear) {
	            driver.findElement(EMPPrePaymentLocators.yearfrnwdbtn).click();
	            WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.yearrangeele, 5);
	            rangeText = driver.findElement(EMPPrePaymentLocators.yearrangeele).getText().trim();
	            startYear = Integer.parseInt(rangeText.split("-")[0]);
	            endYear = Integer.parseInt(rangeText.split("-")[1]);
	        }

	        // Click desired year
	        WebElement yearElement = driver.findElement(EMPPrePaymentLocators.yearOption(targetyear));
	        yearElement.click();
	    }
	  //*****month dropdown page methods
	  public void selectmonthFilter(String month) {
			 WaitUtils.waitForElementClickable(driver,EMPPrePaymentLocators.monthdrpdown , 30).click();
			// Wait for all options to appear
		        WaitUtils.waitForElementVisible(driver, EMPPrePaymentLocators.monthoptions, 20);
		        
		        List<WebElement> options = driver.findElements(EMPPrePaymentLocators.monthoptions);
		        for (WebElement option : options) {
		            if (option.getText().equals(month)) {
		                option.click();
		                log.info("Selected user: " + month);
		                break;
		            }
		        }
		    }
	  public int monthNameToNumber(String monthName) {
		    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
		    Month m = Month.from(fmt.parse(monthName));
		    return m.getValue(); // August → 8
		}
	  public List<WebElement> getDateColumnValues() {
		  List<WebElement> datecols=WaitUtils.waitForElementsVisible(driver,EMPPrePaymentLocators.datecols,20);  // Assuming Date is in first column
		return datecols;
		}

	  // Get all year values from date column
	    public List<String> getAllYearsFromDateColumn() {
	        List<WebElement> dateCells = driver.findElements(EMPPrePaymentLocators.datecols);
	        List<String> years = new ArrayList<>();

	        for (WebElement cell : dateCells) {
	            String fullDate = cell.getText().trim();  // e.g. 01-12-2025 04:36 pm

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

//view action button action methods
	    public String getdatetextelefromviewpage() {
	    	String viewpagedateele=WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.viewbtndateele,20).getText();
			return viewpagedateele;
	    	
	    }
	    public String getamtelefromviewpage() {
	    	String viewpageamtele=WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.viewpageamtele,20).getText();
			return viewpageamtele;
	    	
	    }
	    public String getdeductedmonthelefromviewpage() {
	    	String viewpagedeductmonthele=WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.viewpagedeductmonthele,20).getText();
			return viewpagedeductmonthele;
	     }
	    public void clickclosebtn() {
	    	WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.viewpageclosebtn,20).click();
	    }
	    //for getting first row data to validate viewpage
	    public String getfirstrowdateele() {
	    	String dateeledata=WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.datelerow(1),20).getText();
			return dateeledata;
	    	
	    }
	    public String getfirstrowamteledata() {
	       String amtdata= WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.amtelerow(1),20).getText();
			return amtdata;
	    }
	    public String getmonthdeducteledata() {
	    	String deductmonthdata=WaitUtils.waitForElementVisible(driver,EMPPrePaymentLocators.deductmonthelerow(1),20).getText();
			return deductmonthdata;
	    }
}
