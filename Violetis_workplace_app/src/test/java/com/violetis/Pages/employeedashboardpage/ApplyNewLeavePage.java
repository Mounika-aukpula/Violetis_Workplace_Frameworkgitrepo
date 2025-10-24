package com.violetis.Pages.employeedashboardpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Utilities.WaitUtils;

public class ApplyNewLeavePage extends BasePage {
	 public String appliedLeaveType;
	 public String appliedReason;
	 public String empname;
	 public String startdate;
	 public String enddate;
	public ApplyNewLeavePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickonAddnewLeavebtn() {
		WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Apply_new_leavebtn, 30).click();
		log.info("clicked on add new leave button");
	}
	public void Enterleavetypedrpdown(String Leavetype) {
		WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Leave_typebtn, 30).click();
		// Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Leave_type_opts, 5);
        
        List<WebElement> options = driver.findElements(Empdashboardlocators.Leave_type_opts);
        for (WebElement option : options) {
            if (option.getText().equals(Leavetype)) {
                option.click();
                log.info("Selected user: " + Leavetype);
                break;
            }
        }
	}

	public void clickondatepicker() {
		WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Datepickerbox, 30).click();
		log.info("clicked on datepicker");
	}
	public void enterfromdateLeave(String month,String year,String date) {
		while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, Empdashboardlocators.start_leave_month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Startleave_yearele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Month_forwardbtn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.alldates_indatepicker, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(date))
    	  {
    		  dt.click();
    		  log.info("entered from leave date");
    		  WebElement startDateElement = driver.findElement(Empdashboardlocators.startdateleaveele);
    		  String enteredStartDate = startDateElement.getAttribute("value");
    		  System.out.println("Start Date entered: " + enteredStartDate);
    		  this.startdate=enteredStartDate;
    		  
    		  break;
    	  }
    	  
      }
	}
	public void enddateleave(String month,String year,String date) {
		while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, Empdashboardlocators.start_leave_month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Startleave_yearele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Month_forwardbtn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, Empdashboardlocators.alldates_indatepicker, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(date))
    	  {
    		  dt.click();
    		  log.info("entered upto when applying for leave");
    		  WebElement EndDateElement = driver.findElement(Empdashboardlocators.enddateleaveele);
    		  String enteredendDate = EndDateElement.getAttribute("value");
    		  System.out.println("End Date entered: " + enteredendDate);
    		  this.enddate=enteredendDate;
    		  break;
    	  }
    	  
      }
	}
	public void getempname() {
		WebElement empname=WaitUtils.waitForElementVisible(driver, Empdashboardlocators.empname,30);
		String employeename=empname.getText();
		System.out.println("Employee Name captured: " + employeename);
		this.empname=employeename;
	}
	public void Enterreason(String reason) {
		WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Leave_reasonbox, 30).sendKeys(reason);
		log.info("entered reson for leave");
	}
	public void clickcreatebtn() {
		WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Create_btn, 30).click();
		log.info("clicked on create button for subbmiting leave form");
	}
	public void Applyforleave(String leavetype,String mon,String Year,String date,String endmonth,String endyear,String enddate,String reason) throws InterruptedException {
		this.appliedLeaveType = leavetype;
        this.appliedReason = reason;
		getempname();
		clickonAddnewLeavebtn();
		Enterleavetypedrpdown(leavetype);
		
		clickondatepicker();
		Thread.sleep(2000);
		enterfromdateLeave(mon,Year,date);
		enddateleave(endmonth,endyear,enddate);
		Enterreason(reason);
		clickcreatebtn();
		
		
	}
	
}
