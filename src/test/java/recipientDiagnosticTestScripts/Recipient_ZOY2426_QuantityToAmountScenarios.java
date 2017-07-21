package recipientDiagnosticTestScripts;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Recipient_ZOY2426_QuantityToAmountScenarios extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public String[] totalCostOnBookPay, totalCostOnBookPay3, totalCostOnBookPay2, pkgCostOnPaymentHeresplit, testCostOnPaymentHeresplit, totalCostOnPaymentsplit, totalCostOnThankYouPagesplit;
	public int totalCostOnBookPayValue;
	public String testCost, packageCost, testCostOnBookPay, packageCostOnBookPay, totalCost, packageCostOnBookPay3, testCostOnBookPay3, totalCost3, packageCostOnBookPay2, testCostOnBookPay2, totalCost2, pkgQntyOnPayment, testQntyOnPayment, pkgCostOnPaymentHere, testCostOnPaymentHere, totalCostOnPayment, pkgQntyOnThankYouPage, testQntyOnThankYouPage, totalCostOnThankYouPage;
	public int ActualTestCostValue, ActualPackageCostValue, testCostOnBookPayValue, packageCostOnBookPayValue, ActualTotal, packageCostOnBookPayValue3, testCostOnBookPayValue3, totalCostOnBookPayValue3, ActualTotal3, testCostOnBookPayValue2, packageCostOnBookPayValue2, totalCostOnBookPayValue2, ActualTotal2, pkgCostOnPaymentHereValue, testCostOnPaymentHereValue, totalCostOnPaymentValue, totalCostOnThankYouPageValue;
	
	@Test(priority=1)
	public void testPackageInitialAmount() throws Exception
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DoctorClusters);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		String dcName=Browser.getTextByXpath(Elements_Recipients.dcNameOnProfilePage);
		//Capture test and package amount
		testCost=Browser.getTextByXpath(Elements_Recipients.recipient_DCTestCost);
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCPackageTab);
		packageCost=Browser.getTextByXpath(Elements_Recipients.recipient_DCPackageCost);
		System.out.println("Test cost is: "+testCost);
		System.out.println("Package cost is: "+packageCost);
		RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg"); //Select Slot
		//Convert string value to int of costs
		ActualTestCostValue = Integer.parseInt(testCost);
		ActualPackageCostValue = Integer.parseInt(packageCost);
		//Capture test and package individual costs on book and pay page
		packageCostOnBookPay=Browser.getTextByXpath(Elements_Recipients.recipient_DCPackageCostOnBookPay);
		testCostOnBookPay=Browser.getTextByXpath(Elements_Recipients.recipient_DCTestCostOnBookPay);
		//Convert string value to int of costs
		testCostOnBookPayValue=Integer.parseInt(testCostOnBookPay);
		packageCostOnBookPayValue=Integer.parseInt(packageCostOnBookPay);
		Assert.assertEquals(ActualTestCostValue, testCostOnBookPayValue);
		Assert.assertEquals(ActualPackageCostValue, packageCostOnBookPayValue);
		ActualTotal=packageCostOnBookPayValue+testCostOnBookPayValue;
		System.out.println("Total amount is: "+ActualTotal);
		totalCost=Browser.getTextByXpath(Elements_Recipients.recipient_DCTotalCost);
		totalCostOnBookPay=totalCost.split("\\.");
		System.out.println("Total cost on book and pay: "+totalCostOnBookPay[0]);
		totalCostOnBookPayValue=Integer.parseInt(totalCostOnBookPay[0]);
		Assert.assertEquals(ActualTotal, totalCostOnBookPayValue);
	}
	
	@Test(priority=2)
	public void validateTestPackageCostsfor3quantity() throws Exception
	{
		//Increase package quantity to 3
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCPackageUp);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCPackageUp);
		Thread.sleep(500);
		//Increase test quantity to 3
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCTestUp);
		Thread.sleep(500);
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCTestUp);
		Thread.sleep(500);
		//Capture test and package individual costs on book and pay page
		packageCostOnBookPay3=Browser.getTextByXpath(Elements_Recipients.recipient_DCPackageCostOnBookPay);
		testCostOnBookPay3=Browser.getTextByXpath(Elements_Recipients.recipient_DCTestCostOnBookPay);
		//Convert string value to int of costs
		testCostOnBookPayValue3=Integer.parseInt(testCostOnBookPay3);
		packageCostOnBookPayValue3=Integer.parseInt(packageCostOnBookPay3);
		totalCost3=Browser.getTextByXpath(Elements_Recipients.recipient_DCTotalCost);
		totalCostOnBookPay3=totalCost3.split("\\.");
		System.out.println("Total cost on book and pay: "+totalCostOnBookPay3[0]);
		totalCostOnBookPayValue3=Integer.parseInt(totalCostOnBookPay3[0]);
		ActualTotal3=packageCostOnBookPayValue3+testCostOnBookPayValue3;
		System.out.println("Total amount after quantity increased to 3 is: "+ActualTotal3);
		Assert.assertEquals(ActualTotal3, totalCostOnBookPayValue3);
		Thread.sleep(500);
	}
	
	@Test(priority=3)
	public void validateTestPackageCostsfor2quantity() throws Exception
	{
		//Decrease package quantity by 1
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCPackageDown);
		Thread.sleep(500);
		//Decrease test quantity by 1
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCtestDown);
		Thread.sleep(500);
		//Capture test and package individual costs on book and pay page
		packageCostOnBookPay2=Browser.getTextByXpath(Elements_Recipients.recipient_DCPackageCostOnBookPay);
		testCostOnBookPay2=Browser.getTextByXpath(Elements_Recipients.recipient_DCTestCostOnBookPay);
		//Convert string value to int of costs
		testCostOnBookPayValue2=Integer.parseInt(testCostOnBookPay2);
		System.out.println("Test cost after decrease 1 "+testCostOnBookPayValue2);
		packageCostOnBookPayValue2=Integer.parseInt(packageCostOnBookPay2);
		totalCost2=Browser.getTextByXpath(Elements_Recipients.recipient_DCTotalCost);
		totalCostOnBookPay2=totalCost2.split("\\.");
		System.out.println("Total cost on book and pay: "+totalCostOnBookPay2[0]);
		totalCostOnBookPayValue2=Integer.parseInt(totalCostOnBookPay2[0]);
		ActualTotal2=packageCostOnBookPayValue2+testCostOnBookPayValue2;
		System.out.println("Total amount after quantity decreased by 1 is: "+ActualTotal2);
		Assert.assertEquals(ActualTotal2, totalCostOnBookPayValue2);
		Thread.sleep(500);
	}
	
	@Test(priority=4)
	public void testPackageAmountOnPaymentPage() throws Exception
	{
		RecipientPage.confirmAppointmentOnDiagnostics();
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCHereOnPayment);
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DCTestPkgHeaderOnPayment);
		pkgQntyOnPayment=Browser.getTextByXpath(Elements_Recipients.recipient_DCPackageQntyOnPayment);
		testQntyOnPayment=Browser.getTextByXpath(Elements_Recipients.recipient_DCtestQntyOnPayment);
		Assert.assertEquals(pkgQntyOnPayment, "2");
		Assert.assertEquals(testQntyOnPayment, "2");
		pkgCostOnPaymentHere=Browser.getTextByXpath(Elements_Recipients.recipient_DCpkgCostOnPayment);
		pkgCostOnPaymentHeresplit=pkgCostOnPaymentHere.split("\\.");
		pkgCostOnPaymentHereValue=Integer.parseInt(pkgCostOnPaymentHeresplit[0]);
		Assert.assertEquals(packageCostOnBookPayValue2, pkgCostOnPaymentHereValue);
		testCostOnPaymentHere=Browser.getTextByXpath(Elements_Recipients.recipient_DCtestCostOnPayment);
		testCostOnPaymentHeresplit=testCostOnPaymentHere.split("\\.");
		testCostOnPaymentHereValue=Integer.parseInt(testCostOnPaymentHeresplit[0]);
		Assert.assertEquals(testCostOnBookPayValue2, testCostOnPaymentHereValue);
		totalCostOnPayment=Browser.getTextByXpath(Elements_Recipients.recipient_DCTotalCostOnPayment);
		totalCostOnPaymentsplit=totalCostOnPayment.split("\\.");
		totalCostOnPaymentValue=Integer.parseInt(totalCostOnPaymentsplit[0]);
		Assert.assertEquals(totalCostOnPaymentValue, ActualTotal2);
		Thread.sleep(500);
	}
	
	@Test(priority=5)
	public void testPackageAmountOnThankYouPage() throws Exception
	{
		RecipientPage.makePayment();
		pkgQntyOnThankYouPage=Browser.getTextByXpath(Elements_Recipients.recipient_DCThankYouPagePKGQnty);
		Assert.assertEquals(pkgQntyOnThankYouPage, "2");
		testQntyOnThankYouPage=Browser.getTextByXpath(Elements_Recipients.recipient_DCThankYouPageTestQnty);
		Assert.assertEquals(testQntyOnThankYouPage, "2");
		totalCostOnThankYouPage=Browser.getTextByXpath(Elements_Recipients.recipient_DCTotalOnThankYouPage);
		totalCostOnThankYouPagesplit=totalCostOnThankYouPage.split("\\.");
		totalCostOnThankYouPageValue=Integer.parseInt(totalCostOnThankYouPagesplit[0]);
		Assert.assertEquals(ActualTotal2, totalCostOnThankYouPageValue);
		Thread.sleep(6000);
	}

	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}