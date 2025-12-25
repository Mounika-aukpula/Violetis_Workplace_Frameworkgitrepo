package com.violetis.Tests.ManagerdashboardTest;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerDashboard.WeekendholidayPage;
import com.violetis.Pages.ManagerPackage.HolidayPage;
import com.violetis.Pages.employeePage.EmpHolidayPage;
import com.violetis.Pages.ManagerPackage.LogoutPage;
import com.violetis.Utilities.ConfigReader;

public class WeekendholidayTest extends BaseTest{
public LoginPage loginpage;
public WeekendholidayPage weekendhldpg;
public EmpHolidayPage empholidaypg;
public LogoutPage managerlogout;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	weekendhldpg=new WeekendholidayPage(driver);
	empholidaypg=new EmpHolidayPage(driver);
	managerlogout=new LogoutPage(driver);
	loginpage.login(ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd"));
	}
/*@Test(priority=1)
public void validateHolidayDatesBasedOnSelectedYear() {
	String selectedYear = "2026";
	weekendhldpg.selectyear(selectedYear);
	List<WebElement> holidayDates =weekendhldpg.getholidaydates();
	 // Validate each date contains selected year
    for (WebElement date : holidayDates) {
    	  String dateText = date.getText().trim();
    	  Assert.assertTrue(
                  dateText.contains(selectedYear),
                  "Date does not belong to selected year " + selectedYear + " : " + dateText
          );
    }
	
}
@Test(priority=2)
public void validateholidaytab() throws InterruptedException {
	String selectedYear = "2026";
	weekendhldpg.selectyear(selectedYear);
	List<WebElement> act_holidaynames=weekendhldpg.getholidaynames();
	List<WebElement> act_holidaydates=weekendhldpg.getholidaydates();
	Map<String, String> holidayMap=weekendhldpg.getHolidayNameDateMap();
	System.out.println(holidayMap);
	managerlogout.clickonlogoutbtn();
	loginpage.login();
	Thread.sleep(2000);
	empholidaypg.clickonholidaysmenu();
	Thread.sleep(2000);
	empholidaypg.clickHolidayTab();
	Thread.sleep(2000);
	empholidaypg.selectyear(selectedYear);
	Thread.sleep(2000);
	List<WebElement> exp_holidaynames=empholidaypg.getHolidayNames();
	List<WebElement> exp_holidaydates=empholidaypg.getHolidayDates();
	Map<String, String> HoldatesMap=empholidaypg.getHolidayNameDateMap();
	// Normalize employee date format (dd-MM-yyyy → yyyy-MM-dd)
    Map<String, String> normalizedEmployeeMap =
    		empholidaypg.normalizeDateMap(HoldatesMap, "dd-MM-yyyy", "yyyy-MM-dd");
	System.out.println(normalizedEmployeeMap);
	Assert.assertEquals(holidayMap, normalizedEmployeeMap, "Holiday data mismatch");
	
}*/
@Test
public void validateweekendtab() throws InterruptedException {
	  String selectedYear = "2026";

	    // Select year
	    weekendhldpg.selectyear(selectedYear);

	    // Click Weekend tab
	    weekendhldpg.clickonweekendbtn();
	    Thread.sleep(2000);
	    // Fetch holiday name-date mapping
	    Map<String, String> ManagerholidayMap = weekendhldpg.getHolidayNameDateMap();

	    // 🔍 Mandatory validation
	    Assert.assertFalse(
	    		ManagerholidayMap.isEmpty(),
	            "Weekend holidays are NOT loaded for year " + selectedYear
	    );
	    Map<String, String> managerNormalized =weekendhldpg.normalizeDateMap(ManagerholidayMap, "yyyy-MM-dd", "yyyy-MM-dd");
	    // Optional logging
	    managerNormalized.forEach((name, date) ->
	            System.out.println(name + " -> " + date)
	    );

	    // Logout and login
	    managerlogout.clickonlogoutbtn();
	    loginpage.login();
	    empholidaypg.clickonholidaysmenu();
		Thread.sleep(2000);
		empholidaypg.clickWeekendTab();
		Thread.sleep(2000);
		empholidaypg.selectyear(selectedYear);
		Thread.sleep(2000);
		List<WebElement> exp_holidaynames=empholidaypg.getHolidayNames();
		List<WebElement> exp_holidaydates=empholidaypg.getHolidayDates();
		Map<String, String> HoldatesMap=empholidaypg.getAllWeekendHolidaysAcrossPages();
		// Normalize employee date format (dd-MM-yyyy → yyyy-MM-dd)
	    Map<String, String> normalizedEmployeeMap =
	    		empholidaypg.normalizeDateMap(HoldatesMap, "dd-MM-yyyy", "yyyy-MM-dd");
	    normalizedEmployeeMap.forEach((name, date) ->
         System.out.println(name + " -> " + date)
 );
	    Assert.assertEquals(managerNormalized, normalizedEmployeeMap, "Holiday data mismatch");
}

}
