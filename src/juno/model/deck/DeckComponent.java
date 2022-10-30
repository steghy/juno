package juno.model.deck;

import java.util.Stack;

/**
 * This class defines the deck of
 * the Uno card game.
 * @author steghy
 */
public class DeckComponent<T> extends Stack<T> implements AbstractDeck<T> {

	/* The UnoDeck instance */
	private static DeckComponent<?> instance;

	/* Builds the Deck instance */
	private DeckComponent() {}

	/**
	 * Returns the UnoDeck instance.
	 * @return The UnoDeck instance.
	 */
	public static DeckComponent<?> getInstance(){
		if(instance == null){
			instance = new DeckComponent<>();
		} return instance;
	}

	/**
	 * Returns the top card of the deck.
	 * @return T object
	 * @throws IllegalArgumentException if the deck is
	 * 			empty.
	 */
	public T draw() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Empty deck");
		}
		return this.pop();
	}
}