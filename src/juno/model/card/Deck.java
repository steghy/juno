package juno.model.card;

import java.util.Random;
import java.util.Stack;

public class Deck {
	
	/* The instance */
	private static Deck instance;
	
	/* Deck */
	private Stack<Card> deck;
	
	/* Singleton Pattern */
	private Deck() {
		deck = new Stack<Card>();
	}
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static Deck getInstance() {
		if(instance == null) {
			instance = new Deck();
		} return instance;
	}
	
	/**
	 * Deck shuffler
	 */
	public void shuffle() {
		Random random = new Random();
		for(int i = 0; i < this.deck.size(); i++) {
			int index = random.nextInt(this.deck.size());
			Card card = this.deck.pop();
			this.deck.add(index, card);
		}
	}
	
	/**
	 * Returns the Stack witch contains the card
	 * @return A Stack<Card>
	 */
	public Stack<Card> getDeck() {
		return this.deck;
	}

	/**
	 * Generates the Uno deck.
	 * @param playersNumber The number of players
	 */
	public void generateDeck(int playersNumber) {

		if(playersNumber < 2 || playersNumber > 4) {
			throw new IllegalArgumentException("Invalid "
					+ "numeber of players");
		}

		int factor;
		if(playersNumber > 2) {
			factor = 2;
		} else {
			factor = 1;
		}
		
		for(int i = 0; i < factor; i++) {
			
			// Numberic cards
			for(int j = 1; j < 10; j++) {
				this.deck.add(new Card(j, Color.BLUE, null));
				this.deck.add(new Card(j, Color.GREEN, null));
				this.deck.add(new Card(j, Color.RED, null));
				this.deck.add(new Card(j, Color.YELLOW, null));
			}
			
			// Action cards
			for(Color color : Color.values()) {
				for(Action action : Action.values()) {
					if(!action.isJolly()) {
						this.deck.add(new Card(-1, color, action));
					}
				}
			}
		
			// Jolly cards
			for(Action action : Action.values()) {
				if(action.isJolly()) {
					this.deck.add(new Card(-1, null, action));
					this.deck.add(new Card(-1, null, action));
				}
			}
		}
			
		// Zeros
		for(Color color : Color.values()) {
			this.deck.add(new Card(0, color, null));
		}
			
	}
}
