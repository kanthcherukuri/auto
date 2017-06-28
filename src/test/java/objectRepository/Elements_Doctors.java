package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class Elements_Doctors  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	
	
	 public static String driverpath;
	 public static String  enrollment_h5,enrollment_firstname,enrollment_lastname,enrollment_regname ;
	 public static String enrollment_mobile,enrollment_email,enrollment_clinicaddress,enrollment_consultationfee,enrollment_notes,enrollment_doc_fac,enrollment_terms_cond,enrollment_submit;
	 public static String home_city,home_area,home_specialization;
	 public static WebDriver driver;
	 
	 
	 // Doctor login page Locators(xpath,id etc)
	   public static String username;
		public static String password;
		public static String loginbutton;
		
		
		//Doctor Appointment & Reschedule Locators
		
				public static String appointments_doctortab;
				public static String appointment_todaymenu;
				public static String appointment_sundayMenu;
				public static String appointment_tommorrowmenu;
				public static String appointment_morning;
				public static String appointment_noon;
				public static String appointment_eveningtab;
				public static String appointment_eveningfirstcell;
				public static String appointment_firstname;
				public static String appointment_lsatname;
				public static String appointment_mobile;
				public static String appointment_email;
				public static String appointment_problem;
				public static String appointment_save;
				public static String appointment_backgoundcolor;
				public static String appointment_changeicon;
				public static String appointment_nextmenu;
				public static String appointment_morningfirstcell;
				public static String appointment_changeslot;
				public static String topnotification;
				public static String patient_searchbox;
				public static String patientallmenu;
				public static String patientallmenuname, appointment_clickoncancelmenu, appointment_selectcancelreason, appointment_cancelconfirmation, appointment_eveningfirstcellsize;
				
				
				//Patients screen 
				
				public static String patient_id;
				public static String patient_alltab;
				public static String patient_alltabdivsize;
				public static String patient_sendnotficationbutton;
				public static String patient_sendnotification;
				public static String patient_alltabfullname;
				public static String patient_alltabschedule;
				public static String patient_todaytabname;
				public static String patient_todaytabschedule,patient_getfullname,patient_getstatus;
				public static String patient_getAptID;
				
				//Checkin variables
				public static String patient_clickoncheckinbutton;
				public static String patient_clickonstartconsulationbutton;
				public static String patient_diagnosis;
				public static String patient_prognosis;
				public static String patient_saveproblems;
				public static String patient_height;
				public static String patient_heightinches;
				public static String patient_weight;
				public static String patient_savevitals;
				public static String patient_druginstructions;
				public static String patient_strenght;
				public static String patient_medicinetime;
				public static String patient_saveprescription,patient_consultationnotes,patient_savenotes,patient_generatereciept,patient_clickonrecieptdownload,patient_selectreciepttodownload;
				public static String patient_clickonprescription, patient_selectprescription, patient_selectemailno, patient_clickoncheckoutbutton, patient_clickonfollowupbutton;
				public static String patient_savefollowupappointment;
				
				//Dashboard variables
				
				public static String dashboard_clickondashboardmenu, dashboard_selecttodaysdate, dashboard_fullname, dashboard_checktodayappointmentssize, dashboard_waitfortodaydate;
				public static String dashboard_checktodayappointmentcountfromgraph, clickonellipse, dashboard_waitfornextpage, dashboard_getnameforpage, dashboard_clickonnextmonth, 
				dashboard_clickondateone,dashboard_ClickOnRecepientName, dashboard_ClickonBack, dashboard_AppointmentLisitingSize;
				
				//show more variables
				public static String dashboard_showmorebutton, dashboard_showlessbutton;
				
				//appointments listing
				public static String dashboard_getappointlistingtext,  dashboard_getappointmentlistingsize;
				
				//bulk cancel variables
				public static String bulkcancel_clickonbulkcancelbutton, bulkcancel_fromdate, bulkcancel_todate, bulkcancel_fromtime, bulkcancel_totime, bulkcancel_submit;
				
				//Alert variables
				public static String appointment_clickonview, appointment_getfullnameonclickviewmenu, alert_clickonalertmenu, appointment_getappointmentid;
				
				//set vacation
				public static String closevacationArray, setVacation, addVacationSlot, vacationStart, vacationEnd, vacationActive, vacationSave, removeVacationSlot;
				
				//Break timings
				public static String sunToggle, sunStrtTime, sunEndTime;
				
		//submit schedule
				public static String submitSchedule;
				public static String schedule;
				
		//Clinic tab
				public static String clinicTab, clinicName, clinicTimeSlotMinusBtn, sundayTab, AddWorkTime, sundayToggle, WstrtTime, WendTime, clinicSubmitTimeSlots;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
	 //Clinic Address
	 public static String addressTab;
	 public static String addressEditButton;
	 public static String addLineOne;
	 public static String locality;
	 public static String pincode;
	 public static String addSave;

	 
	 //Hospital Tab
	 
	 public static String Schedule_Hospital_ClickOnHospitalTab, Schedule_Hospital_ClickAddWorkTimingsButton, Schedule_Hospital_ClickOnToggle, Schedule_Hospital_Starttime , Schedule_Hospital_EndTime;
	 public static String Schedule_Hospital_SaveWorkTimings, Schedule_Hospital_DeleteWorkTimings, Schedule_Hospital_SundayMenu;

	 public static String aminitiesTab;
	 public static String aminitiesAmbulance;
	 public static String aminitiesSave;
	 public static String servicesTab;
	 public static String addServices;
	 public static String servicesText;
	 public static String serviceSave;
	 public static String removeService;

	 
	 //Add clinic
	 public static String clickPlusMore;
	 public static String addClinic;
	 public static String popUpHeading;
	 public static String otherclinicName;
	 public static String otherClinicFee;
	 public static String otherClinicMobile;
	 public static String addlineone;
	 public static String otherPincode;
	 public static String otherLon;
	 public static String otherLat;
	 public static String otherClinicSave;
		
	public static  WebDriver Doc_PageProperties()throws Exception{
		
		//Schedule Hospital Tab
		patient_getAptID="(//div[@class='zy-rec-tab-cell zy-rec-dtls'])[1]"; //XPATH
		Schedule_Hospital_ClickOnHospitalTab="//*[@id='cd-12']";
		Schedule_Hospital_ClickAddWorkTimingsButton="//i[@class='fa fa-plus-circle slot_hospital_add']";
		Schedule_Hospital_ClickOnToggle="//span[@class='sp-doc-clinic-workday-switch-switch']";
		Schedule_Hospital_Starttime="//input[@class='slot-start-hos']";
		Schedule_Hospital_EndTime="//input[@class='slot-end-hos']";
		Schedule_Hospital_SaveWorkTimings="//span[@class='sp-doc-hosp-schd-save']";
		Schedule_Hospital_DeleteWorkTimings="(//*[@id='0'])[2]";
		Schedule_Hospital_SundayMenu="cd-26";
	 
		//Add clinic
		clickPlusMore="profile-flip";
		addClinic="//span[contains(., 'Add Clinic')]";
		popUpHeading="myModalLabel";
		otherclinicName="aoc_clinicname";
		otherClinicFee="aoc_consfee";
		otherClinicMobile="aoc_mobnum";
		addlineone="aoc_addr1";
		otherPincode="aoc_pincode";
		otherLon="aoc_lng";
		otherLat="aoc_lat";
		otherClinicSave="aoc_clinic_addr_save";
		
		
		//Clinic Address
		addressTab="(//li[contains(., 'Address')])[1]";
		aminitiesTab="(//li[contains(., 'Amenities')])[1]";
		addressEditButton="man_clinic_addr_edit";
		addLineOne="clinic_addr1";
		locality="clinic_locality";
		pincode="clinic_pincode";
		addSave="clinic_addr_save";
		aminitiesSave="clinic_aminities_save";
		aminitiesAmbulance="ambulance";
		servicesTab="(//li[contains(., 'Services')])[1]";
		addServices="clinic_add_service";
		servicesText="//textarea[@class='serviceName']";
		serviceSave="clinic_service_save";
		removeService="sr0";
		
		//clinic tab
		clinicTab="(//div[contains(., 'Clinics')])[4]";
		clinicName="editClinicName";
		clinicTimeSlotMinusBtn="//i[@class='fa fa-minus-circle clinc_rem_slot']";
		sundayTab="cd-6";
		AddWorkTime="clinic_add_slot";
		sundayToggle="//label[@class='sp-doc-clinic-workday-switch-label']";
		WstrtTime="//input[@class='slot-start']";
		WendTime="//input[@class='slot-end']";
		clinicSubmitTimeSlots="(//span[@class='sp-doc-clinic-schd-save'])[2]";
		
		
		//submit schedule
		submitSchedule="//div[@class='sp-doc-clinic-schd-save-btn menu_links']";
		schedule="schedule";
		
	//Set Vacation
	setVacation="setVacation";
	//closevacationArray="(.//*[@id='0'])[1]";
	addVacationSlot="addVacationSlots";
	vacationStart="(//input[@class='datepicker'])[1]";
	vacationEnd="(//input[@class='datepicker'])[2]";
	vacationActive="vac_status0";
	vacationSave="vacation_save";
	removeVacationSlot="//i[@class='fa fa-minus-circle removeVacationSlots']";
	
	//Break Timings
	sunToggle="(//label[@class='sp-doc-conc-work-hours-switch-label'])[7]";
	sunStrtTime="sun_start_time";
	sunEndTime="sun_end_time";
		
		/*
		 * @Recent Changes 	: @Authur: Sagar Sen
		 * @Changes Made 	: changed xpath of enrollment_submit
		 */
         // Enrollment page elements 
         enrollment_h5="//h5";         
         enrollment_firstname="fname";
         enrollment_lastname="lname";
         enrollment_regname="zws_reg_no";
         enrollment_mobile="zws_mobile";
         enrollment_email="zws_email";
         enrollment_clinicaddress="clinicAddress";
         enrollment_consultationfee="consultationFee";
         enrollment_notes="zws_notes";
         enrollment_doc_fac="zws_doc_fac";
         enrollment_terms_cond="zws_doc_termsCond";
         enrollment_submit="//button[contains(., 'Submit')]";
                  
         //doctors Login Page Locators         
    	 username="emailAddress";
		 password="password";
		 loginbutton="//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div[1]/button";
		 
		 
			//Doctor Appointment & Reschedule Locators
			 
			 appointments_doctortab="appointment_appointmentCalendar";
			 appointment_todaymenu="//*[@id='cd-0']";
			 appointment_sundayMenu="(//li[@class='calendarDateli' and contains(., 'Sunday')])[1]";
			 appointment_tommorrowmenu="//*[@id='cd-1']";
			 appointment_morning="//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]";
			 appointment_noon="//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]";
			 appointment_eveningtab="//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]";
			 appointment_eveningfirstcell="//div[@id='tab-3']/ul/li[1]/div[2]";
			 appointment_eveningfirstcellsize="//*[@id='tab-3']/ul/li";
			 appointment_firstname="//*[@id='firstName']";
			 appointment_lsatname="lastName";
			 appointment_mobile="mobileNumber";
			 appointment_email="email";
			 appointment_problem="problem";
			 appointment_save="saveAppiontment";
			 appointment_backgoundcolor="//*[@id='tab-3']/ul/li[1][@class='bg-red']";
			 appointment_changeicon="//*[@id='change']";
			 appointment_nextmenu="//*[@id='cd-2']";
			 appointment_morningfirstcell="//*[@id='tab-1']/ul/li[1]";
			 appointment_changeslot="//*[@id='confrimSlotChange']";
			 topnotification="html/body/div[6]/div";
			 patient_searchbox="searchPatientsList";
			 patientallmenu=" html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 patientallmenuname="all";
			 appointment_clickoncancelmenu="cancel";
			 appointment_cancelconfirmation="confirmYes";
			 appointment_selectcancelreason="//*[@id='cancel-appointment-popup']/div/div/div[3]/select";
			 
			 //Patient screen send notification
		 
			 patient_id="patients";
			 patient_alltab="html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 patient_alltabdivsize="//*[@id='all']/div";
			 patient_sendnotficationbutton="//button[text()='Send Notification']";
			patient_sendnotification="//*[@id='resendNotification']/button";
			patient_alltabfullname="//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span";
			patient_alltabschedule="//*[@id='all']/div[1]/div[2]/p[1]";
			patient_todaytabname="//*[@id='today']/div/div[1]/div[2]/div/h1/span";
			patient_todaytabschedule="//*[@id='today']/div/div[2]/p[1]";
			patient_getfullname="//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span";
			patient_getstatus="//*[@id='all']/div[1]/div[2]/p[1]";
			
			
			//Checkin locators
			patient_clickoncheckinbutton="checkIn";
			patient_clickonstartconsulationbutton="startConsultation";
			 patient_diagnosis="diagnosis";
			 patient_prognosis="prognosis";
			 patient_saveproblems="saveProblems";
			 patient_height="heightFeet";
			 patient_heightinches="heightInches";
			 patient_weight="weight";
			 patient_savevitals="saveVitals";
			 patient_druginstructions="drugAndInstructions";
			 patient_strenght="strength";
			 patient_medicinetime="//*[@id='tab-pres']/div[1]/div[2]/div[3]/div[2]/span/input";
			 patient_saveprescription="savePrescription";
			 patient_consultationnotes="consultationNotes";
			 patient_savenotes="saveNotes";
			 patient_generatereciept="generateReceipt";
			 patient_clickonrecieptdownload="html/body/div[7]/div[3]/div/div[2]/div[2]/div[1]/button";
			 patient_selectreciepttodownload="//*[@id='presDownload']";
			 patient_clickonprescription="html/body/div[7]/div[3]/div/div[2]/div[2]/div[2]/button";
			 patient_selectprescription="//*[@id='prescriptionPdfShare']";
			 patient_selectemailno="//*[@id='sp-patient-sharepopup']/div/div/div/div/div/span[1]";
			 patient_clickoncheckoutbutton="checkOut";
			 patient_clickonfollowupbutton="//button[contains(text(),'Follow Up')]";
			 patient_savefollowupappointment="saveFollowUpAppiontment";
			 
			 
			 //Dashboard variables
			 dashboard_clickondashboardmenu="dashBoard";
			 dashboard_selecttodaysdate="//a[@class='monthly-day monthly-day-event monthly-today']";
			 dashboard_fullname="//*[@id='scrolls']/div/div[1]/div[2]/span";
			 dashboard_checktodayappointmentssize="//*[@id='scrolls']/div/div";
			 dashboard_checktodayappointmentcountfromgraph="//*[@id='sp-dashboard-content']/div[2]/div[5]/div[1]/div[1]/div";
			 clickonellipse="//i[@class='fa fa-ellipsis-v footer-relipse']";
			 dashboard_waitfornextpage="html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span";
			 dashboard_getnameforpage="//div[@class='zy-rec-content']/div[@class='rec-content']/h1[@class='zy-rec-name']/span";
			 dashboard_clickonnextmonth="//*[@id='mycalendar']/div[1]/a[2]";
			 dashboard_clickondateone="(//a[@class='monthly-day monthly-day-event']/div)[1]";
			 dashboard_waitfortodaydate="//a[@class='monthly-day monthly-day-event monthly-today']";
			 dashboard_ClickOnRecepientName="//*[@id='scrolls']/div/div[3]/div[2]/span";
			 dashboard_ClickonBack="backbtn";
			 dashboard_AppointmentLisitingSize="//*[@id='scrolls']/div/div";
			 
			 
			 //show more variables
			 dashboard_showmorebutton="show-all-btn";
			 dashboard_showlessbutton="show-less-btn";
			 
			 //appointment listing
			 dashboard_getappointlistingtext="//div[@class='label-font']";
			 dashboard_getappointmentlistingsize="//div[@class='force-overflow']//div[@class='patient-details-dashboard']";
			 
			 //bulk cancel locators
			 bulkcancel_clickonbulkcancelbutton="//div//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']";
			 bulkcancel_fromdate="//*[@id='datepicker-cancelfrom']";
			 bulkcancel_todate="//*[@id='datepicker-cancelto']";
			 bulkcancel_fromtime="//*[@id='fromTime']";
			 bulkcancel_totime="//*[@id='toTime']";
			 bulkcancel_submit="cancelAppointmentsSubmit";
			 
			 //Alert Variables
			 
			 appointment_clickonview ="view";
			 appointment_getfullnameonclickviewmenu="html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span";
			 appointment_getappointmentid="html/body/div[7]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/span";
			 alert_clickonalertmenu="alerts";
			
			
		return driver;	
        
       
}
	

	

	
	
	
	
	
	
	
}
