package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPLeaveLocators {
public static final By leavestatusdatas=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[7]/span");
public static final By Leavebtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[5]/div/span");
public static final By sub_leave_btn=By.xpath("//li[@data-menu-id='leaves' and contains(@class,'ant-menu-item')]");
public static final By Leavedays=By.xpath("//tbody[@class='ant-table-tbody']//td[6]/span");
public static final By Allbtn=By.xpath("//div[@id='rc-tabs-16-tab-all']");
public static final By Pendingbtn=By.xpath("//*[@id=\"rc-tabs-0-tab-pending\"]");
public static final By Approvedbtn=By.xpath("//div[contains(@id,'tab-approved')]");
public static final By Rejectedbtn=By.xpath("//div[1][contains(@id,'rejected')] ");
public static final By Alldateseles=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[6]/span");


}
