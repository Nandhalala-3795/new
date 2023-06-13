package listeners;

import java.util.Objects;

import org.testng.*;

import annotations.author;
import constants.CONFIGPROPERTIES;
import constants.LOGTYPE;
import exceptions.PropertyFileUsageException;
import exceptions.ReportFileException;
import filereaders.ConfigurationReader;
import reportUtilies.Logger;
import reportUtilies.Report;
import reportUtilies.ReportManager;
import utilities.SystemProperties;

/**
 * Implemented methods from {@link ITestListener} and {@link ISuiteListener}.
 * Most useful for generating reports.
 * 
 * @author Nandhalala.
 * @Created_on 30 MAY,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 *
 */
public class Listener implements ITestListener, ISuiteListener {

	/**
	 * Overrided method from ISuiteListener.
	 * 
	 * This Method will invoke before test suite starts executing.
	 * 
	 * The report initialization is done here to make sure there is report
	 * available for every test suite.
	 * 
	 * It will throw exception if report cannot be initialized before suite.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onStart(ISuite suite) {
		
		if(!Report.initReport(suite.getName())){
			
			throw new ReportFileException("Report is be initialized "
					+ "before suite execution");
			
		}
		
	}

	/**
	 * Overrided method from ISuiteListener.
	 * 
	 * This method will be invoked after all the test in the test suite 
	 * are executed.
	 * 
	 * The report will be flushed to make sure the report will be readable.
	 * 
	 * If report cannot be flushed it will throw an error.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onFinish(ISuite suite) {
		
		if(!Report.flushReports()) {
			
			throw new ReportFileException("Report Cannot be flushed after"
					+ "suite execution is completed");
			
		}
		
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method will run before start of test case.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		
		Report.createtest(result.getMethod().getMethodName());
		
		ReportManager.getExtentTest().assignAuthor(result.getMethod()
				.getConstructorOrMethod().getMethod()
				.getAnnotation(author.class).name());
		
		ReportManager.getExtentTest()
		.assignDevice(SystemProperties.getDeviceName());
		
		Logger.LOG(LOGTYPE.INFO, "Test : " + 
				result.getMethod().getMethodName() + " is satarted");
	
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method on successful execution of test case.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
				
		Logger.LOG(LOGTYPE.PASS, "Test : "
				+ result.getMethod().getMethodName() 
				+ " is successfully passed");
		
		ReportManager.getExtentTest().assignCategory("Passed Tests");
		
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method will run if the test case is failed.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
				
		Logger.LOG(LOGTYPE.FAIL, "Test : " + 
				result.getMethod().getMethodName()+" is failed");
		
		ReportManager.getExtentTest().assignCategory("Failed Tests");
		
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method will run if the test case is skipped.
	 * 
	 * @author Nandhalala.
	 * @Created_on 30 MAY,2023.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
				
		Logger.LOG(LOGTYPE.SKIP, "Test : " + 
				result.getMethod().getMethodName() + " is skipped");
		
		ReportManager.getExtentTest().assignCategory("Skipped Tests");
		
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method will implemented if any action needs to be performed
	 * on start of test.
	 */
	@Override
	public void onStart(ITestContext context) {
		
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
			
			Report.createparenttest(context.getName());
			
		}
		
	}

	/**
	 * Overrided method from {@link ITestListener}.
	 * 
	 * The method will implemented if any action needs to be performed
	 * on end of test.
	 */
	@Override
	public void onFinish(ITestContext context) {
		
		if(Objects.nonNull(ReportManager.getparentExtentTest())) {
			
			ReportManager.parentunload();
			
		}
		
	}

	
	
}
