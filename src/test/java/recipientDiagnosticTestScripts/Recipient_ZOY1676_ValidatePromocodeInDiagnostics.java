package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
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
public class Recipient_ZOY1676_ValidatePromocodeInDiagnostics extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Sugar Test","Zoylo Health Pkg",Diagnostic_Name }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validatePromocodeInDiagnostics(String runmode,String Tests,String Pkg,String DiagnosticName ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
				Browser.openUrl(loginPage_Url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToDiagnostics();
				RecipientPage.searchInZoyloMAP(DiagnosticName);
				String DiagonosticsFullName = driver.findElement(By.xpath("//h1")).getText();
				System.out.println("DiagonosticsFullName"+DiagonosticsFullName);
				RecipientPage.bookAppointmentOnDiagnostics();
				RecipientPage.selectAvailableSlotInDiagnostics("", Pkg);
				String ConsultationFee=driver.findElement(By.xpath("//div[@class='zy-rec-diag-txt-amt']")).getText();
				System.out.println("ConsultationFee"+ConsultationFee);
				RecipientPage.confirmAppointmentOnDiagnostics();
				 //verifying Promo code with no data
				driver.findElement(By.xpath("//span[text()='Apply']")).click();
			    Browser.verifyNotificationMessage("Please enter promocode");
			    driver.navigate().refresh();
			    //verifying Promo code with Invalid data
			    driver.findElement(By.id("promocodeValue")).sendKeys("asdg123");
				driver.findElement(By.xpath("//span[text()='Apply']")).click();
			    Browser.verifyNotificationMessage("Promo Code Not Found or Invalid");
			    //verifying Promo code with Valid data
			    driver.navigate().refresh();
			    driver.findElement(By.id("promocodeValue")).sendKeys("ZOY15");
				driver.findElement(By.xpath("//span[text()='Apply']")).click();
			    Browser.verifyNotificationMessage("Promocode applied successfully");
			  
			    
			  //verifying Consultation Fee
			    String PaymentConsultationFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Amount Payable')]/div[2]")).getText();
		       // System.out.println("PaymentConsultationFee="+PaymentConsultationFee.replace(".00", ""));
		        Assert.assertEquals(PaymentConsultationFee, "105.00");

		        //verifying Promotion amount
			    String PromotionAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Promotion Applied ')]/div[2]")).getText();
		        System.out.println("PromotionAmount="+PromotionAmount);
		        Assert.assertEquals(PromotionAmount, "-5.00");
		        //verifying Total Amount
			    String TotalFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Total Fee')]/div[2]")).getText();
		        System.out.println("TotalFee="+TotalFee);
		       // String TotalAmountString = TotalAmount.replace(". ", "");
		        System.out.println("TotalFee="+TotalFee);
		        Assert.assertEquals(TotalFee, "100.00");
		        //verifying Advance Confirmation Fee
			    String AdvanceFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Advance Confirmation Fee')]/div[2]")).getText();
		        System.out.println("PromotionAmount="+AdvanceFee);
		        Assert.assertEquals(AdvanceFee, "0.00");
		        //verifying Balance Amount
			    String BalanceAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Balance to pay at Center')]/div[2]")).getText();
		        System.out.println("BalanceAmount="+BalanceAmount);
		       // String BalanceAmountString = BalanceAmount.replace(". ", "");
		        System.out.println("BalanceAmountString="+BalanceAmount);
		        Assert.assertEquals(BalanceAmount, "100.00");
		        
		
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

		 driver.quit();
	      
	    }
    
	

    
    
}