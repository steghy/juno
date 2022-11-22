package juno.model.sound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sound.sampled.*;

import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

public class AudioPlayer
		implements InterfaceAdvancedAudioPlayer, Observable, Runnable{

	private final List<Observer> observerList;
	private Clip clip;
	private Donut<File> tracks;
	private boolean status;
	private FloatControl floatControl;
	private boolean mute;
	private boolean loop;
	private static AudioPlayer instance;

	private AudioPlayer() {
		observerList = new ArrayList<>();
	}

	public static AudioPlayer getInstance() {
		if(instance == null) instance = new AudioPlayer();
		return instance;
	}

	public void play() {
		if(clip != null) {
			status = true;
			clip.start();
			updateAll();
		}
	}

	public void rewind() {
		if(clip != null) {
			clip.setMicrosecondPosition(0L);
			play();
		}
	}

	public void pause() {
		if(status) {
			if(clip != null) {
				status = false;
				clip.stop();
				updateAll();
			}
		}
	}

	public void next() {
		if(tracks != null) {
			if(tracks.getCurrentIndex() == tracks.size() - 1) {
				if(loop) {
					nextTrack();
				} else {
					pause();
				}
			} else {
				nextTrack();
			}
		}
	}

	private void nextTrack() {
		pause();
		tracks.next();
		load(tracks.current());
		play();
	}

	public void back() {
		if(tracks != null) {
			stop();
			load(tracks.previous());
			play();
		}
	}

	public void stop() {
		if(status) {
			pause();
			clip.close();
		}
	}

	public void move(long position) {
		if(position < 0 || position > clip.getMicrosecondLength()) {
			throw new IllegalArgumentException("Invalid input (" + position
			+ ") for length (" + clip.getMicrosecondLength() + ")");
		} else {
			clip.stop();
			clip.close();
			load(this.tracks.current());
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

	public void mute() {
		if(!mute) {
			mute = true;
			floatControl.setValue(-80);
		}
	}

	public void unmute() {
		if(mute) {
			mute = false;
			floatControl.setValue(0);
		}
	}

	public boolean isMuted() {
		return mute;
	}

	public void playEffect(@NotNull final String path) {
		load(new File(path));
		play();
	}

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

	private void load(@NotNull File track) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(track);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			if(mute) {
				floatControl.setValue(-80);
			}
			System.out.println(floatControl.getValue());
		} catch (LineUnavailableException e) {
			throw new RuntimeException("Line not available: " + e);
		} catch (IOException e) {
			throw new RuntimeException("IO error: " + e);
		} catch (UnsupportedAudioFileException e) {
			throw new RuntimeException("Unsupported audio file: " + e);
		}
	}

	@Override
	public void addObserver(@NotNull Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(@NotNull Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void updateAll() {
		observerList.forEach(observer -> observer.update(this));
	}

	@Override
	public void run() {

	}
}