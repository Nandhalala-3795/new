package exceptions;

public class ReportFileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6578921760205003622L;

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
	public ReportFileException(String message) {
		
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
	public ReportFileException(String message, Throwable cause) {
		
		super(message, cause);
		
	}

}
