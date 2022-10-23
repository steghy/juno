package juno.view.audio;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;

public class AudioPlayerPanelTester {

	public static void main(String[] args) {
		// AudioPlayer components
		NextButton nextButton = NextButton.getInstance();
		PreviousButton previousButton = PreviousButton.getInstance();
		ToggleSwitch toggleButton = ToggleSwitch.getInstance();

		
		String previousImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "previous.png");

		String toggleImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "play.png");
		
		String nextImage = PathGenerator
				.generate(Paths.AUDIOPLAYER.getPath(), "next.png");

		
		// AudioPlayer components Settings
		nextButton.setIcon(new ImageIcon(nextImage));
		previousButton.setIcon(new ImageIcon(previousImage));
		toggleButton.setIcon(new ImageIcon(toggleImage));
		
		
		JFrame frame = new JFrame();
		AudioPlayerPanel panel = AudioPlayerPanel.getInstance();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		panel.setVisible(true);
	}
}
