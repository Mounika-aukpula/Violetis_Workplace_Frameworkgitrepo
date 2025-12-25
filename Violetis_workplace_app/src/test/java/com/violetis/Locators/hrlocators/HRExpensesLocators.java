package com.violetis.Locators.hrlocators;

import org.openqa.selenium.By;

import com.violetis.Utilities.WaitUtils;

public class HRExpensesLocators {
//counts locators
public static final By totalempcount=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[1]");
public static final By totalactemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[2]");
public static final By totalinactemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[3]");
public static final By totalempsunderyou=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[4]");

public static final By finance_btn=By.xpath("//span[contains(text(),'Finance')]");
public static final By expenses_submenu=By.xpath("//span[contains(text(),'Expenses')]");
public static final By selectexpensetyedrpdown=By.xpath("//input[@id='rc_select_11']");
public static final By selectuserdrpdown=By.xpath("//*[@id='rc_select_12']");
public static final By allrows=By.xpath("//tbody//tr");

//table ele
public static final By usernamecoleles=By.xpath("//span[@class='name']");
public static final By dateeles=By.xpath("//td[3]");
public static final By expensetypeeles=By.xpath("//td[4]");
public static final By updatestatusbtn=By.xpath("//td[7]/button[1]");
//updateexpense status page
public static final By paymentstatusdrpdown=By.xpath("//span[normalize-space()='Right Now']");
public static final By datetimepicker=By.xpath("//div[@class='ant-picker css-gaz7ss']");
public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
public static final By date_picker_ok_btn=By.xpath("//span[normalize-space()='Ok']");
public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
public static final By selectactdrpdownbox=By.xpath("//div[@class='ant-select ant-select-in-form-item css-gaz7ss ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']");
public static By accountoption(String acttype) {
    return By.xpath("//div[@label='" + acttype + "']");
}
public static final By updatebtn=By.xpath("//span[contains(text(),'Update')]");
public static final By rejbtn=By.xpath("//label[@class='ant-radio-button-wrapper ant-radio-button-wrapper-in-form-item css-gaz7ss']//span[2]");

}