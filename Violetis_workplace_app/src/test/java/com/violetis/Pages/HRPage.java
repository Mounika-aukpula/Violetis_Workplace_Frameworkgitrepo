package com.violetis.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.Empdashboardlocators;
import com.violetis.Locators.HRLocators;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class HRPage extends BasePage {
	public JavaScriptUtility jsUtil;
	String expincreamnetorpromotiontype,expempname,expincsal,expincorpromdate;
	String act_policititle;
	
	public HRPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoincorpromotionmodule() {
		try {
            // Wait for main menu
            WebElement payrollmenu = WaitUtils.waitForElementVisible(driver, HRLocators.payrollbtn, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the payrolls  menu.");
            actions.moveToElement(payrollmenu).click().perform();
            
         // Wait for submenu
            WebElement incorpromotionmenu = WaitUtils.waitForElementVisible(driver, HRLocators.incorprobtn, 50);
            jsUtil=new JavaScriptUtility(driver);
            jsUtil.scrollIntoView(incorpromotionmenu);
            WaitUtils.waitForElementClickable(driver,HRLocators.incorprobtn, 50);
            try {
            	incorpromotionmenu.click();
                log.info("Clicked on increament/promotion menu using standard click.");
            } catch (Exception clickEx) {
                log.warn("Standard click failed on  increament/promotion menu Trying JS click...");
                jsUtil.clickElementByJS(incorpromotionmenu);
                log.info("Clicked on increament/promotion menu  using JS click.");
            }
            
            log.info("Clicked on the increament/promotion menu.");

        } catch (Exception e) {
            log.error("Failed to navigate to payrolls menu.", e);
            throw new RuntimeException("Navigation to payrolls failed!", e);
        }
	}
	public void clickonaddnewincorpromotionbtn() {
		WaitUtils.waitForElementClickable(driver, HRLocators.Addnewincorpromotionbtn, 30).click();
		log.info("clicked on Addnew promoiton or increamnet button");
		;
	}
	
	public void enterdataontypedropdown(String type) throws InterruptedException {
		jsUtil=new JavaScriptUtility(driver);
		// Click the input to open dropdown
		Thread.sleep(2000);
        WebElement typedropdownbtn=WaitUtils.waitForElementVisible(driver, HRLocators.typedrpdownbtn, 30);
        jsUtil.clickElementByJS(typedropdownbtn);
        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, HRLocators.typedropdownoptions, 15);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(HRLocators.typedropdownoptions);
        for (WebElement option : options) {
            if (option.getText().equals(type)) {
                option.click();
                log.info("clicked on given type data in type drop down");
                log.info("Selected user: " + type);
                break;
            }
        }
	}
	public void clicktypedropdown() throws InterruptedException {
		Thread.sleep(2000);
		WaitUtils.waitForElementVisible(driver, HRLocators.userdrpdownbtn, 20).click();
		log.info("clicked on type drop down button");
	}
	public void enterdataonuserdropdown(String empname) throws InterruptedException {
		
		// Click the input to open dropdown
		WaitUtils.waitForElementVisible(driver, HRLocators.userdrpdownbtn, 15).click();
		log.info("clicked on usr drop down");

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, HRLocators.userdrpdownoptions, 15);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(HRLocators.userdrpdownoptions);
        for (WebElement option : options) {
            if (option.getText().equals(empname)) {
                option.click();
                log.info("clicked option on user drop down");
                log.info("Selected user: " + empname);
                break;
            }
        }
	}
	public void clickonDatapicker() {
    	WaitUtils.waitForElementVisible(driver, HRLocators.Date_Time_picker_btn, 15).click();
    	log.info("clicked on datapicker");
    	
    	
    }
	 public void enterincreamentDate(String month,String year, String date) {
	    	while(true) {
	    		WebElement current_month=WaitUtils.waitForElementVisible(driver, HRLocators.month_ele, 10);
	    	         String current_month_text=current_month.getText();
	    	         System.out.println(current_month_text);
	    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, HRLocators.Year_ele, 10);
	    	         String current_year_text=current_year.getText();
	    	         System.out.println(current_year_text);
	    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
	    	         {
	    	        	 break;
	    	         }
	    	         else
	    	         {
	    	        	 WaitUtils.waitForElementVisible(driver, HRLocators.month_forward_btn, 30).click(); 
	    	         }
	    	
	    	        	 
	    	}
	        
	    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, HRLocators.alldates, 30);
	      for(WebElement dt:alldates) {
	    	  if(dt.getText().equals(date))
	    	  {
	    		  dt.click();
	    		  log.info("selected date on datapicker");
	    		  break;
	    	  }
	    	  
	      }
	        
	    }
	public void enterAnnnualsal(String sal) {
		WaitUtils.waitForElementVisible(driver, HRLocators.Annualctcinputbox, 10).sendKeys(sal);
		log.info("entered increamented salary in salary input box");
	}
	public void enterdescriptiondata(String descr) {
		WaitUtils.waitForElementVisible(driver, HRLocators.Descriptionbox, 10).sendKeys(descr);
		log.info("Entered description data on description buttton");
	}
	public void submitincorpromotionform() {
    	WaitUtils.waitForElementVisible(driver, HRLocators.submit_btn, 30).click();
    	log.info("clicked on create button or submitted the  form");
    }
	public void entercurrentdesignation(String currentdesig) {
		// Click the input to open dropdown
				WaitUtils.waitForElementVisible(driver, HRLocators.currentdesignationdropdownbtn, 15).click();
				log.info("clicked on current desgnation drop down");

		        // Wait for all options to appear
		        WaitUtils.waitForElementVisible(driver, HRLocators.currentdesignationoptions, 15);

		        // Get all options dynamically
		        List<WebElement> options = driver.findElements(HRLocators.currentdesignationoptions);
		        for (WebElement option : options) {
		            if (option.getText().equals(currentdesig)) {
		                option.click();
		                log.info("clicked option on current designation drop down");
		                log.info("Selected user: " + currentdesig);
		                break;
		            }
		        }
	}
	public void promotesdesignation(String promoteddesig) {
		// Click the input to open dropdown
		WaitUtils.waitForElementVisible(driver, HRLocators.promoteddesignationdropdown, 15).click();
		log.info("clicked on current desgnation drop down");

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, HRLocators.promotiondesignationoptions, 15);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(HRLocators.promotiondesignationoptions);
        for (WebElement option : options) {
            if (option.getText().equals(promoteddesig)) {
                option.click();
                log.info("clicked option on current designation drop down");
                log.info("Selected user: " + promoteddesig);
                break;
            }
        }
	}
	public void fillincreamentform(String type,String ename,String salary,String month,String year,String date,String desc) throws InterruptedException {
		expincreamnetorpromotiontype=type;
		expempname=ename;
		expincsal=ename;
	
		navigatetoincorpromotionmodule();
		clickonaddnewincorpromotionbtn();
		clicktypedropdown();
		enterdataontypedropdown(type);
		
		enterdataonuserdropdown(ename);
		enterAnnnualsal(salary);
		clickonDatapicker();
		enterincreamentDate(month,year,date);
		WaitUtils.waitForElementVisible(driver, HRLocators.datepicker_ok_btn, 15).click();
		enterdescriptiondata(desc);
		submitincorpromotionform();
		getSuccessPopupText();
	}
	public void fillpromotionform() {
		
	}
	public String getSuccessPopupText() {
	    try {
	        WebElement popupDesc = WaitUtils.waitForElementVisible(
	            driver,HRLocators.popuptextele,10);
	            
	       
	        String message = popupDesc.getText().trim();
	        log.info("Popup message displayed: " + message);
	        return message;
	    } catch (Exception e) {
	        log.error("Success popup not displayed.", e);
	        throw new RuntimeException("Failed to capture success popup!", e);
	    }
	}
