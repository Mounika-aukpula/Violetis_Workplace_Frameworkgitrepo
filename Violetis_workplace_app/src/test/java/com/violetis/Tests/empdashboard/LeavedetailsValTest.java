package com.violetis.Tests.empdashboard;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Pages.employeePage.EMPLeavePage;

public class LeavedetailsValTest extends BaseTest{
	public LoginPage loginPage;
	public EMPDashboardPage dashboardPage;
	public EMPLeavePage empleavepg;
	int total, approved, pending, paid, unpaid, rejected, halfday,expall,exppenleave,expapprovedleave,exprejleaves;
	@BeforeClass
	public void setUpPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new EMPDashboardPage(driver);
        empleavepg=new EMPLeavePage(driver);
	}
	@Test(priority=1)
	
	public void getleavecountsfromempdashboard() {
		loginPage.login();
		int total=dashboardPage.gettotalleavecount();
		int pending=dashboardPage.getPendingleavecount();
		int paid=dashboardPage.getPaidleavecount();
		int unpaid=dashboardPage.getunpaidleavecount();
		int rejected=dashboardPage.getRejectdleavecount();
		int halfday=dashboardPage.getHalfdayleavecount();
		int approved=dashboardPage.getApprovedleavecount();
		System.out.println("✅ Leave counts captured successfully!");
		}
	@Test(priority=2)
	public void getleavecountsfromleavemodule() throws InterruptedException {
		empleavepg.navigatetoLeavebutton();
		int expall=empleavepg.getallleavecounts();
		int exppenleave=empleavepg.getpendingleavecount();
		int expapprovedleave=empleavepg.getapprovedleavecount();
		int exprejleaves=empleavepg.getrejectedleavecount();
		
	}
	@Test(priority=3)
	public void validatelevaecounts() {
		Assert.assertEquals(total,expall,"❌ Total leave count mismatch!");
		Assert.assertEquals(pending,exppenleave,"❌ Pending leave count mismatch!");
		Assert.assertEquals(rejected,exprejleaves,"❌ Rejected leave count mismatch!");
		Assert.assertEquals(approved,expapprovedleave,"❌ Approved leave count mismatch!");
		
		
	}
}
