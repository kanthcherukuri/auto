package doctorsTestScripts;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

		
/**
 * This is a POC1S
 * @author Z9149
 *
 */
public class TC1 {		
	    public WebDriver driver;	
	    
	    @BeforeClass
		public void openbrowser() throws Exception{
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions(); // Added to remove new chrome warning message
			options.addArguments("disable-infobars");   // Added to remove new chrome warning message
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https:zoyloqa.zoylo.com/login");
			driver.findElement(By.id("emailAddress")).sendKeys("sampoornemail@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys("Zoylo@123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div/button")).click();
			Thread.sleep(3000);

	}
		
		@Test
		public void checkbulkcancel() throws Exception{
			
			Date today = new Date(); 
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(today);  
			calendar.add(Calendar.MONTH, 1);  
			calendar.set(Calendar.DAY_OF_MONTH, 1);  
			calendar.add(Calendar.DATE, -1);  
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			Date lastDayOfMonth = calendar.getTime(); 
			String date=sdf.format(today);
			String enddate= sdf.format(lastDayOfMonth);
			System.out.println(date);
			System.out.println(enddate);
			driver.findElement(By.id("appointments")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("html/body/div[6]/div[4]/div/div[1]/div/div/div[2]/div/div[1]/div[3]/i")).click();
			Thread.sleep(1000);
			Actions qua = new Actions(driver);
			qua.moveToElement(driver.findElement(By.xpath("//*[@id='bulk_cancel_fromDate']")));
			qua.click();
			qua.sendKeys(date);
			Thread.sleep(1000);
			qua.sendKeys(Keys.ENTER);
			qua.build().perform();
			Thread.sleep(2000);
			Actions qua1 = new Actions(driver);
			qua1.moveToElement(driver.findElement(By.xpath("//*[@id='bulk_cancel_toDate']")));
			qua1.click();
			qua1.sendKeys(enddate);
			Thread.sleep(1000);
			qua1.sendKeys(Keys.ENTER);
			qua1.build().perform();
			Thread.sleep(2000);
			driver.findElement(By.id("bulk_cancel_fromTime")).sendKeys("07:00");
			Thread.sleep(2000);
			driver.findElement(By.id("bulk_cancel_toTime")).sendKeys("23:00");
			Thread.sleep(2000);
			driver.findElement(By.id("bulkCancel_submit")).click();
			
			
			
		}	
}	