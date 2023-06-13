package constants;

/**
 * Contains all keys of configuration files.
 * 
 * Whenever a new value is added to property file, corressponding key should be created here.
 * 
 * @author Nandhalala.
 * @created on 02 APR, 2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public enum CONFIGPROPERTIES {

	ReportFileName,
	Browser,
	WaitTime,
	Headless,
	PassedScreenShots,
	FailedScreenShots,
	Environment,
	ConsolePrint,
	Createnode;
	
	/**
	 * Overrided method from enum and will return the enum values in String format. 
	 */
	@Override
	public String toString() {
		
		return name().toString();
	
	}
	
}
