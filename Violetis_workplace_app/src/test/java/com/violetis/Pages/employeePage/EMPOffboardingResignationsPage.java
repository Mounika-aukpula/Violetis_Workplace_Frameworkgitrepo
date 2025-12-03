package com.violetis.Pages.employeePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.EmpPageLocators.EMPOFFboardingResignationsLocators;
import com.violetis.Utilities.WaitUtils;

public class EMPOffboardingResignationsPage extends BasePage{

	public EMPOffboardingResignationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoResignationsPage() {
	        try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Offboarding_btn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Resignations_btn, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Resignations submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Offboarding.", e);
	            throw new RuntimeException("Navigation to Offboarding failed!", e);
	        }
	    }
	public void clickonaddnewresignationbtn() {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Add_New_Resignation_btn, 15).click();
	}
	public void enterResignationtitle(String title) {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.title_input_box, 15).sendKeys(title);
	}
	public void enterdescription(String Desc)
	{
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Description_btn, 15).sendKeys(Desc);
	}
	public void enterResigntaionDate(String month,String year, String date) {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Resignation_date_ele, 15).click();
    	while(true) {
    		WebElement current_month=WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.month_ele, 10);
    	         String current_month_text=current_month.getText();
    	         System.out.println(current_month_text);
    	    WebElement current_year=WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.Year_ele, 10);
    	         String current_year_text=current_year.getText();
    	         System.out.println(current_year_text);
    	         if(current_month_text.equals(month) && (current_year_text.equals(year)))
    	         {
    	        	 break;
    	         }
    	         else
    	         {
    	        	 WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.month_forward_btn, 30).click(); 
    	         }
    	
    	        	 
    	}
        
    	List<WebElement> alldates=WaitUtils.waitForElementsVisible(driver, EMPOFFboardingResignationsLocators.alldates, 30);
      for(WebElement dt:alldates) {
    	  if(dt.getText().equals(date))
    	  {
    		  dt.click();
    		  clikokbtninpicker();
    		  break;
    	  }
    	  
      }
      
        
    }
	public void clikokbtninpicker() {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.resig_date_ok_btn, 30).click();
	}
	public void clickcreatebtn() {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.submit_resignation_btn, 30).click();
	}
	public void clickcancelbtn() {
		WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.cancel_btn, 30).click();
	}
	
	   // --------------------- Error / Success message handler ------------------------

    public String getSubmissionStatus() {

    	try {
            if (driver.findElement(EMPOFFboardingResignationsLocators.titlefielderrorele).isDisplayed()) {
                return "The title field is required.";
            }
        } catch (Exception e) {}

        try {
            if (driver.findElement(EMPOFFboardingResignationsLocators.descriptionerrorele).isDisplayed()) {
                return "The description field is required.";
            }
        } catch (Exception e) {}

        try {
            if (driver.findElement(EMPOFFboardingResignationsLocators.startdateerrorele).isDisplayed()) {
                return "The start date field is required.";
            }
        } catch (Exception e) {}

        // ✅ Success message
        try {
            WebElement msgEl = WaitUtils.waitForElementVisible(
                    driver,
                    EMPOFFboardingResignationsLocators.successmsgele,
                    10
            );
            return msgEl.getText().trim();
        } catch (Exception e) {
            System.out.println("Success message not found: " + e.getMessage());
        }

        // ⛔ Only returned if NOTHING found above
        return "UNKNOWN";
    }
    //***************************pending module*****************************
    public void clickPendingTab() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.pending_tab,20).click();
    }
    public String getFirstPendingTitle() {
        WebElement titleEle = WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.first_row_title,20);
        return titleEle.getText().trim();
    }

    public String getFirstPendingDate() {
        WebElement dateEle = WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.resgndate,20);
        return dateEle.getText().trim();
    }

    public void clickViewOnFirstPending() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.firstrowviewbtn,20).click();
    }

    public void clickEditOnFirstPending() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.firstroweditbtn,20).click();
    }

    public void clickDeleteOnFirstPending() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.firstrowdeletebtn,20).click();
    }

    public void confirmDelete() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.confirdelbtn,20).click();
    }
    public void cancelDelete() {
        WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.canceldelbtn,20).click();
    }
//view action methods
    public String getViewPageTitle() {
    	String act_title=WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.titleele,20).getText();
    	return act_title;
    }
    public String getViewPageDate() {
    	String act_date=WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.resigndateele,20).getText();
    	return act_date;
    }
    public void clickonviewcancelbtn() {
    	WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.cancelbtn,20).click();
    }
    //***edit btn action method
    public void editresignationform(String title,String month, String year,String day) {
    	WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.title_input_box, 15).clear();
    	enterResignationtitle(title);
    	enterResigntaionDate(month,year,day);
    }
    //***** for validating approved resignation from approved tab
    public void clikonapprovedtab() {
    	WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.approved_tab_btn, 15).click();
    }
    public void searchtitle(String title) {
    	WaitUtils.waitForElementVisible(driver, EMPOFFboardingResignationsLocators.approved_tab_btn, 15).sendKeys(title);
    }
    
}
	


