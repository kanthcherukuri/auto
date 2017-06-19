package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_NewAdminDiagnostic 
{
	public static WebDriver driver;
	public static String Diagnostic_ClickOnAddDiagnostic,DiagnosticCenter_Name,DiagnosticCenter_ShortName,DiagnosticCenter_fullname,DiagnosticCenter_email,DiagnosticCenter_phone,DiagnosticCenter_password;
	public static String MandatoryFields_dateofbirth, MandatoryFields_desc, MandatoryFields_regno, MandatoryFields_dateofreg;
	public static String MandatoryFields_StatusCode,MandatoryFields_languagesSpoken,MandatoryFields_rating,MandatoryFields_startedyear;
	
	public static WebDriver newAdmin_DiagnosticPageProperties()
	{
	
		Diagnostic_ClickOnAddDiagnostic="add";
		DiagnosticCenter_Name="diagnosticCenterName";
		DiagnosticCenter_ShortName="diagnosticCenterShortName";
		DiagnosticCenter_fullname="fullName";
		DiagnosticCenter_email="email";
		DiagnosticCenter_phone="primaryPhoneNumber";
		DiagnosticCenter_password="password";
		
		//MandatoryFields
		MandatoryFields_dateofbirth="dateOfBirth";
		MandatoryFields_desc="diagnosticCenterDescription";
		MandatoryFields_regno="registrationNumber";
		MandatoryFields_dateofreg="dateOfRegistration";
		MandatoryFields_StatusCode="zoyloStatusCode";
		MandatoryFields_languagesSpoken="languagesSpoken";
		MandatoryFields_rating="zoyloRating";
		MandatoryFields_startedyear="establishedYear";
		
		
		
		
		
		return driver;
	}
}
