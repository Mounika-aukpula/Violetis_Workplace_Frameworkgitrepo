package com.violetis.Pages.ManagerPackage;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.AppreciationsPageLocators;
import com.violetis.Utilities.WaitUtils;

public class AppreciationsPage extends BasePage{

	public AppreciationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAppreciationpage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.Appreciationsmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.appreciations_submenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Appreciations submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
	public int getTotalRowCount() {

	    int totalRowCount = 0;

	    int lastpageno=Integer.parseInt(WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.lastpagenum, 15).getText());

	    // If pagination exists
	    if (lastpageno > 1) {

	       

	        for (int i = 1; i <= lastpageno; i++) {

	            // Count rows in current page
	            List<WebElement> rows =WaitUtils.waitForElementsVisible(driver,AppreciationsPageLocators.allrows,20);
	            totalRowCount += rows.size();

	            // Click next only if not last page
	            if (i < lastpageno) {
	                WebElement nextBtn = WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.pagenavigationnextbtn,20);

	                if (!nextBtn.getAttribute("class").contains("disabled")) {
	                    nextBtn.click();
	                    WaitUtils.waitForPageToLoad(driver); // custom wait
	                }
	            }
	        }

	    } else {
	        // Only one page
	        List<WebElement> rows =WaitUtils.waitForElementsVisible(driver,AppreciationsPageLocators.allrows,20);
	        totalRowCount = rows.size();
	    }

	    return totalRowCount;
	}
	 public void SelectByuser(String empname) {
		 // Click the input to open dropdown
	        WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.selectuserdrpdown , 10).click();

	        // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.selectuserdrpdownoptions, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(AppreciationsPageLocators.selectuserdrpdownoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(empname)) {
	                option.click();
	                log.info("Selected user: " + empname);
	                break;
	            }
	        }
	 }
	 public void selectawarddrpdown(String selectaward) {
		 WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.selectawarddrpdown , 10).click();
		 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.awarddrpeles, 5);
		// Get all options dynamically
	        List<WebElement> options = driver.findElements(AppreciationsPageLocators.awarddrpeles);
	        for (WebElement option : options) {
	            if (option.getText().equals(selectaward)) {
	                option.click();
	                log.info("Selected user: " + selectaward);
	                break;
	            }
	        }
	 }
	 //for appreciations table validations
	 public List<String> getselectawarddrpoptionsdata() {
		 WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.selectawarddrpdown , 10).click();
		 // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.awarddrpeles, 5);

	        // Get all options dynamically
	        List<WebElement> options =WaitUtils.waitForElementsVisible(driver,AppreciationsPageLocators.awarddrpeles,10);
	        
	     // Store option texts
	        List<String> optionTexts = new ArrayList<>();
	        for (WebElement option : options) {
	        	String text = option.getText().trim();
	            if (!text.isEmpty()) {
	                optionTexts.add(text);
	            }
	            }
	        return optionTexts;
	        }
	 /**
	     * Get all users who received appreciations
	 * @throws InterruptedException 
	     */
	    public List<String> getAppreciatedUserNames() throws InterruptedException {
	        List<String> users = new ArrayList<>();
	        Thread.sleep(3000);
	        List<WebElement> elements =WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.usernames, 15);
	        for (WebElement ele : elements) {
	            users.add(ele.getText().trim());
	        }
	        return users;
	    }
	    // get all dated and validate detcols
	    /**
	     * Get all appreciation date values
	     */
	    public List<String> getAppreciationDates() {
	        List<String> dates = new ArrayList<>();

	        List<WebElement> elements =WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.dateeles, 15);
	        for (WebElement ele : elements) {
	            dates.add(ele.getText().trim());
	        }
	        return dates;
	    }
	

/**
 * Get unique awards from Award column
 */
public Set<String> getAwardsFromTable() {
    Set<String> awards = new HashSet<>();

    List<WebElement> elements =WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.awardeles, 15);
    for (WebElement ele : elements) {
        awards.add(ele.getText().trim());
    }
    return awards;
}

