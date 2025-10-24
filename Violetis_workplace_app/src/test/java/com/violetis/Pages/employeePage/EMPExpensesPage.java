package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.EmpPageLocators.ExpensesLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPExpensesPage extends BasePage {

	public EMPExpensesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonexpensesbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.Expencesbtn, 30).click();
	}
	public void clickonAddnewExpense() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.add_new_expense_btn, 30).click();
		
	}
	public void enterExpensetype(String exptype)
	{
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.Expense_category, 30).click();
		// Wait for all options to appear
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.expense_options, 5).click();
		
	}
	public void enteramount(String amt) {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.Amount, 30).sendKeys(amt);
	}
	 public void clickonDatapicker() {
	    	WaitUtils.waitForElementVisible(driver,ExpensesLocators.date_time_picker_btn , 15).click();
	    	
	    	
	    }
	 public void enterExpenseraisedDate(String month,String year, String date) {
	    	while(true) {
	    		WebElement current_month=WaitUtils.waitForElementVisible(driver, ExpensesLocators.month_ele, 10);
	    	         String current_month_text=current_month.getText();
	    	         System.out.println(current_month_text);
	    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, ExpensesLocators.Year_ele, 10);
	    	         String current_year_text=current_year.getText();
	    	         System.out.println(current_year_text);
	    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
	    	         {
	    	        	 break;
	    	         }
	    	         else
	    	         {
	    	        	 WaitUtils.waitForElementVisible(driver, ExpensesLocators.month_forward_btn, 30).click(); 
	    	         }
	    	}
	    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, ManagerLocators.alldates, 30);
	        for(WebElement dt:alldates) {
	      	  if(dt.getText().equals(date))
	      	  {
	      		  dt.click();
	      		  break;
	      	  }
	      	  
	        }
	    	        	 
	    	}
	 public void clickondatepickerokbtn() {
		 WaitUtils.waitForElementVisible(driver,ExpensesLocators.date_picker_ok_btn , 15).click();
	 }
	 public void submitappreciaationform() {
	    	WaitUtils.waitForElementVisible(driver, ExpensesLocators.submit_expense_btn, 30).click();
	    }
	
	public void enterexpensedetails(String Expensetype,String amount,String month,String year,String date)
	{
		enterExpensetype(Expensetype);
		enteramount(amount);
		clickonDatapicker();
		enterExpenseraisedDate(month,year,date);
		clickondatepickerokbtn();
		submitappreciaationform();
		
	}

}
