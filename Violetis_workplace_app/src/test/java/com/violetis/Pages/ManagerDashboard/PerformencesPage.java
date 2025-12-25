package com.violetis.Pages.ManagerDashboard;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class PerformencesPage extends BasePage{

	public PerformencesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// Validate graph is displayed
    public boolean isGraphDisplayed() {
    	scrollToElement(ManagerdashboardLocators.appreciationgraph);
        return WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.appreciationgraph, 20).isDisplayed();
    }
 // Verify chart title
    
    public String getcharttitle() {
    	 return WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.performancetitl, 20).getText();
    }
}
