package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1415_addHospitalDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String hopDocEmailID="hospitaldocjun12_0@zoylo.com";
	public String hopDocName="dochop jun twelve";
	public String shrtName="juntwlvhop";
	public String hopMedNuber="JU12-0";
	public String hopDocmobNum="8888810003";
	public String errorNotification="Address is required";
	
	@DataProvider(name="generaldetails")
    public Object[][] getDataFromDataprovider()
	{
    return new Object[][] 
    	{
            {hopDocEmailID,"Zoylo@123","Zoylo@123"}
        };
	}
	
	@Test(dataProvider="generaldetails", priority=1)
	public void generalDetails(String docEmailID, String password, String confirmpassword) throws InterruptedException
	{
		
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.findElement(By.xpath(Elements_Admin.button_addDoctor)).click();
		Browser.waitFortheElementXpath("//h4[contains(., 'Doctor - Add')]");
		driver.findElement(By.xpath("//input[@value='hospital']")).click();
		driver.findElement(By.name("username")).sendKeys(docEmailID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
		driver.findElement(By.xpath("//input[@value='hospital']")).click();
		//Thread.sleep(2000);
		
	}//End of general details method p1
	
	@DataProvider(name="docInfo")
	public Object[][] getDataFromDataprovider1()
	{
		return new Object[][]
		    	{
		            {hopDocName, shrtName, hopMedNuber, "Male", "Nutrition", "MBBS", "11/08/1991", "Apollo", "10", "1"}
		            //Data must be valid and defined in database for fields like gender, qualification, specialization etc
		            //practiceDate format DD/MM/YYYY
		        };
	}
	
	@Test(dataProvider="docInfo", priority=2)
	public void doctorInformation(String docFirstName, String docshrtName, String docMedNum, String gender, String areaOfSpec, String docQualification, String practiceDate, String hospitalName, String hopFee, String ZFC) throws InterruptedException, URISyntaxException, AWTException
	{
		
		driver.findElement(By.id(Elements_Admin.button_doctorInformation)).click();
		driver.findElement(By.name("doctorInformation.firstName")).sendKeys(docFirstName);
		driver.findElement(By.name("doctorInformation.shortName")).sendKeys(docshrtName);
		driver.findElement(By.name("doctorInformation.medicalRegistrationNumber")).sendKeys(docMedNum);
		driver.findElement(By.name("doctorInformation.gender")).click();
		
		Browser.selectbyName("doctorInformation.gender", gender);
		
		// Specialization
		Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div[2]/div/div[8]/span[1]/span[1]/span/ul", areaOfSpec);
				
		// Qualification
		Browser.actionbyXpath("//*[@id='doctorInformation']/div/div[2]/div/div[10]/span[1]/span[1]/span/ul", docQualification);
				
		driver.findElement(By.name("doctorInformation.practiceStartDate")).sendKeys(practiceDate);
		// Image upload
				driver.findElement(By.xpath("//input[@file-input='doctorInformation.doctorImage']")).sendKeys(doc_image);
		        Thread.sleep(5000);
		
		Browser.scrollbyxpath(".//*[@id='doctorInformation']/div/div[2]/div/div[19]/label");
		
		//Hospital
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[20]/ul/li[1]/div/div[2]/div/div[2]/div[1]/span[1]/span[1]/span")).click();
		Thread.sleep(1000);
		Browser.actionbyXpath("html/body/span/span/span[1]/input", hospitalName);
		
		driver.findElement(By.name("doctorInformation.hospital.0.consultationFee")).sendKeys(hopFee);
		driver.findElement(By.name("doctorInformation.hospital.0.fecilationCharge")).sendKeys(ZFC);
		driver.findElement(By.name("doctorInformation.hospital.0.isDefault")).click();
		
		//Close vacation array
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[21]/ul/li[1]/div/div[1]/button")).click();
		
		// Inactivate all days
		Browser.scrollbyName("doctorInformation.hospital.0.isDefault");

		driver.findElement(By.name("doctorInformation.workingHrs.Monday.markedAsOpen")).click(); // Monday inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[2]/tr/td[2]/button[1]")).click();
		driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.markedAsOpen")).click(); // Tuesday inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[3]/tr/td[2]/button[1]")).click();
		
		Browser.scrollbyName("doctorInformation.workingHrs.Tuesday.markedAsOpen");

		driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.markedAsOpen")).click(); // Wed inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[4]/tr/td[2]/button[1]")).click();
		driver.findElement(By.name("doctorInformation.workingHrs.Thursday.markedAsOpen")).click(); // Thu inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[5]/tr/td[2]/button[1]")).click();
		driver.findElement(By.name("doctorInformation.workingHrs.Friday.markedAsOpen")).click(); // Fri inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[6]/tr/td[2]/button[1]")).click();
		
		Browser.scrollbyName("doctorInformation.workingHrs.Thursday.markedAsOpen");

		driver.findElement(By.name("doctorInformation.workingHrs.Saturday.markedAsOpen")).click(); // Sat inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[7]/tr/td[2]/button[1]")).click();
		driver.findElement(By.name("doctorInformation.workingHrs.Sunday.markedAsOpen")).click(); // Sun inactive
		driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[8]/tr/td[2]/button[1]")).click();
	
		Browser.scrollbyxpath(".//*[@id='doctorInformation']/div/div[2]/div/div[22]/div[2]/table/tbody[8]/tr/td[2]/div[1]/label"); //Scroll to sunday
		
	} //End of doctorInformation method p2
	
	@DataProvider(name="addInfo")
	public Object[][] additionalInfo()
	{
		return new Object[][]
				{
					{hopDocmobNum, "Dental", "Sexologist", hopDocEmailID}
				};
	}
	
	@Test(dataProvider="addInfo", priority=3)
	public void docaddInfo(String mobNum, String doclop, String docpt, String savedEmail) throws InterruptedException
	{
		driver.findElement(By.id(Elements_Admin.button_AdditionalInformation)).click();
		Browser.scrollbyxpath(".//*[@id='additionalInformation']/div/div[1]/h3");
		driver.findElement(By.name("additionalInformation.mobileNumber")).sendKeys(mobNum);
		
		// Line of Practice
		Browser.actionbyXpath(".//*[@id='additionalInformation']/div/div[2]/div[4]/span[1]/span[1]/span/ul", doclop);
		
		// Professional Tag
		Browser.actionbyXpath(".//*[@id='additionalInformation']/div/div[2]/div[5]/span[1]/span[1]/span/ul", docpt);
		
		Browser.scrollbyxpath(".//*[@id='additionalInformation']/div/div[2]/div[29]/ul/li[1]/div/div[2]/div/div/div/label");
		
		driver.findElement(By.id(Elements_Admin.button_DoctorSave)).click();
		if(errorNotification.equalsIgnoreCase("Address is required"))
		{
			Browser.scrollbyID("adminProviderSubmit");
			driver.findElement(By.id(Elements_Admin.button_DoctorSave)).click();
		}
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Doctor ID "+savedEmail+" saved");
		} catch (Exception e) {
			System.out.println("Doctor ID "+savedEmail+" save failed");
		}
	
	} //End of docaddInfo method p3
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.close();
	}
}
