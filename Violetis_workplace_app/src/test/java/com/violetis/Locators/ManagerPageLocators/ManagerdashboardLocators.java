package com.violetis.Locators.ManagerPageLocators;

import org.openqa.selenium.By;

public class ManagerdashboardLocators {
 //dashboard count locators
	public static final By totalemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[1]");
	public static final By totalactempcount=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[2]");
	public static final By totalinactemps=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[3]");
	public static final By totalempsunderyou=By.xpath("(//h2[@class='text-2xl font-bold text-gray-800'])[3]");
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
 
}
