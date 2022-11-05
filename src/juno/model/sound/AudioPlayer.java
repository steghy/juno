package juno.model.sound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

public class AudioPlayer implements AbstractAdvancedAudioPlayer, Subject {

	private final List<Observer> observerList;
	private Clip clip;
	private Donut<File> tracks;
	private boolean status;
	private boolean loop;
	private static AudioPlayer instance;

	private AudioPlayer() {
		observerList = new ArrayList<>();
	}

	public static AudioPlayer getInstance() {
		if(instance == null) {
			instance = new AudioPlayer();
		} return instance;
	}

	public void play() {
		status = true;
		clip.start();
		updateAll();
	}

	public void rewind() {
		clip.setMicrosecondPosition(0L);
		play();
	}

	public void pause() {
		if(status) {
			status = false;
			clip.stop();
			updateAll();
		}
	}

	public void next() {
		stop();
		tracks.next();
		if(tracks.getCurrentIndex() == 0) {
			if(loop) {
				init(tracks.current());
				play();
			} else {
				pause();
			} updateAll();
		}
	}

	public void back() {
		stop();
		init(this.tracks.previous());
		play();
	}

	public void stop() {
		status = false;
		clip.stop();
		clip.close();
		updateAll();
	}

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
			updateAll();
		}
	}


	public void setLoop(boolean value) {
		loop = value;
	}

	public Clip getClip() {
		return clip;
	}

	public boolean isRunning() {
		return status;
	}

	public boolean isLooped() {
		return loop;
	}

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

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void updateAll() {
		observerList.forEach(observer -> observer.update(this));
	}
}