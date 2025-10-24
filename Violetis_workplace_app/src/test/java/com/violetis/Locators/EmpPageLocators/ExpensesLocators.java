package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class ExpensesLocators {
	public static final By Expencesbtn=By.xpath("//div[@class='scroll-container']/ul/li[10]");
	public static final By add_new_expense_btn=By.xpath("//span[normalize-space()='Add New Expense']");
	public static final By Expense_category=By.xpath("//input[@id='form_item_expense_category_id']");
	public static final By expense_options=By.xpath("//div[@label='test']");
	public static final By Amount=By.xpath("//input[@id='form_item_amount']");
	public static final By date_time_picker_btn=By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
	public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
	public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
	public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
	public static final By date_picker_ok_btn=By.xpath("//span[normalize-space()='Ok']");
	public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
	public static final By submit_expense_btn=By.xpath("//span[normalize-space()='Create']");
	
}
