package main.init;

/**
 * This class defines the folders names.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum DirNames {
	
	/** Users folder name */
	USERS("users"),
	
	/** Profiles folder name */
	PROFILES("profiles"),
	
	/** Soundtracks folder name */
	SOUNDTRACKS("soundtracks"),
	
	/** Themes folder name */
	THEMES("themes"),
	
	/** Videos folder name */
	VIDEOS("videos"),
	
	/** Preferences folder name */
	PREFERENCES("preferences"),
	
	/** Config folder name */
	CONFIG("config");

	/* Directory name */
	private String name;

	
	/**
	 * Builds an object with the 
	 * specified folder name
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