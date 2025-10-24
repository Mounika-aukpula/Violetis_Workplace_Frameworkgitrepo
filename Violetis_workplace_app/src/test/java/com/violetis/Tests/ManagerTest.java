package com.violetis.Tests;

import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPage;
import com.violetis.Utilities.ConfigReader;

public class ManagerTest extends BaseTest{
	/*@Test
	public void managerAddAppreciationTest() throws InterruptedException {
	    // Step 1: Login as Manager
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(
	        ConfigReader.getProperty("manageruname"),
	        ConfigReader.getProperty("managerpass")
	    );
	    
	    ManagerPage mpage=new ManagerPage(driver);
	    mpage.navigateToAppreciations();
	    mpage.clickonAddAppriciationbtn();
	    mpage.fillappreciationform("mounikaap","May","2027","8");
	    mpage.submitappreciaationform();
	    Thread.sleep(2000);
	    }*/
	@Test
	public void managerAddWarningtoempTest() {
		// Step 1: Login as Manager
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(
	        ConfigReader.getProperty("manageruname"),
	        ConfigReader.getProperty("managerpass")
	    );
	    ManagerPage mpage=new ManagerPage(driver);
	    mpage.navigateTooffboarding();
	    mpage.clickonNewWarningbtn();
	    mpage.fillWarnedform("mounikaap","QA","Oct","2025","13");
	}
	
}
