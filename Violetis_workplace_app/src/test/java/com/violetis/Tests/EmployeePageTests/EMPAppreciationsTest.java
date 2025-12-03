package com.violetis.Tests.EmployeePageTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EmpAppreciationsPage;
public class EMPAppreciationsTest extends BaseTest{
	public LoginPage loginPage;
	public EmpAppreciationsPage empappg;
	@BeforeClass
	public void openAppreciationspage() {
		loginPage=new LoginPage(driver);
		empappg=new EmpAppreciationsPage(driver);
		loginPage.login(); 
		empappg.navigatetoAppreciationsmenu();
		
	}
	/* @Test(priority = 1)
	    public void verifyEmptyState() throws InterruptedException {
		 Thread.sleep(2000);
		
		 empappg.selectyear("2023"); // Example year with no data
		
	     Assert.assertTrue(empappg.isNoDataDisplayed(), "❌ 'No data' message not displayed when no awards exist.");
	    }
	  @Test(priority = 2)
	    public void verifyAwardDetailsDisplayed() {
		   empappg.selectyear("2025");
	        List<WebElement> rows = empappg.getAllRows();
	        Assert.assertTrue(rows.size() > 0, "❌ No award rows found.");

	        // Validate first row columns not empty
	        Assert.assertNotNull(empappg.getCellValue(1, 2), "❌ Date not displayed.");
	        Assert.assertTrue(empappg.getCellValue(1, 3).contains("£"), "❌ Price not formatted correctly.");
	    }
	   @Test(priority = 3)
	    public void verifyYearFilter() {
		   empappg.selectyear("2025");
	        List<WebElement> rows = empappg.getAllRows();
	        for (WebElement row : rows) {
	            Assert.assertTrue(row.getText().contains("2025"), "❌ Non-2025 award displayed.");
	        }
	    }*/
	   @Test(priority = 4)
	    public void verifyMonthFilter() throws InterruptedException {
		  // empappg.selectyear("2025");
		   empappg.selectMonth("June");
	        List<WebElement> rows = empappg.getAllRows();
	        for (WebElement row : rows) {
	            Assert.assertTrue(row.getText().contains("06-2025"), "❌ Awards from other months displayed.");
	        }
	    }
	 /*
	     @Test(priority = 5)
	    public void verifyActionButton() {
		  // empappg.selectyear("2025");
		   empappg.clickActionButton(0); // Click first row’s action button
	        // Add assertion based on modal or new page load
	    }*/
	}
	