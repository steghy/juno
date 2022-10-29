package juno.model.deck;

import juno.model.card.AbstractUnoCard;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the deck of
 * the Uno card game.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class UnoDeck extends StackDeck<AbstractUnoCard> implements Subject{

	private AbstractDeckRefiller<AbstractUnoCard> refiller;

	private AbstractDiscardPile<AbstractUnoCard> discardedPile;

	private List<Observer> observers;

	private AbstractUnoCard lastCard;


	/* The UnoDeck instance */
	private static UnoDeck instance;

	/* Builds the Deck instance */
	private UnoDeck() {
		observers = new ArrayList<>();
	}

	/**
	 * Returns the UnoDeck instance.
	 * @return The UnoDeck instance.
	 */
	public static UnoDeck getInstance(){
		if(instance == null){
			instance = new UnoDeck();
		} return instance;
	}

	/**
	 * Sets the AbstractDeckRefiller object of this instance.
	 * @param refiller An AbstractDeckRefiller object
	 */
	public void setRefiller(AbstractDeckRefiller<AbstractUnoCard> refiller) {
		this.refiller = refiller;
	}

	/**
	 * Sets the AbstractDiscardedPile object of this instance.
	 * @param discardedPile An AbstractDiscardedPile object
	 */
	public void setDiscardedPile(AbstractDiscardPile<AbstractUnoCard> discardedPile) {
		this.discardedPile = discardedPile;
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
		}

		if(this.size() == 4) {
			refiller.refill(this, discardedPile);
			getMixer().shuffle(this);
		}
		lastCard = this.pop();
		updateAll();
		return lastCard;
	}

	public AbstractUnoCard getLastCard() {
		return lastCard;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void updateAll() {
		observers.forEach(observer -> observer.update(this));
	}
}