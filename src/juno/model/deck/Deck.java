package juno.model.deck;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import juno.model.card.AbstractUnoCard;
import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.deck.exceptions.DeckIsEmptyException;

/**
 * This class defines the deck of
 * the Uno card game.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Deck extends Stack<AbstractUnoCard> implements AbstractDeck<AbstractUnoCard>, Mixable<AbstractUnoCard> {
	
	/* The UnoDeck instance */
	private static Deck instance;

	/* Builds the Deck instance */
	private Deck() {}
	
	/**
	 * Returns the instance of this class.
	 * @return The instance of this class.
	 */
	public static Deck getInstance() {
		if(instance == null) {
			instance = new Deck();
		} return instance;
	}

	/**
	 * Returns the top card of the deck.
	 * @return An AbstractUnoCard object.
	 * @throws DeckIsEmptyException if the deck is
	 * 			empty.
	 */
	public AbstractUnoCard draw() throws DeckIsEmptyException {
		if(this.isEmpty()) {
			throw new DeckIsEmptyException();
		} else {
			return this.pop();
		}
	}


	/*+ method(type): type*
	 * Generated the deck of cards
	 * @param playersNumber The number of players
	 */
	public void generateDeck(int playersNumber) {
		
		if(playersNumber < 2 || playersNumber > 4) {
			throw new IllegalArgumentException("Invalid "
					+ "number of players");
		}

		int factor;
		if(playersNumber > 2) {
			factor = 2;
		} else {
			factor = 1;
		}
		
		for(int i = 0; i < factor; i++) {

			// NUMERIC CARDS
			for(int j = 1; j < 10; j++) {
				this.add(new Card(j, Color.BLUE, null));
				this.add(new Card(j, Color.GREEN, null));
				this.add(new Card(j, Color.RED, null));
				this.add(new Card(j, Color.YELLOW, null));
			}

			// ACTION CARDS
			for(Color color : Color.values()) {
				for(Action action : Action.values()) {
					if(!action.isJolly()) {
						this.add(new Card(-1, color, action));
					}
				}
			}

			// JOLLY CARDS
			for(Action action : Action.values()) {
				if(action.isJolly()) {
					this.add(new Card(-1, null, action));
					this.add(new Card(-1, null, action));
				}
			}
		}

		// ZERO CARDS
		for(Color color : Color.values()) {
			this.add(new Card(0, color, null));
		}
	}

	@Override
	public List<AbstractUnoCard> getDataStructure() {
		return this;
	}
}