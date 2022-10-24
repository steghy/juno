package juno.view.audio.south;

import javax.swing.JLabel;
import javax.swing.JPanel;

import juno.view.exception.JLabelNotSettedException;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SouthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The background */
	private JLabel background;

	/* SouthPanel instance */
	private static SouthPanel instance;
	
	
	/* Builds the SouthPanel instance */
	private SouthPanel() {}

	
	/**
	 * Returns the SouthPanel instance 
	 * @return The SouthPanel instance
	 */
	public static SouthPanel getInstance() {
		if(instance == null) {
			instance = new SouthPanel();
		} return instance;
	}
	
	
	/**
	 * Sets the background of this instance
	 * @param label A JLabel object
	 */
	public void setBackground(JLabel label) {
		background = label;
	}
	
	
	/**
	 * Initialize the SouthPanel instance
	 * @throws JLabelNotSettedException if the required
	 * 			label obejct is not setted
	 */
	public void init() throws JLabelNotSettedException {
		
		// CHECK INTEGRITY
		if(background == null) {
			throw new JLabelNotSettedException();
		}
		
		this.add(background);
		
		this.setOpaque(false);
	}
}