package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class AttendenceDetailsLocators {
public static final By Attendencemenu=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[6]/div/span/span/span[2]");
public static final By Attendencedetailsmenu=By.xpath("//span[contains(text(),'Attendance Details')]");
//year dropdown
public static final By yeardropdown=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
  return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
//month dropdown
public static final By monthdropdown=By.xpath("//div[@class='ant-select css-gaz7ss ant-select-single ant-select-show-arrow ant-select-show-search']");
public static final By monthdrpoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");

public static final By csvdownload=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary']");
public static final By presentworkingdaysele=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[3]/div[1]/div/div[1]/div/div/div/div[2]/span");
public static final By totalofficetimele=By.xpath("//div[@class='mb-30']//div[2]//div[1]//div[1]//div[1]//div[2]");
public static final By Totworkedtimeele=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[3]/div[1]/div/div[3]/div/div/div/div[2]/span");
public static final By lateattendencecountele=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[3]/div[1]/div/div[4]/div/div/div/div[2]/span");
public static final By halfdayele=By.xpath("//span[@class='ant-statistic-content-value-int']");
//table
public static final By attendencerows=By.xpath(".//tbody//tr");
public static final By allrowsstatuseles=By.xpath(".//td[2]/span//span[2]");
public static final By allrowsclockedtimes=By.xpath("//td[5]//a");
public static final By lateattendencerowsele=By.xpath("//tr/td[3]/span");
//Columns within a row
public static final By DATE_COL = By.xpath(".//td[1]");
public static final By STATUS_COL = By.xpath(".//td[2]//span/span[2] | .//td[2]");
public static final By CLOCKIN_COL = By.xpath(".//td[3]");
public static final By CLOCKOUT_COL = By.xpath(".//td[4]");
public static final By CLOCKEDTIME_COL = By.xpath(".//td[5]//a | .//td[5]");
public static final By OTHERDETAILS_COL = By.xpath(".//td[6]");
}
