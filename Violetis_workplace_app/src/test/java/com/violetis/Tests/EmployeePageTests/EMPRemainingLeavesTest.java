package com.violetis.Tests.EmployeePageTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.RemainingLeavesPage;
import com.violetis.Pages.employeePage.EMPLeavePage;
public class EMPRemainingLeavesTest extends BaseTest {
	public LoginPage loginpage;
	public RemainingLeavesPage remleavespg;
	public EMPLeavePage empleavepg;
	@BeforeClass
	public void navigatetoRemainingleaves() {
		loginpage=new LoginPage(driver);
		remleavespg=new RemainingLeavesPage(driver);
		empleavepg=new EMPLeavePage(driver);
		loginpage.login();
		
		
		
		
	}
	@Test(priority=1)
	public void verifyLeaveDecreaseWithApprovedTab() throws InterruptedException {
	    
	    // Step 1: Expected default leave counts
		remleavespg.navigatetoremaingleavepage();
		Thread.sleep(2000);
		remleavespg.selectyear("2025");
		Thread.sleep(2000);
	    Map<String, Integer> expected = new HashMap<>();
	    expected.put("Annual holiday", 24);
	    expected.put("Sick Leave", 6);
	    expected.put("Holidays India", 20);
	    expected.put("Unpaid Leaves", 25);
	    expected.put("Maternity Leave", 10);
	    expected.put("Paternity Leave", 10);
	    expected.put("CONDITIONAL", 3);

	    // Step 2: Get leaves that decreased
	    Map<String, Integer> decreasedLeaves = remleavespg.getDecreasedLeaves(expected);

	    // Step 3: Validate those in Approved tab
	    if (decreasedLeaves.isEmpty()) {
	        System.out.println("✅ All leave counts are as expected. No approvals to verify.");
	    } else {
	    	remleavespg.clickondasboardanchor();
	    	Thread.sleep(2000);
	    	empleavepg.navigatetoLeavebutton();
	    	empleavepg.approvedbtn();
	    	Thread.sleep(2000);

	        for (Map.Entry<String, Integer> entry : decreasedLeaves.entrySet()) {
	            String leaveType = entry.getKey();
	            int expectedApprovedCount = entry.getValue();

	            long actualApprovedCount= empleavepg.getApprovedLeaveCount(leaveType);

	            System.out.println("🔍 Validating " + leaveType +
	                    " → Expected approved count: " + expectedApprovedCount +
	                    " | Actual: " + actualApprovedCount);

	            Assert.assertEquals(actualApprovedCount, expectedApprovedCount,
	                    "Mismatch in approved leave count for: " + leaveType);
	        }
	    }
}
}