package com.violetis.Tests.EmployeePageTests;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.AttendencedetailsPage;
import com.violetis.Pages.employeePage.LogoutPage;
import com.violetis.Utilities.ConfigReader;
import com.violetis.Pages.ManagerPackage.ManagerAttendencedetailspage;
public class EmpAttendencedetailsTest extends BaseTest{
	public LoginPage loginpage;
	public AttendencedetailsPage empAttdetpg;
	public ManagerAttendencedetailspage managerAttpg;
	public LogoutPage emplogout;
	@BeforeClass
	public void navigatetoAttendencedetailspage() throws InterruptedException {
		loginpage=new LoginPage(driver);
		empAttdetpg=new AttendencedetailsPage(driver);
		managerAttpg=new ManagerAttendencedetailspage(driver);
		emplogout=new LogoutPage(driver);
		loginpage.login();
		empAttdetpg.navigatetoAttendencedetails();
		Thread.sleep(5000);
		
		
	}
/*	@Test(priority = 1)
	public void verifyAttendancetotalofficetimeandworkedtimeWithCalculatedValues() {

		 String expectedOfficeTime = empAttdetpg.calculateExpectedOfficeTime();
		 String actualOfficeTime = empAttdetpg.getdispalyedTotalOfficeTime();
		 System.out.println("Expected Office Time: " + expectedOfficeTime);
		 System.out.println("Actual Office Time: " + actualOfficeTime);

		    Assert.assertTrue(
		            actualOfficeTime.contains(expectedOfficeTime),
		            "❌ Total Office Time mismatch! Expected: " + expectedOfficeTime + " but found: " + actualOfficeTime
		    );

		    // ✅ Optionally validate worked time separately
		    String actualWorkedTime = empAttdetpg.getDisplayedTotalWorkedTime();
		    Assert.assertTrue(
		            actualWorkedTime != null && !actualWorkedTime.isEmpty(),
		            "❌ Total Worked Time not found or invalid!"
		    );

		    System.out.println("✅ Total Office Time and Worked Time validation passed.");
	}
	@Test(priority = 2)
	public void verifyPresentAndWorkingDaysMatchWithTable() {
	    int cardPresentDays = empAttdetpg.getPresentDaysFromCard();
	    int cardWorkingDays = empAttdetpg.getWorkingDaysFromCard();

	    int tableRowCount = empAttdetpg.getRowCount();
	    int presentRowCount = empAttdetpg.getPresentDayscountFromTable();

	    System.out.println("Card Present Days: " + cardPresentDays);
	    System.out.println("Table Present Rows: " + presentRowCount);
	    System.out.println("Card Working Days: " + cardWorkingDays);
	    System.out.println("Table Rows Count: " + tableRowCount);

	    Assert.assertEquals(cardWorkingDays, tableRowCount,
	            "❌ Working Days mismatch! Expected from card: " + cardWorkingDays + ", but found in table: " + tableRowCount);

	    Assert.assertEquals(cardPresentDays, presentRowCount,
	            "❌ Present Days mismatch! Expected from card: " + cardPresentDays + ", but found in table: " + presentRowCount);

	    System.out.println("✅ Present & Working Days validated successfully with table rows.");
	}
	@Test(priority = 3)
	public void verifyLateAttendanceValue() {
	    int lateCount = empAttdetpg.getLateCountFromTable();
	    String lateSummary = empAttdetpg.getLateValuefromattendencedetails();

	    if (lateCount == 0) {
	        // ✅ No rows → late value should be "--"
	        Assert.assertEquals(lateSummary, "--", 
	            "❌ Expected 'Late' summary to be '--' when no late rows are present, but found: " + lateSummary);
	        System.out.println("✅ No Late Attendance rows found. Late summary is correctly '--'.");
	    } else {
	        // ✅ Rows exist → summary should not be "--"
	        Assert.assertNotEquals(lateSummary, "--", 
	            "❌ Late summary shows '--' despite rows being present!");
	        System.out.println("✅ Late Attendance rows found. Late summary displayed correctly: " + lateSummary);
	    }
	}*/
	@Test(priority = 4,description = "Validate Employee Attendance matches Manager Attendance for the same employee")
	public void verifyEmployeeAndManagerAttendanceMatch() throws InterruptedException {
		String empname="Mounika A";
		 List<Map<String, String>> empData = empAttdetpg.getEmployeeAttendanceTableData();
		
		 System.out.println("===== 🧍 Employee Attendance Data =====");
		    for (Map<String, String> row : empData) {
		        System.out.println(row);
		    }
		    emplogout.clickonlogout();
		    Thread.sleep(2000);
		 // Step 2:  Login as Manager give Appreciation count and logout
			loginpage.login(
			        ConfigReader.getProperty("manageruname"),
			        ConfigReader.getProperty("managerpass")
			    );
			managerAttpg.naviagettoattendencedetailspage();
			managerAttpg.selectectemployee(empname);
			Thread.sleep(2000);
			
			//🔹 Step 2: Fetch data from Manager module for the same employee
		    List<Map<String, String>> managerData = managerAttpg.fetchAttendanceTableData();
		    System.out.println("===== 🧍 manager Attendance Data =====");
		    for (Map<String, String> row : managerData) {
		        System.out.println(row);
		    }
		 // 🔹 Step 3: Convert lists to maps (keyed by Date) for easier comparison
		    Map<String, Map<String, String>> empMap = new LinkedHashMap<>();
		    for (Map<String, String> row : empData) {
		        empMap.put(row.get("Date"), row);
		    }

		    Map<String, Map<String, String>> mgrMap = new LinkedHashMap<>();
		    for (Map<String, String> row : managerData) {
		        mgrMap.put(row.get("Date"), row);
		    }

		    // 🔹 Step 4: Compare both based on dates
		    for (String date : empMap.keySet()) {
		        Map<String, String> empRow = empMap.get(date);
		        Map<String, String> mgrRow = mgrMap.get(date);

		        if (mgrRow == null) {
		            System.out.println("⚠️ Manager data missing for date: " + date);
		            Assert.fail("Manager attendance missing for date: " + date);
		            continue;
		        }

		        // Compare field by field
		        for (String key : empRow.keySet()) {
		            String empValue = empRow.get(key);
		            String mgrValue = mgrRow.get(key);

		            if (!empValue.equalsIgnoreCase(mgrValue)) {
		                System.out.println("❌ Mismatch on date " + date + " → " + key +
		                        " | Employee: " + empValue + " | Manager: " + mgrValue);
		                Assert.fail("Mismatch on " + date + " for " + key);
		            }
		        }
		    }

		   
	}
}
