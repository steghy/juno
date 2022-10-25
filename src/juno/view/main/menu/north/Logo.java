package juno.view.main.menu.north;

import javax.swing.JLabel;

import juno.view.abstraction.AbstractLabel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Logo extends AbstractLabel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The Logo instance */
	private static Logo instance;

	
	/* Builds the Logo instance */
	private Logo() {
		init();
	}

	/**
	 * Returns the Logo instance
	 * @return The Logo instance
	 */
	public static Logo getInstance() {
		if(instance == null) {
			instance = new Logo();
		} return instance;
	}

	
	/* Initialize the Logo instance */
	private void init() {
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setOpaque(false);
	}
}