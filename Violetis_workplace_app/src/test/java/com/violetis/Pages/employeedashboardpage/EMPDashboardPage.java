package com.violetis.Pages.employeedashboardpage;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.violetis.Base.BasePage;
import com.violetis.Utilities.WaitUtils;
import com.violetis.Locators.Empdashboardlocators;
public class EMPDashboardPage extends BasePage {
	public EMPDashboardPage(WebDriver driver) {
        super(driver);
    }
	 // ===== Clock In / Clock Out Actions =====

    public void clickClockIn() {
        click(Empdashboardlocators.Clock_IN);
    }

    public void clickClockOut() {
    	WaitUtils.waitForElementClickable(driver, Empdashboardlocators.Clock_OUT, 30).click();
        
    }

    public void confirmClockOutBtn() {
        click(Empdashboardlocators.confirmclockoutbtn);
    }

    public void cancelClockOutBtn() {
        click(Empdashboardlocators.confirm_cancel_clockoutbtn);
    }
    public String getClockInButtonText() {
        return getText(Empdashboardlocators.Clock_IN);
    }

    // ===== Fetch Time Info =====

    public String getClockInTime() {
        WaitUtils.waitForTextNotEmpty(driver, Empdashboardlocators.emp_clockINtime, 30);
        return getText(Empdashboardlocators.emp_clockINtime);
    }
    public String getClockOutTime() {
        WaitUtils.waitForTextNotEmpty(driver, Empdashboardlocators.Clock_Out_Time, 30);
        return getText(Empdashboardlocators.Clock_Out_Time);
    }

    public String getWorkedTime() {
        WaitUtils.waitForTextNotEmpty(driver, Empdashboardlocators.empworkedtime, 30);
        return getText(Empdashboardlocators.empworkedtime);
    }
 // Convert worked time string to Duration
    public Duration getWorkedDuration() {
        String workedTimeText = getWorkedTime(); // e.g., "Worked 1 hrs 30 mins"

        int hours = 0;
        int minutes = 0;

        // Match hours
        java.util.regex.Matcher hMatcher = java.util.regex.Pattern.compile("(\\d+)\\s*hrs?").matcher(workedTimeText);
        if (hMatcher.find()) {
            hours = Integer.parseInt(hMatcher.group(1));
        }

        // Match minutes
        java.util.regex.Matcher mMatcher = java.util.regex.Pattern.compile("(\\d+)\\s*mins?").matcher(workedTimeText);
        if (mMatcher.find()) {
            minutes = Integer.parseInt(mMatcher.group(1));
        }

        return Duration.ofHours(hours).plusMinutes(minutes);
    }


    /**
     * Checking if Clock In button is enabled
     */
    public boolean isClockInEnabled() {
        return isEnabled(Empdashboardlocators.Clock_IN);
    }

    /**
     * Check if Clock Out button is enabled
     */
    public boolean isClockOutEnabled() {
        return isEnabled(Empdashboardlocators.Clock_OUT);
    }
    public String getCurrentDateTime() {
        // Wait until text is visible and not empty
        WaitUtils.waitForTextNotEmpty(driver, Empdashboardlocators.CURRENT_DATE_TIME, 20);
        return getText(Empdashboardlocators.CURRENT_DATE_TIME).trim();
    }
    // ===== Dashboard Summary Counts =====

    public int getAppreciationsCount() {
    	 WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.emp_appreciaationcount, 10);
    	    String countText = countElement.getText().trim();
    	    return Integer.parseInt(countText);
    }

    public int getWarningsCount() {
    	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.emp_warningcount, 10);
 	    String countText = countElement.getText().trim();
 	    return Integer.parseInt(countText);
        
    }

    public int getExpensesCount() {
    	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.emp_expensecount, 10);
 	    String countText = countElement.getText().trim();
 	   return WaitUtils.waitForStableNumber(driver, Empdashboardlocators.emp_expensecount, 20);
    }

    public int getComplaintsCount() {
    	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.emp_complaintscount, 10);
 	    String countText = countElement.getText().trim();
 	    return Integer.parseInt(countText);
    }

    // Helper method to safely parse integers
    private int parseCount(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            log.warn("Unable to parse count value: " + text);
            return 0;
        }
    }
    

    /*public String getErrorMessage(){
        return getText(Empdashboardlocators.error_msg);
    }*/
    public void logout() {
    	WaitUtils.waitForElementVisible(driver, Empdashboardlocators.logoutbtn, 30).click();
    	log.info("clicked on logoutbutton");
    	WaitUtils.waitForElementVisible(driver, Empdashboardlocators.confirm_logout, 30).click();
    	log.info("clicked on confirm logout button");
    	
    }
    public void clickondashboardbtn() {
    	WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Dashboard_btn, 30);
    	WaitUtils.waitForDrawerToClose(driver,20);
    	WaitUtils.waitForElementClickable(driver,Empdashboardlocators.Dashboard_btn,30).click();    
    	}
	
//**************Leave  details section******
// get leave details count from empdashboard
public int gettotalleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.All_leave_count, 10);
	    String countText = countElement.getText().trim();
	    return Integer.parseInt(countText);
	 
}
public int getApprovedleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Approved_leave_count, 10);
    String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getRejectdleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Rej_Leave_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getPendingleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Pending_leave_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getPaidleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Payed_leave_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getunpaidleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Unpaid_leave_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getHalfdayleavecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.Half_day_leave_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
//*******get attendence details counts
public int gettotalattendencecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.totalattendencecount,20);

    // Wait until element has actual data
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(d -> {
            String text = countElement.getText().trim();
            return !text.isEmpty() && !text.equals("0");
        });
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getpresentcount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.present_count,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getleavescount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.leavecount,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int gethalfdaycount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.halfdaycount,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
public int getlateattendencecount() {
	WebElement countElement = WaitUtils.waitForElementVisible(driver, Empdashboardlocators.lateattendencecount,10);
	String countText = countElement.getText().trim();
    return Integer.parseInt(countText);
}
//*****increamnet/promotion module
public void validateincorprommodulewithnoprom() {
	
}
}

