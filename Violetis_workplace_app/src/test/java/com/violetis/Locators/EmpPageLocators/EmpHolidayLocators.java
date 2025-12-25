package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EmpHolidayLocators {
public static final By holidaymenu=By.xpath("//span[@class='ant-menu-title-content']//span[contains(text(),'Holidays')]");
public static final By hldcalenderdownloadbtn=By.xpath("//span[normalize-space()='Holiday Calendar']");

public static final By all_tab_btn=By.xpath("//div[@id='rc-tabs-0-tab-all']");
public static final By hldy_tab_btn=By.xpath("//div[contains(text(),'Holiday')]");
public static final By weekend_tab_btn=By.xpath("(//div[contains(@id,'weekend')])[1]");

public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static final By monthdrpdwnbtn=By.xpath("//span[@class='ant-select-selection-placeholder']");
public static final By searchhldybtn=By.xpath("//input[@placeholder='Search By Name']");

public static final By holidaysrows=By.xpath("//tbody[@class='ant-table-tbody']//tr");
public static final By hldynamecellss=By.xpath("//tbody[@class='ant-table-tbody']//tr//td[1]");
public static final By hldydatecells=By.xpath("//tbody[@class='ant-table-tbody']//tr//td[2]");
public static final By nodatamsgele=By.xpath("//p[@class='ant-empty-description']");
public static By yearOption(String year) {
    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
public static By Holidayname(int row) {
    return By.xpath(".//tr[" +row+ "]//td[1]/span");
}
public static By Holidaydate(int row) {
    return By.xpath(".//tr[" +row+ "]//td[2]");
}
public static final By paginationnxtbtn=By.xpath("//span[@aria-label='right']//*[name()='svg']");
public static final By lastpageno=By.xpath("//li[@class='ant-pagination-next']/preceding-sibling::li[1]/a");

		}
