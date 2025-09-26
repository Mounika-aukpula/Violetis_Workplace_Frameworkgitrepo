package com.violetis.Tests;
import org.testng.Assert;
import com.violetis.Base.BaseTest;
import com.violetis.Pages.HomePage;
import com.violetis.Pages.SignUpPage;
import org.testng.annotations.Test;
public class SignupTest extends BaseTest {
	//@Test
   // public void testUserRegistration() {
        //log.info("===== Test: User Registration started =====");

        //SignUpPage signupPage = new SignUpPage(driver);

        // Fill registration form
        //signupPage.selectBusinessEmail();
        //signupPage.enterName("John");
        //signupPage.enterEmail("john@gmail.com");
        //signupPage.enterPassword("Password123");
        //signupPage.enterPhoneNumber("9876543210");
        //signupPage.acceptTerms();
        //signupPage.Signupnowbtn();

        // Example assertion (depends on your app behavior)
        //String currentUrl = loginPage.getCurrentUrl();
        //Assert.assertTrue(currentUrl.contains("dashboard") || currentUrl.contains("success"),
            //    "User registration did not redirect to expected page. Actual URL: " + currentUrl);

        //log.info("===== Test: User Registration completed successfully =====");
   // }

    @Test
    public void testSignUpWithGoogle() {
        log.info("===== Test: Sign up with Google started =====");
        HomePage homePage = new HomePage(driver);
        homePage.clicksignupmenu();

        SignUpPage signupage = new SignUpPage(driver);

        signupage.signUpWithGoogle();

        // Example: validate URL or title after Google redirect
        String title = signupage.getTitle();
        Assert.assertTrue(title.toLowerCase().contains("google"),
                "Sign up with Google did not navigate to Google page. Actual title: " + title);

        log.info("===== Test: Sign up with Google completed successfully =====");
    }
}
