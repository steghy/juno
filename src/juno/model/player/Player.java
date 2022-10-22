package juno.model.player;

import juno.view.user.Avatar;

/**
 * Player class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Player {

	/* Player object name */
	private String name;
	
	/* Player's Avatar object */
	private Avatar avatar;
	
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
	public Player(String name, Avatar avatar) {
		setName(name);
		this.avatar = avatar;
	}
	
	
	/**
	 * Sets the specified Avatar object to this 
	 * Player object
	 * @param avatar An Avatar object
	 */
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
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
	
	
	/**
	 * Returns the Avatar object of this Player object
	 * @return The Avatar object
	 */
	public Avatar getAvatar() {
		return this.avatar;
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