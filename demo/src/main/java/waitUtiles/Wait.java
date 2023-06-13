package waitUtiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.CONFIGPROPERTIES;
import constants.WAITSTRATEGY;
import driverUtilities.DriverManager;
import filereaders.ConfigurationReader;

/**
 * All the wait operations that are to be performed on a WebElement
 * 
 * @author Nandhalala.
 * @Created_on 02 JUNE,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class Wait {

	/**
	 * Private constructor to avoid external instantiation.
	 */
	private Wait(){}

	public static WebElement waitFor(WAITSTRATEGY waitstrategy, String xpath) {
		
		int waittimer = Integer
		.parseInt(ConfigurationReader.getProperty(CONFIGPROPERTIES.WaitTime));
		
		Duration waitduration = Duration.ofSeconds(waittimer);
		
		WebElement element = null;
		
		switch(waitstrategy) {
		
		case CLICKABLE:{
			
			element = new WebDriverWait(DriverManager.getDriver(), waitduration)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			break;
			
		}
		
		case PRESENT:{
			
			element = new WebDriverWait(DriverManager.getDriver(), waitduration)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			
			break;
		
		}
		
		case VISIBLE:{
			
			element = new WebDriverWait(DriverManager.getDriver(), waitduration)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			break;
			
		}
		
		default:
			break;
		
		}
		
		return element;
		
	}
	
}
