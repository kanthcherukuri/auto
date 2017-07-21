package recipientDiagnosticTestScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


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
		  RecipientPage.recipientLogin("ganeshzoylo@gmail.com","Zoylo@123");
		 
	 }
	 
	 @Test(priority=1)
	 public void  checkdeletPackage() throws Exception {
		 Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
		 RecipientPage.goToDiagnostics();
		 RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		 RecipientPage.bookAppointmentOnDiagnostics();
		 RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		 Browser.waitTill(2000);
		 String todaydate=driver.findElement(By.xpath("//span[@class='zy-rec-diag-apt-date']")).getText();
		 System.out.println("Today Date :"+todaydate);
		 DateFormat srcDf = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = srcDf.parse(todaydate);
		 DateFormat destDf = new SimpleDateFormat("MMM dd");
		 String dateStr = destDf.format(date);
		 System.out.println("Converted date is :"+dateStr);
		 
		 String verifydate=driver.findElement(By.xpath(".//*[@id='blk']/span[1]")).getText();
		 System.out.println(verifydate);
		 String[] getdate=verifydate.split("on");
		 String text=getdate[0];
		 System.out.println("First Part of Split :"+text);
		 String time=getdate[1];
		 System.out.println("Second Part of Split :"+time);
		 String[] finaldate=time.split(",");
		 String comparedate=finaldate[0];
		
		 System.out.println("Comparedate of First Part :"+comparedate);
		 String comparetime=finaldate[1];
		 System.out.println("Comparedate of Second Part :"+comparetime);
		
		 if(dateStr.equals(comparedate.trim())) {
			 System.out.println("Date Comparision is Sucessfull");
			 Reporter.log("Date Comparision is Sucessfull");
		 }else {
			Assert.fail();
		 }
		Thread.sleep(1000);
		 
		 Browser.clickOnTheElementByXpath("//i[@name='package']");
		 Browser.CheckNotificationMessage("The Zoylo Health Pkg package has been removed");
		 Reporter.log("Package had Deleted In Book and Pay Page");  
		 Thread.sleep(6000);
	 }
	 
	 @Test(priority=2)
	 public void Checkdeletetest() throws Exception {
		 Browser.clickOnTheElementByXpath("//i[@name='test']");
		 Browser.CheckNotificationMessage("The Cbt test has been removed");
		 Reporter.log("Test also Deleted from In Book and Pay Page");
		 Thread.sleep(6000);
		 Browser.clickOnTheElementByXpath("//*[@id='bookAndPay']/span");
		 Browser.CheckNotificationMessage("Please select Test/Package");
		 Reporter.log("After Deleteing Test/Package and saved Got Notification as: Please select Test/Package"); 
		 Thread.sleep(2000);
		 
	 }
	 
	 @AfterClass
	 public void logout() throws Exception {
	RecipientPage.recipientLogout();
	driver.quit();
		 
	 }

}
