package juno.view.audio.north;

import javax.swing.JButton;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PreviousButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The PreviouButton instance */
	private static PreviousButton instance;

	
	/* Builds the PreviousButton instance */
	private PreviousButton() {}

	
	/**
	 * Returns the PreviousButton instance 
	 * @return The PreviousButton instance
	 */
	public static PreviousButton getInstance() {
		if(instance == null) {
			instance = new PreviousButton();
		} return instance;
	}
}