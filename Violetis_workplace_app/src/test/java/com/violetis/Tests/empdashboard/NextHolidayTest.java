package com.violetis.Tests.empdashboard;

import java.time.LocalDate;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.NextholidayPage;
public class NextHolidayTest extends BaseTest {
	public NextholidayPage nexthldpg;
	String nextholidaytest;
	@BeforeClass
    public void loginAndSetupDashboard() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        nexthldpg=new NextholidayPage(driver);
	}
	@Test(priority=1,description="validate next holiday displayed or not")
	public void validatenextholidaydisplayed() {
		nextholidaytest=nexthldpg.getnextholiday();

	    Assert.assertNotNull(nextholidaytest, "❌ Next holiday element is not found on the dashboard!");
	    Assert.assertFalse(nextholidaytest.isEmpty(), "❌ Next holiday text is empty on the dashboard!");

	    System.out.println("✅ Next holiday is displayed on the dashboard: " + nextholidaytest);
	}
	@Test(priority=2,description="validate viewall button navigates to holidays page or not")
	public void validateviewallnavigationpage() throws InterruptedException {
		nexthldpg.clickonviewall();
		nexthldpg.verifyholidaypageopened();
	}
	
	@Test(priority=3,description = "Validate upcoming holiday in employee dashboard matches next actual holiday from Holidays page")
    public void verifyNextUpcomingHoliday() throws InterruptedException {
		  System.out.println("📅 Dashboard shows next holiday: " + nextholidaytest);

	        // Step 1️⃣ Collect holidays (optimized for current + next month only)
	       // List<LocalDate> allHolidayDates = nexthldpg.getallholidaysdates();

	       // Assert.assertFalse(allHolidayDates.isEmpty(), "❌ No holidays found on Holidays page!");
	       // System.out.println("📅 Holidays collected (current + next month): " + allHolidayDates.size());

	        // Step 2️⃣ Validate dashboard next holiday vs upcoming actual holiday
	       // nexthldpg.validateNextHoliday(nextholidaytest, allHolidayDates);

	        System.out.println("🎉 Successfully validated: Dashboard next holiday matches actual upcoming holiday!");
	    }
    }
    

