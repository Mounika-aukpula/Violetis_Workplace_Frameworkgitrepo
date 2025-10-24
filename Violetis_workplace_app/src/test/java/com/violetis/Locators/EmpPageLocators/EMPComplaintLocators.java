package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPComplaintLocators {
	public static final By Offboarding_btn=By.xpath("//span[contains(text(),'Offboardings')]");
	public static final By complaintsbtn=By.xpath("//li[@role='menuitem']//span[contains(text(),'Complaints')]");
	public static final By comp_title=By.xpath("//input[@id='form_item_title']");
	public static final By to_staff_drp_dwn_btn=By.xpath("//div[@class='ant-select ant-select-in-form-item css-gaz7ss ant-select-single ant-select-allow-clear ant-select-show-arrow ant-select-show-search']");
	public static final By to_staff_drp_options=By.xpath("//div[@class='rc-virtual-list-holder-inner']//div/div[1]");
	public static final By descr_textbox=By.xpath("//textarea[@id='form_item_description']");
	public static final By date_time_picker=By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
	public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
	public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
	public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
	public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
	public static final By okbtn_datepicker=By.xpath("//span[normalize-space()='Ok']");
	public static final By comp_submitbtn=By.xpath("//span[normalize-space()='Create']");
	//complaint loc
	public static final By byyoubtn=By.xpath("//div[contains(@class,'ant-tabs-tab-btn') and contains(text(),'By You')]");
	public static final By Addnewcomplaintbtn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']");
	
}
