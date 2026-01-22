package com.violetis.Tests.ManagerPageTest;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.violetis.Base.BaseTest;
import com.violetis.Pages.LoginPage;
import com.violetis.Pages.ManagerPackage.AttendenceDetailsPage;
import com.violetis.Utilities.ConfigReader;

public class AttendenceDetailsTest extends BaseTest{
public LoginPage loginpage;
public AttendenceDetailsPage Attendencedetailspg;
@BeforeClass
public void init() {
loginpage=new LoginPage(driver);
Attendencedetailspg=new AttendenceDetailsPage(driver);

}
@Test
public void validateAttendencedetails() {
	loginpage.login("emp1@gmail.com","Violetis@2025");
	
	loginpage.login(ConfigReader.getProperty("managertestun"),ConfigReader.getProperty("managertestpswd"));
	Attendencedetailspg.navigatetoAttendencedetailsmenu();
	Attendencedetailspg.selectuser("emp");
	Map<String,String> data=Attendencedetailspg.getFirstRowAttendanceData();
	System.out.print(data);
}
}
