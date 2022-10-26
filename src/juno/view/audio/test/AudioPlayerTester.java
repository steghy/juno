package juno.view.audio.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;
import java.util.Objects;
import javax.swing.JFrame;
import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.AudioPlayerConfigurator;
import juno.view.audio.AudioPlayerPanel;

/**
 * Audio Player class tester 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerTester {

	public static void checkImagesPath() {
		File directory = new File(Paths.AUDIOPLAYER.getPath());
		for(String fileName : Objects.requireNonNull(directory.list())) {
			String path = PathGenerator.generate(directory.getAbsolutePath(), fileName);
			System.out.println(path + " | exists: " + ((new File(path).exists())));
		}

	}

	/**
	 * Main method
	 * @param args The arguments
	 */
	public static void main(String[] args) {

		checkImagesPath();

		// FRAME SETTINGS
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// AUDIO PLAYER SETTINGS
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		AudioPlayerConfigurator.configure();
		
		// CONNECTION
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(audioPlayerPanel, BorderLayout.NORTH);
		
		frame.pack();
		
		// VISIBLE
		frame.setVisible(true);
	}
}