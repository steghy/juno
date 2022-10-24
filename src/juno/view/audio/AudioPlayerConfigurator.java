package juno.view.audio;

import javax.swing.ImageIcon;
import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.north.NextButton;
import juno.view.audio.north.PreviousButton;
import juno.view.audio.north.ToggleSwitch;
import juno.view.audio.south.SouthBackground;
import juno.view.audio.south.SouthPanel;
import juno.view.exception.JButtonNotSettedException;
import juno.view.exception.JLabelNotSettedException;
import juno.view.exception.JPanelNotSettedException;
import juno.view.audio.north.NorthPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerConfigurator {

	// NO INSTANCE 
	private AudioPlayerConfigurator() {}
	
	/**
	 * Configure the AudioPlayer component
	 */
	public static void configure() {
		
		// [MAIN BACKGROUND] 
		MainBackground mainBackground = MainBackground.getInstance();
		
		// [MAIN BACKGROUND] IMAGE PATH
		String mainBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "main-background.png");
		
		// [MAIN BACKGROUND] SETTING ICON
		mainBackground.setIcon(new ImageIcon(mainBackgroundImage));

		// [NORTH PANEL] BUTTONS
		NextButton nextButton = NextButton.getInstance();
		ToggleSwitch toggleSwitch = ToggleSwitch.getInstance();
		PreviousButton previousButton= PreviousButton.getInstance();
		
		// [NORTH PANEL] BUTTONS IMAGES PATH
		String nextButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "next.png");
		String toggleSwitchImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "toggle.png");
		String previousButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "previous.png");
		
		// [NORTH PANEL] SETTING ICONS
		nextButton.setIcon(new ImageIcon(nextButtonImage));
		toggleSwitch.setIcon(new ImageIcon(toggleSwitchImage));
		previousButton.setIcon(new ImageIcon(previousButtonImage));
		
		// [NORTH PANEL] CONNECTION
		NorthPanel northPanel = NorthPanel.getInstance();
		northPanel.setNextButton(nextButton);
		northPanel.setToggleButton(toggleSwitch);
		northPanel.setPreviousButton(previousButton);
		
		// [NORTH PANEL] INITIALIZATION
		try {
			northPanel.init();
		} catch (JButtonNotSettedException e) {
			e.printStackTrace();
		}
		
		// [SOUTH PANEL] BACKGROUND
		SouthBackground southPanelBackground = SouthBackground.getInstance();
		
		// [SOUTH PANEL] BACKGROUND PATH
		String southPanelBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "audio-animation.gif");
		
		// [SOUTH PANEL] SETTING ICONS
		southPanelBackground.setIcon(new ImageIcon(southPanelBackgroundImage));
		
		// [SOUTH PANEL] CONNECTION
		SouthPanel southPanel = SouthPanel.getInstance();
		southPanel.setBackground(southPanelBackground);
		
		southPanelBackground.setPanel(southPanel); // PANEL CONNECTION
		
		// [SOUTH PANEL] INITIALIZATION
		try {
			southPanel.init();
		} catch (JLabelNotSettedException e) {
			e.printStackTrace();
		}

		// [MAIN PANEL] SETTING COMPONENTS
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		audioPlayerPanel.setBackground(mainBackground);
		audioPlayerPanel.setNorthPanel(northPanel);
		audioPlayerPanel.setSouthPanel(southPanel);
		
		mainBackground.setPanel(audioPlayerPanel); // PANEL CONNECTION

		// [MAIN PANEL] INITIALIZATION
		try {
			audioPlayerPanel.init();
		} catch (JPanelNotSettedException | JLabelNotSettedException e) {
			e.printStackTrace();
		}
	}
}