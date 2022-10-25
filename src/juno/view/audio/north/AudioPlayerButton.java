package juno.view.audio.north;

import javax.swing.JPanel;

import juno.view.abstraction.AbstractButton;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class AudioPlayerButton extends AbstractButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Builds an empty AudioPlayerButton
	 */
	public AudioPlayerButton() {
		super.init();
	}
	
	
	/**
	 * Builds an AudioPlayerButton with the 
	 * specified JButton object
	 * @param panel A JPanel object
	 */
	public AudioPlayerButton(JPanel panel) {
		super.setPanel(panel);
		super.init();
	}

}	