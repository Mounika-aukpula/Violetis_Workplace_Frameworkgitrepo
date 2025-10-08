package com.violetis.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Utilities.ConfigReader;
public class LoginTest extends BaseTest {
@Test(priority=1)
public void TestempLogin()
{
	log.info("employee login started****");
	LoginPage login=new LoginPage(driver);
	login.login();
	
	
}
}
