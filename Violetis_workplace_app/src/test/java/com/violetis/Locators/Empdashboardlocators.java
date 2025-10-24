package com.violetis.Locators;
import org.openqa.selenium.By;
public class Empdashboardlocators {
	public static final By Dashboard_btn=By.xpath("//div[@class='main-sidebar']//li[1]");
	public static final By self_btn=By.xpath("//span[normalize-space()='Self']");
	public static final By Clock_IN = By.xpath("//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-24 ant-col-lg-8 ant-col-xl-8 css-3dpotf']//div[@class='ant-space css-3dpotf ant-space-horizontal ant-space-align-center']//div[1]//button[1]");
	public static final By Clock_OUT=By.xpath("//span[normalize-space()='Clock Out']");
	public static final By Pre_Clockout_toastmsg=By.xpath("//span[normalize-space()='You have not clocked in']");
	public static final By empappr=By.xpath("//body//div[@id='app']//div[@class='ant-row mb-20 css-tv86ws']//div[@class='ant-row mb-20 css-tv86ws']//div[1]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By empwar=By.xpath("//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-24 ant-col-lg-16 ant-col-xl-16 css-tv86ws']//div[2]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By emp_Expences=By.xpath("//div[3]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By emp_complaints=By.xpath("//div[4]//div[1]//div[1]//figure[1]//div[1]//div[2]//figcaption[1]//h2[1]");
	public static final By empworkedtime=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[3]/span");
	public static final By emp_clockINtime=By.xpath("//p[contains(text(), 'Clock In Time')]");
	public static final By confirmclockoutbtn=By.xpath("//div[@class='ant-modal-body']//button[2]");
	public static final By confirm_cancel_clockoutbtn=By.xpath("//div[@class='ant-modal-confirm-btns']//span[contains(text(),'Cancel')]");
	public static final By error_msg=By.xpath("");
	public static final By CURRENT_DATE_TIME=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[1]/p");
	public static final By Clock_Out_Time=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[4]/div/div/div/button/span");
	public static final By emp_appreciaationcount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[2]/div/div[1]/div/div/figure/div/div[2]/figcaption/h2");
	public static final By emp_warningcount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[2]/div/div[2]/div/div/figure/div/div[2]/figcaption/h2");
	public static final By emp_expensecount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[2]/div/div[3]/div/div/figure/div/div[2]/figcaption/h2");
	public static final By emp_complaintscount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[2]/div/div[4]/div/div/figure/div/div[2]/figcaption/h2");
	public static final By logoutbtn=By.xpath("//div[@class='main-sidebar']//li[15]");
	public static final By confirm_logout=By.xpath("//span[normalize-space()='Yes, Logout']");
//Work hour details section locators
	public static final By Total_officetime_data=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[3]/div/div[2]/div[1]/div[2]/strong");
	public static final By total_worked_time_data=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[3]/div/div[2]/div[1]/div[3]/strong");
	public static final By total_late_time=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[3]/div/div[2]/div[1]/div[4]/strong");
	public static final By work_hrs_calendar_btn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[3]/div/div[1]/div/div[2]/div/div/button");
	//Employee profile
	public static final By empemailid=By.xpath("//div[@class='profile-details']//div[2]/span[2]");
	public static final By empname=By.xpath("//div[@class='profile-name']");
	// Appy New Leave locators
	public static final By Apply_new_leavebtn=By.xpath("//button[@class='css-gaz7ss ant-btn ant-btn-primary ant-btn-block']");
	public static final By Leave_typebtn=By.xpath("//input[@id='form_item_leave_type_id']");
	public static final By start_leave_month_ele=By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/button[1]");
	public static final By end_leave_month_ele=By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div/button[1]");
	public static final By Leave_type_opts=By.xpath("//div[@class='rc-virtual-list-holder-inner']/div");
	public static final By Half_day_yesbtn=By.xpath("//span[normalize-space()='Yes']");
	public static final By Half_day_Nobtn=By.xpath("//span[normalize-space()='No']");
	public static final By Leave_reasonbox=By.xpath("//div[@class='ant-form-item-control-input-content']/textarea");
	public static final By Month_forwardbtn=By.xpath("//div[@class='ant-picker-panel-container']//div[2]//div[1]//div[1]//button[3]//span[1]");
	public static final By Startleave_yearele=By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/button[2]");
	public static final By endLeave_yearele=By.xpath("/html/body/div[6]/div/div/div/div[2]/div/div/div/div[2]/div/div[1]/div/button[2]");
	public static final By alldates_indatepicker=By.xpath("//table[@class='ant-picker-content']/tbody[1]/tr/td");
	public static final By half_leave_drp_dwnbtn=By.xpath("//input[@id='form_item_half_leave']");
	public static final By Create_btn=By.xpath("//span[normalize-space()='Create']");
	public static final By Datepickerbox = By.xpath("//input[@id='form_item_date'] | //input[@id='form_item_warning_date'] | //input[@id='form_item_date_time']");
	//for leave validations
	public static final By startdateleaveele=By.xpath("//input[@placeholder='Start date']");
	public static final By enddateleaveele=By.xpath("//input[@placeholder='End date']");//validate using getattr of val
	
	//leave details module
	public static final By All_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[1]/div");
	public static final By Approved_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[2]/div");
	public static final By Rej_Leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[3]/div");
	public static final By Pending_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[4]/div");
	public static final By Payed_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[5]/div");
	public static final By Unpaid_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[6]/div");
	public static final By Half_day_leave_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[2]/div/div[2]/div[1]/div[7]/div");
	
	//Attendence details module
	public static final By totalattendencecount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[3]/div/div[2]/div/div[1]/div/div[1]/span[2]");
	public static final By present_count=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[3]/div/div[2]/div/div[1]/div/div[2]/span[2]");
	public static final By leavecount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/span[2]");
	public static final By halfdaycount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[3]/div/div[2]/div/div[1]/div/div[4]/span[2]");
	public static final By lateattendencecount=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[4]/div/div[3]/div/div[2]/div/div[1]/div/div[5]/span[2]");
	//increamnet/decreamnet module
	public static final By yeardrpdown=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[2]/div/div[1]/div/div[2]/div/div[1]/input");
	public static final By yearrangeele=By.xpath("//button[@class='ant-picker-decade-btn']");
	public static final By yearfrwdbtn=By.xpath("//button[@class='ant-picker-header-super-next-btn']");
	public static final By yearbackwardbtn=By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
	public static final By yearele=By.xpath("//table[@class='ant-picker-content']//tbody//tr//td/div");
	public static final By noincdectextele=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[4]/div/div[2]/div[1]/div[3]/span");
	public static final By promodateele=By.xpath("//div[@class='ant-timeline-item-content']/span[1]");
	public static final By promotiontype=By.xpath("//div[@class='ant-timeline-item-content']/span[2]");
	public static final By promotedempname=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[1]");
	public static final By curredesignationele=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[2]/span[1]");
	public static final By promoteddesignationele=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[2]/span[3]");
	public static final By incsalseenbtn=By.xpath("//button[@class=\"css-gaz7ss ant-btn ant-btn-link ant-btn-icon-only\"]");
	public static final By promotionscount=By.xpath("//div[@class='ps']/ul//li");
	
}

