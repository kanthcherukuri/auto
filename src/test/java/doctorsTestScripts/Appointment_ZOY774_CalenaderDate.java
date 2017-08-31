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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
			 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
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
		
		Date today = new Date(); 
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(today);  
		calendar.add(Calendar.MONTH, 1);  
		calendar.set(Calendar.DAY_OF_MONTH, 1);  
		calendar.add(Calendar.DATE, -1);  
		DateFormat sdf = new SimpleDateFormat("dd"); 
		Date lastDayOfMonth = calendar.getTime(); 
		String enddate= sdf.format(lastDayOfMonth);
		System.out.println("Current Month End Date Is:"+enddate);
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.dashboard_clickondashboardmenu)).click();
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.dashboard_waitfortodaydate)));
		String date=driver.findElement(By.xpath(Elements_Doctors.dashboard_selecttodaysdate)).getText();
		System.out.println("Todays Date is:"+date);
		String fullname=firstname+" "+lastname;
		if(date.equals(enddate)){
			driver.findElement(By.xpath(Elements_Doctors.dashboard_clickonnextmonth)).click();
			driver.findElement(By.xpath(Elements_Doctors.dashboard_clickondateone)).click();
			String name=driver.findElement(By.xpath(Elements_Doctors.dashboard_fullname)).getText();
			System.out.println("If Condition Name:"+name);
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
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
	}	


