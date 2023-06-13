package driverUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import constants.CONFIGPROPERTIES;
import exceptions.InvalidBrowserNameException;
import filereaders.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * TO perform actions like statr, close on driver.
 * 
 * @author Nandhalala.
 * @Created on MAY 22,2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */

public final class DriverFactory {

	/**
	 * Private constructor to avoid instantiation
	 */
	private DriverFactory() {}
	
	/**
	 * To initialize the browser.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 22,2023.
	 * 
	 * @param BrowserName.
	 * @return instance of the webdriver.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0
	 */
	public static WebDriver getDRIVER() {
		
		String BrowserName = ConfigurationReader
				.getProperty(CONFIGPROPERTIES.Browser);
		
		WebDriver driver = null;
		
		if(BrowserName.equalsIgnoreCase("CHROME")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver(DriverOptions.getCHROMEOPTIONS());
			
		}
		
		else if(BrowserName.equalsIgnoreCase("EDGE")) {
			
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver(DriverOptions.getEDGEOPTIONS());
		
		}
		
		else {
			
			throw new InvalidBrowserNameException(BrowserName 
					+ " is not a valid browser \nThe valid browser names are "
					+ "\nCHROME\nEDGE\nFIREFOX");
			
		}
		
		return driver;
		
	}
		
}
