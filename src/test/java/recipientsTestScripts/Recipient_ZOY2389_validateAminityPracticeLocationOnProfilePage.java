package recipientsTestScripts;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Recipient_ZOY2389_validateAminityPracticeLocationOnProfilePage extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public DoctorsPage doctorsPage;
	
	@Test()
	public void validatePracticeDetails() throws Exception
	{
		//Doctor Application
		doctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
		Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		Browser.clickOnTheElementByXpath(Elements_Doctors.clinicTab);
		Browser.clickOnTheElementByXpath(Elements_Doctors.aminitiesTab);
		doctorsPage.editAminitiesStringPass(Elements_Doctors.aminitiesBikePark);
		Browser.CheckNotificationMessage("Clinic details updated successfully");
		System.out.println("Bike parking is activated for default clinic");
		Thread.sleep(6000);
		doctorsPage.switchClinicPracticeLoactions();
		doctorsPage.editAminitiesStringPass(Elements_Doctors.aminitiesCarPark);
		Browser.CheckNotificationMessage("Clinic details updated successfully");
		System.out.println("Car parking is activated for other clinic");
		Thread.sleep(6000);
		doctorsPage.doctorlogout();
		//Recipient Application
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		RecipientPage.bookAppointment();
		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, Doctor_Name);
		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfileAminities);
		Thread.sleep(2000);
		for(int value=1;value<=2;value++)
		{
			String AminityHeadxpath="(//div[@class='amenities-title']//h1)["+value+"]";
			String AminityValuexpath="(//div[@class='amenities-title']//p)["+value+"]";
			String aminityText=Browser.getTextByXpath(AminityHeadxpath);
			String aminityTextValue=Browser.getTextByXpath(AminityValuexpath);
			String Aminity=aminityText+" "+aminityTextValue;
			System.out.println(Aminity);
			if(value==1)
			{
				Assert.assertEquals(Aminity, "Bike Parking Available");
			}
			else
			{
				Assert.assertEquals(Aminity, "Car Parking Not Available");
			}
		}
		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfileSchedule);
		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfilePlusMore);
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath(Elements_Recipients.doctor_ProfileOtherClinicDropDown);
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfileAminities);
		Thread.sleep(2000);
		for(int value=1;value<=2;value++)
		{
			String AminityHeadxpath="(//div[@class='amenities-title']//h1)["+value+"]";
			String AminityValuexpath="(//div[@class='amenities-title']//p)["+value+"]";
			String aminityText=Browser.getTextByXpath(AminityHeadxpath);
			String aminityTextValue=Browser.getTextByXpath(AminityValuexpath);
			String Aminity=aminityText+" "+aminityTextValue;
			System.out.println(Aminity);
			if(value==1)
			{
				Assert.assertEquals(Aminity, "Bike Parking Not Available");
			}
			else
			{
				Assert.assertEquals(Aminity, "Car Parking Available");
			}
		}
		driver.get(loginPage_Url);
		doctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
		Browser.clickOnTheElementByID(Elements_Doctors.schedule);
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		Browser.clickOnTheElementByXpath(Elements_Doctors.clinicTab);
		Browser.clickOnTheElementByXpath(Elements_Doctors.aminitiesTab);
		doctorsPage.editAminitiesStringPass(Elements_Doctors.aminitiesBikePark);
		Browser.CheckNotificationMessage("Clinic details updated successfully");
		Thread.sleep(6000);
		doctorsPage.switchClinicPracticeLoactions();
		doctorsPage.editAminitiesStringPass(Elements_Doctors.aminitiesCarPark);
		Browser.CheckNotificationMessage("Clinic details updated successfully");
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Elements_Doctors.Doc_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
		//driver.get(index_url);
	}
	
	@AfterClass
	public void Exit() 
	{	
		driver.quit();
	} 
}