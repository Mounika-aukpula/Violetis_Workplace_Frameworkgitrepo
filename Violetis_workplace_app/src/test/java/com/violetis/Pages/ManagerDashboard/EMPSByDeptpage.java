package com.violetis.Pages.ManagerDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.HolidaysLocators;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPSByDeptpage extends BasePage{

	public EMPSByDeptpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


    // ===== Actions =====

    // Validate graph is displayed
    public boolean isGraphDisplayed() {
        return WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.empsdeptcanvasbarchat, 20).isDisplayed();
    }

    // Verify chart title
    
    public String getcharttitle() {
    	 return WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.charttitle, 20).getText();
    }

}
