package com.violetis.Pages.ManagerDashboard;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPstatusPage extends BasePage{

	public EMPstatusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public String gettopperformername() {
	String topperformernameatempstatus= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.topperformernameatempstatus, 10).getText();
	return topperformernameatempstatus;
}
public String gettopperformerappcount() {
	String topperformerappreciationcountatempstatus= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.appreciationscountfortopperformeratempstatus, 10).getText();
	return topperformerappreciationcountatempstatus;
}
}
