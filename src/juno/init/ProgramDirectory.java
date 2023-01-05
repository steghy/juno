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

package juno.init;

import juno.model.requester.InterfacePathProvider;

/**
 * @author Simone Gentili
 */
public enum ProgramDirectory
		implements InterfacePathProvider {

	// Data.
	DATA("data"),

	// Data -> Config.
	CONFIG(DATA,"config"),
	PROFILES(CONFIG, "profiles"),
	GOALS(CONFIG, "goals"),
	SCORE(CONFIG, "scores"),
	AVATAR(CONFIG, "avatar"),

	// Data -> Audio.
	AUDIO(DATA, "audio"),
	MUSIC(AUDIO, "music"),
	EFFECTS(AUDIO, "effects"),

	// Data -> Video.
	VIDEOS(DATA, "videos"),

	// Data -> Images.
	IMAGES(DATA, "images"),

	// Images -> Gifs.
	GIFS(IMAGES, "gifs"),

	// Images -> Logos.
	LOGOS(IMAGES, "logos"),

	// Images -> Backgrounds.
	BACKGROUNDS(IMAGES, "backgrounds"),

	// Images -> Buttons.
	BUTTONS(IMAGES, "buttons"),

	// Images -> Cards.
	CARDS(IMAGES, "cards"),

	// Images -> Colors.
	COLORS(IMAGES, "colors"),

	// Cards -> Cover and cards.
	COVER(CARDS, "cover"),
	RED_CARDS(CARDS, "red"),
	BLUE_CARDS(CARDS, "blue"),
	GREEN_CARDS(CARDS, "green"),
	YELLOW_CARDS(CARDS, "yellow"),
	JOLLY_CARDS(CARDS, "jolly"),

	// Images -> Awards.
	AWARDS(IMAGES, "awards"),

	// Images/Awards -> Avatars.
	AVATARS(AWARDS, "avatars"),

	// Images/Awards -> Frames.
	FRAMES(AWARDS, "frames");

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