package testBase;



import objectRepository.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;


public class RecipientPage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public   WebDriver driver;
	public TestUtils Browser;
	public boolean Slots;

	public RecipientPage(WebDriver driver) throws Exception {
		this.driver=driver;

		Elements_Recipients.Recipients_PageProperties();
		Elements_Home.Home_PageProperties();
		Browser= new TestUtils(driver);  
		// LoadProp Prop= new LoadProp(driver);
	}



	/*   Below is the Sample Method
	 *  @Author      :Ganesh kumar.M
	 *  @Description : Entering the test details in Doctor enrollment Page and submitting the page
	 *  @Parameters  : Area,  FirstName, LastName ..
	 *  @Return      : 
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


	/*  
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to login into zoylo app
	 *  @Parameters  : Username, Password ..
	 *  @Return      : 
	 */

	public void recipientLogin(String email, String password) throws InterruptedException{
		Browser.waitFortheID("emailAddress");		
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).clear();
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(email);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).clear();
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
		Browser.waitTill(60);
		System.out.println("Logged in as"+email );
		Reporter.log("Logged in as"+email);

	}
	
	/*  
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Logout from zoylo app
	 *  @Parameters  : 
	 *  @Return      : 
	 */

	public void recipientLogout() throws InterruptedException{

		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/myaccount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='logout_1']/span/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(2000);	

	}
	
	/*  
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to view get directions pop up under address assertion on doctor profile page
	 *  @Parameters  :
	 *  @Return      : distance
	 */
	public String addressAssertion()
	{
		Browser.waitFortheElementXpath(Elements_Recipients.addressAssertion);
		driver.findElement(By.xpath(Elements_Recipients.addressAssertion)).click();
		Browser.waitFortheID(Elements_Recipients.getDirectionLink);
		String distance=Browser.getTextByXpath(Elements_Recipients.distanceValue);
		Browser.clickOnTheElementByID(Elements_Recipients.getDirectionLink);
		//Pop up handler
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		if(driver.findElement(By.xpath("(//img[@class='adp-marker'])[1]")).isDisplayed())
		{
			System.out.println("Get directions is displayed as expected");
		}
		else
		{
			System.out.println("ERROR - Get directions is not displayed");
		}
		driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
		driver.switchTo().window(parentWindowHandler);  // switch back to parent window
		return distance;
	}
	
	/*  
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to check if the address is within the service range of DC for home visit
	 *  @Parameters  :
	 *  @Return      : 
	 */
	public void checkDChomeVisitServiceRange() throws InterruptedException
	{
		Browser.waitFortheElementXpath("//div[@class='zy-rec-diag-hm-add-title']");
		//Select first address
		driver.findElement(By.xpath("(//div[@class='zy-rec-diag-hm-add-radio']//input[@name='address'])[1]")).click();
		String address1=driver.findElement(By.xpath("//span[contains(., 'Pragathi nagar jntu ,Housing Board Colony ,Telangana ,India.')]")).getText();
		driver.findElement(By.xpath("//div[@class='zy-rec-diag-add-confirm-btn']//span")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("(.//*[@id='tests_search'])[2]")).isDisplayed())
		{
			//Browser.waitFortheElementXpath("(.//*[@id='tests_search'])[2]");
			System.out.println(address1+" is within the service range");
			Thread.sleep(5000);
			driver.findElement(By.id("home_pickup")).click();
		}
		else
		{
			Browser.CheckNotificationMessage("Home Sample Collection is not availabe at your location");
		}
		//Select second address
		driver.findElement(By.xpath("(//div[@class='zy-rec-diag-hm-add-radio']//input[@name='address'])[2]")).click();
		String address2=driver.findElement(By.xpath("//span[contains(., 'ECIL X Roads, Moula Ali, Secunderabad, Telangana, India')]")).getText();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='zy-rec-diag-add-confirm-btn']//span")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("(.//*[@id='tests_search'])[2]")).isDisplayed())
		{
			//Browser.waitFortheElementXpath("(.//*[@id='tests_search'])[2]");
			System.out.println(address2+" is within the service range");
			Thread.sleep(5000);
			driver.findElement(By.id("home_pickup")).click();
		}
		else
		{
			Browser.CheckNotificationMessage("Home Sample Collection is not availabe at your location");
		}
	}

	/*  
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Enter the search details in Zoylo Map
	 *  @Parameters  : Area ..
	 *  @Return      : 
	 */
	public void searchInZoyloMAP(String keyword) throws InterruptedException{

		Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
		Thread.sleep(5000);
		
		driver.findElement(By.id("search2")).click();
	    for(int i=0;i<=keyword.length()-1; i++)
	    {
	    	char Doc = keyword.charAt(i);	    	
	    	driver.findElement(By.id("indexSearchTextbox")).sendKeys(Character.toString(Doc));
	    	Thread.sleep(500);
	    }
	    Thread.sleep(500);
		driver.findElement(By.cssSelector("div.a-s-w > span")).click();
		Thread.sleep(2000);

	}
	
	/*  
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to Enter the search details of diagnostics in Zoylo Map
	 *  @Parameters  : DCName
	 *  @Return      : 
	 */
	public void searchDCInZoyloMAP(String keyword) throws InterruptedException{
		Browser.waitFortheElementXpath(Elements_Home.Map_DiagnosticsCenters);
		Thread.sleep(1000);
		driver.findElement(By.id("search2")).click();
	    for(int i=0;i<=keyword.length()-1; i++)
	    {
	    	char Dc = keyword.charAt(i);	    	
	    	driver.findElement(By.id("indexSearchTextbox")).sendKeys(Character.toString(Dc));
	    	Thread.sleep(500);
	    }
	    Thread.sleep(500);
		driver.findElement(By.cssSelector("div.a-s-w > span")).click();
		Thread.sleep(2000);

	}
	
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Enter the search details in Zoylo Map
	 *  @Parameters  : Area ..
	 *  @Return      : 
	 */	
	public void searchInZoyloMAPArea(String Area) throws InterruptedException{

        Browser.waitFortheElementXpath("//span[@id='zy-location-right']/span[2]");
		driver.findElement(By.xpath("//span[@id='zy-location-right']/span[2]")).click();
		for(int i=0;i<=Area.length()-1; i++)
	    {
	    	char Doc = Area.charAt(i);	    	
	    	driver.findElement(By.id("location")).sendKeys(Character.toString(Doc));
	    	Thread.sleep(500);
	    }
	
		driver.findElement(By.xpath("//li[@id='locationName']")).click();
		Thread.sleep(5000);
		System.out.println("Searched with location"+Area);

	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Enter the search details in Zoylo detail Map
	 *  @Parameters  : Location/User ..
	 *  @Return      : 
	 */	
	public void searchInZoylodetailMAP(String keyword) throws InterruptedException{
		Browser.waitFortheID("searchFilter");
		driver.findElement(By.id("searchFilter")).click();
		Thread.sleep(1000);
		
		for(int i=0;i<=keyword.length()-1; i++)
	    {
	    	char Doc = keyword.charAt(i);	    	
	    	driver.findElement(By.id("listingSearchTextbox")).sendKeys(Character.toString(Doc));
	    	Thread.sleep(500);
	    }

		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@class='a-s-w']/span)[3]")).click();
		System.out.println("Cliked on span");
		Thread.sleep(5000);	

	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to click on book button in Doctors
	 *  @Parameters  : 
	 *  @Return      : 
	 *  Last Change  : 
	 */	
	public void bookAppointment() throws InterruptedException{

		Browser.clickOnTheElementByID("bookAppointment");
		Browser.waitTill(60);
		Thread.sleep(2000);
		System.out.println("Cliked on Book Button");
	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to click on book button in Diagnostics
	 *  @Parameters  : 
	 *  @Return      : 
	 */	
	public void bookAppointmentOnDiagnostics() throws InterruptedException{

		Browser.clickOnTheElementByXpath("//*[@id='diagnosticDetails']");
		Browser.waitTill(60);
		System.out.println("Cliked on Book Button");
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to select available slot in Doctors 
	 *  @Parameters  : 
	 *  @Return      : Appointment details (clinic name , appointment Time)
	 */
	public String[]  selectDefaultSlot1() throws InterruptedException{
		String[] Appointmentdetails= new String[2];
		//Next Day
		driver.findElement(By.id("cd-1")).click();
		Browser.waitFortheElementXpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]");
		Appointmentdetails[0] = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
		Appointmentdetails[1] = driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).getText();
        System.out.println("Clinic Name:"+Appointmentdetails[0]);
        System.out.println("Appointment Time:"+Appointmentdetails[1]);
		if(driver.findElements(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).isEmpty()){

			throw new SkipException("Slots are not available");
 
		}else{
			driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click();  // book
			Thread.sleep(2000);
			System.out.println("Cliked on Default Slot Button");

		}
		return Appointmentdetails;
	}
	
	
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to select available slot in Doctors 
	 *  @Parameters  : 
	 *  @Return      : Appointment details (clinic name , appointment Time)
	 */
	public String[]  selectDefaultSlot() throws InterruptedException{
		String[] Appointmentdetails= new String[2];
		//checkSlots();
		Browser.waitFortheElementXpath("(//div[@class='panel-collapse collapse in']/ul/li)[1]");
		String SlotStatus=driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']/ul/li[last()]")).getAttribute("class");
		
		
		if(SlotStatus.equals("sp-available-slots")){
			System.out.println("Default Slot Tab");
			Appointmentdetails[0] = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
			Appointmentdetails[1] = driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])[1]")).getText();
	        System.out.println("Clinic Name:"+Appointmentdetails[0]);
	        System.out.println("Appointment Time:"+Appointmentdetails[1]);
		
				driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])[1]")).click();  // book
				Thread.sleep(2000);
				System.out.println("Cliked on Default Slot Button");

		}else{
			System.out.println("Cliked on Next Slot Tab");
			driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']/parent::*/following-sibling::div[@class='panel panel-default'][1]/div[1]//a")).click();
			Thread.sleep(2000);
			Appointmentdetails[0] = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
			Appointmentdetails[1] = driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])[1]")).getText();
	        System.out.println("Clinic Name:"+Appointmentdetails[0]);
	        System.out.println("Appointment Time:"+Appointmentdetails[1]);
		
				driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])[1]")).click();  // book
				Thread.sleep(2000);
			
		
		
		}

		return Appointmentdetails;
	}
	/*
	 * Author: Sagar Sen
	 * @Description: This method is used to select home visit available slot
	 * @Params:
	 * @Return: time slot at which the appointment has been booked
	 */
	public String selectHomeVisitSlot() throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("(.//*[@id='apponitmentTime' and @class='sp-available-slots']//img[@class='homevisiticon'])[1]")).isDisplayed())
		{
			System.out.println("Home visit slot is already displaying");
		}
		else
		{
			driver.findElement(By.id("session4")).click();
		}
		
		Thread.sleep(2000);
		Browser.waitFortheElementXpath("(.//*[@id='apponitmentTime' and @class='sp-available-slots']//img[@class='homevisiticon'])[1]");
		String slotTime=driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots']//following-sibling::img[@class='homevisiticon'])[1]")).getText();
		if(driver.findElements(By.xpath("(.//*[@id='apponitmentTime' and @class='sp-available-slots']//img[@class='homevisiticon'])[1]")).isEmpty()){

			throw new SkipException("Home slots are not available");
		}else{
			driver.findElement(By.xpath("(.//*[@id='apponitmentTime' and @class='sp-available-slots']//img[@class='homevisiticon'])[1]")).click();  // book
			Thread.sleep(2000);
			
		}
		return slotTime;
	}
	
	/*   
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to select available payment options and proceed to payment page 
	 *  @Parameters  : paymentValue - mention 1 for ICICI, 2 for EBS and 3 for PayTm
	 *  @Return      : 
	 */
	public void paymentOptions(int paymentValue) throws InterruptedException
	{
		Browser.waitFortheElementXpath("//*[@id='proceed']");
		driver.findElement(By.xpath("(//input[@name='paymentOption'])["+paymentValue+"]")).click();
		driver.findElement(By.id("termsAndConditions")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("proceed")).click();
	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to select available slot in Diagnostics 
	 *  @Parameters  : Tests and packages
	 *  @Return      : 
	 */
	public void selectAvailableSlotInDiagnostics_old(String tests,String pkg ) throws InterruptedException{
		Browser.waitFortheElementXpath("//*[@id='test-li']/a");

		if(pkg.isEmpty()){
			//tests
			driver.findElement(By.xpath("//*[@id='test-li']/a")).click();
			driver.findElement(By.id("tests_search")).sendKeys(tests);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'test_select_checkbox')])[1]")).click();

		}else if (tests.isEmpty()){
			//pkg
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys(pkg);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'pack_select_checkbox')])[1]")).click();

		}else{
			System.out.println("Enter in test pkg");
			//tests
			driver.findElement(By.xpath("//*[@id='test-li']/a")).click();
			driver.findElement(By.id("tests_search")).sendKeys(tests);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'test_select_checkbox')])[1]")).click();

			//pkg
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys(pkg);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'pack_select_checkbox')])[1]")).click();
			Thread.sleep(5000);

		}

		driver.findElement(By.xpath("//*[@id='schedule-li']/a")).click();
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("(//*[@class='timeSlot sp-available-slots'])[1]")).isEmpty()){

			throw new SkipException("Slots are not available");

		}else{
			driver.findElement(By.xpath("(//*[@class='timeSlot sp-available-slots'])[1]")).click();  // book
			Thread.sleep(2000);
			System.out.println("Cliked on Available Slot Button from diagonostics");
			
		}

	}
	
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to select available slot in Diagnostics 
	 *  @Parameters  : Tests and packages
	 *  @Return      : 
	 */
	public String[] selectAvailableSlotInDiagnostics(String tests,String pkg ) throws InterruptedException{
		Browser.waitFortheElementXpath("//*[@id='test-li']/a");

		if(pkg.isEmpty()){
			//tests
			driver.findElement(By.xpath("//*[@id='test-li']/a")).click();
			driver.findElement(By.id("tests_search")).sendKeys(tests);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'test_select_checkbox')])[1]")).click();

		}else if (tests.isEmpty()){
			//pkg
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys(pkg);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'pack_select_checkbox')])[1]")).click();

		}else{
			System.out.println("Enter in test pkg");
			//tests
			driver.findElement(By.xpath("//*[@id='test-li']/a")).click();
			driver.findElement(By.id("tests_search")).sendKeys(tests);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'test_select_checkbox')])[1]")).click();

			//pkg
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys(pkg);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[contains(@class,'pack_select_checkbox')])[1]")).click();
			Thread.sleep(5000);

		}
		
		String[] Appointmentdetails= new String[2];
		driver.findElement(By.xpath("//*[@id='schedule-li']/a")).click();  // click on Schedule tab
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("(//div[@class='panel-collapse collapse in']/ul/li)[1]");
		String SlotStatus=driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']/ul/li[last()]")).getAttribute("class");
		
		
		
		if(SlotStatus.equals("timeSlot sp-available-slots")){
			System.out.println("Default Slot Tab");
			
			Appointmentdetails[1] = driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[1]")).getText();
	        System.out.println("Clinic Name:"+Appointmentdetails[0]);
	        System.out.println("Appointment Time:"+Appointmentdetails[1]);
		
				driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[1]")).click();  // book
				Thread.sleep(2000);
				System.out.println("Cliked on Default Slot Button");

		}else{
			System.out.println("Cliked on Next Slot Tab");
			driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']/parent::*/following-sibling::div[@class='panel panel-default'][1]/div[1]//a")).click();
			Thread.sleep(2000);
			Appointmentdetails[0] = driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
			Appointmentdetails[1] = driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[1]")).getText();
	        System.out.println("Clinic Name:"+Appointmentdetails[0]);
	        System.out.println("Appointment Time:"+Appointmentdetails[1]);
		
				driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[1]")).click();  // book
				Thread.sleep(2000);
			
		
		
		}
		
		return Appointmentdetails;

	}
	
	/*   
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to select available slots for home visit in Diagnostics 
	 *  @Parameters  : 
	 *  @Return      : 
	 */
	public void selectDChomeVisitSlots() throws InterruptedException
	{
		driver.findElement(By.id(Elements_Recipients.dcHometestTab)).click();
		driver.findElement(By.xpath("//span[@class='zy-rec-diag-h-test-chkbox']")).click(); //Select test
		driver.findElement(By.id(Elements_Recipients.dcHomePkgTab)).click();
		Browser.waitFortheElementXpath("//span[@class='zy-rec-diag-h-pkg-chkbox']");
		driver.findElement(By.xpath("//span[@class='zy-rec-diag-h-pkg-chkbox']")).click(); //Select pkg
		driver.findElement(By.id(Elements_Recipients.hWorkingTab)).click();
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("(//div[@id='diag-rec-h-timings']//div[@class='sp-slots-booking']//li[@class='timeSlot sp-available-slots'])[1]")).isEmpty())
		{
			throw new SkipException("Slots are not available");
		}
		else
		{
			driver.findElement(By.xpath("(//div[@id='diag-rec-h-timings']//div[@class='sp-slots-booking']//li[@class='timeSlot sp-available-slots'])[1]")).click();  // book
			Thread.sleep(2000);
			System.out.println("Cliked on Available Slot Button from diagonostics");
		}
	}
	
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Confirm Appointments in Doctors 
	 *  @Parameters  : Health Details
	 *  @Return      : 
	 */
	public void confirmAppointment(String details) throws InterruptedException{

		Browser.waitFortheElementXpath("//div[@id='bookAppointment']");
		driver.findElement(By.id("problem")).sendKeys(details);
		Browser.scrollbyxpath("//div[@id='bookAppointment']");
		driver.findElement(By.xpath("//div[@id='bookAppointment']")).click();  //Confirm Appointment
		Thread.sleep(5000); //Add Due to clickable Issue
		System.out.println("Appointment Confirmed");
	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Confirm Appointments in Diagnostics 
	 *  @Parameters  : 
	 *  @Return      : 
	 */
	public void confirmAppointmentOnDiagnostics() throws InterruptedException{

		Browser.waitFortheElementXpath("//h5[contains(., 'Selected Packages & Tests')]");
		Browser.scrollbyxpath("//*[@id='bookAndPay']");
		driver.findElement(By.xpath("//*[@id='bookAndPay']")).click();  //Confirm Appointment
		Thread.sleep(5000); //changed
		System.out.println("Appointment Confirmed");
	}
	/*   
	 *  @Author      : Ganesh kumar.M
	 *  @Description : This method is used to Confirm Appointments as Others 
	 *  @Parameters  : 
	 *  @Return      : 
	 */
	public void confirmAppointmentAsOthers(String details,String Pname,String Lname,String Pgender,String PAge,String BloodGRP) throws InterruptedException{

		Browser.waitFortheElementXpath("//div[@id='bookAppointment']");
		driver.findElement(By.id("problem")).sendKeys(details);
		driver.findElement(By.id("radio-checkbtn-others")).click(); // self (Added newly)
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys(Pname);
		driver.findElement(By.id("lastName")).sendKeys(Lname);
		driver.findElement(By.id("patientGender")).sendKeys(Pgender);
		driver.findElement(By.id("patientAge")).sendKeys(PAge);
		//driver.findElement(By.id("bloodGroup")).sendKeys(BloodGRP);
		Browser.scrollbyID("bookAppointment");
		driver.findElement(By.id("bookAppointment")).click();  //Confirm Appointment
		Thread.sleep(5000); //changed
		System.out.println("Appointment Confirmed");
	}
	public void makePayment_old() throws InterruptedException{

		Browser.waitFortheID("applyPromocode");

		driver.findElement(By.xpath("(//input[@id='applyPromocode'])[1]")).click();

		Thread.sleep(10000);
		//driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();
		driver.findElement(By.id("termsAndConditions")).click();
		Browser.scrollbyID("proceed");
		driver.findElement(By.id("proceed")).click();     //Make payment
		Browser.waitTill(60);
		//Thread.sleep(20000);
		System.out.println("Payment done");
	}
	
	//New Promo Page
	public void makePayment() throws InterruptedException{

		Browser.waitFortheElementXpath("//h4[@class='review-panelLink']");
		Browser.enterTextByID("promocodeValue", "ZOY15");
		//driver.findElement(By.id("promocodeValue")).sendKeys("ZOY15");
		//driver.findElement(By.xpath("//span[3]")).click();
		Browser.clickOnTheElementByXpath("//span[@class='btn btn-default applyPromocode']");
		Thread.sleep(6000);
		//driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();  // To check the 3rd Option of promo code
		//driver.findElement(By.id("termsAndConditions")).click();                      // Terms and condition
		Browser.scrollbyID("proceed");
		driver.findElement(By.id("proceed")).click();     //Make payment
		//Browser.waitTill(60);
		Thread.sleep(5000);
		System.out.println("Payment done");
	}
	
	//New Promo Page
		public void UpcomingAppointment(String APID , String Action) throws InterruptedException{

			Browser.waitFortheID("upcmng");
			driver.findElement(By.id("aptSearch")).click();
			driver.findElement(By.id("aptSearch")).sendKeys(APID);
			Thread.sleep(5000);
			Browser.waitFortheElementXpath("(//div[@class='zy-diagno-zy-apt-chng']//div[@class='zyBookApmptId' and contains(.,'"+APID+"')])");	
			//driver.findElement(By.xpath("//div[@class='zy-diagno-doc-revw change-DcApt apt-doc-col']")).click();
		if(Action.equals("Reschedule")){
			System.out.println("Reshedule Action Is Executed");
			driver.findElement(By.xpath("(//div[@class='zy-diagno-doc-revw change-DcApt apt-doc-col' and contains(.,'Reschedule Appointment')])")).click();
		}else if (Action.equals("Cancel")){
			System.out.println("Cancelled Action Is Executed");
			driver.findElement(By.xpath("(//div[@class='menu_links appt-cancel apt-doc-col'])[1]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='cancelYes']")).click();
			Thread.sleep(2000);
		}
			
			
		}
	
	/*   
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to click proceed on payment page for DC 
	 *  @Parameters  : 
	 *  @Return      : 
	 */
	public void makePaymentforDC() throws InterruptedException{

		Browser.waitFortheID("promocodeValue");
		driver.findElement(By.id("promocodeValue")).sendKeys("ZOY15");
		driver.findElement(By.xpath("//span[3]")).click();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();  // To check the 3rd Option of promo code
		//driver.findElement(By.id("termsAndConditions")).click();                      // Terms and condition
		Browser.scrollbyID("proceed");
		driver.findElement(By.id("proceed")).click();     //Make payment
		//Browser.waitTill(60);
		Thread.sleep(15000);
		System.out.println("Payment done");
	}
	
	/*   
	 *  @Author      : Sagar Sen
	 *  @Description : This method is used to click search icon on home page to navigate to index page post booking DC appointment 
	 *  @Parameters  : 
	 *  @Return      : 
	 */
	public void goToDCIndexPageFromHome()
	{
		Browser.waitFortheID("diag-search-icon");
		driver.findElement(By.id("diag-search-icon")).click();
		//Browser.waitFortheElementXpath("//i[@class='fa fa-map-marker']");
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

	public void goToDiagnostics() throws InterruptedException{
		Thread.sleep(1000);
		Browser.clickOnTheElementByID("diagnostics");
		//Browser.waitTill(60);
		Thread.sleep(3000);
		System.out.println("Cliked on Diagnostics Icon");
	}



	public void goToAppointments() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='myaccount']/span/img")).click();
		Thread.sleep(5000);
		System.out.println("Clicked On My Account");
		driver.findElement(By.xpath("//li[@id='myAppointment']/a/span/i")).click();
		Thread.sleep(2000);
		System.out.println("Clicked On Appointments");	
		Thread.sleep(5000);// Added for view
		
	}
	public void ApplyFilter(String FilterCatagory,String name , String Value,String Search) throws InterruptedException{



		driver.findElement(By.xpath("//span[contains(.,'"+FilterCatagory+"')]")).click();
		System.out.println("Clicked on the"+FilterCatagory);
		Thread.sleep(2000);
		if(Search.equals("")){
			System.out.println("No Serach in filters");
		}else{
			driver.findElement(By.xpath("//*[@id='"+Search+"']")).sendKeys(Value);
			Thread.sleep(2000);	
		}
		//Browser.waitFortheElementXpath("//input[@name='"+name+"' and @value='"+Value+"']");
		
	/*	WebElement invisibleelement= driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+Value+"']"));  
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", invisibleelement); */
		//Browser.clickOnTheElementByID(""+Value+""+name+"");
		Browser.clickOnTheElementByXpath("//li[@name='"+Value+""+name+"']");
		System.out.println("Clicked on the"+Value);
		driver.findElement(By.id("applyFilter")).click();
		Thread.sleep(5000);	
		System.out.println("Applied filter on"+FilterCatagory+" "+Value);
	}



	public void ApplyFilterInDiagnostics(String FilterCatagory,String name , String Value,String Search) throws InterruptedException{



		driver.findElement(By.xpath("//span[contains(.,'"+FilterCatagory+"')]")).click();
		System.out.println("Clicked on the"+FilterCatagory);
		Thread.sleep(2000);

		if(Search.equals("")){
			System.out.println("No Serach in filters");
		}else{
			driver.findElement(By.xpath("//*[@id='"+Search+"']")).sendKeys(Value);
			Thread.sleep(5000);
			
		}

		WebElement invisibleelement= driver.findElement(By.xpath("//input[@name='"+name+"' and @value='"+Value+"']"));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", invisibleelement); 
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
        Browser.waitFortheElementXpath("//span[@class='zy-filtersimg']/img");
		driver.findElement(By.xpath("//span[@class='zy-filtersimg']/img")).click();
		Thread.sleep(5000);	
		System.out.println("Cliked on filter img");
	}

	public void clickOnMapICon() throws InterruptedException{

		driver.findElement(By.xpath("//div[@id='mapIconMenu']/span/img")).click();
		Thread.sleep(5000);
		System.out.println("Cliked on Map Listing / Icon");
	}

	public void openMyAccounts() throws InterruptedException{
		driver.get(LoadPropMac.base_url+"myaccount");
		Thread.sleep(5000);
		System.out.println("Cliked on Map Listing / Icon");
	}
	
	public String getNotificationMesssage() throws InterruptedException{
		Thread.sleep(2000);
		String Notification= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();

		System.out.println("Notification is"+Notification);

		return Notification;
	}

	public void openMyAccounts(String TabName) throws InterruptedException{
		driver.get(LoadPropMac.base_url+"myaccount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'"+TabName+"')]")).click();
		Thread.sleep(2000);
		System.out.println("Cliked on Tab Name"+TabName);
	}

	public void goToMyAccounts(String TabName) throws InterruptedException{

		Browser.clickOnTheElementByXpath("//li[@id='myaccount']/span/img");
		Browser.waitTill(60);
		driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'"+TabName+"')]")).click();
		Thread.sleep(2000);
		System.out.println("Cliked on Tab Name"+TabName);
	}


	public void checkSlots() throws InterruptedException{

		driver.findElement(By.xpath("//a[contains(@href, '#sp-morningslots')]")).click();
		Thread.sleep(2000);
		if(driver.findElements(By.xpath("//div[@id='sp-morningslots']/ul/li[@class='sp-available-slots']")).isEmpty())
		{
			System.out.println("Clicked on After noon slots");
			driver.findElement(By.xpath("//a[contains(@href, '#sp-afternoonslots')]")).click();
			Thread.sleep(2000);
		}
		else if(driver.findElements(By.xpath("//div[@id='sp-afternoonslots']/ul/li[@class='sp-available-slots']")).isEmpty())
		{
			System.out.println("Clicked on Evening  slots");
			driver.findElement(By.xpath("//a[contains(@href, '#sp-eveningslots')]")).click();
			Thread.sleep(2000);

		}else if(driver.findElements(By.xpath("//div[@id='sp-eveningslots']/ul/li[@class='sp-available-slots']")).isEmpty())
		{
			System.out.println("Clicked on night slots");
			driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
			Thread.sleep(2000);

		}

	}

}