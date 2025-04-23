package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

/*
 * Scenario:
 * This program reads key-value pairs from a properties file (`config.properties`) and prints them to the console.
 * It is useful in test automation for managing configuration settings such as URLs, credentials, and test data.
 */

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
// ===========================================================================================================================
// Step 1: Open the properties file in read mode //Location of properties file
// ===========================================================================================================================		
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "\\testdata\\config.properties");	
		
// ===========================================================================================================================
// Step 2: Create an object of the Properties class & load the properties file
// ===========================================================================================================================
		
		Properties propertiesObj=new Properties();
		propertiesObj.load(file);      // Load the properties file into memory
		 
// ===========================================================================================================================
// Step 3: Read specific properties from the file
// ===========================================================================================================================
	
		String url=propertiesObj.getProperty("appURL3");   			    // Fetches the application URL associated with the key "appURL3"
		String emailid=propertiesObj.getProperty("email"); 				// Fetches the email associated with the key "email"
		String pwd=propertiesObj.getProperty("password");  				// Fetches password
		String orid=propertiesObj.getProperty("orderid");  				// Fetches order ID
		String prodname=propertiesObj.getProperty("searchProductName"); // Fetches product name
		
		//System.out.println(url+" "+emailid+" "+pwd+" "+orid+" "+prodname);
// ===========================================================================================================================
// Step 4: Print the key-value pairs from the properties file
// ===========================================================================================================================
		// Print the data in the console
		System.out.println("*********** Config Properties Data ***********");
        System.out.println("appURL3          : " + url);
        System.out.println("email            : " + emailid);
        System.out.println("password         : " + pwd);
        System.out.println("orderid          : " + orid);
        System.out.println("searchProductName: " + prodname);
        
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        
// ===========================================================================================================================
// Step 5: Read and print all keys from the properties file
// 1st Approach - Read all keys using keySet()
// ===========================================================================================================================
        System.out.println("All Property Keys:");
        Set<Object> keys = propertiesObj.keySet(); // Retrieve all keys
        //System.out.println(keys);
        for (Object key : keys) 
        {
            System.out.println(" - " + key);
        }
        System.out.println("--------------------------------------------------------------------");
        
// ===========================================================================================================================
// Step 6: Read and print all values from the properties file
// Reading all the values from properties file
// ===========================================================================================================================
        System.out.println("\nAll Property Values:");
        Collection<Object> values = propertiesObj.values(); // Retrieve all values
        //System.out.println(values);
        for (Object value : values) 
        {
            System.out.println(" - " + value);
        }
        
// ---- Reading all the keys from properties file ---------------------------------------------
        
        //2nd Approach  - Read all keys using stringPropertyNames()
        //Set<String> keys=propertiesObj.stringPropertyNames();
        //System.out.println(keys); //[appURL7, searchProductName, appURL6, orderid, appURL9, appURL8, appURL3, appURL19, appURL2, appURL17, appURL5, appURL18, appURL4, appURL15, appURL16, appURL1, appURL13, appURL14, appURL11, appURL12, password, appURL10, password1, email]

// ===========================================================================================================================
// Step 7: Close the file input stream
// ===========================================================================================================================
        file.close();

        // Indicate successful execution
        System.out.println("\nProperties File Read Successfully!");
	}

}
