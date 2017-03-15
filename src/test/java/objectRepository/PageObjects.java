package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjects {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	
	 public static String driverpath;
	 public static String  home_city,home_area,home_specialization,map_AreaName ;
	
		public static WebDriver driver;
		
		
	public static WebDriver PageProperties()throws Exception{
	   // FileInputStream inStream;
        inStream = new FileInputStream(new File("PageLocators\\HomePageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        
        // Home Page Objects
        home_city=prop.getProperty("home.city");
        home_area=prop.getProperty("home.area");
        home_specialization=prop.getProperty("home.specialization");
        
        
       // Map Page Objects
        map_AreaName=prop.getProperty("map.AreaName");
        
        
        //map_AreaName="id=zy-location-right";
        
        
		return driver;	
        
       
}

}
