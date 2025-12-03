package com.violetis.Pages.employeedashboardpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Utilities.WaitUtils;

public class Policypage extends BasePage{

	public Policypage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public String getlatestpolicyname() {
	WebElement TextElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.latestpolicyname,10);
	String nopromtext=TextElement.getText();
	return nopromtext;
}
public void clickviewallbtn() {
	WaitUtils.waitForElementClickable(driver, Empdashboardlocators.poliviewallbutton, 30).click();
}

}
