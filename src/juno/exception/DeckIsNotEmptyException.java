package juno.exception;

/**
 * DeckNotEmptyException class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class DeckIsNotEmptyException extends Exception {

	/* Serial VersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds a DeckNotEmptyException object
	 * @param message The message
	 */
	public DeckIsNotEmptyException(String message) {
		super(message);
	}

}
