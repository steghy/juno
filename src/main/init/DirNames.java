package main.init;

/**
 * This class defines the folders names 
 * with the priority codes.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum DirNames {
	
	/** Users folder */
	USERS("users", 0),
	
	/** Profiles folder */
	PROFILES("profiles", 0),
	
	/** Soundtracks folder */
	SOUNDTRACKS("soundtracks", 1),
	
	/** Themes folder */
	THEMES("themes", 1),
	
	/** Videos folder */
	VIDEOS("videos", 1),
	
	/** Preferences folder */
	PREFERENCES("preferences", 0),
	
	/** Config folder */
	CONFIG("config", 0),
	
	/** Saves folder */
	SAVES("saves", 0);

	/* Folder name */
	private String name;
	
	/* Priority folder */
	private int priority;

	
	/**
	 * Builds an object with the 
	 * specified folder name
	 * @param name The folder name
	 * @param priority The priority
	 */
	private DirNames(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	
	/**
	 * Returns the directory name
	 * @return The directory name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Returns the priority
	 * @return The priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	public String toString() {
		return "[Folder name = ".concat(this.name.concat(" | Priority = " + this.priority)).concat("]");
	}
}