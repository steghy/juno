package juno.view.audio.south;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import juno.view.exception.JLabelNotSetException;

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
	private SouthPanel() {
		
		// DIMENSION
		this.setSize(new Dimension(210, 40));
		this.setPreferredSize(new Dimension(210, 40));
		this.setMinimumSize(new Dimension(210, 40));
		this.setMaximumSize(new Dimension(210, 40));

	}

	
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
	 * @throws JLabelNotSetException if the required
	 * 			label obejct is not setted
	 */
	public void init() throws JLabelNotSetException {
		
		// CHECK INTEGRITY
		if(background == null) {
			throw new JLabelNotSetException(""
					+ "JLabel background isn't setted");
		}
		
		// ADD COMPONENTS
		this.add(background);
		this.setOpaque(false);
	}
}