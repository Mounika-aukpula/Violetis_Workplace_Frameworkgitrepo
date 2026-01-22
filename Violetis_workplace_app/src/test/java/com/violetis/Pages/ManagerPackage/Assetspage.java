package com.violetis.Pages.ManagerPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.AppreciationsPageLocators;
import com.violetis.Locators.ManagerPageLocators.AssetsLocators;
import com.violetis.Locators.hrlocators.HRAssetsLocators;
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
	        WaitUtils.waitForElementClickable(driver,AssetsLocators.selectlocationdrpdown , 10).click();

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
	
	//not working tab methods
		 public List<Map<String, String>> getAllNotWorkingAssets() throws InterruptedException{
			 Thread.sleep(5000);
			 List<Map<String, String>> assetsList = new ArrayList<>();
			  // Locate all rows
		        List<WebElement> notworkingassetrows = WaitUtils.waitForElementsVisible(driver, AssetsLocators.allnotworkingassetsrows, 20);
		        for (WebElement row : notworkingassetrows) {
		            Map<String, String> assetData = new HashMap<>();
		          String  AssetName=WaitUtils.waitForElementVisible(driver, AssetsLocators.assetnames, 20).getText();
		          String  Assettype=WaitUtils.waitForElementVisible(driver, AssetsLocators.assettypes, 20).getText();
		          String  Lentto=WaitUtils.waitForElementVisible(driver, AssetsLocators.lentoeles, 20).getText();
		          String  Location=WaitUtils.waitForElementVisible(driver, AssetsLocators.locationeles, 20).getText();
		          String  Sno=WaitUtils.waitForElementVisible(driver, AssetsLocators.snoeles, 20).getText();
		          String  Status=WaitUtils.waitForElementVisible(driver, AssetsLocators.statuseles, 20).getText();
		          assetData.put("AssetName", AssetName);
		          assetData.put("AssetType", Assettype);
		          assetData.put("LentTo", Lentto);
		          assetData.put("Location", Location);
		          assetData.put("SerialNumber", Sno);
		          assetData.put("Status", Status);

		          assetsList.add(assetData);
		      }

		      return assetsList;
		    
		 }
		 public void validatinglocationbyfilter(String location) throws InterruptedException {
			
			 Thread.sleep(5000);
			 SelectBylocation(location);
			 Thread.sleep(5000);
			  // Locate all rows
		        List<WebElement> notworkingassetrows = WaitUtils.waitForElementsVisible(driver, AssetsLocators.allnotworkingassetsrows, 20);
		        for (WebElement row : notworkingassetrows) {
		        	 String  act_Location=WaitUtils.waitForElementVisible(driver, AssetsLocators.locationeles, 20).getText();
		        	 Assert.assertEquals(
		        			 act_Location.trim(),
		                     location.trim(),
		                     "❌ Location filter mismatch"
		             );
		        }
		 }
		 public void validateassettypebyfilter(String assettype) throws InterruptedException {
			 Thread.sleep(5000);
			 searchbyasset(assettype);
			 Thread.sleep(5000);
			  // Locate all rows
		        List<WebElement> notworkingassetrows = WaitUtils.waitForElementsVisible(driver, AssetsLocators.allnotworkingassetsrows, 20);
		        for (WebElement row : notworkingassetrows) {
		        	 String  act_assettype=WaitUtils.waitForElementVisible(driver, AssetsLocators.assettypes, 20).getText();
		        	 Assert.assertEquals(
		        			 act_assettype.trim(),
		        			 assettype.trim(),
		                     "❌ Assettype filter mismatch"
		             );
		        }
		 }
		

}
