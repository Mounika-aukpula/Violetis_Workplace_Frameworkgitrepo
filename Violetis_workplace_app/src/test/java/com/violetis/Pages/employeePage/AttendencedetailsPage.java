package com.violetis.Pages.employeePage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.violetis.Base.BasePage;
import com.violetis.Locators.EmpPageLocators.AttendenceDetailsLocators;
import com.violetis.Locators.EmpPageLocators.EmpAttendencePageLocators;
import com.violetis.Locators.EmpPageLocators.EmpHolidayLocators;
import com.violetis.Utilities.JavaScriptUtility;
import com.violetis.Utilities.WaitUtils;

public class AttendencedetailsPage extends BasePage {

	public AttendencedetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoAttendencedetails() {
		 try {
             // Wait for main menu
             WebElement Attendence_Menu = WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.Attendencebtn, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Attendence  menu.");
             actions.moveToElement(Attendence_Menu).click().perform();
             
          // Wait for submenu
             WebElement Attendencedetails_Menu = WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.Attendencedetailsbtn, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(Attendencedetails_Menu);
             WaitUtils.waitForElementClickable(driver, EmpAttendencePageLocators.Attendencedetailsbtn, 50);
             try {
            	 Attendencedetails_Menu.click();
                 log.info("Clicked on Attendencedetails_Menu using standard click.");
             } catch (Exception clickEx) {
                 log.warn("Standard click failed on  Attendencedetails_Menu. Trying JS click...");
                 jsUtil.clickElementByJS(Attendencedetails_Menu);
                 log.info("Clicked on Attendence details menu  using JS click.");
             }
             
             log.info("Clicked on the Attendence details menu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Attendence menu.", e);
             throw new RuntimeException("Navigation to Attendence failed!", e);
         }
	}
	public int getLateAttendanceDays(WebElement element) {
	    String text = element.getText(); // e.g. "20 Days (20.09%)"
	    
	    Pattern pattern = Pattern.compile("\\d+"); // matches the first number
	    Matcher matcher = pattern.matcher(text);
	    
	    if (matcher.find()) {
	        return Integer.parseInt(matcher.group()); // returns 20
	    }
	    
	    return 0; // default if no number found
	}
	public void clickonyearpicker() {
		WaitUtils.waitForElementVisible(driver, EmpAttendencePageLocators.yeardrpdownbtn, 50).click();
		log.info("clicked on yer picker");
	}
	public void enterYearOnYearPicker() throws InterruptedException {
	    int currentYear =LocalDate.now().getYear();
	    System.out.println("Current year = " + currentYear);

	    while (true) {
	        try {
	            // Re-find the visible year range every iteration to avoid stale element
	            WebElement rangeElem = WaitUtils.waitForElementClickable(driver, EmpAttendencePageLocators.yearpickeryearrangeele, 30);
	            String[] years = rangeElem.getText().split("-");
	            int startYear = Integer.parseInt(years[0].trim());
	            int endYear = Integer.parseInt(years[1].trim());

	            // Check if current year is within the visible range
	            if (currentYear >= startYear && currentYear <= endYear) {
	                // Re-find all year elements
	                List<WebElement> yearElements = WaitUtils.waitForElementsVisible(driver, EmpAttendencePageLocators.yearele, 10);

	                boolean yearClicked = false;
	                for (WebElement yearElem : yearElements) {
	                    int year = Integer.parseInt(yearElem.getText().trim());
	                    if (year == currentYear) {
	                        // JS click to avoid stale element issues
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearElem);
	                        yearClicked = true;
	                        break;
	                    }
	                }

	                if (yearClicked) {
	                    
	                    break; // exit while loop once year is clicked
	                }
	            } 
	            else if (currentYear > endYear) {
	                // Click Next
	                driver.findElement(EmpAttendencePageLocators.yearfrwdbtn).click();
	                Thread.sleep(500); // wait for DOM update
	            } 
	            else if (currentYear < startYear) {
	                // Click Previous
	                driver.findElement(EmpAttendencePageLocators.yearbackwardbtn).click();
	                Thread.sleep(500); // wait for DOM update
	            }
	        } catch (StaleElementReferenceException e) {
	            // Retry automatically
	        }
	    }
	    System.out.println("✅ Current year selected successfully: " + currentYear);
	}
	public int getTotalLateLogins() throws InterruptedException {
	    int totalLateDays = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January
	    JavaScriptUtility jsUtil = new JavaScriptUtility(driver);

	    // Open the month dropdown initially
	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        String monthName = Month.of(month).getDisplayName(TextStyle.FULL, Locale.ENGLISH); // "January", "February"

	        // Scrollable container for virtual list
	        WebElement container = driver.findElement(By.cssSelector(".rc-virtual-list-holder"));
	        boolean monthFound = false;
	        int maxScrolls = 10;
	        int scrolls = 0;

	        while (!monthFound && scrolls < maxScrolls) {
	            // Wait for visible month options
	            List<WebElement> months = WaitUtils.waitForElementsVisible(driver, EmpAttendencePageLocators.monthdrpdownbtnoptions, 50);

	            for (WebElement m : months) {
	                if (m.getText().equalsIgnoreCase(monthName)) {
	                    jsUtil.clickElementByJS(m); // Use JavaScriptUtility to click
	                    monthFound = true;
	                    break;
	                }
	            }

	            if (!monthFound) {
	                // Scroll up slightly if month not found
	                jsUtil.scrollUp(50); // Scroll up using JS utility
	                Thread.sleep(200); // wait for DOM to update
	                scrolls++;
	            }
	        }

	        if (!monthFound) {
	            throw new RuntimeException("Month '" + monthName + "' not found after scrolling");
	        }

	        // Wait for table/dashboard to refresh (replace Thread.sleep with explicit wait if possible)
	        Thread.sleep(500);

	        // Capture late login element
	        WebElement lateCountElem = driver.findElement(EmpAttendencePageLocators.lateloginele);

	        // Use your existing method to get days
	        int days = getLateAttendanceDays(lateCountElem);

	        System.out.println(monthName + " → Late login days = " + days);

	        // Add to total sum
	        totalLateDays += days;

	        // Re-open dropdown for next iteration if needed
	        if (month < currentMonth) {
	            driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();
	        }
	    }

	    System.out.println("✅ Total late login days from Jan → Current month = " + totalLateDays);
	    return totalLateDays;
	}

	public int getTotalAttendanceCount() throws InterruptedException {
	    int totalAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update

	        // Get all present icons
	        List<WebElement> presentList = driver.findElements(EmpAttendencePageLocators.presentcheckele);
	        // Get all leave icons
	        List<WebElement> leaveList = driver.findElements(EmpAttendencePageLocators.leavecarele);

	        // Add this month's attendance to total
	        totalAttendance += presentList.size() + leaveList.size();
	    }

	    return totalAttendance;
	}
	public int getpresentdayscount() throws InterruptedException {
		int totalpresentAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update

	        // Get all present icons
	        List<WebElement> presentList = driver.findElements(EmpAttendencePageLocators.presentcheckele);
	        totalpresentAttendance+=presentList.size();
	    }
	    return totalpresentAttendance;
}
	public int getabsentcount() throws InterruptedException {
		int totalabsentAttendance = 0;
	    int currentMonth = LocalDate.now().getMonthValue(); // 1 = January

	    driver.findElement(EmpAttendencePageLocators.monthdrpdwnbtn).click();

	    for (int month = 1; month <= currentMonth; month++) {
	        // Convert month to proper name like "January", "February"
	        String monthName = Month.of(month)
	                                .getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

	        // Select the month from dropdown
	        List<WebElement> months = driver.findElements(EmpAttendencePageLocators.monthdrpdownbtnoptions);
	        for (WebElement m : months) {
	            if (m.getText().equalsIgnoreCase(monthName)) {
	                m.click();
	                break;
	            }
	        }

	        Thread.sleep(5000); // Wait for calendar to update
	     // Get all leave icons
	        List<WebElement> leaveList = driver.findElements(EmpAttendencePageLocators.leavecarele);

	        totalabsentAttendance+=leaveList.size();
	}
	    return totalabsentAttendance;
}
// Attendence details page validation methods**********************************
	public String getPresentDays() {
		return WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.presentworkingdaysele, 30).getText().trim();
		}
	public String getdispalyedTotalOfficeTime() {
        return WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.totalofficetimele, 30).getText().trim();
    }

    public String getDisplayedTotalWorkedTime() {
        return WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.Totworkedtimeele, 30).getText().trim();
    }

    public String getLateValue() {
        return WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.lateattendencecountele, 30).getText().trim();
    }

    public String getHalfDays() {
        return WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.halfdayele, 30).getText().trim();
    }
    /** ✅ Get all "Clocked Time" values for Present days and return total in minutes */
    public int getTotalClockedMinutesFromTable() {
        List<WebElement> allRows = WaitUtils.waitForElementsPresence(driver, AttendenceDetailsLocators.attendencerows, 30);
        int totalMinutes = 0;

        for (WebElement row : allRows) {
            String status =WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.allrowsstatuseles, 30).getText().trim();
            if (status.equalsIgnoreCase("Present")) {
                String clockedTime = WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.allrowsclockedtimes, 30).getText().trim(); // e.g., "8 hrs 25 mins" or "1 hrs 19 mins"
                totalMinutes += convertToMinutes(clockedTime);
            }
        }
        return totalMinutes;
    }
    /** Convert "X hrs Y mins" → total minutes */
    private int convertToMinutes(String timeText) {
        int hours = 0, minutes = 0;
        if (timeText.contains("hrs")) {
            hours = Integer.parseInt(timeText.split("hrs")[0].trim());
        }
        if (timeText.contains("mins")) {
            String minPart = timeText.substring(timeText.indexOf("hrs") + 3).replace("mins", "").trim();
            try {
                minutes = Integer.parseInt(minPart);
            } catch (Exception ignored) {}
        }
        return (hours * 60) + minutes;
    }

    /** Convert minutes to "X hrs Y mins" */
    public String convertToHrMinFormat(int totalMinutes) {
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        return hours + " hrs " + minutes + " mins";
    }
    public int getWorkingDays() {
    	String presentDaysText=getPresentDays(); // e.g. "9/13"
        return Integer.parseInt(presentDaysText.split("/")[0].trim());
    }
    public String calculateExpectedOfficeTime() {
        int workingDays = getWorkingDays();
        double totalHours = workingDays * 8.5; // 8.5 hours per day

        int hrs = (int) totalHours;
        int mins = (int) Math.round((totalHours - hrs) * 60);

        return String.format("%d hrs %d mins", hrs, mins);
    }
    //validate present/workingdays ele
 // Get the text like "9 / 13 Days"
    public String getPresentDaysText() {
    	String presentDaysText=WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.presentworkingdaysele, 30).getText().trim();
        return presentDaysText;
    }

    // Extract present and working days from the text
    public int getPresentDaysFromCard() {
        String text = getPresentDaysText(); // e.g., "9 / 13 Days"
        return Integer.parseInt(text.split("/")[0].trim());
    }

    public int getWorkingDaysFromCard() {
        String text = getPresentDaysText();
        return Integer.parseInt(text.split("/")[1].replaceAll("[^0-9]", "").trim());
    }

    public int getPresentDayscountFromTable() {
        int count = 0;
        List<WebElement> statusesRows=WaitUtils.waitForElementsPresence(driver, AttendenceDetailsLocators.allrowsstatuseles, 30);
        for (WebElement statusCell :statusesRows) {
            String status = statusCell.getText().trim().toLowerCase();
            if (status.equalsIgnoreCase("present")) {
                count++;
            }
        }
        return count;
    }
    public int getRowCount() {
    	 List<WebElement> tableRows= WaitUtils.waitForElementsPresence(driver, AttendenceDetailsLocators.attendencerows, 30);
        return tableRows.size();
    }
    //validate late attendence
    public String getLateValuefromattendencedetails() {
    	WebElement lateattval=WaitUtils.waitForElementPresence(driver, AttendenceDetailsLocators.lateattendencecountele, 30);
        return lateattval.getText().trim();
    }
    public int getLateCountFromTable() {
        try {
        	List<WebElement> lateattendencetableRows= WaitUtils.waitForElementsPresence(driver, AttendenceDetailsLocators.lateattendencerowsele, 30);
            int count = 0;
            
            for (WebElement lateattcell : lateattendencetableRows) {
                String text = lateattcell.getText().trim();
                if (!text.isEmpty() && text.equalsIgnoreCase("Late")) {
                    count++;
                }
            }
            return count;
        } catch (Exception e) {
            System.out.println("⚠️ No 'Late' entries found: " + e.getMessage());
            return 0;
        }
    }
    // ✅ Get Late Attendance rows safely
    public int getLateAttendanceRows() {
        List<WebElement> lateRows;
        try {
        	lateRows = WaitUtils.waitForElementsPresence(driver, AttendenceDetailsLocators.lateattendencerowsele, 10);
            System.out.println("🔹 Found " + lateRows.size() + " Late Attendance rows.");
        } catch (Exception  e) {
            lateRows = new ArrayList<>();
            System.out.println("ℹ️ No 'Late Attendance' rows found in table.");
        }
        return lateRows.size();
    }
    //validating emp attendence details table using cross module validation from manager
    public List<Map<String, String>> getEmployeeAttendanceTableData() {
        List<Map<String, String>> attendanceData = new ArrayList<>();
        List<WebElement> rows = driver.findElements(AttendenceDetailsLocators.attendencerows);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            Map<String, String> rowData = new LinkedHashMap<>();

            try {
                // Extract text for each column safely
                String date = getTextSafe(row, AttendenceDetailsLocators.DATE_COL);
                String status = getTextSafe(row, AttendenceDetailsLocators.STATUS_COL);
                String clockIn = getTextSafe(row, AttendenceDetailsLocators.CLOCKIN_COL);
                String clockOut = getTextSafe(row, AttendenceDetailsLocators.CLOCKOUT_COL);
                String clockedTime = getTextSafe(row, AttendenceDetailsLocators.CLOCKEDTIME_COL);
                //String otherDetails = getTextSafe(row, AttendenceDetailsLocators.OTHERDETAILS_COL);

                rowData.put("Date", date);
                rowData.put("Status", status);
                rowData.put("ClockIn", clockIn);
                rowData.put("ClockOut", clockOut);
                rowData.put("ClockedTime", clockedTime);
                //rowData.put("OtherDetails", otherDetails);

                attendanceData.add(rowData);

            } catch (Exception e) {
                System.out.println("⚠️ Error reading row " + (i + 1) + ": " + e.getMessage());
            }
        }

        System.out.println("✅ Total rows fetched: " + attendanceData.size());
        return attendanceData;
    }

    private String getTextSafe(WebElement parent, By locator) {
        try {
            WebElement element = parent.findElement(locator);
            String text = element.getText().trim();
            return text.isEmpty() ? "--" : text;
        } catch (NoSuchElementException e) {
            return "--";
        }
    }
   
    //Attendence summery page validation from Attendence details page
    /** Extract only date number (e.g. "14" from "14 Nov 2025") */
    private String extractDay(String fullDate) {
        return fullDate.substring(0, 2).trim();
    }
    /** Get only date number from first column */
    private String getDayNumberFromRow(WebElement row) {
        String fullDate = row.findElement(By.xpath(".//td[1]")).getText().trim();
        return extractDay(fullDate);  
    }
    /** Get status from second column: td[2]/span */
    private String getStatusFromRow(WebElement row) {
        WebElement statusSpan = row.findElement(By.xpath("./td[2]//span"));
        return statusSpan.getText().trim();
    }
    /** Map: dayNumber → status */
    public Map<String, String> getAllDateStatusMap() {
        Map<String, String> map = new LinkedHashMap<>();

        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));

        for (WebElement row : allRows) {
            String day = getDayNumberFromRow(row);  // "14"
            String status = getStatusFromRow(row);  // "Present"

            map.put(day, status);
        }

        return map;
    }
   
}

		

