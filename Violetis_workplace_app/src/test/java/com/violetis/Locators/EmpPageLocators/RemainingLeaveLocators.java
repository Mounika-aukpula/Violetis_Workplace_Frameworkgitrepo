package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class RemainingLeaveLocators {
public static final By Leavebtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[5]/div/span");
public static final By remainingleave_btn=By.xpath("//span[@class='ant-menu-title-content']//span[contains(text(),'Remaining Leaves')]");

public static final By annualholidaycount=By.xpath("//tbody//tr[1]/td[2]");
public static final By sickleavecount=By.xpath("//tbody//tr[2]/td[2]");
public static final By holidayindiacount=By.xpath("//tbody//tr[3]/td[2]");
public static final By unpaidleavescount=By.xpath("//tbody//tr[4]/td[2]");
public static final By metarnityleavescount=By.xpath("//tbody//tr[5]/td[2]");
public static final By petarnatyleavescount=By.xpath("//tbody//tr[6]/td[2]");
public static final By ocnditionalleavescount=By.xpath("//tbody//tr[7]/td[2]");
public static final By remainingleavenames=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[1]");
public static final By remainingleavecount=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[2]");


//year dopdown
public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
//anchors
public static final By dashboardanchortag=By.xpath("//a[normalize-space()='Dashboard']");

}
