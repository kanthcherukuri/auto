package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;

public class Recipients_ZOY1092_SearchByDoctorSpecializationNClinic extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void launchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);   
		//Test Starts-Here
		Browser.openUrl(loginPage_Url);			
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);


	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Deepak","Cardiology","Clinic Niramoi","sx123sx","Apollo Hospitals","Ent" }

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=1)
	public void mapSearchByDoctors(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital,String Synonym ) throws Exception {

		if(runmode.equals("yes")){

			//Verify search with Doctors name
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String Search_Doctor = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor name is"+Search_Doctor);
			Assert.assertTrue(Search_Doctor.contains(Doctor_Name));

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}

	}

	@AfterMethod(groups = { "Regression","Medium" })
	public void refresh( ) throws Exception {

		driver.navigate().refresh();
		Thread.sleep(5000);	
		Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
		
	}
	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=2)
	public void mapSearchBySpecialization(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital ,String Synonym) throws Exception {

		if(runmode.equals("yes")){
			RecipientPage.searchInZoyloMAP(Specialization);
			String Search_Specialization = driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertTrue(Search_Specialization.contains(Specialization));
			System.out.println("Passed"+Search_Specialization);

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}

	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=3)
	public void validateMapsearchByClinic(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital,String Synonym ) throws Exception {

		if(runmode.equals("yes")){
			//Verify search with clinic name
			RecipientPage.searchInZoyloMAP(Clinic);
			RecipientPage.bookAppointment();
			String Search_Clinic = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']")).getText();
			System.out.println("clicnic name"+Search_Clinic);
			Assert.assertEquals(Search_Clinic, Clinic);
			RecipientPage.goToDoctors();

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}


	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=3)
	public void validateMapsearchByHospital(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital ,String Synonym) throws Exception {

		if(runmode.equals("yes")){
			//Verify search with clinic name
			RecipientPage.searchInZoyloMAP(Hospital);
			RecipientPage.bookAppointment();
			String Search_Hospital = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']")).getText();
			System.out.println("clicnic name"+Search_Hospital);
			Assert.assertEquals(Search_Hospital, Hospital);
			RecipientPage.goToDoctors();

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}

	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=4)
	public void mapSearchByInvalidData(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital,String Synonym ) throws Exception {

		if(runmode.equals("yes")){

			//Verify with Invalid data
			driver.findElement(By.id("search2")).click();
			
			 for(int i=0;i<=invalidData.length()-1; i++)
			    {
			    	char invalidData2 = invalidData.charAt(i);	    	
			    	driver.findElement(By.id("indexSearchTextbox")).sendKeys(Character.toString(invalidData2));
			    	Thread.sleep(500);
			    }
			    Thread.sleep(500);
			   String InvalidSearchMessage=Browser.getTextByXpath("//div[@class='a-s-w']"); 
			    
			   Assert.assertTrue(InvalidSearchMessage.contains("Oops your Search"));
			   Assert.assertTrue(InvalidSearchMessage.contains("did not match any records"));


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}
	
	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=4)
	public void mapSearchBySynonym(String runmode,String Doctor,String Specialization,String Clinic,String invalidData,String Hospital,String Synonym ) throws Exception {

		if(runmode.equals("yes")){

			//Verify search with clinic name
			RecipientPage.searchInZoyloMAP(Synonym);
			String Search_Specialization = driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertTrue(Search_Specialization.contains(Specialization));
			System.out.println("Passed"+Search_Specialization);

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}
	
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 





}