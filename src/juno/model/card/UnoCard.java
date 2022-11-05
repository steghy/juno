package juno.model.card;

public record UnoCard<T, E, C>(T action, E color, C value) implements AbstractUnoCard<T, E, C> {

	@Override public T action() {
		return this.action;
	}

	@Override
	public E color() {
		return this.color;
	}

	@Override
	public C value() {
		return this.value;
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
		if (object instanceof UnoCard<?, ?, ?> card) {
			return this.action.equals(card.action) &&
					this.color.equals(card.color) &&
					this.value.equals(card.value());
		} else {
			throw new IllegalArgumentException("The object needs to"
					+ "be an instance of type Card");
		}
	}
}