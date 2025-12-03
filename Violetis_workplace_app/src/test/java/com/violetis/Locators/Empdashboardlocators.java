package com.violetis.Locators;
import org.openqa.selenium.By;
public class Empdashboardlocators {
	public static final By Dashboard_btn=By.xpath("//div[@class='main-sidebar']//li[1]");
	public static final By self_btn=By.xpath("//span[normalize-space()='Self']");
	public static final By Clock_IN = By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[4]/div/div/div[1]");
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
	public static final By Clock_Out_Time = By.xpath("//*[@id='components-layout-demo-responsive']/section/section/div/div/main/div[2]/div/div[2]/div[1]/div/div/div/div[4]/div/div/div/button/span");
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
	public static final By alldates_indatepicker=By.xpath("//table[@class='ant-picker-content']//tbody[1]/tr/td");
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
	public static final By noincdectextele=By.xpath("//div[@class='ant-result-extra']/span[contains(text(),'No active increments or promotions at this time')]");
	public static final By promodateele=By.xpath("//div[@class='ant-timeline-item-content']/span[1]");
	public static final By promotiontype=By.xpath("//div[@class='ant-timeline-item-content']/span[2]");
	public static final By promotedempname=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[1]");
	public static final By curredesignationele=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[2]/span[1]");
	public static final By promoteddesignationele=By.xpath("//div[@class='ant-timeline-item-content']/div/div/div[2]/span[3]");
	public static final By incsalseenbtn=By.xpath("//button[@class=\"css-gaz7ss ant-btn ant-btn-link ant-btn-icon-only\"]");
	public static final By promotionscount=By.xpath("//div[@class='ps']/ul//li");
	//Birthday module locators
	public static final By bdaydatepicker=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[3]/div/div[1]/div/div[2]/div/div[1]/span/div/div[1]/input");
	public static final By selectuserdrpdwnbtn=By.xpath("//input[@id='rc_select_0']");
	public static final By bdmonthele=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/div/button[1]");
	public static final By bdyearele=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/div/button[2]");
	public static final By bdayyear_frwd_btn=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/button[4]");
	public static final By bdyearprevbtn=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/button[1]");
	public static final By bdaydatelems=By.xpath("//table[@class='ant-picker-content']/tbody/tr/td/div");
	public static final By bdayrows=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[3]/div/div[2]/div/div/div[3]/div/div/ul/li");
	public static final By bdaymonthforwardbtn=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/button[3]/span");
	public static final By bdaymonthprevbtn=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/button[2]/span");
	public static final By bdayusernameeles=By.xpath("//div[@class='ant-spin-container']/ul/li/div/div[2]/h4/div/div[1]");
	public static final By bdayuserdateles=By.xpath("//div[@class='ant-spin-container']/ul/li/div/div[2]/h4/div/div[2]");
	public static final By nobdaymsgele=By.xpath("//span[contains(text(),'There is no birthdays')]");
	//Work Anniversary locators
	public static final By workanniversarydatepicker=By.xpath("//*[@id=\'components-layout-demo-responsive\']/section/section/div/div/main/div[2]/div/div[5]/div[4]/div/div[1]/div/div[2]/div/div[1]");
	public static final By wokannseluserdrpdwn=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[4]/div/div[1]/div/div[2]/div/div[2]/span/div");
	public static final By noworkannele=By.xpath("//span[contains(text(),'There is no upcoming work anniversary')]");
	public static final By workannmonth_ele=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/div/button[1]");
	public static final By workannyearele=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/div/button[2]");
	public static final By workannmonthfrwdbtn=By.xpath("/html/body/div[5]/div/div/div/div/div/div[1]/div[1]/button[3]/span");
	public static final By wokann_month_prev=By.xpath("/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/button[2]");
	public static final By badege_eles=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[4]/div/div[2]/div/div/div[3]/div/div/ul/li/div/div[2]/h4/div/div[2]");
	public static final By upcoming_ann_users=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[4]/div/div[2]/div/div/div[3]/div/div/ul/li");
	public static final By upcoming_ann_username=By.xpath("//div[@class='notification-left']/strong");
	public static final By upcoming_ann_dates=By.xpath("//div[@class='notification-left']/div");
	//weekend holiday module
	public static final By hlddatepicker=By.xpath("//input[starts-with(@title, '20')]");
	public static final By hldbtn=By.xpath("//label[@class='ant-segmented-item ant-segmented-item-selected']");
	public static final By weekendbtn=By.xpath("//label[@class='ant-segmented-item']");
	public static final By hldrows=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[5]/div/div[2]/div[2]/div/div[3]/div/div/ul/li");
	public static final By weekendrows=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[5]/div/div[2]/div[2]/div/div[3]/div/div/ul/li");
	public static final By nohldmsgele=By.xpath("//span[contains(text(),'There are no holidays')]");
	public static final By yearrangeeleinpicker=By.xpath("//button[@class='ant-picker-decade-btn']");			
	public static final By allyearelesinpicker=By.xpath("//table[@class='ant-picker-content']//tbody//td");
	public static final By nextbutninpicker=By.xpath("/html/body/div[4]/div/div/div/div/div/div/div[1]/button[2]");
	public static final By prevbtninpicker=By.xpath("/html/body/div[4]/div/div/div/div/div/div/div[1]/button[1]");
	public static final By holidaynames=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[5]/div/div[2]/div[2]/div/div[3]/div/div/ul/li/div/div/h4/div/div/strong");
	public static final By holidaydates=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[5]/div/div[2]/div[2]/div/div[3]/div/div/ul/li/div/div/h4/div/div[2]");
	public static final By weekenddateseles=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[5]/div[5]/div/div[2]/div[2]/div/div[3]/div/div/ul/li/div/div/h4/div/div[2]");
	//next holiday locators
	public static final By upcominghldyele=By.xpath("//div[contains(text(),'Weekend, 01 Nov 2025')]");
	public static final By viewallbtn=By.xpath("//a[@href='/admin/self/holidays']//button[@type='button']//span[contains(text(),'View All')]");
	public static final By holidaypgheader=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[1]/div/div/div/div[1]/div/div/div/span");
	public static final By monthdropdpwnbtn=By.xpath("//input[@id='rc_select_22']");
	public static final By allnexthldbtn=By.xpath("//li[@title='Next Page']//button[@type='button']");
	public static final By allhldydateeles=By.xpath("//tbody[@class='ant-table-tbody']//tr/td[2]");
	//policies module
	public static final By latestpolicyname=By.xpath("//div[@class='policy-updated']");
	public static final By poliviewallbutton=By.xpath("//*[@id=\"components-layout-demo-responsive\"]/section/section/div/div/main/div[2]/div/div[6]/div[2]/div[1]/div/div/div/div/a/button/span");
	//next birthday module
	public static final By nextbirthdayele=By.xpath("//div[@class='member-name']");
	public static final By nextarrowbtn=By.xpath("//div[@class='custom-slick-arrow slick-arrow slick-next']");
	public static final By prevarrowbtn=By.xpath("//div[@class='custom-slick-arrow slick-arrow slick-prev']");
	public static final By birthdaydates=By.xpath("//div[@class='member-role']");
	
}

