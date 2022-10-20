package juno.model.card;

/**
 * Thid class defines Action object
 * for the Uno cards
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum Action {

	DRAW_TWO(false),
	REVERSE(false),
	SKIP(false),
	WILD(true),
	WILD_DRAW_FOUR(true);
	
	/* Jolly field */
	private boolean isJolly;
	
	
	/**
	 * Builds an Action object with
	 * the specified boolean value
	 * @param isJolly if is a Jolly action
	 */
	private Action(boolean isJolly) {
		this.isJolly = isJolly;
	}
	
	
	/**
	 * Returns true if this object is
	 * a Jolly action
	 * @return A boolean
	 */
	public boolean isJolly() {
		return this.isJolly;
	}
	
	/**
	 * Returns the Action object from the specified
	 * action name
	 * @param actionName The action name
	 * @return An Action object
	 */
	public static Action getActionObject(String actionName) {
		switch(actionName.toUpperCase()) {
		case("DRAW_TWO")      : return Action.DRAW_TWO;
		case("REVERSE")       : return Action.REVERSE;
		case("SKIP")          : return Action.SKIP;
		case("WILD")          : return Action.WILD;
		case("WILD_DRAW_FOUR"): return Action.WILD_DRAW_FOUR;
		} return null;
	}
}
