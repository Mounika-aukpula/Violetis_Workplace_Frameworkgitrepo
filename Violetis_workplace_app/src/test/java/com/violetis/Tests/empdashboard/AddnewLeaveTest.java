package com.violetis.Tests.empdashboard;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.ApplyNewLeavePage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Pages.ManagerPage;
import com.violetis.Utilities.ConfigReader;
public class AddnewLeaveTest extends BaseTest {
	private ApplyNewLeavePage leave;
	private LoginPage loginPage;
	private ManagerPage mpage;
	private EMPDashboardPage dashboardPage;
	@BeforeClass
    public void loginAndSetupDashboard() {
        // Login before each test
       loginPage = new LoginPage(driver);
       leave=new ApplyNewLeavePage(driver);
        mpage=new ManagerPage(driver);
        dashboardPage=new EMPDashboardPage(driver);
    }
@Test(priority=1)
	public void ApplyLeaveTest() throws InterruptedException {
	 loginPage.login();
	 leave.Applyforleave("Holidays India","Nov","2025","10","Nov","2025","10","Personal work");
	 Thread.sleep(2000);
	 dashboardPage.logout();
	 //driver.navigate().refresh();
	 loginPage = new LoginPage(driver);
	 
	}
	@Test(priority=2)
	public void validateLeavefromManager()  {
		//Login as Manager and validate received leave from the particular employee
		loginPage.login(
		        ConfigReader.getProperty("manageruname"),
		        ConfigReader.getProperty("managerpass")
		    );
		mpage.NavigatetoLeavebtn();
		System.out.println("employee applied leave type is:" +leave.appliedLeaveType);
		System.out.println("employee applied leave for reson:" +leave.appliedReason);
		System.out.println("employee name:" +leave.empname);
		System.out.println("employee startdate leave" +leave.startdate);
		System.out.println("employee end date leave" +leave.enddate);
		mpage.validateLeave();
		
	}
	
}
