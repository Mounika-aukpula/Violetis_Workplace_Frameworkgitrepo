package com.violetis.Pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.violetis.Base.BasePage;
import com.violetis.Utilities.WaitUtils;
import com.violetis.Locators.Empdashboardlocators;
public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
        super(driver);
    }
	 // ===== Clock In / Clock Out Actions =====

    public void clickClockIn() {
        click(Empdashboardlocators.Clock_IN);
    }

    public void clickClockOut() {
        click(Empdashboardlocators.Clock_OUT);
    }

    public void confirmClockOutBtn() {
        click(Empdashboardlocators.confirmclockoutbtn);
    }

    public void cancelClockOutBtn() {
        click(Empdashboardlocators.confirm_cancel_clockoutbtn);
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

    /*public String getErrorMessage(){
        return getText(Empdashboardlocators.error_msg);
    }*/
}
