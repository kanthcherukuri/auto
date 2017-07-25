package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

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


public class Recipients_ZOY1095_ValidateHomePageSearch extends LoadPropMac {
	public HomePage HomePage;
	public TestUtils Browser;	
	public RecipientPage RecipientPage;



	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Home.Home_PageProperties();// loading UI Page Elements / Locators
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		HomePage = new HomePage(driver); // Loading Pages
		Browser= new TestUtils(driver);   


	} 
	@BeforeMethod(groups = { "Regression","High" })
	public void HomePage() throws Exception {
		Browser.openUrl(base_url);

	}

	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Hyderabad","","","Hyderabad" },

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void HomePageDiagnosticsSearch(String runmode ,String City, String Locality,String Specialization,String Expected) throws Exception {

		if(runmode.equals("yes")){

			driver.findElement(By.xpath("//*[@id='onlyDiagnostics']/a")).click();			 
			HomePage.searchDiagnosticsZoylo(City, Locality, Specialization);
			Browser.waitFortheElementXpath(Elements_Home.Map_DiagnosticsCenters);
			String ActualResult = driver.findElement(By.id(Elements_Home.map_AreaName)).getText();
			//Comparing Actual VS Expected
			Assert.assertEquals(ActualResult, Expected);	

		}else{

			throw new SkipException("RUNMODE IS OFF");
		}


	}
	@DataProvider(name = "DP2")
	public String[][] createData2() {
		return new String[][] {
			{ "yes","Hyderabad","","Zoylo Health Pkg" },


		};
	}
	@Test(dataProvider="DP2",groups = { "Regression","High" })
	public void HomePageDiagnosticsSearchWithPackage(String runmode ,String City, String Locality,String pkg) throws Exception {

		if(runmode.equals("yes")){
			//Test Starts - Here
			driver.findElement(By.xpath("//*[@id='onlyDiagnostics']/a")).click();
		 	HomePage.searchDiagnosticsZoylo(City, Locality, pkg);
		 	Browser.waitFortheElementXpath(Elements_Home.Map_DiagnosticsCenters);
			Thread.sleep(10000);
			RecipientPage.clickOnMapICon();
			RecipientPage.bookAppointmentOnDiagnostics();
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys(pkg);
			Thread.sleep(2000);
			String PkgNameActual = driver.findElement(By.xpath("//span[@class='zy-rec-diag-s-pkg-chkbox']/following-sibling::span[1]")).getText();
			Assert.assertEquals(PkgNameActual, pkg);



		}else{

			throw new SkipException("RUNMODE IS OFF");
		}


	}




	@AfterClass(groups = { "Regression","High" })

	public void Exit() {

		driver.quit();

	}





}