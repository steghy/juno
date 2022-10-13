package main.init;

/**
 * This class defines the errors in 
 * the program. 
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum ErrorCode {

	/** No error */
	ERROR_0(0, "No error"),
	
	/** File not found */
	ERROR_1(1, "File not found"),
	
	/** Directory not found */
	ERROR_2(2, "Directory not found"),
	
	/** Fatal error */
	ERROR_128(128, "Fatal error");
	
	/* The error code */
	private int errorCode;
	
	/* The error message */
	private String message;
	
	
	/* Builds an ErrorCodes instance */
	private ErrorCode(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
	/**
	 * Returns the error code
	 * @return The error code
	 */
	public int getErrorCode() {
		return this.errorCode;
	}
	
	
	/**
	 * Returns the error message
	 * @return The error mesage
	 */
	public String getErrorMessage() {
		return this.message;
	}
	
	
	/**
	 * Returns true if the ErrorCode is fatal
	 * @return A boolean
	 */
	public boolean isFatal() {
		return this.errorCode == 128;
	}
}	