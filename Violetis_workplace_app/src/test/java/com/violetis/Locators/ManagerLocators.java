package com.violetis.Locators;

import org.openqa.selenium.By;

public class ManagerLocators {
public static final By Appreciations=By.xpath("//li[@data-submenu-id=\"appreciations\"]/div");
public static final By Appreciation=By.xpath("//li[@role='menuitem']//span[contains(text(),'Appreciations')]");
public static final By Add_Appreciationbtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[1]/div/div/button");
//appreciation form locators
public static final By uname=By.xpath("//input[@id='form_item_user_id']");
public static final By Date_Time_picker_btn=By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
public static final By year_forward_btn=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/div[1]/button[4]");
public static final By user_app_options=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By app_date_ok_btn=By.xpath("//span[normalize-space()='Ok']");
//appreciation form date pickers locators
public static final By month_year=By.xpath("//div[@class='ant-picker-date-panel']/div[1]/div");
public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
public static final By submit_app_btn=By.xpath("//span[normalize-space()='Create']");
//Warning 
public static final By off_boarding=By.xpath("//span[contains(text(),'Offboardings')]");
public static final By warnings_btn=By.xpath("//ul[@id='sub_menu_6_$$_offboardings-popup']");
public static final By ADD_NEW_WARN=By.xpath("//span[normalize-space()='Add New Warning']");
public static final By Warn_title=By.xpath("//input[@id='form_item_title']");
public static final By manager_logout=By.xpath("//div[@class='main-sidebar']//li[10]");
public static final By manager_confirm_logout=By.xpath("//span[normalize-space()='Yes, Logout']");
//Leave
public static final By Leavebtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div[2]/ul/li[5]/div/span");
public static final By main_leavebtn=By.xpath("//li[@data-menu-id='leaves']");
//leaverows
public static final By alleaverows=By.xpath("//tbody[@class='ant-table-tbody']//tr");
public static final By allleavepersonsnames=By.xpath("//tbody[@class='ant-table-tbody']//tr/td[2]/button/div/div/div/span");
public static final By allleavedetailscols=By.xpath("//div[@class='ant-table-content']//table//th");
public static final By leaveraisedunames=By.xpath("//tbody[@class='ant-table-tbody']//tr/td[2]");
//public static final By empleavecolsdyn=By.xpath("//div[@class='ant-table-content']//table//tbody//tr//td[6]");
public static By getempnameLocator(int row) {
    return By.xpath("//tbody[@class='ant-table-tbody']//tr[" + row + "]/td[2]/button/div/div/div/span");
    }
public static By getleavetype(int row,int col) {
	return By.xpath("//div[@class='ant-table-content']//table//tbody//tr\" + row + \"//td[\" + col + \"]");
}








}
