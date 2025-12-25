package com.violetis.Tests.ManagerdashboardTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.violetis.Pages.ManagerDashboard.EMPSByDeptpage;
import com.violetis.Utilities.ConfigReader;

public class EMPSbyDeptTest extends BaseTest{
public LoginPage loginpage;
public EMPSByDeptpage empsdeptpage;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	empsdeptpage=new EMPSByDeptpage(driver);
	loginpage.login(ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd"));
}
@Test(priority=1)
public void verifyBarChartIsDisplayed() {
    Assert.assertTrue(
    		empsdeptpage.isGraphDisplayed(),
        "Bar chart canvas is not displayed"
    );
}

@Test(priority = 2)
public void verifycharttitle() {
	String exp_title="Employees By Department";
	String act_title=empsdeptpage.getcharttitle();
	Assert.assertTrue(exp_title.equalsIgnoreCase(act_title));
   
}
@AfterClass
public void tearDown() {
    driver.quit();
}
}
