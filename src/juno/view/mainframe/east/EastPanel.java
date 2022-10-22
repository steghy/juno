package juno.view.mainframe.east;

import java.awt.Dimension;

import javax.swing.JPanel;

public class EastPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;

	/* Default dimension */
	private final Dimension DEF_DIMENSION = new Dimension(200, 900);
	
	/* Minimun dimension */
	private final Dimension MIN_DIMENSION = new Dimension(0, 0); 

	/* Minimun dimension */
	private final Dimension MAX_DIMENSION = new Dimension(0, 0); 
	
	
	/* The SouthPanel instance */
	private static EastPanel instance;


	/* Builds SouthPath instance */
	private EastPanel() {
		init();
	}

	
	/**
	 * Returns the SouthPanel instance
	 * @return The SouthPanel instance
	 */
	public static EastPanel getInstance() {
		if(instance == null) {
			instance = new EastPanel();
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
