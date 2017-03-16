package doctorsTestScripts;

import java.io.File;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import objectRepository.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
public class Appointment_JiraID_ValidateDoctorEnrollment extends LoadProp {
	 public HomePage HomePageOfZoylo;
	 public TestUtils baseActions;	

	
	
		
	 @BeforeClass
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties();
		  Elements_Doctors.Doc_PageProperties();
		  HomePageOfZoylo= new HomePage(driver);
		  baseActions= new TestUtils(driver);
		  
		  
		  
		  
		 
		 
 } /*   @Autur : Ganesh Mandala
	  *   Entering the test details in Doctor enrollment Page and submitting the page
	  */

	 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Data.xls","Doctor", "TC2");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1")
	 public void ValidateDoctorEnrollment(String runmode,String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes,String expected) throws Exception {
	  
		 if(runmode.equals("yes")){
			 
		
		
			 
			 
			 //Test Starts -Here
			 baseActions.openUrl("https://zoyloqa.zoylo.com/doctorenrollmentform");
			 HomePageOfZoylo.doctorsEnrollment( Area,  FirstName, LastName, Gender, Qualification, Email,  Address, Fee, Notes);
			 Thread.sleep(5000);
			 String SuccessfulText=driver.findElement(By.xpath(Elements_Doctors.enrollment_h5)).getText();
			 System.out.println("SuccessfulText="+SuccessfulText);
			//Comparing Actual VS Expected
			 Assert.assertTrue(SuccessfulText.contains(expected));	
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}