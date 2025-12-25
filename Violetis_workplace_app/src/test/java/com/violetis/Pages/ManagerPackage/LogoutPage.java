package com.violetis.Pages.ManagerPackage;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.LogoutLocators;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonlogoutbtn() throws InterruptedException {
		scrollToElement(LogoutLocators.logoutbtn);
		WaitUtils.waitForElementVisible(driver, LogoutLocators.logoutbtn, 20).click();
		Thread.sleep(2000);
		WaitUtils.waitForElementVisible(driver, LogoutLocators.confirm_logout, 20).click();
	}

}
