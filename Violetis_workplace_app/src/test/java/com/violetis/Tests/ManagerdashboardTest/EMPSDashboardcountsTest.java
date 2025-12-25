package com.violetis.Tests.ManagerdashboardTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.HrDashboardPage.HRDashboardCountPage;
import com.violetis.Pages.ManagerDashboard.DashboardEMPcountPage;
import com.violetis.Pages.ManagerPackage.EmployeePage;
import com.violetis.Pages.ManagerPackage.LogoutPage;
import com.violetis.Utilities.ConfigReader;

public class EMPSDashboardcountsTest extends BaseTest{
public LoginPage loginpage;
public DashboardEMPcountPage empcountpg;
public EmployeePage emppage;
public HRDashboardCountPage hrcountpg;
public LogoutPage managerlogout;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	empcountpg=new DashboardEMPcountPage(driver);
	emppage=new EmployeePage(driver);
	hrcountpg=new HRDashboardCountPage(driver);
	managerlogout=new LogoutPage(driver);
}
@Test
public void validateempscounts() throws InterruptedException {
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
	int exp_totalempcount=Integer.parseInt(empcountpg.gettotalempscount());
	int exp_totalactemps=Integer.parseInt(empcountpg.getactiveempcount());
	int exp_totalinactempcount=Integer.parseInt(empcountpg.getinactiveempscount());
	int exp_totalempunderyoucount=Integer.parseInt(empcountpg.getunderyouempscount());
	System.out.println(exp_totalempcount);
	System.out.println(exp_totalactemps);
	System.out.println(exp_totalinactempcount);
	System.out.println(exp_totalempunderyoucount);
	emppage.navigatetoemployeepage();
	emppage.clickonactivetab();
	int act_totalempunderyoucount=emppage.getallrowscount();
	System.out.println(act_totalempunderyoucount);
	managerlogout.clickonlogoutbtn();
	loginpage.login(
	        ConfigReader.getProperty("hrusername"),
	        ConfigReader.getProperty("hrpassword")
	    );
	Thread.sleep(4000);
	int act_totalempscount=Integer.parseInt(hrcountpg.gettotalempscount());
	int act_totalactemps=Integer.parseInt(hrcountpg.gettotalactiveempscount());
	int act_totalinactemps=Integer.parseInt(hrcountpg.getinactemps());
	System.out.println(act_totalempscount);
	System.out.println(act_totalactemps);
	System.out.println(act_totalinactemps);
	Assert.assertEquals(exp_totalempcount, act_totalempscount);
	Assert.assertEquals(exp_totalactemps, act_totalactemps);
	Assert.assertEquals(exp_totalinactempcount, act_totalinactemps);
	Assert.assertEquals(exp_totalempunderyoucount, act_totalempunderyoucount);
}
}
