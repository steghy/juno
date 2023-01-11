/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.model.data.io;

import juno.model.requester.InterfacePathProvider;

/**
 * This class contains the directory tree of the project.
 * @author Simone Gentili
 */
public enum ProgramDirectory
		implements InterfacePathProvider {

	// Data.
	/** Data directory. */
	DATA("data"),

	// Data -> Config.
	/** Config directory. */
	CONFIG(DATA,"config"),
	/** Profiles directory. */
	PROFILES(CONFIG, "profiles"),
	/** Goals directory. */
	GOALS(CONFIG, "goals"),
	/** Score directory */
	SCORE(CONFIG, "scores"),
	/** Avatar directory. */
	AVATAR(CONFIG, "avatar"),

	// Data -> Audio.
	/** Audio directory. */
	AUDIO(DATA, "audio"),
	/** Music directory. */
	MUSIC(AUDIO, "music"),
	/** Effects directory */
	EFFECTS(AUDIO, "effects"),

	// Data -> Video.
	/** Videos directory. */
	VIDEOS(DATA, "videos"),

	// Data -> Images.
	/** Images directory. */
	IMAGES(DATA, "images"),

	// Images -> Gifs.
	/** Gifs directory. */
	GIFS(IMAGES, "gifs"),

	// Images -> Logos.
	/** Logos directory. */
	LOGOS(IMAGES, "logos"),

	// Images -> Backgrounds.
	/** Backgrounds directory. */
	BACKGROUNDS(IMAGES, "backgrounds"),

	// Images -> Buttons.
	/** Buttons directory. */
	BUTTONS(IMAGES, "buttons"),

	// Images -> Cards.
	/** Cards directory. */
	CARDS(IMAGES, "cards"),

	// Images -> Colors.
	/** Colors directory */
	COLORS(IMAGES, "colors"),

	// Cards -> Cover and cards.
	/** Cover directory. */
	COVER(CARDS, "cover"),
	/** Red cards directory. */
	RED_CARDS(CARDS, "red"),
	/** Blue directory. */
	BLUE_CARDS(CARDS, "blue"),
	/** Green directory */
	GREEN_CARDS(CARDS, "green"),
	/** Yellow directory. */
	YELLOW_CARDS(CARDS, "yellow"),
	/** Jolly directory. */
	JOLLY_CARDS(CARDS, "jolly"),

	// Images -> Awards.
	/** Awards directory. */
	AWARDS(IMAGES, "awards"),

	// Images/Awards -> Avatars.
	/** Avatars directory. */
	AVATARS(AWARDS, "avatars");

	// The path.
	private String path;

	// The absolute path.
	private String absolutePath;

	// Builds a Directories object with the
	// specified Directories and String objects.
	ProgramDirectory(ProgramDirectory dir, String name) {
		generatePath(dir, name);
	}

	// Builds a Directories object with the specified String object.
	ProgramDirectory(String name) {
		generatePath(null, name);
	}

	@Override
	public String canonicalPath() {
		return this.path;
	}

	@Override
	public String absolutePath() {
		return absolutePath;
	}

	// Generates the absolute path and the path of this object.
	private void generatePath(ProgramDirectory dir, String name) {
		String div = System.getProperty("file.separator");
		StringBuilder builder = new StringBuilder(dir == null ? "" : dir.path);
		builder.append(div.concat(name));
		this.path = builder.toString();
		builder.insert(0, System.getProperty("user.dir"));
		this.absolutePath = builder.toString();
	}

}