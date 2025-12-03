package com.violetis.Tests.EmployeePageTests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EMPPromotionordemotionPage;

public class EMPPromotionordemotionTest extends BaseTest{
public LoginPage loginpage;
public EMPPromotionordemotionPage promodemopg;
@BeforeClass
public void navigatetopromotiondemotionpage() throws InterruptedException {
	loginpage=new LoginPage(driver);
	promodemopg=new EMPPromotionordemotionPage(driver);
	loginpage.login();
	promodemopg.navigatetoincordecmodule();
	Thread.sleep(2000);
}
/*@Test(priority=1)
public void verifyEmptyState() {
	promodemopg.selectyear("2024");
	Assert.assertTrue(promodemopg.isNoDataDisplayed(), "No data message not displayed!");
}
@Test(priority=2)
public void verifyYearFilterwithhavingdata() throws InterruptedException {
 String expectedYear = "2025";
 promodemopg.selectyear(expectedYear);
 Thread.sleep(2000);  // Wait for table refresh

    // Verify rows exist
    Assert.assertTrue(promodemopg.getrowCount() > 0, "Rows should be loaded");

    // Verify every row contains year = 2025
    boolean result = promodemopg.verifyAllRowsYear(expectedYear);

    Assert.assertTrue(result, "All rows should contain year " + expectedYear);
}
@Test(priority=3)
public void verifymonthfilter() throws InterruptedException {
	 String expectedmonth="January";
	 String expectedYear = "2026";
	 promodemopg.selectyear(expectedYear);
	 int expectedMonthNumber = promodemopg.monthNameToNumber(expectedmonth);
	 String expectedMonthno = String.format("%02d", expectedMonthNumber); 
	 promodemopg.selectmonthFilter(expectedmonth);
	 Thread.sleep(2000);
	 List<WebElement> dateCells = promodemopg.getDateColumnValues();
	 for (WebElement cell : dateCells) {
	        String fullDate = cell.getText().trim();   // e.g. "08-08-2025"

	        String monthFromDate = fullDate.substring(3, 5); // extract MM

	        Assert.assertEquals(
	                monthFromDate,
	                expectedMonthno,
	                "Date row contains wrong month: " + fullDate
	        );
	 }
}*/
@Test
public void verifyAllTabContainsAllRecords() throws InterruptedException {

    List<String> incrementRows = promodemopg.getIncrementRows();
    Thread.sleep(3000);
    List<String> promotionRows = promodemopg.getPromotionRows();
    Thread.sleep(3000);
    List<String> incPromotionRows = promodemopg.getIncPromotionRows();
    Thread.sleep(3000);
    List<String> decrementRows = promodemopg.getDecrementRows();
    Thread.sleep(3000);
    List<String> decPromotionRows = promodemopg.getDecdemotionRows();
    Thread.sleep(3000);

    // Load all rows in All tab (scrolls automatically)
    List<String> allTabRows = promodemopg.getAllTabRows();
    Thread.sleep(3000);
    
    Set<String> combinedSet = new HashSet<>();
    combinedSet.addAll(incrementRows);
    combinedSet.addAll(promotionRows);
    combinedSet.addAll(incPromotionRows);
    combinedSet.addAll(decrementRows);
    combinedSet.addAll(decPromotionRows);

    for (String row : combinedSet) {
        Assert.assertTrue(
            allTabRows.contains(row),
            "❌ Row missing in All tab: " + row
        );
    }

    System.out.println("✅ All rows exist in All tab!");
}
}
