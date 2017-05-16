package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY_ApprovalForTest extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	

	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","City Hospital Package","Full Body Test","10000","2"}

			};
		}

	@Test(dataProvider="DP1")
	public void ScheduleHomePickupTestMakeActiveInActive(String RunMode, String testname,String description,String cost,String discount) throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.clickonhomevisitmenu();
		int id=DiagnosticPageZoylo.ScheduleHomeVisitAddTest(testname, description, cost, discount);

		Thread.sleep(1000);
		DiagnosticPageZoylo.ScheduleHomePickupSubmitTestsForApproval(id);
		CloseBrowser();
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver");
		ChromeOptions options = new ChromeOptions(); // Added to remove new chrome warning message
		options.addArguments("disable-infobars");   // Added to remove new chrome warning message
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https:zoyloqa.zoylo.com/login");
		driver.get("https://zoyloqa.zoylo.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("emailAddress")).sendKeys("laKSHMikanth@zoylo.com");
		driver.findElement(By.id("password")).sendKeys("Zoylo@123");	
		driver.findElement(By.xpath("//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='collapseThree']/div/ul/li[7]/a")).click();
		int tablesize=driver.findElements(By.xpath("//*[@id='DataTables_Table_1']/tbody/tr")).size();
		for(int i=1;i<=tablesize;i++){
			driver.findElement(By.xpath("//*[@id='DataTables_Table_1']/tbody/tr["+i+"]/td[2]")).getText();
			driver.findElement(By.xpath(".//*[@id='DataTables_Table_1']/tbody/tr["+i+"]/td[3]")).getText();
		}
		
		
	}
	
	@AfterClass
	  public void CloseBrowser() {
		driver.close();
	  }
}
