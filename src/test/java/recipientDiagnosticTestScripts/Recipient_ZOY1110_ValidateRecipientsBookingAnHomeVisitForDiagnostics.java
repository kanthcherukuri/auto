package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;

import org.openqa.selenium.*;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;

public class Recipient_ZOY1110_ValidateRecipientsBookingAnHomeVisitForDiagnostics extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	
	public HomePage HomePage;




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		HomePage = new HomePage(driver);
		Browser= new TestUtils(driver);        

	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Hyderabad","Sugar Test","Zoylo Health pkg", }

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsBookingAnHomeVisitForDoctor(String runmode,String City,String Tests, String Pkg ) throws Exception {

		if(runmode.equals("yes")){



			//Test Starts-Here
			Browser.openUrl(loginPage_Url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
			RecipientPage.goToDiagnostics();
			RecipientPage.searchInZoyloMAPArea(City);
			RecipientPage.clickOnFilterImg();
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilterInDiagnostics("Home PickUp","homeVisit","doesHomeVisit","");
	        Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			RecipientPage.searchInZoylodetailMAP(Diagnostic_Name);
			//Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			String DiagnosticsName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor is"+DiagnosticsName);
			RecipientPage.bookAppointmentOnDiagnostics();
			
			
			Browser.waitFortheElementXpath(Elements_Recipients.dcNameHolder);
			driver.findElement(By.id(Elements_Recipients.dcHomePickUp)).click();
			Browser.waitFortheElementXpath("//div[@class='zy-rec-diag-hm-add-title']"); //Address heading
			driver.findElement(By.xpath(Elements_Recipients.recipient_firstHomeAddress)).click();
			driver.findElement(By.xpath(Elements_Recipients.dcHomeVisitAddressProceed)).click();
			Browser.waitFortheElementXpath("(.//*[@id='tests_search'])[2]"); //search bar xpath
			RecipientPage.selectDChomeVisitSlots();
			RecipientPage.confirmAppointmentOnDiagnostics();
			RecipientPage.makePaymentforDC();
			Browser.waitFortheElementXpath("//h5[contains(., 'Thank you for booking appointment at Diagnosticszoylo through Zoylo')]");
			System.out.println("Home visit appointment is successfully booked");
		
		


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {
		driver.quit();
	}





}