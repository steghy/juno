package juno.model.sound.test;

import java.io.File;

import javax.sound.sampled.Clip;

import juno.exception.FileNotFoundException;
import juno.exception.NotADirectoryException;
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
		AudioPlayer player;
		try {
			player = AudioPlayer.getInstance();
			System.out.println("AudioPlayer initialization successful");
			player.play();
			System.out.println("Current Player status: " + (player.isRunning() ? "ON" : "OFF"));
			for(File file : player.getMusicFiles()) {
				System.out.print(file.getAbsolutePath());
				System.out.println(" | EXISTS: " + (file.exists() ? "TRUE" : "FALSE"));
			}
			
			Clip clip = player.getClipComponent();
			System.out.println("Clip | LINE_INFO: " + clip.getLineInfo());
			System.out.println("Clip | ACTIVE: " + (clip.isActive() ? "TRUE" : "FALSE"));
			System.out.println("Clip | OPEN: " + (clip.isOpen() ? "TRUE" : "FALSE"));
			System.out.println("Clip | RUNNING: " + (clip.isRunning() ? "TRUE" : "FALSE"));
			
		} catch (FileNotFoundException | NotADirectoryException e) {
			e.printStackTrace();
		}

	}
}
