package constants;

import java.io.File;
import java.io.FileNotFoundException;

import exceptions.PathDoesNotExistsException;

/**
 * Framework Constants holds all the constant values used within the framework. 
 * If some value needs to be changed or Modified often, then it should be stored in the property files.
 * 
 * 
 * @author Nandhalala.
 * @created on 28 MAY, 2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */

public final class AutoConstants {

	/**
	 * private constructor to avoid external instantiation.
	 */
	private AutoConstants() {}
	
	private static final String PROJECT_PATH = System.getProperty("user.dir");
	
	private static final String SOURCE_PATH = PROJECT_PATH+File.separator+"src";
	
	private static final String MAIN_PATH = SOURCE_PATH+File.separator+"main";
	
	private static final String TEST_PATH = SOURCE_PATH+File.separator+"test";
	
	//private static final String MAIN_JAVA_PATH = MAIN_PATH+File.separator+"java";
	
	private static final String MAIN_RESOURCE_PATH = MAIN_PATH+File.separator+"resources";
	
	//private static final String TEST_JAVA_PATH = TEST_PATH+File.separator+"java";
	
	private static final String TEST_RESOURCE_PATH = TEST_PATH+File.separator+"resources";
	
	private static final String REPORT_PATH = PROJECT_PATH+File.separator+"Reports";
	
	private static final String PASSED_SCREENSHOT_PATH = PROJECT_PATH
									+File.separator+"PassedScreenshots";
	
	private static final String FAILED_SCREENSHOT_PATH = PROJECT_PATH
			+File.separator+"FailedScreenshots";
	
	private static final String DOWNLOAD_PATH = PROJECT_PATH+File.separator+"Downloads";
	
	private static final String CONFIG_Path = TEST_RESOURCE_PATH+File.separator
			+"configuration.properties";
	
	private static final String ENV_Path = TEST_RESOURCE_PATH+File.separator
			+"environment.properties";
	
	private static final String XML_RPT_CONFIG_PATH = MAIN_RESOURCE_PATH
			+File.separator+"ExtentReportConfiguration.xml";
	
	/**
	 * This method provides only Reports folder path to store Report file and 
	 * does not provide any name or report file.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path where to store reports.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getReportsPath() {
		
		if(check_directory(REPORT_PATH))
			return REPORT_PATH;
		
		else
			throw new PathDoesNotExistsException(REPORT_PATH
					+ " does not exists in root folder");
	
	}

	/**
	 * This method provides only screenshot folder path to store or read already 
	 * present report and does not provide any name for screenshot or 
	 * any screenshot.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path where to store passed stepsscreenshots taken during execution.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getPssedScreenshotPath() {
		
		if(check_directory(PASSED_SCREENSHOT_PATH))
			return PASSED_SCREENSHOT_PATH;
		
		else
			throw new PathDoesNotExistsException(PASSED_SCREENSHOT_PATH
					+ " does not exist in the root folder");
	
	}
	
	/**
	 * This method provides only screenshot folder path to store or read already 
	 * present report and does not provide any name for screenshot or 
	 * any screenshot.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path where to store failed steps screenshots taken during execution.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getFailedScreenshotPath() {
		
		if(check_directory(FAILED_SCREENSHOT_PATH))
			return FAILED_SCREENSHOT_PATH;
		
		else
			throw new PathDoesNotExistsException(FAILED_SCREENSHOT_PATH
					+ " does not exist in the root folder");
	
	}
	
	/**
	 * This method provides only downloads folder path and not any files.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path where to store downloaded files.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getDownloadsPath() {
		
		if(check_directory(DOWNLOAD_PATH))
			return DOWNLOAD_PATH;
		
		else
			throw new PathDoesNotExistsException(DOWNLOAD_PATH
					+ " does not exists in root folder");
	
	}
	
	/**
	 * This method provides only main/resource path and not any files.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path of main resource.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getMainResourcePath() {
		
		if(check_directory(MAIN_RESOURCE_PATH))
			return MAIN_RESOURCE_PATH;
		
		else 
			throw new PathDoesNotExistsException(MAIN_RESOURCE_PATH
					+ " does not exists in root folder");
		
	}
	
	/**
	 * This method provides only test/resource path and not any files.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * @return the path of test resource.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getTestResourcePath() {
		
		if(check_directory(TEST_RESOURCE_PATH))
			return TEST_RESOURCE_PATH;
		
		else 
			throw new PathDoesNotExistsException(TEST_RESOURCE_PATH
					+ " does not exists in root folder");
		
	}
	
	/**
	 * This method is to check folder exists and whether it is a folder.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28, 2023.
	 * @param dir provides the file path.
	 * @return whether the path is a folder.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	private static boolean check_directory(String dir) {
		
		File f = new File(dir);
		
		return f.exists()&&f.isDirectory();
		
	}
	
	/**
	 * 
	 * This method checks whether file exsists or not.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21, 2023.
	 * 
	 * @param filepath provides file path.
	 * @return whether file exists or not.
	 * @throws FileNotFoundException.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	private static boolean check_file(String filepath) throws FileNotFoundException {
		
		File f = new File(filepath);
		
		if(f.exists()) {
		
			return true;
		
		}
		
		else {
		
			throw new FileNotFoundException(filepath+" file does not exists");
		
		}
		
	}

	/**
	 * 
	 * This method is used to get configuration file.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 21, 2023.
	 * 
	 * @return configuration.properties file path.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getConfigPath() {
		
		try {
			
			if(check_file(CONFIG_Path))
				return CONFIG_Path;
			
			else 
				throw new PathDoesNotExistsException(CONFIG_Path
						+ " does not exists in root folder");
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}
	
	/**
	 * 
	 * This method is used to get environment file.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 23, 2023.
	 * 
	 * @return environment.properties file path.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getENVPath() {
		
			try {
				
				if(check_file(ENV_Path))
					return ENV_Path;
				
				else 
					throw new PathDoesNotExistsException(ENV_Path
							+ " does not exists in root folder");
			
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			
			}
			
			return null;
	}
	
	/**
	 * 
	 * This method is used to get report configuration file path.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 23, 2023.
	 * 
	 * @return reportconfiguration xml file path.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static String getXMLRPTCONFIGPath() {
		
			try {
				
				if(check_file(XML_RPT_CONFIG_PATH))
					return XML_RPT_CONFIG_PATH;
				
				else 
					throw new PathDoesNotExistsException
					(XML_RPT_CONFIG_PATH + " does not exists in root folder");
			
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			
			}
			
			return null;
	}
	
}
