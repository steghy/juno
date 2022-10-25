package juno.view.exception;

import java.io.Serial;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class JPanelNotSetException extends Exception {

	/* Serial Version UID */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Builds a JPanelNotSetException
	 * @param message The message
	 */
	public JPanelNotSetException(String message) {
		super(message);
	}

}
