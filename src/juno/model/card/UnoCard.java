package juno.model.card;

public record UnoCard(AbstractUnoCardAction action, AbstractUnoCardColor<AbstractUnoColor> color, AbstractUnoCardValue value) implements AbstractUnoCard {

	@Override
	public AbstractUnoCardAction action() {
		return action;
	}

	@Override
	public AbstractUnoCardColor<AbstractUnoColor> color() {
		return color;
	}

	@Override
	public AbstractUnoCardValue value() {
		return value;
	}
}