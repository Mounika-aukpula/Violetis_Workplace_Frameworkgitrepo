package com.violetis.Locators.EmpPageLocators;
import org.openqa.selenium.By;
public class EMPAssetsLocators {
public static final By nodataele=By.xpath("//p[contains(text(),'No data')]");
public static final By issuedassetsbtn=By.xpath("//div[@id='rc-tabs-4-tab-all']");
public static final By assetsrows=By.xpath("//tbody[@class='ant-table-tbody']//tr");
public static final By assetscells=By.xpath("//tbody[@class='ant-table-tbody']//tr//td");
public static final By assetmenu=By.xpath("//span[contains(text(),'Assets')]");
public static final By viewbutton=By.xpath("//span[@class='anticon anticon-eye']");
public static final By assettypedrpdwn=By.xpath("//input[@id='rc_select_27']");
public static final By assettypeoptions=By.xpath("//div[@class='ant-select-item-option-content']");
//issued assets
public static final By issuedassetsrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']");
public static final By Assetnamecell=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]");
public static final By issueddatecells=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[4]");
public static final By expectedreturndatecells=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[5]");

}
