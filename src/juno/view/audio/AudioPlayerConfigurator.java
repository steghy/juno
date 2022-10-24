package juno.view.audio;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.north.ButtonPanel;
import juno.view.audio.north.NextButton;
import juno.view.audio.north.NorthPanel;
import juno.view.audio.north.PreviousButton;
import juno.view.audio.north.ToggleSwitch;
import juno.view.audio.south.SouthBackground;
import juno.view.audio.south.SouthPanel;
import juno.view.exception.JButtonNotSettedException;
import juno.view.exception.JLabelNotSettedException;
import juno.view.exception.JPanelNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerConfigurator {

	// NO INSTANCE 
	private AudioPlayerConfigurator() {}

	public static void checkImagesPath() {
		File directory = new File(Paths.AUDIOPLAYER.getPath());
		for(String fileName : directory.list()) {
			String path = PathGenerator.generate(directory.getAbsolutePath(), fileName);
			System.out.println(path + " | exists: " + ((new File(path).exists())));
		}
	}
	
	
	/*
	 * Configure the AudioPlayer component
	 */
	public static void configure() {
		
		checkImagesPath();
		
		/********************** NORTH PANEL *********************************/
		
		// [AUDIO PLAYER NORTH PANEL] BUTTONS
		NextButton nextButton = NextButton.getInstance();
		ToggleSwitch toggleSwitch = ToggleSwitch.getInstance();
		PreviousButton previousButton= PreviousButton.getInstance();
		
		ButtonPanel nextPanel = new ButtonPanel(nextButton);
		ButtonPanel previousPanel = new ButtonPanel(previousButton);
		ButtonPanel togglePanel = new ButtonPanel(toggleSwitch);
		
		try {
			nextPanel.init();
			previousPanel.init();
			togglePanel.init();
		} catch (JButtonNotSettedException e) {
			e.printStackTrace();
		}

		nextButton.setPanel(nextPanel);
		previousButton.setPanel(previousPanel);
		toggleSwitch.setPanel(togglePanel);
		
		// [AUDIO PLAYER NORTH PANEL] CONNECTION
		NorthPanel northPanel = NorthPanel.getInstance();
		northPanel.setNextPanel(nextPanel);
		northPanel.setTogglePanel(togglePanel);
		northPanel.setPreviousPanel(previousPanel);
		
		// [AUDIO PLAYER NORTH PANEL] BUTTONS IMAGES PATH
		String nextButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "next.png");
		String toggleSwitchImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "toggle.png");
		String previousButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "previous.png");
		
		// [AUDIO PLAYER NORTH PANEL] SETTING ICONS
		nextButton.setIcon(new ImageIcon(nextButtonImage));
		toggleSwitch.setIcon(new ImageIcon(toggleSwitchImage));
		previousButton.setIcon(new ImageIcon(previousButtonImage));
		

		// [AUDIO PLAYER NORTH PANEL] INITIALIZATION
		try {
			northPanel.init();
		} catch (JPanelNotSettedException e) {
			e.printStackTrace();
		}
		
		/******************** SOUTH PANEL **********************************/

		// [AUDIO PLAYER SOUTH PANEL] CONNECTION
		SouthPanel southPanel = SouthPanel.getInstance();
		SouthBackground southPanelBackground = SouthBackground.getInstance();
		southPanel.setBackground(southPanelBackground);
		southPanelBackground.setPanel(southPanel); 
		
		// [AUDIO PLAYER SOUTH PANEL] BACKGROUND PATH
		String southPanelBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "audio-animation.gif");
		
		// [AUDIO PLAYER SOUTH PANEL] SETTING ICONS
		southPanelBackground.setIcon(new ImageIcon(southPanelBackgroundImage));
		
		// [AUDIO PLAYER SOUTH PANEL] INITIALIZATION
		try {
			southPanel.init();
		} catch (JLabelNotSettedException e) {
			e.printStackTrace();
		}

		/******************** MAIN PANEL ***************************************/

		// [AUDIO PLAYER MAIN PANEL] SETTING COMPONENTS
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		MainBackground mainBackground = MainBackground.getInstance();
		audioPlayerPanel.setBackground(mainBackground);
		audioPlayerPanel.setNorthPanel(northPanel);
		audioPlayerPanel.setSouthPanel(southPanel);
		mainBackground.setPanel(audioPlayerPanel); 

		// [AUDIO PLAYER MAIN PANEL BACKGROUND] IMAGE PATH
		String mainBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "main-background.png");
		
		// [AUDIO PLAYER MAIN PANEL BACKGROUND] SETTING ICON
		mainBackground.setIcon(new ImageIcon(mainBackgroundImage));

		// [AUDIO PLAYER MAIN PANEL] INITIALIZATION
		try {
			audioPlayerPanel.init();
		} catch (JPanelNotSettedException | JLabelNotSettedException e) {
			e.printStackTrace();
		}
		
		
		JFrame frame = new JFrame();
		frame.add(audioPlayerPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		configure();
	}
}