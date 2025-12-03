package com.violetis.Tests.empdashboard;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.HRPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
public class IncreamentorpromotionTest extends BaseTest{
	public LoginPage loginPage;
	public HRPage hrpg;
	public EMPDashboardPage empdbpg;
	@BeforeClass
	public void setUpPages() {
        loginPage = new LoginPage(driver);
        hrpg=new HRPage(driver);
        empdbpg=new EMPDashboardPage(driver);
	}
	@Test(priority=1)
	public void validateincordecreamentwithnoincorpromotions()
	{
		loginPage.login("mounika.aukpula08@gmail.com", "Mounika@1997");
		String expected_text="No active increments or promotions at this time";
		String actual_text=empdbpg.getincorprommodulewithnoprom();
		Assert.assertEquals(actual_text, expected_text);
		empdbpg.logout();
		
	}
	@Test(priority=2)
	public void AddincreamentfromHR() throws InterruptedException {
		log.info("Login As Hr and give Promotion or increament to particular employee");
		loginPage.login("testing@violetis.ai","VioletisTesting@2025");
		hrpg.fillincreamentform("Increment","mounikaap","6","Oct","2025","24","Test");
		
	}
	public void validateafterassigningincorpromotiontoemp() {
		
	}
}
