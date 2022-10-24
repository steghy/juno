package juno.view.exception;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class JPanelNotSettedException extends Exception {

	/* Serial Verison UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds a JPanelNotSettedException object
	 * @param message The message
	 */
	public JPanelNotSettedException(String message) {
		super(message);
	}

}
