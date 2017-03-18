package sanityTestScipts;



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
public class Home_JiraID_ValidateSearchZoyloInHomePage extends LoadProp {
	 public HomePage HomePageOfZoylo;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Sanity" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  //Elements_Doctors.Doc_PageProperties(); // load your page locators
		  Elements_Home.Home_PageProperties(); 
		  HomePageOfZoylo= new HomePage(driver);
		  Browser= new TestUtils(driver);
		  	 
 } 
	 
	 /*   @Autur : Ganesh Mandala
	  *   Entering the test details in Doctor enrollment Page and submitting the page
	  */
 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Data.xls","Doctor", "TC1");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups="Sanity")
	 public void ValidateDoctorEnrollment(String runmode ,String City, String Locality,String Specialization,String Expected) throws Exception {
	  
		 if(runmode.equals("yes")){
			//Test Starts - Here
			 Browser.openUrl(base_url);
			 HomePageOfZoylo.searchZoylo(City, Locality, Specialization);
			 Browser.waitFortheID(Elements_Home.map_AreaName);
			 String ActualResult = driver.findElement(By.id(Elements_Home.map_AreaName)).getText();
			 //Comparing Actual VS Expected
			 Assert.assertEquals(ActualResult, Expected);
			//ScreenShot
			 Browser.capturescreenshot(Expected);	
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Sanity" })	
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}