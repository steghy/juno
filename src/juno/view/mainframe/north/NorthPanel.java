package juno.view.mainframe.north;

import java.awt.Dimension;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {

	/* Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/* Default Dimension */
	private Dimension DEF_DIMENSION = new Dimension();
	
	/* Minimun Dimension */
	private Dimension MIN_DIMENSION = new Dimension();
	
	/* Maximun Dimension */
	private Dimension MAX_DIMENSION = new Dimension();
	
	/* The NorthPanel instance */
	private static NorthPanel instance;
	
	
	/* Builds the NorthPanel instance */
	private NorthPanel() {
		init();
	}
	
	
	/**
	 * Returns the NorthPanel instance
	 * @return The NorthPanel instance
	 */
	public static NorthPanel getInstance() {
		if(instance == null) {
			instance = new NorthPanel();
		} return instance;
	}

	
	/* Initialize the NorthPanel instance */
	private void init() {
		this.setLayout(null);

		// Logo
		Logo logo = Logo.getInstance();
		this.add(logo);

		// Dimension settings
		// this.setPreferredSize(DEF_DIMENSION);
		// this.setSize(DEF_DIMENSION);
		// this.setMinimumSize(MIN_DIMENSION);
		// this.setMaximumSize(MAX_DIMENSION);
	}
}
