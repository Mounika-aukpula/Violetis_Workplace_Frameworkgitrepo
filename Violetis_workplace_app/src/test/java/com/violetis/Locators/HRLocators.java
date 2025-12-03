package com.violetis.Locators;

import org.openqa.selenium.By;

public class HRLocators {
public static final By payrollbtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div[2]/ul/li[9]/div/span");
public static final By incorprobtn=By.xpath("//span[contains(text(),'Increment/Promotion')]");
public static final By Addnewincorpromotionbtn=By.xpath("//span[normalize-space()='Add New Increment/Promotion']");
public static final By typedrpdownbtn=By.xpath("//div[@class='ant-select ant-select-in-form-item css-gaz7ss ant-select-single ant-select-show-arrow']");
public static final By typedropdownoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']//div/div");
public static final By userdrpdownbtn=By.xpath("//input[@id='form_item_user_id']");
public static final By userdrpdownoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By Annualctcinputbox=By.xpath("//input[@id='form_item_net_salary']");
public static final By Descriptionbox=By.xpath("//textarea[@id='form_item_description']");
public static final By Date_Time_picker_btn=By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
public static final By month_ele=By.xpath("//button[@class='ant-picker-month-btn']");
public static final By Year_ele=By.xpath("//button[@class='ant-picker-year-btn']");
public static final By month_forward_btn=By.xpath("//button[@class='ant-picker-header-next-btn']");
public static final By year_forward_btn=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/div[1]/button[4]");
public static final By datepicker_ok_btn=By.xpath("//span[normalize-space()='Ok']");

public static final By month_year=By.xpath("//div[@class='ant-picker-date-panel']/div[1]/div");
public static final By alldates=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
public static final By submit_btn=By.xpath("//span[normalize-space()='Create']");
public static final By popuptextele=By.xpath("//div[contains(@class,'ant-notification-notice-description')]");
public static final By currentdesignationdropdownbtn=By.xpath("//input[@id='form_item_current_designation_id']");
public static final By currentdesignationoptions=By.xpath("/html/body/div[10]/div/div/div/div[2]/div[1]/div/div/div");
public static final By promoteddesignationdropdown=By.xpath("//input[@id='form_item_promoted_designation_id']");
public static final By promotiondesignationoptions=By.xpath("/html/body/div[10]/div/div/div/div[2]/div[1]/div/div/div");
// Holiday module
public static final By main_holdays_menu=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div[2]/ul/li[4]/div/span");
public static final By sub_hldy_menu=By.xpath("//*[@id=\"sub_menu_3_$$_holidays-popup\"]/li[1]/span");
public static final By Add_new_holiday_tab=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[1]/div/div[1]/button");
public static final By holiday_name_inputbox=By.xpath("//input[@placeholder='Please Enter Name']");
     //create and datpickers locators are same in above
public static final By holidayrows=By.xpath("//*[@id=\"holiday-report\"]/div/div/table/tbody/tr");
public static final By holodaynameele=By.xpath("//*[@id=\"holiday-report\"]/div/div/table/tbody/tr//td[2]/span");
//Add policy module
public static final By policybtn=By.xpath("//span[contains(text(),'Company Policies')]");
public static final By addnewpolibtn=By.xpath("//span[normalize-space()='Add New Company Policy']");
public static final By locationdrpdown=By.xpath("//input[@id='form_item_location_id']");
public static final By locationdropdownoptions=By.xpath("//div[@class='ant-select-item-option-content']");
public static final By policytitleinpputbox=By.xpath("//*[@id=\"form_item_title\"]");
public static final By policydescription=By.xpath("//*[@id=\"form_item_description\"]");
public static final By uploadfileradbtn=By.xpath("//input[@value='upload']");
public static final By createfileradbtn=By.xpath("//*[@id=\"form_item_method_type\"]/label[2]/span[1]/input");
public static final By letterdesciptionofcreatefile=By.xpath("//div[@class='ql-editor ql-blank']//p");
public static final By createbtn=By.xpath("//span[normalize-space()='Create']");
//hr logout moudle
public static final By logout=By.xpath("//span[contains(text(),'Logout')]");
public static final By confirmlogout=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']");




}
