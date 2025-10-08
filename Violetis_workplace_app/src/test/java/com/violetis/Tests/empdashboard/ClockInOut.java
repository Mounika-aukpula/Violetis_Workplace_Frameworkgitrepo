package com.violetis.Tests.empdashboard;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.DashboardPage;
import com.violetis.Pages.LoginPage;
public class ClockInOut extends BaseTest{
	private DashboardPage dashboard;
	@BeforeMethod
    public void loginAndSetupDashboard() {
        // Login before each test
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        dashboard = new DashboardPage(driver);
    }


	    // ===== Employer Dashboard Test Cases =====

	/* @Test(priority = 1, description = "Clock In button functionality")
	    public void testClockInFunctionality() {
	        dashboard.clickClockIn();

	        String clockInTime = dashboard.getClockInTime();
	        String workedTime = dashboard.getWorkedTime();

	        System.out.println("Clock In Time: " + clockInTime);
	        System.out.println("Worked Time: " + workedTime);

	        Assert.assertTrue(clockInTime.contains("AM") || clockInTime.contains("PM"), 
	            "Clock In Time not updated correctly!");
	        Assert.assertNotNull(workedTime, "Worked Time should be displayed after clock-in!");
	    }

	    @Test(priority = 2, description = "Prevent double Clock In")
	    public void testPreventDoubleClockIn() {
	        boolean isClockInEnabled = dashboard.isClockInEnabled();
	        Assert.assertFalse(isClockInEnabled, "Clock In button should be disabled after already clocking in!");
	    }
	    @Test(priority = 3, description = "Clock Out button functionality")
	    public void testClockOutFunctionality() {
	        dashboard.clickClockOut();
	        dashboard.confirmClockOutBtn();

	        String workedTime = dashboard.getWorkedTime();
	        System.out.println("Worked Time after Clock Out: " + workedTime);

	        Assert.assertNotNull(workedTime, "Worked Time not updated after Clock Out!");
	        Assert.assertTrue(workedTime.matches(".*\\d+.*"), "Worked Time is not valid!");
	    }

	    @Test(priority = 4, description = "Prevent Clock Out before Clock In")
	    public void testPreventClockOutBeforeClockIn() {
	        // Precondition: Make sure user is logged out and re-logged in fresh
	        driver.navigate().refresh();

	        // Attempt Clock Out without Clock In

	        boolean isClockOutEnabled = dashboard.isClockOutEnabled();
	        Assert.assertFalse(isClockOutEnabled, "Clock Out should not be active before Clock In!");
	    }
	@Test(priority = 5, description = "Display current date/time on dashboard")
	public void testDisplayCurrentDateTime() {
	    String dashboardDateTime = dashboard.getCurrentDateTime().trim();
	    System.out.println("📅 Dashboard shows: " + dashboardDateTime);

	    String[] parts = dashboardDateTime.split(",");
	    if (parts.length != 2) {
	        Assert.fail("Dashboard date/time format unexpected: " + dashboardDateTime);
	    }

	    String timePart = parts[0].trim().replace("\u00A0", " ").toUpperCase();
	    String datePart = parts[1].trim().replace("\u00A0", " ");

	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

	    LocalTime time = LocalTime.parse(timePart, timeFormatter);
	    LocalDate date = LocalDate.parse(datePart, dateFormatter);
	    LocalDateTime dashboardDT = LocalDateTime.of(date, time);

	    LocalDateTime systemDT = LocalDateTime.now();

	    System.out.println("System time: " + systemDT.format(DateTimeFormatter.ofPattern("hh:mm a, dd MMM yyyy")));

	    long minutesDiff = Math.abs(Duration.between(dashboardDT, systemDT).toMinutes());
	    Assert.assertTrue(minutesDiff <= 3, "⚠️ Dashboard date/time differs from system by more than 3 minutes!");

	    System.out.println("✅ Dashboard date/time validated successfully its displaying correctly.");
	}*/
	@Test(priority = 6, description = "Validate total worked hours calculation")
	public void testTotalWorkedHours() {
	    boolean clockInJustHappened = false;

	    // Click Clock In only if enabled
	    if (dashboard.isClockInEnabled()) {
	        dashboard.clickClockIn();
	        clockInJustHappened = true;

	        // Wait to simulate work only if Clock In happened now
	        try { Thread.sleep(2 * 60 * 1000); } catch (InterruptedException e) { }
	    }

	    // Get Clock In time and parse only the time part, convert to uppercase
	    String clockInStr = dashboard.getClockInTime(); // e.g., "Clock In Time 11:43 AM"
	    String clockInTimeOnly = clockInStr
	            .replaceAll(".*?(\\d{1,2}:\\d{2} [APap][Mm]).*", "$1")
	            .toUpperCase();
	    LocalTime clockInTime = LocalTime.parse(clockInTimeOnly, DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH));

	    // Click Clock Out only if enabled
	    if (dashboard.isClockOutEnabled()) {
	        dashboard.clickClockOut();
	        dashboard.confirmClockOutBtn();
	    }

	    // Get Clock Out time and parse only the time part, convert to uppercase
	    String clockOutStr = dashboard.getClockOutTime(); // e.g., "Clocked Out : 01:31 pm"
	    String clockOutTimeOnly = clockOutStr
	            .replaceAll(".*?(\\d{1,2}:\\d{2} [APap][Mm]).*", "$1")
	            .toUpperCase();
	    LocalTime clockOutTime = LocalTime.parse(clockOutTimeOnly, DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH));

	    // Calculate expected worked duration
	    Duration expectedDuration = Duration.between(clockInTime, clockOutTime);

	    // Get worked duration from dashboard
	    Duration dashboardWorkedDuration = dashboard.getWorkedDuration();

	    // Print durations
	    System.out.println("Expected worked duration: " + expectedDuration.toHoursPart() + "h " + expectedDuration.toMinutesPart() + "m");
	    System.out.println("Dashboard worked duration: " + dashboardWorkedDuration.toHoursPart() + "h " + dashboardWorkedDuration.toMinutesPart() + "m");

	    // Validate within 1 minute tolerance
	    long diff = Math.abs(expectedDuration.toMinutes() - dashboardWorkedDuration.toMinutes());
	    Assert.assertTrue(diff <= 1, "⚠️ Total worked hours mismatch! Difference: " + diff + " mins");
	}
	
}
