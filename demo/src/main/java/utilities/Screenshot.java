package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import constants.AutoConstants;
import constants.LOGTYPE;
import driverUtilities.DriverManager;
import exceptions.ScreenShotFileNULLException;

/**
 * Utility to capture screenshot in png and base 64 format to attach in report.
 * 
 * @author Nandhalala.
 * @created on MAR 28, 2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0
 * @since 1.0
 *
 */
@SuppressWarnings("unused")
public final class Screenshot {

	/**
	 * A String to store Base 64 format
	 */
	private static String encodedBase64 = null;
	
	/**
	 * File Input stream to store the file as stream
	 */
	private static FileInputStream fis = null;
	
	/**
	 * Destination file path to store the screenshot
	 */
	private static File destination = null;
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private Screenshot() {}
	
	/**
	 * Takes screenshot, saves it in png format and also encode it in base64 
	 * format to attach in the report
	 * Use this only in Listeners
	 * 
	 * @author Nandhalala.
	 * @created on APR 02, 2023.
	 * 
	 * @param Testcasename gives test case name which is method name.
	 * @param driver instance on which screenshot is taken.
	 * @return base64 format of the image.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 *
	 * @since 1.0.
	 */
	public static String takeScreenshot(String Testcasename,Status status) {
		
		try {
			
			String datetime = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss z")
				.format(new Date());
			
			WebDriver driver = DriverManager.getDriver();
			
			TakesScreenshot scrsht = (TakesScreenshot) driver;
			
			File source = scrsht.getScreenshotAs(OutputType.FILE);
			
			String destinationpath = null;
			
			if(status.toString().equalsIgnoreCase("PASS")) {
			
				destinationpath = AutoConstants.getPssedScreenshotPath()
						+"//"+Testcasename+" "+datetime+".png";
			
			}else if(status.toString().equalsIgnoreCase("FAIL")) {
			
				destinationpath = AutoConstants.getFailedScreenshotPath()
						+"//"+Testcasename+" "+datetime+".png";
			
			}
			
			if(Objects.isNull(destinationpath)) {
			
				throw new ScreenShotFileNULLException("Destination path is NULL");
			
			}
			
			destination = new File(destinationpath);
			
			FileUtils.copyFile(source, destination);
			
			fis = new FileInputStream(destination);
			
			byte [] filebytes = new byte[(int)destination.length()];
			
			fis.read();
			
			encodedBase64 = new String(Base64.encodeBase64String(filebytes));
			
			fis.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
		
		if(Objects.nonNull(encodedBase64))
			return encodedBase64;
		
		else
			throw new ScreenShotFileNULLException("Encoded base64 file is null");
		
	}
	
	/**
	  * If not need to save the screenshot use this method.
	  * This method will directly take screenshot as Base64 file.
	  * 
	  * @author Nandhalala.
	  * @Created_on 28 MAY,2023.
	  * 
	  * @return screenshot in base64 format.
	  * 
	  * @Last_Modified_by.
	  * @Last_Modified_on.
	  * @since 1.0.
	  */
	public static String takeScreenshot() {
		
		return ((TakesScreenshot)DriverManager.getDriver())
				.getScreenshotAs(OutputType.BASE64);
		
	}
	
	
}
