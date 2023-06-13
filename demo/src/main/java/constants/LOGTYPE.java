package constants;

/**
 * Provides the log type on which status we are logging.
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
public enum LOGTYPE {

	PASS,
	FAIL,
	WARNING,
	SKIP,
	INFO;

	/**
	 * Overrided method from enum and will return the enum values in String format. 
	 */
	@Override
	public String toString() {
		
		return name().toString();
	
	}
	
}
