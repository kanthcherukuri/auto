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

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

*/
public class Recipients_ZOY1092_SearchByDoctorSpecializationNClinic extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		  //Test Starts-Here
		  Browser.openUrl(recipient_url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		  Thread.sleep(2000);
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1092");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=1)
	 public void mapSearchByDoctors(String runmode,String Doctor,String Specialization,String Clinic,String invalidData ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			//Searching Locality/Area
			RecipientPage.searchInZoyloMAPArea("Hyderabad");
			//Verify search with Doctors name
			RecipientPage.searchInZoyloMAP(Doctor);
			String Search_Doctor = driver.findElement(By.xpath("//h1")).getText();
	        Assert.assertTrue(Search_Doctor.contains(Doctor));
	        RecipientPage.goToDoctors();
	   	   
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
	 }
		 @Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=2)
		 public void searchMapBySpecialization(String runmode,String Doctor,String Specialization,String Clinic,String invalidData ) throws Exception {
		  
			 if(runmode.equals("yes")){

		   	    //Verify search with Specialization name
				RecipientPage.searchInZoyloMAP(Specialization);
				String Search_Specialization = driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
		        Assert.assertTrue(Search_Specialization.contains(Specialization));
		        System.out.println("Passed"+Search_Specialization);
		        RecipientPage.goToDoctors();
		       
				 
			 }else{
				 
				throw new SkipException("RUNMODE IS OFF");
				
			 }	
	    }
    
		 @Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=3)
		 public void searchMapByClinic(String runmode,String Doctor,String Specialization,String Clinic,String invalidData ) throws Exception {
		  
			 if(runmode.equals("yes")){

				 //Verify search with clinic name
			        driver.navigate().refresh();
					RecipientPage.searchInZoyloMAP(Clinic);
					RecipientPage.bookAppointment();
					String Search_Clinic = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']")).getText();
					System.out.println("clicnic name"+Search_Clinic);
			        Assert.assertEquals(Search_Clinic, Clinic);
				 
			 }else{
				 
				throw new SkipException("RUNMODE IS OFF");
				
			 }	
	    }
    
		 @Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=4)
		 public void searchMapByInvalidData(String runmode,String Doctor,String Specialization,String Clinic,String invalidData ) throws Exception {
		  
			 if(runmode.equals("yes")){

				  //Verify with Invalid data
			        RecipientPage.goToDoctors();
			        driver.findElement(By.id("search2")).click();
			    	driver.findElement(By.id("indexSearchTextbox")).sendKeys(invalidData);
			    	Thread.sleep(5000);
			    	String OppsContent = driver.findElement(By.cssSelector("div.a-s-w > span")).getText();
			    	Assert.assertEquals(OppsContent, "Oops! your search for "+invalidData+" did not match any records");
			        
				 
			 }else{
				 
				throw new SkipException("RUNMODE IS OFF");
				
			 }	
	    }
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}