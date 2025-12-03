package com.violetis.Tests.EmployeePageTests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.HrPage.HrLogoutPage;
import com.violetis.Pages.HrPage.HRExpensesPage;
import com.violetis.Pages.employeePage.EMPExpensesPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Utilities.ConfigReader;

public class EMPExpensesTest extends BaseTest{
public LoginPage loginpage;
public EMPExpensesPage expensepg;
public EMPDashboardPage dashboardpg;
public HrLogoutPage hrlogout;
public HRExpensesPage hrexpensespg;
@BeforeClass
public void navigatetoexpensespage() {
	loginpage= new LoginPage(driver);
	expensepg=new EMPExpensesPage(driver);
	dashboardpg=new EMPDashboardPage(driver);
	hrlogout=new HrLogoutPage(driver);
	hrexpensespg=new HRExpensesPage(driver);
	loginpage.login();
	expensepg.clickonexpensesbtn();
}
//****************ADd new expenses module**********
/*@Test(priority=1, description=" validation by adding all fields on add expense module")
public void testValidExpense() throws InterruptedException {
	expensepg.clickonAddnewExpense();
	expensepg.enterExpensetype("TRAVEL");
	
	expensepg.enteramount("20");
	expensepg.clickonDatapicker();
	expensepg.enterExpenseraisedDate("Nov","2025","25");
	expensepg.enterreferencenumber("12345");
	
	//expensepg.uploadBill("D:\\Users\\Dell\\Downloads");
	
	expensepg.enternotes("Claim");
	expensepg.submitappreciaationform();
    

   
}*/
/*@Test(priority=2)
public void testExpenseTypeRequiredError() {
    expensepg.clickonAddnewExpense();
    
    // Do not enter expense type
    expensepg.enteramount("100");
    expensepg.submitappreciaationform();
    
    String errorMsg = expensepg.getExpenseTypeError();
    expensepg.clickcancelbtn();
    Assert.assertEquals(errorMsg, "The expense category id field is required.",
        "Error message mismatch!");
    
}
@Test(priority=3)
public void testAmountRequiredError() {
    expensepg.clickonAddnewExpense();
    
    // Do not enter expense type
    expensepg.enterExpensetype("HOTEL");
    expensepg.submitappreciaationform();
    
    String errorMsg = expensepg.getAmountError();
    expensepg.clickcancelbtn();
    Assert.assertEquals(errorMsg, "The amount field is required.",
        "Error message mismatch!");
}*/
//*********Pending tab validations********
/*@Test
public void validatependingtab() throws InterruptedException {

    String expensetype = "TRAVEL";
    String amt = "20";
    String refNo ="12345";
    String notes="Claim";
    LocalDate today = LocalDate.now();

    
    String month = today.format(DateTimeFormatter.ofPattern("MMM"));// "November"
    String year  = String.valueOf(today.getYear());                                 // "2025"
    String day   = String.valueOf(today.getDayOfMonth());   
    System.out.println(month);
   /* expensepg.clickonAddnewExpense();
    expensepg.enterExpensetype(expensetype);
    expensepg.enteramount(amt);
    expensepg.clickonDatapicker();
    expensepg.enterExpenseraisedDate(month,year,day);
    expensepg.enterreferencenumber(refNo);
    expensepg.enternotes(notes);
	expensepg.submitappreciaationform();
	Thread.sleep(4000);
   
   

    // Validate Expense Type
    String act_expensetype = expensepg.getfirstrowexpensetype();
    Assert.assertEquals(act_expensetype.toLowerCase(), expensetype.toLowerCase(), "expensetype mismatch!");

    // Validate Amount (remove currency)
    String act_amt = expensepg.getfirstrowamount().replace("£", "").replace(".00", "").trim();
    Assert.assertEquals(act_amt, amt);

    // Validate Date
    String act_dateandtime = expensepg.getfirstDatetime();  // Example: "26-11-2025 05:22 pm"
    String dateOnlyString = act_dateandtime.split(" ")[0];  // → "26-11-2025"

    // Convert "Nov" → month number
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
    int monthNum = Month.from(monthFormatter.parse(month)).getValue();

    // Expected LocalDate
    LocalDate expectedDate = LocalDate.of(Integer.parseInt(year), monthNum, Integer.parseInt(day));

    // Convert UI date (dd-MM-yyyy) to LocalDate
    DateTimeFormatter uiFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate actualDate = LocalDate.parse(dateOnlyString, uiFormatter);

    // Final Assertion
    Assert.assertEquals(actualDate, expectedDate, "Date does not match!");
    expensepg.clickfirstrowviewbtn();
    //view btn ele
    String view_EXPENSETYPE=expensepg.getviewbtnexpensetypedata();
    String view_AMT=expensepg.getviewbtnamountdata();
    String view_datetime=expensepg.getviewbtnDatetime();
    String View_refnumber=expensepg.getviewbtnrefno();
    String view_notes=expensepg.getviewbtnnotes();
   
    Assert.assertEquals(view_EXPENSETYPE,act_expensetype,"expensetype not matched in view data");
    Assert.assertEquals(view_AMT, expensepg.getfirstrowamount(),"amount not matched in view data");
    Thread.sleep(200);
    //Assert.assertEquals(view_datetime, act_dateandtime,"date and time not matched view data");
    Assert.assertEquals(View_refnumber, refNo,"reference number not matched in view data");
    Assert.assertEquals(view_notes,notes,"notes not matched in view data" );
    //edit btn
    String editday = String.valueOf(today.getDayOfMonth() - 1);
    expensepg.clickeditbtn();
    expensepg.enterExpensetype("HOTEL");
    Thread.sleep(2000);
    expensepg.clearamtdata();
    expensepg.enteramount("30");
    expensepg.clickonDatapicker();
	expensepg.enterExpenseraisedDate(month,year,editday);
	expensepg.clearrefno();
	expensepg.enterreferencenumber("122122");
	expensepg.clearnotes();
	expensepg.enternotes("edited claim");
	Thread.sleep(2000);
	
	
	expensepg.clickupdatebtn();
	Thread.sleep(2000);
	//download btn validations
	expensepg.clickdownloadbtn();
	Thread.sleep(2000);
	//validatedel btn
	expensepg.clickdelbtn();
	
}*/
@Test
public void validateapprovedtab() throws InterruptedException {
	 LocalDate today = LocalDate.now();
	String username="Mounika A";
	Thread.sleep(2000);
	String expensetype=expensepg.getfirstrowexpensetype();
	String date=expensepg.getfirstDatetime();
	System.out.println(expensetype);
	System.out.println(date);
	dashboardpg.logout();
	loginpage.login(
	        ConfigReader.getProperty("hrusername"),
	        ConfigReader.getProperty("hrpassword")
	    );
	hrexpensespg.navigatetoecpensesmodule();
	hrexpensespg.approveExpense(username,expensetype,date);
	String month = today.format(DateTimeFormatter.ofPattern("MMM"));// "November"
    String year  = String.valueOf(today.getYear());                                 // "2025"
    String day   = String.valueOf(today.getDayOfMonth()); 
    hrexpensespg.approveexpenseformfill(month,year,day,"test");
	hrlogout.clickonlogout();
	loginpage.login();
	expensepg.clickonexpensesbtn();
	expensepg.approvedtab();
	String act_exptype=expensepg.getfirstrowappexptype();
	String act_status=expensepg.getfirstrowappstatusele();
	Assert.assertEquals(expensetype, act_exptype,"expense type not matched in approved");
	Assert.assertEquals(act_status, "Approved");
}
	
	
	


}

