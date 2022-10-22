package juno.model.sound.test;

import java.io.File;
import javax.sound.sampled.Clip;
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
		player = AudioPlayer.getInstance();
		System.out.println("AudioPlayer initialization successful");
		player.play();
		System.out.println("Current Player status: " + (player.isRunning() ? "ON" : "OFF"));
		
		// Checks file
		for(File file : player.getMusicFiles()) {
			System.out.print(file.getAbsolutePath());
			System.out.println(" | EXISTS: " + (file.exists() ? "TRUE" : "FALSE"));
		}
	
		// Clip status 
		Clip clip = player.getClipComponent();
		System.out.println("Clip | LINE_INFO: " + clip.getLineInfo());
		System.out.println("Clip | ACTIVE: " + (clip.isActive() ? "TRUE" : "FALSE"));
		System.out.println("Clip | OPEN: " + (clip.isOpen() ? "TRUE" : "FALSE"));
		System.out.println("Clip | RUNNING: " + (clip.isRunning() ? "TRUE" : "FALSE"));
		
		long songMicrosecondLength = clip.getMicrosecondLength();
		System.out.println("Song length in second: " + songMicrosecondLength / 1000000);
		System.out.println("Song length in microsecond: " + songMicrosecondLength);
		int min = 0;
		long sec = 0L;
		while(clip.getMicrosecondPosition() != songMicrosecondLength) {
			sec += 1;
			if(sec == 60) {
				sec = 0;
				min += 1;
			}
			System.out.println(min + ":" + sec);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}