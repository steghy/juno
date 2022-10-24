package juno.model.deck.exceptions;

/**
 * IncompatibleCardException class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class IncompatibleCardException extends Exception {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds an IncompatibleCardException object
	 * @param message The message
	 */
	public IncompatibleCardException(String message) {
		super(message);
	}

}
