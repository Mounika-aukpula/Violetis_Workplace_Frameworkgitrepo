package com.violetis.Pages.employeePage;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EMPOFFboardingWarningsLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPOffboardingWarnPage extends BasePage {

	public EMPOffboardingWarnPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoWarnpage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EMPOFFboardingWarningsLocators.Offboarding_btn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,EMPOFFboardingWarningsLocators.warning_btn, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the warnings submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to offboarding.", e);
	            throw new RuntimeException("Navigation to offboarding failed!", e);
	        }
	}
	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, EMPOFFboardingWarningsLocators.yeardrpdwnbtn, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingWarningsLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( EMPOFFboardingWarningsLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EMPOFFboardingWarningsLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPOFFboardingWarningsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPOFFboardingWarningsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EMPOFFboardingWarningsLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPOFFboardingWarningsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPOFFboardingWarningsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EMPOFFboardingWarningsLocators.yearOption(targetyear));
        yearElement.click();
    }
	public void selectmonth(String month) {
		WebElement monthinput=WaitUtils.waitForElementPresence(driver, EMPOFFboardingWarningsLocators.monthdrpdwnbtn, 30);
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
	public void searchWarning(String data) {
		WebElement SearchBox=WaitUtils.waitForElementPresence(driver, EMPOFFboardingWarningsLocators.serachbytitleinputbox, 30);
		SearchBox.clear();
		SearchBox.sendKeys(data);
    }
	 public List<String> getAllTitles() {
	        return driver.findElements(EMPOFFboardingWarningsLocators.warnrows).stream()
	                .map(row -> row.findElement(EMPOFFboardingWarningsLocators.titlecells).getText().trim())
	                .collect(Collectors.toList());
	    }
	 public String getWarningDateAt(int rowIndex) {
	        return driver.findElements(EMPOFFboardingWarningsLocators.warnrows)
	                .get(rowIndex)
	                .findElement(EMPOFFboardingWarningsLocators.warndatecells)
	                .getText()
	                .trim();
	    }
	 public void clickViewAt(int rowIndex) {
	        driver.findElements(EMPOFFboardingWarningsLocators.warnrows)
	                .get(rowIndex)
	                .findElement(EMPOFFboardingWarningsLocators.viewicons)
	                .click();
	    }
	 public boolean isNoDataShown() {
	        return isDisplayed(EMPOFFboardingWarningsLocators.nodataele);
	    }
	 public void clickNextPage() {
	        click(EMPOFFboardingWarningsLocators.pagonationelefrwd);
	        
	    }
	 /**
	  * Verifies if the table headers match the expected list.
	  *
	  * @param expectedHeaders A list of expected header titles in order.
	  * @return true if all headers match, false otherwise.
	  */
	 public boolean areHeadersCorrect(List<String> expectedHeaders) {
	     List<WebElement> headerElements =WaitUtils.waitForElementsPresence(driver, EMPOFFboardingWarningsLocators.tableheaders, 30);
	     
	     if (headerElements.size() != expectedHeaders.size()) {
	         System.out.println("Header count mismatch! Expected: " + expectedHeaders.size() + ", Found: " + headerElements.size());
	         return false;
	     }

	     for (int i = 0; i < headerElements.size(); i++) {
	         String actualHeader = headerElements.get(i).getText().trim();
	         if (!actualHeader.equalsIgnoreCase(expectedHeaders.get(i).trim())) {
	             System.out.println("Header mismatch at index " + i + ": Expected '" + expectedHeaders.get(i) + "', Found '" + actualHeader + "'");
	             return false;
	         }
	     }
	     
	     return true;
	 }
	 public String getTitleTextAt(int rowIndex) {
		  String xpath = String.format("//table//tbody//tr[%d]//td[1]/a", rowIndex + 1);
		    WebElement titleElement = driver.findElement(By.xpath(xpath));
		    return titleElement.getText().trim();
		}
	 public String getDateTextAt(int rowIndex) {
		  String xpath = String.format("//table//tbody//tr[%d]//td[2]", rowIndex + 1);
		    WebElement titleElement = driver.findElement(By.xpath(xpath));
		    return titleElement.getText().trim();
		}
	 public String getTitleInDetailView() {
		String titleview= WaitUtils.waitForElementPresence(driver, EMPOFFboardingWarningsLocators.titleele, 30).getText();
		return titleview;
	 }
	 public String getDateInDetailView() {
		 String Dateview= WaitUtils.waitForElementPresence(driver, EMPOFFboardingWarningsLocators.dateele, 30).getText();
			return Dateview;
	 }
	 /**
	  * Clicks on the title link at the specified row in the warnings table.
	  * @param rowIndex Index of the row (0-based).
	  */
	 public void clickTitleAt(int rowIndex) {
	     String xpath = String.format("//table//tbody//tr[%d]//td[1]//a", rowIndex + 1);
	     WebElement titleLink = driver.findElement(By.xpath(xpath));
	     titleLink.click();
	 }
	 public List<String> getAllWarningDates() {
		    return driver.findElements(By.xpath("//table//tbody//tr//td[2]"))
		            .stream()
		            .map(WebElement::getText)
		            .map(String::trim)
		            .collect(Collectors.toList());
		}
}
