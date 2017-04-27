package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.*;
import objectRepository.*;
		
/**
 * This is a POC1S
 * @author Z9149
 *
 */
public class TC1 {		
	    public WebDriver driver;		
		@Test	(groups = { "Medium" })			
		public void testEasy() throws Exception {
			driver.get("http://zoylo.com");  
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("Find a Doctor")); 
			Elements_Doctors.Doc_PageProperties();
			System.out.println("Objects are"+Elements_Doctors.enrollment_h5);
		}	
		@BeforeClass (groups = { "Medium" })	
		public void beforeTest() {	
			//test123
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:/Users/Z9149/Downloads/chromedriver.exe");
			driver = new ChromeDriver(); 
		}		
		@AfterClass(groups = { "Medium" })	
		public void afterTest() {
			driver.quit();			
		}		
}	