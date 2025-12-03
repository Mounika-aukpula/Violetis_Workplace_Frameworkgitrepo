package com.violetis.Tests.EmployeePageTests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EMPPrepaymentPage;

public class EMPPrepayementTest extends BaseTest{
	public LoginPage loginpage;
	public EMPPrepaymentPage empprepaymentpg;
	@BeforeClass
	public void navigatetoprepayemnetpage() throws InterruptedException {
		loginpage=new LoginPage(driver);
		empprepaymentpg=new EMPPrepaymentPage(driver);
		loginpage.login();
		empprepaymentpg.navigatetoprepayementPage();
		Thread.sleep(2000);
		
	}
	 @Test(priority=1)
	    public void verifyEmptyState() {
		 empprepaymentpg.selectyear("2024");
	     Assert.assertTrue(empprepaymentpg.isNoDataDisplayed(), "No data message not displayed!");
	    }
	 @Test(priority=2)
	    public void verifyYearFilter() throws InterruptedException {
		 String expectedYear = "2025";
		 empprepaymentpg.selectyear(expectedYear);
		 Thread.sleep(2000);  // Wait for table refresh

	        // Verify rows exist
	        Assert.assertTrue(empprepaymentpg.getrowCount() > 0, "Rows should be loaded");

	        // Verify every row contains year = 2025
	        boolean result = empprepaymentpg.verifyAllRowsYear(expectedYear);

	        Assert.assertTrue(result, "All rows should contain year " + expectedYear);
	    }
	 @Test(priority=3)
	 public void verifymonthfilter() throws InterruptedException {
		 String expectedmonth="August";
		
		 int expectedMonthNumber = empprepaymentpg.monthNameToNumber(expectedmonth);
		 String expectedMonthno = String.format("%02d", expectedMonthNumber); 
		 empprepaymentpg.selectmonthFilter(expectedmonth);
		 Thread.sleep(2000);
		 List<WebElement> dateCells = empprepaymentpg.getDateColumnValues();
		 for (WebElement cell : dateCells) {
		        String fullDate = cell.getText().trim();   // e.g. "08-08-2025 09:46 pm"

		        String monthFromDate = fullDate.substring(3, 5); // extract MM

		        Assert.assertEquals(
		                monthFromDate,
		                expectedMonthno,
		                "Date row contains wrong month: " + fullDate
		        );
		 }
	 }
	/* @Test(priority=4)
	    public void verifyRowHighlightOnSelection() throws InterruptedException {

	        // For example: click checkbox on 1st row
	        int rowIndex = 0;

	        empprepaymentpg.selectRow(rowIndex);
	        Thread.sleep(3500); // Wait for highlight animation

	       

	        // Approach 2 : verify highlight color
	        boolean highlighted = empprepaymentpg.isRowHighlighted(rowIndex);
	        //Assert.assertTrue(highlighted, "Row background should be highlighted (selected)");
	    }*/
	 @Test(priority=5)
	 public void validateviewactionbtnpage() throws InterruptedException {
		 String expecetddateeledata=empprepaymentpg.getfirstrowdateele();
		 String expectedamounteledata=empprepaymentpg.getfirstrowamteledata();
		 String expecteddeductmontheledata=empprepaymentpg.getmonthdeducteledata();
		 empprepaymentpg.clickActionButton(0);
		 Thread.sleep(2000);
		 String actual_dateeleinviewpage=empprepaymentpg.getdatetextelefromviewpage();
		 String actual_amountelefromviwpage=empprepaymentpg.getamtelefromviewpage();
		 String actual_deductmontheledatainviewpage=empprepaymentpg.getdeductedmonthelefromviewpage();
		 Assert.assertEquals(expecetddateeledata, actual_dateeleinviewpage,"dateeledata is not matched in viewpage");
		 Assert.assertEquals(expectedamounteledata,actual_amountelefromviwpage,"amounteledata is not matched in viewpage");
		 Assert.assertEquals(expecteddeductmontheledata,actual_deductmontheledatainviewpage,"deductmonth ele data is not matched in view page");
		 
	 }
	 
	 
}
