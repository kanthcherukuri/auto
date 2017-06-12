package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;




public class Elements_Diagnostics  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String home_city,home_area,home_specialization,map_AreaName,searchIcon,link_customerlogin,link_practicelogin,link_contactus,link_aboutus,link_diagnostics,link_termsconditions,link_privacypolicy,link_cancellationrefundpolicy,button_forandroid,button_forios;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
	 
	 //Diagonistic Login page Locators variables
	    public static String username;
		public static String password;
		public static String loginbutton;
		
		//Diagnostic Home visit appointment locators variables
		public static String clickonappointmentsmenu;
		public static String clickontoggle;
		public static String tommorowmenu;
		public static String morninghomevisit;
		public static String noonhomevisit;
		public static String eveninghomevisit;
		public static String eveningfirstcell;
		public static String detailsfirstname;
		public static String detailslastname;
		public static String detailsmobile;
		public static String detailsemail;
		public static String detailsaddress;
		public static String detailsproblem;
		public static String packagetab;
		public static String packagecheckbox;
		public static String windowsavebutton, homevisitdashboardsize, homevisitimageindashboard;
		
		//notification variable
		public static String notification;
		
		//Ellipse locator Variables
		public static String ellipse;
		
		//Diagnostics logout locator variables
		public static String clickonmyaccountmenu;
		public static String clickonsignout;
		public static String confirmsignout;
		
		//Appointments Reschedule Variables
		public static String clickonmore;
		public static String clickonchange;
		public static String nextdaymenu;
		public static String topnotification;
		
		//Cancel Appointment Variables
		public static String clickoncancel;
		public static String selectbox;
		public static String submitbutton;
		
		//Bulk Cancel Locator Variables
		public static String fromtime;
		public static String totime;
		public static String bulksubmitbutton;
		public static String fromcanceldate;
		public static String tocanceldate;
		public static String clickonbulkcancelcalendar;
		public static String enableddates;
		
		//Diagnostic Appointment Creation Variables
		public static String morningmenu;
		public static String noonmenu;
		public static String eveningmenu;
		
		//View Diagnostic Appointment Variables
		public static String calltext;
		public static String changetext;
		public static String canceltext;
		
		//patient tab Variables
		public static String clickonpatientmenu;
		public static String clickonsearchicon;
		public static String todaytabsize;
		public static String clickonalltab;
		public static String serachtextbox;
		public static String alltabsize;
		public static String  clickonserachbarid;
		public static String alltabgetfullname;
		public static String alltabstatus;
		public static String todaytabfullname;
		public static String todaytabstatus;
		
		//profile Variables
		public static String clickonaccountmenu;
		public static String abouteditbutton;
		public static String shortname;
		public static String profilemobile;
		public static String language;
		public static String aboutsave;
		public static String profileaddressmenu;
		public static String addresseditbutton;
		public static String addresscountry;
		public static String addressstate;
		public static String addresscity;
		public static String addresssave;
		public static String clickonawardsmenu;
		public static String awardseditbutton;
		public static String awardsource;
		public static String awardyear;
		public static String saveawards;
		public static String clickonsignoutmenu;
		public static String confirmlogout;
		
		//Show More Diagnostic Dashboard
		public static String showmorebutton;
		public static String showlessbutton;
		
		//Dashboard variables
		public static String clickondashboardmenu;
		public static String todayhighliteddate;
		public static String todaysappointmentslist;
		public static String graphtodayappointmentcount;
		
		//Checkin Variables
		public static String checkinbutton;
		public static String checkinstartconsultation;
		public static String packagessavebutton;
		public static String appointmentnotes;
		public static String appointmentnotesavebutton;
		public static String generatebillsbutton;
		public static String checkoutbutton;
		
		//Schedule Variables
		public static String clickonschedulemenu, clickondiagnosticmanage, clickoncontact, clickaddclinic,addname,addphone,addemail,addfax;
		public static String clickonsave, clickondelete, clickonpackagemenu, clickonaddpackagebutton;
		
		//ScheduleHomePickup Variables
		public static String clickonhomevisitaddpackagebutton, clickonhomevisitpackagesavebutton, clickonhometestaddbutton, clickhomevisittestsavebutton;
		public static String clickonhomevisitmenu,   clickonmanagetestsmenu, clickonpackagemenuinhomepickup;
		
		//Admin variables
		public static String diagnosticapprovalsurl, adminsearchbutton, facilitationbutton, adminapprovebutton;
		
		//ScheduleInManageAddPackage Variables
		public static String ManagePackagename, ManagePackagecost, ManagePackagediscount, ManagePackagedesc, ManagePackageAddTest, ManagePackageTestname;
		public static String ManagePackageTestdesc, ManagePackageSavePackage, ManagePackageEditlink, ManagePacakgeApproval,  amenitiesbikeparking;
		public static String amenitiescarparking, amenitiescardswipe, amenitieswashroom, amenitiespremiunservice, amenitiesemergencyservices;
		public static String amenitiessave, clcikondiagnosticmanagemenu, ManageSubmitPackageApproval ;
		
		//Schedule Manage Test Variables
		public static String ManageTestTestname, ManageTestTestDesc, ManageTestCost, ManageTestDiscount, ManageTestSave, ManageTestSubmit;
		public static String ManageTestSubmitNotification, ManageTestEditLink;
		
		//Schedule Home PickUp
		public static String HomePickupTestTestname, HomePickupTestTestdesc, HomePickupTestTestcost, HomePickupTestTestdiscount;
		public static String HomePickupTestsEditLink, HomePickupTestSubmit, HomePickupTestSubmitNotification, HomePickupPackName;
		public static String HomepickupPackDesc, HomepickupPackCost,  HomepickupPackDiscount,  HomepickupPacktestname, HomepickupPacktestdesc;
		public static String HomePickupPackClickAddTest, HomePickupPackSubmit, HomePickupPackSubmitNotification, HomePickupPackEditLink;
		
		//Homesample variables
		public static String HomeSampleDistance, HomeSampleSave,  HomeSampleCollectionMenu;
	 public static String adminusername, adminpassword, adminlogin;
		
		
	public static WebDriver Diag_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		
         // Home page elements 
         home_city="search-city";         
         home_area="search-area";
         home_specialization="name";
         map_AreaName="zy-location-right";
         searchIcon="search-icon";
         link_customerlogin="//a[contains(.,'Customer Login')]";
         link_practicelogin="//a[contains(.,'Practice Login')]";
         link_contactus="//a[contains(.,'Contact us')]";
         link_aboutus="//a[contains(.,'About us')]";
         link_diagnostics="//a[contains(.,'Diagnostics')]";
         link_termsconditions="//a[contains(.,'Terms & Conditions')]";
         link_privacypolicy="//a[contains(.,'Privacy Policy')]";
         link_cancellationrefundpolicy="//a[contains(.,'Cancellation & Refund Policy')]";
         button_forandroid="//img[@src='https://d130z5wnxdwqwr.cloudfront.net/images/homePage/app-android.gif']";
         button_forios="//img[@src='https://d130z5wnxdwqwr.cloudfront.net/images/homePage/app-ios.gif']";
         
         
         
       //doctors Login Page Locators         
    	 username="emailAddress";
		 password="password";
		 loginbutton="//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div[1]/button";
		 
		 //Diagnostic Home visit appointment locators	 
		 
		 clickonappointmentsmenu ="appointments";
		 clickontoggle = "//div[@class='material-switch pull-left']";
		 tommorowmenu = "//*[@id='cd-1']";
		 morninghomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[1]/div/div";
		 noonhomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[2]/div/div";
		 eveninghomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[3]/div/div";
		 eveningfirstcell="//*[@id='myTab-3']/ul/li[1]/div[3]";
		 detailsfirstname="apt_fname";
		 detailslastname="apt_lname";
		 detailsmobile="apt_mobile";
		 detailsemail="apt_email";
		 detailsaddress="apt_address";
		 detailsproblem="apt_problem";
		 packagetab="//li[2]//a[@data-toggle='tab']";
		 packagecheckbox="//input[@class='pack_select_checkbox']";
		 windowsavebutton="diagServiceAptms_save";
		 homevisitdashboardsize="//*[@class='sp-diagno-dash-patient-details apt_details']";
		 homevisitimageindashboard="//img[@class='diagno-homvisitimg']";
		 
		//notification locator
		 
		 notification="html/body/div[6]/div";
		 
		//Diagnostics logout locator 
		 clickonmyaccountmenu="account";	
		 clickonsignout="//*[@id='myTabs']/li[6]/a/span[1]/i";
		 confirmsignout="logout";
		 
		 ellipse="//span//i[@class='fa fa-ellipsis-v footer-relipse']";
		 
		 //Reschedule Locators
		 clickonmore="//*[@id='myTab-3']/ul/li[1]/div[2]/a";
		 clickonchange=".//*[@id='zy-spdg-view0']/div/div[4]/div[2]/span[1]/button";
		 nextdaymenu="//*[@id='cd-2']/div[1]";
		 topnotification= "div[class='zy-status-wrapper']";
		 
		 //Cancel Locators
		 
		 clickoncancel="//*[@id='zy-spdg-view0']/div/div[4]/div[2]/span[2]/button";
		 selectbox="cancel_reason_select";
		 submitbutton=".//*[@id='submitCancelApt']/button";
		 
		 //bulk Cancel Locators
		 fromtime="//*[@id='bulk_cancel_fromTime']";
		 totime="//*[@id='bulk_cancel_toTime']";
		 bulksubmitbutton="//*[@id='bulkCancel_submit']";
		 fromcanceldate="//*[@id='bulk_cancel_fromDate']";
		 tocanceldate="//*[@id='bulk_cancel_toDate']";
		 clickonbulkcancelcalendar="//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']";
		 enableddates="//td[@class='day']";
		 
		 //Diagnostic Appointment Creation Locators
		 
		 morningmenu="//*[@id='diag-home-samples']/div[3]/ul/li[1]/div/div";
		 noonmenu="//*[@id='diag-home-samples']/div[3]/ul/li[2]/div/div";
		 eveningmenu="//*[@id='diag-home-samples']/div[3]/ul/li[3]/div/div";
		 
		 //View Diagnostic Locators
		 calltext="//span[@class='zy-sp-diag-m-p-text']";
		 changetext="//span[@class='zy-sp-diag-m-p-chng-btn change_apt']";
		 canceltext="//span[@class='zy-sp-diag-m-p-cancel-btn cancel_appointment']";
		 
		 //Patient Screen Locators
		 
		 clickonpatientmenu="patients";
		 clickonsearchicon="//*[@id='search-bar']";
		 clickonserachbarid="search-bar";
		 todaytabsize="//*[@id='sp-diagno-tab-1']/div";
		 clickonalltab="all";
		 serachtextbox="apt-search";
		 alltabsize="//*[@id='sp-diagno-tab-2']/div";
		 alltabgetfullname="//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[1]";
		 alltabstatus="//*[@id='sp-diagno-tab-2']/div/div/div[2]/div/h1/span[2]/p";
		 todaytabfullname="//*[@id='sp-diagno-tab-1']/div[1]/div/div[2]/div/h1/span[1]/span";
		 todaytabstatus="//p[@class='check_in']";
		 
		 //profile screen locators
		 clickonaccountmenu="account";
		 abouteditbutton="//button[@class='menu_links']";
		 shortname="shortName";
		 profilemobile="mobileNum";
		 language="languagesSpoken";
		 aboutsave="zysaveAboutInfo";
		 profileaddressmenu="//*[@id='myTabs']/li[2]/a";
		 addresseditbutton="man_clinic_addr_edit";
		 addresscountry="addressCountry";
		 addressstate="addressState";
		 addresscity="addressCity";
		 addresssave="zyDiagnostic_addr_save";
		 clickonawardsmenu="//*[@id='myTabs']/li[3]/a";
		 awardseditbutton="zyEditProfileAwards";
		 awardsource="awardSource0";
		 awardyear="awardYear0";
		 saveawards="zySaveAwards";
		 clickonsignoutmenu="//*[@id='myTabs']/li[6]/a/span[2]";
		 confirmlogout="logout";
		 
		//Show More Diagnostic Dashboard locators
		 showmorebutton="html/body/div[6]/div[3]/div[1]/div[5]/button[1]";
		 showlessbutton="html/body/div[6]/div[3]/div[1]/div[5]/button[2]";
		 
		//Dashboard variables
		 clickondashboardmenu="dashBoard";
		 todayhighliteddate="//a[@class='monthly-day monthly-day-event monthly-today']";
		 todaysappointmentslist="//div[@id='sp-diagno-dash-scrolls']/div[1]/div";
		 graphtodayappointmentcount="html/body/div[6]/div[3]/div[2]/div[5]/div[1]/div[1]/div";
		 
		 
		//Checkin locators
		 checkinbutton="//div[@id='checkIn']/span[2]";
		 checkinstartconsultation="startConsultation";
		 packagessavebutton="tab-pkgs-btn";
		 appointmentnotes="appointmentNotes";
		 appointmentnotesavebutton="diag-note-btn";
		 generatebillsbutton="generatReceiptBtn";
		 checkoutbutton="checkoutBtn";
		 
		 //schedule
		 //Diagnostic Center Manage Locators
		 clickonschedulemenu="schedule";
		 clickondiagnosticmanage="cd-12";
		 clickoncontact="//*[@id='tab-hospital']/div[2]/div[1]/ul/li[4]";
		 clickaddclinic="addClinicContact";
		 addname="contactPersonName0";
		 addphone="contactPersonPhone0";
		 addemail="contactPersonEmail0";
		 addfax="contactPersonFax0";
		 clickonsave="editClinicContactDetails";
		 clickondelete="//i[@class='fa fa-minus-circle diagcontact_rem_slot']";
		 clickonpackagemenu="//*[@id='tab-hospital']/div[2]/div[1]/ul/li[3]";
		 clickonaddpackagebutton="addPackage";
		 
		 //Schedule Home Pickup Locators
		 clickonhomevisitaddpackagebutton="addHomeVistPackage";
		 clickonhomevisitpackagesavebutton="homeVisitPackages";
		 clickonhometestaddbutton="addHomeVisitTests";
		 clickhomevisittestsavebutton="saveHomePickTests";
		 clickonhomevisitmenu="//*[@id='cd-13']/div";
		 clickonmanagetestsmenu="//*[@id='tab-hospital']/div[2]/div[1]/ul/li[2]";
		 clickonpackagemenuinhomepickup="//*[@id='tab-home']/div[2]/div[1]/ul/li[2]";
		 
		 //Admin Locators
		 diagnosticapprovalsurl="https://zoyloqa.zoylo.com/admin/zyDiagnosticCenterPackagesAndTestApprovalsList";
		 adminsearchbutton="//input[@type='search']";
		 facilitationbutton="//input[@class='updatedCharges']";
		 adminapprovebutton="//button[contains(., 'Approve')]";
		 
		//ScheduleInManageAddPackage locators
		 ManagePackagename="(//input[starts-with(@id,'packageName')])[last()]";
		 ManagePackagecost="(//input[starts-with(@id,'packageCost')])[last()]";
		 ManagePackagediscount="(//*[@class='sp-diag-dcenter-pack-docard clinicPackages pckgIndex']/div[3]/div[3]/div[2]/input)[last()]";
		 ManagePackagedesc="(//input[starts-with(@id,'packageDescription')])[last()]";
		 ManagePackageAddTest="(//*[@id='addPackageTest'])[last()]";
		 ManagePackageTestname="(//input[starts-with(@id,'packTestName')])[last()]";
		 ManagePackageTestdesc="(//input[starts-with(@id,'packTestDesc')])[last()]";
		 ManagePackageSavePackage="saveClinicPackages";
		 ManagePackageEditlink="(//div[@class='paddingb0 sp-diag-dcenter-edit clinicPackageEdit menu_links'])[last()]";
		 ManagePacakgeApproval="(//*[@class='sp-diag-dcenter-pack-docard clinicPackages pckgIndex']/div[1]/div[1]/div[1]/div/label/span[2])[last()]";
		 amenitiesbikeparking="BIKE_PARKING";
		 amenitiescarparking="CAR_PARKING";
		 amenitiescardswipe="AMBULANCE";
		 amenitieswashroom="PRO_BONO";
		 amenitiespremiunservice="PREMIUM_SERVICE";
		 amenitiesemergencyservices="EMERGENCY_SERVICE";
		 amenitiessave="saveClinicAminities";
		 clcikondiagnosticmanagemenu="//*[@id='cd-12']/div";
		 ManageSubmitPackageApproval="(//div[@class='sp-diag-dcenter-aproveswitch-label'][contains(text(),'Approval is pending')])[last()]";
		 
		 //Managae Tets
		 ManageTestTestname="(//input[starts-with(@id,'testName')])[last()]";
		 ManageTestTestDesc="(//input[starts-with(@id,'testDescription')])[last()]";
		 ManageTestCost="(//input[starts-with(@id,'testCost')])[last()]";
		 ManageTestDiscount="(//input[starts-with(@id,'discountPercentage')])[last()]";
		 ManageTestSave="saveClinicTests";
		 ManageTestSubmit="(//*[@class='sp-diag-dcenter-pack-docard clinicTests testIndex']/div[1]/div/div[1]/div/label/span[2])[last()]";
		 ManageTestSubmitNotification="(//*[@class='sp-diag-dcenter-pack-docard clinicTests testIndex']/div[1]/div/div[2])[last()]";
		 ManageTestEditLink="(//div[@class='paddingb0 sp-diag-dcenter-edit clinicTestEdit menu_links'])[last()]";
		 
		 
		//Schedule Home PickUp
		 HomePickupTestTestname="(//input[starts-with(@id,'homeTestName')])[last()]";
		 HomePickupTestTestdesc="(//input[starts-with(@id,'homeTestDescription')])[last()]";
		 HomePickupTestTestcost="(//input[starts-with(@id,'homeTestCost')])[last()]";
		 HomePickupTestTestdiscount="(//input[starts-with(@id,'homeDiscountPercentage')])[last()]";
		 HomePickupTestsEditLink="(//div[@class='paddingb0 sp-diag-homepick-edit homepickTestEdit menu_links'])[last()]";
		 HomePickupTestSubmit="(//*[@class='sp-diag-homepick-pack-docard homePickTests testIndex']/div[1]/div/div[1]/div/label/span[2])[last()]";
		 HomePickupTestSubmitNotification="(//div[@class='sp-diag-dcenter-testaproveswitch-label'])[last()]";
		 HomePickupPackName="(//input[starts-with(@id, 'homeVisitPacakageName')])[last()]";
		 HomepickupPackDesc="(//input[starts-with(@id, 'homeVisitPacakageDesc')])[last()]";
		 HomepickupPackCost="(//input[starts-with(@id, 'homeVisitPacakageCost')])[last()]";
		 HomepickupPackDiscount="(//input[starts-with(@id, 'homeVisitPacakageDiscount')])[last()]";
		 HomepickupPacktestname="(//input[starts-with(@id, 'homeVisitPackTestName')])[last()]";
		 HomepickupPacktestdesc="(//input[starts-with(@id, 'homeVisitPackTestDesc')])[last()]";
		 HomePickupPackClickAddTest="(//*[@id='addHomeVistPackageTest'])[last()]";
		 HomePickupPackSubmit="(//*[@class='sp-diag-homepick-pack-docard homeVisitPackages pckgIndex']/div[1]/div[1]/div[1]/div/label/span[2])[last()]";
		 HomePickupPackSubmitNotification="(//div[@class='sp-diag-homepick-aproveswitch-label'])[last()]";
		 HomePickupPackEditLink="(//div[@class='sp-diag-homepick-edit homepickupPackageEdit menu_links'])[last()]";
		 //Home Sample Collection menu
		 
		 HomeSampleDistance="homeVisitDistance";
		 HomeSampleSave="diagnosticHomeVisitTimeSlots";
		 HomeSampleCollectionMenu="//*[@id='cd-11']/div";
		 
		 adminusername="emailAddress";
		 adminpassword="password";
		 adminlogin="//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div/button";
		 
		return driver;	
        
       
}

}
