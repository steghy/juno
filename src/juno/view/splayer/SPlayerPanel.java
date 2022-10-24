package juno.view.splayer;

import javax.swing.JPanel;

import juno.view.factories.AbstractSPlayerFactory;

/**
 * Single Player panel for the Juno videogame
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SPlayerPanel extends JPanel implements AbstractSPlayerFactory {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* The SPlayerPanel instance */
	private static SPlayerPanel instance;

	/**
	 * Returns the SPlayerPanel instance
	 * @return The SPlayerPanel instance
	 */
	private static SPlayerPanel getInstance() {
		if(instance == null) {
			instance = new SPlayerPanel();
		} return instance;
	}

	@Override
	public JPanel getSPlayerPanel() {
		return getInstance();
	}
	
	
	/* Initialize the SPlayerPanel instance */
	public void init() {
		
	}

}
