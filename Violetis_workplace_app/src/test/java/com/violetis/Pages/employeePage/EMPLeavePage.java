package com.violetis.Pages.employeePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.violetis.Base.BasePage;
import com.violetis.Locators.ManagerLocators;
import com.violetis.Locators.EmpPageLocators.EMPAppreciationsLocators;
import com.violetis.Locators.EmpPageLocators.EMPLeaveLocators;
import com.violetis.Utilities.WaitUtils;
import com.violetis.Utilities.JavaScriptUtility;

public class EMPLeavePage extends BasePage{
	private JavaScriptUtility jsUtil;
	public EMPLeavePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void navigatetoLeavebutton() {
		 try {
	            // Wait for main menu
	            WebElement mainMenu = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Leavebtn, 15);

	            // Hover over main menu
	            Actions actions = new Actions(driver);
	           
	            log.info("Hovered over the main menu.");
	            actions.moveToElement(mainMenu).click().perform();

	            // Wait for submenu
	            WebElement subMenu = WaitUtils.waitForElementVisible(driver,EMPLeaveLocators.sub_leave_btn, 15);
	            actions.moveToElement(subMenu).click().perform();
	            
	            log.info("Clicked on the Leave submenu.");

	        } catch (Exception e) {
	            log.error("Failed to navigate to Leave.", e);
	            throw new RuntimeException("Navigation to Leave failed!", e);
	        }
	}
	/*public void navigatetoLeavebutton() {
		 try {
             // Wait for main menu
             WebElement Leave_mainMenu = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Leavebtn, 15);

             // Hover over main menu
             Actions actions = new Actions(driver);
            
             log.info("Hovered over the Leave main menu.");
             actions.moveToElement(Leave_mainMenu).click().perform();
             
          // Wait for submenu
             WebElement subMenu = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.sub_leave_btn, 50);
             jsUtil=new JavaScriptUtility(driver);
             jsUtil.scrollIntoView(subMenu);
             WaitUtils.waitForElementClickable(driver, EMPLeaveLocators.sub_leave_btn, 50);
             try {
             	subMenu.click();
                 log.info("Clicked on leaves submenu using standard click.");
             } catch (Exception clickEx) {
                 log.warn("Standard click failed on leaves submenu. Trying JS click...");
                 jsUtil.clickElementByJS(subMenu);
                 log.info("Clicked on leaves submenu using JS click.");
             }
             
             log.info("Clicked on the leaves submenu.");

         } catch (Exception e) {
             log.error("Failed to navigate to Leaves.", e);
             throw new RuntimeException("Navigation to Leaves failed!", e);
         }
	}*/
	  // Methods to count Pending, Approved, and Rejected
   public void clickonallbtn() {
	   WebElement all = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Allbtn, 15);
	   all.click();
	   
   }
   public void pendingbtn() {
	   WebElement pendingbtn = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Pendingbtn, 15);
	   pendingbtn.click();
   }
   public void approvedbtn() {
	   WebElement approvedbtn = WaitUtils.waitForElementPresence(driver, EMPLeaveLocators.Approvedbtn, 50);
	   approvedbtn.click();
   	}
   public void rejectedbtn() {
	   WebElement rejectedbtn = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Rejectedbtn, 15);
	   rejectedbtn.click();
   }
	public int getallleavecounts() {
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int totalDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					totalDays += days;  // or use a double variable if you want decimal sum
				
				}
		}

