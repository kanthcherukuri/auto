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
		
				public static String doctortab;
				public static String todaymenu;
				public static String sundayMenu;
				public static String tommorrowmenu;
				public static String morning;
				public static String noon;
				public static String evening;
				public static String eveningfirstcell;
				public static String locatorfirstname;
				public static String locatorlsatname;
				public static String locatormobile;
				public static String locatoremail;
				public static String locatorproblem;
				public static String locatorsave;
				public static String backgoundcolor;
				public static String changeicon;
				public static String nextmenu;
				public static String morningfirstcell;
				public static String changeslot;
				public static String topnotification;
				public static String patienticon;
				public static String patientsearchbox;
				public static String patientallmenu;
				public static String patientallmenuname, clickoncancelmenu, selectcancelreason, cancelconfirmation, eveningfirstcellsize;
				
				
				//Patients screen 
				
				public static String patienticonid;
				public static String alltab;
				public static String alltabdivsize;
				public static String sendnotficationbutton;
				public static String sendnotification;
				public static String alltabname;
				public static String alltabschedule;
				public static String todaytabname;
				public static String todaytabschedule, patientgetfullname,patientgetstatus;
				
				//Checkin variables
				public static String clickoncheckinbutton;
				public static String clickonstartconsulationbutton;
				public static String diagnosis;
				public static String prognosis;
				public static String saveproblems;
				public static String height;
				public static String heightinches;
				public static String weight;
				public static String savevitals;
				public static String druginstructions;
				public static String strenght;
				public static String medicinetime;
				public static String saveprescription,consultationnotes,savenotes,generatereciept,clickonrecieptdownload,selectreciepttodownload;
				public static String clickonprescription, selectprescription, selectemailno, clickoncheckoutbutton, clickonfollowupbutton;
				public static String savefollowupappointment;
				
				//Dashboard variables
				
				public static String clickondashboardmenu, selecttodaysdate, dashboardfullname, checktodayappointmentssize;
				public static String checktodayappointmentcountfromgraph, clickonellipse;
				
				//show more variables
				public static String showmorebutton, showlessbutton;
				
				//appointments listing
				public static String getappointlistingtext,  getappointmentlistingsize;
				
				//bulk cancel variables
				public static String clickonbulkcancelbutton, cancelfromdate, canceltodate, cancelfromtime, canceltotime, submitbulkcancel;
				
				//Alert variables
				public static String clickonview, getfullnameonclickviewmenu, clickonalertmenu, getappointmentid;
				
				//set vacation
				public static String setVacation, addVacationSlot, vacationStart, vacationEnd, vacationActive, vacationSave, removeVacationSlot;
				
				//Break timings
				public static String sunToggle, sunStrtTime, sunEndTime;
				
		//submit schedule
				public static String submitSchedule;
				public static String schedule;
				
		//Clinic tab
				public static String clinicTab, clinicName, sundayTab, AddWorkTime, sundayToggle, WstrtTime, WendTime, clinicSubmitTimeSlots;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
	 //Clinic Address
	 public static String addressTab;
	 public static String addressEditButton;
	 public static String addLineOne;
	 public static String locality;
	 public static String pincode;
	 public static String addSave;

	 
	 //Hospital Tab
	 
	 public static String ClickOnHospitalTab, HospitalClickAddWorkTimingsButton, HospitalClickOnToggle, HospitalStarttime , HospitalEndTime;
	 public static String HospitalSaveWorkTimings, HospitalDeleteWorkTimings, HospitalsSundayMenu;

	 public static String aminitiesTab;
	 public static String aminitiesAmbulance;
	 public static String aminitiesSave;
	 public static String servicesTab;
	 public static String addServices;
	 public static String servicesText;
	 public static String serviceSave;
	 public static String removeService;

		
	public static  WebDriver Doc_PageProperties()throws Exception{
		
		//Schedule Hospital Tab
		
		ClickOnHospitalTab="//*[@id='cd-12']";
		HospitalClickAddWorkTimingsButton="//i[@class='fa fa-plus-circle slot_hospital_add']";
		HospitalClickOnToggle="//span[@class='sp-doc-clinic-workday-switch-switch']";
		HospitalStarttime="//input[@class='slot-start-hos']";
		HospitalEndTime="//input[@class='slot-end-hos']";
		HospitalSaveWorkTimings="//span[@class='sp-doc-hosp-schd-save']";
		HospitalDeleteWorkTimings="(//*[@id='0'])[2]";
		HospitalsSundayMenu="cd-26";
	 
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
			 
			 doctortab="appointment_appointmentCalendar";
			 todaymenu="//*[@id='cd-0']";
			 sundayMenu="(//li[@class='calendarDateli' and contains(., 'Sunday')])[1]";
			 tommorrowmenu="//*[@id='cd-1']";
			 morning="//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]";
			 noon="//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]";
			 evening="//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]";
			 eveningfirstcell="//div[@id='tab-3']/ul/li[1]/div[2]";
			 eveningfirstcellsize="//*[@id='tab-3']/ul/li";
			 locatorfirstname="//*[@id='firstName']";
			 locatorlsatname="lastName";
			 locatormobile="mobileNumber";
			 locatoremail="email";
			 locatorproblem="problem";
			 locatorsave="saveAppiontment";
			 backgoundcolor="//*[@id='tab-3']/ul/li[1][@class='bg-red']";
			 changeicon="//*[@id='change']";
			 nextmenu="//*[@id='cd-2']";
			 morningfirstcell="//*[@id='tab-1']/ul/li[1]";
			 changeslot="//*[@id='confrimSlotChange']";
			 topnotification="html/body/div[6]/div";
			 patienticon="patients_patientsIcon";
			 patientsearchbox="searchPatientsList";
			 patientallmenu=" html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 patientallmenuname="all";
			 clickoncancelmenu="cancel";
			 cancelconfirmation="confirmYes";
			 selectcancelreason="//*[@id='cancel-appointment-popup']/div/div/div[3]/select";
			 
			 //Patient screen send notification
		 
			 patienticonid="patients";
			 alltab="html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 alltabdivsize="//*[@id='all']/div";
			 sendnotficationbutton="//button[text()='Send Notification']";
			sendnotification="//*[@id='resendNotification']/button";
			alltabname="//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span";
			alltabschedule="//*[@id='all']/div[1]/div[2]/p[1]";
			todaytabname="//*[@id='today']/div/div[1]/div[2]/div/h1/span";
			todaytabschedule="//*[@id='today']/div/div[2]/p[1]";
			patientgetfullname="//*[@id='all']/div[1]/div[1]/div[2]/div/h1/span";
			patientgetstatus="//*[@id='all']/div[1]/div[2]/p[1]";
			
			
			//Checkin locators
			clickoncheckinbutton="checkIn";
			clickonstartconsulationbutton="startConsultation";
			 diagnosis="diagnosis";
			 prognosis="prognosis";
			 saveproblems="saveProblems";
			 height="heightFeet";
			 heightinches="heightInches";
			 weight="weight";
			 savevitals="saveVitals";
			 druginstructions="drugAndInstructions";
			 strenght="strength";
			 medicinetime="//*[@id='tab-pres']/div[1]/div[2]/div[3]/div[2]/span/input";
			 saveprescription="savePrescription";
			 consultationnotes="consultationNotes";
			 savenotes="saveNotes";
			 generatereciept="generateReceipt";
			 clickonrecieptdownload="html/body/div[7]/div[3]/div/div[2]/div[2]/div[1]/button";
			 selectreciepttodownload="//*[@id='presDownload']";
			 clickonprescription="html/body/div[7]/div[3]/div/div[2]/div[2]/div[2]/button";
			 selectprescription="//*[@id='prescriptionPdfShare']";
			 selectemailno="//*[@id='sp-patient-sharepopup']/div/div/div/div/div/span[1]";
			 clickoncheckoutbutton="checkOut";
			 clickonfollowupbutton="//button[contains(text(),'Follow Up')]";
			 savefollowupappointment="saveFollowUpAppiontment";
			 
			 
			 //Dashboard variables
			 clickondashboardmenu="dashBoard";
			 selecttodaysdate="//a[@class='monthly-day monthly-day-event monthly-today']";
			 dashboardfullname="//*[@id='scrolls']/div/div[1]/div[2]/span";
			 checktodayappointmentssize="//*[@id='scrolls']/div/div";
			 checktodayappointmentcountfromgraph="//*[@id='sp-dashboard-content']/div[2]/div[5]/div[1]/div[1]/div";
			 clickonellipse="html/body/div[9]/div/div[2]/div[3]/span/i";
			 
			 //show more variables
			 showmorebutton="show-all-btn";
			 showlessbutton="show-less-btn";
			 
			 //appointment listing
			 getappointlistingtext="//div[@class='label-font']";
			 getappointmentlistingsize="//div[@class='force-overflow']//div[@class='patient-details-dashboard']";
			 
			 //bulk cancel locators
			 clickonbulkcancelbutton="//div//i[@class='pa-cancl-apt fa fa-calendar-times-o cancel-apmpt-btn menu_links']";
			 cancelfromdate="//*[@id='datepicker-cancelfrom']";
			 canceltodate="//*[@id='datepicker-cancelto']";
			 cancelfromtime="//*[@id='fromTime']";
			 canceltotime="//*[@id='toTime']";
			 submitbulkcancel="cancelAppointmentsSubmit";
			 
			 //Alert Variables
			 
			 clickonview ="view";
			 getfullnameonclickviewmenu="html/body/div[7]/div[3]/div/div[1]/div[2]/div/h1/span";
			 getappointmentid="html/body/div[7]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/span";
			 clickonalertmenu="alerts";
			
			
		return driver;	
        
       
}
	

	

	
	
	
	
	
	
	
}
