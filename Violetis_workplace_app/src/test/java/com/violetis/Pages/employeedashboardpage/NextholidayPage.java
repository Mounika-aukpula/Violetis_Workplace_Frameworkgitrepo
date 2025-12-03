package com.violetis.Pages.employeedashboardpage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Utilities.WaitUtils;

public class NextholidayPage extends BasePage {
	public  DateTimeFormatter tableFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public DateTimeFormatter dashboardFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
	public NextholidayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public String getnextholiday() {
	WebElement TextElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.upcominghldyele,20);
	String upcominghldtext=TextElement.getText();
	return upcominghldtext;
}
public void clickonviewall() throws InterruptedException {
	Thread.sleep(2000);
	WaitUtils.waitForElementVisible(driver, Empdashboardlocators.viewallbtn,30).click();
}

public void verifyholidaypageopened() throws InterruptedException   {
	Thread.sleep(2000);
	 WaitUtils.waitForElementVisible(driver, Empdashboardlocators.holidaypgheader, 20);
     String header = driver.findElement(Empdashboardlocators.holidaypgheader).getText().trim();
     Assert.assertTrue(header.equalsIgnoreCase("Holidays") || header.contains("Holiday"),
             "❌ Holidays page not opened properly! Found header: " + header);
}


 }