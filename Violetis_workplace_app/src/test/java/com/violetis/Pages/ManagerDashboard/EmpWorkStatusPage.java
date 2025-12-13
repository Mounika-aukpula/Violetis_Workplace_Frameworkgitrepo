package com.violetis.Pages.ManagerDashboard;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class EmpWorkStatusPage extends BasePage {

	public EmpWorkStatusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String gettotalaactiveempcount() {
		scrollToElement(ManagerdashboardLocators.totalempcount);
		String totalemployeecount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.totalempcount, 10).getText();
		return totalemployeecount;
	}
	public String getprobationcount() {
		scrollToElement(ManagerdashboardLocators.probationcount);
		String probationcount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.probationcount, 10).getText();
		return probationcount;
	}
	public String getfulltimecount() {
		String fulltimecount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.fulltimecount, 10).getText();
		return fulltimecount;
	}
	public String getcontractempcount() {
		String contractempcount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.contractempcount, 10).getText();
		return contractempcount;
	}
	public String getWFHcount() {
		String wfhcount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.wfhcount, 10).getText();
		return wfhcount;
	}
	//top performer
	public String gettopperformername() {
		String topperformername= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.topperformernameatempworksttaus, 10).getText();
		return topperformername;
	}
	public String gettopperformerappcount() {
		String topperf_apcount= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.appreciationscountfortopperformeratworkempsttaus, 10).getText();
		return topperf_apcount;
	}

}
