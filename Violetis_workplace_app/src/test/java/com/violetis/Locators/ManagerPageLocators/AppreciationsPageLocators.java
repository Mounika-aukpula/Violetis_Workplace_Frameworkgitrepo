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


}
