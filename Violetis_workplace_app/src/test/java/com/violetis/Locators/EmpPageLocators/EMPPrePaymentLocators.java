package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPPrePaymentLocators {
//payroll btn
public static final By payrollbtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[11]/div/span");
public static final By sub_menu_prepayementbtn=By.xpath("//li[@data-menu-id='pre_payments']");

public static final By nodataele=By.xpath("//p[contains(text(),'No data')]");
public static final By allrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']");
//year dropdown elemnets
public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
  return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
public static final By monthdrpdown=By.xpath("//input[@id='rc_select_2']");
public static final By monthoptions=By.xpath("//div[contains(@class, 'ant-select-item') and contains(@class, 'ant-select-item-option')]/div");
public static final By scrollby=By.xpath("//div[@class='rc-virtual-list-scrollbar-thumb']");
public static final By viewactionbts=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[5]//div//button");
public static By row(int index) {
    return By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][" + index + "]");
}
public static final By ROW_CHECKBOXES=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[1]/label/span/input");
public static final By deductmonthelecols=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[4]");
public static final By amountelecols=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[3]");
public static final By datecols=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]");
public static final By pagebox=By.xpath("//a[@rel='nofollow']");
//view page locators
public static final By viewbtndateele=By.xpath("//table/tbody/tr[2]/td/div/span");
public static final By viewpageamtele=By.xpath("//table/tbody/tr[4]/td/div/span");
public static final By viewpagedeductmonthele=By.xpath("//table/tbody/tr[6]/td/div/span");
public static final By viewpageclosebtn=By.xpath("//span[@class='anticon anticon-close']");
public static By datelerow(int index) {
    return By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][" + index + "]//td[2]");
}
public static By amtelerow(int index) {
    return By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][" + index + "]//td[3]");
}
public static By deductmonthelerow(int index) {
    return By.xpath("//tr[@class='ant-table-row ant-table-row-level-0'][" + index + "]//td[4]");
}
}
