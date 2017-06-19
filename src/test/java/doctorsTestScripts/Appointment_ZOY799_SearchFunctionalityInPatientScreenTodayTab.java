package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY799_SearchFunctionalityInPatientScreenTodayTab extends LoadPropMac {
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {  
		  	LoadBrowserProperties();
		  	driver.get(doctors_Url);		 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DoctorsPage= new DoctorsPage(driver);
			Browser=new TestUtils(driver);
			DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		
			  }	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Elurubusstop","N","9966226611","elurubus@gmail.com","Diabetic" }

			};
		}
	
	@Test(dataProvider="DP1")
	public void SearchFunctionalityInPatientScreenTodayTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patient_id)).click();
		Browser.waitFortheID("searchPatientsList");
		Thread.sleep(2000);
		String fullname=firstname+" "+lastname;
		 String topping[]=new String[3];
		 topping[0]=fullname;
		 topping[1]=mobile;
		 topping[2]=email;
		 for(int i=0;i<=topping.length-1;i++){
			 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(topping[i]);	 
			 driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
			 Thread.sleep(3000);
			String name= driver.findElement(By.xpath(Elements_Doctors.patient_todaytabname)).getText();
			String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_todaytabschedule)).getText();
			if(name.contains(firstname)&& schedule.equalsIgnoreCase("Scheduled")){
			
				System.out.println("Appointment Created User Had Available");
			}else{
				System.out.println("Appointment Created User Not Available");
				Assert.fail("Appointment Created User Not Available");
			}
		  }
	      }
	@AfterMethod
	public void AppointmentBulkCancelandLogout() throws Exception{
		DoctorsPage.BulkCancel();
		DoctorsPage.doctorlogout();
	}
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
	

}
