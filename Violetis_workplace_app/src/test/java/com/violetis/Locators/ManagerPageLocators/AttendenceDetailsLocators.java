package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class AttendenceDetailsLocators {
	public static final By selectuserdrpdown=By.xpath("(//span[@class='ant-select-selection-item'])[1]");
	public static final By selectuseroptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
	public static final By yeardrpdown=By.xpath("//input[@placeholder='Select Year...']");
	public static final By firstrowdateele=By.xpath("(//tbody/tr[1])[1]/td[1]");
	public static final By firstrowstatusele=By.xpath("(//tbody/tr[1])[1]/td[2]//span[2]");
	public static final By firstrowclockinele=By.xpath("(//tbody/tr[1])/td[3]");
	public static final By firstrowclockoutele=By.xpath("(//tbody/tr[1])/td[4]");
	public static final By firstrowclockedtimeele=By.xpath("(//tbody/tr[1])/td[5]/span/a");
	public static final By allrows=By.xpath("//tbody/tr");
	public static final By Attendence_mainmenu=By.xpath("(//span[contains(text(),'Attendance')])[1]");
	public static final By AttendenceDetails_subenu=By.xpath("(//span[contains(text(),'Attendance')])[2]");
}
