package com.violetis.Tests.ManagerPageTest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.HrPage.HrAssetsPage;
import com.violetis.Pages.HrPage.HrLogoutPage;
import com.violetis.Pages.ManagerPackage.Assetspage;
import com.violetis.Pages.ManagerPackage.LogoutPage;
import com.violetis.Utilities.ConfigReader;

public class AssetsTest extends BaseTest{
public LoginPage loginpage;
public Assetspage managerassetspage;
public HrAssetsPage Hrassetspg;
public LogoutPage managerlogout;
public HrLogoutPage hrlogoutpg;
@BeforeClass
public void init() {
	loginpage=new LoginPage(driver);
	managerassetspage=new Assetspage(driver);
	Hrassetspg=new HrAssetsPage(driver);
	managerlogout=new LogoutPage(driver);
	hrlogoutpg=new HrLogoutPage(driver);
}
/*@Test(priority=1)
public void validatenotworkingtabdata() throws InterruptedException {
	log.info("Login as Manager");
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
	log.info("Navigating to Assets module");
	managerassetspage.navigatetoAssetsPage();
	log.info("clicking on not working tab");
	managerassetspage.clickonNotworkingtab();
	log.info("getting  not working tab data");
	 List<Map<String, String>> managerAssets=managerassetspage.getAllNotWorkingAssets();
	 System.out.println(managerAssets);
	 log.info("doing logout from manager");
	 managerlogout.clickonlogoutbtn();
	 log.info("Login as Hr");
	 loginpage.login(
		        ConfigReader.getProperty("hrusername"),
		        ConfigReader.getProperty("hrpassword")
		    );
	 log.info("Navigate to Assets module");
	 Hrassetspg.navigatetoAssetsPage();
	 log.info("click on not working tab");
	 Hrassetspg.clickonnotworkingtab();
	 log.info("get not working assets data from hr");
	 List<Map<String, String>> hrAssets= Hrassetspg.getAllNotWorkingAssets();
	 System.out.println(hrAssets);
	// Compare lists directly
	 log.info("comparing the not working assets data from manger and HR");
	  Assert.assertEquals(
	            new HashSet<>(managerAssets),
	            new HashSet<>(hrAssets),
	            "❌ Manager and HR Not Working assets data mismatch"
	    );
	  log.info("doing logout from hr");
	  hrlogoutpg.clickonlogout();
	 
}*/
@Test(priority=2)
public void validateselectlocationdrpdown() throws InterruptedException {
	log.info("Login as Manager");
	loginpage.login(
	        ConfigReader.getProperty("managertestun"),
	        ConfigReader.getProperty("managertestpswd")
	    );
	managerassetspage.navigatetoAssetsPage();
	managerassetspage.clickonNotworkingtab();
	//managerassetspage.SelectBylocation("India");
	managerassetspage.validatinglocationbyfilter("India");
	managerlogout.clickonlogoutbtn();
}
}
