package com.violetis.Pages.HrPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.hrlocators.HRAssetsLocators;
import com.violetis.Utilities.WaitUtils;

public class HrAssetsPage extends BasePage {

	public HrAssetsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void NavigatetoAssetsmenu() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver,HRAssetsLocators.assetsbtn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the Assets main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,HRAssetsLocators.aseetssub_menu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Assets submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Assets.", e);
	            throw new RuntimeException("Navigation to Assets failed!", e);
	        }
	}
	public void clickonAddNewAssits() {
	    WaitUtils.waitForElementVisible(driver,HRAssetsLocators.addnewassetbtn, 15).click();
	}
	public void enterAssetname(String Assetname) {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.assetname, 15).sendKeys(Assetname);
	}
	public void enterAssettype(String AssetType) {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.assettypedrpdown, 30).click();
		 // Click the input to open dropdown
       

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, HRAssetsLocators.asserttypeoptions,15);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(HRAssetsLocators.asserttypeoptions);
        for (WebElement option : options) {
            if (option.getText().equals(AssetType)) {
                option.click();
                log.info("Selected Asset type: " + AssetType);
                break;
            }
        }
	}
	public void enterlocation(String loc) {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.locationdrpdown, 30).click();
		 // Click the input to open dropdown
      

       // Wait for all options to appear
       WaitUtils.waitForElementVisible(driver, HRAssetsLocators.locationdrpdownoptions,15);

       // Get all options dynamically
       List<WebElement> options = driver.findElements(HRAssetsLocators.locationdrpdownoptions);
       for (WebElement option : options) {
           if (option.getText().equals(loc)) {
               option.click();
               log.info("Selected location: " + loc);
               break;
           }
       }
	}
	public void enterserialno(String serno) {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.serialnoinputbox, 30).sendKeys(serno);
	}
	public void enterdescription(String desc) {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.descriptionbox, 30).sendKeys(desc);
	}
	public void clickoncreate() {
		WaitUtils.waitForElementVisible(driver,HRAssetsLocators.createbtn, 30).click();
	}
	public void fillassetsform(String Assetname,String Assettype,String loc,String sno,String desc) {
		enterAssetname(Assetname);
		enterAssettype(Assettype);
		enterlocation(loc);
		enterserialno(sno);
		enterdescription(desc);
	}
	public void clickLendtoActionButtonBySno(String targetSno) {
	    List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr"));
	    
	    for (int i = 1; i <= rows.size(); i++) {
	        // Relocate the 7th column each time to avoid stale reference
	        String col7Xpath = "//tbody[@class='ant-table-tbody']//tr[" + i + "]/td[7]";
	        WebElement col7 = driver.findElement(By.xpath(col7Xpath));
	        String snoValue = col7.getText().trim();
	        
	        if (snoValue.equals(targetSno)) {
	            // Now locate the 'Lend To' button in the same row (e.g., in 9th column)
	            String actionButtonXpath = "//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[3]/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr[" + i + "]/td[9]/div/div[4]/button/span";
	            driver.findElement(By.xpath(actionButtonXpath)).click();
	            System.out.println("Clicked action button for Sno: " + targetSno + " (Row " + i + ")");
	            break;
	        }
	    }
	}
	
	//Lendto module
	public void selectLendtoDateInAbbreviatedFormat(String date) {
		  // Expected format: "dd-MM-yyyy"
	    String[] dateParts = date.split("-");
	    String day = dateParts[0];
	    String month = dateParts[1];
	    String year = dateParts[2];

	    // Convert month number to abbreviated month name
	    String[] monthAbbr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
	                          "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	    String monthName = monthAbbr[Integer.parseInt(month) - 1];

	    // Open date picker
	    WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lenddatepicker, 30).click();

	    while (true) {
	        WebElement currentMonthEle = WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendmonthele, 10);
	        WebElement currentYearEle = WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendyearele, 10);

	        String currentMonth = currentMonthEle.getText().trim();
	        String currentYear = currentYearEle.getText().trim();

	        if (currentMonth.equals(monthName) && currentYear.equals(year)) {
	            break;
	        }

	        // Compare year and month to navigate backward or forward
	        int currentYearVal = Integer.parseInt(currentYear);
	        int targetYearVal = Integer.parseInt(year);
	        int currentMonthVal = Arrays.asList(monthAbbr).indexOf(currentMonth) + 1;
	        int targetMonthVal = Integer.parseInt(month);

	        if (currentYearVal > targetYearVal || 
	            (currentYearVal == targetYearVal && currentMonthVal > targetMonthVal)) {
	            // Go to previous month
	            WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendmonthprevbutton, 30).click();
	        } else {
	            // Go to next month
	            WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendmonthnextbtn, 30).click();
	        }
	    }

	    // Now select the day
	    List<WebElement> allDates = WaitUtils.waitForElementsVisible(driver, HRAssetsLocators.lendpickeralldatescells, 30);
	    for (WebElement dt : allDates) {
	        if (dt.getText().trim().equals(day)) {
	            dt.click();
	            break;
	        }
	    }
	    }
	    public void selectReturnDateInAbbreviatedFormat(String date) {
			  // Expected format: "dd-MM-yyyy"
		    String[] dateParts = date.split("-");
		    String day = dateParts[0];
		    String month = dateParts[1];
		    String year = dateParts[2];

		    // Convert month number to abbreviated month name
		    String[] monthAbbr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
		                          "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		    String monthName = monthAbbr[Integer.parseInt(month) - 1];

		    // Open date picker
		    WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returndatapicker, 30).click();

		    while (true) {
		        WebElement currentMonthEle = WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returnmonthele, 10);
		        WebElement currentYearEle = WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returnyearele, 10);

		        String currentMonth = currentMonthEle.getText().trim();
		        String currentYear = currentYearEle.getText().trim();

		        if (currentMonth.equals(monthName) && currentYear.equals(year)) {
		            break;
		        }

		        // Compare year and month to navigate backward or forward
		        int currentYearVal = Integer.parseInt(currentYear);
		        int targetYearVal = Integer.parseInt(year);
		        int currentMonthVal = Arrays.asList(monthAbbr).indexOf(currentMonth) + 1;
		        int targetMonthVal = Integer.parseInt(month);

		        if (currentYearVal > targetYearVal || 
		            (currentYearVal == targetYearVal && currentMonthVal > targetMonthVal)) {
		            // Go to previous month
		            WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returnmonthprevbtn, 30).click();
		        } else {
		            // Go to next month
		            WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returnmonthfrwdbtn, 30).click();
		        }
		    }

		    // Now select the day
		    List<WebElement> allDates = WaitUtils.waitForElementsVisible(driver, HRAssetsLocators.returdatealldatesele, 30);
		    for (WebElement dt : allDates) {
		        if (dt.getText().trim().equals(day)) {
		            dt.click();
		            break;
		        }
		    }
	}
	    public void enterLendUser(String username) {
	 
	    	 // 1. Open the dropdown
	        WaitUtils.waitForElementClickable(driver, HRAssetsLocators.lendtousernamedrpdown, 10).click();

	        // 2. Wait for dropdown options to load
	        WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendtouserdrpdownoptions, 10);

	        // 3. Fetch all options
	        List<WebElement> options = driver.findElements(HRAssetsLocators.lendtouserdrpdownoptions);

	        boolean userFound = false;
	        for (WebElement option : options) {
	            // Scroll each option into view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

	            String optText = option.getText().trim();
	            if (optText.equalsIgnoreCase(username)) {
	                option.click();
	                log.info("✅ Selected user: " + username);
	                userFound = true;
	                break;
	            }
	        }

	        if (!userFound) {
	            throw new RuntimeException("❌ User '" + username + "' not found in dropdown options!");
	        }
	    	
	        }
	public void clickonlenderdatepicker() {
		WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lenddatepicker, 30).click();
	}
	public void clickonretrndatedatepicker() {
		WaitUtils.waitForElementVisible(driver, HRAssetsLocators.returndatapicker, 20).click();
	}
	public void enterNotesonnotesbox(String notes) {
		WaitUtils.waitForElementVisible(driver, HRAssetsLocators.textareabox, 20).sendKeys(notes);;
	}
	public void clickoncreatelenderform() {
		WaitUtils.waitForElementVisible(driver, HRAssetsLocators.lendformcraetebtn, 20).click();
	}
	public void fillLendform(String username,String lenddate,String returndate,String note) throws InterruptedException {
		enterLendUser(username);
		Thread.sleep(2000);
		clickonlenderdatepicker();
		selectLendtoDateInAbbreviatedFormat(lenddate);
		clickonretrndatedatepicker();
		selectReturnDateInAbbreviatedFormat(returndate);
		enterNotesonnotesbox(note);
		clickoncreatelenderform();
		
	}
	//return module functionality
	
	
}

