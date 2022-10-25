package juno.view.audio.test;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import juno.main.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.audio.south.SouthBackground;
import juno.view.audio.south.SouthPanel;
import juno.view.exception.JLabelNotSettedException;

/**
 * AudioPlayerSouthPanel tester
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerNorthSouthTester {

	/**
	 * Main method
	 * @param args The arguments
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
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(southPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
