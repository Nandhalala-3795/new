package driverUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import constants.AutoConstants;
import constants.CONFIGPROPERTIES;
import exceptions.PropertyFileUsageException;
import filereaders.ConfigurationReader;

/**
 * To create driver option and to get them
 * 
 * @author Nandhalala.
 * @created on 24 MAY,2023
 *
 * @Last_Modified_by.
 * @Last_Modified_on.
 *
 * @version 1.0
 * @since 1.0
 */
class DriverOptions {

	/**
	 * Private variables initialized to add desired capabilities.
	 */
	private static ChromeOptions chromeOptions = new ChromeOptions();
	
	private static EdgeOptions edgeOptions = new EdgeOptions();
	
	private static Map<String, String> prefs = new HashMap<>();
	
	private static List<String> options = new ArrayList<>();
	
	/**
	 * Load all the capabilities.
	 */
	static {
		
		prefs.put("download.default_directory", AutoConstants.getDownloadsPath());
		
		if(getHeadlessoption()) {
			
			options.add("--headless");
			options.add("--window-size=1920,1200");
			
		}
		
		chromeOptions.addArguments(options);//set chromeoptions for chrome browser
		chromeOptions.setExperimentalOption("prefs", prefs);//Set default download directory for chrome browser
		
		edgeOptions.addArguments(options);//set edgeoptions for edge browser
		edgeOptions.setExperimentalOption("prefs", prefs);//Set default download directory for edge browser
		
	}
	
	/**
	 * This method will get whether to run in headless mode or not.
	 * 
	 * @author Nandhalala.
	 * @created on 24 MAY,2023.
	 * 
	 * @return headless mode.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0
	 */
	private static boolean getHeadlessoption() {
				
		String headless = ConfigurationReader.
				getProperty(CONFIGPROPERTIES.Headless);
		
		if (headless.equals("")) {
			
			return false;
			
		}
		
		else if(headless.equalsIgnoreCase("YES")||
				headless.equalsIgnoreCase("Y")) {
			
			return true;
			
		}else if(headless.equalsIgnoreCase("NO")||
				headless.equalsIgnoreCase("N")) {
			
			return false;
			
		}else {
			
			throw new PropertyFileUsageException("The Value for "
					+CONFIGPROPERTIES.Headless
					+" is not valid in configuration.properties file. \n If you wish to run in headless "
					+ "give value YES or else give NO");
			
		}
		
	}

	/**
	 * This method is used to get the desired chromeoptions for Google chrome browser.
	 * 
	 * @author Nandhalala.
	 * @created on 24 MAY,2023.
	 * 
	 * @return chromeoptions for chrome browser.
	 *
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0
	 */
	static ChromeOptions getCHROMEOPTIONS() {
		
		return chromeOptions;
		
	}
	
	/**
	 * This method is used to get the desired edgeoptions for Microsoft edge browser.
	 * 
	 * @author Nandhalala.
	 * @created on 24 MAY,2023.
	 * 
	 * @return edgeoptions for chrome browser.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	static EdgeOptions getEDGEOPTIONS() {
		
		return edgeOptions;
		
	}
	
}
