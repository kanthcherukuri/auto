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
	public void validateBookingAnAppointment( ) throws Exception {

			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
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
		    driver.findElement(By.id("promocodeValue")).sendKeys("Promo code 4");
			driver.findElement(By.xpath("//span[text()='Apply']")).click();
		    Browser.verifyNotificationMessage("Promocode applied successfully");
		    //verifying Consultation Fee
		    String PaymentConsultationFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Consultation Fee')]/div[2]")).getText();
	        System.out.println("PaymentConsultationFee="+PaymentConsultationFee);
	        Assert.assertEquals(ConsultationFee.replace(" ", ""), PaymentConsultationFee.replace(". ", ""));
	        //verifying Booking Fee
		    String PaymentBookingFee=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Booking Fee ')]/div[2]")).getText();
	        System.out.println("PaymentBookingFee="+PaymentBookingFee);
	        String BookingfeeString = PaymentBookingFee.replace(". ", "");
	        System.out.println("BookingfeeString="+BookingfeeString);
	        Assert.assertEquals(BookingfeeString, "9.00");
	        //verifying Service Tax
		    String PaymentServiceTax=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Service Tax')]/div[2]")).getText();
	        System.out.println("PaymentServiceTax="+PaymentServiceTax);
	        String PaymentServiceTaxString = PaymentServiceTax.replace(". ", "");
	        System.out.println("PaymentServiceTaxString="+PaymentServiceTaxString);
	        Assert.assertEquals(PaymentServiceTaxString, "1.00");
	        //verifying Promotion amount
		    String PromotionAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Promotion Amount')]/div[2]")).getText();
	        System.out.println("PromotionAmount="+PromotionAmount);
	        String PromotionAmountString = PromotionAmount.replace(". ", "");
	        System.out.println("PromotionAmountString="+PromotionAmountString);
	        Assert.assertEquals(PromotionAmountString, "5.00");
	        //verifying Total amount
		    String TotalAmount=driver.findElement(By.xpath("//div[@class='zy-sp-payment-opts' and contains(.,'Total')]/div[2]")).getText();
	        System.out.println("TotalAmount="+TotalAmount);
	        String TotalAmountString = TotalAmount.replace(". ", "");
	        System.out.println("TotalAmountString="+TotalAmountString);
	        Assert.assertEquals(TotalAmountString, "5.00");
	        //verifying Balance Amount
		    String BalanceAmount=driver.findElement(By.xpath("//div[@class='balancetopay zy-sp-payment-opts' and contains(.,'Balance to pay at clinic ')]/div[2]")).getText();
	        System.out.println("BalanceAmount="+BalanceAmount);
	        String BalanceAmountString = BalanceAmount.replace(". ", "");
	        System.out.println("BalanceAmountString="+BalanceAmountString);
	        Assert.assertEquals(BalanceAmountString, "90");
	        
	
	
	
	}

	@AfterClass(groups = { "Regression","High" })

	public void Exit() {
		
		driver.close();

	}





}