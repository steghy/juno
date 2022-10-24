package juno.view.audio.north;

import javax.swing.JButton;

/**
 * ToggleSwitch class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class ToggleSwitch extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The ToggleSwitch instance */
	private static ToggleSwitch instance;

	
	/* Builds the ToggleSwitch instance */
	private ToggleSwitch() {}

	
	/**
	 * Returns the ToggleSwitch instance 
	 * @return The ToggleSwitch instance
	 */
	public static ToggleSwitch getInstance() {
		if(instance == null) {
			instance = new ToggleSwitch();
		} return instance;
	}
}