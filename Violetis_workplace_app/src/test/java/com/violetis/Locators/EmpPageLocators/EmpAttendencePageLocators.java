package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EmpAttendencePageLocators {

public static final By Attendencebtn=By.xpath("//span[@class='ant-menu-title-content']//span//span[contains(text(),'Attendance')]");
public static final By Attendencedetailsbtn=By.xpath("//span[contains(text(),'Attendance Details')]");
public static final By Attendencesummarybtn=By.xpath("//span[contains(text(),'Attendance Summary')]");
// Attendence details locators
public static final By yeardrpdownbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By monthdrpdwnbtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div/div[2]/div");
public static final By monthdrpdownbtnoptions=By.xpath("//div[(@aria-selected='true' or @aria-selected='false') and not(@role='option')]");
public static final By yearpickeryearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearbackwardbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static final By yearele=By.xpath("//table[@class='ant-picker-content']//tbody//tr//td/div");
public static final By lateloginele=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[3]/div[1]/div/div[4]/div/div/div/div[2]/span");

//attendence summary locators

public static final By presentcheckele=By.xpath("//span[@class='anticon anticon-check' and @tabindex='-1']");
public static final By leavecarele=By.xpath("//span[@class='anticon anticon-car' and @tabindex='-1']");
public static final By halfdayelestar=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[1]/div/div[1]/span");
   //yeardrpdown,monthdropddown,monthelmens,yearoptions,forward,prev buttons same as attendence details

}
