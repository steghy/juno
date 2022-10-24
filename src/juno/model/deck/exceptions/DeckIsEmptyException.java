package juno.model.deck.exceptions;

/**
 * DeckIsEmptyException class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class DeckIsEmptyException extends Exception {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds a DeckIsEmptyException object
	 * @param message The message
	 */
	public DeckIsEmptyException(String message) {
		super(message);
	}
	
	/**
	 * Builds a DeckIsEmptyException
	 */
	public DeckIsEmptyException() {
		
	}

}
