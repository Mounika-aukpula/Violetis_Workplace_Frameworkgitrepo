package com.violetis.Tests.EmployeePageTests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Pages.HrPage.HRResignationPage;
import com.violetis.Utilities.ConfigReader;
import com.violetis.Pages.employeePage.EMPOffboardingResignationsPage;
import com.violetis.Pages.HRPage;
public class EMPOffboardResignationTest extends BaseTest {
	public LoginPage loginpage ;
	public EMPDashboardPage empdaspg;
	public  EMPOffboardingResignationsPage regpg ;
	public HRResignationPage hrrespg;
	public HRPage hrpg;;
	@BeforeClass
	public void navigatetoresignationspage() throws InterruptedException {
	loginpage=new LoginPage(driver);
	regpg=new EMPOffboardingResignationsPage(driver);
	empdaspg=new EMPDashboardPage(driver);
	hrrespg=new HRResignationPage(driver);
	loginpage.login();
	regpg.navigatetoResignationsPage();
	Thread.sleep(2000);
	
	}
/*	@Test(priority=1)
	public void validateAddnewresignations() {
		 LocalDate tomorrow = LocalDate.now().plusDays(1);
		 // Get components
	        String day = String.valueOf(tomorrow.getDayOfMonth());
	        String monthShort = tomorrow.format(DateTimeFormatter.ofPattern("MMM"));
	        String year = String.valueOf(tomorrow.getYear());
		regpg.clickonaddnewresignationbtn();
		regpg.enterResignationtitle("Job Change");
		regpg.enterdescription("I got an oppurtunity need to do resignation please approveit");
		regpg.enterResigntaionDate(monthShort, year, day);
		regpg.clickcreatebtn();
		
	}
	 
	        @DataProvider(name = "Resignation invalid data")
	        public Object[][] getData() {
	        	LocalDate tomorrow = LocalDate.now().plusDays(1);
	        	String year = String.valueOf(tomorrow.getYear());
	            return new Object[][]{
	            	
	                // Missing Title
	               {"", "Valid description",
	                        getMonthShort(1), year, getDay(1),
	                        "The title field is required."},

	                // Missing Description
	               {"Resignation B", "",
	                        getMonthShort(3), year, getDay(3),
	                        "The description field is required."},

	               // Missing Month → for date-related errors PASS ALL THREE AS EMPTY
	                {"Resignation C", "Valid desc","","","",
	                        
	                        "The start date field is required."},


	                

	            };
	            };
	        

	        // Helper to get future/past month (short format like "Nov")
	        private String getMonthShort(int daysOffset) {
	            return LocalDate.now().plusDays(daysOffset)
	                    .format(DateTimeFormatter.ofPattern("MMM"));
	        }

	        // Helper to get future/past year
	        private String getYear(int daysOffset) {
	            return String.valueOf(LocalDate.now().plusDays(daysOffset).getYear());
	        }

	        // Helper to get future/past day
	        private String getDay(int daysOffset) {
	            return String.valueOf(LocalDate.now().plusDays(daysOffset).getDayOfMonth());
	        }

	        // Helper to generate too long description
	        private String veryLongText() {
	            return "A".repeat(260); 
	        }
	        @Test(dataProvider = "Resignation invalid data",priority=2)
	        public void testAddResignation(String title, String desc, String month, String year, String day, String expectedMsg) throws InterruptedException {
	        	 regpg.clickonaddnewresignationbtn();
	        	 regpg.enterResignationtitle(title);
	     		regpg.enterdescription(desc);
	     		 if (!month.isEmpty() && !year.isEmpty() && !day.isEmpty()) {
	     			regpg.enterResigntaionDate(month, year, day);
	     	    }
	     		
	     		regpg.clickcreatebtn();

	        	    String actualStatus = regpg.getSubmissionStatus();
	        	    System.out.println("Actual Msg: " + actualStatus);

	        	    Assert.assertEquals(actualStatus, expectedMsg, "❌ Validation mismatch!");

	        	    // Close form for negative test cases
	        	    if (!expectedMsg.equalsIgnoreCase("Success")) {
	        	        regpg.clickcancelbtn();
	        	    }
	        	   
	        }*/
	        //*********************Pending moudle test methods
	       /* @Test(priority = 3)
	        public void testFirstPendingResignationData() {
	           
	        	regpg.clickPendingTab();

	            String title = regpg.getFirstPendingTitle();
	            String date = regpg.getFirstPendingDate();

	            System.out.println("Pending Title: " + title);
	            System.out.println("Pending Date: " + date);

	            Assert.assertFalse(title.isEmpty(), "Title should not be empty");
	            Assert.assertFalse(date.isEmpty(), "Date should not be empty");
	        }
	        @Test(priority = 4)
	        public void testViewPendingResignation() {
	           

	        	regpg.clickPendingTab();
	        	String title = regpg.getFirstPendingTitle();
	            String date = regpg.getFirstPendingDate();

	            System.out.println("Pending Title: " + title);
	            System.out.println("Pending Date: " + date);
	        	regpg.clickViewOnFirstPending();

	        	 // Step 3: Capture data from View Page
	            String actualTitle = regpg.getViewPageTitle();
	            String actualDate = regpg.getViewPageDate();

	            System.out.println("View Title: " + actualTitle);
	            System.out.println("View Date: " + actualDate);

	            // Step 4: Assertions
	            Assert.assertEquals(actualTitle, title, "Title does not match!");
	            Assert.assertEquals(actualDate, date, "Resignation Date does not match!");
	        }

	        @Test(priority = 5)
	        public void testEditPendingResignation() {
	           

	        	regpg.clickPendingTab();
	        	String date = regpg.getFirstPendingDate();
	        	System.out.println("Pending Date: " + date);
	        	String title = regpg.getFirstPendingTitle();
	        	System.out.println("Pending Title: " + title);
	        	regpg.clickEditOnFirstPending();
	        	 // Extract day, month, year
	            String[] dateParts = date.split(" ")[0].split("-");

	            int day = Integer.parseInt(dateParts[0]);
	            int month = Integer.parseInt(dateParts[1]);
	            int year = Integer.parseInt(dateParts[2]);

	            // Step 2: Compute new date (day+1)
	            int newDay = day + 1;

	            // Convert month → short (Jan, Feb, Mar...)
	            String monthShort = Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

	            System.out.println("Editing to: " + newDay + "-" + monthShort + "-" + year);
	            //Step 3: Click Edit button
	            regpg.clickEditOnFirstPending();
	         // Step 4: Update Title
	            String newTitle = "Updated Title " + System.currentTimeMillis();
	            regpg.editresignationform(newTitle,monthShort,String.valueOf(year), String.valueOf(newDay));
	        }*/
	        //******validate approved or rejected through cross module validation
			@Test
	        public void verifyapprovedstate() throws InterruptedException {
				String title = regpg.getFirstPendingTitle();
				String date = regpg.getFirstPendingDate();

		        // 1. Define input format
		        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");

		        // 2. Parse the string to LocalDateTime
		        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormat);

