package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class EmployeePageLocators {
public static final By employeesmenu=By.xpath("(//span[contains(text(),'Employees')])[1]");
public static final By employeessubmenu=By.xpath("(//span[contains(text(),'Employees')])[2]");
//tabs
public static final By activetab=By.xpath("(//div[@class='ant-tabs-tab-btn'])[4]");
public static final By allrows=By.xpath("//tbody//tr");
public static final By alltab=By.xpath("(//div[@class='ant-tabs-tab-btn'])[3]");


//table locators
public static final By allrowsviewbtns=By.xpath("//tbody//tr//td[9]/button");
public static final By allrowsusernames=By.xpath("//div[@class='profile-widget']/div/span");
public static final By allrowsdesignatoons=By.xpath("//div[@class='profile-widget']/div/span");

//viewbtn locators
public static final By workinfotab=By.xpath("//span[contains(text(),'Work Info')]");
public static final By probation_startdate=By.xpath("(//tr[@class='ant-descriptions-row'])[8]/td[1]//span");
public static final By probation_enddate=By.xpath("(//tr[@class='ant-descriptions-row'])[8]/td[2]//span");
public static final By closebtn=By.xpath("//span[@class='anticon anticon-close']");
//anchor tags
public static final By dasboardlink=By.xpath("//a[normalize-space()='Dashboard']");
}
