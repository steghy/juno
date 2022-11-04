package juno.view.audio.test;

import java.awt.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.border.Border;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;
import juno.model.util.PathGenerator;
import juno.view.audio.AudioPlayerPanelConfigurator;
import juno.view.audio.AudioPlayerPanel;

public class AudioPlayerTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// AUDIO PLAYER CONFIGURATION
		AudioPlayer audioPlayer = AudioPlayer.getInstance();
		String audioTracksPath = PathGenerator.generate(Paths.AUDIO.getPath(), "music-1");
		audioPlayer.setTracks((new File(audioTracksPath)).listFiles());

		AudioPlayerPanelConfigurator.configure();

		frame.add(AudioPlayerPanel.getInstance(), BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
}