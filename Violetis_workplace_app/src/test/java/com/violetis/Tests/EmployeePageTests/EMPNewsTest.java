package com.violetis.Tests.EmployeePageTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.employeePage.EMPNewsPage;

public class EMPNewsTest extends BaseTest {
	public LoginPage loginpage;
	public EMPNewsPage empnewspg;
	@BeforeClass
	public void navigaettoNewspage() throws InterruptedException {
		loginpage=new LoginPage(driver);
		empnewspg=new EMPNewsPage(driver);
		loginpage.login();
		empnewspg.navigatetonewspage();
		Thread.sleep(2000);		
	}
/*	@Test(priority=1)
	public void testValidSearch() {
		empnewspg.searchNews("violetis");

	    List<String> titles = empnewspg.getAllTitles();
	    boolean found = titles.stream()
	                          .anyMatch(title -> title.contains("violetis"));

	    Assert.assertTrue(found, "Search result doesn't match for Perplexity");
	}
	  @Test(priority=2)
	    public void testPartialSearch() {
		  empnewspg.searchNews("Latest");

	        Assert.assertFalse(empnewspg.isEmptyStateDisplayed(), "Unexpected empty results");
	    }
	  @Test(priority=3)
	    public void testNoMatchSearch() {
		  empnewspg.searchNews("abc");

	        Assert.assertTrue(empnewspg.isEmptyStateDisplayed(), "No-record state NOT shown");
	    }
	  @Test(priority=4)
	    public void testColumnHeaders() {


	        Assert.assertTrue(empnewspg.isColumnHeaderDisplayed("Title"));
	        Assert.assertTrue(empnewspg.isColumnHeaderDisplayed("Action"));
	    }
	  @Test(priority=5)
	    public void testViewIconVisible() {
		  driver.navigate().refresh();
		  Assert.assertTrue(empnewspg.isViewIconPresent(), "View icon missing");
	    }*/

	   @Test(priority=6)
	    public void testViewNewsDetails() {
		   String tableTitle = empnewspg.getAllTitles().get(0).trim();
		   empnewspg.searchNews(tableTitle);
		   empnewspg.clickViewIcon(0);
		   String Actual_Title = empnewspg.gettitlefromviewpage();
	       Assert.assertEquals(tableTitle, Actual_Title,"not equal");
	    }

}
