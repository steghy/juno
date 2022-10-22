package juno.view.player;

import java.awt.Dimension;
import java.awt.GridLayout;

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
	
	private final Dimension DEF_DIMENSION = new Dimension();
	
	/* Preferred Dimension */
	private final Dimension PRF_DIMENSION = new Dimension();
	
	/* Minimun Dimension */
	private final Dimension MIN_DIMENSION = new Dimension();
	
	/* Maximun Dimension */
	private final Dimension MAX_DIMENSION = new Dimension();

	private static AudioPlayerPanel instance;
	
	/* 'next' AudioPlayer button */
	private JButton nextButton;
	
	/* 'previous' AudioPlayer button */
	private JButton previousButton;
	
	/* 'stop' AudioPlayer button */
	private JButton stopButton;
	
	/* Builds AudioPlayerPanel instance */
	private AudioPlayerPanel() {
		init();
	}
	
	public static AudioPlayerPanel getInstance() {
		if(instance == null) {
			instance = new AudioPlayerPanel();
		} return instance;
	}
	
	
	/* Initialize the AudioPlayerPanel button */
	private void init() {

		// Buttons settings
		this.nextButton = NextButton.getInstance();
		this.previousButton = NextButton.getInstance();
		this.stopButton = NextButton.getInstance();

		// Layout
		this.setLayout(new GridLayout(1, 3));
		this.add(this.previousButton);
		this.add(this.stopButton);
		this.add(this.nextButton);

		// Dimension settings
		this.setPreferredSize(PRF_DIMENSION);
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
	}
}
