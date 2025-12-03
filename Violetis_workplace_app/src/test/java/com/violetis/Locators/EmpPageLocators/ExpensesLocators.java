package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class ExpensesLocators {
	public static final By Expencesbtn=By.xpath("//span[normalize-space()='Expenses']");
	public static final By add_new_expense_btn=By.xpath("//span[normalize-space()='Add New Expense']");
	public static final By Expense_category=By.xpath("//input[@id='form_item_expense_category_id']/ancestor::div[contains(@class,'ant-select')]/div");
	public static final By expense_options=By.xpath("//div[@label='test']");
	public static final By expence_caterogiry_drpdown_options=By.xpath("//div[@class='ant-select-item-option-content']");
	
	public static final By Amount=By.xpath("//input[@id='form_item_amount']");
	public static final By date_time_picker_btn=By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
	public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
	public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
	public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
	public static final By date_picker_ok_btn=By.xpath("//span[normalize-space()='Ok']");
	public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
	
	public static final By refernce_inputbox=By.xpath("//input[@id='form_item_reference_number']");
	public static final By expensebill=By.xpath("//span[contains(text(),'Upload')]");
	public static final By notes_input_box=By.xpath("//textarea[@placeholder='Please Enter Notes']");
	public static final By submit_expense_btn=By.xpath("//span[normalize-space()='Create']");
	public static final By cancel_btn=By.xpath("//div[@class='ant-drawer-footer']//button[@type='button']");
	public static final By file=By.cssSelector("input[type='file']");
	//error eles
	public static final By amterror_ele=By.xpath("//div[contains(text(),'The amount field is required.')]");
	public static final By expensetypeerrorele=By.xpath("//div[contains(text(),'The expense category id field is required.')]");
	//pending tab
	public static final By pending_tab=By.xpath("//div[@id='rc-tabs-0-tab-pending']");
	public static final By firstrowexpensetypeele=By.xpath("//tbody//tr[1]/td");
	public static final By firstrowamountele=By.xpath("//tbody//tr[1]/td[2]");
	public static final By Datetimeele=By.xpath("//tbody//tr[1]/td[3]");
	public static final By firstrowstatusele=By.xpath("//tbody//tr[1]/td[4]/span");
	public static final By firstrowviewbtn=By.xpath("//tbody//tr[1]/td[5]/button[1]");
	public static final By firstroweditbtn=By.xpath("//tbody//tr[1]/td[5]/button[2]");
	public static final By firstrowdelbtn=By.xpath("//tbody//tr[1]/td[5]/button[3]");
	public static final By firstrowdwnldbtn=By.xpath("//tbody//tr[1]/td[5]/button[4]");
	//view btn form page locators in pending tab
	public static final By viewexpensetypedata=By.xpath("//tbody/tr[2]/td[2]/div[1]/span[1]");
	public static final By viewbtnamtdata=By.xpath("(//span[@class='ant-descriptions-item-content'])[3]");
	public static final By viewbtnrefnodate=By.xpath("(//span[@class='ant-descriptions-item-content'])[4]/div");
	public static final By viewbtndatedate=By.xpath("(//span[@class='ant-descriptions-item-content'])[5]");
	public static final By viewbtnnotesdata=By.xpath("(//span[@class='ant-descriptions-item-content'])[10]/div");
	public static final By crossbtn=By.xpath("//*[name()='path' and contains(@d,'M799.86 16')]");
	//editbtn locators
	public static final By updatebtn=By.xpath("//span[normalize-space()='Update']");
	
	//approved tab locators
	public static final By approved_tab=By.xpath("//div[@id='rc-tabs-7-tab-approved']");
	public static final By firstrowapprovedexpensetypeeletext=By.xpath("//tbody//tr[1]/td[1]");
	public static final By firstrowapprovedsttausele=By.xpath("//tr[1]/td[4]/span");
	
	
	

	
	
	
}
