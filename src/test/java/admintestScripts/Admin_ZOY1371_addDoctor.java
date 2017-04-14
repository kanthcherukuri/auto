package admintestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.javafx.tk.Toolkit;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;


public class Admin_ZOY1371_addDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	@DataProvider(name="genericdetails")
    public Object[][] getDataFromDataprovider()
	{
    return new Object[][] 
    	{
            {"pomscript1@zoy.com","Zoylo@123","Zoylo@123"}
        };
	}
	
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
		
	}
	
	@DataProvider(name="docInfo")
	public Object[][] getDataFromDataprovider1()
	{
		return new Object[][] 
		    	{
		            {"PomName", "POM1", "Male", "qaz", "PomOne Default", "MBBS", "20", "11/08/1991"}
		            //Data must be valid and defined in database for fields like gender, qualification, specialization etc
		            //practiceDate format DD/MM/YYYY
		        };
	}
	@Test(dataProvider="docInfo", priority=2)
	public void doctorInformation(String docFirstName, String docMedNum, String gender, String areaOfSpec, String defaultClinicName, String docQualification, String consultationFee, String practiceDate) throws InterruptedException, URISyntaxException, AWTException, FindFailed
	{
		
		driver.findElement(By.xpath(Elements_Admin.button_doctorInformation)).click();
		driver.findElement(By.name("doctorInformation.firstName")).sendKeys(docFirstName);
		driver.findElement(By.name("doctorInformation.medicalRegistrationNumber")).sendKeys(docMedNum);
		driver.findElement(By.name("doctorInformation.gender")).click();
		
		WebElement mySelectElement = driver.findElement(By.name("doctorInformation.gender"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(gender);
		
		// Specialization
		Actions spec1 = new Actions(driver);
		spec1.moveToElement(driver.findElement(By.xpath(
				".//*[@id='doctorInformation']/div/div[2]/div/div[7]/span[1]/span[1]/span/ul")));
		spec1.click();
		spec1.sendKeys(areaOfSpec);
		spec1.sendKeys(Keys.ENTER);
		spec1.build().perform();
		
		driver.findElement(By.name("doctorInformation.clinicName")).sendKeys(defaultClinicName);
		
		// Qualification
		Actions qua = new Actions(driver);
		qua.moveToElement(driver.findElement(By.xpath(
				".//*[@id='doctorInformation']/div/div[2]/div/div[13]/span[1]/span[1]/span/ul")));
		qua.click();
		qua.sendKeys(docQualification);
		qua.sendKeys(Keys.ENTER);
		qua.build().perform();
		
		driver.findElement(By.name("doctorInformation.consultationFee")).sendKeys(consultationFee);
		driver.findElement(By.name("doctorInformation.practiceStartDate")).sendKeys(practiceDate);
		
		// Image upload
		//driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.doctorImage']//label[@class='btn btn-default']")).click();
		//Thread.sleep(5000);
		 
	
        //Code to perform action using action using sikuli script
        
		
		//Screen src = new Screen();
		//Pattern img= new Pattern("/Users/sen/Desktop/Zoylo.Project/Automate/Screenshots/tbd.png");
		//Pattern open = new Pattern("/Users/sen/Desktop/Zoylo.Project/Automate/Screenshots/upload.png");
		//src.find(img);
		//src.click(img);
		//src.find(open);
        //src.click(open);
        
		//Close other clinic tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[23]/ul/li[1]/div/div[1]/button")).click(); 
        //Close hospital tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[24]/ul/li[1]/div/div[1]/button")).click(); 
		//Close vacation tab
        driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[25]/ul/li[1]/div/div[1]/button")).click();
        
	}
	
	@DataProvider(name="timeSlots")
	public Object[][] doctorTimeslots()
	{
		return new Object[][]
				{
					{"true", "08:00"}
				};
	}
	
	@Test(dataProvider="timeSlots", priority=3)
	public void doctorTimeSlots(String mValue, String mondayStart)
	{
		Browser.scrollbyxpath(".//*[@id='doctorInformation']/div/div[2]/div/div[25]/div"); //Scroll to Vacation text
		if(mValue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.isActive")).click(); //Active check box
			driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Monday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
			driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.start")).sendKeys(mondayStart);
		}
		else
		{
			//Monday check box
			driver.findElement(By.name("doctorInformation.workingHrs.Monday.markedAsOpen")).click();
			//div close
			driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[2]/tr/td[2]/button[1]"));
			System.out.println("Monday slots are not provided");
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
