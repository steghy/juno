package juno.view.exception;

/** 
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class JLabelNotSettedException extends Exception {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds a JLabelNotSettedException object
	 * @param message The message
	 */
	public JLabelNotSettedException(String message) {
		super(message);
	}

}
