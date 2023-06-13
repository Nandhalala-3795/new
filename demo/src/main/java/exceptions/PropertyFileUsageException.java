package exceptions;

/**
 * Runtime exception occurs when a invalid path is given
 * 
 * @author Nandhalala.
 * @created on MAR 28,2023.
 * 
 * @Last_Modified_by.
 * @Last_Modified_on.
 * 
 * @version 1.0.
 * @since 1.0.
 */
public class PropertyFileUsageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6111022179639482076L;

	/**
	 * Pass the message that needs to be appended to the stacktrace.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * 
	 * @param message Details about exception or custom message
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public PropertyFileUsageException(String message) {
		
		super(message);
	
	}
	
	/**
	 * Pass the message that needs to be appended to the stacktrace.
	 * 
	 * @author Nandhalala.
	 * @created on MAR 28,2023.
	 * 
	 * @param message Details about exception or custom message.
	 * @param cause Pass the enriched stacktrace or customised stacktrace.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public PropertyFileUsageException(String message, Throwable cause) {
		
		super(message,cause);
	
	}

	
}
