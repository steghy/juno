package juno.model.sound.test;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;

/**
 * AudioPlayerTester class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerTester {
	
	/**
	 * Main method
	 * @param args The arguments
	 */
	public static void main(String[] args) {

		// MUSIC PATH
		String musicDirectory = Paths.MUSIC.getPath();

		// INITIALIZE THE AUDIO PLAYER INSTANCE
		AudioPlayer audioPlayer = AudioPlayer.getInstance();
		audioPlayer.setTracks(musicDirectory);



	}
}