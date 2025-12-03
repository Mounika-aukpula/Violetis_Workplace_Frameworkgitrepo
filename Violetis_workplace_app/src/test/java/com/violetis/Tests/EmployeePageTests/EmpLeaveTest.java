package com.violetis.Tests.EmployeePageTests;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EMPLeavePage;

public class EmpLeaveTest extends BaseTest {
	public LoginPage loginpage;
	public EMPLeavePage empleavepg;
	@BeforeClass
	public void NavigatetoLeavesmodule() throws InterruptedException {
		loginpage=new LoginPage(driver);
		empleavepg=new EMPLeavePage(driver);
		loginpage.login();
		empleavepg.navigatetoLeavebutton();
		Thread.sleep(2000);
		
	}
	/*@Test(priority = 1)
	public void verifyAllTabShowsAllLeaves() {
	    Assert.assertTrue(empleavepg.clickTabAndVerifyStatus("All"), "All tab validation failed!");
	}

	@Test(priority = 2)
	public void verifyPendingTabShowsOnlyPendingLeaves() {
	    Assert.assertTrue(empleavepg.clickTabAndVerifyStatus("Pending"), "Pending tab validation failed!");
	}

	@Test(priority = 3)
	public void verifyApprovedTabShowsOnlyApprovedLeaves() {
	    Assert.assertTrue(empleavepg.clickTabAndVerifyStatus("Approved"), "Approved tab validation failed!");
	}

	@Test(priority = 4)
	public void verifyRejectedTabShowsOnlyRejectedLeaves() {
	    Assert.assertTrue(empleavepg.clickTabAndVerifyStatus("Rejected"), "Rejected tab validation failed!");
	}
	*//*
	@Test(priority = 5, description = "Verify Month, Year, and Leave Type filters")
	public void verifyFilters_Month_Year_LeaveType() throws InterruptedException {
	   
		driver.navigate().refresh();

	    // 1️⃣ Select Month filter and verify
	   // leavePage.selectMonth("August");
	    //Assert.assertTrue(empleavepg.verifyMonthFilter("August"), "Month filter validation failed!");

	    // 2️⃣ Select Year filter and verify
		empleavepg.selectyear("2025");
	    Assert.assertTrue(empleavepg.verifyYearFilter("2025"), "Year filter validation failed!");

	    // 3️⃣ Select Leave Type filter and verify
	    empleavepg.selectleavetype("Sick Leave");
	    Thread.sleep(2000);
	    Assert.assertTrue(empleavepg.verifyLeaveTypeFilter("Sick Leave"), "Leave Type filter validation failed!");

	    System.out.println("✅ Filters verified successfully: Month=November, Year=2025, Type=Sick Leave");
	}
	@Test(priority = 6)
    public void verifyActionIconsVisibility() {
		  List<WebElement> rows = empleavepg.getAllLeaveRows();
		    System.out.println("✅ Found " + rows.size() + " leave rows.");

		    for (WebElement row : rows) {
		        String status = empleavepg.getLeaveStatus(row).toLowerCase();
		        System.out.println("📘 Checking row with status: " + status);

		        boolean viewVisible = empleavepg.isActionVisibleForRow(row, "view");
		        boolean editVisible = empleavepg.isActionVisibleForRow(row, "edit");
		        boolean deleteVisible = empleavepg.isActionVisibleForRow(row, "delete");

		        switch (status) {
		            case "pending":
		                Assert.assertTrue(viewVisible, "View should be visible for Pending status");
		                Assert.assertTrue(editVisible, "Edit should be visible for Pending status");
		                Assert.assertTrue(deleteVisible, "Delete should be visible for Pending status");
		                break;

		            case "approved":
		            case "rejected":
		                Assert.assertTrue(viewVisible, "View should be visible for " + status + " status");
		                Assert.assertFalse(editVisible, "Edit should NOT be visible for " + status + " status");
		                Assert.assertFalse(deleteVisible, "Delete should NOT be visible for " + status + " status");
		                break;

		            default:
		                System.out.println("⚠️ Unknown status: " + status);
		        }
		    }
    }*/

   @Test(priority = 7)
    public void verifyViewAction() throws InterruptedException {
    	
    	List<WebElement> rows = empleavepg.getAllLeaveRows();
        Assert.assertTrue(rows.size() > 0, "No rows found!");

        WebElement firstRow = rows.get(0);
        // Step 1: Get details from the table row
        Map<String, String> tableData = empleavepg.getLeaveDetailsFromRow(firstRow);
        System.out.println("Table Data: " + tableData);
        Thread.sleep(2000);
        // Step 2: Click on “View”
        empleavepg.clickViewOnFirstRow();
       Thread.sleep(200);
    // Step 3: Get details from the View popup
       Map<String, String> viewData = empleavepg.getLeaveDetailsFromViewactionbtn();
       System.out.println("View Popup Data: " + viewData);

       // Step 4: Compare table and view data
       Assert.assertEquals(viewData.get("Name"), tableData.get("Name"), "Employee name mismatch!");
       Assert.assertEquals(viewData.get("LeaveType"), tableData.get("LeaveType"), "Leave type mismatch!");
       Assert.assertEquals(viewData.get("FromDate"), tableData.get("FromDate"), "From date mismatch!");
       Assert.assertEquals(viewData.get("ToDate"), tableData.get("ToDate"), "To date mismatch!");
       Assert.assertEquals(viewData.get("HalfDay"), tableData.get("HalfDay"), "Half day mismatch!");
       Assert.assertEquals(viewData.get("Status"), tableData.get("Status"), "Status mismatch!");

       System.out.println("✅ View popup validated successfully with table data.");
        
    }

  /*  @Test(priority = 8)
    public void verifyEditAction() {
        for (WebElement row : empleavepg.getAllLeaveRows()) {
            if (empleavepg.getLeaveStatus(row).equalsIgnoreCase("Pending")) {
            	empleavepg.clickAction(row, "edit");
                // perform edit and verify update
                break;
            }
        }
    }

    @Test(priority = 9)
    public void verifyDeleteAction() {
        
        for (WebElement row : empleavepg.getAllLeaveRows()) {
            if (empleavepg.getLeaveStatus(row).equalsIgnoreCase("Pending")) {
            	empleavepg.clickAction(row, "delete");
                // handle alert and verify removal
                driver.switchTo().alert().accept();
                break;
            }
        }
    }
	*/
}
