package diagnosticTestScripts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.LoadPropMac;
import testBase.TestUtils;

//@Author: Sagar Sen

public class MongoRemove_ZOY2572_DiagnosticsAppointments extends LoadPropMac
{
	public TestUtils Browser;
	public String emailID="honeytestdg@gmail.com";
	
	@Test()
	public void removeDoctorAppointments() throws Exception
	{
		String dcID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyDiagnosticCenters", "user.email", emailID);
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyDiagnosticCenterAppointments", "diagnosticCenterId", dcID);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		Browser= new TestUtils(driver);
	}
}
