package doctorsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;





import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
*/
import testBase.*;
import objectRepository.*;

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

*/
public class Appointment_JiraID_ValidateDoctorEnrollment extends LoadPropMac {
	 public HomePage HomePageOfZoylo;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Doctors.Doc_PageProperties(); // loading UI Page Elements / Locators
		  HomePageOfZoylo= new HomePage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData/Data.xls","Doctor", "TC2");
	        return(retObjArr);
	    }
	 
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateDoctorEnrollment(String runmode,String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes,String expected) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl(enrollment_url);			
			 HomePageOfZoylo.doctorsEnrollment( Area,  FirstName, LastName, Gender, Qualification, Email,  Address, Fee, Notes);
			 Thread.sleep(5000);
			 String SuccessfulText=driver.findElement(Elements_Doctors.enrollment1_h5).getText();
			 System.out.println("SuccessfulText="+SuccessfulText);
			//Comparing Actual VS Expected
			 AssertJUnit.assertTrue(SuccessfulText.contains(expected));	
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}