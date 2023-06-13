package driverUtilities;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import exceptions.DriverNullException;

/**
 * 
 * To get thread safety for the WebDriver.
 * 
 * @author Nandhalala.
 * @Created on MAY 21,2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 *
 */
public final class DriverManager {

	/**
	 * Private constructor to avoid instantiation
	 */
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21, 2023.
	 * 
	 * @param driverReference instance that needs to saved from Thread safety issues.
	 *  
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0
	 * 
	 */
	static void setDriver(WebDriver driverReference) {
		
		if(Objects.nonNull(driverReference)) {
			
			driver.set(driverReference);
			
		}else if(Objects.isNull(driverReference)) {
			
			throw new DriverNullException("Driver Reference is NULL");
			
		}
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21, 2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	static void unload() {
		
		driver.remove();
	
	}
	
	/**
	 * Returns the thread safe WebDriver instance fetched from ThreadLocal variable.
	 * 
	 * @author Nandhalala.
	 * @Created on MAY 21, 2023.
	 * 
	 * @return WebDriver instance.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static WebDriver getDriver() {
		
		return driver.get();
	
	}
	
}
