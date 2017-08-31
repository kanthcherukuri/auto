package oldAdmintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1456_editHospitalDoctor extends LoadPropMac
{
	public AdminPage admin;
	public TestUtils Browser;
	
	//Global variables for pre condition values
	public String hopDocEmailID="hospitaldocjun12_0@zoylo.com";
	
	@DataProvider(name="editHopDoc")
	public Object[][] details()
	{
		return new Object[][]
				{
					{hopDocEmailID, "true", "06:00", "18:00", "true", "06:00", "18:00", "false", "07:00", "19:00", "true", "08:00", "20:00", "true", "09:00", "21:00"}
				};
	}
	
	@Test(dataProvider="editHopDoc")
	public void editdoctor(String docID, String mValue, String mondayStart, String mondayEnd, String tValue, String tueStart, String tueEnd, String wValue, String wStart, String wEnd, String thValue, String thStart, String thEnd, String fValue, String fStart, String fEnd) throws InterruptedException
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(docID);
		
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[1]", docID);
		
		driver.findElement(By.xpath("//button[contains(., 'EDIT')]")).click();
		
		Browser.waitFortheElementXpath("//h4[contains(., 'Doctor - Edit')]");
		
		driver.findElement(By.name("isActive")).click();
		driver.findElement(By.id(Elements_Admin.button_doctorInformation)).click();
		Browser.scrollbyxpath(".//*[@id='doctorInformation']/div/div/div/div[20]/ul/li[1]/div/div[2]/div/div[2]/div[3]/label");
		
		//Monday
				if(mValue.equalsIgnoreCase("true"))
					{
						driver.findElement(By.name("doctorInformation.workingHrs.Monday.markedAsOpen")).click(); //Active check box
						driver.findElement(By.xpath("//button[@data-autoform-field='doctorInformation.workingHrs.Monday.slots']")).click(); //Open array
						driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.isActive")).click(); //Active
						driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Monday.slots.0.locationType']//label//input[@value='hospital']")).click();
						
						Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div/div/div[22]/div[2]/table/tbody[2]/tr/td[2]/div[4]/div/div[5]/span[1]/span[1]/span", "Apollo");
											
						driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.start")).sendKeys(mondayStart);
						driver.findElement(By.name("doctorInformation.workingHrs.Monday.slots.0.end")).sendKeys(mondayEnd);
						System.out.println("Monday slots entered");
					}
				else
					{
						//Monday check box
						//driver.findElement(By.name("doctorInformation.workingHrs.Monday.markedAsOpen")).click();
						System.out.println("Monday slots are not provided");
					}
				
				//Tuesday
				if(tValue.equalsIgnoreCase("true"))
					{
						driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.markedAsOpen")).click(); //Active check box
						driver.findElement(By.xpath("//button[@data-autoform-field='doctorInformation.workingHrs.Tuesday.slots']")).click(); //Open array
						driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.isActive")).click(); //Active
						driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Tuesday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
						
						Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div/div/div[22]/div[2]/table/tbody[3]/tr/td[2]/div[4]/div/div[5]/span[1]/span[1]/span", "Apollo");
						
						driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.start")).sendKeys(tueStart);
						driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.slots.0.end")).sendKeys(tueEnd);
						System.out.println("Tuesday slots entered");
					}
				else
					{
						//Tuesday check box
						//driver.findElement(By.name("doctorInformation.workingHrs.Tuesday.markedAsOpen")).click();
						System.out.println("Tuesday slots are not provided");
					}
				
				//Wednesday
				if(wValue.equalsIgnoreCase("true"))
					{
					driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.markedAsOpen")).click(); //Active check box
					driver.findElement(By.xpath("//button[@data-autoform-field='doctorInformation.workingHrs.Wednesday.slots']")).click(); //Open array
						driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.isActive")).click(); //Active
						driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Wednesday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
						
						Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div/div/div[22]/div[2]/table/tbody[4]/tr/td[2]/div[4]/div/div[5]/span[1]/span[1]/span", "Apollo");
						
						driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.start")).sendKeys(wStart);
						driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.slots.0.end")).sendKeys(wEnd);
						System.out.println("Wednesday slots entered");
					}
				else
					{
						//Wednesday check box
						//driver.findElement(By.name("doctorInformation.workingHrs.Wednesday.markedAsOpen")).click();
						System.out.println("Wednesday slots are not provided");
					}
				
				//Thursday
				if(thValue.equalsIgnoreCase("true"))
					{
					driver.findElement(By.name("doctorInformation.workingHrs.Thursday.markedAsOpen")).click(); //Active check box
					driver.findElement(By.xpath("//button[@data-autoform-field='doctorInformation.workingHrs.Thursday.slots']")).click(); //Open array
						driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.isActive")).click(); //Active
						driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Thursday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
						
						Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div/div/div[22]/div[2]/table/tbody[5]/tr/td[2]/div[4]/div/div[5]/span[1]/span[1]/span", "Apollo");
						
						driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.start")).sendKeys(thStart);
						driver.findElement(By.name("doctorInformation.workingHrs.Thursday.slots.0.end")).sendKeys(thEnd);
						System.out.println("Thursday slots entered");
					}
				else
					{
						//Thursday check box
						//driver.findElement(By.name("doctorInformation.workingHrs.Thursday.markedAsOpen")).click();
						System.out.println("Thursday slots are not provided");
					}
				
				//Friday
				if(fValue.equalsIgnoreCase("true"))
					{
					driver.findElement(By.name("doctorInformation.workingHrs.Friday.markedAsOpen")).click(); //Active check box
					driver.findElement(By.xpath("//button[@data-autoform-field='doctorInformation.workingHrs.Friday.slots']")).click(); //Open array
						driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.isActive")).click(); //Active
						driver.findElement(By.xpath("//div[@data-schema-key='doctorInformation.workingHrs.Friday.slots.0.locationType']//label//input[@value='hospital']")).click(); //Location type
						
						Browser.actionbyXpath(".//*[@id='doctorInformation']/div/div/div/div[22]/div[2]/table/tbody[6]/tr/td[2]/div[4]/div/div[5]/span[1]/span[1]/span", "Apollo");
						
						driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.start")).sendKeys(fStart);
						driver.findElement(By.name("doctorInformation.workingHrs.Friday.slots.0.end")).sendKeys(fEnd);
						System.out.println("Friday slots entered");
					}
				else
					{
					//Friday check box
					//driver.findElement(By.name("doctorInformation.workingHrs.Friday.markedAsOpen")).click();
					System.out.println("Friday slots are not provided");
					}
				
				//Saturday and Sunday arrays close and inactive
				//driver.findElement(By.name("doctorInformation.workingHrs.Saturday.markedAsOpen")).click();
				//div close
				//driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[7]/tr/td[2]/button[1]"));
				
				//driver.findElement(By.name("doctorInformation.workingHrs.Sunday.markedAsOpen")).click();
				//div close
				//driver.findElement(By.xpath(".//*[@id='doctorInformation']/div/div[2]/div/div[26]/div[2]/table/tbody[8]/tr/td[2]/button[1]"));
				
		Browser.scrollbyID("adminProviderSubmit");
		driver.findElement(By.id(Elements_Admin.button_DoctorSave)).click();
		Thread.sleep(5000);
		
		try {
			Browser.waitFortheID("add");
			System.out.println("Doctor ID "+docID+" saved");
		} catch (Exception e) {
			System.out.println("Doctor ID "+docID+" save failed");
		}
	}
	
	@BeforeClass
	public void lauchBrowser() throws Exception
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
