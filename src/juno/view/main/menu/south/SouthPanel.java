package juno.view.main.menu.south;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * South Panel class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class SouthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Default dimension */
	private final Dimension DEF_DIMENSION = new Dimension(800, 100);
	
	/* Minimun dimension */
	private final Dimension MIN_DIMENSION = new Dimension(0, 0); 

	/* Minimun dimension */
	private final Dimension MAX_DIMENSION = new Dimension(0, 0); 
	
	
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
	private void init() {
		// Dimension
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
		
		// Opaque
		this.setOpaque(false);
	}
}
