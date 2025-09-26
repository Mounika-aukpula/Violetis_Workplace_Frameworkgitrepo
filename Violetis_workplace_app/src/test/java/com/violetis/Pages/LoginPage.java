package com.violetis.Pages;

import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.LoginPageLocators;


public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
        super(driver);
    }
public void enteruserorphno(String lgusername) {
	click(LoginPageLocators.emailorph);
}
public void enterpassword(String lgpassword)
{
	click(LoginPageLocators.password);
}
public void clickloginbtn()
{
	click(LoginPageLocators.loginbtn);
}

//Action methods
public void login(String lgusername,String lgpassword)
{
enteruserorphno(lgusername);
enterpassword(lgpassword);
clickloginbtn();
}
}
