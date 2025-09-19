package com.violetis.Locators;
import org.openqa.selenium.By;
public class HomePageLocators {

    // ====== Main Menu Locators ======
    public static final By HR_FEATURES = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[1]/a");
    public static final By CRM = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[2]/a");
    public static final By MAIL = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[3]/a");
    public static final By RESOURCES = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[4]/a");
    public static final By PARTNER = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[5]/a");
    public static final By PRICING = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[6]/a");
    public static final By LOGIN = By.xpath("//*[@id=\"navbarContent\"]/div/div/a");

    // ===== Sub Menus =====
    public static final By HR_FEATURE_SUBMENUS = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[1]/ul/li/a");
    public static final By CRM_MENUS = By.xpath("//*[@id='navbarContent']/div/ul/li[2]/ul/li/a");
    public static final By MAIL_MENUS = By.xpath("//*[@id=\"navbarContent\"]/div/ul/li[3]/ul/li/a");
    public static final By Logo=By.xpath("/html/body/div/nav/div/a/img");
    public static final By Signupfree=By.linkText("Sign up for free trial");
    public static final By Reqdemo=By.linkText("Request Demo");
}