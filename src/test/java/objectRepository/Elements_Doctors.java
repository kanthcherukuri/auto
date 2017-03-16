package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class Elements_Doctors {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	
	 public static String driverpath;
	 public static String  enrollment_h5 ;
	
		public static WebDriver driver;
		
		
	public static WebDriver Doc_PageProperties()throws Exception{
	   // FileInputStream inStream;
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        
        // Enrollment page elements
         enrollment_h5=prop.getProperty("enrollment.h5");
       
        
        
		return driver;	
        
       
}

}
