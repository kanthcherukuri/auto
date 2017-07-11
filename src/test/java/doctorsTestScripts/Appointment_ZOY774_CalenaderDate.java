package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import objectRepository.Elements_Doctors;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY774_CalenaderDate extends LoadPropMac {
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;



	@BeforeClass
		public void LaunchBrowser() throws Exception {		
			 LoadBrowserProperties();	 
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser= new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	}
	
	
	
	@DataProvider(name = "CalendarDate")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY774");
        return(retObjArr);
    }
		  
		
		
	@Test(dataProvider="CalendarDate")
	public void CheckingDashBoradCalendarDatefunctionality(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.dashboard_clickondashboardmenu)).click();
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.dashboard_waitfortodaydate)));
		//LoadProp.isElementPresnt(driver, "//a[@class='monthly-day monthly-day-event monthly-today']", 20).click();
		String date=driver.findElement(By.xpath(Elements_Doctors.dashboard_selecttodaysdate)).getText();
		System.out.println(date);
		String fullname=firstname+" "+lastname;
		if(date.equals("30")||(date.equals("31"))){
			driver.findElement(By.xpath(Elements_Doctors.dashboard_clickonnextmonth)).click();
			driver.findElement(By.xpath(Elements_Doctors.dashboard_clickondateone)).click();
			String name=driver.findElement(By.xpath(Elements_Doctors.dashboard_fullname)).getText();
			Assert.assertEquals(name, fullname);
			System.out.println("Created Appointment is Available");
		}
		else{
			driver.findElement(By.xpath("//*[@id='mycalendar']/div[3]/a["+date+"+1]/div[1]")).click();
			Thread.sleep(3000);
			String name=driver.findElement(By.xpath(Elements_Doctors.dashboard_fullname)).getText();
			Assert.assertEquals(name, fullname);
			driver.findElement(By.xpath(Elements_Doctors.dashboard_fullname)).click();
			System.out.println("Created Appointment is Available");
		}
		}
		
				 
		
		
	@AfterMethod
	public void AppointmentbulkCancelandLogout() throws Exception{
		DoctorsPage.BulkCancel();
		Thread.sleep(3000);
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
	}	


