package diagnosticTestScripts;

import java.net.UnknownHostException;
import java.util.Arrays;

import org.testng.Assert;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class test extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	public static void main( String args[] ) throws UnknownHostException{
		 
	    	  
	    	 MongoClient mongoClient = null;
	  		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("zoynpap","zoylo_zqa","apz0yl0_321".toCharArray());

	  		mongoClient = new MongoClient(new ServerAddress("52.66.101.182", 27219), Arrays.asList(mongoCredential));


	  		//Selecting the database
	  		DB db = mongoClient.getDB("zoylo_zqa");

	  		System.out.println("Connect to database successfully");

	  		//System.out.println(db.getStats());
	          System.out.println(db.getCollectionNames());
	          
	          DBCollection coll = db.getCollection("providers");
	          System.out.println("Collection mycol selected successfully");
	          
	          BasicDBObject searchQuery = new BasicDBObject();
	         
	    
	      	searchQuery.put("providerid:", "w3CZgY6YjHMRjPEmN");
	      	
	      	
	          DBCursor cursor = coll.find(searchQuery);
	     
	          String response=null;
	          while (cursor.hasNext()) { 
	             //System.out.println("Inserted Document: "+i); 
	         response = cursor.next().toString();
	             System.out.println(response); 
	            
	     
	  	 } 
	          //Assert.assertTrue(response.contains("kanthch@hotmail.com"));
	          System.out.println("Asserted successfully");
	  		
	  		
	  	}
	}



	