System.out.println("Total leave days: " + totalDays);
return totalDays;
	}
	public int getpendingleavecount() throws InterruptedException {
		pendingbtn();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int pendingDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					pendingDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("pending leave days: " + pendingDays);
return pendingDays;
		
	}
	public int getapprovedleavecount() throws InterruptedException {
		approvedbtn();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int approvedDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					approvedDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("approved leave days: " + approvedDays);
return approvedDays;
	}
	public int getrejectedleavecount() throws InterruptedException {
		Thread.sleep(2000);
		rejectedbtn();
		List<WebElement> elements = driver.findElements(EMPLeaveLocators.Alldateseles);

		int rejectedDays = 0;

		for (WebElement el : elements) {
			String text = el.getText().trim(); // e.g., "2 days" or "1.5 days"
    
			// Extract digits using regex
			String numberOnly = text.replaceAll("[^0-9.]", ""); // removes everything except digits and dot
				if (!numberOnly.isEmpty()) {
					double days = Double.parseDouble(numberOnly); // parse as double in case of half-days
					rejectedDays += days;  // or use a double variable if you want decimal sum
				}
		}

System.out.println("rejected leave days: " + rejectedDays);
return rejectedDays;
	}
	
	 // ===== Table Details =====
    public boolean isStatusDisplayed(String expectedStatus) {
        List<WebElement> statuses = driver.findElements(EMPLeaveLocators.leavestatusdatas);
        return statuses.stream().allMatch(s -> s.getText().contains(expectedStatus));
    }

    // OR — for compact code:
    public boolean isActionIconVisible(String action) {
        String xpath = String.format("//tbody//tr//td[8]//span[contains(@class,'anticon-%s')]", action.toLowerCase());
        List<WebElement> icons = driver.findElements(By.xpath(xpath));
        return !icons.isEmpty() && icons.get(0).isDisplayed();
    }

    // ===== Actions =====
    public void clickViewIcon() {
        driver.findElement(EMPLeaveLocators.viewicon).click();
    }

    public void clickEditIcon() {
        driver.findElement(EMPLeaveLocators.editicon).click();
    }

    public void clickDeleteIcon() {
        driver.findElement(EMPLeaveLocators.deleteicon).click();
    }

    public void confirmDelete() {
        driver.findElement(EMPLeaveLocators.confirmdebtn).click();
    }
    public boolean isLeaveListDisplayed() {
        return driver.findElements(EMPLeaveLocators.leavedayrows).size() > 0;
    }
    //filters
    public void selectyear(String targetyear) throws InterruptedException {
		WaitUtils.waitForElementPresence(driver, EMPLeaveLocators.yeardropdown, 30).click();
		 // Wait until year picker visible
        WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.yearrangeele, 10); 
        String rangeText = driver.findElement( EMPLeaveLocators.yearrangeele).getText().trim();
        int startYear = Integer.parseInt(rangeText.split("-")[0]);
        int endYear = Integer.parseInt(rangeText.split("-")[1]);
        int Year = Integer.parseInt(targetyear);
        
        // Navigate decades if needed
        while (Year < startYear) {
            driver.findElement(EMPLeaveLocators.yearprevbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPLeaveLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }
        while (Year > endYear) {
            driver.findElement(EMPLeaveLocators.yearfrnwdbtn).click();
            WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.yearrangeele, 5);
            rangeText = driver.findElement(EMPLeaveLocators.yearrangeele).getText().trim();
            startYear = Integer.parseInt(rangeText.split("-")[0]);
            endYear = Integer.parseInt(rangeText.split("-")[1]);
        }

        // Click desired year
        WebElement yearElement = driver.findElement(EMPLeaveLocators.yearOption(targetyear));
        yearElement.click();
        
    }
    public void selectMonth(String monthName) throws InterruptedException {
	    // 1️⃣ Click dropdown to open it
	    WebElement dropdown = WaitUtils.waitForElementClickable(driver,
	    		EMPAppreciationsLocators.monthdropdown, 10);
	    dropdown.click();

	    // 2️⃣ Locate visible dropdown panel
	    WebElement dropdownPanel = WaitUtils.waitForElementPresence(driver,EMPLeaveLocators.monthdropdown, 10);

	    // 🟢 ADD THIS LINE — find the actual scrollable list holder
	    WebElement scrollableList = WaitUtils.waitForElementPresence(driver,EMPLeaveLocators.scrollbar, 10);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean found = false;

	    // Step 3️⃣: Scroll and search for the desired month
	    for (int i = 0; i < 15; i++) {
	        List<WebElement> options = driver.findElements(EMPLeaveLocators.monthdropoptions);

	        for (WebElement option : options) {
	            String text = option.getText().trim();
	            if (text.equalsIgnoreCase(monthName)) {
	                option.click(); // ✅ Select month
	                found = true;
	                break;
	            }
	        }

	        if (found) break;

	        // Scroll down to load more items
	        js.executeScript("arguments[0].scrollTop += 300;", scrollableList);
	        Thread.sleep(400); // allow lazy load to render new items
	    }

	    if (!found) {
	        throw new RuntimeException("Month '" + monthName + "' not found even after scrolling!");
	    }

	    // Step 4️⃣: Verify month was selected
	    WebElement selectedMonthEle = WaitUtils.waitForElementVisible(driver,
	        By.xpath("//span[contains(@class,'ant-select-selection-item')]"), 10);

	    String selectedMonth = selectedMonthEle.getText().trim();
	    Assert.assertEquals(selectedMonth, monthName, "❌ Month selection verification failed!");

	    System.out.println("✅ Successfully selected and verified month: " + selectedMonth);
	}
    public void selectleavetype(String leavetype) {
    	// Click the input to open dropdown
        WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.selectleave_drpdown, 10).click();

        // Wait for all options to appear
        WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.selectleavoptions, 5);

        // Get all options dynamically
        List<WebElement> options = driver.findElements(EMPLeaveLocators.selectleavoptions);
        for (WebElement option : options) {
            if (option.getText().equals(leavetype)) {
                option.click();
                log.info("Selected leavetype is: " + leavetype);
                break;
            }
        }
    }
    public List<String> getDisplayedLeaveNames() {
    	List<WebElement> rows = driver.findElements(EMPLeaveLocators.leavenameele);
        List<String> leaveTexts = new ArrayList<>();

        for (WebElement row : rows) {
            String text = row.getText().trim();
            if (!text.isEmpty()) { // optional: skip blank rows
                leaveTexts.add(text);
            }
        }
        return leaveTexts;
    }
    public boolean isActionVisibleForRow(WebElement row, String actionName) {
        try {
            // 🔹 Get all action icons (like view/edit/delete) in this specific row
            List<WebElement> actionIcons = row.findElements(EMPLeaveLocators.Action_cols);
            System.out.println("🔹 Found " + actionIcons.size() + " action icons in this row.");

            for (WebElement icon : actionIcons) {
                String iconClass = icon.getAttribute("class");
                System.out.println("🔍 Checking icon class: " + iconClass);

                // Match based on unique class substring for each icon
                if (actionName.equalsIgnoreCase("view") && iconClass.contains("anticon-eye")) {
                    return true;
                } else if (actionName.equalsIgnoreCase("edit") && iconClass.contains("anticon-edit")) {
                    return true;
                } else if (actionName.equalsIgnoreCase("delete") && iconClass.contains("anticon-delete")) {
                    return true;
                }
            }

            // 🔸 If we reach here, that means no matching icon was found
            System.out.println("❌ No '" + actionName + "' icon found for this row.");
            return false;

        } catch (Exception e) {
            System.out.println("⚠️ Error checking action visibility: " + e.getMessage());
            return false;
        }
    }
    public void clickAction(WebElement row, String actionName) {
        try {
            // 🔹 Find all icons under the Actions column for the given row
            List<WebElement> actionIcons = row.findElements(EMPLeaveLocators.Action_cols);

            for (WebElement icon : actionIcons) {
                String iconClass = icon.getAttribute("class");

                // 🔹 Match the correct icon using class names
                if (actionName.equalsIgnoreCase("view") && iconClass.contains("anticon-eye")) {
                    icon.click();
                    System.out.println("👁️ Clicked on 'View' action.");
                    return;
                } else if (actionName.equalsIgnoreCase("edit") && iconClass.contains("anticon-edit")) {
                    icon.click();
                    System.out.println("✏️ Clicked on 'Edit' action.");
                    return;
                } else if (actionName.equalsIgnoreCase("delete") && iconClass.contains("anticon-delete")) {
                    icon.click();
                    System.out.println("🗑️ Clicked on 'Delete' action.");
                    return;
                }
            }

            System.out.println("⚠️ No matching action found for: " + actionName);
        } catch (Exception e) {
            System.out.println("❌ Failed to click action: " + actionName + " - " + e.getMessage());
        }
    }
    // ===== Leave Table =====
    public String getTotalDays() {
        return WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Alldateseles, 10).getText();
    }

    public String getStatusText() {
        return WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.leavestatusdatas, 10).getText();
    }
    public String getLeaveStatus(WebElement row) {
        try {
            WebElement statusCell = row.findElement(By.xpath(".//td[7]//span"));
            String statusText = statusCell.getText().trim();
            System.out.println("📘 Leave Status found: " + statusText);
            return statusText;
        } catch (Exception e) {
            System.out.println("⚠️ Unable to fetch Leave Status for row. " + e.getMessage());
            return "";
        }
    }
    public Map<Integer, List<String>> getAllRowActions() {
        List<WebElement> rows = driver.findElements(EMPLeaveLocators.leavedayrows);
        Map<Integer, List<String>> rowActions = new LinkedHashMap<>();

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> icons = row.findElements(EMPLeaveLocators.Action_cols);

            List<String> actions = new ArrayList<>();
            for (WebElement icon : icons) {
                String cls = icon.getAttribute("class");
                if (cls.contains("anticon-eye")) actions.add("View");
                else if (cls.contains("anticon-edit")) actions.add("Edit");
                else if (cls.contains("anticon-delete")) actions.add("Delete");
            }

            rowActions.put(i + 1, actions);
        }
        return rowActions;
    }
    public Map<String, List<String>> getLeaveStatusAndActions() {
        List<WebElement> rows = driver.findElements(EMPLeaveLocators.leavedayrows);
        Map<String, List<String>> result = new LinkedHashMap<>();

        for (WebElement row : rows) {
            // Get status (like Pending, Approved, Rejected)
            String status = row.findElement(EMPLeaveLocators.leavestatusdatas).getText().trim();

            // Get all action icons in that row
            List<WebElement> icons = row.findElements(EMPLeaveLocators.Action_cols);

            List<String> actions = new ArrayList<>();
            for (WebElement icon : icons) {
                String cls = icon.getAttribute("class");
                if (cls.contains("anticon-eye")) actions.add("View");
                else if (cls.contains("anticon-edit")) actions.add("Edit");
                else if (cls.contains("anticon-delete")) actions.add("Delete");
            }

            result.put(status, actions);
        }
        return result;
    }
    public List<WebElement> getAllLeaveRows() {
        List<WebElement> rows = driver.findElements(EMPLeaveLocators.leavedayrows);
        
        if (rows.isEmpty()) {
            System.out.println("⚠️ No leave rows found in the table.");
        } else {
            System.out.println("✅ Found " + rows.size() + " leave rows.");
        }
        return rows;
    }
    public boolean verifyYearFilter(String expectedYear) {
        List<WebElement> rows = getAllLeaveRows();

        for (WebElement row : rows) {
            String startDate = row.findElement(EMPLeaveLocators.startdateeleintable).getText().trim(); // Start Date
            String[] parts = startDate.split("-"); // dd-MM-yyyy
            String actualYear = parts[2];

            if (!actualYear.equals(expectedYear)) {
                System.out.println("❌ Year mismatch found: " + startDate);
                return false;
            }
        }
        System.out.println("✅ All leaves belong to year: " + expectedYear);
        return true;
    }
    public boolean verifyLeaveTypeFilter(String expectedType) {
        List<WebElement> rows = getAllLeaveRows();

        for (WebElement row : rows) {
            String actualType = row.findElement(EMPLeaveLocators.leavetypeeleintable).getText().trim(); // Leave Type col
            if (!actualType.equalsIgnoreCase(expectedType)) {
                System.out.println("❌ Leave type mismatch: found " + actualType);
                return false;
            }
        }
        System.out.println("✅ All leaves match type: " + expectedType);
        return true;
    }
    private String getMonthName(String monthNumber) {
        int month = Integer.parseInt(monthNumber);
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    public boolean verifyMonthFilter(String expectedMonth) {
        List<WebElement> rows = getAllLeaveRows();
        boolean isValid = true;

        if (rows.isEmpty()) {
            System.out.println("⚠️ No leave records found after selecting month: " + expectedMonth);
            return false;
        }

        for (WebElement row : rows) {
            String startDate = row.findElement(EMPLeaveLocators.startdateeleintable).getText().trim(); // Start Date column
            String endDate = row.findElement(EMPLeaveLocators.enddateeleintable).getText().trim();   // End Date column

            // Extract month part from date like 12-11-2025 -> 11 (November)
            String startMonth = startDate.split("-")[1];
            String endMonth = endDate.split("-")[1];

            // Convert numeric month to full name (11 → November)
            String startMonthName = getMonthName(startMonth);
            String endMonthName = getMonthName(endMonth);

            if (!(startMonthName.equalsIgnoreCase(expectedMonth) || endMonthName.equalsIgnoreCase(expectedMonth))) {
                System.out.println("❌ Row mismatch: Found Start=" + startMonthName + ", End=" + endMonthName);
                isValid = false;
            }
        }

        if (isValid)
            System.out.println("✅ All displayed leaves belong to month: " + expectedMonth);
        else
            System.out.println("❌ Some leaves don’t belong to month: " + expectedMonth);

        return isValid;
    }

  

    // ===== Actions =====
    public void clickViewButton(String startdate,String enddate) {
    	List<WebElement> rows=WaitUtils.waitForElementsVisible(driver, EMPLeaveLocators.leavedayrows, 10);
    	for (int i = 1; i <= rows.size(); i++) {
    		String startdate1="//tbody[@class='ant-table-tbody']/tr[" + i + "]/td[3]";
    		String viewbtn="//tbody[@class='ant-table-tbody']/tr[" + i + "]/td[8]/div/div[1]";
    		String enddate1="//tbody[@class='ant-table-tbody']/tr[" + i + "]/td[4]";
    	}
    }

    public void clickEditButton() {
    	WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.editicon, 10).click();
    }

    public void clickDeleteButton() {
    	WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.deleteicon, 10).click();
    }
    public boolean clickTabAndVerifyStatus(String tabName) {
        try {
            // 🔹 Use your existing reusable methods here
            switch (tabName.toLowerCase()) {
                case "all":
                    clickonallbtn();
                    break;

                case "pending":
                    pendingbtn();
                    break;

                case "approved":
                    approvedbtn();
                    break;

                case "rejected":
                    rejectedbtn();
                    break;

                default:
                    throw new IllegalArgumentException("❌ Invalid tab name provided: " + tabName);
            }

            // 🔹 Wait a bit for table to update (better to use explicit wait)
            Thread.sleep(1000);

            List<WebElement> rows =WaitUtils.waitForElementsVisible(driver, EMPLeaveLocators.leavedayrows, 20);

            // ✅ If tab = "All" → just verify that rows exist
            if (tabName.equalsIgnoreCase("all")) {
                System.out.println("✅ 'All' tab clicked - total leaves displayed: " + rows.size());
                return rows.size() > 0;
            }

            // ✅ For other tabs → verify each row’s status text
            for (WebElement row : rows) {
                String status = getLeaveStatus(row);

                if (!status.equalsIgnoreCase(tabName)) {
                    System.out.println("❌ Mismatch in tab '" + tabName + "': found status - " + status);
                    return false;
                }
            }

            System.out.println("✅ All leaves under '" + tabName + "' tab match the expected status.");
            return true;

        } catch (Exception e) {
            System.out.println("⚠️ Error verifying tab '" + tabName + "': " + e.getMessage());
            return false;
        }
    }
    //get leave details from row to validate it on view button
    public Map<String, String> getLeaveDetailsFromRow(WebElement row) {
        Map<String, String> details = new HashMap<>();

        details.put("Name", row.findElement(EMPLeaveLocators.empname).getText().trim());
        details.put("LeaveType", row.findElement(EMPLeaveLocators.leavetypele).getText().trim());
        details.put("FromDate", row.findElement(EMPLeaveLocators.startdateele).getText().trim());
        details.put("ToDate", row.findElement(EMPLeaveLocators.enddate).getText().trim());
        details.put("HalfDay", row.findElement(EMPLeaveLocators.ishalfday).getText().trim());
        details.put("Status", row.findElement(EMPLeaveLocators.leavestatus).getText().trim());

        return details;
    }
    // for validating view button
    public void clickViewOnFirstRow() {
        try {
            // Get all table rows
            List<WebElement> rows = getAllLeaveRows();
            System.out.println("🔹 Total rows found: " + rows.size());

            if (rows.size() > 0) {
                WebElement firstRow = rows.get(0); // get first row
                // Find the view icon (eye) in the first row
                WebElement viewIcon = firstRow.findElement(By.xpath(".//td[8]//span[contains(@class,'anticon-eye')]"));
                viewIcon.click();
                System.out.println("👁️ Clicked on View icon for the first row.");
            } else {
                System.out.println("⚠️ No rows found in the leave table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error while clicking View icon on first row.");
        }
    }
    public Map<String, String> getLeaveDetailsFromViewactionbtn() {
        Map<String, String> details = new HashMap<>();
        try {
           

            // Extract details from the View popup/modal
            String empName = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.viewbtnempname, 10).getText().trim();
            String leaveType =WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.Leavetypeviewele, 10).getText().trim();
            String fromDateraw = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.startdateviewele, 10).getText().trim();
            String toDateraw = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.enddateviewele, 10).getText().trim();
            // ✅ Remove time part if present (e.g., "17-11-2025 12:00 am" → "17-11-2025")
            String fromDate = fromDateraw.split(" ")[0];
            String toDate = toDateraw.split(" ")[0];
            String halfDayvalue = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.ishalfdayviewelem, 10).getText().trim();
            String status = WaitUtils.waitForElementVisible(driver, EMPLeaveLocators.statusviewele, 10).getText().trim();
            
            // ✅ Normalize HalfDay field (convert 0/1 → No/Yes)
            String HalfDay;
            if (halfDayvalue.equals("1")) {
            	HalfDay = "Yes";
            } else if (halfDayvalue.equals("0")) {
            	HalfDay = "No";
            } else {
            	HalfDay = halfDayvalue; // fallback if it’s already Yes/No
            }
            details.put("Name", empName);
            details.put("LeaveType", leaveType);
            details.put("FromDate", fromDate);
            details.put("ToDate", toDate);
            details.put("HalfDay", HalfDay);
            details.put("Status", status);

            System.out.println("👁️ View Popup Details: " + details);
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error while fetching leave details from View popup.");
        }
        return details;
    }

    
    
    //get count of approved leaves based on leave type
    public long getApprovedLeaveCount(String leaveType) {
        // Wait for table rows to load
        WaitUtils.waitForElementPresence(driver, By.xpath("//tbody//tr"), 10);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        if (rows.isEmpty()) {
            System.out.println("⚠️ No rows found in Approved tab.");
            return 0;
        }

        // Debug print (optional)
        rows.forEach(row -> {
            String type = row.findElement(By.xpath(".//td[2]")).getText().trim();
            String status = row.findElement(By.xpath(".//td[7]/span")).getText().trim();
            System.out.println("📄 Row → LeaveType: " + type + " | Status: " + status);
        });

        // Count rows that match the leave type and are Approved
        long count = rows.stream()
                .filter(row -> {
                    String type = row.findElement(By.xpath(".//td[2]")).getText().trim();
                    String status = row.findElement(By.xpath(".//td[7]/span")).getText().trim();
                    return type.equalsIgnoreCase(leaveType.trim())
                            && status.equalsIgnoreCase("Approved");
                })
                .count();

        System.out.println("✅ Approved leave count for [" + leaveType + "] = " + count);
        return count;
    }
    //Add new Leave page
    public void clickaddnewleavebtn() {
    	WaitUtils.waitForElementVisible(driver,EMPLeaveLocators.Add_new_leave_btn,20).click();
    	
    }
    
    public void fillleaveform() {
    	
    }

}
