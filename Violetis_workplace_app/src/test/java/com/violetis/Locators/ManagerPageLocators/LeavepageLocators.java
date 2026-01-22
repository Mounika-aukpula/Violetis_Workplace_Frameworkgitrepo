package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class LeavepageLocators {
public static final By alltab=By.xpath("//div[contains(@id,'tab-all')]");
public static final By approvedtab=By.xpath("//div[contains(@id,'tab-approved')]");
public static final By rejectedtab=By.xpath("//div[contains(@id,'tab-rejected')]");
//dropdowns
public static final By selectleavetypedropdwn=By.xpath("(//input[contains(@id,'rc_select')])[1]");
public static final By selectleaveoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By selectuserdrpdown=By.xpath("(//input[contains(@id,'rc_select')])[2]");
public static final By useroptions=By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div");
//table locators
public static final By statuseles=By.xpath("//tr//td[8]//span");
public static final By tableheaders=By.xpath("//table//th[position() >= 2]");


public static final By Leaves_mainmenu=By.xpath("(//span[contains(text(),'Leaves')])[1]");
public static final By Leaves_submenu=By.xpath("(//span[contains(text(),'Leaves')])[2]");
public static final By pendingtabs=By.xpath("//div[contains(text(),'Pending')]");
public static final By allrows=By.xpath("//tbody//tr");
public static final By allrowsnames=By.xpath("//tbody//tr//td[2]//div[@class='profile-info']/span");
public static final By startdateele=By.xpath("//tbody//tr//td[4]");
public static final By enddateele=By.xpath("//tbody//tr//td[5]");

}
