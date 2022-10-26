package juno.view.menu.west;

import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class WestPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* The SouthPanel instance */
	private static WestPanel instance;


	/* Builds SouthPath instance */
	private WestPanel() {
		init();
	}

	
	/**
	 * Returns the SouthPanel instance
	 * @return The SouthPanel instance
	 */
	public static WestPanel getInstance() {
		if(instance == null) {
			instance = new WestPanel();
		} return instance;
	}
	
	
	/* Initialize the SouthPanel instance */
	private void init() {
		this.setOpaque(false);
	}
}