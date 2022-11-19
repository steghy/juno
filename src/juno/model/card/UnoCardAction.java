package juno.model.card;

public enum UnoCardAction implements AbstractUnoCardAction {

	DRAW_TWO,
	REVERSE,
	SKIP,
	WILD,
	WILD_DRAW_FOUR;

	@Override
	public boolean isWildAction() {
		return this.name().equals("WILD");
	}

	@Override
	public boolean isWildDrawFourAction() {
		return this.name().equals("WILD_DRAW_FOUR");
	}

	@Override
	public boolean isSkipAction() {
		return this.name().equals("SKIP");
	}

	@Override
	public boolean isReverseAction() {
		return this.name().equals("REVERSE");
	}

	@Override
	public boolean isDrawTwoAction() {
		return this.name().equals("DRAW_TWO");
	}
}