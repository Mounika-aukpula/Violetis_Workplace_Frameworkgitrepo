package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class LeavepageLocators {
public static final By Leaves_mainmenu=By.xpath("(//span[contains(text(),'Leaves')])[1]");
public static final By Leaves_submenu=By.xpath("(//span[contains(text(),'Leaves')])[2]");
public static final By pendingtabs=By.xpath("//div[contains(text(),'Pending')]");
public static final By allrows=By.xpath("//tbody//tr");
public static final By allrowsnames=By.xpath("//tbody//tr//td[2]//div[@class='profile-info']/span");
public static final By startdateele=By.xpath("//tbody//tr//td[4]");
public static final By enddateele=By.xpath("//tbody//tr//td[5]");

}
