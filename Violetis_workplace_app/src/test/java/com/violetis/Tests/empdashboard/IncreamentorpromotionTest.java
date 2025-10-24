package com.violetis.Tests.empdashboard;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.HRPage;

public class IncreamentorpromotionTest extends BaseTest{
	public LoginPage loginPage;
	public HRPage hrpg;
	@BeforeClass
	public void setUpPages() {
        loginPage = new LoginPage(driver);
        hrpg=new HRPage(driver);
	}
	@Test(priority=1)
	public void validateincordecreamentwithnoincorpromotions()
	{
		
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
