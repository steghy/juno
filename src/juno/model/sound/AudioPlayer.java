package juno.model.sound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import juno.main.init.Paths;
import juno.model.util.PathGenerator;

/**
 * Audio Player class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayer {
	
	public static final int ACTIVE = 1;
	
	/* Paused status */
	public static final int INACTIVE = 0; 

	/* List of all files */
	private ArrayList<File> tracks;
	
	/* AudioInputStream component */
	private AudioInputStream audioInputStream;
	
	/* Clip component */
	private Clip clip;
	
	/* Track position */
	private long trackMicrosecondsPosition;
	
	/* Dynamic status */
	private int status;

	/* Track index */
	private int trackIndex;
	
	/* The AudioPlayer instance */
	private static AudioPlayer instance;
	
	
	/* Builds the AudioPlayer instance */
	private AudioPlayer() {
		init();
	}

	
	/**
	 * Returns the AudioPlayer instance
	 * @return The AudioPlayer instance 
	 */
	public static AudioPlayer getInstance() {
		if(instance == null) {
			instance = new AudioPlayer();
		} return instance;
	}
	
	
	/** Start the AudioPlayer process */
	public void play() {
		clip.start();
		status = AudioPlayer.ACTIVE;
	}
	
	
	/** Restart the current track */
	public void restart() {
		clip.stop();
		clip.close();
		resetAudioPlayer();
		trackMicrosecondsPosition = 0L;
		clip.setMicrosecondPosition(trackMicrosecondsPosition);
		clip.start();
	}

	
	/** Resume the current track */
	public void resume() {
		if(status == AudioPlayer.INACTIVE) {
			clip.close();
			resetAudioPlayer();
			clip.setMicrosecondPosition(trackMicrosecondsPosition);
			play();
		} else {
			throw new IllegalArgumentException(""
					+ "AudioPlayer instance is not running.");
		}
	}
	
	
	/** Stops the current audio track */
	public void stop() {
		trackMicrosecondsPosition = this.clip.getMicrosecondPosition();
		clip.stop();
		clip.close();
		status = AudioPlayer.INACTIVE;
	}
	
	
	/** Plays the next track */
	public void next() {
		stop();
		if(trackIndex == tracks.size() - 1) {
			trackIndex = 0;
		} else {
			trackIndex++;
		}
		play();
	}
	
	
	/** Plays the previous track */
	public void previous() {
		if(trackIndex == 0) {
			trackIndex = tracks.size() - 1;
		} else {
			trackIndex--;
		}
		play();
	}

	
	/**
	 * Returns true if the status is 'Play' 
	 * @return A boolean value
	 */
	public boolean isRunning() {
		return status == AudioPlayer.ACTIVE;
	}

	
	/**
	 * Returns the AudioInputStream component of this instance
	 * @return The AudioInputStream component of this instance
	 */
	public AudioInputStream getAudioInputStream() {
		return audioInputStream;
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
		return tracks;
	}

	
	/* Initializes the AudioPlayer instance */
	private void init() {
		tracks = new ArrayList<File>();
		String musicDirectoryPath = Paths.MUSIC.getPath();
		File musicDirectory = new File(musicDirectoryPath);
		for(String fileName : musicDirectory.list()) {
			String fileNamePath = PathGenerator.generate(musicDirectoryPath, fileName);
			if(fileNamePath.endsWith(".wav")) 
				tracks.add(new File(fileNamePath));
		} resetAudioPlayer();  // Sets the AudioInputStream object and Clip object
	}

	
	/* Reset the AudioPlayer instance */
	private void resetAudioPlayer() {
		try {
			audioInputStream = AudioSystem
					.getAudioInputStream(tracks.get(trackIndex).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
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