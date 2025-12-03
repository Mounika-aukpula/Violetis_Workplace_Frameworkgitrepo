package com.violetis.Tests.empdashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.HRPage;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.Policypage;
import com.violetis.Pages.employeedashboardpage.WeekendandholidayPage;
public class PolicyTest extends BaseTest{
	public Policypage policypg;
	public HRPage hrpage;
	@BeforeMethod
    public void loginAndSetupDashboard() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        
        hrpage=new HRPage(driver);
        policypg=new Policypage(driver);
         }
@Test(priority=1,description="create a new policy from hr")
public void verfifylatestpolicydiplayed() {
	
}
}
