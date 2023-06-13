package reportUtilies;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

import exceptions.ReportFileException;

/**
 * Report class is responsible for initiating the report before starting testcase
 * and closing the report to make sure the report can be access for reading.
 * 
 * It is also responsible for providing thread safety for the report.
 * 
 * @author Nandhalala.
 * @Created_on 28 MAY,2023
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0
 * @since 1.0
 */
public final class ReportManager {

	/**
	 * Private constructor to avoid instantiation.
	 */
	private ReportManager() {};
	
	private static ThreadLocal<ExtentTest> extentTest = 
			new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<ExtentTest> parenttest = 
			new ThreadLocal<ExtentTest>(); 
	
	/**
	 * This method is used to get the thread safe extenttest instance fetched from
	 * threadlocal variable.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 28, 2023.
	 * 
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} 
	 * instance.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	 public static ExtentTest getExtentTest() {
		 
		 if(Objects.nonNull(extentTest)) {
			 
			 return extentTest.get();
			 
		 }else {
			 
			 throw new ReportFileException("Test is null : Set the test"
			 		+ " before ruunning the testcases");
			 
		 }
		
	}

	/**
	 * Set the ExtentTest instance to thread local variable.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 28, 2023.
	 * 
	 * @param test : ExtentTest instance that needs to saved from Thread safety 
	 * issues.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	static void setExtentTest(ExtentTest test) {
		
		if(Objects.nonNull(test)) {
			
			extentTest.set(test);
		
		}
	
	}

	/**
	 * Calling remove method on Threadlocal variable to make sure that the 
	 * threadlocal variablehas been set the default value.
	 * 
	 * @author Nandhalala.
	 * @created on MAY 28, 2023.
	 * 
	 * @param test : ExtentTest instance that needs to saved from Thread safety 
	 * issues.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	static void unload() {
		
		extentTest.remove();
	
	}
	
	public static void setparentExtentTest(ExtentTest test) {
		
		if(Objects.nonNull(test)) {
			
			parenttest.set(test);
		
		}
	
	}
	
	public static ExtentTest getparentExtentTest() {
		
		return parenttest.get();
	}
	
	public static void parentunload() {
		
		parenttest.remove();
	
	}
	
}
