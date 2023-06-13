package driverUtilities;

import java.util.Objects;

import constants.AutoConstants;
import constants.CONFIGPROPERTIES;
import constants.ENVIRONMENT;
import exceptions.EnvironmentException;
import exceptions.PropertyFileUsageException;
import filereaders.ConfigurationReader;
import filereaders.EnvironmentReader;

/**
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * It is also responsible for 
 * setting the driver variable to DriverManager which handles the thread safety for the 
 * webdriver instance.
 * 
 * @author Nandhalala.
 * @Created_on MAY 21,2023.
 *
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class Driver {

	/**
	 * Private constructor to avoid instantiation
	 */
	private Driver() {}
	
	/**
	 * Launch the browser.
	 * 
	 * @author Nandhalala.
	 * @Created on MAY 23,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static void launchBrowser() {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			
			DriverManager.setDriver(DriverManager.getDriver());
			
		}
		
	}
	
	/**
	 * Close the current thread browser.
	 * 
	 * @author Nandhalala.
	 * @Created on MAY 23,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static void quitBrowser() {
		
		if(Objects.nonNull(DriverManager.getDriver())) {
			
			DriverManager.getDriver().quit();
			
			DriverManager.unload();
			
		}
		
	}
	
	/**
	 * Launch the application url.
	 * 
	 * @author Nandhalala.
	 * @Created on MAY 21,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static void launchApplication() {
		
		String environment = ConfigurationReader
				.getProperty(CONFIGPROPERTIES.Environment);
		
		if(environment.equals("")) {
			
			throw new PropertyFileUsageException("The value for environment"
					+ " is invalid in configuration.properties.\n"
					+"Give valid values like\n\t\"TEST\"\n\t\"DEV\"\n\t\"UAT\"\n\t\"MIRROR\"");
			
		}
		
		ENVIRONMENT[] env = ENVIRONMENT.values();
		
		int count = env.length;
		
		for(int i = 0 ; i < count ; i++){
			
			if(environment.equalsIgnoreCase(env[i].toString())) {
				
				DriverManager.getDriver()
					.get(EnvironmentReader.getProperty(env[i]));
				
			}else if(i == count-1) {
				
				System.out.println("Environment not found");
				
				throw new EnvironmentException("Environment not found in "
						+ AutoConstants.getENVPath());
				
			}
			
		}
		
	}
	
	
}
