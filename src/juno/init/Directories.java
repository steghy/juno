package juno.init;

public enum Directories
		implements InterfaceDirectories {

	// DATA
	DATA("data"),

	// DATA -> CONFIG
	CONFIG(DATA,"config"),
	PROFILES(CONFIG, "profiles"),
	AWARDS(CONFIG, "awards"),
	SCORES(CONFIG, "scores"),

	// DATA -> AUDIO
	AUDIO(DATA, "audio"),
	MUSIC(AUDIO, "music-1"),
	MUSIC_2(AUDIO, "music-2"),
	MUSIC_3(AUDIO, "music-3"),
	EFFECTS(AUDIO, "effects"),

	// DATA -> VIDEO
	VIDEOS(DATA, "videos"),

	// DATA -> IMAGES
	IMAGES(DATA, "images"),
	GIFS(IMAGES, "gifs"),
	LOGOS(IMAGES, "logos"),
	BACKGROUNDS(IMAGES, "backgrounds"),
	BUTTONS(IMAGES, "buttons"),

	// IMAGE -> CARDS
	CARDS(IMAGES, "cards"),
	COVER(CARDS, "cover"),
	RED_CARDS(CARDS, "red"),
	BLUE_CARDS(CARDS, "blue"),
	GREEN_CARDS(CARDS, "green"),
	YELLOW_CARDS(CARDS, "yellow"),
	JOLLY_CARDS(CARDS, "jolly");

	private String path;
	private String absolutePath;
	
	Directories(Directories dir, String name) {
		generatePath(dir, name);
	}

	Directories(String name) {
		generatePath(null, name);
	}

	public String path() {
		return this.path;
	}

	public String absolutePath() {
		return absolutePath;
	}

	private void generatePath(Directories dir, String name) {
		String div = System.getProperty("file.separator");
		StringBuilder builder = new StringBuilder(dir == null ? "" : dir.path);
		builder.append(div.concat(name));
		this.path = builder.toString();
		builder.insert(0, System.getProperty("user.dir"));
		this.absolutePath = builder.toString();
	}
}