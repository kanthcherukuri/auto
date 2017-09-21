package zoyloMT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

public class ZMT_Hospital_SubmitEnquiry_GetEstimate_ZOY2667 extends LoadPropMac {
	
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
		@BeforeClass
		public void Browser() throws Exception {	
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://"+Zmt_environmentname+".com");
		}
		
		
		 @DataProvider(name = "Hospitals")
		 public String[][] createData1() {
				return new String[][] {
						{ "kanth","kanthxy@gmail.com","9966662411","Query And enquiry form submission"}

				};
			}
		
		@Test(dataProvider="Hospitals")
		public void CheckHospitalSubmitEnquiry(String Name, String Email,String Phno,String Query) throws Exception {
			
			Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_SearchButton);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.SearchResults_TopHospitalMenu);
			int hossize=driver.findElements(By.xpath(Elements_ZMTusers.SearchResults_TopHospitals_Size)).size();
			System.out.println("size:"+hossize);
			if(driver.findElements(By.xpath(Elements_ZMTusers.SearchResults_TopHospitals_Size)).size()!=0) {
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.SearchResults_TopHospitals_SubmitEnquiry);
			zmtUserPage.Hospitals_SubmitEnquiry_Details(Name, Email, Phno, Query);
			Browser.zmt_notification("We will get back to you soon");
			//Get An Estimate Script
			driver.navigate().refresh();
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.SearchResults_TopHospitalMenu);
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.SearchResults_TopHospitals_GetEstimate);
			zmtUserPage.Hospitals_SubmitEnquiry_Details(Name, Email, Phno, Query);
			Browser.zmt_notification("We will get back to you soon");	
			}else {
				
			System.out.println("Hospital Records Are Not Available");
				
			}
			//List Of Hospital Scripts-Submit Enquiry
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,900)", "");
			Browser.clickOnTheElementByXpath(Elements_ZMTusers.Hospitals_Usefulllinks);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			int hoslinksize=driver.findElements(By.xpath(Elements_ZMTusers.Listofhospitalssize)).size();
			System.out.println("Hospital Links:"+hoslinksize);
			if(driver.findElements(By.xpath(Elements_ZMTusers.Listofhospitalssize)).size()!=0) {
				
				Browser.clickOnTheElementByXpath(Elements_ZMTusers.SubmitEnquiry_ListOfhospitals);
				zmtUserPage.ListOfHospitals_SubmitEnquiry_Details(Name, Email, Phno, Query);
				Browser.zmt_notification("We will get back to you soon");	
				
				//List of Hospitals:-Get An Estimate Script
				driver.navigate().refresh();
				Browser.clickOnTheElementByXpath(Elements_ZMTusers.GetEstimate_Listofhospitals);
				zmtUserPage.ListOfHospitals_SubmitEnquiry_Details(Name, Email, Phno, Query);
				Browser.zmt_notification("We will get back to you soon");	
			}else {
				
				System.out.println("List Of Hospitals Records Not Available");
			}
			
		}
		
		
		@AfterClass
		public void CloseBrowser() {
			driver.quit();
		}

}
