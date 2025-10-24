package com.violetis.Tests.empdashboard;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.AttendencedetailsPage;
import com.violetis.Pages.employeePage.EMPLeavePage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
public class EmpAttendencedetailsvalTest extends BaseTest {
	public LoginPage loginPage;
	public EMPDashboardPage dashboardPage;
	public AttendencedetailsPage attendencedetails;
	int totatt,presentdaayscount,leavescount,halfdayleavescpount,lateloginscount;
	@BeforeClass
	public void setUpPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new EMPDashboardPage(driver);
        //empleavepg = new EMPLeavePage(driver);
        attendencedetails=new AttendencedetailsPage(driver);
	}
	@Test(priority=1)
	public void getAttendencecountfromempdashboard() {
		loginPage.login();
		int totatt=dashboardPage.gettotalattendencecount();
		int presentdaayscount=dashboardPage.getpresentcount();
		int leavescount=dashboardPage.getleavescount();
		int halfdayleavescpount=dashboardPage.gethalfdaycount();
		int lateloginscount=dashboardPage.getlateattendencecount();
		System.out.println(totatt);
		System.out.println(presentdaayscount);
		System.out.println(leavescount);
		System.out.println(halfdayleavescpount);
		System.out.println(lateloginscount);
		
		
	}
	@Test(priority=2)
	public void getattendencecountfromattendencemodule() throws InterruptedException {
		loginPage.login();
		attendencedetails.navigatetoAttendencedetails();
		Thread.sleep(2000);
		attendencedetails.clickonyearpicker();
		attendencedetails.enterYearOnYearPicker();
		Thread.sleep(2000);
		int lateloginscount=attendencedetails.getTotalLateLogins();
		System.out.println(lateloginscount);
	}
}
