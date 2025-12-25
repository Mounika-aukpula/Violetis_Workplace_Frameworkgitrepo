package com.violetis.Pages.ManagerDashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPstatusPage extends BasePage{

	public EMPstatusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public String gettopperformername() {
	String topperformernameatempstatus= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.topperformernameatempstatus, 10).getText();
	return topperformernameatempstatus;
}
public String gettopperformerappcount() {
	String topperformerappreciationcountatempstatus= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.appreciationscountfortopperformeratempstatus, 10).getText();
	return topperformerappreciationcountatempstatus;
}
public int getappcount() {
	String appcount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.appcount, 10).getText();
	int appreciationcount=Integer.parseInt(appcount);
	return appreciationcount;
}
public int getexpensescount() {
	String expcount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.expcount, 10).getText();
	int expensescount=Integer.parseInt(expcount);
	return expensescount;
}
public int getwarncount() {
	String warncount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.warncount, 10).getText();
	int warningscount=Integer.parseInt(warncount);
	return warningscount;
}
public int getAssignedsurvey() {
	String surveycount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.assignedsurveycount, 10).getText();
	int Asssurveycount=Integer.parseInt(surveycount);
	return Asssurveycount;
}
public int getAssetslentto() {
	String assetscount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.Assetslenttocount, 10).getText();
	int assetslentto=Integer.parseInt(assetscount);
	return assetslentto;
}
public int getcomplaints() {
	String complaintscount=WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.complaintcount, 10).getText();
	int complaintcount=Integer.parseInt(complaintscount);
	return complaintcount;
}
public void selectuser(String empname) {
	
		 WaitUtils.waitForElementClickable(driver,ManagerdashboardLocators.selectuserdrpdown , 30).click();
		// Wait for all options to appear
	        WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.selectuserdrpdownoptions, 20);
	        
	        List<WebElement> options = driver.findElements( ManagerdashboardLocators.selectuserdrpdownoptions);
	        for (WebElement option : options) {
	            if (option.getText().equals(empname)) {
	                option.click();
	                log.info("Selected user: " +empname);
	                break;
	            }
	        }
}
public void Thisyeardrpdown(String dataoption) {

	 WaitUtils.waitForElementClickable(driver,ManagerdashboardLocators.Thisyeardrpdown , 30).click();
	// Wait for all options to appear
       WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.thisyeardrpdownoptions, 20);
       
       List<WebElement> options = driver.findElements(ManagerdashboardLocators.thisyeardrpdownoptions);
       for (WebElement option : options) {
           if (option.getText().equals(dataoption)) {
               option.click();
               log.info("Selected user: " +dataoption);
               break;
           }
       }
}

}
