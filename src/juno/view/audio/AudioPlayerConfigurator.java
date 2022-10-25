package juno.view.audio;

import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.north.AudioPlayerButton;
import juno.view.audio.north.ButtonPanel;
import juno.view.audio.north.NorthPanel;
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

		/*
		 * Nota: La dimensione dei pannelli deve essere effettuata
		 * prima che questi ultimi vengano passati in input al metodo
		 * setPanel(JPanel panel) dei relativi buttoni. 
		 * Nota: La configurazione deve essere fatta in maniera 'Button up'
		 * quindi è necessario configurare e connettere prima i componenti di più
		 * basso livello andando a salire verso quelli di più alto livello.
		 */

		/********************* NORTH PANEL ************************************/

		// [AUDIO PLAYER NORTH PANEL] PANELS & BUTTONS
		AudioPlayerButton nextButton = new AudioPlayerButton();
		AudioPlayerButton previousButton = new AudioPlayerButton();
		AudioPlayerButton toggleSwitch = new AudioPlayerButton();
		
		nextButton.setPreferredSize(new Dimension(30, 30));
		
		ButtonPanel nextPanel = new ButtonPanel(nextButton);
		ButtonPanel previousPanel = new ButtonPanel(previousButton);
		ButtonPanel togglePanel = new ButtonPanel(toggleSwitch);
		
		nextButton.setPanel(nextPanel);
		previousButton.setPanel(previousPanel);
		toggleSwitch.setPanel(togglePanel);

		// [AUDIO PLAYER NORTH PANEL] IMAGE SETTING 
		String nextButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "next.png");
		String toggleSwitchImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "toggle.png");
		String previousButtonImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "previous.png");
		
		nextButton.setIcon(new ImageIcon(nextButtonImage));
		toggleSwitch.setIcon(new ImageIcon(toggleSwitchImage));
		previousButton.setIcon(new ImageIcon(previousButtonImage));
		
		// [AUDIO PLAYER NORTH PANEL] INITIALIZATION
		try {
			nextPanel.init();
			previousPanel.init();
			togglePanel.init();
		} catch (JButtonNotSettedException e) {
			e.printStackTrace();
		}
		
		// [AUDIO PLAYER NORTH PANEL] CONNECTION
		NorthPanel northPanel = NorthPanel.getInstance();
		northPanel.setNextPanel(nextPanel);
		northPanel.setTogglePanel(togglePanel);
		northPanel.setPreviousPanel(previousPanel);
		
	
		try {
			northPanel.init();
		} catch (JPanelNotSettedException e) {
			e.printStackTrace();
		}
		
		/******************** SOUTH PANEL **********************************/

		// [AUDIO PLAYER SOUTH PANEL] BACKGROUND & PANELS
		SouthPanel southPanel = SouthPanel.getInstance();
		SouthBackground southPanelBackground = SouthBackground.getInstance();
		
		southPanel.setBackground(southPanelBackground);
		southPanelBackground.setPanel(southPanel); 
		
		// [AUDIO PLAYER SOUTH PANEL] IMAGE SETTING
		String southPanelBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "audio-animation.gif");
		
		southPanelBackground.setIcon(new ImageIcon(southPanelBackgroundImage));
		
		// [AUDIO PLAYER SOUTH PANEL] INITIALIZATION
		try {
			southPanel.init();
		} catch (JLabelNotSettedException e) {
			e.printStackTrace();
		}

		/******************** MAIN PANEL ***************************************/

		// [AUDIO PLAYER MAIN PANEL] PANELS & BACKGROUND
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();
		MainBackground mainBackground = MainBackground.getInstance();

		mainBackground.setPanel(audioPlayerPanel); 
		
		// [AUDIO PLAYER MAIN PANEL] IMAGES SETTING
		String mainBackgroundImage = PathGenerator.generate(Paths.AUDIOPLAYER.getPath(), "pngwing.com.png");
		
		mainBackground.setIcon(new ImageIcon(mainBackgroundImage));

		// [AUDIO PLAYER MAIN PANEL] CONNECTION
		audioPlayerPanel.setBackground(mainBackground);
		audioPlayerPanel.setNorthPanel(northPanel);
		audioPlayerPanel.setSouthPanel(southPanel);


		// [AUDIO PLAYER MAIN PANEL] INITIALIZATION
		try {
			audioPlayerPanel.init();
		} catch (JPanelNotSettedException | JLabelNotSettedException e) {
			e.printStackTrace();
		}
	}
}