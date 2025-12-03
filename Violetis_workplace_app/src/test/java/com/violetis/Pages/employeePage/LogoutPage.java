package com.violetis.Pages.employeePage;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.EmpPageLocators.LogoutLocators;
import com.violetis.Utilities.WaitUtils;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	  public void clickonlogout(){
	    	WaitUtils.waitForElementVisible(driver, LogoutLocators.logoutbtn, 30).click();
	    	log.info("clicked on logoutbutton");
	    	WaitUtils.waitForElementVisible(driver, LogoutLocators.confirm_logout, 30).click();
	    	log.info("clicked on confirm logout button");
	    	
	    }

}
