package com.violetis.Pages.employeePage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.ManagerLocators;
import  com.violetis.Locators.EmpPageLocators.EMPComplaintLocators;
import com.violetis.Utilities.WaitUtils;
public class EMPComplaintPage extends BasePage {

	public EMPComplaintPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void Navigatetocomplaintbtn() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.Offboarding_btn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the offboarding menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.complaintsbtn, 30);
	            actions.moveToElement(subMenu).click().perform();
	            
	            try {
	            	subMenu.click();
	                log.info("Clicked on complaint submenu using standard click.");
	            } catch (Exception clickEx) {
	                log.warn("Standard click failed on complaint submenu. Trying JS click...");
	                jsUtil.clickElementByJS(subMenu);
	                log.info("Clicked on complaint submenu using JS click.");
	            }
	            
	            log.info("Clicked on the complaint submenu.");


	        } catch (Exception e) {
	            log.error("Failed to navigate to complaints .", e);
	            throw new RuntimeException("Navigation to complaints failed!", e);
	        }
	}
	public void clickonaddnewcomplaint() {
		WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.byyoubtn, 30).click();
		WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.Addnewcomplaintbtn, 30).click();
	}
	public void entercomplainttitle(String tit) {
		WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.comp_title, 30).sendKeys(tit);
	}
	 public void clickonDatapicker() {
	    	WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.date_time_picker, 15).click();
	    	}
	 public void entercomplaintraiseDate(String month,String year, String date) {
	    	while(true) {
	    		WebElement current_month=WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.month_ele, 10);
	    	         String current_month_text=current_month.getText();
	    	         System.out.println(current_month_text);
	    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.Year_ele, 10);
	    	         String current_year_text=current_year.getText();
	    	         System.out.println(current_year_text);
	    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
	    	         {
	    	        	 break;
	    	         }
	    	         else
	    	         {
	    	        	 WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.month_forward_btn, 30).click(); 
	    	         }
	    	
	    	        	 
	    	}
	        
	    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, EMPComplaintLocators.alldates, 30);
	      for(WebElement dt:alldates) {
	    	  if(dt.getText().equals(date))
	    	  {
	    		  dt.click();
	    		  break;
	    	  }
	    	  
	      }
	        
	    }
	 public void enterTostaffdata(String tostaff) {
		 WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.to_staff_drp_dwn_btn, 30).click();
		 // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.to_staff_drp_options, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(EMPComplaintLocators.to_staff_drp_options);
	        for (WebElement option : options) {
	            if (option.getText().equals(tostaff)) {
	                option.click();
	                log.info("Selected user: " + tostaff);
	                break;
	            }
	        }
	        }
	 public void entercomlaintdescription(String descr) {
		 WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.descr_textbox, 30).sendKeys(descr);
	 }
	 public void submitcomplaintform() {
	    	WaitUtils.waitForElementVisible(driver, EMPComplaintLocators.comp_submitbtn, 30).click();
	    }
	public void fillcomplaintform(String com_title,String Month,String year,String date,String tostaff,String Desc) {
		
		entercomplainttitle(com_title);
		clickonDatapicker();
		entercomplaintraiseDate(Month,year,date);
		enterTostaffdata(tostaff);
		entercomlaintdescription(Desc);
		submitcomplaintform();
		
	}
	
}
