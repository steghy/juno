package juno.view.audio;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * PlayerPanel Class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* AudioPlayerPanel instance */
	private static AudioPlayerPanel instance;
	
	/* 'next' AudioPlayer button */
	private JButton nextButton;
	
	/* 'previous' AudioPlayer button */
	private JButton previousButton;
	
	/* 'stop' AudioPlayer button */
	private JButton toggleButton;
	
	/* Builds AudioPlayerPanel instance */
	private AudioPlayerPanel() {
		init();
	}
	
	/**
	 * Returns the AudioPlayerPanel instance
	 * @return The AudioPlayerPanel instance
	 */
	public static AudioPlayerPanel getInstance() {
		if(instance == null) {
			instance = new AudioPlayerPanel();
		} return instance;
	}
	
	
	/* Initialize the AudioPlayerPanel button */
	private void init() {

		// Buttons settings
		this.nextButton = NextButton.getInstance();
		this.previousButton = PreviousButton.getInstance();
		this.toggleButton = ToggleSwitch.getInstance();

		// Layout
		this.setLayout(new FlowLayout());
		this.add(this.previousButton, 0);
		this.add(this.toggleButton, 1);
		this.add(this.nextButton, 2);
	}
}
