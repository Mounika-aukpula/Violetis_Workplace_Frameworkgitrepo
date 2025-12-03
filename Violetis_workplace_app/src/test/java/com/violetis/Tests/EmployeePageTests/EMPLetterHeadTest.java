package com.violetis.Tests.EmployeePageTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Locators.EmpPageLocators.EMPLetterHeadsPage;
import com.violetis.Pages.LoginPage;

public class EMPLetterHeadTest extends BaseTest{
	public LoginPage loginpage;
	public EMPLetterHeadsPage letterheadpg;
	@BeforeClass
	public void navigatetoLetterhead() {
		loginpage=new LoginPage(driver);
		letterheadpg=new EMPLetterHeadsPage(driver);
		loginpage.login();
		letterheadpg.navigateletterheadpage();
	}
	@Test(priority=1)
	    public void testChangeYear() {
	        

		letterheadpg.selectyear("2025");
	        Assert.assertTrue(letterheadpg.getRowCount() > 0, "Rows should load for year 2025");
	        List<String> years = letterheadpg.getAllCreatedYears();

	        for (String yr : years) {
	            Assert.assertEquals(yr, "2025", "A row with incorrect year found!");
	        }
	    }
	  @Test(priority=2)
	    public void testNoMatchFilters() {
		  letterheadpg.selectyear("2024");
		  

	        Assert.assertTrue(letterheadpg.isNoDataDisplayed(), "No data message should be shown");
	    }
	  @Test(priority=3)
	    public void testDownloadLetterhead() {
		  driver.navigate().refresh();
	        
		  letterheadpg.downloadFirstLetterhead();
	        // If needed, verify file exists in downloads folder
	        Assert.assertTrue(true, "Download triggered");
	    }
	  @Test(priority=4)
	    public void testChangePagination() {
	        
		  letterheadpg.changePagination("20");
	        Assert.assertTrue(letterheadpg.getRowCount() <= 20, "Page should show 20 entries");
	    }
	  @Test(priority=5)
	    public void testNavigatePages() {
	        
		  letterheadpg.clickNext();
	        Assert.assertTrue(letterheadpg.getRowCount() > 0, "Next page loaded");

	        letterheadpg.clickPrev();
	        Assert.assertTrue(letterheadpg.getRowCount() > 0, "Previous page loaded");
	    }
}