		        // 3. Add 30 days
		        LocalDateTime plus30 = dateTime.plusDays(30);

		        // 4. Extract required values
		        String month = plus30.format(DateTimeFormatter.ofPattern("MMM"));   // e.g., Nov
		        String year  = plus30.format(DateTimeFormatter.ofPattern("yyyy"));  // e.g., 2025/2026
		        String day   = plus30.format(DateTimeFormatter.ofPattern("dd"));    // e.g., 02, 20
		        String text="approved the resignation";
		        System.out.println("MONTH = " + month);
		        System.out.println("YEAR  = " + year);
		        System.out.println("DAY   = " + day);
	        	empdaspg.logout();
	        	loginpage.login(
				        ConfigReader.getProperty("hrusername"),
				        ConfigReader.getProperty("hrpassword")
				    );
	        	Thread.sleep(2000);
	        	hrrespg.navigaettoResignationpage();
	        	
	        	hrrespg.clickonserachtitleinput(title);
	        	Thread.sleep(2000);
	        	String act_title=hrrespg.getfirstrowtitle();
	        	if (title.equalsIgnoreCase(act_title)) {

	                System.out.println("Title matched: " + act_title);

	                // 👉 If matched, click Approve or Reject
	                hrrespg.clickonrejorappbtn();
	                String lastworkingday=hrrespg.fillresignformwithapprovedresignation(month, year, day,text);
	                hrrespg.clickonupdatebtn();
	                hrpg.clicklogout();
	                loginpage.login();
	                regpg.navigatetoResignationsPage();
	                
	                

	            } else {

	                System.out.println("Title did NOT match.");
	                System.out.println("Expected: " + title + " | Found: " + act_title);

	                // You can fail or skip test if needed
	                Assert.fail("Title mismatch — cannot approve/reject.");
	            }
	        	
	        	hrpg.clicklogout();
	        	loginpage.login();
	        	regpg.navigatetoResignationsPage();
	        	regpg.clikonapprovedtab();
	        	regpg.searchtitle(title);
	        	
	        	
	        }
	        	
	        	
	        }