/**
 * Get awards from Select Award dropdown
 */
public Set<String> getAwardsFromDropdown() {
    Set<String> awards = new HashSet<>();

    WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.selectawarddrpdown, 15).click();
    List<WebElement> elements = WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.awarddrpeles, 15);
    for (WebElement ele : elements) {
        awards.add(ele.getText().trim());
    }
    return awards;
}
/**
 * Get all price amount values
 */
public List<String> getPriceAmounts() {
    List<String> prices = new ArrayList<>();

    List<WebElement> elements = WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.priceamteles, 15);
    for (WebElement ele : elements) {
        prices.add(ele.getText().trim());
    }
    return prices;
}
//*******************************************
//Add new appreciations module action methods
public void clickaddnewappbtn() {
	 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.Addnewappbtn, 15).click();
}
public void enteruserdropdownoption(String uname) {
	 WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.appuserdrpdown , 10).click();
	 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.appuserdrpoptions, 5);
	// Get all options dynamically
        List<WebElement> options = driver.findElements(AppreciationsPageLocators.appuserdrpoptions);
        for (WebElement option : options) {
            if (option.getText().equals(uname)) {
                option.click();
                log.info("Selected user: " + uname);
                break;
            }
        }
}
public void enterawardtype(String awardtype) {
	 WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.appawarddrpdown , 10).click();
	 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.appawrddrpoptions, 5);
	// Get all options dynamically
       List<WebElement> options = driver.findElements(AppreciationsPageLocators.appawrddrpoptions);
       for (WebElement option : options) {
           if (option.getText().equals(awardtype)) {
        	   option.click();
               log.info("Selected user: " + awardtype);
               break;
           }
       }
}
public void enterappreciationdate(String month,String year, String day)
{
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.datepicketdrpdown, 15).click();
	while(true) {
		WebElement current_month=WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.month_ele, 10);
	         String current_month_text=current_month.getText();
	         System.out.println(current_month_text);
	    WebElement current_year=WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.Year_ele, 10);
	         String current_year_text=current_year.getText();
	         System.out.println(current_year_text);
	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
	         {
	        	 break;
	         }
	         else
	         {
	        	 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.month_forward_btn, 30).click(); 
	         }
	
	        	 
	}
    
	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, AppreciationsPageLocators.dateele, 30);
  for(WebElement dt:alldates) {
	  if(dt.getText().equals(day))
	  {
		  dt.click();
		  WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.ok_btn_datepicker, 20).click();
		  break;
	  }
	  
  }
}
public void enterprizemoney(String prizemoney) {
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.priceinputbox, 15).sendKeys(prizemoney);
}
public void enteraccoutnno(String accname) {
	 WaitUtils.waitForElementVisible(driver,AppreciationsPageLocators.acctnodrpdown , 10).click();
	 WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.actnooptions, 5);
	// Get all options dynamically
      List<WebElement> options = driver.findElements(AppreciationsPageLocators.actnooptions);
      for (WebElement option : options) {
          if (option.getText().equals(accname)) {
       	   option.click();
              log.info("Selected user: " + accname);
              break;
          }
      }
}
public void clickaddpricegivenbtn() {
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.addpricegivenbtn, 15).click();
}
public void enterprizegivefordata(String prizengivenunder) {
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.pricegiveninputbox, 15).sendKeys(prizengivenunder);
}
public void enterdescription(String desc) {
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.descriptionbox, 15).sendKeys(desc);
}
public void clickcreatebtn() {
	WaitUtils.waitForElementVisible(driver, AppreciationsPageLocators.createbtn, 15).click();
}
public void selectAppreciationDateAfterDays(int days) {
    LocalDate targetDate = LocalDate.now().plusDays(days);
    String month = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    String year = String.valueOf(targetDate.getYear());
    String day = String.valueOf(targetDate.getDayOfMonth());
    enterappreciationdate(month, year, day);
}
}

	

