package com.violetis.Tests.ManagerPageTest;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPackage.LeavesPage;
import com.violetis.Utilities.ConfigReader;

public class LeavesTest extends BaseTest{
public LoginPage loginpage;
public LeavesPage Leavepg;
@BeforeClass
public void init() {
loginpage=new LoginPage(driver);
Leavepg=new LeavesPage(driver);
loginpage.login(ConfigReader.getProperty("managertestun"),ConfigReader.getProperty("managertestpswd"));
Leavepg.navigatetoleavespage();
}
@Test(priority=1)
public void validateHeaders() throws InterruptedException {
    List<String> expectedHeaders = Arrays.asList(
            "",
            "User",
            "Leave Type",
            "Start Date",
            "End Date",
            "Is Half Day",
            "Total Days"
    );

	for (String tab : Arrays.asList("All", "Pending", "Approved", "Rejected")) {
	
        Leavepg.clickTab(tab);
        Assert.assertEquals(
        		Leavepg.getTableHeaderNames(),
                expectedHeaders,
                "Header mismatch in " + tab + " tab"
        );
    }

   
}
@Test(priority=2)
public void validatePendingTabData() throws InterruptedException {
	Leavepg.clickTab("Pending");

    for (String status : Leavepg.getStatuses()) {
        Assert.assertEquals(status, "Pending",
                "Non-pending record found in Pending tab");
    }
}
@Test(priority=3)
public void validateApprovedTabData() throws InterruptedException {
	Leavepg.clickTab("Approved");

    for (String status : Leavepg.getStatuses()) {
        Assert.assertEquals(status, "Approved",
                "Non-approved record found in Approved tab");
    }
}
@Test(priority=4)
public void validateRejectedTabData() throws InterruptedException {
	Leavepg.clickTab("Rejected");

    for (String status : Leavepg.getStatuses()) {
        Assert.assertEquals(status, "Rejected",
                "Non-rejected record found in Rejected tab");
    }
}
}
