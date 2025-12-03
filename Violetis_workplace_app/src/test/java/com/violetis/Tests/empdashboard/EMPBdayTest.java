package com.violetis.Tests.empdashboard;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPage;
import com.violetis.Pages.employeedashboardpage.ApplyNewLeavePage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardBirthdayPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;


public class EMPBdayTest extends BaseTest{
	public LoginPage loginPage;
	public EMPDashboardBirthdayPage empbdpg;

	@BeforeClass
    public void loginAndSetupDashboard() {
        // Login before each test
       loginPage = new LoginPage(driver);
       empbdpg=new EMPDashboardBirthdayPage(driver);
       loginPage.login();
    }
	
	/*  @Test(priority=1)
	    public void verifyBirthdaysAreDisplayed() throws InterruptedException {
		  	
	        Assert.assertTrue(empbdpg.areBirthdaysDisplayed(), "Birthdays are not displayed");
	    }*/
	  @Test(priority=2)
	    public void verifyFilteringByUser() throws InterruptedException {
	       
	    	String expected_slectuname=empbdpg.selectUser("Mounika A");
	    	Thread.sleep(2000);
	    	String actual_selecteduname=empbdpg.getselectedbdayusername();
	    	Assert.assertEquals(expected_slectuname, actual_selecteduname);
	    	driver.navigate().refresh();
	    	Thread.sleep(200);
	    	log.info("selected user successfully");
	    }

	   @Test(priority=4)
	    public void verifyFilteringByDate() throws InterruptedException {
	    	empbdpg.enterdateondatepicker("Oct","2025","19");
	    	Thread.sleep(2000);  	
	    	
	    	
	    	
	    }

	   

	    @Test(priority=3)
	    public void verifyNoBirthdaysForSelectedDate() {
	       
	    	empbdpg.enterdateondatepicker("Nov","2025","14");
	        Assert.assertTrue(empbdpg.isNoBirthdayMessageDisplayed(), "No birthday message not displayed");
	        driver.navigate().refresh();
	    }
}
