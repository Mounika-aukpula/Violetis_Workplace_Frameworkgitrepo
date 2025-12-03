package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.EmpPageLocators.EMPComplaintLocators;
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
	        WaitUtils.waitForElementVisible(driver, ExpensesLocators.expence_caterogiry_drpdown_options, 5);

	        // Get all options dynamically
	        List<WebElement> options = driver.findElements(EMPComplaintLocators.to_staff_drp_options);
	        for (WebElement option : options) {
	            if (option.getText().equals(exptype)) {
	                option.click();
	                log.info("Selected user: " + exptype);
	                break;
	            }
	        }
	}
	public void enteramount(String amt) {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.Amount, 30).sendKeys(amt);
	}
	 public void clickonDatapicker() {
	    	WaitUtils.waitForElementVisible(driver,ExpensesLocators.date_time_picker_btn , 15).click();
	    	
	    	
	    }
	/* public void enterExpenseraisedDate(String month,String year, String date) {
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
	    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, ExpensesLocators.alldates, 30);
	        for(WebElement dt:alldates) {
	      	  if(dt.getText().equals(date))
	      	  {
	      		  dt.click();
	      		WaitUtils.waitForElementVisible(driver, ExpensesLocators.date_picker_ok_btn, 30).click();
	      		  
	      		  break;
	      	  }
	      	  
	        }
	    	        	 
	    	}*/
	 public void enterExpenseraisedDate(String month, String year, String date) {

		    while (true) {
		        String currentMonth = WaitUtils.waitForElementVisible(driver, ExpensesLocators.month_ele, 20).getText();
		        String currentYear  = WaitUtils.waitForElementVisible(driver, ExpensesLocators.Year_ele, 10).getText();

		        if (currentMonth.startsWith(month) && currentYear.equals(year)) {
		            break;
		        } else {
		            driver.findElement(ExpensesLocators.month_forward_btn).click();
		        }
		    }

		    List<WebElement> allDates = WaitUtils.waitForElementsVisible(driver, ExpensesLocators.alldates, 30);

		    boolean currentMonthStarted = false;

		    for (WebElement dt : allDates) {

		        String day = dt.getText().trim();

		        // Start selecting only after "1" appears
		        if (day.equals("1")) {
		            currentMonthStarted = true;
		        }

		        if (currentMonthStarted && day.equals(date)) {
		            dt.click();
		            WaitUtils.waitForElementVisible(driver, ExpensesLocators.date_picker_ok_btn, 30).click();
		            break;
		        }
		    }
		}
	 public void enterreferencenumber(String refno) {
		 WaitUtils.waitForElementVisible(driver,ExpensesLocators.refernce_inputbox , 25).sendKeys(refno);
	 }
	 public void enternotes(String notes) {
		 WaitUtils.waitForElementVisible(driver,ExpensesLocators.notes_input_box , 15).sendKeys(notes);
	 }
	 public void clickondatepickerokbtn() {
		 WaitUtils.waitForElementVisible(driver,ExpensesLocators.date_picker_ok_btn , 15).click();
	 }
	 public void submitappreciaationform() {
	    	WaitUtils.waitForElementVisible(driver, ExpensesLocators.submit_expense_btn, 30).click();
	    }
	 public void uploadBill(String filePath) {
		    
		  WaitUtils.waitForElementVisible(driver,ExpensesLocators.expensebill,20).click();
		  WebElement fileInput =WaitUtils.waitForElementVisible(driver,ExpensesLocators.file , 15);
			    
		  fileInput.sendKeys(filePath);
		    
		}
	
	public void enterexpensedetails(String Expensetype,String amount,String month,String year,String date,String refno,String notes) throws InterruptedException
	{
		enterExpensetype(Expensetype);
		Thread.sleep(2000);
		enteramount(amount);
		clickonDatapicker();
		enterExpenseraisedDate(month,year,date);
		enterreferencenumber(refno);
		enternotes(notes);
		
		clickondatepickerokbtn();
		submitappreciaationform();
		
	}
	public String getExpenseTypeError() {
		try {
			String expenseerror=WaitUtils.waitForElementVisible(driver, ExpensesLocators.expensetypeerrorele, 30).getText();
			return expenseerror;
		}
		 catch (Exception e) {
		        return null;  // No error message
		    }
	}
	public String getAmountError() {
		try {
			String amounterror=WaitUtils.waitForElementVisible(driver, ExpensesLocators.amterror_ele, 30).getText();
			return amounterror;
		}
		 catch (Exception e) {
		        return null;  // No error message
		    }
	}
	public void clickcancelbtn() {
		 WaitUtils.waitForElementVisible(driver,ExpensesLocators.cancel_btn , 30).click();
	}
	//******* validations on pendingtab*******
	public String  getfirstrowexpensetype() {
		String firstrowexpensetype=WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowexpensetypeele, 30).getText();
		return firstrowexpensetype;
	}
	public String  getfirstrowamount() {
		String firstrowamount=WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowamountele, 30).getText();
		return firstrowamount;
	}
	public String getfirstDatetime() {
		String firstrowdatetimeele=WaitUtils.waitForElementVisible(driver, ExpensesLocators.Datetimeele, 30).getText();
		return firstrowdatetimeele;
	}
	public String getfirstrowstatus() {
		String firstrowstatusele=WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowstatusele, 30).getText();
		return firstrowstatusele;
	}
	public void clickfirstrowviewbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowviewbtn, 30).click();
	}
	public void clickfirstroweditbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstroweditbtn, 30).click();
	}
	public void clickfirstrowdelbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowdelbtn, 30).click();
	}
	public void clickfirstrowdownloadbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowdwnldbtn, 30).click();
	}
	//viewbtn validation on pending tab
	public String getviewbtnexpensetypedata() {
		String viewbtnexpensetypedata=WaitUtils.waitForElementVisible(driver, ExpensesLocators.viewexpensetypedata, 30).getText();
		return viewbtnexpensetypedata;
	}
	public String getviewbtnamountdata() {
		String viewbtnamountdata=WaitUtils.waitForElementVisible(driver, ExpensesLocators.viewbtnamtdata, 30).getText();
		return viewbtnamountdata;
	}
	public String getviewbtnrefno() {
		String viewbtnrefno=WaitUtils.waitForElementVisible(driver, ExpensesLocators.viewbtnrefnodate, 30).getText();
		return viewbtnrefno;
	}
	public String getviewbtnDatetime() {
		String viewbtnDatetime=WaitUtils.waitForElementVisible(driver, ExpensesLocators.viewbtndatedate, 30).getText();
		return viewbtnDatetime;
	}
	public String getviewbtnnotes() {
		String viewbtnnotes=WaitUtils.waitForElementVisible(driver, ExpensesLocators.viewbtnnotesdata, 30).getText();
		return viewbtnnotes;
	}
	public void clickcrossbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.crossbtn, 30).click();
	}
	// edit btn methods 
	public void clickupdatebtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.updatebtn, 30).click();
	}
	public void clickeditbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstroweditbtn, 30).click();
	}
	public void clearamtdata() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.Amount, 30).clear();
	}
	public void clearrefno() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.refernce_inputbox, 30).clear();
	}
	public void clearnotes() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.notes_input_box, 30).clear();
	}
	public void editform(String expensetype,String amt,String month,String year,String Day,String refno,String notes) throws InterruptedException {
		enterExpensetype(expensetype);
		Thread.sleep(2000);
		clearamtdata();
		enteramount(amt);
		clickonDatapicker();
		enterExpenseraisedDate(month,year,Day);
		clearrefno();
		enterreferencenumber(refno);
		clearnotes();
		enternotes(notes);
		
		clickondatepickerokbtn();
		clickupdatebtn();
	}
	//del btn validation
	public void clickdelbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowdelbtn, 30).click();
	}
	public void clickdownloadbtn() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowdwnldbtn, 30).click();
	}
	//for approved tab validation*************************************
	public void approvedtab() {
		WaitUtils.waitForElementVisible(driver, ExpensesLocators.approved_tab, 30).click();
	}
	public String getfirstrowappexptype() {
		String appexptype=WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowapprovedexpensetypeeletext, 30).getText();
		return appexptype;
	}
	public String getfirstrowappstatusele() {
		String appstatus=WaitUtils.waitForElementVisible(driver, ExpensesLocators.firstrowapprovedsttausele, 30).getText();
		return appstatus;
	}
}
