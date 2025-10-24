package com.violetis.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.LoginPageLocators;
import com.violetis.Utilities.ConfigReader;
import com.violetis.Utilities.WaitUtils;


public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
        super(driver);
    }
	// Enter username or phone number (from config.properties)
    public void enterUserOrPhNo() {
    	WaitUtils.waitForElementVisible(driver, LoginPageLocators.emailorph, 20)
        .sendKeys(ConfigReader.getProperty("uname"));
        log.info("Entered username: {}");
    }

    // Enter password (from config.properties)
    public void enterPassword() {
    	WaitUtils.waitForElementVisible(driver, LoginPageLocators.password, 10)
        .sendKeys(ConfigReader.getProperty("password"));
        log.info("Entered password");
    }

    // Click login button
    public void clickLoginBtn() {
    	WaitUtils.waitForElementVisible(driver, LoginPageLocators.loginbtn, 10).click();
        log.info("Clicked on Login button");
    }

    // Optional: click password visibility icon
    public void clickPasswordSeenIcon() {
        click(LoginPageLocators.pswdseenicon);
        log.info("Clicked on password visibility icon");
    }

    // Perform login using credentials from config.properties
    public void login() {
        log.info("Performing login using credentials from config.properties");
        enterUserOrPhNo();
        enterPassword();
        clickLoginBtn();
    }

    // Perform login using custom credentials (for negative tests)
    public void login(String username, String password) {
        log.info("Performing login with custom credentials: {}", username);
        WaitUtils.waitForElementVisible(driver, LoginPageLocators.emailorph, 15);
        type(LoginPageLocators.emailorph, username);
        WaitUtils.waitForElementVisible(driver, LoginPageLocators.password, 15);
        type(LoginPageLocators.password, password);
        clickLoginBtn();
    }

    // Get login error message (replace with actual error locator if exists)
    public String getLoginErrorMessage(By errorLocator) {
        String msg = getText(errorLocator);
        log.info("Login error message: {}", msg);
        return msg;
    }
}
