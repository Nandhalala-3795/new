package exceptions;

public class WaitException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8564408602835628746L;

	public WaitException() {
		
		super();

	}

	/**
	 * Pass the message that needs to be appended to the stacktrace.
	 * 
	 * @author Nandhalala.
	 * @created on 03 JUNE,2023.
	 * 
	 * @param message Details about exception or custom message.
	 * @param cause Pass the enriched stacktrace or customised stacktrace.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public WaitException(String message, Throwable cause) {
		
		super(message, cause);
			
	}

	/**
	 * Pass the message that needs to be appended to the stacktrace.
	 * 
	 * @author Nandhalala.
	 * @created on 03 JUNE,2023.
	 * 
	 * @param message Details about exception or custom message.
	 * 
	 * @Last_Modified_by.
	 * @Last_Modified_on.
	 * 
	 * @since 1.0.
	 */
	public WaitException(String message) {
		
		super(message);
	
	}

	
	
}
