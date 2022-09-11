package main.model;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum DirNames {
	
	/**
	 * 
	 */
	USERS("users"),
	
	/**
	 * 
	 */
	PROFILES("profiles"),
	
	/**
	 * 
	 */
	SOUNDTRACKS("soundtracks"),
	
	/**
	 * 
	 */
	THEMES("themes"),
	
	/**
	 * 
	 */
	VIDEOS("videos"),
	
	/**
	 * 
	 */
	PREFERENCES("preferences");

	// dir name
	private String name;

	
	/**
	 * Builds a dir name
	 * @param name
	 */
	private DirNames(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name
	 * @return The name
	 */
	public String getName() {
		return this.name;
	}
}
