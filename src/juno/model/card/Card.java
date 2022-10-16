package juno.model.card;

/**
 * This class defines the 'Uno game' cards,
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Card {
	
	/* Card numeric value */
	private int value;
	
	/* Card color */
	private Color color;
	
	/* Card action */
	private Action action;
	
	/* Playable parameter */
	private boolean playable;

	
	/**
	 * Builds a Card object with the specified 
	 * values 
	 * @param value The numeric card value
	 * @param color The card color
	 * @param action The card action
	 */
	public Card(int value, Color color, Action action) {
		this.value = value;
		this.color = color;
		this.action = action;
	}
	
	
	/**
	 * Returns true if, and only if, this card
	 * is playable 
	 * @return A boolean
	 */
	public boolean isPlayable() {
		return this.playable;
	}

	
	/**
	 * Imposta la giocabilità di una carta.
	 * La giocabilità di una carta dipende dalla carta
	 * in cima nella pila degli scarti durante la partita.
	 * @param playable
	 */
	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	
	/**
	 * Returns the value of this card
	 * @return The numeric value of this card
	 */
	public int getValue() {
		return this.value;
	}

	
	/**
	 * Returns the color of this card
	 * @return A Color object 
	 */
	public Color getColor() {
		return this.color;
	}

	
	/**
	 * Returns the action of this card if
	 * it is present, otherwise returns null.
	 * @return An Action object
	 */
	public Action getAction() {
		return this.action;
	}

	
	/**
	 * Returns true if the specified Card object is compatible
	 * with this Card object.
	 * @param otherCard The other Card object
	 * @return A boolean
	 */
	public boolean isCompatible(Card otherCard) {
		// Same color case
		if(this.color == otherCard.getColor()) {
			return true;
		}
			
		// Same action case
		else if(this.action == otherCard.getAction()) {
			return true;
		}
			
		// Jolly Card case
		else if(otherCard.getAction().isJolly()) {
			return true;
		}
		
		// Same number case
		else if(this.value == otherCard.getValue()
				&& this.action == null && otherCard.getAction() == null) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public String toString() {
		return "Card[" + this.value + ", " 
				+ (this.color == null ? "NO_COLOR" : this.color.name()) 
				+ ", " 
				+ (this.action == null ? "NO_ACTION" : this.action.name()) + "]";
	}
	
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Card) {
			Card otherCard = (Card) object;
			if(this.action == otherCard.getAction() &&
			   this.color == otherCard.getColor() &&
			   this.value == otherCard.getValue()) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new IllegalArgumentException("The object needs to"
					+ "be an instance of type Card");
		}
	}
}