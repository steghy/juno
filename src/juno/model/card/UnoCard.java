package juno.model.card;

public record UnoCard(InterfaceUnoCardAction action,
					  InterfaceUnoCardColor<InterfaceUnoColor> color,
					  InterfaceUnoCardValue value)
		implements InterfaceUnoCard {

	@Override
	public InterfaceUnoCardAction action() {
		return action;
	}

	@Override
	public InterfaceUnoCardColor<InterfaceUnoColor> color() {
		return color;
	}

	@Override
	public InterfaceUnoCardValue value() {
		return value;
	}
}