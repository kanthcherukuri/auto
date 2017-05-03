package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class test extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {	
		
	 LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  }
@Test
public void appointmenthome() throws Exception{
	driver.findElement(By.id(Elements_Diagnostics.clickonappointmentsmenu)).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='material-switch pull-left']")).click();
//
//	WebElement slider = driver.findElement(By.xpath("//div[@class='material-switch pull-left']")); 
//	int widt= slider.getSize().width;
//	System.out.println("width size ="+widt);
//	
//	Actions action = new Actions(driver);
//
//	
//	action.moveToElement(slider);
//	action.click().build().perform();
	
	//Action action = (Action) move.dragAndDropBy(slider, 60, 0).build(); 
	//action.perform();

	
//	WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='material-switch pull-left']"));
//	int numberOfPixelsToDragTheScrollbarDown = 5000;
//	action.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
//    //div[@class='material-switch pull-left']
	
	
    //JavascriptExecutor js = (JavascriptExecutor) driver;

    //WebElement a = driver.findElement(By.xpath("//div[@id='slider-1']/a"));

    //js.executeScript("arguments[0].setAttribute('style', 'left:100%;')",ele);
	
}
}
