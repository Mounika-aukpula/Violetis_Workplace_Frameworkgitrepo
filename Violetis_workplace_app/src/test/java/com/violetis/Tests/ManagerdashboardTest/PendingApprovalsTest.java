package com.violetis.Tests.ManagerdashboardTest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerDashboard.PendingApprovalsPage;
import com.violetis.Pages.ManagerPackage.LeavesPage;
import com.violetis.Utilities.ConfigReader;

public class PendingApprovalsTest extends BaseTest{
public LoginPage loginpage;
public LeavesPage leavepg;
public PendingApprovalsPage pendingapppg;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	leavepg=new LeavesPage(driver);
	pendingapppg=new PendingApprovalsPage(driver);
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
}
/*@Test
public void validaterowcountbtn() throws InterruptedException {
	pendingapppg.clickonleavesbtn();
	int exp_leaverowcount=pendingapppg.getrowcountbtndata();
	int act_leaverowcount=pendingapppg.getallrowscount();
	Assert.assertEquals(exp_leaverowcount, act_leaverowcount);
	Thread.sleep(2000);
	//validations on expenses count
	pendingapppg.clickonexpensesbtn();
	int exp_expenseserowcount=pendingapppg.getrowcountbtndata();
	int act_expenrowcount=pendingapppg.getallrowscount();
	Assert.assertEquals(exp_expenseserowcount, act_expenrowcount);
}*/
@Test
public void validateLeavesdata() throws InterruptedException {
	pendingapppg.clickonleavesbtn();
	Map<String, String> pendingMap = pendingapppg.mapPendingApprovals();
	leavepg.navigatetoleavespage();
	Thread.sleep(2000);
	leavepg.clickonpendingtab();
	Map<String, String> leaveMap = leavepg.mapUserToLeaveDates();
	for (String user : pendingMap.keySet()) {
	    Assert.assertEquals(
	        pendingMap.get(user),
	        leaveMap.get(user),
	        "Date mismatch for user: " + user
	    );
}
}
}
