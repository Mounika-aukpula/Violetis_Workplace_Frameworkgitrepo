package com.violetis.Tests.empdashboard;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.WeekendandholidayPage;
import com.violetis.Pages.HRPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Locators.Empdashboardlocators;

public class WeekendandholidayTest extends BaseTest {
	public WeekendandholidayPage weekendhldypg;
	public LoginPage loginPage;
	public HRPage hrpage;
	public EMPDashboardPage empdashpg;
	@BeforeMethod
    public void loginAndSetupDashboard() {
        // Login
        loginPage = new LoginPage(driver);
        weekendhldypg=new WeekendandholidayPage(driver);
        hrpage=new HRPage(driver);
        empdashpg=new EMPDashboardPage(driver);
        
        
    }
	/*@Test(priority = 1, description = "Verify no holidays case")
	    public void verifyNoHolidaysCase() throws InterruptedException {
		 loginPage.login();
		 String expected_noholidaymessage="There are no holidays";
		 weekendhldypg.clickyearpicker();
		 
		 weekendhldypg.selectYearFromPicker(2027);
		 weekendhldypg.clickHolidayTab();
		 
		 String act_noholidaymessage=weekendhldypg.getNoHolidayMessage();
		 Assert.assertEquals(act_noholidaymessage,expected_noholidaymessage);
		 empdashpg.logout();
		 
		 
	 }
	 @Test(priority = 2, description = "Verify holidays display correctly in real-time")
	 public void verifyHolidaysRealTime() {
		loginPage.login();
		 weekendhldypg.clickyearpicker();
		 weekendhldypg.selectYearFromPicker(2025);
		 weekendhldypg.clickHolidayTab();

	     List<String> holidayNames = weekendhldypg.getAllHolidayNames();
	     List<String> holidayDates = weekendhldypg.getAllHolidayDates();

	     // --- Real-time checks ---
	     Assert.assertFalse(holidayNames.isEmpty(), "No holiday names found!");
	     Assert.assertFalse(holidayDates.isEmpty(), "No holiday dates found!");
	     Assert.assertEquals(holidayNames.size(), holidayDates.size(), "Holiday name/date count mismatch!");

	     System.out.println("Holidays displayed on UI:");
	     for (int i = 0; i < holidayNames.size(); i++) {
	         System.out.println(holidayNames.get(i) + " - " + holidayDates.get(i));
	     }
		
	     empdashpg.logout();
	 }
	 
	 @Test(priority=3, description="add holoday and validate is it displays")
	 public void verifyAddedholiday() {
		 int year=2027;
		 loginPage.login("testing@violetis.ai","VioletisTesting@2025");
		 hrpage.navigatetoholidaymenu();
		 hrpage.clickonaddnewholidaytab();
		 hrpage.enterholidayform("Test holiday","Jan","2027","26");
		 hrpage.submitincorpromotionform();
		 driver.navigate().refresh();
		 empdashpg.logout();
		 loginPage.login();
		 weekendhldypg.clickyearpicker();
		 weekendhldypg.selectYearFromPicker(year);
		 weekendhldypg.clickHolidayTab();
		 List<String> holidayNames = weekendhldypg.getAllHolidayNames();
	     List<String> holidayDates = weekendhldypg.getAllHolidayDates();
	     Assert.assertFalse(holidayNames.isEmpty(), "No holiday names found!");
	     Assert.assertFalse(holidayDates.isEmpty(), "No holiday dates found!");
	     Assert.assertEquals(holidayNames.size(), holidayDates.size(), "Holiday name/date count mismatch!");

	     System.out.println("Holidays displayed on UI:");
	     for (int i = 0; i < holidayNames.size(); i++) {
	         System.out.println(holidayNames.get(i) + " - " + holidayDates.get(i));
		 
	     }
	     empdashpg.logout();
	     loginPage.login("testing@violetis.ai","VioletisTesting@2025");
	     hrpage.navigatetoholidaymenu();
	     
	 }
	 */
	 @Test(priority=4,description="validate weekenddates diplays correctly")
	 public void verifyweekenddisplaycorrcetly() {
		 loginPage.login();
		 weekendhldypg.clickWeekendTab();
		 
		 List<String> weekendDateStrings = weekendhldypg.getAllweekendDates();
	        List<LocalDate> actualDates = new ArrayList<>();

	        for (String dateText : weekendDateStrings) {
	            LocalDate date = LocalDate.parse(dateText.trim());
	            actualDates.add(date);
	        }

	        System.out.println("📅 Total weekend dates displayed: " + actualDates.size());

	        // 2️⃣ Verify no duplicates
	        Set<LocalDate> uniqueDates = new HashSet<>(actualDates);
	        Assert.assertEquals(uniqueDates.size(), actualDates.size(),
	                "❌ Duplicate weekend dates found!");

	        // 3️⃣ Verify all dates are real weekends (Saturday or Sunday)
	        for (LocalDate date : actualDates) {
	            DayOfWeek day = date.getDayOfWeek();
	            Assert.assertTrue(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY,
	                    "❌ " + date + " is not a real weekend! It's a " + day);
	        }

	        // 4️⃣ Verify ascending order
	        List<LocalDate> sortedDates = new ArrayList<>(actualDates);
	        Collections.sort(sortedDates);
	        Assert.assertEquals(actualDates, sortedDates,
	                "❌ Weekend dates are not in ascending order!");

	        // 5️⃣ Generate expected weekends for the entire year
	        int year = actualDates.get(0).getYear();
	        List<LocalDate> expectedWeekends = getExpectedWeekendsForYear(year);

	        System.out.println("📅 Expected weekends (from calendar): " + expectedWeekends.size());

	        // 6️⃣ Compare UI weekends with real calendar weekends
	        Assert.assertEquals(actualDates, expectedWeekends,
	                "❌ Displayed weekends do not match actual calendar weekends for " + year);

	        System.out.println("✅ All weekend validations passed successfully for year " + year);
	    }

	    /** Utility: generate all Saturdays and Sundays for a full year */
	    public List<LocalDate> getExpectedWeekendsForYear(int year) {
	        List<LocalDate> weekends = new ArrayList<>();
	        LocalDate date = LocalDate.of(year, 1, 1);

	        while (date.getYear() == year) {
	            DayOfWeek day = date.getDayOfWeek();
	            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
	                weekends.add(date);
	            }
	            date = date.plusDays(1);
	        }

	        return weekends;
	    } 
	    
	    
	    }
	 
	 
	 
