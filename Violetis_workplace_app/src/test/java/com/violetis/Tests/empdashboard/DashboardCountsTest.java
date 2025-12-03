package com.violetis.Tests.empdashboard;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.testng.Assert;
import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPage;
import com.violetis.Pages.employeedashboardpage.EMPDashboardPage;
import com.violetis.Utilities.ConfigReader;
import com.violetis.Pages.employeePage.EMPComplaintPage;
import com.violetis.Pages.employeePage.EMPExpensesPage;

public class DashboardCountsTest extends BaseTest {
	private LoginPage loginPage;
	private EMPDashboardPage dashboardPage;
	private ManagerPage managerPage;
	private EMPExpensesPage expencepage;
	private EMPComplaintPage complaintpage;
	int beforecount;
	@BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new EMPDashboardPage(driver);
        managerPage = new ManagerPage(driver);
        expencepage=new EMPExpensesPage(driver);
        complaintpage=new EMPComplaintPage(driver);
       
	}
	
@Test(priority=1)
	public void validateAppreciationCountAfterMangerAction() throws InterruptedException {
		// Step 1: Login as Employee to get initial count and logout
		loginPage.login();
		Thread.sleep(2000);
		int beforecount=dashboardPage.getAppreciationsCount();
		log.info("Appreciation count*** Before manager gives***" +beforecount);
		dashboardPage.logout();
		// Step 2:  Login as Manager give Appreciation count and logout
				loginPage.login(
				        ConfigReader.getProperty("manageruname"),
				        ConfigReader.getProperty("managerpass")
				    );
				
				managerPage.navigateToAppreciations();
			    managerPage.clickonAddAppriciationbtn();
				
				managerPage.fillappreciationform("Mounika A","Dec","2025","26"); 
				managerPage.Managerlogout();
				
				
				 // Step 3:Login again as Employee and validate appreciation count
				loginPage.login();
				int AfterCount=dashboardPage.getAppreciationsCount();
				log.info("Appreciation count*** After manager gives***" +AfterCount);
				Assert.assertEquals(AfterCount, beforecount + 1, "Appreciation count did not increase!");
				dashboardPage.logout();
		
	} 

	@Test(priority=2)
	public void validateWarningcountAfterMangerACtion() {
	// Step 1: Login as Employee to get initial count and logout
				loginPage.login();
				int beforecount=dashboardPage.getWarningsCount();
				log.info("Warning count*** Before manager gives***" +beforecount);
				dashboardPage.logout();
				 

				// Step 2:  Login as Manager give Warning toemployee and logout
						loginPage.login(
						        ConfigReader.getProperty("manageruname"),
						        ConfigReader.getProperty("managerpass")
						    );
						managerPage.navigateTooffboarding();
						managerPage.clickonNewWarningbtn();
						managerPage.fillWarnedform("Mounika A","Warn Test","Oct","2025","14");
						managerPage.Managerlogout();
						//Step 3:Login again as Employee and validate Warning count
						loginPage.login();
						int AfterCount=dashboardPage.getWarningsCount();
						log.info("Appreciation count*** After manager gives***" +AfterCount);
						Assert.assertEquals(AfterCount, beforecount + 1, "Warning count did not increase!");
						dashboardPage.logout();
	}
	@Test(priority=3)
	public void validateExpensecountAftreraisingExpense() throws InterruptedException {
		loginPage.login();
		Thread.sleep(6000);
		int beforecount=dashboardPage.getExpensesCount();
		log.info("Expense count*** Before Raising Expenses request***" +beforecount);
		System.out.println(beforecount);
		expencepage.clickonexpensesbtn();
		expencepage.clickonAddnewExpense();
		expencepage.enterexpensedetails("test","20","Oct","2025","14","Ref1234","sample");
		dashboardPage.clickondashboardbtn();
		Thread.sleep(2000);
		int AfterCount=dashboardPage.getExpensesCount();
		log.info("Expenses count*** After Raising Expense request***" +AfterCount);
		Assert.assertEquals(AfterCount, beforecount + 1, "Expense count did not increase!");
		dashboardPage.logout();
		
	}
	@Test(priority=4)
	public void validatecomplaintcount() throws InterruptedException {
		loginPage.login("mounika.aukpula08@gmail.com","Mounika@1997");
		int beforecount=dashboardPage.getComplaintsCount();
		log.info("complaint count*** Before someone gives***" +beforecount);
		dashboardPage.logout();
		driver.navigate().refresh();
		loginPage.login();
		complaintpage.Navigatetocomplaintbtn();
		complaintpage.Navigatetocomplaintbtn();
		complaintpage.clickonaddnewcomplaint();
		complaintpage.fillcomplaintform("Test_complaint","Oct","2025","15","mounikaap","comp_desc");
		Thread.sleep(2000);
		dashboardPage.logout();
		driver.navigate().refresh();
		loginPage.login("mounika.aukpula08@gmail.com","Mounika@1997");
		int Aftercount=dashboardPage.getComplaintsCount();
		log.info("complaint count*** After someone gives***" +Aftercount);
		Assert.assertEquals(Aftercount, beforecount + 1, "complaint count did not increase!");
		dashboardPage.logout();
	}
			
}
