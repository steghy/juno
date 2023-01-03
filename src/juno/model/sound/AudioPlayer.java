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
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Simone Gentili
 */
public class AudioPlayer
		implements MuteableAudioPlayer, RepeatableAudioPlayer, Playable, Observable, ActionListener {

	// The Observers List.
	private final List<Observer> observerList;

	// The clip.
	private Clip clip;

	// The tracks.
	private Donut<File> tracks;

	// The Audio player status.
	private boolean status;

	// The clip float control.
	private FloatControl floatControl;

	// The mute boolean value.
	private boolean mute;

	// The loop boolean value.
	private boolean loop;

	// The AudioPlayer instance.
	private static AudioPlayer instance;

	// Builds the AudioPlayer instance.
	private AudioPlayer() {
		observerList = new ArrayList<>();
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
	public void play() {
		if(clip != null) {
			status = true;
			clip.start();
		}
	}

	/**
	 * Rewinds the clip of this object.
	 */
	public void rewind() {
		if(clip != null) {
			clip.setMicrosecondPosition(0L);
			play();
		}
	}

	/**
	 * Interrupts the clip of this object.
	 */
	public void pause() {
		if(status && clip != null) {
			status = false;
			clip.stop();
		}
	}

	/**
	 * Plays the next track.
	 */
	public void next() {
		if(tracks != null) {
			if(tracks.getCurrentIndex() == tracks.size() - 1) {
				if(loop)
					nextTrack();
				else
					pause();
			} else
				nextTrack();
		}
	}

	/**
	 * Plays the next track.
	 */
	private void nextTrack() {
		pause();
		tracks.next();
		File track = tracks.current();
		load(track);
		play();
	}

	/**
	 * Plays the previous track.
	 */
	public void back() {
		if(tracks != null) {
			stop();
			load(tracks.previous());
			play();
		}
	}

	/**
	 * Stops the clip of this object.
	 */
	public void stop() {
		if(status) {
			pause();
			clip.close();
		}
	}

	@Override
	public void mute() {
		if(!mute) {
			mute = true;
			floatControl.setValue(-80);
		}
	}

	@Override
	public void unmute() {
		if(mute) {
			mute = false;
			floatControl.setValue(0);
		}
	}

	@Override
	public boolean isMuted() {
		return mute;
	}

	@Override
	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	@Override
	public boolean isLooped() {
		return loop;
	}

	/**
	 * Sets the tracks of this object with the
	 * specified array of File objects.
	 * @param tracks An array of File objects.
	 */
	public void setTracks(@NotNull File[] tracks) {
		if(tracks.length > 0) {
			this.tracks = new Donut<>();
			this.tracks.addAll(Arrays.asList(tracks));
			this.tracks.initialize(0);
			load(this.tracks.current());
		} else {
			throw new IllegalArgumentException("Length 0.");
		}
	}

	/**
	 * Loads the specified audio track represented by
	 * the specified File object.
	 * @param track A File object.
	 */
	public void load(@NotNull File track) {
		try {
			// Opening audio track.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(track);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Volume control.
			floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			if(mute) floatControl.setValue(-80);

			// The timer.
			Timer timer = new Timer(0, this);
			timer.setInitialDelay((int) clip.getMicrosecondLength() / 1000);
			timer.setRepeats(false);
			timer.start();

		} catch (LineUnavailableException e) {
			throw new RuntimeException("Line not available: " + e);
		} catch (IOException e) {
			throw new RuntimeException("IO error: " + e);
		} catch (UnsupportedAudioFileException e) {
			throw new RuntimeException("Unsupported audio file: " + e);
		}
	}

	@Override
	public boolean addObserver(@NotNull Observer observer) {
		return observerList.add(observer);
	}

	@Override
	public boolean removeObserver(@NotNull Observer observer) {
		return observerList.remove(observer);
	}

	@Override
	public void updateAll() {
		observerList.forEach(observer -> observer.update(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		next();
	}

}