package juno.model.card;

/**
 * This class defines the UnoCard object that
 * represents the Uno cards.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Card implements AbstractUnoCard {

	/* The value. */
	private final int value;

	/* The color Object. */
	private final Color color;

	/* The Action object. */
	private final Action action;

	/* Playable parameter. */
	private boolean playable;

	
	/**
	 * Builds an UnoCard object with the specified
	 * parameters: value, color and action.
	 * @param value The value.
	 * @param color A Color object.
	 * @param action An Action object.
	 */
	public Card(int value, Color color, Action action) {
		this.value = value;
		this.color = color;
		this.action = action;
	}


	/**
	 * Returns true if this UnoCard object is playable,
	 * otherwise returns false.
	 * @return A boolean.
	 */
	public boolean isPlayable() {
		return this.playable;
	}


	/**
	 * Sets the playable fild of this UnoCard object.
	 * @param value A boolean.
	 */
	public void setPlayable(boolean value) {
		this.playable = value;
	}

	
	/**
	 * Returns the value of this UnoCard object.
	 * @return A int value.
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
	 * @param card An AbstractUnoCard object
	 * @return A boolean
	 */
	public boolean isCompatibleWith(AbstractUnoCard card) {
		if(card instanceof Card) {
			if (this.color == card.getColor() ||
					this.action == card.getAction() ||
					this.value == card.getValue() ||
					((Card) card).getAction().isJolly()) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new IllegalArgumentException("The card must be a Card object");
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