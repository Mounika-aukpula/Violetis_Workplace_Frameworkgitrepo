package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PromotionordemotaionLocators {
	public static final By payrollbtn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/aside/div/div[2]/div/ul/li[11]/div/span");
	public static final By Submenu_incordec=By.xpath("//li[@data-menu-id='increments_promotions']");
	//all,inc,dec,inc/promotion,dec,dec/demotion tabs locators
	public static final By alltabbtn=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-all')+1)='tab-all']]");
	public static final By increamenttab=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-increment')+1)='tab-increment']]");
	public static final By promotiontab=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-promotion')+1)='tab-promotion']]");
	public static final By incorpromotiontab=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-increment_promotion')+1)='tab-increment_promotion']]");
	public static final By decreamnettab=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-decrement')+1)='tab-decrement']]");
	public static final By decordemotiontab=By.xpath("//div[@id[substring(.,string-length(.)-string-length('tab-decrement_demotion')+1)='tab-decrement_demotion']]");
	//month dropdown locators
	public static final By monthdropdown=By.xpath("//*[@id='rc_select_0']");
	public static final By monthoptions=By.xpath("//div[contains(@class, 'ant-select-item') and contains(@class, 'ant-select-item-option')]/div"); 
	//year dropdown locators
	public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
	public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
	public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
	public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
	public static By yearOption(String year) {
	  return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
	}
	public static final By hiddenbtn=By.xpath("//span[@class='ant-switch-inner']");
	public static final By nodataele=By.xpath("//p[contains(text(),'No data')]");
	
	//table element locators
	public static final By allrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']");
	public static final By  datecolsinallrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td[2]");
	public static By singleRow(WebElement row) {
	    String text = row.getText();
	    return By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//[td[contains(.,'" + text + "')]]");
	}
}