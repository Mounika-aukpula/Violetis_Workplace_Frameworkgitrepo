package com.violetis.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.LoginPageLocators;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Utilities.WaitUtils;


import com.violetis.Utilities.ConfigReader;
import com.violetis.Utilities.DateUtils;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Pages.employeedashboardpage.ApplyNewLeavePage;

public class ManagerPage extends BasePage {
	private JavaScriptUtility jsUtil;
	public  ApplyNewLeavePage empleavepg;

    public ManagerPage(WebDriver driver) {
        super(driver);
        jsUtil = new JavaScriptUtility(driver);
    }

    /**
     * Hover over the main menu and navigate to Appreciations submenu.
     */
    public void navigateToAppreciations() {
        try {
            // Wait for main menu
            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.Appreciations, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the main menu.");
            actions.moveToElement(mainMenu).click().perform();

            // Wait for submenu
            WebElement subMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.Appreciation, 15);
            actions.moveToElement(subMenu).click().perform();
            
            log.info("Clicked on the Appreciations submenu.");

        } catch (Exception e) {
            log.error("Failed to navigate to Appreciations.", e);
            throw new RuntimeException("Navigation to Appreciations failed!", e);
        }
    }
    
    public void clickonAddAppriciationbtn() {
    	WaitUtils.waitForElementVisible(driver,ManagerLocators.Add_Appreciationbtn, 10).click();
    	log.info("clicked on  Add appriciation button******");
    }
    public void enterAppreciationUser(String username) {
        // Click the input to open dropdown
        WaitUtils.waitForElementVisible(driver, ManagerLocators.uname, 10).click();

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, ManagerLocators.user_app_options, 5);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(ManagerLocators.user_app_options);
        for (WebElement option : options) {
            if (option.getText().equals(username)) {
                option.click();
                log.info("Selected user: " + username);
                break;
            }
        }
        }
    public void clickonDatapicker() {
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.Date_Time_picker_btn, 15).click();
    	
    	
    }
    public void Managerlogout() {
    	WaitUtils.waitForDrawerToClose(driver, 10);
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.manager_logout, 30).click();
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.manager_confirm_logout, 30).click();
    	
    	
    }
    public void enterAppreciationDate(String month,String year, String date) {
    	while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, ManagerLocators.month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, ManagerLocators.Year_ele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, ManagerLocators.month_forward_btn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, ManagerLocators.alldates, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(date))
    	  {
    		  dt.click();
    		  break;
    	  }
    	  
      }
        
    }
    public void submitappreciaationform() {
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.submit_app_btn, 30).click();
    }
    
    public void fillappreciationform(String appuname,String month,String year, String date) {
    	enterAppreciationUser(appuname);
    	clickonDatapicker();
    	enterAppreciationDate(month,year,date);
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.app_date_ok_btn, 15).click();
    	submitappreciaationform();
    }
    
	//Action methods for Warning*************
    public void navigateTooffboarding() {
        try {
            // Wait for main menu
            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.off_boarding, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the offboarding menu.");
            actions.moveToElement(mainMenu).click().perform();

            // Wait for submenu
            WebElement subMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.warnings_btn, 50);
            WaitUtils.waitForElementClickable(driver, ManagerLocators.warnings_btn, 50);
            try {
            	subMenu.click();
                log.info("Clicked on Warnings submenu using standard click.");
            } catch (Exception clickEx) {
                log.warn("Standard click failed on Warnings submenu. Trying JS click...");
                jsUtil.clickElementByJS(subMenu);
                log.info("Clicked on Warnings submenu using JS click.");
            }
            
            log.info("Clicked on the Warnings submenu.");

        } catch (Exception e) {
            log.error("Failed to navigate to Warnings menu.", e);
            throw new RuntimeException("Navigation to Warnings failed!", e);
        }
    }
    public void clickonNewWarningbtn() {
    	WaitUtils.waitForElementVisible(driver,ManagerLocators.ADD_NEW_WARN, 10).click();
    	log.info("clicked on  Add New Warning raise button******");
    }
    
    public void enterWarnedUser(String username) {
        // Click the input to open dropdown
        WaitUtils.waitForElementVisible(driver, ManagerLocators.uname, 10).click();

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, ManagerLocators.user_app_options, 5);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(ManagerLocators.user_app_options);
        for (WebElement option : options) {
            if (option.getText().equals(username)) {
                option.click();
                log.info("Selected user: " + username);
                break;
            }
        
        }
        
   }
    public void EnterWarntitle(String title) {
    	WebElement tit=WaitUtils.waitForElementVisible(driver, ManagerLocators.Warn_title, 5);
    	tit.sendKeys(title);
    }
    public void clickonWarnedDatapicker() {
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.Date_Time_picker_btn, 15).click();
    	
    	
    }
    public void enterWarnRaiseDate(String month,String year, String date) {
    	while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, ManagerLocators.month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, ManagerLocators.Year_ele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, ManagerLocators.month_forward_btn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, ManagerLocators.alldates, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(date))
    	  {
    		  dt.click();
    		  break;
    	  }
    	  
      }
        
    }
    public void fillWarnedform(String appuname,String title,String month,String year, String date) {
    	enterWarnedUser(appuname);
    	EnterWarntitle(title);
    	clickonDatapicker();
    	enterWarnRaiseDate(month,year,date);
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.app_date_ok_btn, 15).click();
    	submitWarnedform();
    }
    public void submitWarnedform() {
    	WaitUtils.waitForElementVisible(driver, ManagerLocators.submit_app_btn, 15).click();
    }
    // Leave validation ***********************
    public void NavigatetoLeavebtn() {
    	 try {
             // Wait for main menu
             WebElement mainMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.Leavebtn, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the main menu.");
             actions.moveToElement(mainMenu).click().perform();

             // Wait for submenu
             WebElement subMenu = WaitUtils.waitForElementVisible(driver, ManagerLocators.main_leavebtn, 15);
             actions.moveToElement(subMenu).click().perform();
             
             log.info("Clicked on the Leaves submenu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Leaves.", e);
             throw new RuntimeException("Navigation to Leaves failed!", e);
         }
    	
    }
    public void validateLeave() {
    	List<WebElement> all_leaveraiserows=WaitUtils.waitForElementsVisible(driver, ManagerLocators.alleaverows, 15);
    	 for( int i=1;i<=all_leaveraiserows.size();i++)
    	 {
    		 By empnamedynamicLocator = ManagerLocators.getempnameLocator(i);
    		 WebElement button = driver.findElement(empnamedynamicLocator);
    		 String leaveempname=button.getText();
    		 empleavepg=new ApplyNewLeavePage(driver);
    		 if(leaveempname.equals(empleavepg.empname)) {
    			 for(int j=3;j<=5;j++) {
    				 By leavedetailsdynloc=ManagerLocators.getleavetype(i, j);
    				 WebElement leavedetail = driver.findElement(empnamedynamicLocator);
    				 String leavedet=leavedetail.getText();
    				 if(leavedet.equals(empleavepg.appliedLeaveType)|| leavedet.equals(empleavepg.startdate)||leavedet.equals(empleavepg.enddate)) {
    					 System.out.println("validation done successfully" +leavedet);
    					 
    				 }
    			 }
    		 }
    	  }
    }
}