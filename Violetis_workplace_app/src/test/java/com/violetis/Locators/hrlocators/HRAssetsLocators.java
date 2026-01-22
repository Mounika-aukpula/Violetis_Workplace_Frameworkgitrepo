package com.violetis.Locators.hrlocators;

import org.openqa.selenium.By;


public class HRAssetsLocators {
public static final By assetsmenu=By.xpath("(//span[contains(text(),'Assets')])[1]");
public static final By aseetssub_menu=By.xpath("(//span[contains(text(),'Assets')])[2]");
public static final By addnewassetbtn=By.xpath("//span[normalize-space()='Add New Asset']");
public static final By assetname=By.xpath("//input[@id='form_item_name']");
public static final By assettypedrpdown=By.xpath("//input[@id='form_item_asset_type_id']");
public static final By asserttypeoptions=By.xpath("//div[@class='ant-select-item-option-content']");
public static final By locationdrpdown=By.xpath("//input[@id='form_item_location_id']");
public static final By locationdrpdownoptions=By.xpath("/html/body/div[6]/div/div/div/div[2]/div[1]/div/div/div");
public static final By serialnoinputbox=By.xpath("//input[@id='form_item_serial_number']");
public static final By createbtn=By.xpath("//span[normalize-space()='Create']");
public static final By descriptionbox=By.xpath("//textarea[@id='form_item_description']");
public static final By rowcounts=By.xpath("//tbody[@class='ant-table-tbody']//tr");
public static final By colcells=By.xpath("//tbody[@class='ant-table-tbody']//tr//td");
public static final By workingtab=By.xpath("(//div[contains(text(),'Working')])[1]");
public static final By notworkingtab=By.xpath("(//div[contains(text(),'Working')])[2]");
//notworking tab locators
public static final By assetnames=By.xpath(".//td[2]/a");
public static final By assettypes=By.xpath(".//td[3]");
public static final By lentoeles=By.xpath(".//td[5]//div");
public static final By locationeles=By.xpath(".//td[6]");
public static final By snoeles=By.xpath(".//td[7]");
public static final By statuseles=By.xpath(".//td[8]/span");
public static final By allnotworkingassetsrows=By.xpath(".//tbody//tr");

//lenttolocators
public static final By lendtousernamedrpdown=By.xpath("//input[@id='form_item_user_id']");
public static final By lendtouserdrpdownoptions=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
public static final By lenddatepicker=By.xpath("//input[@id='form_item_lend_date']");
public static final By returndatapicker=By.xpath("//input[@id='form_item_return_date']");
public static final By textareabox=By.xpath("//textarea[@id='form_item_notes']");
public static final By lendformcraetebtn=By.xpath("//span[contains(text(),'Create')]");
public static final By lendmonthele=By.xpath("//div[@class='ant-picker-header-view']//button[1]");
public static final By lendyearele=By.xpath("//div[@class='ant-picker-header-view']//button[2]");
public static final By lendmonthnextbtn=By.xpath("//button[@class='ant-picker-header-next-btn']");
public static final By lendmonthprevbutton=By.xpath("//button[@class='ant-picker-header-prev-btn']");
public static final By lendpickeralldatescells=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
public static final By returnmonthele=By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div[1]/div/button[1]");
public static final By returnyearele=By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div[1]/div/button[2]");
public static final By returnmonthfrwdbtn=By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div[1]/button[3]");
public static final By returnmonthprevbtn=By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div[1]/button[2]");
public static final By returdatealldatesele=By.xpath("/html/body/div[6]/div/div/div/div/div/div[1]/div[2]/table/tbody/tr/td/div");
//return asset lodule

}
