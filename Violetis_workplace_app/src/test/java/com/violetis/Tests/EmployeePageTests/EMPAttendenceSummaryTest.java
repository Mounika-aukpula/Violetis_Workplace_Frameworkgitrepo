package com.violetis.Tests.EmployeePageTests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.AttendencesummaryPage;
import com.violetis.Pages.employeePage.AttendencedetailsPage;
public class EMPAttendenceSummaryTest extends BaseTest{
	public LoginPage loginpage;
	public AttendencesummaryPage Attsumpg;
	public AttendencedetailsPage Attdetpg;
	@BeforeClass
	public void navigatetoattendencesummary() {
		loginpage=new LoginPage(driver);
		Attsumpg=new AttendencesummaryPage(driver);
		Attdetpg=new AttendencedetailsPage(driver);
		loginpage.login();
		Attsumpg.navigaettoattendencesummarypage();
	}
	

	 @Test
	    public void verifyAttendanceSummaryMatchesDetails() throws InterruptedException {
		 

	        // 1️⃣ Extract both mappings
	        Map<String, String> summaryMap = Attsumpg.getDateStatusMap();
	        System.out.println("Summary Map: " + summaryMap);
	        Attsumpg.gobacktodashboard();
	        Attdetpg.navigatetoAttendencedetails();
	        Thread.sleep(4000);
	     // Step 2: Fetch Details Page Map (Day → Status)
	        Map<String, String> detailsMap = Attdetpg.getAllDateStatusMap();
	        // Step 3: Compare summary and detail using mapping rules
	        for (String day : summaryMap.keySet()) {
	            String summaryStatus = summaryMap.get(day);
	            String detailsStatus = detailsMap.get(day);
	            // Skip future dates where summary status is "Unknown"
	            if (summaryStatus.equalsIgnoreCase("Unknown")) {
	                System.out.println("Skipping future date comparison for day: " + day);
	                continue;
	            }

	            // If summary shows On Leave → details should show Absent
	            if (summaryStatus.equalsIgnoreCase("On Leave")) {
	                Assert.assertEquals(detailsStatus, "Absent",
	                    "Mismatch on date " + day + ": Summary shows On Leave, Expected Details: Absent, Actual Details: " + detailsStatus);
	            } 
	            // If summary shows Absent → details should show Not Marked
	            else if (summaryStatus.equalsIgnoreCase("Absent")) {
	                Assert.assertEquals(detailsStatus, "Not Marked",
	                    "Mismatch on date " + day + ": Summary shows Absent, Expected Details: Not Marked, Actual Details: " + detailsStatus);
	            } 
	            // All other statuses must match
	            else {
	                Assert.assertEquals(detailsStatus, summaryStatus,
	                    "Mismatch on date " + day + ": Summary: " + summaryStatus + ", Details: " + detailsStatus);
	            }
	        }
	    }
	        
	        
}