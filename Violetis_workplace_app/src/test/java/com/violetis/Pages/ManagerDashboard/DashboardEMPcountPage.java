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
		String totalactiveemployeecount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalactempcount, 10).getText();
		return totalactiveemployeecount;
	}
	public String gettotalempscount() {
		String totalemployeecount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalemps, 10).getText();
		return totalemployeecount;
	}
	public String getinactiveempscount() {
		String totalinactiveemployeescount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalinactemps, 10).getText();
		return totalinactiveemployeescount;
	}
	public String getunderyouempscount() {
		String totalunderyouemployeescount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalempsunderyou, 10).getText();
		return totalunderyouemployeescount;
	}
	

}
