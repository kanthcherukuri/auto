package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import testBase.LoadProp;


public class Elements_Home  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String home_city,home_area,home_specialization,map_AreaName;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
		
	public static WebDriver Home_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		
         // Home page elements 
         home_city="search-city";         
         home_area="search-area";
         home_specialization="name";
         map_AreaName="zy-location-right";
       
        
		return driver;	
        
       
}

}
