package juno.model.sound.test;

import juno.init.Directories;
import juno.model.sound.AudioPlayer;

import java.io.File;
import java.util.Scanner;

public class AudioPlayerTester {
	
	public static void main(String[] args) {

		// MUSIC PATH
		String musicDirectory = Directories.MUSIC.absolutePath();
		File directory = new File(musicDirectory);

		// AUDIO PLAYER INITIALIZATION
		AudioPlayer audioPlayer = AudioPlayer.getInstance();
		audioPlayer.setTracks(directory.listFiles());
		// audioPlayer.setLoop(true);

		// GETS INPUTS
		Scanner scanner = new Scanner(System.in);
		while(true) {

			if(scanner.hasNextInt()) {
				int value = scanner.nextInt();


				// PREVIOUS
				if(value == 1) {
					audioPlayer.back();
				}

				// PAUSE
				else if(value == 2) {
					audioPlayer.pause();
				}

				// PLAY
				else if(value == 3) {
					audioPlayer.play();
				}

				// REWIND
				else if(value == 4) {
					audioPlayer.rewind();
				}

				// NEXT
				else if(value == 5) {
					audioPlayer.next();
				}

				// STOP
				else if(value == 6) {
					audioPlayer.stop();
				}

				else {
					System.out.println("invalid input");
				}
			}
		}
	}
}