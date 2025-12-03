package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class ManagerAttendencedetailsLocators {
public static final By Attendencemainmoudle=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div[2]/ul/li[6]/div/span");
public static final By Attendencedetails_submodule=By.xpath("//span[contains(text(),'Attendance Details')]");
public static final By selectemployeedropdown=By.xpath("//span[@title='Jlq1L9rR']");
public static final By selectdrpdownoptions=By.xpath("//div[@class='profile-info']//span");
public static final By Attendence_details_rows=By.xpath("//table//tbody/tr");
// 🔹 Columns inside each row
public static final By DATE_COL = By.xpath(".//td[1]");
public static final By STATUS_COL = By.xpath(".//td[2]//span/span[2] | .//td[2]");
public static final By CLOCKIN_COL = By.xpath(".//td[3]");
public static final By CLOCKOUT_COL = By.xpath(".//td[4]");
public static final By CLOCKEDTIME_COL = By.xpath(".//td[5]//a | .//td[5]");
public static final By OTHERDETAILS_COL = By.xpath(".//td[6]");
}
