package com.violetis.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.violetis.Base.BaseTest;
import com.violetis.Pages.HomePage;
import com.violetis.Pages.SignUpPage;
import com.violetis.Utilities.DataProviderutils;
public class SignupDDTTest extends BaseTest{
	 @Test(dataProvider = "signupData", dataProviderClass = DataProviderutils.class)
	    public void testSignupWithExcelData(String email, String password, String name, String Phone,String expectedResult) {
	        HomePage homePage = new HomePage(driver);
	        homePage.clicksignupmenu();

	        SignUpPage signupPage = new SignUpPage(driver);
	        signupPage.enterName(name);
	        signupPage.enterEmail(email);
	        signupPage.enterPassword(password);
	        signupPage.enterPhoneNumber(Phone);
	       /* String actualUrl = signupPage.getCurrentUrl();

	        if (expectedResult.equalsIgnoreCase("success")) {
	            Assert.assertTrue(actualUrl.contains("welcome"),
	                    "Signup failed! Expected success but got: " + actualUrl);
	        } else {
	            Assert.assertTrue(actualUrl.contains("signup") || signupPage.getErrorMessage().length() > 0,
	                    "Signup passed unexpectedly with invalid data: " + email);
	        }*/
	    }
}
