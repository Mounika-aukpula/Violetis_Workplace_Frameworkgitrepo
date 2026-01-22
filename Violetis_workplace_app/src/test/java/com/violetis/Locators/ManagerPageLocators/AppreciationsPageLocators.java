package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class AppreciationsPageLocators {
public static final By Appreciationsmenu=By.xpath("(//span[contains(text(),'Appreciations')])[1]");
public static final By appreciations_submenu=By.xpath("(//span[contains(text(),'Appreciations')])[2]");
public static final By allrows=By.xpath("//tbody//tr");
public static final By lastpagenum=By.xpath("(//li[contains(@class,'ant-pagination-item ant-pagination-item')])[last()]/a");
public static final By selectuserdrpdown=By.xpath("(//input[contains(@id,'rc_select')])[1]");
public static final By selectuserdrpdownoptions=By.xpath("//div[contains(@class,'ant-select-item ant-select')]");
public static final By yearpicker=By.xpath("//div[@class='ant-picker ant-picker-range custom-select css-gaz7ss ant-picker-focused']");
public static final By datepickersoptions=By.xpath("//div[@class='ant-picker-presets']//li");
public static final By pagenavigationnextbtn=By.xpath("(//button[@class='ant-pagination-item-link'])[2]");
public static final By selectawarddrpdown=By.xpath("(//span[contains(text(),'Select Award...')])[1]");
public static final By awarddrpeles=By.xpath("//div[@class='rc-virtual-list-holder-inner']//div/div");
//table locators
public static final By tableheaders=By.xpath("//thead/tr/th[position() >= 2]");
public static final By usernames=By.xpath("//div[@class='profile-info']/span");
public static final By designations=By.xpath("//div[@class='profile-info']/p");
public static final By dateeles=By.xpath("//tr//td[3]");
public static final By awardeles=By.xpath("//tr//td[4]");
public static final By priceamteles=By.xpath("//tr//td[5]");
public static final By viewbtns=By.xpath("//tr//td[7]/div//div[1]");
public static final By editbtns=By.xpath("//tr//td[7]/div//div[2]");
public static final By delbtns=By.xpath("//tr//td[7]/div//div[3]");
//Add new appreciations btn locators
public static final By Addnewappbtn=By.xpath("//span[normalize-space()='Add New Appreciation']");
public static final By appuserdrpdown=By.xpath("//input[@id='form_item_user_id']");
public static final By datepicketdrpdown=By.xpath("//input[@id='form_item_date']");
public static final By dateele=By.xpath("//div[@class='ant-picker-cell-inner']");
public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
public static final By ok_btn_datepicker=By.xpath("//span[normalize-space()='Ok']");
public static final By appuserdrpoptions=By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div");
public static final By appawarddrpdown=By.xpath("//input[@id='form_item_award_id']");
public static final By appawrddrpoptions=By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[5]/div");
public static final By priceinputbox=By.xpath("//input[@id='form_item_price_amount']");
public static final By addpricegivenbtn=By.xpath("//span[normalize-space()='Add Price Given']");
public static final By pricegiveninputbox=By.xpath("//input[@id='form_item_price_given']");
public static final By descriptionbox=By.xpath("//textarea[@id='form_item_description']");
public static final By createbtn=By.xpath("//span[contains(text(),'Create')]");
public static final By acctnodrpdown=By.xpath("//input[@id='form_item_account_id']");
public static final By actnooptions=By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div");

//error eles for fields
public static final By userfielderrormsg=By.xpath("//div[@class='ant-form-item-explain-error']");


}
