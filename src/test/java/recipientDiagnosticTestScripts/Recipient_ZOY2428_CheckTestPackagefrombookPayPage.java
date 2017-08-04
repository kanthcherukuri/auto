
/*@author:ch.LakshmiKanth
* About Script:Compares the Date and Check Notification Message When Package is deleted
*/
package recipientDiagnosticTestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import objectRepository.Elements_Recipients;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY2428_CheckTestPackagefrombookPayPage extends LoadPropMac {
	
	public RecipientPage RecipientPage;
	 public TestUtils Browser;	
	 public DiagnosticPage DiagnosticPage;
	 
	 @BeforeClass
	 public void LaunchBrowser() throws Exception {
		  LoadBrowserProperties();
		  Elements_Recipients.Recipients_PageProperties();
		  RecipientPage = new RecipientPage(driver);
		  Browser= new TestUtils(driver); 
		  Browser.openUrl(loginPage_Url);
		  RecipientPage.recipientLogin(Recipient_Username,Recipient_Password);
		 
	 }
	 
	 @Test(priority=1)
	 public void  ValidateDiagnosticsdeletPackage() throws Exception {
		 Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
		 RecipientPage.goToDiagnostics();
		 RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		 RecipientPage.bookAppointmentOnDiagnostics();
		 RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		// Browser.waitTill(2000);
		 String todaydate=driver.findElement(By.xpath("//span[@class='zy-rec-diag-apt-date']")).getText();
		 System.out.println("Today Date :"+todaydate);
		 DateFormat srcDf = new SimpleDateFormat("dd/MM/yyyy");
		 DateFormat destDf = new SimpleDateFormat("MMM d");
		 String dateStr=destDf.format(srcDf.parse(todaydate));
		 System.out.println("Converted date is :"+dateStr);
		 
		 String verifydate=driver.findElement(By.xpath(".//*[@id='blk']/span[1]")).getText();
		 System.out.println(verifydate);	
		 if(verifydate.contains(dateStr)) {
			 System.out.println("Date Comparision is Sucessfull");
			 Reporter.log("Date Comparision is Sucessfull");
		 }else {
			Assert.fail();
		 }
		//Thread.sleep(1000);
		 
		 Browser.clickOnTheElementByXpath("//i[@name='package']");
		 Browser.CheckNotificationMessage("The Zoylo Health Pkg package has been removed");
		 Reporter.log("Package had Deleted In Book and Pay Page");  
		// Thread.sleep(6000);
	 }
	 
	 @Test(priority=2)
	 public void ValidateDiagnosticsdeletTest() throws Exception {
		 Browser.clickOnTheElementByXpath("//i[@name='test']");
		 Browser.CheckNotificationMessage("The Cbt test has been removed");
		 Reporter.log("Test also Deleted from In Book and Pay Page");
		 //Thread.sleep(6000);
		 Browser.clickOnTheElementByXpath("//*[@id='bookAndPay']/span");
		 Browser.CheckNotificationMessage("Please select Test/Package");
		 Reporter.log("After Deleteing Test/Package and saved Got Notification as: Please select Test/Package"); 
		 RecipientPage.recipientLogout();
		 
	 }
	 
	 @AfterClass
	 public void logout() throws Exception {
	
	driver.quit();
		 
	 }

}
