package com.violetis.Pages.HrDashboardPage;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.hrlocators.HRDashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class HRDashboardCountPage extends BasePage{

	public HRDashboardCountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String gettotalempscount() {
		String totalempcount= WaitUtils.waitForElementVisible(driver, HRDashboardLocators.totalempscount, 10).getText();
		return totalempcount;
	}
	public String gettotalactiveempscount() {
		String totalactempscount= WaitUtils.waitForElementVisible(driver, HRDashboardLocators.totalactempscount, 10).getText();
		return totalactempscount;
	}
	public String getinactemps() {
		String totalinactemps= WaitUtils.waitForElementVisible(driver, HRDashboardLocators.totalinactiveemps, 10).getText();
		return totalinactemps;
	}

}
