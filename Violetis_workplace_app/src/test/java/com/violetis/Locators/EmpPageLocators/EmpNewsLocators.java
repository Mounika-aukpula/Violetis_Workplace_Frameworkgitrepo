package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EmpNewsLocators {
public static final By Newsbtn=By.xpath("//span[contains(text(),'News')]");
public static final By Newsrows=By.xpath("//tbody//tr");
public static final By searchnewsinputbox=By.xpath("//input[@placeholder='Search By Title']");
public static final By nodataele=By.xpath("//p[contains(text(),'No data')]");
public static final By headernames=By.xpath("//tr//th");
public static final By alltitles=By.xpath("//tbody//td[1]");
public static final By viewicons=By.xpath("//tbody//td[2]//button//span");
public static final By viewbtntitle=By.xpath("/html/body/div[4]/div/div[2]/div/div/div[2]/div[1]/div/div/div/table/tbody/tr[2]//span");
public static final By viewbtndesc=By.xpath("/html/body/div[4]/div/div[2]/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td/div/span/div");



}
