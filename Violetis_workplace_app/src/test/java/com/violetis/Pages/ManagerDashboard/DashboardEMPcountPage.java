package com.violetis.Pages.ManagerDashboard;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class DashboardEMPcountPage extends BasePage{

	public DashboardEMPcountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getactiveempcount() {
		String totalemployeecount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalactempcount, 10).getText();
		return totalemployeecount;
	}
	

}
