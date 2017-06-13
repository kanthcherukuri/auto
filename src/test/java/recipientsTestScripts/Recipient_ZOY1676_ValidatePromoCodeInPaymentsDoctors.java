package recipientsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;
import testBase.*;
import objectRepository.*;

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

 */
public class Recipient_ZOY1676_ValidatePromoCodeInPaymentsDoctors extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        

	} 


	
	@Test(groups = { "Regression","High" })
	public void validatePromoCodeInPaymentsDoctors( ) throws Exception {

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println(DoctorFullName);
			String ConsultationFee=driver.findElement(By.xpath("//*[@id='bookAppointment']/div")).getText();
			RecipientPage.bookAppointment();
			String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
			System.out.println("App details"+Appointmentdetails[0]);
			System.out.println("App details"+Appointmentdetails[1]);
			RecipientPage.confirmAppointment("Patient details");			
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
		    String PaymentConsultationFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Consultation Fee')]/div[2]")).getText();
	        System.out.println("PaymentConsultationFee="+PaymentConsultationFee.replace(".00", ""));
	        Assert.assertEquals(ConsultationFee.replace(" ", ""), PaymentConsultationFee.replace(".00", ""));

	        //verifying Promotion amount
		    String PromotionAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Promotion Applied ')]/div[2]")).getText();
	        System.out.println("PromotionAmount="+PromotionAmount);
	        Assert.assertEquals(PromotionAmount, "-5.00");
	        //verifying Total Fee
		    String TotalFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Total Fee')]/div[2]")).getText();
	        System.out.println("TotalAmount="+TotalFee);
	       // String TotalAmountString = TotalAmount.replace(". ", "");
	        System.out.println("TotalFee="+TotalFee);
	        Assert.assertEquals(TotalFee, "95.00");
	        //verifying Advance Confirmation Fee
		    String AdvanceFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Advance Confirmation Fee')]/div[2]")).getText();
	        System.out.println("PromotionAmount="+AdvanceFee);
	        Assert.assertEquals(AdvanceFee, "0.00");
	        //verifying Balance Amount
		    String BalanceAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Balance to pay at Clinic')]/div[2]")).getText();
	        System.out.println("BalanceAmount="+BalanceAmount);
	       // String BalanceAmountString = BalanceAmount.replace(". ", "");
	        System.out.println("BalanceAmountString="+BalanceAmount);
	        Assert.assertEquals(BalanceAmount, "95.00");
	        
	
	
	
	}

	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		
		driver.quit();
	} 





}