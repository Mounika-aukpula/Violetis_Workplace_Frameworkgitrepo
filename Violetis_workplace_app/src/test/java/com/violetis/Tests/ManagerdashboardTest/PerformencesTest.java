package com.violetis.Tests.ManagerdashboardTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerDashboard.PerformencesPage;
import com.violetis.Utilities.ConfigReader;

public class PerformencesTest extends BaseTest{
public LoginPage loginpage;
public PerformencesPage performencespg;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	performencespg=new PerformencesPage(driver);
	loginpage.login(ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd"));
	
}
@Test(priority=1)
public void verifyPerformanceGraphIsDisplayed() {
    Assert.assertTrue(
    		performencespg.isGraphDisplayed(),
        "Bar chart canvas is not displayed"
    );
}

@Test(priority = 2)
public void verifygraphtitle() {
	String exp_title="Performance";
	String act_title=performencespg.getcharttitle();
	Assert.assertTrue(exp_title.equalsIgnoreCase(act_title));
   
}
@AfterClass
public void teatdown() {
	driver.quit();
}
}
