package com.violetis.Pages;
import org.openqa.selenium.WebDriver;

import com.violetis.Base.BasePage;
import com.violetis.Locators.SignUpPageLocators;
public class SignUpPage extends BasePage{
	public SignUpPage(WebDriver driver) {
        super(driver);
    }
	public void selectBusinessEmail() {
        click(SignUpPageLocators.Bussinessemailradio);
    }

    public void selectPersonalEmail() {
        click(SignUpPageLocators.Personalemairadio);
    }

    public void enterName(String name) {
        type(SignUpPageLocators.Namefield, name);
    }

    public void enterEmail(String email) {
        type(SignUpPageLocators.Emailfield, email);
    }

    public void enterPassword(String password) {
        type(SignUpPageLocators.Passwordfield, password);
    }

    public void enterPhoneNumber(String phone) {
        type(SignUpPageLocators.Phonenumberfield, phone);
    }

    public void acceptTerms() {
        click(SignUpPageLocators.Termscheckbox);
    }

    public void clickSignupnowbtn() {
        click(SignUpPageLocators.Signupnowbtn);
    }

    public void signUpWithGoogle() {
        click(SignUpPageLocators.signupwithgoogle);
    }

    public void signUpWithApple() {
        click(SignUpPageLocators.signupwithapple);
    }

    public void signUpWithFacebook() {
        click(SignUpPageLocators.signupwithfb);
    }

    public void signUpWithTwitter() {
        click(SignUpPageLocators.signupwithtwitter);
    }

    // Example of composite action (filling the form)
    public void registerNewUser(String name, String email, String password, String phone) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        enterPhoneNumber(phone);
        acceptTerms();
        clickSignupnowbtn();
    }

}
