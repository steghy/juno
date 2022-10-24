package juno.view.audio.north;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class NextButton extends JButton {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The panel */
	private JPanel panel;
	
	/* The NextButton instance */
	private static NextButton instance;

	
	/* Builds the NextButton instance */
	private NextButton() {}
	
	/**
	 * Returns the NextButton instance 
	 * @return The NextButton instance
	 */
	public static NextButton getInstance() {
		if(instance == null) {
			instance = new NextButton();
		} return instance;
	}
	
	
	public void setIcon(Icon icon) {
		
	}
}