package com.violetis.Pages.HrPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.ExpensesLocators;
import com.violetis.Locators.hrlocators.HRExpensesLocators;
import com.violetis.Locators.hrlocators.HRResignationLocators;
import com.violetis.Utilities.WaitUtils;

public class HRExpensesPage extends BasePage{

	public HRExpensesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public void navigatetoecpensesmodule() {
        try {
            // Wait for main menu
            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.finance_btn, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the main menu.");
            actions.moveToElement(mainMenu).click().perform();

            // Wait for submenu
            WebElement subMenu = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.expenses_submenu, 15);
            actions.moveToElement(subMenu).click().perform();
            
            log.info("Clicked on the expenses submenu.");

        } catch (Exception e) {
            log.error("Failed to navigate to finance.", e);
            throw new RuntimeException("Navigation to finance failed!", e);
        }
    
}
public void approveExpense(String expectedUser, String expectedExpenseType,String expecteddate) throws InterruptedException {
    List<WebElement> rows = WaitUtils.waitForElementsVisible(driver, HRExpensesLocators.allrows, 15);

    for (WebElement row : rows) {

        String user = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.usernamecoleles, 15).getText().trim();
        String expenseType = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.expensetypeeles, 15).getText().trim();
        String dateele=WaitUtils.waitForElementVisible(driver, HRExpensesLocators.dateeles, 25).getText().trim();
        System.out.println(user);
        System.out.println(expenseType);
        System.out.println(dateele);
        if (user.equalsIgnoreCase(expectedUser) &&
            expenseType.equalsIgnoreCase(expectedExpenseType)&&dateele.equalsIgnoreCase(expecteddate)) {
        	Thread.sleep(2000);            // Click Approve button in that row (column 3)
        	WaitUtils.waitForElementVisible(driver, HRExpensesLocators.updatestatusbtn, 25).click();
            break;
        }
    }
}
public void clickdatepicker() {
	WaitUtils.waitForElementVisible(driver, HRExpensesLocators.datetimepicker, 25).click();
}
public void enterExpenseraisedDate(String month, String year, String date) {

    while (true) {
        String currentMonth = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.month_ele, 20).getText();
        String currentYear  = WaitUtils.waitForElementVisible(driver, HRExpensesLocators.Year_ele, 10).getText();

        if (currentMonth.startsWith(month) && currentYear.equals(year)) {
            break;
        } else {
            driver.findElement(HRExpensesLocators.month_forward_btn).click();
        }
    }

    List<WebElement> allDates = WaitUtils.waitForElementsVisible(driver, HRExpensesLocators.alldates, 30);

    boolean currentMonthStarted = false;

    for (WebElement dt : allDates) {

        String day = dt.getText().trim();

        // Start selecting only after "1" appears
        if (day.equals("1")) {
            currentMonthStarted = true;
        }

        if (currentMonthStarted && day.equals(date)) {
            dt.click();
            WaitUtils.waitForElementVisible(driver, HRExpensesLocators.date_picker_ok_btn, 30).click();
            break;
        }
    }
}

public void clickaccounttypedrpdonw(String acttype) {
	 WaitUtils.waitForElementVisible(driver, HRExpensesLocators.selectactdrpdownbox, 30).click();
	 WaitUtils.waitForElementVisible(driver, HRExpensesLocators.accountoption(acttype), 30).click();
}
public void clickupdatebtn() {
	 WaitUtils.waitForElementVisible(driver, HRExpensesLocators.updatebtn, 30).click();
}
public void approveexpenseformfill(String month,String year,String day,String acttype ) {
	clickdatepicker();
	enterExpenseraisedDate(month,year,day);
	clickaccounttypedrpdonw(acttype);
	clickupdatebtn();
	
	
}
public void Rejectexpenseformfill() {
	WaitUtils.waitForElementVisible(driver, HRExpensesLocators.rejbtn, 30).click();
	clickupdatebtn();
}
}
