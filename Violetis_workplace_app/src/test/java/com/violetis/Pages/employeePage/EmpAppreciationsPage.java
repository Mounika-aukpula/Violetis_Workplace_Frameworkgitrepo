package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EMPAppreciationsLocators;
import com.violetis.Utilities.WaitUtils;

public class EmpAppreciationsPage extends BasePage{

	public EmpAppreciationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAppreciationsmenu() {
		WaitUtils.waitForElementPresence(driver, EMPAppreciationsLocators.Appreciations_menu, 30).click();
	}
	public void selectyear(String targetyear) {
		WaitUtils.waitForElementPresence(driver, EMPAppreciationsLocators.yeardrpdwnbtn, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EMPAppreciationsLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( EMPAppreciationsLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EMPAppreciationsLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPAppreciationsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPAppreciationsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EMPAppreciationsLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPAppreciationsLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPAppreciationsLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EMPAppreciationsLocators.yearOption(targetyear));
        yearElement.click();
    }
	  public void selectAwardType(String awardName) {
		  WaitUtils.waitForElementVisible(driver, EMPAppreciationsLocators.selectawarddropdown, 15).click();
	        List<WebElement> options =  driver.findElements(EMPAppreciationsLocators.selectdropdownoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(awardName)) {
	                option.click();
	                log.info("Selected user: " + awardName);
	                break;
	            }
	        }
	    }
	  public void selectMonth(String monthName) throws InterruptedException {
		    // 1️⃣ Click dropdown to open it
		    WebElement dropdown = WaitUtils.waitForElementClickable(driver,
		    		EMPAppreciationsLocators.monthdropdown, 10);
		    dropdown.click();

		    // 2️⃣ Locate visible dropdown panel
		    WebElement dropdownPanel = WaitUtils.waitForElementPresence(driver,EMPAppreciationsLocators.monthdrpoptions, 10);

		    // 🟢 ADD THIS LINE — find the actual scrollable list holder
		    WebElement scrollableList = WaitUtils.waitForElementPresence(driver,EMPAppreciationsLocators.monthdrpscrollbar, 10);
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
		        js.executeScript("arguments[0].scrollTop += 300;", scrollableList);
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
	  public List<WebElement> getAllRows() {
		  return WaitUtils.waitForElementsVisible(driver, EMPAppreciationsLocators.appreciationsrows,20);
	    }
	  public String getCellValue(int row, int col) {
	        return driver.findElement(EMPAppreciationsLocators.getCellByRowAndColumn(row, col)).getText().trim();
	    }
	  public boolean isNoDataDisplayed() {
	        List<WebElement> msg = driver.findElements(EMPAppreciationsLocators.nodataele);
	        return !msg.isEmpty() && msg.get(0).isDisplayed();
	    }
	  public void clickActionButton(int rowIndex) {
	        List<WebElement> actionBtns = driver.findElements(EMPAppreciationsLocators.actionBtn);
	        if (rowIndex < actionBtns.size()) {
	            actionBtns.get(rowIndex).click();
	        }
	    }

	

}
