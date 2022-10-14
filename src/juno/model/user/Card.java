package juno.model.user;

/**
 * This class defines the cards of Uno game. 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum Card {
	
	ZERO(0), 
	ONE(1), 
	TWO(2), 
	THREE(3), 
	FOUR(4), 
	FIVE(5),
	SIX(6), 
	SEVEN(7), 
	EIGHT(8), 
	NINE(9), 
	PLUS(10), 
	STOP(11), 
	CHANGE(12), 
	JOLLY_PLUS(13), 
	JOLLY_CHANGE(14);
	
	/* Card value */
	private int value;

	
	/*
	 * Builds a card with the specified value
	 */
	private Card(int value) {
		this.value = value;
	}
	
	
	/**
	 * Returns the value of this card
	 * @return The value of this card
	 */
	public int getValue() {
		return this.value;
	}
}