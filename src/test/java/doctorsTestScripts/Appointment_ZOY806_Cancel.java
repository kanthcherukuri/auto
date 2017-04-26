package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY806_Cancel extends LoadPropMac  {

	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 
	 public void beforeClass() throws Exception {
	
		 LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		  }
	 
	 @Test(groups = { "Regression","High" },priority=1)	
	 public  void SignIntoDoctorLogin() throws Exception {
	
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
				
		  }
	 
	 
	 
	 
	 @DataProvider(name = "DP1")
	   // public Object[][] createData_DP1() throws Exception{
	  //Object[][] retObjArr=TestUtils.getTableArray("TestData\\DoctorAppointment1.xls", "doc", "TC1");
	    //    return(retObjArr);
	    //}
	 
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","korea","K","9499229191","korea@gmail.com","Diabetic" }

			};
		}



@Test(dataProvider="DP1", priority=2,groups = { "Regression","High" })

public void doctorappointment(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{

	if(RunMode.equals("yes")){
		
	DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
	Thread.sleep(3000);
	DoctorsPageOfZoylo.Cancel(firstname, lastname, mobile, email, problem);
	Thread.sleep(3000);
	DoctorsPageOfZoylo.CheckCancelAppointmentInPatientScreen(firstname, lastname, email);
	}
	 else{
		 
			throw new SkipException("RUNMODE IS OFF");
		 }
	
		}


@Test(priority=3)

public void CancelAllAppointments() throws Exception{
	DoctorsPageOfZoylo.BulkCancel();
	Thread.sleep(2000);
	DoctorsPageOfZoylo.doctorlogout();
	
}


@AfterClass
public void closebrowser(){
	driver.close();
}



}
