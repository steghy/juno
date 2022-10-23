package juno.view.card;

import javax.swing.JButton;

/**
 * Cover class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardCover extends JButton {
	
	private static final long serialVersionUID = 1L;

	/* The instance */
	private static CardCover instance;

	
	/* Builds the cover object */
	private CardCover() {
		init();
	}

	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static CardCover getInstance() {
		if(instance == null) {
			instance = new CardCover();
		} return instance;
	}
	
	
	/* Initialize the Cover object */
	private void init() {}
}