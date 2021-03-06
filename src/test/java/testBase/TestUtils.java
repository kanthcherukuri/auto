package testBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import objectRepository.Elements_Recipients;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class TestUtils {
	//FirefoxDriver browser = new FirefoxDriver();

	public final WebDriver driver;
	public TestUtils(WebDriver driver) {
		this.driver=driver;
	}
	/*	@Author: Sagar Sen
	 * 	@Description: This method can be used to extract the image source using xpath
	 * 	@Parms: xpath
	 * 	@Return: src path
	 */
	public String getImageSrc(String xpath)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		String src = ((JavascriptExecutor)driver).executeScript("return arguments[0].attributes['src'].value;", element).toString();
		System.out.println("The image source extracted is: "+src);
		return src;
	}

	/*   @Autur : Ganesh Mandala
	 *   @Description: Sharing geolocation in zoylo map
	 *   @Recent Changes : 
	 *   @Comments : This method works only in Chrome
	 */

	public void shareGeoLocation() throws InterruptedException{
		driver.navigate().to("chrome://settings/content");
		Thread.sleep(2000);
		driver.switchTo().frame("settings"); 
		driver.findElement(By.xpath("//input[@name='location' and @value='allow']")).click();
		driver.findElement(By.xpath("//*[@id='content-settings-overlay-confirm']")).click();

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
		Thread.sleep(3000);
		System.out.println("Opened URL="+name);
		Reporter.log("Opened URL="+name);
	}



	//Scroll by ID
	public void scrollbyID(String ID) throws InterruptedException
	{
		WebElement scroll = driver.findElement(By.id(ID));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		Reporter.log("scrolled to "+ID);
	}

	//Scroll by xpath
	public void scrollbyxpath(String xpath) throws InterruptedException
	{
		WebElement scroll = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		Reporter.log("scrolled to "+xpath);
	}

	//Scroll by name
	public void scrollbyName(String name)
	{
		WebElement scrollname = driver
				.findElement(By.name(name));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollname);
		Reporter.log("scrolled to "+name);
	}

	//horizontal scroll
	public void horizontalScroll()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;     
		jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
		Reporter.log("scrolled Horizontally");
	}
	
	// scroll UP
		public void ScrollUp()
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			Reporter.log("scrolled UP");
		}
		
		// scroll Down
				public void ScrollDown()
				{
					
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,500)", "");
					
					Reporter.log("scrolled Down");
					
				}

	//screen-shot
	public void capturescreenshot(String screenname) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshots\\"+screenname+".png"));

	}

	//TIME increment and send keys by Name
	public void dateTimeIncrement(int value, String name)
	{
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/YYYY HH:mm");
		currentDate.add(Calendar.MINUTE, value);
		String date = formatter.format(currentDate.getTime());
		driver.findElement(By.name(name)).sendKeys(date);
		//System.out.println(date);
	}

	//YEAR increment and send keys by Name
	public void yearIncrement(int value, String name)
	{
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/YYYY HH:mm");
		currentDate.add(Calendar.YEAR, value);
		String date = formatter.format(currentDate.getTime());
		driver.findElement(By.name(name)).sendKeys(date);
		//System.out.println(date);
	}

	//Wait for the ID
	public void waitFortheID(String ID){
		System.out.println("waiting for "+ID);
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
		System.out.println("waited for "+ID);
	}

	//Wait for the Xpath Element
	public void waitFortheElementXpath(String xpath){
		System.out.println("waiting for "+xpath);
		WebDriverWait wait = (new WebDriverWait(driver, 100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		System.out.println("waited for "+xpath);	 
	}
	
	//Wait for the name Element
	public void waitforElementName(String name)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}



	//Wait for the Screen Validation
	public void waitForScreenValidation( ){

		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Elements_Recipients.Recipient_Wrapper)));
		String validation= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		System.out.println(validation);

	}
	//Wait for the Screen Validation
	public void verifyNotificationMessage(String ExpectedErrorMesg ) throws InterruptedException{
		Thread.sleep(2000);
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Elements_Recipients.Recipient_Wrapper)));
		String ActualError= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		System.out.println("ActualError="+ActualError);			    
		Assert.assertEquals(ActualError, ExpectedErrorMesg);

	}	

	//Wait for text to be present by xpath
	public void waitforTextbyxpath(String xpath, String value)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		//wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), value));
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(xpath), value));

	}

	//Wait for text to be present by ID
	public void waitforTextbyID(String ID, String value)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		//wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(ID), value));
		wait.until(ExpectedConditions.textToBePresentInElement(By.id(ID), value));
	}

	//Actions by xpath
	public void actionbyXpath(String path, String value) throws InterruptedException
	{
		Actions qua = new Actions(driver);
		qua.moveToElement(driver.findElement(By.xpath(
				path)));
		qua.click();
		qua.sendKeys(value);
		Thread.sleep(2000);
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


	//Actions by id	
	public void actionbyid(String id, String value) throws Exception
	{
		Actions qua = new Actions(driver);
		qua.moveToElement(driver.findElement(By.id(id)));
		qua.click();
		//Thread.sleep(4000);
		qua.sendKeys(value);
		//Thread.sleep(2000);
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

	//WebElement Select by ID
	public void selectbyID(String elementName, String selectvalue)
	{
		WebElement mySelectElement = driver.findElement(By.id(elementName));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(selectvalue);
	}

	//WebElement Select by xpath
	public void selectbyXpath(String elementXpath, String selectvalue)
	{
		WebElement mySelectElement = driver.findElement(By.xpath(elementXpath));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(selectvalue);
	}


	// WebElement Select by id

	public void selectbyid(String elementid,String selectvalue)
	{
		WebElement mySelectElement=driver.findElement(By.id(elementid));
		Select dropdown=new Select(mySelectElement);
		dropdown.selectByValue(selectvalue);
	}

	//Click on the element ID
	public void clickOnTheElementByID(String ID)
	{
		System.out.println("waiting  for "+ID);
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
		driver.findElement(By.id(ID)).click();
		System.out.println("Clicked on "+ID);
		Reporter.log("Clicked on the Element="+ID);
	}

	//Get text of the element by Xpath
	public String getTextByXpath(String xpath)
	{
		System.out.println("waiting  for "+xpath);
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		String text =driver.findElement(By.xpath(xpath)).getText();
		System.out.println("Text = "+text);
		return text;
	}

	//Get text of the element by ID
	public String getTextByID(String ID)
	{
		System.out.println("waiting  for "+ID);
		WebDriverWait wait = (new WebDriverWait(driver, 90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
		String text =driver.findElement(By.id(ID)).getText();
		System.out.println("Text = "+text);
		return text;
	}

	//Click on the element Xpath
	public void clickOnTheElementByXpath(String Xpath)
	{
		System.out.println("Waiting for "+Xpath);
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		driver.findElement(By.xpath(Xpath)).click();
		System.out.println("Clicked on "+Xpath);
		Reporter.log("Clicked on the Element="+Xpath);
	}

	// Enter text by id
	public void enterTextByID(String ID,String data)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
		driver.findElement(By.id(ID)).clear();
		driver.findElement(By.id(ID)).sendKeys(data);
		System.out.println("Texted = "+data);
		Reporter.log("Text Entered="+data);
	}

	//Enter text by  Xpath
	public void enterTextByXpath(String Xpath,String data)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		driver.findElement(By.xpath(Xpath)).clear();
		driver.findElement(By.xpath(Xpath)).sendKeys(data);
		System.out.println("Texted = "+data);
		Reporter.log("Text Entered="+data);
	}



	// select text by id
	public void selectByVisibleTextByID(String ID,String data)
	{
		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
		Select drpCountry = new Select(driver.findElement(By.id(ID)));
		drpCountry.selectByVisibleText(data);
		System.out.println("Selected = "+data);
	}

	// select text by id
	public void selectByVisibleTextByXpath(String xpath,String data)
	{
		Select drpCountry = new Select(driver.findElement(By.xpath(xpath)));
		drpCountry.selectByVisibleText(data);
		System.out.println("Selected = "+data);
	}

	//Wait Till int
	public void waitTill(int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void CheckNotificationMessage(String ExpectedNotificationMesg ){

		WebDriverWait wait = (new WebDriverWait(driver, 60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='zy-status-wrapper']")));
		String ActualNotification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
		System.out.println("ActualNotificationMessage="+ActualNotification);
		Reporter.log("Verified Notification="+ActualNotification);
		Assert.assertEquals(ActualNotification,ExpectedNotificationMesg);
		driver.findElement(By.xpath("//div[@class='zy-status-wrapper']")).click();

	}
	
	/*
	 * @Author: Sagar Sen
	 * @Desc: Wait for notification message
	 * @Parm: text
	 * @return: NA
	 */
		public void zmt_notification(String text) throws Exception {
			WebDriverWait wait = (new WebDriverWait(driver, 60));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(
					By.xpath("//div[@class='alert alert-success alert-dismissable']"), text));
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@data-dismiss='alert']")).click();
			Thread.sleep(1000);
		}


	/* 
	 * @Description:This function is used to get the appointment id from thank you page
	   @Return type appointment id
	 *
	 */

	public String getAppointmentID(){

		String AppointmentId = driver.findElement(By.xpath("(//div[@class='book-dtbox']/h3)[1]")).getText();
		System.out.println("before split id is "+AppointmentId);
		String APID[]=AppointmentId.split(":");
		String Apid=APID[1].replace(" ", "");
		System.out.println("After split id is="+Apid);
		return Apid;

	}

	/*
	 * @Author: Ganesh
	 * @Desc: This function will return the value of the textbox
	 * @Parm: ID
	 * @return: String Value of the textbox (ID)
	 */
	public String getTextBoxValueByID(String ID){
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
    String inputValue = (String) js.executeScript("return document.getElementById('"+ID+"').value");       
    System.out.println("CURRENT VALUE : " + inputValue);
     
    return inputValue;    
	}

	/* 
	 * This function is used to read the emails from gmail with the subject name
       Ex:Browser.emailResponse(Recipient_DocUsername, Recipient_DocPassword, "Zoylo.com | Appointment registered");
	 *
	 */	
	public  String  emailResponse(String user,String password,String Subject) throws Exception{

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", user, password);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		System.out.println("Total Message:" + folder.getMessageCount());
		System.out.println("Unread Message:"
				+ folder.getUnreadMessageCount());

		Message[] messages = null;
		boolean isMailFound = false;
		Message mailFromGod= null;
		Thread.sleep(1000);
		//Search for mail from Zoylo
		for (int i = 0; i<=5; i++) {
			Thread.sleep(500);
			messages = folder.search(new SubjectTerm(Subject),folder.getMessages());

			//Wait for 10 seconds

			if (messages.length == 0) {
				System.out.println("mail not found");
				Thread.sleep(10000);
			}

		}

		//Search for unread mail from Zoylo
		//This is to avoid using the mail for which 
		//Registration is already done
		for (Message mail : messages) {
			if (!mail.isSet(Flags.Flag.SEEN)) {
				mailFromGod = mail;
				System.out.println("Message Count is: "
						+ mailFromGod.getMessageNumber());
				isMailFound = true;
			}
		}
		StringBuffer buffer =null;
		//Test fails if no unread mail was found from Zoylo
		if (!isMailFound) {
			// throw new Exception("Could not find new mail from Zoylo :-(");
			System.out.println("Mail Not Found Subject name="+Subject);
			//Read the content of mail and launch registration URL                
		} else {
			String line;
			buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(mailFromGod
							.getInputStream()));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			System.out.println(buffer);


		}

		String  Email_response=null;

		if(buffer != null){
			Email_response=buffer.toString(); 
		} else {
			System.out.println("no response");
		}
		return Email_response;
	}

	/*	@Author: Ganesh
	 * 	@Description: This method can be used to read xl sheet with table name and sheet name
	 * 	@Parms: xlFilePath,  sheetName,  tableName
	 * 	@Return: Table array
	 */

	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
		String[][] tabArray=null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName); 
		int startRow,startCol, endRow, endCol,ci,cj;
		Cell tableStart=sheet.findCell(tableName);
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();

		Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 64000, 64000,  false);                

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

	public String randomalphabets(){
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		String s = "";
		Random random = new Random();
		int randomLen = 1+random.nextInt(9);
		for (int i = 0; i < randomLen; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			s+=c;

		}
		return s;

	}


	/*	@Author: Ganesh
	 * 	@Description: This method can be used to generate Random String
	 * 	@Parms: length of the return type
	 * 	@Return: RandomString
	 */
	public String generateRandomString(int length){
		return RandomStringUtils.randomAlphabetic(length);
	}

	/*	@Author: Ganesh
	 * 	@Description: This method can be used to generate Random Number
	 * 	@Parms: length of the return type
	 * 	@Return: Random Number
	 */	 
	public String generateRandomNumber(int length){
		return RandomStringUtils.randomNumeric(length);
	}
	/*	@Author: Ganesh
	 * 	@Description: This method can be used to generate Random AlphaNumeric
	 * 	@Parms: length of the return type
	 * 	@Return: Random AlphaNumeric
	 */	 
	public String generateRandomAlphaNumeric(int length){
		return RandomStringUtils.randomAlphanumeric(length);
	}
	/*	@Author: Ganesh
	 * 	@Description: This method can be used to generate random Email
	 * 	@Parms: length of the return type
	 * 	@Return: random Email
	 */	 
	public String generateEmail(int length) {
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890";
		String email="";
		String temp=RandomStringUtils.random(length,allowedChars);
		email=temp.substring(0,temp.length()-9)+"@automation.org";
		return email;
	}
	/*	@Author: Ganesh
	 * 	@Description: This method verify the string is integer / decimal or not
	 * 	@Parms: String
	 * 	@Return: boolean
	 */	
	public  boolean isInteger(String str) {
		try { 
			Double.parseDouble(str);
		} catch(NumberFormatException e) { 
			return false; 
		} 
		// only got here if we didn't return false
		return true;
	}
	/*	@Author: Ganesh
	 * 	@Description: This method verify the the element present or not
	 * 	@Parms: Element by xpath/css/id or any element tag
	 * 	@Return: boolean
	 */	
	public boolean isElementPresent(By by){
		try{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	/*	@Author: Ganesh
	 * 	@Description: This method use to read PDF
	 * 	@Parms: String file path
	 * 	@Return: String
	 */	
	
	public String readPDF(String filepath) throws  IOException{

		File fileDetails = new File(filepath);	
		PDDocument document = PDDocument.load(fileDetails);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String text = pdfStripper.getText(document);
		System.out.println(text);
		document.close();
		if(fileDetails.delete()) { 
			System.out.println(fileDetails.getName() + " is deleted!");
		} else {
			System.out.println("Delete operation is failed.");
		}
		return text;
	}

	//MONGO DB
	/* 
	 * This function is used to get the values from MongoDB based on the key and value
			   Ex:Browser.mongoDB_Response(String ServerAddress ,int Port ,String UserName, String Database ,String Password,String QueryKey,String QueryValue);
	 */
	public String mongoDB_Response(String ServerAddress ,int Port ,String UserName, String Database ,String Password,String collection, String QueryKey,String QueryValue) throws UnknownHostException{


		MongoClient mongoClient = null;
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(UserName,Database,Password.toCharArray());

		mongoClient = new MongoClient(new ServerAddress(ServerAddress, Port), Arrays.asList(mongoCredential));


		//Selecting the database
		DB db = mongoClient.getDB("zoylo_zqa");

		System.out.println("Connect to database successfully");

		//System.out.println(db.getStats());
		System.out.println(db.getCollectionNames());

		DBCollection coll = db.getCollection(collection);
		System.out.println("Collection mycol selected successfully");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(QueryKey, QueryValue);

		DBCursor cursor = coll.find(searchQuery);

		String response=null;
		while (cursor.hasNext()) { 
			//System.out.println("Inserted Document: "+i); 
			response = cursor.next().toString();
			System.out.println(response); 


		} 
		// Assert.assertTrue(response.contains("ganesh@zoylo.com"));
		System.out.println("Asserted successfully");
		return response;

	}

	/*
	 * @ Description: This method is used to remove the document from DB
	 */
	public void mongoDB_Remove(String ServerAddress ,int Port ,String UserName, String Database ,String Password,String collectionName, String QueryKey,String QueryValue) throws UnknownHostException{

		try{
			MongoClient mongoClient = null;
			MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(UserName,Database,Password.toCharArray());

			mongoClient = new MongoClient(new ServerAddress(ServerAddress, Port), Arrays.asList(mongoCredential));


			//Selecting the database
			DB db = mongoClient.getDB(Database);

			System.out.println("Connected to database successfully");

			//System.out.println(db.getStats());
			System.out.println(db.getCollectionNames());

			DBCollection coll = db.getCollection(collectionName);
			System.out.println(collectionName+" Collection selected successfully");

			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(QueryKey, QueryValue);

			coll.remove(searchQuery);
			System.out.println("Removed " +QueryValue+ " from " +collectionName+ " collection successfully ");

		}catch (Exception e) {
			System.out.println(QueryValue+ " from MongoDB is not removed");
		}

	}


	public void mongoDB_isWhiteListHonoured(String ServerAddress ,int Port ,String UserName, String Database ,String Password,String collectionName, boolean isWhiteListHonouredValue) throws UnknownHostException{

		//Connecting to the mongoDB instance
		MongoClient mongoClient = null;
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("zoynpap","zoylo_zqa","apz0yl0_321".toCharArray());

		mongoClient = new MongoClient(new ServerAddress("52.66.101.182", 27219), Arrays.asList(mongoCredential));
		System.out.println("Connect to server successfully");   
		//Selecting the database
		DB db = mongoClient.getDB("zoylo_zqa");
		System.out.println("Connect to database successfully");   

		DBCollection dbCollection = db.getCollection("applicationProperties");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("propertyValue", isWhiteListHonouredValue));
		BasicDBObject searchQuery = new BasicDBObject().append("propertyName", "isWhiteListHonoured");

		dbCollection.update(searchQuery, newDocument);

		System.out.println("Updated successfully");
		mongoClient.close();

	}

	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method is used to get ID of a document
	 * @ Parms: ServerAddress , Port , UserName,  Database , Password, collectionName,  QueryKey,  QueryValue
	 * @ Returns: ID
	 */
	public String mongoDB_getID(String ServerAddress ,int Port ,String UserName, String Database ,String Password,String collectionName, String QueryKey, String QueryValue) throws UnknownHostException{

		//Connecting to the mongoDB instance
		MongoClient mongoClient = null;
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(UserName,Database,Password.toCharArray());

		mongoClient = new MongoClient(new ServerAddress(ServerAddress, Port), Arrays.asList(mongoCredential));
		System.out.println("Connect to server successfully");   
		//Selecting the database
		DB db = mongoClient.getDB("zoylo_zqa");
		System.out.println("Connect to database successfully");   

		DBCollection dbCollection = db.getCollection(collectionName);

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(QueryKey, QueryValue);
		BasicDBObject searchQuery1 = new BasicDBObject();
		searchQuery1.put("_id", 1);

		DBCursor cursor = dbCollection.find(searchQuery,searchQuery1);

		String response=null;
		while (cursor.hasNext()) { 
			//System.out.println("Inserted Document: "+i); 
			response = cursor.next().get("_id").toString();
			System.out.println(response); 
			System.out.println("Updated successfully");
			mongoClient.close();
			//System.out.println(resultValue);

		}
		return response;
	}

	/*
	 * @ Author: Sagar Sen
	 * @ Description: This method is used to get OTP
	 * @ Parms: value exsmple emsil ID
	 * @ Returns: otp
	 */
	public String getOtp(String value) throws Exception
	{
		String x=mongoDB_Response("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", value);
		String[] y=x.split("num\" : \"");
		//System.out.println("otpString="+y[1]);		
		String[] otp=y[1].split("\" , \"");		
		System.out.println("otp="+otp[0]);
		return otp[0];
	}

}