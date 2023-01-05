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

package juno.model.sound;

import juno.model.util.Donut;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class AudioPlayer
		extends GenericAudioPlayer {

	// The files.
	private final Donut<File> files;

	// The AudioPlayer instance.
	private static AudioPlayer instance;

	// Builds the AudioPlayer instance.
	private AudioPlayer() {
		files = new Donut<>();
	}

	/**
	 * Returns the AudioPlayer instance.
	 * @return The AudioPlayer instance.
	 */
	public static AudioPlayer getInstance() {
		if(instance == null) instance = new AudioPlayer();
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		super.load(files.next());
		play();
	}

	@Override
	public void play() {
		getTimer().start();
		getClip().start();
	}

	public void load(@NotNull List<File> files) {
		this.files.clear();
		this.files.addAll(files);
		this.files.initialize();
		super.load(this.files.current());
	}

}