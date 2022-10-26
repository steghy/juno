package juno.model.card;

/**
 * This class defines Action object
 * for the UnoCard class.
 * The Action object are:
 * DRAW_TWO, REVERSE, SKIP, WILD, WILD_DRAW_FOUR.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum Action {

	/** Draw two action */
	DRAW_TWO,

	/** Reverse action */
	REVERSE,

	/** Skip action */
	SKIP,

	/** Wild jolly action */
	WILD,

	/** Wild draw four action */
	WILD_DRAW_FOUR;
	

	/**
	 * Returns true if this object is a jolly,
	 * otherwise returns false
	 * @return A boolean
	 */
	public boolean isJolly() {
		return this.name().equals("WILD") ||
				this.name().equals("WILD_DRAW_FOUR");
	}
	
	/**
	 * Returns the Action object associated with the
	 * specified action name
	 * @param actionName The action name
	 * @return An Action object
	 */
	public static Action getActionObject(String actionName) {
		return switch (actionName.toUpperCase()) {
			case ("DRAW_TWO") -> Action.DRAW_TWO;
			case ("REVERSE") -> Action.REVERSE;
			case ("SKIP") -> Action.SKIP;
			case ("WILD") -> Action.WILD;
			case ("WILD_DRAW_FOUR") -> Action.WILD_DRAW_FOUR;
			default -> null;
		};
	}
}
