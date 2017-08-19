package doctorsTestScripts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class MongoRemove_ZOY2572_DoctorAppointments extends LoadPropMac
{
	public TestUtils Browser;
	public String emailID="kanthzoylo@gmail.com";
	
	@Test()
	public void removeDoctorAppointments() throws Exception
	{
		String docID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "appointment", "providerId", docID);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		Browser= new TestUtils(driver);
	}
}
