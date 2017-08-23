package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import objectRepository.Elements_Doctors;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY799_SearchFunctionalityInPatientScreen extends LoadPropMac{
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {  
		  	LoadBrowserProperties();
		  			 
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DoctorsPage= new DoctorsPage(driver);
			Browser=new TestUtils(driver);
			Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
			DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		
			  }	
	
	@DataProvider(name = "PatientScreen")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY799");
        return(retObjArr);
    }
	
	
	@Test(dataProvider="PatientScreen")
	public void CheckSearchFunctionalityAllTab(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.patient_id)).click();
		Thread.sleep(10000);
		driver.findElement(By.name("all")).click();
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
			String name= driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
			String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
			if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
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
