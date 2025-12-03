package com.violetis.Tests.EmployeePageTests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.employeePage.EMPOffboardingWarnPage;
import com.violetis.Pages.LoginPage;

public class EMPOffboardingWarnTest extends BaseTest{
	public EMPOffboardingWarnPage empwarnpg;
	public LoginPage loginpage;
	@BeforeClass
	public void navigateoffboardingwarnpage() {
		loginpage=new LoginPage(driver);
		empwarnpg=new EMPOffboardingWarnPage(driver);
		loginpage.login();
		empwarnpg.navigatetoWarnpage();
		
	}
	 /**
     * 🔹 TC1 – Validate Table Headers
	 * @throws InterruptedException 
     */
  
    @Test(priority=1)
    public void testTableHeadersCorrectness() throws InterruptedException {
        List<String> expectedHeaders = Arrays.asList("Title","Warning Date","Action");
        boolean headersMatch =empwarnpg.areHeadersCorrect(expectedHeaders);
        Thread.sleep(200);
        Assert.assertTrue(headersMatch, "Table headers do not match expected values!");
    }
    /**
     * 🔹 TC2 – Validate Exact Search
     * @throws InterruptedException 
     */
    @Test(priority=2)
    public void testExactTitleSearch() throws InterruptedException {
    	String title=empwarnpg.getTitleTextAt(0);
    	empwarnpg.searchWarning(title);
    	 Thread.sleep(2000);

        List<String> titles = empwarnpg.getAllTitles();

        Assert.assertTrue(
                titles.stream().anyMatch(t -> t.equalsIgnoreCase("Late login")),
                "❌ Exact title not found after search"
        );
    }
    /**
     * 🔹 TC3 – Validate Partial Search
     * @throws InterruptedException 
     */
    @Test(priority=3)
    public void testPartialSearch() throws InterruptedException {
    	String title=empwarnpg.getTitleTextAt(0);
    	int halflength=title.length()/2;
    	if(title.length()%2!=0) {
    		halflength+=1;
    	}
    	String firstpart=title.substring(0,halflength);
    	empwarnpg.searchWarning(firstpart);
    	 Thread.sleep(2000);

        List<String> titles = empwarnpg.getAllTitles();

        Assert.assertTrue(
                titles.stream().allMatch(t -> t.toLowerCase().contains("la")),
                "❌ Partial search failed – irrelevant rows visible"
        );
    }
    /**
     * 🔹 TC4 – Validate No-Match State
     * @throws InterruptedException 
     */
    @Test(priority=4)
    public void testNoDataState() throws InterruptedException {
    	empwarnpg.searchWarning("XYZ123NORESULT");
    	 Thread.sleep(2000);

        Assert.assertTrue(
        		empwarnpg.isNoDataShown(),
                "❌ No Data state not shown"
        );
    }
 /**
     * 🔹 TC5 – Validate Clear Search reloads all rows
     * @throws InterruptedException 
     */
  @Test(priority=5)
    public void testClearSearchReloadsTable() throws InterruptedException {

    	empwarnpg.searchWarning("late");
    	 Thread.sleep(2000);
        int filteredCount = empwarnpg.getAllTitles().size();

        empwarnpg.searchWarning(""); // Clear search
        Thread.sleep(3000);

        int fullCount = empwarnpg.getAllTitles().size();

        Assert.assertTrue(
                fullCount > filteredCount,
                "❌ Full list NOT restored after clearing search"
        );
    }

    /**
     * 🔹 TC6 – Validate Date Format (dd-MM-yyyy hh:mm a)
     * @throws InterruptedException 
     */
    @Test(priority=6)
    public void testDateFormat() throws InterruptedException {
        String date = empwarnpg.getWarningDateAt(0);
        Thread.sleep(2000);

        String regex = "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2} (am|pm|AM|PM)$";

        Assert.assertTrue(
                date.matches(regex),
                "❌ Date format incorrect → " + date
        );
    }
    

    @Test(priority=7)
    public void testClickTitleOpensCorrectDetail() throws InterruptedException {
        // Step 1: Capture title of first row
        String firstTitleBeforeClick = empwarnpg.getTitleTextAt(0);
        String firstDateBeforeClick = empwarnpg.getDateTextAt(0);
        Thread.sleep(2000);
        System.out.println("Captured Title in list: " + firstTitleBeforeClick);
        System.out.println("Captured Date in list: " + firstDateBeforeClick);

        // Step 2: Click the first title link
        empwarnpg.clickTitleAt(0);
        

        // Step 3: Capture title in the details page
        String titleInDetailView = empwarnpg.getTitleInDetailView();
        String DateInDetailView = empwarnpg.getDateInDetailView();
        System.out.println("Title in details page: " + titleInDetailView);
        System.out.println("Date in details page: " + DateInDetailView);
        // Step 4: Assert both titles match
        Assert.assertEquals(titleInDetailView, firstTitleBeforeClick, "Titles do not match!");
        Assert.assertEquals(DateInDetailView, firstDateBeforeClick, "Dates do not match!");
    }
  /*  @Test(priority=8)
    public void testYearMonthFilterCombo() {
    	

    	String currentYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
        String currentMonthName = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM")); // e.g., "November"
        String currentMonthNumber = LocalDate.now().format(DateTimeFormatter.ofPattern("MM")); // for November (month number)

        // Step 1: Apply filters
        empwarnpg.selectyear(currentYear);
    	empwarnpg.selectmonth(currentMonthName); // Dropdown may use full month name

        // Step 2: Capture all dates from the Warning Date column
        List<String> dates = empwarnpg.getAllWarningDates(); // Method returns list of date strings

        // Step 3: Ensure we have results
        Assert.assertFalse(dates.isEmpty(), "❌ No warnings found for 2025 + November");

        // Step 4: Validate each date matches expected year and month
        for (String date : dates) {
            String[] dateParts = date.split(" ")[0].split("-"); // Split date portion (dd-MM-yyyy → [0]=dd, [1]=MM, [2]=yyyy)
            String month = dateParts[1];
            String year = dateParts[2];

            Assert.assertEquals(month, currentMonthNumber, "❌ Mismatched month in date: " + date);
            Assert.assertEquals(year, currentYear, "❌ Mismatched year in date: " + date);
        }
}*/
}
