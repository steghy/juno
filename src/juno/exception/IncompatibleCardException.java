package juno.exception;

/**
 * IncompatibleCardException class 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class IncompatibleCardException extends Exception {

	/* Serial VersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Buids an IncompatibleCardException object
	 * @param message The message
	 */
	public IncompatibleCardException(String message) {
		super(message);
	}
}