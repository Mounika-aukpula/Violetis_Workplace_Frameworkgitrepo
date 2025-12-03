package com.violetis.Pages.HrPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.hrlocators.HRResignationLocators;
import com.violetis.Utilities.WaitUtils;

public class HRResignationPage extends BasePage{

	public HRResignationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigaettoResignationpage() {
	        try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, HRResignationLocators.offboarding_menu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver, HRResignationLocators.Resignations_sub_menu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Resignations submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Offboarding.", e);
	            throw new RuntimeException("Navigation to Offboarding failed!", e);
	        }
	    
	}
	public void clickonserachtitleinput(String title){
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.searchbytitleinputbox, 15).sendKeys(title);
	}
	public void clickonrejorappbtn() {
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.accorrejbtn, 15).click();
	}
	public String getfirstrowtitle() {
		WebElement titleEle = WaitUtils.waitForElementVisible(driver, HRResignationLocators.first_row_title,20);
        return titleEle.getText().trim();
	}
	public void clickonupdatebtn() {
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.updatebtn,20).click();
	}
	public void enterlastworkingday(String month,String year, String day)
	{
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.Lastworkingdaydatepicker, 15).click();
    	while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, HRResignationLocators.month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, HRResignationLocators.Year_ele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, HRResignationLocators.month_forward_btn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, HRResignationLocators.dateele, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(day))
    	  {
    		  dt.click();
    		  WaitUtils.waitForElementVisible(driver, HRResignationLocators.ok_btn_datepicker, 20).click();
    		  break;
    	  }
    	  
      }
	}
	public void enterreplynotesdata(String data) {
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.replynotesinputbox, 20).sendKeys(data);
	}
	public String fillresignformwithapprovedresignation(String month,String year,String day,String data) {
		enterlastworkingday(month,year,day);
		String lastworkingdate=WaitUtils.waitForElementVisible(driver,HRResignationLocators.lastworkingdatestoreele,20).getAttribute("value");
		enterreplynotesdata(data);
		clickonupdatebtn();
		return lastworkingdate;
	}
	public String fillresignwithreject(String month,String year,String day,String data) {
		enterlastworkingday(month,year,day);
		String lastworkingdate=WaitUtils.waitForElementVisible(driver,HRResignationLocators.lastworkingdatestoreele,20).getAttribute("value");
		enterreplynotesdata(data);
		WaitUtils.waitForElementVisible(driver, HRResignationLocators.Rejected_btn, 20).click();
		clickonupdatebtn();
		return lastworkingdate;
	}

}
