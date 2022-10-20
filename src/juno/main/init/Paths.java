package juno.main.init;


public enum Paths {

	DATA(generatePath("data")),
	AUDIO(generatePath(DATA, "audio")),
	MUSIC(generatePath(AUDIO, "music")),
	EFFECTS(generatePath(AUDIO, "effects")),
	VIDEOS(generatePath(DATA, "videos")),
	IMAGES(generatePath(DATA, "images")),
	CARDS(generatePath(IMAGES, "cards")),
	RCARDS(generatePath(CARDS, "red")),
	BCARDS(generatePath(CARDS, "blue")),
	GCARDS(generatePath(CARDS, "green")),
	YCARDS(generatePath(CARDS, "yellow")),
	JCARDS(generatePath(CARDS, "jolly")),
	COVER(generatePath(CARDS, "cover")),
	BACKGROUNDS(generatePath(IMAGES, "backgrounds"));
	
	/* The path */
	private String path;
	
	/*
	 * Builds a Path object
	 * with the specified path
	 */
	private Paths(String path) {
		this.path = path;
	}
	
	/**
	 * Returns the path of this object
	 * @return The path
	 */
	public String getPath() {
		return this.path;
	}

	
	/**
	 * Generates a path with the specified names
	 * @param names The names of the path's component
	 * @return A String that represent a path
	 */
	private static String generatePath(String... names) {
		String div = System.getProperty("file.separator");
		String path = System.getProperty("user.dir");
		for(String name : names) {
			path += div.concat(name);
		} return path;
	}
	
	/*
	 * Returns a path 
	 * @param pathObject A Path obejct
	 * @param names The names
	 * @return A path
	 */
	private static String generatePath(Paths pathObject, String... names) {
		String div = System.getProperty("file.separator");
		String path = pathObject.getPath();
		for(String name : names) {
			path += div.concat(name);
		} return path;
	}
}