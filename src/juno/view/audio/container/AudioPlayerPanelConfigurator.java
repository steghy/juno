package juno.view.audio.container;

import javax.swing.ImageIcon;
import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.panel.Panel;
import juno.view.exception.JLabelNotSetException;
import juno.view.exception.JPanelNotSetException;

public class AudioPlayerPanelConfigurator {

	private AudioPlayerPanelConfigurator() {}

	public static void configure() {

		// [AUDIO PLAYER MAIN PANEL] PANELS & BACKGROUND
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		Background background = Background.getInstance();

		background.setPanel(audioPlayerPanel);
		
		// [AUDIO PLAYER MAIN PANEL] IMAGES SETTING
		String backgroundImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "background-6.gif");
		
		background.setIcon(new ImageIcon(backgroundImage));

		// [AUDIO PLAYER MAIN PANEL] CONNECTION
		audioPlayerPanel.setBackground(background);
		audioPlayerPanel.setPanel(Panel.getInstance());

		// [AUDIO PLAYER MAIN PANEL] INITIALIZATION
		try {
			audioPlayerPanel.init();
		} catch (JPanelNotSetException | JLabelNotSetException e) {
			e.printStackTrace();
		}
	}
}