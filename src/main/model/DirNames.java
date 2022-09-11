package main.model;

/**
 * This class defines the directories names of
 * the program
 * @author steghy
 *
 */
public enum DirNames {
	
	// list of all dir names
	USERS("users"),
	PROFILES("profiles"),
	SOUNDTRACKS("soundtracks"),
	THEMES("themes"),
	VIDEOS("videos"),
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
