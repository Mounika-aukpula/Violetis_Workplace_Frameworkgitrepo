package com.violetis.Pages.employeePage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.EmpHolidayLocators;
import com.violetis.Locators.ManagerPageLocators.HolidaysLocators;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
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
    	return WaitUtils.waitForElementsPresent(
                driver,
                EmpHolidayLocators.hldynamecellss,
                20
        );
       
    }
    public List<WebElement> getHolidayDates() {
    	return WaitUtils.waitForElementsPresent(
                driver,
                EmpHolidayLocators.hldydatecells,
                20
        );
        
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
    //For Managredashboard holidayvalidations
    public Map<String, String> getHolidayNameDateMap() {

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Map<String, String> holidayMap = new LinkedHashMap<>();

	    List<WebElement> holidayNames =getHolidayNames();
	           
	    List<WebElement> holidayDates =getHolidayDates();

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
            String inputPattern,
            String outputPattern) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern);

        Map<String, String> normalizedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            LocalDate date = LocalDate.parse(entry.getValue(), inputFormatter);
            normalizedMap.put(entry.getKey(), date.format(outputFormatter));
        }
        return normalizedMap;
    }
    public Map<String, String> getAllWeekendHolidaysAcrossPages() {
    	  Map<String, String> holidayMap = new LinkedHashMap<>();
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	    Actions actions = new Actions(driver);

    	    // Get total pages
    	    String lastPageText = WaitUtils.waitForElementPresence(driver, EmpHolidayLocators.lastpageno, 20).getText().trim();
    	    int totalPages = Integer.parseInt(lastPageText);

    	    for (int page = 1; page <= totalPages; page++) {
    	        // Wait for rows on current page
    	        List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(EmpHolidayLocators.holidaysrows));

    	        for (int i = 1; i <= rows.size(); i++) {
    	            try {
    	                WebElement nameCell = wait.until(ExpectedConditions.visibilityOfElementLocated(EmpHolidayLocators.Holidayname(i)));
    	                WebElement dateCell = wait.until(ExpectedConditions.visibilityOfElementLocated(EmpHolidayLocators.Holidaydate(i)));

    	                String name = nameCell.getText().trim();
    	                String date = dateCell.getText().trim();

    	                if (!name.isEmpty() && !date.isEmpty()) {
    	                    holidayMap.putIfAbsent(name + "_" + date, date);
    	                }

    	            } catch (StaleElementReferenceException e) {
    	                // Re-locate the row if stale
    	                i--;
    	            }
    	        }

    	        // Click "Next Page" only if not last page
    	        if (page < totalPages) {
    	            WebElement nextPageBtn = wait.until(ExpectedConditions.elementToBeClickable(EmpHolidayLocators.paginationnxtbtn));
    	            actions.moveToElement(nextPageBtn).pause(Duration.ofMillis(300)).click().perform();

    	            // Wait for table to refresh after page change
    	            wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
    	        }
    	    }

    	    return holidayMap;
    	    }
    
    public boolean isNextPageClickable() {
    	try {
    	WebElement nextBtn = driver.findElement(
    			EmpHolidayLocators.paginationnxtbtn
        );
    	String classAttr = nextBtn.getAttribute("class");
    	  // Ant Design disables next button using CSS class
        return nextBtn.isDisplayed()
                && nextBtn.isEnabled()
                && !classAttr.contains("ant-pagination-disabled");
    	
    }catch (NoSuchElementException e) {
        return false;
    }
    }
}
