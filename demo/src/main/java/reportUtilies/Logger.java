package reportUtilies;

import java.util.function.Consumer;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import constants.CONFIGPROPERTIES;
import constants.ConsoleColors;
import constants.LOGTYPE;
import exceptions.PropertyFileUsageException;
import filereaders.ConfigurationReader;
import utilities.Screenshot;

/**
 * To log the details of test in the report
 * 
 * @author Nandhalala.
 * @Created_on 28 MAY,2023
 *
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public final class Logger {

	private static final Consumer<String> PASS = 
			(message)->ReportManager.getExtentTest().pass(message);
			
	private static final Consumer<String> FAIL = 
			(message)->ReportManager.getExtentTest().fail(message);
			
	private static final Consumer<String> WARN = 
			(message)->ReportManager.getExtentTest().warning(message);
			
	private static final Consumer<String> SKIP = 
			(message)->ReportManager.getExtentTest().skip(message);
	
	private static final Consumer<String> INFO = 
			(message)->ReportManager.getExtentTest().info(message);
			
	private static final Consumer<String> CONSOLELOG_PASS = 
			(message)->System.out.println(ConsoleColors.GREEN
					+"[--------PASS--------] : "
					+message+ConsoleColors.RESET);
			
	private static final Consumer<String> CONSOLELOG_FAIL = 
			(message)->System.out.println(ConsoleColors.RED
					+"[--------FAIL--------] : "
					+message+ConsoleColors.RESET);
			
	private static final Consumer<String> CONSOLELOG_WARNING = 
			(message)->System.out.println(ConsoleColors.YELLOW
					+"[--------WARNING--------] : "
					+message+ConsoleColors.RESET);
					
	private static final Consumer<String> CONSOLELOG_SKIP = 
			(message)->System.out.println(ConsoleColors.RED
					+"[--------SKIPPED--------] : "
					+message+ConsoleColors.RESET);
			
	private static final Consumer<String> CONSOLELOG_INFO = 
			(message)->System.out.println(ConsoleColors.BLUE
					+"[--------INFO--------] : "
					+message+ConsoleColors.RESET);

	private static final Consumer<String> PASSandCONSOLE =
			PASS.andThen(CONSOLELOG_PASS);
	
	private static final Consumer<String> FAILandCONSOLE =
			FAIL.andThen(CONSOLELOG_FAIL);
	
	private static final Consumer<String> WARNandCONSOLE =
			WARN.andThen(CONSOLELOG_WARNING);
	
	private static final Consumer<String> SKIPandCONSOLE =
			SKIP.andThen(CONSOLELOG_SKIP);
	
	private static final Consumer<String> INFOandCONSOLE =
			INFO.andThen(CONSOLELOG_INFO);
	
	/**
	 * Log the status of the test cases
	 * 
	 * @author Nandhalala.
	 * @Created_on 28 MAY,2023
	 *
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @version 1.0.
	 * @since 1.0.
	 * 
	 */
	public static void LOG(LOGTYPE logtype, String message) {
		
		String passedscreenshots=ConfigurationReader.
				getProperty(CONFIGPROPERTIES.PassedScreenShots);
		
		String failedscreenshots=ConfigurationReader.
				getProperty(CONFIGPROPERTIES.FailedScreenShots);
		
		String consolelog = ConfigurationReader.
				getProperty(CONFIGPROPERTIES.ConsolePrint);
		
		if(!(passedscreenshots.equalsIgnoreCase("YES")||passedscreenshots.equalsIgnoreCase("Y")||
				passedscreenshots.equals("")||
				passedscreenshots.equalsIgnoreCase("NO")||passedscreenshots.equalsIgnoreCase("N"))) {
			
			throw new PropertyFileUsageException("Value for passed"
					+ "screenshots is not a valid input in configuration.properties."
					+ "\nPlease give a valid input like,\n\"YES\" \"NO\" ");
			
		}
		
		if(!(failedscreenshots.equalsIgnoreCase("YES")||failedscreenshots.equalsIgnoreCase("Y")||
				failedscreenshots.equals("")||
				failedscreenshots.equalsIgnoreCase("NO")||failedscreenshots.equalsIgnoreCase("N"))) {
			
			throw new PropertyFileUsageException("Value for failed"
					+ "screenshots is not a valid input in configuration.properties"
					+ ".\nPlease give a valid input like,\n\"YES\" \"NO\" ");
			
		}
		
		if(!(consolelog.equalsIgnoreCase("YES")||consolelog.equalsIgnoreCase("Y")||
				consolelog.equals("")||consolelog.equalsIgnoreCase("NO")||consolelog.equalsIgnoreCase("N"))) {
			
			throw new PropertyFileUsageException("Value for failed"
					+ "screenshots is not a valid input in configuration.properties."
					+ "\nPlease give a valid input like,\n\"YES\" \"NO\" ");
			
		}
		
		switch (logtype) {
			case PASS:{
				
				if(consolelog.equalsIgnoreCase("YES")||consolelog.equals("")||
						consolelog.equalsIgnoreCase("Y"))
					PASSandCONSOLE.accept(message);
				
				
				else if(consolelog.equalsIgnoreCase("NO")||
						consolelog.equalsIgnoreCase("N"))
					PASS.accept(message);
				
				
				if(!passedscreenshots.equals("")&&
						passedscreenshots.equalsIgnoreCase("YES")) {
					
					ReportManager.getExtentTest().log(Status.PASS, 
							MediaEntityBuilder.
							createScreenCaptureFromBase64String(Screenshot
									.takeScreenshot()).build());
					
				}
					

				break;

			}

			case FAIL:{
				
				if(consolelog.equalsIgnoreCase("YES")||consolelog.equals("")||
						consolelog.equalsIgnoreCase("Y"))
					FAILandCONSOLE.accept(message);
				
				
				else if(consolelog.equalsIgnoreCase("NO")||
						consolelog.equalsIgnoreCase("N"))
					FAIL.accept(message);
				
				
				if(!failedscreenshots.equals("")&&
						passedscreenshots.equalsIgnoreCase("YES")) {
					
					ReportManager.getExtentTest().log(Status.PASS, 
							MediaEntityBuilder.
							createScreenCaptureFromBase64String(Screenshot
									.takeScreenshot()).build());
					
				}

				break;

			}

			case WARNING:{

				if(consolelog.equalsIgnoreCase("YES")||consolelog.equals("")||
						consolelog.equalsIgnoreCase("Y"))
					WARNandCONSOLE.accept(message);
				
				
				else if(consolelog.equalsIgnoreCase("NO")||
						consolelog.equalsIgnoreCase("N"))
					WARN.accept(message);
				
				
				break;
				
			}

			case SKIP:{

				if(consolelog.equalsIgnoreCase("YES")||consolelog.equals("")||
						consolelog.equalsIgnoreCase("Y"))
					SKIPandCONSOLE.accept(message);
				
				
				else if(consolelog.equalsIgnoreCase("NO")||
						consolelog.equalsIgnoreCase("N"))
					SKIP.accept(message);
				
				break;
			
			}

			case INFO:{
				
				if(consolelog.equalsIgnoreCase("YES")||consolelog.equals("")||
						consolelog.equalsIgnoreCase("Y"))
					INFOandCONSOLE.accept(message);
				
				
				else if(consolelog.equalsIgnoreCase("NO")||
						consolelog.equalsIgnoreCase("N"))
					INFO.accept(message);
				
				break;
			}

			default:{
				
				break;
				
			}
		}
		
	}
	
}
