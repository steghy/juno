package juno.model.deck;

import java.util.List;
import java.util.Stack;
import juno.model.card.AbstractUnoCard;

/**
 * This class defines the deck of
 * the Uno card game.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Deck extends Stack<AbstractUnoCard> implements AbstractDeck<AbstractUnoCard>, Mixable<AbstractUnoCard>, Generable<AbstractUnoCard> {
	
	/* Builds the Deck instance */
	public Deck() {}


	/**
	 * Returns the top card of the deck.
	 * @return An AbstractUnoCard object.
	 * @throws IllegalArgumentException if the deck is
	 * 			empty.
	 */
	public AbstractUnoCard draw() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			return this.pop();
		}
	}


	public void insert(AbstractUnoCard card){
		this.add(card);
	}

	@Override
	public List<AbstractUnoCard> getDataStructure() {
		return this;
	}
}