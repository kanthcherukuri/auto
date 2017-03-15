package doctorsTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
		
public class TC1 {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://zoylo.com");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Find a Doctor")); 		
		}	
		@BeforeClass
		public void beforeTest() {	
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:/Users/Z9149/Downloads/chromedriver.exe");
			driver = new ChromeDriver(); 
		}		
		@AfterClass
		public void afterTest() {
			driver.quit();			
		}		
}	