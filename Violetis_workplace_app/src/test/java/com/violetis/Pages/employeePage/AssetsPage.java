package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.EmpPageLocators.EMPAssetsLocators;
import com.violetis.Locators.hrlocators.HRAssetsLocators;
import com.violetis.Utilities.WaitUtils;

public class AssetsPage extends BasePage{

	public AssetsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonAssetsmodule() {
		WaitUtils.waitForElementClickable(driver,EMPAssetsLocators.assetmenu , 30).click();
	}
	
	public void clickonissuedassets() {
		WaitUtils.waitForElementClickable(driver,EMPAssetsLocators.issuedassetsbtn , 30).click();
	}
	// Check if "No data" text is displayed
	public boolean isNoDataDisplayed() {
	        return driver.findElement(EMPAssetsLocators.nodataele).isDisplayed();
	}
	  // Get all asset rows
	public List<WebElement> getAllAssetRows() {
	        return driver.findElements(EMPAssetsLocators.assetsrows);
	}
	//click on view button
	public void clickViewButton(WebElement row) {
        row.findElement(EMPAssetsLocators.viewbutton).click();
    }
	 public void selectAssetTypeFilter(String assetType) {
		 WaitUtils.waitForElementClickable(driver,EMPAssetsLocators.assettypedrpdwn , 30).click();
		// Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, EMPAssetsLocators.assettypeoptions, 20);
	        
	        List<WebElement> options = driver.findElements(EMPAssetsLocators.assettypeoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(assetType)) {
	                option.click();
	                log.info("Selected user: " + assetType);
	                break;
	            }
	        }
	    }
/*	 // Click Return button in Action column
    public void clickReturnButton(WebElement row) {
        //row.findElement(EMPAssetsLocators.ACTION_RETURN_BTN).click();
    }*/
	/* // Check if row is overdue (highlighted)
	    public boolean isRowOverdue(WebElement row) {
	        return row.getAttribute("class").contains("overdue");
	    }*/
}
