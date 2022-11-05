package juno.view.audio;

import javax.swing.*;

import juno.controller.audio.AudioPlayerAction;
import juno.init.Paths;
import juno.model.util.PathGenerator;
import juno.view.exception.JLabelNotSetException;
import juno.view.exception.JPanelNotSetException;
import juno.view.util.ButtonConfigurator;
import juno.view.util.ImageResizer;

import java.awt.*;

public class AudioPlayerPanelConfigurator {

	private AudioPlayerPanelConfigurator() {}

	public static void configure() {
		// MAIN-COMPONENT
		AudioPlayerPanel audioPlayerPanel = AudioPlayerPanel.getInstance();

		// MAIN-COMPONENT DIMENSION
		Dimension dimension = new Dimension(300,80);
		audioPlayerPanel.setSize(dimension);
		audioPlayerPanel.setPreferredSize(dimension);
		audioPlayerPanel.setMinimumSize(dimension);
		audioPlayerPanel.setMaximumSize(dimension);

		// GENERATES BUTTON
		JButton next = new JButton();
		JButton back = new JButton();
		JToggleButton toggle = new JToggleButton();
		JLabel background = new JLabel();

		// BUTTON CONFIGURATION
		ButtonConfigurator.configure(next, 78, 60);
		ButtonConfigurator.configure(back, 78, 60);
		ButtonConfigurator.configure(toggle, 78, 60);

		// SETTING BUTTONS
		audioPlayerPanel.setNextButton(next);
		audioPlayerPanel.setBackButton(back);
		audioPlayerPanel.setToggleButton(toggle);
		audioPlayerPanel.setBackground(background);

		// [AUDIO PLAYER MAIN PANEL] IMAGES SETTING
		String backgroundImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "background2.png");
		String nextImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "next.png");
		String backImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "back.png");
		String playImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "play.png");
		String pauseImage = PathGenerator.generate(Paths.AUDIO_PLAYER.getPath(), "pause.png");

		// IMAGES SETTINGS
		next.setIcon(new ImageIcon(ImageResizer.resize(next, nextImage)));
		back.setIcon(new ImageIcon(ImageResizer.resize(back, backImage)));
		toggle.setIcon(new ImageIcon(ImageResizer.resize(toggle, playImage)));
		toggle.setSelectedIcon(new ImageIcon(ImageResizer.resize(toggle, pauseImage)));
		background.setIcon(new ImageIcon(ImageResizer.resize(audioPlayerPanel, backgroundImage)));

		// ACTION SETTINGS
		next.addActionListener(AudioPlayerAction.getInstance());
		back.addActionListener(AudioPlayerAction.getInstance());
		toggle.addActionListener(AudioPlayerAction.getInstance());

		// ACTION COMMAND SETTINGS
		next.setActionCommand(AudioPlayerAction.nextButton);
		back.setActionCommand(AudioPlayerAction.backButton);
		toggle.setActionCommand(AudioPlayerAction.toggleButton);

		// [AUDIO PLAYER MAIN PANEL] INITIALIZATION
		try {
			audioPlayerPanel.init();
		} catch (JPanelNotSetException | JLabelNotSetException e) {
			e.printStackTrace();
		}
	}
}