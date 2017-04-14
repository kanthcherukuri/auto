package objectRepository;

import org.openqa.selenium.WebDriver;

public class Elements_Admin 
{
	public static WebDriver driver;
	public static String link_Catalogues,link_catalogs_Doctors,button_addDoctor;
	public static String radio_docotrAssociatedwithHospital,button_doctorInformation,button_AdditionalInformation,button_facilities,button_address,button_SEO,button_DoctorSave,button_DoctorCancel;
	
	public static WebDriver Admin_PageProperties()
	{
		
		link_Catalogues="//h4[contains(., 'Catalogues')]";
		link_catalogs_Doctors="//a[text()='Doctors']";
		button_addDoctor="//button[contains(., 'Add Doctor')]";
		radio_docotrAssociatedwithHospital="//input[@value='hospital']";
		button_doctorInformation=".//*[@id='doctorInformationDiv']/button";
		button_AdditionalInformation="additionalInformationDiv"; //IDs
		button_facilities="facilitiesDiv"; //ID
		button_address="addressDiv"; //ID
		button_SEO="seoInformationDiv"; //ID
		button_DoctorSave="adminProviderSubmit"; //ID
		button_DoctorCancel="submitCancel"; //ID
		
		return driver;
	}
	
	
}
