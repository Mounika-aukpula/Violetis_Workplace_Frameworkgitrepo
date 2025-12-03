package com.violetis.Locators.hrlocators;

import org.openqa.selenium.By;

public class HRResignationLocators {
	public static final By offboarding_menu=By.xpath("//span[contains(text(),'Offboardings')]");
	public static final By Resignations_sub_menu=By.xpath("//span[contains(text(),'Resignations')]");
	public static final By searchbytitleinputbox=By.xpath("//input[@placeholder='Search By Title']");
	public static final By titleele=By.xpath("//tr//td[2]/a");
	public static final By accorrejbtn=By.xpath("//tr//td[7]/button[1]");
	public static final By first_row_title=By.xpath("//tr//td[2]/a");
	//datepicker elemens
	public static final By dateele=By.xpath("//div[@class='ant-picker-cell-inner']");
	public static final By replynotesinputbox=By.xpath("//textarea[@placeholder='Please Enter Reply Notes']");
	public static final By Rejected_btn=By.xpath("//*[@id=\"form_item_status\"]/label[2]/span[2]");
	public static final By Lastworkingdaydatepicker=By.xpath("//div[@class='ant-picker css-gaz7ss']");
	public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
	public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
	public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
	public static final By ok_btn_datepicker=By.xpath("//span[normalize-space()='Ok']");
	public static final By updatebtn=By.xpath("//span[contains(text(),'Update')]");
	public static final By  lastworkingdatestoreele=By.xpath("//input[@id='form_item_end_date']");
	
}
