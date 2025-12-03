package com.violetis.Locators;

import org.openqa.selenium.By;

public class EMPLetterHeadsLocators {
public static final By letterhead_btn=By.xpath("//span[contains(text(),'Letter Heads')]");
public static final By selectmonthdrpdown=By.xpath("//span[contains(text(),'Select Month...')]");
//year dropdown
public static final By yeardrpdown=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//div[@class='ant-picker-header-view']/button");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
//letter head dropdown
public static final By selectletterheaddrpdown=By.xpath("//input[@id='rc_select_163']");
//tables
public static final By tablerows=By.xpath("//table/tbody/tr");
public static final By nodataele=By.xpath("//*[contains(text(), 'No data')]");
public static final By firstrowdwnldbtn=By.xpath("//tbody/tr[1]/td[3]/button");
public static final By createddatecols=By.xpath("//tr//td[2]");
//pagination
public static final By paginationfrwdbtn=By.xpath("//li[@title='Next Page']//button[@type='button']");
public static final By paginationprevbtn=By.xpath("//span[@aria-label='left']//*[name()='svg']");
public static final By paginationdrpdown=By.xpath("//span[@class='ant-select-selection-item']");
public static final By paginationdrpdownoptions=By.xpath("//div[@class='ant-select-item-option-content'][contains(normalize-space(), 'page')]");

}
