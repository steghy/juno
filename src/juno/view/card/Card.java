package juno.view.card;

public enum Card {
	
	ZERO,
	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	HEIGHT,
	NINE,
	SKIP,
	REVERSE,
	DRAW_TWO,
	WILD,
	WILD_CARD_FOUR;
	
	/* The graphic card path */
	private String path;
	
	/*
	 * Builds a Card object
	 */
	private Card() {}
	
	/**
	 * Returns the path
	 * @return The path
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * Sets the path
	 * @param path The path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
