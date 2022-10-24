package juno.model.deck.exceptions;

public class DeckIsNotEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeckIsNotEmptyException(String message) {
		super(message);
	}
}
