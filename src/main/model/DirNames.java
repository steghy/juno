package main.model;

/**
 * This class defines the names of directories
 * for the program.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum DirNames {
	
	/** */
	USERS("users"),
	
	/** */
	PROFILES("profiles"),
	
	/** */
	SOUNDTRACKS("soundtracks"),
	
	/** */
	THEMES("themes"),
	
	/** */
	VIDEOS("videos"),
	
	/** */
	PREFERENCES("preferences");

	/* Directory name */
	private String name;

	
	/**
	 * Builds an object with the 
	 * specified directory name
	 * @param name The directory name
	 */
	private DirNames(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the directory name
	 * @return The directory name
	 */
	public String getName() {
		return this.name;
	}
}
