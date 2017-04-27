package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testfailedclass {

	public class Test001 {
		@BeforeClass 
		public void setup()
		{
			
			System.out.println("setup");
		}
		@Test
		public void Test1()
		{
			AssertJUnit.assertEquals(false, true);
			System.out.println("failed");
		}
	 
		@Test
		public void Test2()
		{
			AssertJUnit.assertEquals(true, true);
			System.out.println("passed");
		}
		@AfterClass 
		public void exit()
		{
			
			System.out.println("exit");
		}
	}
	
	
}
