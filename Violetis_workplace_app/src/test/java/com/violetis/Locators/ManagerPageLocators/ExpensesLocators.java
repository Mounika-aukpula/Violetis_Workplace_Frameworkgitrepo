package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class ExpensesLocators {
public static final By Financemenu=By.xpath("//span[contains(text(),'Finance')]");
public static final By expensessubmenu=By.xpath("//span[contains(text(),'Expenses')]");
public static final By allrows=By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']");
public static final By selectuserdrpdown=By.xpath("(//input[contains(@id,'rc_select')])[3]");

}
