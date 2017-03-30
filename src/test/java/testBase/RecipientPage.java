package testBase;



import objectRepository.*;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class RecipientPage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public   WebDriver driver;
	 public TestUtils Browser;	
	
	public RecipientPage(WebDriver driver) throws Exception {
		this.driver=driver;
	
		Elements_Recipients.Recipients_PageProperties();
		 Browser= new TestUtils(driver);   
	}
   
	
	
	 /*   Below is the Sample Method
	  *  @Autur : Ganesh Mandala
	  *   Entering the test details in Doctor enrollment Page and submitting the page
	  */
	
		public void doctorsEnrollment(String Area, String FirstName,String LastName,String Gender,String Qualification,String Email, String Address,String Fee,String Notes) throws InterruptedException{
			
			int Phno = (int )(Math.random() *1000000000);
			
			 System.out.println("element firstName"+Elements_Doctors.enrollment_firstname);
			
			driver.findElement(By.xpath("//span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Area+"')]")).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_firstname)).sendKeys(FirstName);
			driver.findElement(By.id(Elements_Doctors.enrollment_lastname)).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@value='"+Gender+"']")).click();
			driver.findElement(By.xpath("//div[2]/span/span/span/ul")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@id,'"+Qualification+"')]")).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_regname)).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id(Elements_Doctors.enrollment_mobile)).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id(Elements_Doctors.enrollment_email)).sendKeys(""+Email+""+Phno+"@india.com");
			driver.findElement(By.id(Elements_Doctors.enrollment_clinicaddress)).sendKeys(Address);
			driver.findElement(By.id(Elements_Doctors.enrollment_consultationfee)).sendKeys(Fee);
			driver.findElement(By.id(Elements_Doctors.enrollment_notes)).sendKeys(Notes);
			driver.findElement(By.id(Elements_Doctors.enrollment_doc_fac)).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_terms_cond)).click();
			driver.findElement(By.xpath(Elements_Doctors.enrollment_submit)).click();
			
			
		}
		
		
		
		
public void recipientLogin(String email, String password) throws InterruptedException{
			
	 driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).clear();
	 driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(email);
	 Thread.sleep(2000);
	 driver.findElement(By.id(Elements_Recipients.Recipient_Password)).clear();
	 driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(password);
	 driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
	 Browser.waitTill(30);
	 System.out.println("Logged in as"+email );
			
		}


public void recipientLogout() throws InterruptedException{
	
	 driver.get("https://zoyloqa.zoylo.com/myaccount");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//a[@id='logout_1']/span/i")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.id("logout")).click();
	 Thread.sleep(2000);	
			
		}

/*   
 *  @Autur : Ganesh Mandala
 *   Entering the search details in Zoylo Map
 */

public void searchInZoyloMAP(String keyword) throws InterruptedException{
	
	driver.findElement(By.id("search2")).click();
	driver.findElement(By.id("indexSearchTextbox")).sendKeys(keyword);
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("div.a-s-w > span")).click();
	Thread.sleep(5000);	
			
		}

public void searchInZoyloMAPArea(String Area) throws InterruptedException{
	
	
	driver.findElement(By.xpath("//span[@id='zy-location-right']/span[2]")).click();
	driver.findElement(By.id("location")).sendKeys(Area);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//li[@id='locationName']")).click();
	Thread.sleep(10000);
	System.out.println("Searched with location"+Area);
			
		}

public void bookAppointment() throws InterruptedException{

	driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();  // book
	Browser.waitTill(60);
	Thread.sleep(2000);
System.out.println("Cliked on Book Button");
		}

public void selectDefaultSlot() throws InterruptedException{

	driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click();  // book
	Thread.sleep(2000);
System.out.println("Cliked on Default Slot Button");
		}
public void confirmAppointment(String details) throws InterruptedException{

    Browser.waitFortheElementXpath("//div[text()='Confirm Appointment']");
	driver.findElement(By.id("problem")).sendKeys(details);
	driver.findElement(By.xpath("//div[text()='Confirm Appointment']")).click();  //Confirm Appointment
	Thread.sleep(5000); //changed
    System.out.println("Appointment Confirmed");
		}
public void makePayment() throws InterruptedException{

	Browser.waitFortheID("applyPromocode");
	driver.findElement(By.id("applyPromocode")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();
	driver.findElement(By.id("termsAndConditions")).click();
	driver.findElement(By.id("proceed")).click();     //Make payment
	Browser.waitTill(60);
    System.out.println("Payment done");
		}

public void goToMyAccount() throws InterruptedException{

	driver.findElement(By.xpath("//li[@id='myaccount']/span/img")).click();  // book
	Browser.waitTill(60);
	Thread.sleep(2000);
System.out.println("Cliked on My Account Icon");
		}

public void goToDoctors() throws InterruptedException{

	driver.findElement(By.xpath("//*[@id='index']/span[1]/img")).click();  // book
	Browser.waitTill(60);
	Thread.sleep(2000);
System.out.println("Cliked on Doctors Icon");
		}
public void ApplyFilter(String FilterCatagory,String name , String Value) throws InterruptedException{
	
	

driver.findElement(By.xpath("//span[contains(.,'"+FilterCatagory+"')]")).click();
System.out.println("Clicked on the"+FilterCatagory);
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+Value+"']")).click();
System.out.println("Clicked on the"+Value);
driver.findElement(By.id("applyFilter")).click();
Thread.sleep(5000);	
System.out.println("Applied filter on"+FilterCatagory+" "+Value);
		}

public void ClearFilters() throws InterruptedException{

driver.findElement(By.id("clearFilter")).click();
Thread.sleep(5000);	
System.out.println("Cliked on Clear filter Button");
		}

public void clickOnFilterImg() throws InterruptedException{

	driver.findElement(By.cssSelector("span.zy-filtersimg > img")).click();
	Thread.sleep(5000);	
	System.out.println("Cliked on filter img");
		}
}