package doctorsTestScripts;

import org.testng.annotations.Test;

import testBase.TestUtils;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DocAppointment {
	
	static WebDriver driver;
	
  @Test
  public void f() throws InterruptedException, IOException {
	  TestUtils ts=new TestUtils(driver);
	  driver.findElement(By.xpath(".//*[@id='listingSearchTextbox']")).sendKeys("doctor");
	  List<WebElement> doctorNames = driver.findElements(By.xpath(".//*[@id='indexContainer']//div[@class='a-s-w']"));
	  for(int i=1;i<=doctorNames.size()+1;i++)
	  {
		String doctorName=driver.findElement(By.xpath(".//*[@id='indexContainer']/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/div/div["+i+"]/span[1]")).getText();
		//System.out.println(doctorName);
		if(doctorName.equals("Dr. Doctor M M"))
		{
			driver.findElement(By.xpath(".//*[@id='indexContainer']/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/div/div["+i+"]")).click();
		
			break;
		}
	  }
		Thread.sleep(4000);
	  driver.findElement(By.xpath(".//*[@id='bookAppointment']/button")).click();
	  Thread.sleep(4000);
	  if(driver.findElement(By.xpath(".//*[@id='cd-0']")).isDisplayed())
	  {
		 
		  for(int i=0;i<=14;i++)
		  {
			  driver.findElement(By.xpath(".//*[@id='cd-"+i+"']")).click();
			  
			  String timeslot="11:00 AM";
			  for(int j=1;j<=7;j=j+2)
				
			  {
				  int size=driver.findElements(By.xpath("//div[@id='accordion']/div["+j+"]/div[2]/ul/li")).size(); 
				  System.out.println(size);
				  List<WebElement> list1=driver.findElements(By.xpath("//div[@id='accordion']/div["+j+"]/div[2]/ul/li/span"));
				  if(size > 1)
				  {
					  for(int k=0;k<=size-1;k++)
					  {
						  System.out.println(list1.get(k).getText());
						  if(list1.get(k).getText().equalsIgnoreCase(timeslot))
						  {
							  list1.get(k).click();
							  Thread.sleep(4000);
							  break;
						  }
					  }
				  }
				  if(driver.findElement(By.xpath(".//*[@id='bookAppointment']")).isDisplayed())
				  {
					  break;
				  }
				  
			  }
			  if(driver.findElement(By.xpath(".//*[@id='bookAppointment']")).isDisplayed())
			  {
				  break;
			  }
		  }
	  }
      driver.findElement(By.xpath(".//*[@id='bookAppointment']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//div[@class='sr-promocode-block']/ul/li[1]/input[@id='applyPromocode']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath("//div[3]/ul/li/input[@value='ICICI']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//*[@id='termsAndConditions']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//*[@id='proceed']")).click();
      Thread.sleep(4000);
     if( driver.findElement(By.xpath("//div[@class='book-dtbox']/h3[1]")).getText().contains("Booking Id"))
     {
    	 System.out.println("Test case passed and booking done");
    	 ts.capturescreenshot("paased test");
     }
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException, IOException {
	  
	  FileInputStream inStream = new FileInputStream(new File("ConfigFiles\\Setup-Details.txt"));
      Properties prop = new Properties();
      prop.load(inStream);
      System.out.println("launching chrome browser");
      System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.get(prop.getProperty("login.url"));
      driver.manage().window().maximize();
      driver.findElement(By.xpath(".//*[@id='emailAddress']")).sendKeys(prop.getProperty("login.username1"));
      driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(prop.getProperty("login.password1"));
      driver.findElement(By.xpath(".//*[@id='zoyloCustLogin-form']//button[@class='signup-btn']")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//*[@id='index']/span[1]/img")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//*[@id='mapIconMenu']/span/img")).click();
      Thread.sleep(4000);
      driver.findElement(By.xpath(".//*[@id='searchFilter']")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
