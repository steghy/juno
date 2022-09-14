package main.init;

/**
 * This class defines the folders names.
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public enum DirNames {
	
	/** Users folder name */
	USERS("users", 0),
	
	/** Profiles folder name */
	PROFILES("profiles", 0),
	
	/** Soundtracks folder name */
	SOUNDTRACKS("soundtracks", 1),
	
	/** Themes folder name */
	THEMES("themes", 1),
	
	/** Videos folder name */
	VIDEOS("videos", 1),
	
	/** Preferences folder name */
	PREFERENCES("preferences", 0),
	
	/** Config folder name */
	CONFIG("config", 0);

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