package juno.model.player;

/**
 * Player class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Player {

	/* Player object name */
	private String name;
	
	/**
	 * Builds an empty Player object
	 */
	public Player() {}
	
	/**
	 * Builds a Player from the name and
	 * the specified Image avatar. 
	 * @param name The name of the Player
	 * @param avatar Image of the Player
	 */
	public Player(String name) {
		setName(name);
	}
	
	/**
	 * Sets the name of this Player object
	 * @param name A name for this Player object
	 * @throws IllegalArgumentException if the name
	 * 			is greater than or equal to 15 or less than 1.
	 */
	public void setName(String name) {
		checkNameValidity(name);
		this.name = name;
	}

	
	/**
	 * Returns the name of this object
	 * @return The name 
	 */
	public String getname() {
		return this.name;
	}
	
	
	/* Checks the name validity */
	private void checkNameValidity(String name) {
		if(name.length() <= 0 || name.length() > 14) {
			throw new IllegalArgumentException(""
					+ "The specified name should "
					+ "be greater than 0 and less "
					+ "than 15 in length");
		}
	}
}