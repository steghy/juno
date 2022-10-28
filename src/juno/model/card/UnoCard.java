package juno.model.card;

/**
 * This class defines the UnoCard object that
 * represents the Uno cards.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class UnoCard implements AbstractUnoCard {

	private AbstractUnoCardColor color;
	private final AbstractUnoCardAction action;
	private final AbstractUnoCardValue value;

	/**
	 * Builds an UnoCard object with the specified
	 * parameters: value, color and action.
	 *
	 * @param value  The value.
	 * @param color  A Color object.
	 * @param action An Action object.
	 */
	public UnoCard(AbstractUnoCardValue value, AbstractUnoCardColor color, AbstractUnoCardAction action) {
		this.value = value;
		this.color = color;
		this.action = action;
	}

	/**
	 * Returns the value of this UnoCard object.
	 *
	 * @return A int value.
	 */
	@Override
	public AbstractUnoCardValue value() {
		return this.value;
	}


	/**
	 * Returns the color of this card
	 *
	 * @return A Color object
	 */
	@Override
	public AbstractUnoCardColor color() {
		return this.color;
	}


	/**
	 * Returns the action of this card if
	 * it is present, otherwise returns null.
	 *
	 * @return An Action object
	 */
	@Override
	public AbstractUnoCardAction action() {
		return this.action;
	}


	public void setWildCardColor(AbstractUnoCardColor color){
		if(this.action != null) {
			if (this.action.isWildAction() || this.action.isWildDrawFourAction()) {
				this.color = color;
				return;
			}
		} throw new IllegalArgumentException("Invalid argument");
	}


	@Override
	public String toString() {
		return "UnoCard["
				+ (this.value == null ? "NO_VALUE" : this.value)
				+ ", "
				+ (this.color == null ? "NO_COLOR" : this.color)
				+ ", "
				+ (this.action == null ? "NO_ACTION" : this.action)
				+ "]";
	}


	@Override
	public boolean equals(Object object) {
		if (object instanceof UnoCard card) {
			return this.action.equals(card.action) &&
					this.color.equals(card.color) &&
					this.value.equals(card.value());
		} else {
			throw new IllegalArgumentException("The object needs to"
					+ "be an instance of type Card");
		}
	}
}