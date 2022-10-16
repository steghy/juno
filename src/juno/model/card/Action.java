package juno.model.card;

public enum Action {

	DRAW_TWO(false),
	REVERSE(false),
	SKIP(false),
	WILD(true),
	WILD_CARD_FOUR(true);
	
	private boolean isJolly;
	
	
	private Action(boolean isJolly) {
		this.isJolly = isJolly;
	}
	
	public boolean isJolly() {
		return this.isJolly;
	}
}
