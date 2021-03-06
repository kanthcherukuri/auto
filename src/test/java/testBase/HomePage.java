package testBase;



import objectRepository.*;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;




public class HomePage  {
	//FirefoxDriver browser = new FirefoxDriver();
	public   WebDriver driver;
	 public TestUtils Browser;
	public HomePage(WebDriver driver) throws Exception {
		this.driver=driver;
		Browser= new TestUtils(driver); 
		Elements_Home.Home_PageProperties();
		Elements_Doctors.Doc_PageProperties();
		
	}
   
	
	 /*  @Autur : Ganesh Mandala
	  *   Entering the search query as per the city , locality and Specialization in home page 
	  */
	
	public  void searchZoylo(String City, String Locality,String Specialization) throws InterruptedException{
		
		
		Browser.waitFortheID(Elements_Home.home_city);
		driver.findElement(By.id(Elements_Home.home_city)).sendKeys(City);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='pac-item'])[1]")).click();
		Thread.sleep(2000);
		// In case of Null Area
		try{
		driver.findElement(By.id(Elements_Home.home_area)).sendKeys(Locality);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//html/body/div[11]/div[1]")).click();
		Thread.sleep(2000);
		} catch(Exception e) {
			
		}
		// In case of Null Specialization
		try{
		driver.findElement(By.id(Elements_Home.home_specialization)).sendKeys(Specialization);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='one']/div/div[3]/div/ul/li")).click();
		Thread.sleep(2000);
        } catch(Exception e) {
			
		}
		driver.findElement(By.id("search-icon")).click();
		
		
	}
	
	 
	 
	 
	
	 
public  void searchDiagnosticsZoylo(String City, String Locality,String Specialization) throws InterruptedException{
		
		
		Browser.waitFortheElementXpath("//*[@id='diag-search-city']");
		driver.findElement(By.id("diag-search-city")).sendKeys(City);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='pac-item'])[1]")).click();
		Thread.sleep(2000);
		// In case of Null Area
		try{
		driver.findElement(By.id("diag-search-area")).sendKeys(Locality);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//html/body/div[13]/div[1]")).click();
		Thread.sleep(2000);
		} catch(Exception e) {
			
		}
		// In case of Null Specialization
		try{
		driver.findElement(By.id("search-test-pkg")).sendKeys(Specialization);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='two']/div/div[3]/div/div[1]/div/div[1]")).click();
		Thread.sleep(2000);
        } catch(Exception e) {
			
		}
		driver.findElement(By.id("diag-search-icon")).click();
		System.out.println("Clicked on search button");
		
	}
	
public  void searchQuery(String City, String Locality,String Specialization) throws InterruptedException{
		
		
		
		driver.findElement(By.id(Elements_Home.home_city)).sendKeys(City);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[15]/div[1]")).click();
		Thread.sleep(2000);
		// In case of Null Area
		try{
		driver.findElement(By.id(Elements_Home.home_area)).sendKeys(Locality);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[16]/div[1]")).click();
		Thread.sleep(2000);
		} catch(Exception e) {
			
		}
		// In case of Null Specialization
		try{
		driver.findElement(By.id(Elements_Home.home_specialization)).sendKeys(Specialization);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='srch-op']/div[3]/div/ul/li")).click();
		Thread.sleep(2000);
        } catch(Exception e) {
			
		}
		
		
	}
	 /*   @Autur : Ganesh Mandala
	  *   Entering the test details in Doctor enrollment Page and submitting the page
	  *   @Recent Changes : @Authur: Sagar Sen
	  *   @Changes Made : Called scrolled function for submit button
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
			driver.findElement(By.id(Elements_Doctors.enrollment_regname)).sendKeys(String.valueOf(Phno));
			Thread.sleep(1500);
			driver.findElement(By.id(Elements_Doctors.enrollment_mobile)).sendKeys(String.valueOf("9"+Phno));
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Doctors.enrollment_email)).sendKeys(Email);
			driver.findElement(By.id(Elements_Doctors.enrollment_clinicaddress)).sendKeys(Address);
			driver.findElement(By.id(Elements_Doctors.enrollment_consultationfee)).sendKeys(Fee);
			driver.findElement(By.id(Elements_Doctors.enrollment_notes)).sendKeys(Notes);
			driver.findElement(By.id(Elements_Doctors.enrollment_doc_fac)).click();
			driver.findElement(By.id(Elements_Doctors.enrollment_terms_cond)).click();
			Browser.scrollbyxpath(Elements_Doctors.enrollment_submit);
			driver.findElement(By.xpath(Elements_Doctors.enrollment_submit)).click();
			
			
		}
    
}