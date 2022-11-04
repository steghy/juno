package juno.model.sound;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import juno.model.util.Donut;

/**
 * @author steghy
 */
public class AudioPlayer implements Runnable, AbstractAdvancedAudioPlayer {

	private Clip clip;
	private Donut<File> tracks;
	private boolean status;
	private boolean loop;
	private static AudioPlayer instance;
	private AudioPlayer() {}

	/**
	 * Returns the AudioPlayer instance
	 * @return The AudioPlayer instance 
	 */
	public static AudioPlayer getInstance() {
		if(instance == null) {
			instance = new AudioPlayer();
		} return instance;
	}

	/**
	 * Play the current track from
	 * the beginning.
	 */
	public void play() {
		status = true;
		clip.start();
	}

	/**
	 * Rewind the audio track.
	 */
	public void rewind() {
		clip.setMicrosecondPosition(0L);
		play();
	}

	/**
	 * Pause the audio player.
	 */
	public void pause() {
		if(status) {
			status = false;
			clip.stop();
		}
	}

	/**
	 * Plays the next audio track.
	 */
	public void next() {
		stop();
		tracks.next();
		init(tracks.current());
		play();
	}

	/**
	 * Plays the previous audio track.
	 */
	public void previous() {
		stop();
		init(this.tracks.previous());
		play();
	}

	/**
	 * Stop the audio player
	 */
	public void stop() {
		status = false;
		clip.stop();
		clip.close();
	}

	/**
	 * Jumps to the specified position
	 * @param position A long value
	 */
	public void move(long position) {
		if(position < 0 || position > clip.getMicrosecondLength()) {
			throw new IllegalArgumentException("Invalid input (" + position
			+ ") for length (" + clip.getMicrosecondLength() + ")");
		} else {
			clip.stop();
			clip.close();
			init(this.tracks.current());
			clip.setMicrosecondPosition(position);
			clip.start();
			status = true;
		}
	}

	/**
	 * Sets the audio sound to play with this AudioPlayer instance.
	 * @param tracks An array of File objects
	 */
	public void setTracks(File[] tracks) {
		if(tracks != null && tracks.length > 0) {
			this.tracks = new Donut<>();
			this.tracks.addAll(Arrays.asList(tracks));
			this.tracks.initialize(0);
			init(this.tracks.current());
		} else {
			throw new IllegalArgumentException("Invalid input");
		}
	}

	@Override
	public void run() {
		if(clip == null) {
			throw new IllegalArgumentException(
					"AudioPlayer instance isn't initialized"
			);
		} while(true) {
			this.play();
			try {
				TimeUnit.MICROSECONDS.sleep(clip.getMicrosecondLength());
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			} if(loop) {
				next();
			} else {
				break;
			}
		} stop();
	}

	/**
	 * Sets the loop parameter.
	 * @param value A boolean
	 */
	public void loop(boolean value) {
		loop = value;
	}

	/**
	 * Returns the Clip object of this instance
	 * @return The Clip object of this instance
	 */
	public Clip getClip() {
		return clip;
	}

	/**
	 * Initialize the AudioPlayer instance with the specified
	 * File object.
	 * @param track An object of type File.
	 */
	private void init(File track) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(track);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			throw new RuntimeException("Line not available: " + e);
		} catch (IOException e) {
			throw new RuntimeException("IO error: " + e);
		} catch (UnsupportedAudioFileException e) {
			throw new RuntimeException("Unsupported audio file: " + e);
		}
	}
}