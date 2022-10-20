package juno.model.sound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import juno.exception.FileNotFoundException;
import juno.exception.NotADirectoryException;
import juno.main.init.Paths;
import juno.model.util.PathGenerator;

/**
 * Audio Player class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayer {
	
	/* Play status */
	public static final int PLAY = 1;
	
	/* Paused status */
	public static final int PAUSED = 0;

	/* List of all files */
	private ArrayList<File> files;
	
	/* AudioInputStream component */
	private AudioInputStream audioInputStream;
	
	/* Clip component */
	private Clip clip;
	
	/* Track position */
	private long position;
	
	/* Dynamic status */
	private int status;

	/* Actual index audio */
	private int index;
	
	/* The AudioPlayer instance */
	private static AudioPlayer instance;
	
	
	/* Builds the AudioPlayer instance */
	private AudioPlayer() throws FileNotFoundException, NotADirectoryException {
		init();
	}

	/**
	 * Returns the AudioPlayer instance
	 * @return The AudioPlayer instance 
	 * @throws NotADirectoryException 
	 * @throws FileNotFoundException 
	 */
	public static AudioPlayer getInstance() throws FileNotFoundException, NotADirectoryException {
		if(instance == null) {
			instance = new AudioPlayer();
		} return instance;
	}
	
	
	/** Start the AudioPlayer process */
	public void play() {
		clip.start();
		status = AudioPlayer.PLAY;
	}
	
	
	/** Restart the current track */
	public void restart() {
		clip.stop();
		clip.close();
		resetAudioPlayer();
		position = 0L;
		clip.setMicrosecondPosition(position);
		clip.start();
	}

	
	/** Resume the current track */
	public void resume() {
		if(status == AudioPlayer.PAUSED) {
			clip.close();
			resetAudioPlayer();
			clip.setMicrosecondPosition(position);
			play();
		} else {
			throw new IllegalArgumentException(""
					+ "AudioPlayer instance is not running.");
		}
	}
	
	
	/** Stops the current audio track */
	public void stop() {
		position = this.clip.getMicrosecondPosition();
		clip.stop();
		clip.close();
		status = AudioPlayer.PAUSED;
	}
	
	
	/** Plays the next track */
	public void next() {
		stop();
		if(index == files.size() - 1) {
			index = 0;
		} else {
			index++;
		}
		play();
	}
	
	
	/** Plays the previous track */
	public void previous() {
		if(index == 0) {
			index = files.size() - 1;
		} else {
			index--;
		}
		play();
	}

	
	/**
	 * Returns true if the status is 'Play' 
	 * @return A boolean value
	 */
	public boolean isRunning() {
		return status == AudioPlayer.PLAY;
	}
	
	/**
	 * Returns the AudioInputStream component of this instance
	 * @return The AudioInputStream component of this instance
	 */
	public AudioInputStream getAudioInputStream() {
		return audioInputStream;
	}
	
	/**
	 * Returns the current track position
	 * @return The current track position
	 */
	public long getCurrenTrackPosition() {
		return position;
	}
	
	
	/**
	 * Returns the Clip component of this object
	 * @return The Clip component of this object
	 */
	public Clip getClipComponent() {
		return this.clip;
	}
	
	/**
	 * Returns the music files
	 * @return An ArrayList<File>
	 */
	public ArrayList<File> getMusicFiles(){
		return files;
	}

	/* Initializes the AudioPlayer instance */
	private void init() {
		
		// First track index
		this.index = 0;

		// Music files initialization
		files = new ArrayList<File>();

		String musicDirectoryPath = Paths.MUSIC.getPath();
		File musicDirectory = new File(musicDirectoryPath);
		for(String fileName : musicDirectory.list()) {
			String path = PathGenerator.generate(musicDirectoryPath, fileName);
			files.add(new File(path));
		}

		resetAudioPlayer();
	}

	
	/* Reset the AudioPlayer instance */
	private void resetAudioPlayer() {
		try {
			clip = AudioSystem.getClip();
			audioInputStream = AudioSystem
					.getAudioInputStream(files.get(index).getAbsoluteFile());
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace(); 
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}