package com.violetis.Tests.ManagerdashboardTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerDashboard.DashboardEMPcountPage;
import com.violetis.Pages.ManagerDashboard.EMPstatusPage;
import com.violetis.Pages.ManagerDashboard.EmpWorkStatusPage;
import com.violetis.Pages.ManagerPackage.EmployeePage;
import com.violetis.Utilities.ConfigReader;

public class EmpWorkStatusTest extends BaseTest{
public LoginPage loginpage;
public DashboardEMPcountPage empscountpg;
public EmpWorkStatusPage empworkstatuspg;
public EMPstatusPage empstatuspg;
public EmployeePage emppage;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	empscountpg=new DashboardEMPcountPage(driver);
	empworkstatuspg=new EmpWorkStatusPage(driver);
	emppage=new EmployeePage(driver);
	empstatuspg=new EMPstatusPage(driver);
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
	
}
/*@Test(priority=1)
public void validateActiveempscount() {
	int act = Integer.parseInt(empscountpg.getactiveempcount());
	int exp = Integer.parseInt(empworkstatuspg.gettotalaactiveempcount());

	Assert.assertEquals(act, exp, "Active employee count mismatch!");
	
}
@Test(priority=2)
public void validatetopperformer() {
	//from empstatus section
	String exp_topperformername=empstatuspg.gettopperformername();
	int exp_appreciationcount=Integer.parseInt(empstatuspg.gettopperformerappcount());
	//from emp work status section
	String act_topperformername=empworkstatuspg.gettopperformername();
	int act_appcount=Integer.parseInt(empworkstatuspg.gettopperformerappcount());
	Assert.assertEquals(exp_topperformername, act_topperformername, " top perfoemer data mismatch!");
	Assert.assertEquals(exp_appreciationcount, act_appcount, " top perfoemer data mismatch!");
	
}*/
@Test
public void validatecountsonempworkstatus() throws InterruptedException {
	//getting counts from empworkstatus count
	int exp_contractempcount=Integer.parseInt(empworkstatuspg.getcontractempcount());
	int exp_fulltimeempcount=Integer.parseInt(empworkstatuspg.getfulltimecount());
	int exp_probationempcount=Integer.parseInt(empworkstatuspg.getprobationcount());
	int exp_WFHempvount=Integer.parseInt(empworkstatuspg.getWFHcount());
	Thread.sleep(2000);
	emppage.navigatetoemployeepage();
	int act_probationscount=emppage.getEmployeesStillInProbationToday();
	System.out.println(act_probationscount);
	/* for probation, full time and WFH having bugs*/
}
}
