package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class HolidaysLocators {
public static final By selfbtn=By.xpath("//span[normalize-space()='Self']");
public static final By holidaysbtn=By.xpath("//span[contains(text(),'Holidays')]");
//yearpicker
public static final By yearpicker=By.xpath("(//div[@class='ant-card-extra'])[5]");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static final By yearnextbtn=By.xpath("//span[@class='ant-picker-super-next-icon']");
public static final By yeareles=By.xpath("//div[@class='ant-picker-cell-inner']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static By yearOption(String year) {
	    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
	}
//tabs
public static final By holidaytab=By.xpath("//div[contains(@id,'tab-holiday')]");
public static final By weekendtab=By.xpath("//div[contains(text(),'Weekends')]");
public static final By holidaynames=By.xpath("//table//tbody//tr/td[1]");
public static final By holidaydates=By.xpath("//table//tbody//tr/td[2]");
public static final By pageforwardbtn=By.xpath("//span[@aria-label='right']//*[name()='svg']");

}
