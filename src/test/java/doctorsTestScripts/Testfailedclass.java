package doctorsTestScripts;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


public class Testfailedclass {

	public class Test001 {
		@BeforeClass 
		public void setup()
		{
			
			System.out.println("setup");
		}
	
		@AfterClass 
		public void exit()
		{
			
			System.out.println("exit");
		}
	}
	
	
}
