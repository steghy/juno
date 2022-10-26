package juno.model.card;

/**
 * This class defines Action object
 * for the UnoCard class.
 * The Action object are:
 * DRAW_TWO, REVERSE, SKIP, WILD, WILD_DRAW_FOUR.
 * @author steghy
 * @email steghy.github@proton.me
 */
public enum Action implements AbstractUnoAction {

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