package reportUtilies;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.AutoConstants;
import constants.CONFIGPROPERTIES;
import exceptions.PropertyFileUsageException;
import exceptions.ReportFileException;
import filereaders.ConfigurationReader;

/**
 * Report class is responsible for initiating the report before starting testcase 
 * and closing the report to make sure the report can be access for reading.
 * 
 * It is also responsible for providing thread safety for the report.
 * 
 * @author Nandhalala.
 * @Created_on 26 MAY,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public final class Report {
	
	/**
	 * Private constructor to avoid instantiation.
	 */
	private Report() {}
	
	/**
	 * Private variable to store the report.
	 */
	private static ExtentReports extentreport;
	
	/**
	 * Set the initial configuration for the Extent Reports and decides 
	 * the report generation path.
	 * 
	 * @author Nandhalala.
	 * @Created_on 28 MAY,2023.
	 * 
	 * @return whether extent report in intialized or not.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static boolean initReport(String reporttitle) {
		
		if(Objects.isNull(extentreport)) {
			
			extentreport = new ExtentReports();
			
			String reportfilename;
			
			if(!ConfigurationReader
					.getProperty(CONFIGPROPERTIES.ReportFileName)
					.equals("")) {
				
				reportfilename = ConfigurationReader
						.getProperty(CONFIGPROPERTIES.ReportFileName);
				
			}else {

				SimpleDateFormat date = 
						new SimpleDateFormat("YYYY MM dd HH MM ss");
				
				String timestamp = date.format(new Date());
				
				reportfilename = "index " + timestamp;
				
			}
			
			File reportfile = new File(AutoConstants.getReportsPath()
					+File.separator+reportfilename+".html");
						
			ExtentSparkReporter sparkreport = 
					new ExtentSparkReporter(reportfile);
			
			File configfile = 
					new File(AutoConstants.getXMLRPTCONFIGPath());
			
			if(configfile.exists()) {
				
				try {
					
					sparkreport.loadXMLConfig(configfile);
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				
			}else {
				
				sparkreport.config().setTheme(Theme.STANDARD);
				
				sparkreport.config().setTimeStampFormat("YYYY MM DD HH:MM:SS");
				
			}			
			
			sparkreport.config().setDocumentTitle(reporttitle);
			
			sparkreport.viewConfigurer().viewOrder()
				.as(ReportViewOrder.getReportViewOrder()).apply();
			
			extentreport.attachReporter(sparkreport);
			
			return Objects.nonNull(extentreport);
			
		}else {
			
			throw new ReportFileException("Extent Report cannot be "
					+ "intialized as it already have been initialized");
			
		}
		
	}
	
	/**
	 * Flushing the reports ensures extent logs are reflected properly.
	 * Sets the ThreadLocal variable to default value.
	 * 
	 * @author Nandhalala.
	 * @Created_on 28 MAY,2023.
	 * 
	 * @return whether the report has been flushed or not.
	 * 
	 * @since 1.0.
	 */
	public static boolean flushReports() {
		
		if(Objects.nonNull(extentreport)) {
			
			extentreport.flush();
			
		}else {
			
			throw new ReportFileException("Tried to flush the report "
					+ "but report is null");
			
		}
		
		ReportManager.unload();
		
		return Objects.isNull(ReportManager.getExtentTest());
		
	}

	/**
	 * Creates a test node in the extent report. 
	 * 
	 * @author Nandhalala.
	 * @Created_on 28 MAY,2023.
	 * 
	 * @param TestCaseName to set the test node name.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public static void createtest(String TestCaseName) {
		
		String createnode = 
				ConfigurationReader.getProperty(CONFIGPROPERTIES.Createnode);
		
		if(!(createnode.equals("")||createnode.equalsIgnoreCase("YES")||
				createnode.equalsIgnoreCase("NO"))) {
			
			throw new PropertyFileUsageException("The value for Createnode"
					+ " is invalid in configuration.properties.\nIf you wish to create teat as node"
					+ " give \"YES\" or if you wish to create seperate test give \"NO\"");
			
		}
			
		
		if(createnode.equalsIgnoreCase("YES")||
				createnode.equalsIgnoreCase("Y")) {
			
			ExtentTest childtest = ReportManager.getparentExtentTest()
					.createNode(TestCaseName);
			
			ReportManager.setExtentTest(childtest);
			
		}
		
		else {
			
			ReportManager
			.setExtentTest(extentreport.createTest(TestCaseName));
			
		}
		
	}
	
	public static void createparenttest(String TestClassName) {
		
		ReportManager.setparentExtentTest(
				extentreport.createTest(TestClassName));
		
	}
	
}
