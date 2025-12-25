package com.violetis.Pages.ManagerPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.AppreciationsPageLocators;
import com.violetis.Locators.ManagerPageLocators.AssetsLocators;
import com.violetis.Utilities.WaitUtils;

public class Assetspage extends BasePage{

	public Assetspage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAssetsPage() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, AssetsLocators.Assetsmenu, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,AssetsLocators.Assetssubmenu, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Assets submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Assets.", e);
	            throw new RuntimeException("Navigation to Assets failed!", e);
	        }
	}
	public void clickonworkingtab() {
		 WaitUtils.waitForElementVisible(driver,AssetsLocators.workingtab, 15).click();
	}
	public void clickonNotworkingtab() {
		 WaitUtils.waitForElementVisible(driver,AssetsLocators.notworkingtab, 15).click();
	}
	public void searchbyasset(String Assetname) {
		 WaitUtils.waitForElementVisible(driver,AssetsLocators.searchbyasset, 15).sendKeys(Assetname);
	}
	 public void SelectBylocation(String location) {
		 // Click the input to open dropdown
	        WaitUtils.waitForElementVisible(driver,AssetsLocators.selectlocationdrpdown , 10).click();

	        // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, AssetsLocators.selectlocationoptions, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(AssetsLocators.selectlocationoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(location)) {
	                option.click();
	                log.info("Selected user: " + location);
	                break;
	            }
	        }
	 }
	 public void Selectbyuser(String empname) {
		 // Click the input to open dropdown
	        WaitUtils.waitForElementVisible(driver,AssetsLocators.selectbyuserdrpdown , 10).click();

	        // Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, AssetsLocators.selectbyuseroptions, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(AssetsLocators.selectbyuseroptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(empname)) {
	                option.click();
	                log.info("Selected user: " + empname);
	                break;
	            }
	        }
	 }

}
