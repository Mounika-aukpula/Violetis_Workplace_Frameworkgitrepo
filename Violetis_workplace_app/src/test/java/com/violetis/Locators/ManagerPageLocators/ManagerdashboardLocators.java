package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class ManagerdashboardLocators {
 //dashboard count locators
	public static final By totalemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[1]");
	public static final By totalactempcount=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[2]");
	public static final By totalinactemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[3]");
	public static final By totalempsunderyou=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[4]");
//employeestatus locators
	public static final By appcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[1]//div[2]/h3");
	public static final By expcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[2]//div[2]/h3");
	public static final By warncount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[3]//div[2]/h3");
	public static final By complaintcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[4]//div[2]/h3");
	public static final By assignedsurveycount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[5]//div[2]/h3");
	public static final By Assetslenttocount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[6]//div[2]/h3");
	public static final By selectuserdrpdown=By.xpath("(//input[contains(@id,'rc_select')])[1]");
	public static final By selectuserdrpdownoptions=By.xpath("//div[contains(@class,'ant-select-item ant-select-item-option')]");
	public static final By Thisyeardrpdown=By.xpath("//span[contains(text(),'This Year')]");
	public static final By thisyeardrpdownoptions=By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']");
	
	//top performer locators
	public static final By topperformernameatempstatus=By.xpath("(//div[@class='performer-details'])[1]/div[1]//span[1]");
	public static final By appreciationscountfortopperformeratempstatus=By.xpath("(//div[@class='performer-details'])[1]/div[2]//span[2]");
 //employee status locators
 public static final By totalempcount=By.xpath("//h2[@class='number-employee']");
 public static final By probationcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[7]/div[2]/h3");
 public static final By contractempcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[8]/div[2]/h3");
 public static final By fulltimecount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[9]/div[2]/h3");
 public static final By wfhcount=By.xpath("(//div[@class='ant-card css-gaz7ss ant-card-bordered ant-card-small'])[10]/div[2]/h3");
 public static final By topperformernameatempworksttaus=By.xpath("(//div[@class='performer-details'])[2]/div[1]//span[1]");
 public static final By appreciationscountfortopperformeratworkempsttaus=By.xpath("(//div[@class='performer-details'])[2]/div[2]//span[2]");
 //pending approvals section locators
 public static final By leavesbtn=By.xpath("//div[contains(text(),'Leaves')]");
 public static final By expensesbtn=By.xpath("(//div[@class='ant-segmented-item-label'])[2]");
 public static final By empnamesunderleavesandexpensesbtn=By.xpath("//span[@class='ant-typography css-gaz7ss']/strong");
 public static final By rowscountbtn=By.xpath("//sup[@class='ant-scroll-number ant-badge-count ant-badge-multiple-words']");
 public static final By allrows=By.xpath("(//div[@class='ant-spin-container'])[3]//li");
 public static final By dates=By.xpath("(//div[@class='ant-spin-container'])[3]//li//h4");
 public static final By actionelesofallrows=By.xpath("(//div[@class='ant-spin-container'])[3]//li//div[@class='ant-space css-gaz7ss ant-space-horizontal ant-space-align-center']");
 public static final By allrowsviewbtns=By.xpath("(//div[@class='ant-spin-container'])[3]//li//div[@class='ant-space css-gaz7ss ant-space-horizontal ant-space-align-center']/div[1]");
 public static final By allrowsapprovebtns=By.xpath("(//div[@class='ant-spin-container'])[3]//li//div[@class='ant-space css-gaz7ss ant-space-horizontal ant-space-align-center']/div[2]");
 public static final By allrowsrejbtns=By.xpath("(//div[@class='ant-spin-container'])[3]//li//div[@class='ant-space css-gaz7ss ant-space-horizontal ant-space-align-center']/div[3]");
 //weekend and holidays module
 public static final By yearpicker=By.xpath("(//div[@class='ant-card-extra'])[5]");
 public static final By yearprevbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
 public static final By yearnextbtn=By.xpath("//span[@class='ant-picker-super-next-icon']");
 public static final By yeareles=By.xpath("//div[@class='ant-picker-cell-inner']");
 public static final By holidaybtn=By.xpath("(//div[@class='ant-segmented-item-label'])[3]");
 public static final By weekendbtn=By.xpath("(//div[@class='ant-segmented-item-label'])[4]");
 public static final By holidaysnames=By.xpath("(//div[@class='notification-text']/strong)[position() >= 50]");
 public static final By holidaysdates=By.xpath("(//div[@class='notification-time'])[position()>=50]");
 public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
 public static By yearOption(String year) {
	    return By.xpath("//table[@class='ant-picker-content']//tbody//tr//td//div[text()='" + year + "']");
	}
 //employees By dept Locators
 public static final By empsdeptcanvasbarchat=By.xpath("//canvas[@id='bar-chart']");
 public static final By charttitle= By.xpath("//div[@class='ant-card-head-title'][normalize-space()='Employees By Department']");
 //performences Locators
 public static final By appreciationgraph=By.xpath("//canvas[@id='line-chart']");
 public static final By performancetitl=By.xpath("//div[contains(text(),'Performance')]");
 
}
