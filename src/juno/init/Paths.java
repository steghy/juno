package juno.init;


public enum Paths {

	DATA(generatePath("data")),
	AUDIO(generatePath(DATA, "audio")),
	MUSIC(generatePath(AUDIO, "music-1")),
	MUSIC_2(generatePath(AUDIO, "music-2")),
	MUSIC_3(generatePath(AUDIO, "music-3")),
	EFFECTS(generatePath(AUDIO, "effects")),
	VIDEOS(generatePath(DATA, "videos")),
	IMAGES(generatePath(DATA, "images")),
	CARDS(generatePath(IMAGES, "cards")),
	RED_CARDS(generatePath(CARDS, "red")),
	BLUE_CARDS(generatePath(CARDS, "blue")),
	GREEN_CARDS(generatePath(CARDS, "green")),
	YELLOW_CARDS(generatePath(CARDS, "yellow")),
	JOLLY_CARDS(generatePath(CARDS, "jolly")),
	COVER(generatePath(CARDS, "cover")),
	LOGOS(generatePath(IMAGES, "logos")),
	BACKGROUNDS(generatePath(IMAGES, "backgrounds")),
	AUDIO_PLAYER(generatePath(IMAGES, "audio-player")),
	BUTTONS(generatePath(IMAGES, "buttons"));
	
	private final String path;
	
	Paths(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}

	private static String generatePath(String... names) {
		String div = System.getProperty("file.separator");
		StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
		for(String name : names) {
			path.append(div.concat(name));
		} return path.toString();
	}
	
	private static String generatePath(Paths pathObject, String... names) {
		String div = System.getProperty("file.separator");
		StringBuilder path = new StringBuilder(pathObject.getPath());
		for(String name : names) {
			path.append(div.concat(name));
		} return path.toString();
	}
}