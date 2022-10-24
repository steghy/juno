package juno.view.exception;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class JButtonNotSettedException extends Exception {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds a JButtonNotSettedException object
	 * @param message The message
	 */
	public JButtonNotSettedException(String message) {
		super(message);
	}
}
