package juno.view.single.player;

import javax.swing.JPanel;

/**
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SinglePlayerMenu extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The SPlayerPanel instance */
	private static SinglePlayerMenu instance;

	
	/**
	 * Returns the SinglePlayerMenu instance
	 * @return The SinglePlayerMenu instance
	 */
	public static SinglePlayerMenu getInstance() {
		if(instance == null) {
			instance = new SinglePlayerMenu();
		} return instance;
	}

	
	/** Initialize the SinglePlayerMenu instance */
	public void init() {}
}