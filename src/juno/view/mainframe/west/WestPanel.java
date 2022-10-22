package juno.view.mainframe.west;

import java.awt.Dimension;

import javax.swing.JPanel;

public class WestPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Default dimension */
	private final Dimension DEF_DIMENSION = new Dimension(200, 900);
	
	/* Minimun dimension */
	private final Dimension MIN_DIMENSION = new Dimension(0, 0); 

	/* Minimun dimension */
	private final Dimension MAX_DIMENSION = new Dimension(0, 0); 
	
	
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
		// Dimension
		this.setSize(DEF_DIMENSION);
		this.setMinimumSize(MIN_DIMENSION);
		this.setMaximumSize(MAX_DIMENSION);
		
		// Opaque
		this.setOpaque(false);
	}
}
