package juno.model.deck;

import java.util.Stack;

import juno.model.card.AbstractUnoCard;

/**
 * This class defines the deck of
 * the Uno card game.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class UnoDeck extends Stack<AbstractUnoCard> implements AbstractUnoDeck<AbstractUnoCard>, AbstractGenerable<AbstractUnoCard> {

	private static UnoDeck instance;

	/* The AbstractMixer object */
	private AbstractMixer<AbstractUnoCard> mixer;

	/* The AbstractUnoDeckManager object */
	private AbstractUnoDeckManager manager;

	/* The AbstractUnoDiscardedCards object */
	private AbstractUnoDiscardedCards<AbstractUnoCard> discardedCards;
	
	/* Builds the Deck instance */
	private UnoDeck() {}

	public static UnoDeck getInstance(){
		if(instance == null){
			instance = new UnoDeck();
		} return instance;
	}

	/**
	 * Returns the top card of the deck.
	 * @return An AbstractUnoCard object.
	 * @throws IllegalArgumentException if the deck is
	 * 			empty.
	 */
	public AbstractUnoCard draw() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Empty deck");
		} else if(this.size() == 4) {
			manager.reintroduceCards(this, discardedCards);
			mixDeck();
		} return this.pop();
	}

	/** Mix this deck */
	public void mixDeck(){
		this.mixer.shuffle(this);
	}


	/**
	 * Sets the Mixer object of this instance
	 * @param mixer A Mixer object
	 */
	public void setMixer(AbstractMixer<AbstractUnoCard> mixer){
		this.mixer = mixer;
	}


	/**
	 * Sets the AbstractUnoDeckManager object of this
	 * instance
	 * @param manager An AbstractUnoDeckManager object
	 */
	public void setManager(AbstractUnoDeckManager manager){
		this.manager = manager;
	}


	/**
	 * Sets the AbstractUnoDiscardedCards object of this
	 * instance
	 * @param discardedCards An AbstractUnoDiscardedCards
	 *                                  object
	 */
	public void setDiscardedCards(AbstractUnoDiscardedCards<AbstractUnoCard> discardedCards){
		this.discardedCards = discardedCards;
	}


	@Override
	public void insert(AbstractUnoCard card){
		this.add(card);
	}

}