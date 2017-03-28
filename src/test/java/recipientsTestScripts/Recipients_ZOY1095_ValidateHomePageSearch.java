package recipientsTestScripts;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;




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


public class Recipients_ZOY1095_ValidateHomePageSearch extends LoadProp {
	 public HomePage HomePage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Home.Home_PageProperties();// loading UI Page Elements / Locators
		  
		  HomePage = new HomePage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
	
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1095");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateHomePageSearch(String runmode ,String City, String Locality,String Specialization,String Expected) throws Exception {
		  
		 if(runmode.equals("yes")){
			 
			 
			 //Test Starts - Here
			 Browser.openUrl(base_url);
			 HomePage.searchZoylo(City, Locality, Specialization);
			 Browser.waitFortheID(Elements_Home.map_AreaName);
			 String ActualResult = driver.findElement(By.id(Elements_Home.map_AreaName)).getText();
			 //Comparing Actual VS Expected
			 Assert.assertEquals(ActualResult, Expected);
		
			
		
			
			
		 }else{
			 System.out.println("RUNMODE IS OFF");
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}