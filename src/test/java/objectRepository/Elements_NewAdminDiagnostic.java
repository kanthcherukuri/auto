package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDiagnostic 
{
	public static WebDriver driver;
	public static String ClickOnAddDiagnostic,DiagnosticName,ShortName,fullname,email,phone,password,dateofbirth,desc,regno,dateofreg;
	public static String rating,startedyear;
	
	public static WebDriver newAdmin_DiagnosticPageProperties()
	{
	
		ClickOnAddDiagnostic="add";
		DiagnosticName="diagnosticCenterName";
		ShortName="diagnosticCenterShortName";
		fullname="fullName";
		email="email";
		phone="primaryPhoneNumber";
		password="password";
		dateofbirth="dateOfBirth";
		desc="diagnosticCenterDescription";
		regno="registrationNumber";
		dateofreg="dateOfRegistration";
		rating="zoyloRating";
		startedyear="establishedYear";
		
		
		
		
		
		return driver;
	}
}
