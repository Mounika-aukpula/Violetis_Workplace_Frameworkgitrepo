package com.violetis.Tests.ManagerdashboardTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerDashboard.EMPstatusPage;
import com.violetis.Pages.ManagerPackage.AppreciationsPage;
import com.violetis.Utilities.ConfigReader;

public class EMPStatusTest extends BaseTest{
public LoginPage loginpage;
public EMPstatusPage statuspg;
public AppreciationsPage apppg;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	statuspg=new EMPstatusPage(driver);
	apppg=new AppreciationsPage(driver);
	loginpage.login(ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd"));
	
}
@Test
public void ValidatetheAppreciationscount() {
	int exp_appcount=statuspg.getappcount();
	apppg.navigatetoAppreciationpage();
	int act_appcount=apppg.getTotalRowCount();
	Assert.assertEquals(exp_appcount,act_appcount);
}
}
