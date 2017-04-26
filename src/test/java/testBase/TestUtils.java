package testBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import objectRepository.Elements_Recipients;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestUtils {
	//FirefoxDriver browser = new FirefoxDriver();
	
	public final WebDriver driver;
	public TestUtils(WebDriver driver) {
		this.driver=driver;
	}
  

	
	
	
	//links
	public void clickLink(String link){
		driver.findElement(By.linkText(link)).click();
	}
    //button
	public void clickButtonWithName(String name){
		driver.findElement(By.name(name)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	}
	//Open Browser
	public void openUrl(String name) throws InterruptedException{
		driver.get(name);
		Thread.sleep(5000);
		System.out.println("Opened URL="+name);
	}
	
	//Scroll by ID
	public void scrollbyID(String ID)
	{
		WebElement scroll = driver.findElement(By.id(ID));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
	}
	
	//Scroll by xpath
		public void scrollbyxpath(String xpath)
		{
			WebElement scroll = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		}
	
	//Scroll by name
		public void scrollbyName(String name)
		{
			WebElement scrollname = driver
					.findElement(By.name(name));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollname);
		}
		
	
	
	//screen-shot
	public void capturescreenshot(String screenname) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshots\\"+screenname+".png"));

	}
	
	//Wait for the ID
	public void waitFortheID(String ID){
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		 wait.until(ExpectedConditions.elementToBeClickable(By.id(ID)));
	}
	
	//Wait for the Xpath Element
		public void waitFortheElementXpath(String xpath){
			WebDriverWait wait = (new WebDriverWait(driver, 60));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
					 
		}
		
	//Wait for the name Element
		public void waitforElementName(String name)
		{
			WebDriverWait wait = (new WebDriverWait(driver, 60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
		}
		
		
		
		//Wait for the Screen Validation
		public void waitForScreenValidation( ){
			
					WebDriverWait wait = (new WebDriverWait(driver, 30));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Elements_Recipients.Recipient_Wrapper)));
					String validation= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
				  
				}
		//Wait for the Screen Validation
		public void verifyNotificationMessage(String ExpectedErrorMesg ){
					
			WebDriverWait wait = (new WebDriverWait(driver, 1000));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Elements_Recipients.Recipient_Wrapper)));
			String ActualError= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			System.out.println("ActualError="+ActualError);			    
			Assert.assertEquals(ExpectedErrorMesg, ActualError);
	
						}	
		//Wait for text to be present by xpath
		public void waitforTextbyxpath(String xpath, String value)
		{
			WebDriverWait wait = (new WebDriverWait(driver, 20));
			wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), value));
			//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), value));
		}
		
		//Wait for text to be present by ID
				public void waitforTextbyID(String ID, String value)
				{
					WebDriverWait wait = (new WebDriverWait(driver, 20));
					wait.until(ExpectedConditions.textToBePresentInElement(By.id(ID), value));
				}
		
		//Actions by xpath
				public void actionbyXpath(String path, String value)
				{
					Actions qua = new Actions(driver);
					qua.moveToElement(driver.findElement(By.xpath(
							path)));
					qua.click();
					qua.sendKeys(value);
					qua.sendKeys(Keys.ENTER);
					qua.build().perform();
				}
				
		//Actions by name
				public void actionbyname(String name, String value)
				{
					Actions qua = new Actions(driver);
					qua.moveToElement(driver.findElement(By.name(
							name)));
					qua.click();
					qua.sendKeys(value);
					qua.sendKeys(Keys.ENTER);
					qua.build().perform();
				}
				
		//close second tab
				public void closeSecondTab()
				{
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
				    driver.switchTo().window(tabs2.get(1));
				    driver.close();
				    driver.switchTo().window(tabs2.get(0));
				}
		
		//WebElement Select by name
				public void selectbyName(String elementName, String selectvalue)
				{
					WebElement mySelectElement = driver.findElement(By.name(elementName));
					Select dropdown= new Select(mySelectElement);
					dropdown.selectByVisibleText(selectvalue);
				}
		
	//Wait Till int
	public void waitTill(int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void CheckNotificationMessage(String ExpectedNotificationMesg ){
		
		WebDriverWait wait = (new WebDriverWait(driver, 1000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
		String ActualNotification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		System.out.println("ActualNotificationMessage="+ActualNotification);
		//SoftAssert assertion=new SoftAssert();
		//assertion.assertEquals(ExpectedNotificationMesg,ActualNotification);
		//assertion.assertAll();
	    Assert.assertEquals(ExpectedNotificationMesg,ActualNotification);
		
	}
	
	
	
	 public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
		    String[][] tabArray=null;
		    
		        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		        Sheet sheet = workbook.getSheet(sheetName); 
		        int startRow,startCol, endRow, endCol,ci,cj;
		        Cell tableStart=sheet.findCell(tableName);
		        startRow=tableStart.getRow();
		        startCol=tableStart.getColumn();

		        Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

		        endRow=tableEnd.getRow();
		        endCol=tableEnd.getColumn();
		        System.out.println("startRow="+startRow+", endRow="+endRow+", " +
		                "startCol="+startCol+", endCol="+endCol);
		        tabArray=new String[endRow-startRow-1][endCol-startCol-1];
		        ci=0;

		        for (int i=startRow+1;i<endRow;i++,ci++){
		            cj=0;
		            for (int j=startCol+1;j<endCol;j++,cj++){
		                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
		            }
		        }
		    

		    return(tabArray);
		}





	
    
}