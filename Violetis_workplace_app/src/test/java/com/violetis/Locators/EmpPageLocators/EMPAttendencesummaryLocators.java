package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPAttendencesummaryLocators {
public static final By Attendencemenu=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[6]/div/span/span/span[2]");
public static final By Attendencesummarymenu=By.xpath("//span[contains(text(),'Attendance Summary')]");
public static final By datescols=By.xpath("//table/thead/tr/th");
//year dropdown
public static final By yeardropdown=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
//month dropdown
public static final By monthdropdown=By.xpath("//div[@class='ant-select css-gaz7ss ant-select-single ant-select-show-arrow ant-select-show-search']");
public static final By monthdrpoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
//dashboard link
public static final By dashboardlink=By.xpath("//a[normalize-space()='Dashboard']");
}
