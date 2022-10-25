package juno.view.audio.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.north.ButtonPanel;
import juno.view.audio.north.AudioPlayerButton;
import juno.view.audio.north.NorthPanel;
import juno.view.exception.JButtonNotSetException;
import juno.view.exception.JPanelNotSetException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerNorthPanelTest {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * Nota: La dimensione dei pannelli deve essere effettuata
		 * prima che questi ultimi vengano passati in input al metodo
		 * setPanel(JPanel panel) dei relativi buttoni. 
		 * Nota: La configurazione deve essere fatta in maniera 'Button up'
		 * quindi è necessario configurare e connettere prima i componenti di più
		 * basso livello andando a salire verso quelli di più alto livello.
		 */

		// [AUDIO PLAYER NORTH PANEL] PANELS & BUTTONS
		AudioPlayerButton nextButton = new AudioPlayerButton();
		AudioPlayerButton previousButton = new AudioPlayerButton();
		AudioPlayerButton toggleSwitch = new AudioPlayerButton();
		
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
		} catch (JButtonNotSetException e) {
			e.printStackTrace();
		}
		
		// [AUDIO PLAYER NORTH PANEL] CONNECTION
		NorthPanel northPanel = NorthPanel.getInstance();
		northPanel.setNextPanel(nextPanel);
		northPanel.setTogglePanel(togglePanel);
		northPanel.setPreviousPanel(previousPanel);
		
	
		try {
			northPanel.init();
		} catch (JPanelNotSetException e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.add(northPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}