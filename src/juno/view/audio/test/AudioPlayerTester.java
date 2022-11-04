package juno.view.audio.test;

import java.awt.Container;
import java.io.File;
import javax.swing.JFrame;

import juno.init.Paths;
import juno.model.sound.AudioPlayer;
import juno.model.util.PathGenerator;
import juno.view.audio.container.AudioPlayerPanelConfigurator;
import juno.view.audio.container.AudioPlayerPanel;
import juno.view.audio.panel.PanelConfigurator;

public class AudioPlayerTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// AUDIO PLAYER CONFIGURATION
		AudioPlayer audioPlayer = AudioPlayer.getInstance();
		String audioTracksPath = PathGenerator.generate(Paths.AUDIO.getPath(), "music-1");
		audioPlayer.setTracks((new File(audioTracksPath)).listFiles());

		PanelConfigurator.configure();
		AudioPlayerPanelConfigurator.configure();

		Container container = frame.getContentPane();
		container.add(AudioPlayerPanel.getInstance());

		frame.pack();
		frame.setVisible(true);
	}
}