package juno.view.audio.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.north.ButtonPanel;
import juno.view.audio.north.NextButton;
import juno.view.audio.north.NorthPanel;
import juno.view.audio.north.PreviousButton;
import juno.view.audio.north.ToggleSwitch;
import juno.view.exception.JButtonNotSettedException;
import juno.view.exception.JPanelNotSettedException;

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
	
		try {
			northPanel.init();
		} catch (JPanelNotSettedException e) {
			e.printStackTrace();
		}
		

		JFrame frame = new JFrame();
		frame.add(northPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
