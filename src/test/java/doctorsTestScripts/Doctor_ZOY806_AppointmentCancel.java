package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Doctor_ZOY806_AppointmentCancel extends LoadPropMac  {

	 public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 
	 public void beforeClass() throws Exception {
	
		 LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		  }
	 
	 @Test(groups = { "Regression","High" },priority=1)	
	 public  void SignIntoDoctorLogin() throws Exception {
	
		 DoctorsPageOfZoylo= new DoctorsPage(driver);			
		DoctorsPageOfZoylo.SignIn(DoctorsLogin_username, DoctorsLogin_password);
				
		  }
	 
	 
	 
	 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	  Object[][] retObjArr=TestUtils.getTableArray("TestData\\DoctorAppointment1.xls", "doc", "TC1");
	        return(retObjArr);
	    }



@Test(dataProvider="DP1", priority=2,groups = { "Regression","High" },enabled=false)

public void doctorappointment(String RunMode,String timeslot,String firstname,String lastname,String mobile,String email,String problem){
	 
	  String emailaddress=email;
	  String name=firstname+" "+lastname;
	  System.out.println(name);	  ;
	  String isFound = "true";
	  String isFound1 = "true";
	  
	 driver.findElement(By.id("appointment_appointmentCalendar")) .click();	 
	 
	 if(RunMode.equals("yes")){
		 
	 try {
		for(int i=0;i<=14 && isFound=="true";i++)
		 {
		
			 driver.findElement(By.xpath(".//*[@id='cd-"+i+"']")).click();
			 
			 for(int j=1;j<=3 && isFound1=="true";j++){
				 
				 driver.findElement(By.xpath(".//*[@id='patient-apmt-tabs']/li["+j+"]/div/center/span[1]")).click(); 
				 
				 int slotsize = driver.findElements(By.xpath(".//*[@id='tab-"+j+"']/ul/li")).size();
				 
				 if(slotsize>1)
				 {
					 
					for(int k=1;k<=slotsize;k++) 
					{
						
						
				String textvalue = driver.findElement(By.xpath(".//div[@id='tab-"+j+"']//ul//li["+k+"]//div[@class='apt-tme']")).getText();
				
				
				
				
				if(textvalue.equalsIgnoreCase(timeslot)){
					System.out.println(timeslot);
					System.out.println("Time Slot Found");
					driver.findElement(By.xpath(".//*[@id='tab-"+j+"']/ul/li["+k+"]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstname);
					driver.findElement(By.id("lastName")).sendKeys(lastname);
					driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
					driver.findElement(By.id("email")).sendKeys(email);
					driver.findElement(By.id("problem")).sendKeys(problem);
					driver.findElement(By.id("saveAppiontment")).click();	
				Thread.sleep(2000);
							
				
				
				driver.findElement(By.xpath(".//*[@id='tab-"+j+"']/ul/li["+k+"]/div[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='cancel']")).click();
			
				Thread.sleep(4000);
				
      driver.findElement(By.xpath("//*[@id='cancel-appointment-popup']/div/div/div[3]/select")).sendKeys("Personal reason");
		driver.findElement(By.id("confirmYes")).click();		
				Thread.sleep(5000);
				driver.findElement(By.id("patients_patientsIcon")).click();
				
				driver.findElement(By.id("searchPatientsList")).sendKeys(email);
				 driver.findElement(By.id("searchPatientsList")).sendKeys(Keys.ENTER);
				 driver.findElement(By.xpath(" html/body/div[9]/div[3]/div[2]/div/ul/li[2]")).click();
				 
				 
				 int patientsize= driver.findElements(By.xpath("//*[@id='all']/div")).size();
				 
					String isfound2="true";
					for(int l=1;l<=patientsize && isfound2=="true";l++){
					
					String patientname=	driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[1]/div[2]/div/h1/span")).getText();
					System.out.println(patientname);
					if(patientname.equalsIgnoreCase(firstname+" "+lastname))
					{
						
			String provider=driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).getText();
				if(provider.equalsIgnoreCase("Cancelled By Provider")){
					
					driver.findElement(By.xpath(".//*[@id='all']/div["+l+"]/div[2]/p[1]")).click();
					
					Reporter.log("The Appointment had been Canceled");
					break;
				}
					
				else{
					System.out.println("The Appointment Is Not Cancelled");
					isfound2="false";
				}	
						
				
					}
					
					
					}			
										
									
												
					isFound="false";
					isFound1="false";
					break;				
				}
				else
					
				{
					System.out.println(timeslot);
					System.out.println("Time Slot Not Matched");
					
				}					
					
					}	//for loop	 k
									 
				 }	// if loop		  	 
				 		 			 
			 }	//for loop	 j
		
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Time Slot Not found in 14 Days");
	} 	// for loop  i
	 
}// main method 
	 
	 
	  else {
		  throw new SkipException("RUNMODE IS OFF");
	  }
		 
	 System.out.println(emailaddress); 
	
	 
}

	 
	 
@Test(priority=2)
public void bulkCancellation() throws Exception{
	DoctorsPageOfZoylo.BulkCancel();
	
}
 

	
	
}
