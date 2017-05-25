package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;


public class Admin_ZOY1371_addDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;

	//Global variables for pre condition values
	public String emailID="may19_0@zoy.com";
	public String docName="Twofivemay";
	public String regNum="May250";
	public String clinicDefName="Src Default";
	public String mobNumDoc="7777710014";
		
	@DataProvider(name="genericdetails")
    public Object[][] getDataFromDataprovider()
	{
    return new Object[][] 
    	{
            {emailID,"Zoylo@123","Zoylo@123"}
		
        };
	}
	
	
	//Pre-Request Change: DoctorName , Registerid , Phno , Email
	
	
	@Test(dataProvider="genericdetails", priority=1)
	public void genericdetails(String docEmailID, String password, String confirmpassword)
	{
		
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.findElement(By.xpath(Elements_Admin.button_addDoctor)).click();
		Browser.waitFortheElementXpath("//h4[contains(., 'Doctor - Add')]");
		driver.findElement(By.name("username")).sendKeys(docEmailID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
		
	} //End of genericdetails method p1
	
	@DataProvider(name="docInfo")
	public Object[][] getDataFromDataprovider1()
	{
		return new Object[][] 
		    	{

		            {docName, regNum, "Male", "qaz", clinicDefName, "MBBS", "20", "11/08/1991"}
		            //Data must be valid and defined in database for fields like gender, qualification, specialization etc
		            //practiceDate format DD/MM/YYYY
		        };
	}
	@Test(dataProvider="docInfo", priority=2)
	public void doctorInformation(String docFirstName, String docMedNum, String gender, String areaOfSpec, String defaultClinicName, String docQualification, String consultationFee, String practiceDate) throws InterruptedException, URISyntaxException, AWTException
	{
		
		driver.findElement(By.id(Elements_Admin.button_doctorInformation)).click();
		driver.findElement(By.name("doctorInformation.firstName")).sendKeys(docFirstName);
		driver.findElement(By.name("doctorInformation.medicalRegistrationNumber")).sendKeys(docMedNum);
		driver.findElement(By.name("doctorInformation.gender")).click();
		
		WebElement mySelectElement = driver.findElement(By.name("doctorInformation.gender"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(gender);
		
		// Specialization
		Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div[2]/div/div[7]/span[1]/span[1]/span/ul", areaOfSpec);
		
		driver.findElement(By.name("doctorInformation.clinicName")).sendKeys(defaultClinicName);
		
		// Qualification
		Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div[2]/div/div[13]/span[1]/span[1]/span/ul", docQualification);
		
		driver.findElement(By.name("doctorInformation.consultationFee")).sendKeys(consultationFee);
		driver.findElement(By.name("doctorInformation.practiceStartDate")).sendKeys(practiceDate);
		
		// Image upload
		driver.findElement(By.xpath("//input[@file-input='doctorInformation.doctorImage']")).sendKeys(doc_image);
        Thread.sleep(5000);
		
		//Close other clinic tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[23]/ul/li[1]/div/div[1]/button")).click(); 
        //Close hospital tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[24]/ul/li[1]/div/div[1]/button")).click(); 
		//Close vacation tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[25]/ul/li[1]/div/div[1]/button")).click();
        
	} // End of doctorInformation method p2
	
	@DataProvider(name="timeSlots")
	public Object[][] doctorTimeslots()
	{
		return new Object[][]
				{
					{"true", "05:00", "17:00", "true", "06:00", "18:00", "true", "07:00", "19:00", "true", "08:00", "20:00", "true", "09:00", "21:00"}
				};
	}
	
	@Test(dataProvider="timeSlots", priority=3)
	public void doctorTimeSlots(String mValue, String mondayStart, String mondayEnd, String tValue, String tueStart, String tueEnd, String wValue, String wStart, String wEnd, String thValue, String thStart, String thEnd, String fValue, String fStart, String fEnd)
	{
		Browser.scrollbyxpath(".//*[@id='doctorInformation']/div/div[2]/div/div[25]/div"); //Scroll to Vacation text
		//Monday
		if(mValue.equalsIgnoreCase("true"))
			{
				driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.isActive")).click(); //Active check box
				driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Monday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
				driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.start")).sendKeys(mondayStart);
				driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.end")).sendKeys(mondayEnd);
				System.out.println("Monday slots entered");
			}
		else
			{
				//Monday check box
				driver.findElement(By.name("doctorInformation.workingHrs.Monday.markedAsOpen")).click();
				//div close
				driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[2]/tr/td[2]/button[1]"));
				System.out.println("Monday slots are not provided");
			}
		
		//Tuesday
		if(tValue.equalsIgnoreCase("true"))
			{
				driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.isActive")).click(); //Active check box
				driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Tuesday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
				driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.start")).sendKeys(tueStart);
				driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.end")).sendKeys(tueEnd);
				System.out.println("Tuesday slots entered");
			}
		else
			{
				//Tuesday check box
				driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.markedAsOpen")).click();
				//div close
				driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[3]/tr/td[2]/button[1]"));
				System.out.println("Tuesday slots are not provided");
			}
		
		//Wednesday
		if(wValue.equalsIgnoreCase("true"))
			{
				driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.isActive")).click(); //Active check box
				driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Wednesday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
				driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.start")).sendKeys(wStart);
				driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.end")).sendKeys(wEnd);
				System.out.println("Wednesday slots entered");
			}
		else
			{
				//Wednesday check box
				driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.markedAsOpen")).click();
				//div close
				driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[4]/tr/td[2]/button[1]"));
				System.out.println("Wednesday slots are not provided");
			}
		
		//Thursday
		if(thValue.equalsIgnoreCase("true"))
			{
				driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.isActive")).click(); //Active check box
				driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Thursday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
				driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.start")).sendKeys(thStart);
				driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.end")).sendKeys(thEnd);
				System.out.println("Thursday slots entered");
			}
		else
			{
				//Thursday check box
				driver.findElement(By.name("doctorInformation.workingHrs.Thursday.markedAsOpen")).click();
				//div close
				driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[5]/tr/td[2]/button[1]"));
				System.out.println("Thursday slots are not provided");
			}
		
		//Friday
		if(fValue.equalsIgnoreCase("true"))
			{
				driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.isActive")).click(); //Active check box
				driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Friday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
				driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.start")).sendKeys(fStart);
				driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.end")).sendKeys(fEnd);
				System.out.println("Friday slots entered");
			}
		else
			{
			//Friday check box
			driver.findElement(By.name("doctorInformation.workingHrs.Friday.markedAsOpen")).click();
			//div close
			driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[6]/tr/td[2]/button[1]"));
			System.out.println("Friday slots are not provided");
			}
		
		//Saturday and Sunday arrays close and inactive
		driver.findElement(By.name("doctorInformation.workingHrs.Saturday.markedAsOpen")).click();
		//div close
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[7]/tr/td[2]/button[1]"));
		
		driver.findElement(By.name("doctorInformation.workingHrs.Sunday.markedAsOpen")).click();
		//div close
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[8]/tr/td[2]/button[1]"));
		
	} //End of doctorTimeSlots method p3
	
	@DataProvider(name="additionalInformation")
	public Object[][] additionInfo()
	{
		return new Object[][]
		{

			{mobNumDoc,"Naturopathy", "Obstetrician"}

		};
	}
	
	@Test(dataProvider="additionalInformation", priority=4)
	public void additionalInformation(String docmobileNumber, String docLOP, String docProfessionalTag) throws InterruptedException
	{
		driver.findElement(By.id(Elements_Admin.button_AdditionalInformation)).click();
		driver.findElement(By.name("additionalInformation.mobileNumber")).sendKeys(docmobileNumber);
		
		//LineOfPractice
		Browser.actionbyXpath(".//*[@id='additionalInformation']/div/div[2]/div[4]/span[1]/span[1]/span/ul", docLOP);
		
		// Professional Tag
		Browser.actionbyXpath(".//*[@id='additionalInformation']/div/div[2]/div[5]/span[1]/span[1]/span/ul", docProfessionalTag);
		
		Browser.scrollbyxpath(".//*[@id='additionalInformation']/div/div[2]/div[29]/ul/li[1]/div/div[2]/div/div/div/label"); //Scroll to Services
		
	} //End of additionalInformation method p4
	
	@DataProvider(name="addressdiv")
	public Object[][] addDiv()
	{
		return new Object[][]
		{
			//{"India", "Telangana", "Hyderabad", "This is default complete address", "Default locality", "543216", "77.123", "17.234"}
			{"India", "Telangana", "Hyderabad", "101/4B block C, Jubliee Enclave", "Hitech city", "500045", "77.123", "17.234"}
		};
	}
	
	@Test(dataProvider="addressdiv", priority=5)
	public void docaddress(String country, String state, String city, String completeaddress, String locality, String pincode, String lng, String lat)
	{
		
		driver.findElement(By.id(Elements_Admin.button_address)).click();
		
		//Country
		driver.findElement(By.id("select2-providerCountryOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(country);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		//State
		driver.findElement(By.id("select2-providerStateOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(state);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		
		//City locality address pin code and long lat
		driver.findElement(By.id("select2-providerCityOptions-container")).click();
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(city);
		driver.findElement(By.xpath("html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("address.completeAddress")).sendKeys(completeaddress);
		driver.findElement(By.name("address.locality")).sendKeys(locality);
		driver.findElement(By.name("address.pincode")).sendKeys(pincode);
		driver.findElement(By.name("address.lng")).sendKeys(lng);
		driver.findElement(By.name("address.lat")).sendKeys(lat);
		
	} //End of docaddress method p5
	
	@DataProvider(name="saved")
	public Object[][] saveddata()
	{
		return new Object[][]
				{

					{emailID}

				};
	}
	@Test(dataProvider="saved", priority=6)
	public void save(String savedEmail)
	{
		driver.findElement(By.id(Elements_Admin.button_DoctorSave)).click();
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Doctor ID "+savedEmail+" saved");
		} catch (Exception e) {
			System.out.println("Doctor ID "+savedEmail+" save failed");
		}
		
		
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.close();
	}
	
}
