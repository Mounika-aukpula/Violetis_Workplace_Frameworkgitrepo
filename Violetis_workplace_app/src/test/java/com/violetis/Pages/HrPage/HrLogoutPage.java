package com.violetis.Pages.HrPage;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.hrlocators.HrlogoutLocators;
import com.violetis.Utilities.WaitUtils;

public class HrLogoutPage extends BasePage {

	public HrLogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonlogout() {
		WaitUtils.waitForDrawerToClose(driver, 10);
    	WaitUtils.waitForElementVisible(driver, HrlogoutLocators.logoutbtn,30).click();
    	WaitUtils.waitForElementVisible(driver, HrlogoutLocators.confirm_logout, 30).click();
	}

}
