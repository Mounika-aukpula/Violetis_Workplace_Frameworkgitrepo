package com.violetis.Tests.ManagerPageTest;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPackage.AppreciationsPage;
import com.violetis.Pages.ManagerPackage.EmployeePage;
import com.violetis.Utilities.ConfigReader;

public class AppreciationsTest extends BaseTest {
public LoginPage loginpage;
public EmployeePage emppg;
public AppreciationsPage apppg;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	emppg=new EmployeePage(driver);
	apppg=new AppreciationsPage(driver);
	log.info("login as manager");
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
}
/*@Test(priority=1)
public void validateappusers() throws InterruptedException {
	log.info("Navigate to employees page");
	emppg.navigatetoemployeepage();
	log.info("clicked on all tab");
	emppg.clickonalltab();
	log.info("fetching all emp names under all tab");
	List<String> employeeNames=emppg.getAllEmployeeNames();
	emppg.dashboardnavigation();
	log.info("Navigate to appreciations page");
	apppg.navigatetoAppreciationpage();
	List<String> appreciationUsers=apppg.getAppreciatedUserNames();
	// Validation
    for (String user : appreciationUsers) {
        Assert.assertTrue(
            employeeNames.contains(user),
            "❌ Appreciated user not belongs to the Managers employees: " + user
        );
    }
}
@Test(priority = 2)
public void validateAppreciationDateFormat() throws java.text.ParseException {

	apppg.navigatetoAppreciationpage();
    List<String> dates = apppg.getAppreciationDates();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
    sdf.setLenient(false); // strict format validation

    for (String date : dates) {
        sdf.parse(date);
		Assert.assertTrue(true, "Valid date format: " + date);
    }
}*/
@Test(priority=3)
public void validateawardcol() {
	apppg.navigatetoAppreciationpage();
	Set<String> awardsFromTable=apppg.getAwardsFromTable();
	Set<String> awardsFromdropdown=apppg.getAwardsFromDropdown();
	 // Validate dropdown contains all table awards

    SoftAssert softAssert = new SoftAssert();
    for (String tableAward : awardsFromTable) {
        softAssert.assertTrue(
            awardsFromdropdown.contains(tableAward),
            "❌ Dropdown missing award from table: " + tableAward
        );
        softAssert.assertAll();
    }
}

/*@Test(priority = 5)
public void validatePriceAmountcolumnFormat() {
    List<String> prices = apppg.getPriceAmounts();

    SoftAssert softAssert = new SoftAssert();

    String priceRegex = "^£\\d+(\\.\\d{1,2})?$";

    for (String price : prices) {
        softAssert.assertTrue(
            price.matches(priceRegex),
            "❌ Invalid price format found: " + price
        );
    }

    softAssert.assertAll();
}
@Test(priority=6)
public void validateselectuserdropdownandtabledata() throws InterruptedException {
	String uname="emp";
	apppg.SelectByuser(uname);
	List<String> appusernames=apppg.getAppreciatedUserNames();
	for(String appuname:appusernames) {
		Assert.assertEquals(appuname, uname);
	}
	
	
}
@Test(priority=7)
public void validateselectawarddropdownontabledata() {
	driver.navigate().refresh();
	String awardname="Best Performance";
	apppg.selectawarddrpdown(awardname);
	Set<String> awards=apppg.getAwardsFromTable();
	for(String award:awards) {
		Assert.assertEquals(award, awardname);
	}
}*/
@Test(priority=8)
 public void addAppreciationWithValidData() throws InterruptedException {
	apppg.clickaddnewappbtn();
	apppg.enteruserdropdownoption("mounika");
	// Pass only number of days
    apppg.selectAppreciationDateAfterDays(5);
    apppg.enterprizemoney("20");
    Thread.sleep(2000);
    apppg.selectawarddrpdown("Best Performance");
    apppg.enteraccoutnno("Payer_account");
    Thread.sleep(2000);
    apppg.clickaddpricegivenbtn();
    Thread.sleep(2000);
    apppg.enterprizegivefordata("Amazon");
    Thread.sleep(2000);
    apppg.enterdescription("Appreciation");
    Thread.sleep(2000);
    apppg.clickcreatebtn();
    Thread.sleep(5000);
}
}

