package com.violetis.Tests.EmployeePageTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EmpHolidayPage;
public class EmpHolidayTest extends BaseTest {
	public EmpHolidayPage empholidaypg;
	public LoginPage loginPage;
	 @BeforeClass
	    public void  openHolidaysPage() {
		 loginPage = new LoginPage(driver);
		  empholidaypg=new EmpHolidayPage(driver);
		  loginPage.login();
		  empholidaypg.clickonholidaysmenu();
	 }
	 @Test(priority=1)
	 public void verifiyholidaylistdisplay() {
		 Assert.assertTrue(empholidaypg.isHolidayListPresent(), "Holiday list is not displayed!");
	 }
	 @Test(priority = 2)
	    public void verifyAllTabFunctionality() {
		 empholidaypg.clickalltabs();
	        Assert.assertTrue(empholidaypg.isHolidayListPresent(), "All holidays not displayed!");
	    }
	/* @Test(priority = 3)
	    public void verifyNoHolidayCase() {
		// empholidaypg.selectyear("2030");
		empholidaypg.selectmonth("March");
	        Assert.assertTrue(empholidaypg.isNoDataDisplayed(), "No data message is missing!");
	    }*/
	 @Test(priority = 4)
	    public void verifyHolidayTabFunctionality() throws InterruptedException{
		 empholidaypg.clickHolidayTab();
		 Thread.sleep(2000);
	        List<String> holidays = empholidaypg.getHolidayNames().stream().map(e -> e.getText()).toList();
	        holidays.forEach(name -> Assert.assertFalse(name.toLowerCase().contains("weekend")));
	    }
	  @Test(priority = 5)
	    public void verifyWeekendTabFunctionality() throws InterruptedException{
		  empholidaypg.clickWeekendTab();
		  Thread.sleep(2000);
	        List<String> holidays = empholidaypg.getHolidayNames().stream().map(e -> e.getText()).toList();
	        holidays.forEach(name -> Assert.assertTrue(name.toLowerCase().contains("week")));
	    }
	  @Test(priority = 6)
	    public void verifyYearFilter() throws InterruptedException{
		  empholidaypg.selectyear("2026");
		  Thread.sleep(2000);
	        Assert.assertTrue(empholidaypg.getHolidayDates()
	                .stream()
	                .allMatch(e -> e.getText().endsWith("2026")), "Not all holidays are from 2026");
	    }

	 /*   @Test(priority = 7)
	    public void verifyMonthFilter() {
	    	empholidaypg.selectMonth("December");
	    	empholidaypg.getHolidayDates().forEach(date ->
	                Assert.assertTrue(date.getText().substring(3, 5).equals("12"),
	                        "Date month not matching filter!"));
	    }*/
	    @Test(priority = 8)
	    public void verifySearchByPartialName() throws InterruptedException {
	    	driver.navigate().refresh();
	    	empholidaypg.searchHoliday("Week");
	    	Thread.sleep(2000);
	    	empholidaypg.getHolidayNames().forEach(name ->
	                Assert.assertTrue(name.getText().toLowerCase().contains("week")));
	    }
	    @Test(priority = 9)
	    public void verifySearchNoMatch() throws InterruptedException {
	    	driver.navigate().refresh();
	    	empholidaypg.searchHoliday("abcd123");
	    	Thread.sleep(2000);
	        Assert.assertTrue(empholidaypg.isNoDataDisplayed(), "No data message missing for unmatched search!");
	    }
	    @Test(priority = 10)
	    public void verifyHolidayDateFormat() {
	    	driver.navigate().refresh();
	        String date = empholidaypg.getHolidayDates().get(0).getText();
	        Assert.assertTrue(date.matches("\\d{2}-\\d{2}-\\d{4}"), "Date format is not DD-MM-YYYY!");
	    }

	    @Test(priority = 11)
	    public void verifyDownloadHolidayCalendar() {
	    	empholidaypg.clickondownloadcalenderbtn();
	        // TODO: Add file download verification
	        Assert.assertTrue(true, "Download triggered! (Add logic later)");
	    }
}
