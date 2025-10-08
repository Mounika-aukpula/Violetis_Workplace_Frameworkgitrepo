package com.violetis.Locators;
import org.openqa.selenium.By;
public class Empdashboardlocators {
	public static final By Clock_IN = By.xpath("//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-24 ant-col-lg-8 ant-col-xl-8 css-tv86ws']//div[@class='ant-space css-tv86ws ant-space-horizontal ant-space-align-center']//div[1]//button[1]");
	public static final By Clock_OUT=By.xpath("//span[normalize-space()='Clock Out']");
	public static final By empappr=By.xpath("//body//div[@id='app']//div[@class='ant-row mb-20 css-tv86ws']//div[@class='ant-row mb-20 css-tv86ws']//div[1]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By empwar=By.xpath("//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-24 ant-col-lg-16 ant-col-xl-16 css-tv86ws']//div[2]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By emp_Expences=By.xpath("//div[3]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By emp_complaints=By.xpath("//div[4]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By empworkedtime=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[3]/span");
	public static final By emp_clockINtime=By.xpath("//p[contains(text(), 'Clock In Time')]");
	public static final By confirmclockoutbtn=By.xpath("//div[@class='ant-modal-body']//button[2]");
	public static final By confirm_cancel_clockoutbtn=By.xpath("//div[@class='ant-modal-confirm-btns']//span[contains(text(),'Cancel')]");
	public static final By error_msg=By.xpath("");
	public static final By CURRENT_DATE_TIME=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[1]/p");
	public static final By Clock_Out_Time=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[4]/div/div/div/button/span");
}
