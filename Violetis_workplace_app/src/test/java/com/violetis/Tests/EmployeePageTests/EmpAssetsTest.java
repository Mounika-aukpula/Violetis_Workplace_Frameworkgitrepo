package com.violetis.Tests.EmployeePageTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.AssetsPage;
import com.violetis.Utilities.ConfigReader;
import com.violetis.Pages.HrPage.HrAssetsPage;
import com.violetis.Pages.employeePage.LogoutPage;
import com.violetis.Pages.HrPage.HrLogoutPage;
public class EmpAssetsTest extends BaseTest {
	LoginPage loginPage;
	HrAssetsPage hrassetspg;
	AssetsPage empassetspg;
	LogoutPage logoutpg;
	HrLogoutPage hrlogoutpg;
	//dynamic test data
	String dynamicsno="VLT" + System.currentTimeMillis();
	String actsno="VLT1762263404102";//dynamicsno;
	  @BeforeClass
	    public void setupPages() {
		  loginPage=new LoginPage(driver);
		  hrassetspg=new HrAssetsPage(driver);
		  empassetspg=new AssetsPage(driver);
		  logoutpg=new LogoutPage(driver);
		  hrlogoutpg=new HrLogoutPage(driver);
	  }
	  /** Test Case 1: Verify empty state when no assets are issued */
	   /* @Test(priority = 1)
	    public void verifyEmptyStateNoAssetsIssued() {
	    	loginPage.login();
	    	empassetspg.clickonAssetsmodule();
	    	Assert.assertTrue(empassetspg.isNoDataDisplayed(), "No data message not shown!");
	    	logoutpg.clickonlogout();
	    }*/
	    /** Test Case 2: Verify issued asset details appear correctly 
	     **/
	    @Test(priority = 2)
	    public void verifyIssuedAssetDetails() throws InterruptedException {
	    	loginPage.login(
			        ConfigReader.getProperty("hrusername"),
			        ConfigReader.getProperty("hrpassword")
			    );
	    	hrassetspg.NavigatetoAssetsmenu();
	    	/*hrassetspg.clickonAddNewAssits();
	    	hrassetspg.fillassetsform("Mouse","mouse","India",dynamicsno,"sampledescription");
	    	hrassetspg.clickoncreate();*/
	    	Thread.sleep(3000);
	    	hrassetspg.clickLendtoActionButtonBySno(actsno);
	    	hrassetspg.fillLendform("mounikaap","05-11-2025","15-11-2025","samplenotes");
	    	hrlogoutpg.clickonlogout();
	    	loginPage.login("mounika.aukpula08@gmail.com","Mounika@1997");
	    	empassetspg.clickonAssetsmodule();
	    	//Assert.assertTrue(empassetspg.isAssetDisplayed(assetName), "Asset not visible in employee dashboard!");
	    }
}
