package juno.view.menu.south;

import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SouthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	
	/* The SouthPanel instance */
	private static SouthPanel instance;


	/* Builds SouthPath instance */
	private SouthPanel() {
		init();
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
	
	
	/* Initialize the SouthPanel instance */
	public void init() {
		// Opaque
		this.setOpaque(false);
	}
}