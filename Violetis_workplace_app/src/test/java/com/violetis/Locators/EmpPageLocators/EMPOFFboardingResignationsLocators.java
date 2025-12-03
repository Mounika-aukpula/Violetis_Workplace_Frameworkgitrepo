package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPOFFboardingResignationsLocators {
	//******* Add Resignation Module Locators***********************
	public static final By Offboarding_btn=By.xpath("//span[contains(text(),'Offboardings')]");
	public static final By Resignations_btn=By.xpath("//span[contains(text(),'Resignations')]");
	public static final By Add_New_Resignation_btn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']");
	public static final By title_input_box=By.xpath("//input[@id='form_item_title']");
	public static final By Description_btn=By.xpath("//textarea[@placeholder='Please Enter Description']");
	public static final By Resignation_date_ele=By.xpath("//input[@id='form_item_start_date']");
	//datepicker
	public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
	public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
	public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
	public static final By year_forward_btn=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/div[1]/button[4]");
	public static final By user_app_options=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
	public static final By resig_date_ok_btn=By.xpath("//span[normalize-space()='Ok']");
	public static final By month_year=By.xpath("//div[@class='ant-picker-date-panel']/div[1]/div");
	public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
	public static final By submit_resignation_btn=By.xpath("//span[contains(normalize-space(), 'Create') or contains(normalize-space(), 'Update')]");
	public static final By cancel_btn=By.xpath("//span[normalize-space()='Cancel']");
	//error ele
	public static final By titlefielderrorele=By.xpath("//div[contains(text(),'The title field is required')]");
	public static final By descriptionerrorele=By.xpath("//div[contains(text(),'The description field is required.')]");
	public static final By startdateerrorele=By.xpath("//div[contains(text(),'The start date field is required.')]");
	//success ele
	public static final By successmsgele=By.xpath("//div[@class='ant-notification-notice-message' and contains(text(),'Success')]");
	
	//************* pending tab locators
	public static final By pending_tab=By.xpath("//div[@id='rc-tabs-0-tab-pending']");
	public static final By first_row_title=By.xpath("//tr/td[1]/a");
	public static final By resgndate=By.xpath("//tr/td[2]/span");
	//action btns
	public static final By firstrowviewbtn=By.xpath("//tr[1]/td[3]/button[1]");
	public static final By firstroweditbtn=By.xpath("//tr[1]/td[3]/button[2]");
	public static final By firstrowdeletebtn=By.xpath("//tr[1]/td[3]/button[3]");
	public static final By firstrowdownloadbtn=By.xpath("//tr[1]/td[3]/button[4]");
	public static final By confirdelbtn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-default ant-btn-dangerous']");
	public static final By canceldelbtn=By.xpath("//div[@class='ant-modal-body']//button[1]");
	
	//view elements
	public static final By name=By.xpath("//tbody//tr[2]/td/div/span");
	public static final By resigndateele=By.xpath("//div[@class='ant-descriptions-item-container']/span/span");
	public static final By titleele=By.xpath("//tbody//tr[4]/td/div/span");
	public static final By descriptionele=By.xpath("//tbody//tr[8]/td/div/span/div");
	public static final By cancelbtn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']//span[contains(text(),'Cancel')]");
	//approved tab elements
	public static final By approved_tab_btn=By.xpath("//div[@id='rc-tabs-0-tab-approved']");
	public static final By searchtitleinput=By.xpath("//input[@placeholder='Search By Title']");
	
	
	
}

