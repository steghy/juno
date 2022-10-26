package juno.model.card;

/**
 * This class defines the UnoCard object that
 * represents the Uno cards.
 *
 * @param value  The value.
 * @param color  The color Object.
 * @param action The Action object.
 * @author steghy
 * @email steghy.github@proton.me
 */
public record UnoCard(int value, AbstractUnoColor color, AbstractUnoAction action) implements AbstractUnoCard {

	/**
	 * Builds an UnoCard object with the specified
	 * parameters: value, color and action.
	 *
	 * @param value  The value.
	 * @param color  A Color object.
	 * @param action An Action object.
	 */
	public UnoCard {
	}

	/**
	 * Returns the value of this UnoCard object.
	 *
	 * @return A int value.
	 */
	@Override
	public int value() {
		return this.value;
	}


	/**
	 * Returns the color of this card
	 *
	 * @return A Color object
	 */
	@Override
	public AbstractUnoColor color() {
		return this.color;
	}


	/**
	 * Returns the action of this card if
	 * it is present, otherwise returns null.
	 *
	 * @return An Action object
	 */
	@Override
	public AbstractUnoAction action() {
		return this.action;
	}


	@Override
	public String toString() {
		return "UnoCard[" + this.value + ", "
				+ (this.color == null ? "NO_COLOR" : this.color)
				+ ", "
				+ (this.action == null ? "NO_ACTION" : this.action)
				+ "]";
	}


	@Override
	public boolean equals(Object object) {
		if (object instanceof UnoCard card) {
			return this.action == card.action() &&
					this.color == card.color() &&
					this.value == card.value();
		} else {
			throw new IllegalArgumentException("The object needs to"
					+ "be an instance of type Card");
		}
	}
}