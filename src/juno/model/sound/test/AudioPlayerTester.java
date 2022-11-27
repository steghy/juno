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