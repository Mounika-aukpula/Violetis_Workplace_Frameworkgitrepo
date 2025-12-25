package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class AssetsLocators {
	public static final By Assetsmenu=By.xpath("(//span[contains(text(),'Assets')])[1]");
	public static final By Assetssubmenu=By.xpath("(//span[contains(text(),'Assets')])[2]");
	public static final By selectlocationdrpdown=By.xpath("//span[contains(text(),'Select Location...')]");
	public static final By selectlocationoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
	public static final By selectbyuserdrpdown=By.xpath("(//input[contains(@id,'rc_select')])[2]");
	public static final By selectbyuseroptions=By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div");
	public static final By searchbyasset=By.xpath("//input[@placeholder='Search By Asset Name']");
	public static final By workingtab=By.xpath("//div[contains(text(),'Working')]");
	public static final By notworkingtab=By.xpath("//div[contains(text(),'Not Working')]");
	public static final By pagenextnavigation=By.xpath("//span[@aria-label='right']//*[name()='svg']");
	public static final By lastpahgenumber=By.xpath("(//li[contains(@class,'ant-pagination-item ant-pagination-item')])[last()]/a");
	
}
