package com.violetis.Pages.ManagerDashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerPageLocators.ManagerdashboardLocators;
import com.violetis.Utilities.WaitUtils;

public class PendingApprovalsPage extends BasePage{

	public PendingApprovalsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 public int getrowcountbtndata() {
	 scrollToElement(ManagerdashboardLocators.rowscountbtn);
	 String countText= WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.rowscountbtn, 20).getText();
	 countText = countText.replaceAll("\\s+", "").trim();
	 int count = Integer.parseInt(countText);
	return count;
 }
 public void clickonleavesbtn() {
	 WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.leavesbtn, 20).click();
 }
 public void clickonexpensesbtn() {
	 WaitUtils.waitForElementVisible(driver, ManagerdashboardLocators.expensesbtn, 20).click();
 }
 public int getallrowscount() {
	List<WebElement> rows= WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.allrows, 20);
	int rowscount=rows.size();
	return rowscount;
	
 }
 public List<WebElement> getallrownames(){
	List<WebElement> names= WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.empnamesunderleavesandexpensesbtn, 10);
	return names;
 }
 public List<WebElement> getdates(){
	List<WebElement> dates= WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.dates, 10);
	return dates;
 }
 // Get view buttons
 public List<WebElement> getViewButtons() {
     return WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.allrowsviewbtns, 10);
 }
 // Click view button by row index
 public void clickViewByIndex(int index) {
     getViewButtons().get(index).click();
 }
//Get approval buttons
public List<WebElement> getapprovalbtns() {
   return WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.allrowsapprovebtns, 10);
}
// Click approval button by row index
public void clickapprovalbtns(int index) {
	getapprovalbtns().get(index).click();
}
//Get reject buttons
public List<WebElement> getrejectbtns() {
 return WaitUtils.waitForElementsVisible(driver, ManagerdashboardLocators.allrowsrejbtns, 10);
}
//Click rejec button by row index
public void clickrejectbtn(int index) {
	getrejectbtns().get(index).click();
}
// Map Pending Approvals: user -> date (extract from parentheses)
public Map<String, String> mapPendingApprovals() {
    List<WebElement> users = getallrownames();
    List<WebElement> dates = getdates();

    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < users.size(); i++) {
        String user = users.get(i).getText();
        String dateText = dates.get(i).getText();
        String date = dateText.replaceAll(".*\\((.*?)\\).*", "$1");
        map.put(user, date);
    }
    return map;
}
}