//Add holiday ********************************************************
	public void navigatetoholidaymenu() {
		try {
            // Wait for main menu
            WebElement holidaymenu = WaitUtils.waitForElementVisible(driver, HRLocators.main_holdays_menu, 15);

            // Hover over main menu
            Actions actions = new Actions(driver);
           
            log.info("Hovered over the payrolls  menu.");
            actions.moveToElement(holidaymenu).click().perform();
            
         // Wait for submenu
            WebElement incorpromotionmenu = WaitUtils.waitForElementVisible(driver, HRLocators.sub_hldy_menu, 50);
            jsUtil=new JavaScriptUtility(driver);
            jsUtil.scrollIntoView(incorpromotionmenu);
            WaitUtils.waitForElementClickable(driver,HRLocators.sub_hldy_menu, 50);
            try {
            	incorpromotionmenu.click();
                log.info("Clicked on holidays sub menu using standard click.");
            } catch (Exception clickEx) {
                log.warn("Standard click failed on holidays sub menu Trying JS click...");
                jsUtil.clickElementByJS(incorpromotionmenu);
                log.info("Clicked on holidays sub menu  using JS click.");
            }
            
            log.info("Clicked on the holidays main menu.");

        } catch (Exception e) {
            log.error("Failed to navigate to holidays menu.", e);
            throw new RuntimeException("Navigation to holidays failed!", e);
        }
	}
	public void clickonaddnewholidaytab() {
		WaitUtils.waitForElementVisible(driver, HRLocators.Add_new_holiday_tab, 30).click();
	}
	public void enternameofholiday(String holidayname) {
		WaitUtils.waitForElementVisible(driver, HRLocators.holiday_name_inputbox, 30).sendKeys(holidayname);
	}
	public void enterholidayform(String holidayname,String month,String year,String date) {
		enternameofholiday(holidayname);
		clickonDatapicker();
		enterincreamentDate(month,year,date);
		submitincorpromotionform();
	}
	//policy adding 
	public void clickonpolicybutton() {
		WaitUtils.waitForElementVisible(driver, HRLocators.policybtn, 30).click();
	}
	public void clickaddnewpolicybtn() {
		WaitUtils.waitForElementVisible(driver, HRLocators.addnewpolibtn, 30).click();
	}
	public void enterlocation(String locationname) {
		// Click the input to open dropdown
        WaitUtils.waitForElementVisible(driver, HRLocators.locationdrpdown, 20).click();

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, HRLocators.locationdropdownoptions, 20);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(HRLocators.locationdropdownoptions);
        for (WebElement option : options) {
            if (option.getText().equals(locationname)) {
                option.click();
                log.info("Selected user: " + locationname);
                break;
            }
        }
	}
	public void enterpolicytitle(String title) {
		WaitUtils.waitForElementVisible(driver, HRLocators.policytitleinpputbox, 20).sendKeys(title);
	}
	public void enterdescription(String desc) {
		WaitUtils.waitForElementVisible(driver, HRLocators.policydescription, 20).sendKeys(desc);
	}
	public void clickcreatefile() {
		WaitUtils.waitForElementVisible(driver, HRLocators.createfileradbtn, 20).click();
	}
	public void enterletterdescription(String letter) {
		WaitUtils.waitForElementVisible(driver, HRLocators.letterdesciptionofcreatefile, 20).sendKeys(letter);
	}
	public void clickcreatebtn() {
		WaitUtils.waitForElementVisible(driver, HRLocators.createbtn, 20).click();
	}
	public void enterpolicydetails(String location,String title,String desc,String letter) {
		String act_policititle=title;
		enterlocation(location);
		enterpolicytitle(title);
		enterdescription(desc);
		clickcreatefile();
		enterletterdescription(letter);
		
		
	}
	public void clicklogout() {
    	WaitUtils.waitForElementVisible(driver, HRLocators.logout, 15).click();
    	WaitUtils.waitForElementVisible(driver,HRLocators.confirmlogout,20).click();
    }
}
