package com.violetis.Locators.EmpPageLocators;

import org.openqa.selenium.By;

public class EMPAppreciationsLocators {
public static final By Appreciations_menu=By.xpath("//span[@class='ant-menu-title-content']//span[contains(text(),'Appreciations')]");
public static final By yeardrpdwnbtn=By.xpath("//input[@placeholder='Select Year...']");
public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
public static final By yearfrnwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
public static By yearOption(String year) {
    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
}
public static final By monthdropdown=By.xpath("//div[contains(@class,'ant-select') and .//span[contains(text(),'Select Month')]]");
public static final By monthdrpoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']//div/div");
public static final By monthdrpscrollbar=By.xpath("//div[@class='rc-virtual-list-scrollbar-thumb']");
public static final By selectawarddropdown=By.xpath("//*[@id='rc_select_1']");
public static final By selectdropdownoptions=By.xpath("//div[@class='ant-select-item-option-content']");

public static final By nodataele=By.xpath("//p[@class='ant-empty-description']");
public static final By appreciationsrows=By.xpath("//tbody[@class='ant-table-tbody']//tr");
public static final By appreciationscells=By.xpath("//tbody[@class='ant-table-tbody']//tr/td");

//Table columns (dynamic)
public static By getCellByRowAndColumn(int row, int col) {
    return By.xpath(String.format("//tbody[@class='ant-table-tbody']//tr[%d]//td[%d]", row, col));
}

public static final By actionBtn = By.xpath("//tbody//button[contains(@class,'ant-btn') or contains(@class,'view')]");
}
