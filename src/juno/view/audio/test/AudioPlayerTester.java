package juno.view.audio.test;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import juno.view.audio.AudioPlayerConfigurator;
import juno.view.audio.AudioPlayerPanel;

/**
 * Audio Player class tester 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerTester {

	/**
	 * Main method
	 * @param args The arguments
	 */
	public static void main(String[] args) {

		// FRAME SETTINGS
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1400, 800);

		// AUDIO PLAYER SETTINGS
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		AudioPlayerConfigurator.configure();
		
		// CONNECTION
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(audioPlayerPanel);
		
		// VISIBLE
		frame.setVisible(true);
	}
}