package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPLeaveLocators {
public static final By leavestatusdatas=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[7]/span");
public static final By Leavebtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[5]/div/span");
public static final By sub_leave_btn=By.xpath("//li[@data-menu-id='leaves' and contains(@class,'ant-menu-item')]");
public static final By Leavedays=By.xpath("//tbody[@class='ant-table-tbody']//td[6]/span");
public static final By Allbtn=By.xpath(" //div[@id='rc-tabs-0-tab-all']");
public static final By Pendingbtn=By.xpath("//*[@id=\"rc-tabs-0-tab-pending\"]");
public static final By Approvedbtn=By.xpath("//div[contains(@id,'tab-approved')]");
public static final By Rejectedbtn=By.xpath("//div[1][contains(@id,'rejected')] ");
public static final By Add_new_leave_btn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']//span[contains(text(),'Add New Leave')]");

//Filters year
public static final By yeardropdown=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
  return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
public static final By startdateeleintable=By.xpath("//tbody/tr//td[3]");
public static final By enddateeleintable=By.xpath("//tbody/tr//td[4]");
//month dropdown
public static final By monthdropdown=By.xpath("//input[@id='rc_select_44']");
public static final By monthdropoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By scrollbar=By.xpath("//div[@class='rc-virtual-list-scrollbar-thumb']");
//slect leave type dropdown
public static final By selectleave_drpdown=By.xpath("//input[@id='rc_select_1']");
public static final By selectleavoptions=By.xpath("/html/body/div[5]/div/div/div/div[2]/div[1]/div/div/div");
public static final By leavetypeeleintable=By.xpath("//tbody[@class='ant-table-tbody']/tr/td[2]");
//table
public static final By leavedayrows=By.xpath("//tbody[@class='ant-table-tbody']/tr");
public static final By Alldateseles=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[6]/span");
public static final By leavenameele=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]");
public static final By leave_status_cols=By.xpath("//tbody[@class='ant-table-tbody']/tr/td[7]/span");
public static final By Action_cols=By.xpath(".//td[8]//span[contains(@class,'anticon')]");
//icons
public static final By viewicon=By.xpath("//tbody[@class='ant-table-tbody']/tr/td[8]/div/div[1]");
public static final By editicon=By.xpath("//tbody[@class='ant-table-tbody']/tr/td[8]/div/div[2]");
public static final By deleteicon=By.xpath("//tbody[@class='ant-table-tbody']/tr/td[8]/div/div[3]");
public static final By confirmdebtn=By.xpath("//span[contains(text(),'Yes')]");
//table col dataele for validating view button
public static final By empname=By.xpath("//tbody//tr//td[1]");
public static final By leavetypele=By.xpath("//tbody//tr//td[2]");
public static final By startdateele=By.xpath(".//td[3]");
public static final By enddate=By.xpath(".//td[4]");
public static final By ishalfday=By.xpath("//tbody//tr//td[5]");
public static final By leavestatus=By.xpath("//tbody//tr//td[7]/span");
//view icon elements
public static final By viewbtnempname=By.xpath("//tr[2][@class='ant-descriptions-row']/td[1]/div/span");
public static final By Leavetypeviewele=By.xpath("//tr[2][@class='ant-descriptions-row']/td[2]/div/span");
public static final By startdateviewele=By.xpath("//tr[2][@class='ant-descriptions-row']/td[3]/div/span");
public static final By enddateviewele=By.xpath("//tr[4][@class='ant-descriptions-row']//td[1]/div/span");
public static final By ishalfdayviewelem=By.xpath("//tr[4][@class='ant-descriptions-row']//td[2]/div/span");
public static final By statusviewele=By.xpath("//tr[4][@class='ant-descriptions-row']//td[3]/div/span/span");
public static final By cancelbtn=By.xpath("//span[normalize-space()='Cancel']");
//leavemoudle ele
public static final By leavetypedrpdown=By.xpath("//input[@id='form_item_leave_type_id']");
public static final By leavetypeoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By reason=By.xpath("//textarea[@id='form_item_reason']");
public static final By ishalfdayradbtn=By.xpath("//span[@class='ant-radio-button']");
public static final By createbtn=By.xpath("//span[normalize-space()='Create']");





}
