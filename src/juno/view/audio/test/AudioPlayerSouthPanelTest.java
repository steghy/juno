package juno.view.audio.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.south.SouthBackground;
import juno.view.audio.south.SouthPanel;
import juno.view.exception.JLabelNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerSouthPanelTest {

	/**
	 * Main method
	 * @param args The arguments
	 */
	public static void main(String[] args) {

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
		
		
		JFrame frame = new JFrame();
		frame.add(southPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}