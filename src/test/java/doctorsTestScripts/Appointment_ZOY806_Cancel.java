package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointment_ZOY806_Cancel extends LoadProp  {

	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 
	 public void beforeClass() throws Exception {
	
		 LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		  }
	 
	 @Test(groups = { "Regression","High" })	
	 public  void SignIntoDoctorLogin() throws Exception {
	
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_username, DoctorsLogin_password);
				
		  }
	 
	 
	 
	 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\DoctorAppointment1.xls", "doc", "TC1");
	        return(retObjArr);
	    }



@Test(dataProvider="DP1", priority=2,groups = { "Regression","High" })

public void doctorappointment(String RunMode,String timeslot,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	DoctorsPageOfZoylo.Cancel(firstname, lastname, mobile, email, problem);
	
	
}









}
