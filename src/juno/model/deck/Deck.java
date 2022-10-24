package juno.model.deck;

import java.util.Random;
import java.util.Stack;

import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.deck.exceptions.DeckIsEmptyException;
import juno.model.deck.exceptions.DeckIsNotEmptyException;
import juno.model.deck.exceptions.IncompatibleCardException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Deck {
	
	/* The instance */
	private static Deck instance;
	
	/* Deck */
	private Stack<Card> deck;
	
	/* Discarded cards */
	private Stack<Card> discarded;
	
	/* Il numero totale di carte in mano */
	private int cardsInHand;
	
	/* Singleton Pattern */
	private Deck() {}
	
	
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
	 * 
	 * @return
	 * @throws DeckIsEmptyException
	 */
	public Card draw() throws DeckIsEmptyException {
		if(this.deck.isEmpty()) {
			throw new DeckIsEmptyException();
		}
		Card card = this.deck.pop();
		this.cardsInHand++;
		return card;
	}
	
	
	/**
	 * 
	 * @param card
	 * @throws IncompatibleCardException
	 */
	public void putCard(Card card) throws IncompatibleCardException {
		if(this.discarded.peek().isCompatible(card)) {
			this.cardsInHand--;
			this.discarded.push(card);
		} else {
			throw new IncompatibleCardException("THe specified Card object"
					+ "cannot be puts into the discarded cards");
		}
	}
	
	
	/**
	 * 
	 * @return
	 * @throws DeckIsNotEmptyException
	 */
	public Deck addDiscardedToDeck() throws DeckIsNotEmptyException {
		if(this.deck.isEmpty()) {
			this.deck.addAll(this.discarded);
			this.discarded.clear();
		} else {
			throw new DeckIsNotEmptyException("Deck is not empty,"
					+ "first consume this deck.");
		} return this;
	}

	
	/**
	 * 
	 * @return
	 */
	public Deck shuffle() {
		Random random = new Random();
		for(int i = 0; i < 250; i++) {
			Card card = this.deck.pop();
			int index_1 = random.nextInt(this.deck.size());
			this.deck.add(index_1, card);
		} return this;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Stack<Card> getDeck() {
		return this.deck;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Stack<Card> getDiscarded() {
		return this.discarded;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int getCardsInHand() {
		return this.cardsInHand;
	}

	
	/**
	 * 
	 * @param playersNumber
	 * @return
	 */
	public Deck generateDeck(int playersNumber) {
		
		this.deck = new Stack<>();
		this.discarded = new Stack<>();

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
		return this;	
	}
}