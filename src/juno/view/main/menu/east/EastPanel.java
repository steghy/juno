package juno.view.main.menu.east;

import javax.swing.JPanel;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class EastPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* The EastPanel instance */
	private static EastPanel instance;

	/* Builds EastPanel instance */
	private EastPanel() {}

	
	/**
	 * Returns the EastPanel instance
	 * @return The EastPanel instance
	 */
	public static EastPanel getInstance() {
		if(instance == null) {
			instance = new EastPanel();
		} return instance;
	}

	
	/* Initialize the EastPanel instance */
	public void init() {
		this.setOpaque(false);
	}
}