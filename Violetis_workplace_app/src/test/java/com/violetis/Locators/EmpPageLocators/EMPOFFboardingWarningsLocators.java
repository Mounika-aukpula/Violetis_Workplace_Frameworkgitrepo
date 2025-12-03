package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPOFFboardingWarningsLocators {
public static final By Offboarding_btn=By.xpath("//span[contains(text(),'Offboardings')]");
public static final By warning_btn=By.xpath("//span[contains(text(),'Warnings')]");
//year dropdown elemnets
public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
public static final By monthdrpdwnbtn=By.xpath("//span[@class='ant-select-selection-placeholder']");
public static final By monthdrpoptions=By.xpath("//div[@class='ant-select-item-option-content']");
public static final By serachbytitleinputbox=By.xpath("//input[@placeholder='Search By Title']");
public static final By tableheaders=By.xpath("//table//th");
public static final By warnrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']");
public static final By titlecells=By.xpath("//td[1]/a");
public static final By warndatecells=By.xpath("//td[2][@class='ant-table-cell']");
public static final By viewicons=By.xpath(".//td[last()]//span[contains(@class,'eye')]");
public static final By nodataele=By.xpath("//p[contains(text(),'No data')]");
//pagination
public static final By pagonationelefrwd=By.xpath("//span[@aria-label='right']//*[name()='svg']");
//title limk elements
public static final By titleele=By.xpath("/html/body/div[4]/div/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[4]/td/div/span");
public static final By dateele=By.xpath("/html/body/div[4]/div/div[2]/div/div/div[2]/div/div/div/div/table/tbody/tr[6]/td/div/span/span");

}
